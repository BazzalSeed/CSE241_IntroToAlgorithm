package lab1;

import java.awt.*;

/**
 * Definition for the XYPoint class
 *
 * The variable counter is a static integer that keeps track of the number of
 * point objects.  Each point has an x coordinate, a y coordinate, and a
 * globally unique value num (for convenience in debugging).
 */
public class XYPoint {
    static int counter = 0;

    // X coordinate.
    public int x;
    // Y coordinate.
    public int y;
    // Color for display purposes.
    public Color color;
    // Unique identifier for isLeftOf() and isBelow()
    int num;

    public XYPoint() {
	   x = 0;
	   y = 0;
       color = Color.black;
	   num = counter++;
    }

    public XYPoint(int xcoord, int ycoord) {  
    	x = xcoord;
    	y = ycoord;
        color = Color.black;
    	num = counter++;
    }
   
    /**
     * Computes the euclidean distance.
     */
    public double dist(XYPoint other) {
	   double deltax = x - other.x;    
	   double deltay = y - other.y;                
	   return Math.sqrt(deltax*deltax + deltay*deltay);   
    }

    public boolean isLeftOf(XYPoint other) {
	   return (x < other.x || (x == other.x && num < other.num));
    }
    
    public boolean isBelow(XYPoint other) {
	   return (y < other.y || (y == other.y && num < other.num));
    }

    public String toString() {
	   return ("(" + x + "," + y + ")");
    }
}
