package lab1;

/**
 * Comparator interface that can be passed to a sort algorithm to sort based on
 * x and y coordinates.
 *
 * This interface has two implementations:
 * - XComparator: compares the points based on x coordinates
 * - YComparator: compares the points based on y coordinates
 */
interface Comparator {
	/**
	 * @param XYPoint first point to compare
	 * @param XYPoint second point to compare
	 * @return boolean, true if the first point precedes the second point
	 */
    public boolean comp(XYPoint p1, XYPoint p2);
}
