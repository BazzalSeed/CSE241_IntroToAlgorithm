package lab1;

import java.io.*;

/**
 * Read in a series of points from a file.
 *
 * The first line of the file gives the number of points, while each subsequent
 * line contains x and y coordinates for one point.
 */
public class PointReader {
    // Extract an integer from a string, which may contain whitespace
    static int parseInteger(String s) {
		int x = 0;
		try {
	    	x = Integer.parseInt(s.trim());
		} catch (NumberFormatException e) {
	    	System.out.println("Cannot parse integer from string \"" + s
	    		+ "\"\n" + e);
		}
		return x;
    }
    
    /**
     * Extract a pair of integers from a string, which may contain whitespace.
     * 
     * Treat the pair as x,y coordinates for a point.
     */
    static XYPoint parsePoint(String s) {
		int x, y;

		s = s.trim().replace('\t', ' ');
		int firstSpaceIdx = s.indexOf(' ');
		String sx = s.substring(0, firstSpaceIdx);
		String sy = s.substring(firstSpaceIdx).trim();

		x = parseInteger(sx);
		y = parseInteger(sy);

		return new XYPoint(x,y);
    }
    
    /**
     * Read in a collection of points from a file.
     */
    public static XYPoint [] readXYPoints(String fileName) {
        XYPoint points [] = null;
		BufferedReader r;
		int nPoints;

        // Create a reader for the file
        try {
            InputStream is = new FileInputStream(fileName);
            r = new BufferedReader(new InputStreamReader(is));
        } catch (IOException e) {
            System.out.println("IOException while opening " + fileName + "\n"
            	+ e);
            return points;
        }

		try {
		    String nextline = r.readLine();
		    if (nextline == null) {
		    	// End of file
			    System.out.println("Error: point file " + fileName
			    	+ " is empty!\n");
			    return points;
			}

		    nPoints = parseInteger(nextline);
		} catch (IOException e) {
	        System.out.println("IOException while getting # of points from "
	            + fileName + "\n" + e);
	        return points;
	    }
    

		points = new XYPoint [nPoints];

		for (int j = 0; j < nPoints; j++) {
			try {
			    String nextline = r.readLine();
			    if (nextline == null) {
			    	// End of file
				    System.out.println("Error: point file ends " + "after "
				    	+ j + " points\n" + " (expected " + nPoints + ")\n");
				    return points;
				}

			    points[j] = parsePoint(nextline);			    
			} catch (IOException e) {
			    System.out.println("IOException while reading line " + j
			    	+ " from " + fileName + "\n" + e);
			    return points;
			}
		}
		return points;
    }
}
