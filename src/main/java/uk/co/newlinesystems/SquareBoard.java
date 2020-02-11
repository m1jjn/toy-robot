/**
 * 
 */
package uk.co.newlinesystems;

/**
 * Implementation of Board that is square and contiguous
 * @author Jim Nicholson
 *
 */
public class SquareBoard implements Board {

	private final int size;
	
	/**
	 * Constructor.
	 * Size of board in x & y directions
	 */
	public SquareBoard(int size) {
		this.size = size;
	}

	/**
	 * Could the robot stand at the specified location?
	 * @param location the location to check.
	 * @return whether the specified location is valid.
	 */
	public boolean canStandAt(Location location) {
		return (0 <= location.getX() &&
				location.getX() < size &&
				0 <= location.getY() &&
				location.getY() < size);
	}

}
