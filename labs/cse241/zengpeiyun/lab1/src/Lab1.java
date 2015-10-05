package lab1;

import java.util.Date;
import java.awt.*;

//=================================== Lab1 ===============================
//
// Input: n the number of points
//
// Output: A pair of closest points and their distance
//
//========================================================================
public class Lab1 {

    static XYPoint[] genPointsAtRandom(int nPoints, java.util.Random randseq) {
		XYPoint points[] = new XYPoint [nPoints];
		int x = 0;
		double y = 0.0;
		double step = Math.sqrt(nPoints);

		for (int j = 0; j < nPoints; j++)  {
			// jitter next point's X coordinate
			x = Math.abs(randseq.nextInt(nPoints*10));

			// move the Y coordinate a random amount up,
			// while keeping it within limits [0 .. nPoints)
			y = (y + step * (randseq.nextDouble() + 1)) % nPoints;

			points[j] = new XYPoint((int) Math.round(x), (int) Math.round(y));
	    }

		return points;
    }

    //================================ main ===============================
    //
    // You can use command line arguments to have the output and/or input
    // come from a file versus the command line.
    //
    // If there are two arguments then the first one is the file from where
    // the input is read and the second is the file where a transcript is
    // saved.
    //
    // If there is just one argument then it is the file where a transcript
    // is saved.
    public static void main(String args[]) {
		XYPoint points [];

		if (args.length >= 1) {
	    	Terminal.startTranscript(args[0]);
	    }
	    if (args.length >= 2) {
	    	// Read points from file
			points = PointReader.readXYPoints(args[1]);
	    } else {
			// You can change "" to something else when testing,
			// but it MUST  be "3861" for your submitted output!

			java.util.Random randseq = new java.util.Random(3861);

			// Use this line if you want a different random set of
			// points for each run.  This code uses the system
			// clock as the seed to the random number generator.
			//
			// java.util.Random randseq = new java.util.Random();

			Terminal.println("How many points? ");

			int nPoints = Terminal.readInt();

			points = genPointsAtRandom(nPoints, randseq);
	    }

		XComparator lessThanX = new XComparator();
		YComparator lessThanY = new YComparator();

		Date startTime = new Date();

		//////////////////////////////////////////////////////////////////////
		// CLOSEST-PAIR ALGORITHM STARTS HERE	

		// The algorithm expects two arrays containing the same points.
		XYPoint pointsByX [] = new XYPoint [points.length];
		XYPoint pointsByY [] = new XYPoint [points.length];
		for (int j = 0; j < points.length; j++) {
			pointsByX[j] = points[j];
			pointsByY[j] = points[j];
	    }

		// Ensure sorting precondition for divide-and-conquer CP algorithm.
		// You should *not* have to call msort() in your own code!
		Sort.msort(pointsByX, lessThanX); // sort by x-coord
		Sort.msort(pointsByY, lessThanY); // sort by y-coord

		Result rMin = ClosestPair.findClosestPair(pointsByX, pointsByY);
		rMin.print();

		// CLOSEST-PAIR ALGORITHM ENDS HERE
		//////////////////////////////////////////////////////////////////////
	

		Date endTime = new Date();
		long elapsedTime = endTime.getTime() - startTime.getTime();

		Terminal.println("For n = " + points.length + ", the elapsed time is "
			+ elapsedTime + " milliseconds.\n");
	
		// *** NOTE: for your submitted output for Part Two, you MUST print 
		// *** the closest pair of points and the distance between them!
	
		//////////////////////////////////////////////////////////////////////
		// THE FOLLOWING LINES DEMONSTRATE HOW TO USE THE PROVIDED
		// PLOTTER ROUTINE.  Uncomment them as you wish for debugging
		// purposes, or use them in your closest pair code to inspect
		// the point arrays at any time.  For example, you could color
		// all points in the left half red and all points in the right
		// half blue and then visually check that you divided them
		// properly by calling the plotter before you recurse.  Note
		// that if you make several calls, all the plots will
		// initially be on top of each other -- just move them so you
		// can see everything.
		//
		
		// Here the points are plotted and labelled by X-coordinate
		
		// new Plotter(pointsByY, true, "Sorted by X-coordinate");
		
		// Here the points are plotted and labelled by Y-coordinate
		
		//new Plotter(pointsByY, true, "Sorted by Y-coordinate");
		
		// Here's a call to the plot routine in which the points
		// aren't labeled. A nice thing to do at this point (if you
		// computed the two closest points) would be to color the two
		// closest points a different color For a XYPoint p, you could
		// color p (say red) with the line: 
		//
		// p.color = Color.red;
		
		// new Plotter(pointsByX, true, "Output");
    }
    
    //============================ makeInt ================================
    //
    // Converts a double between 0 and 1 to an integer between lo and hi
    //
    static int makeInt(double rand, int lo, int hi) {   
		return lo + ((int) Math.floor(rand * (hi + 1 - lo)));
    }
}
