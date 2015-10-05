package lab1;

import java.awt.*;
import java.awt.event.*;

public class Plotter extends Frame {
    static int count = 0;

    Font f = new Font("helvetica",Font.PLAIN,10);

    XYPoint[] p;
    double minX, minY, maxX, maxY;
    boolean numbered;
    String title;

    public Plotter(XYPoint[] p, boolean numbered, String title) {
    	super(title);
	
		this.p = p;
		if (p.length == 0) {
			return;
		}
	
		minX = p[0].x;
		maxX = p[0].x;
		minY = p[0].y;
		maxY = p[0].y;
		for (int i = 1; i < p.length; i++) {
			if (p[i].x < minX) {
			    minX = p[i].x;
			}
			if (p[i].x > maxX) {
			    maxX = p[i].x;
			}
			if (p[i].y < minY) {
			    minY = p[i].y;
			}
			if (p[i].y > maxY) {
			    maxY = p[i].y;
		    }
		}

		this.numbered = numbered;		
		this.title = title;
		setSize(400, 400);
		count++;
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			    if (--count == 0) {
					System.exit(0);
				}
			    e.getWindow().dispose();
			}
		});

		setVisible(true);
    }
    
    public void paint(Graphics g) {
		if (p != null) {
			g.setFont(f);

			int i = 0;
			while (i < p.length) {
				if (p[i] != null) {
					g.setColor(p[i].color);
					int width = getBounds().width - 50;
					int height = getBounds().height - 50;
					double scale = Math.min(width / (maxX - minX),
						height / (maxY - minY));
					int x = (int) (7 + (p[i].x - minX) * scale);
					int y = (int) (height + 35 - (p[i].y - minY) * scale);
					if (numbered) {
					    g.drawString(p[i].x + "," +p[i].y, x + 1, y - 1);
					}
					g.drawRect(x, y, 1, 1);
				}
				i++;
			}
		}
	}
}
