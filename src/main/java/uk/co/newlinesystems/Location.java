package uk.co.newlinesystems;

/**
 * A place on the board
 * @author Jim Nicholson
 *
 */
public class Location {
	private final int x;
	private final int y;
	
	/**
	 * Constructor
	 * @param x x position
	 * @param y y position
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * X position for testing
	 * @return
	 */
	protected int getX() {
		return x;
	}

	/**
	 * Y position for testing
	 * @return
	 */
	protected int getY() {
		return y;
	}
	
	/**
	 * Returns a new location in the specified direction
	 * @param direction the direction to move to
	 * @return a new location
	 */
	public Location getNext(Direction direction) {
		switch(direction) {
		case NORTH:
			return new Location(x, y + 1);
		case SOUTH:
			return new Location(x, y - 1);
		case EAST:
			return new Location(x + 1, y);
		default:
			return new Location(x - 1, y);
		}
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

}
