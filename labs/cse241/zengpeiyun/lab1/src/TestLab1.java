package lab1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestLab1 {

    private static XComparator lessThanX = new XComparator();
    private static YComparator lessThanY = new YComparator();

	@Test
	public void testTenPointSort() {
        XYPoint[] tenPoints = new XYPoint[10];
        tenPoints[0] = new XYPoint(0, 0);
        tenPoints[1] = new XYPoint(-1, 50);
        tenPoints[2] = new XYPoint(-4, -5);
        tenPoints[3] = new XYPoint(7, 20);
        tenPoints[4] = new XYPoint(100, -4);
        tenPoints[5] = new XYPoint(-87, 46);
        tenPoints[6] = new XYPoint(76, 33);
        tenPoints[7] = new XYPoint(-78, -27);
        tenPoints[8] = new XYPoint(90, 83);
        tenPoints[9] = new XYPoint(-89, 12);

        XYPoint tenPointsByX[] = new XYPoint[10];
        XYPoint tenPointsByXExpected[] = new XYPoint[10];
        XYPoint tenPointsByY[] = new XYPoint[10];
        XYPoint tenPointsByYExpected[] = new XYPoint[10];
        for (int j = 0; j < tenPoints.length; j++) {
            tenPointsByX[j] = tenPoints[j];
            tenPointsByXExpected[j] = tenPoints[j];
            tenPointsByY[j] = tenPoints[j];
            tenPointsByYExpected[j] = tenPoints[j];
        }
        // Assume that number doesn't come into play for our basic test case.
        Arrays.sort(tenPointsByXExpected, new java.util.Comparator<XYPoint>() {
            @Override
            public int compare(XYPoint p1, XYPoint p2) {
                return p1.x - p2.x;
            }
        });
        Arrays.sort(tenPointsByYExpected, new java.util.Comparator<XYPoint>() {
            @Override
            public int compare(XYPoint p1, XYPoint p2) {
                return p1.y - p2.y;
            }
        });
		long startTime = System.currentTimeMillis();
        Sort.msort(tenPointsByX, lessThanX);
        Sort.msort(tenPointsByY, lessThanY);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		assertArrayEquals(tenPointsByXExpected, tenPointsByX);
        assertArrayEquals(tenPointsByYExpected, tenPointsByY);
		System.out.println("Sorting 10 points took " + duration + "ms to run.");
	}

    @Test
    public void testSamePointSort() {
        XYPoint p1 = new XYPoint(0, 0);
        XYPoint p2 = new XYPoint(0, 0);
        XYPoint[] points = new XYPoint[2];
        points[0] = p2;
        points[1] = p1;
        Sort.msort(points, lessThanX);
        assertEquals(p1, points[0]);
        assertEquals(p2, points[1]);
    }

    @Test
    public void testRandomizedSort() {
        XYPoint[] points = Lab1.genPointsAtRandom(10000, new Random());
        XYPoint pointsByX[] = new XYPoint[10000];
        XYPoint pointsByXExpected[] = new XYPoint[10000];
        XYPoint pointsByY[] = new XYPoint[10000];
        XYPoint pointsByYExpected[] = new XYPoint[10000];
        for (int j = 0; j < points.length; j++) {
            pointsByX[j] = points[j];
            pointsByXExpected[j] = points[j];
            pointsByY[j] = points[j];
            pointsByYExpected[j] = points[j];
        }
        Arrays.sort(pointsByXExpected, new java.util.Comparator<XYPoint>() {
            @Override
            public int compare(XYPoint p1, XYPoint p2) {
                if (p1.x == p2.x) {
                    return p1.num - p2.num;
                }
                return p1.x - p2.x;
            }
        });
        Arrays.sort(pointsByYExpected, new java.util.Comparator<XYPoint>() {
            @Override
            public int compare(XYPoint p1, XYPoint p2) {
                if (p1.y == p2.y) {
                    return p1.num - p2.num;
                }
                return p1.y - p2.y;
            }
        });
        long startTime = System.currentTimeMillis();
        Sort.msort(pointsByX, lessThanX);
        Sort.msort(pointsByY, lessThanY);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertArrayEquals(pointsByXExpected, pointsByX);
        assertArrayEquals(pointsByYExpected, pointsByY);
        System.out.println("Sorting 10,000 points took " + duration + "ms to run.");
    }

    @Test
    public void testTenPointClosestPair() {
        XYPoint[] tenPoints = new XYPoint[10];
        tenPoints[0] = new XYPoint(0, 0);
        tenPoints[1] = new XYPoint(-1, 50);
        tenPoints[2] = new XYPoint(-4, -5);
        tenPoints[3] = new XYPoint(7, 20);
        tenPoints[4] = new XYPoint(100, -4);
        tenPoints[5] = new XYPoint(-87, 46);
        tenPoints[6] = new XYPoint(76, 33);
        tenPoints[7] = new XYPoint(-78, -27);
        tenPoints[8] = new XYPoint(90, 83);
        tenPoints[9] = new XYPoint(-89, 12);

        XYPoint tenPointsByX[] = new XYPoint[10];
        XYPoint tenPointsByXExpected[] = new XYPoint[10];
        XYPoint tenPointsByY[] = new XYPoint[10];
        XYPoint tenPointsByYExpected[] = new XYPoint[10];
        for (int j = 0; j < tenPoints.length; j++) {
            tenPointsByX[j] = tenPoints[j];
            tenPointsByXExpected[j] = tenPoints[j];
            tenPointsByY[j] = tenPoints[j];
            tenPointsByYExpected[j] = tenPoints[j];
        }
        Sort.msort(tenPointsByX, lessThanX);
        Sort.msort(tenPointsByY, lessThanY);
        long startTime = System.currentTimeMillis();
        lab1.Result rMin = ClosestPair.findClosestPair(tenPointsByX, tenPointsByY);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertEquals(tenPoints[2].x, rMin.p1.x);
        assertEquals(tenPoints[2].y, rMin.p1.y);
        assertEquals(tenPoints[0].x, rMin.p2.x);
        assertEquals(tenPoints[0].y, rMin.p2.y);
        assertEquals(tenPoints[2].dist(tenPoints[0]), rMin.dist, .01);
        System.out.println("Finding the closest points for 10 points took " + duration
            + "ms to run.");
    }

    // USES A QUADRATIC TIME ALGORITHM THAT YOU HAVE IMPLEMENTED FIRST.
    // UNCOMMENT OUT THE LINES IF YOU WANT TO USE THIS METHOD.
    @Test
    public void testClosestPair() {
        XYPoint[] points = Lab1.genPointsAtRandom(10000, new Random());
        XYPoint pointsByX[] = new XYPoint[10000];
        XYPoint pointsByY[] = new XYPoint[10000];
        for (int j = 0; j < points.length; j++) {
            pointsByX[j] = points[j];
            pointsByY[j] = points[j];
        }
        Sort.msort(pointsByX, lessThanX);
        Sort.msort(pointsByY, lessThanY);
        // IF YOU WANT, IMPLEMENT A BRUTE FORCE CLOSEST PAIR TO TEST YOUR METHOD.
        // lab1.Result rMinExpect =
        //    ClosestPair.findClosestPairBruteForce(points)
        long startTime = System.currentTimeMillis();
        lab1.Result rMin = ClosestPair.findClosestPair(pointsByX, pointsByY);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        //assertEquals(rMinExpect.p1.x, rMin.p1.x);
        //assertEquals(rMinExpect.p1.y, rMin.p1.y);
        //assertEquals(rMinExpect.p2.x, rMin.p2.x);
        //assertEquals(rMinExpect.p2.y, rMin.p2.y);
        //assertEquals(rMinExpect.dist, rMin.dist, .01);
        System.out.println("Finding the closest points for 10,000 points took "
            + duration + "ms to run.");
    }

  	public static void main(String[] args) {
    	Result result = JUnitCore.runClasses(TestLab1.class);
    	System.out.println("---------------");
    	for (Failure failure : result.getFailures()) {
      		System.out.println(failure.toString());
      	}
      	if (result.getFailures().size() == 0) {
      		System.out.println("All tests passed!!");
      	} else {
            System.out.println("SOME TESTS FAILED :(");
        }
    }
}
