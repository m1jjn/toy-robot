package uk.co.newlinesystems;

/**
 * A toy robot that moves over a board
 * @author Jim Nicholson
 *
 */
public class Robot {

	/**
	 * The board to move over
	 */
	private final Board board;
	
	/**
	 * The current position on the board
	 */
	private Location location;
	
	/**
	 * The direction that the robot is facing
	 */
	private Direction facing;
	
	/**
	 * Constructor
	 * @param board the board to move over
	 */
	public Robot(Board board) {
		this.board = board;
	}

	/**
	 * Place the robot on the board facing in a particulat direction
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param facing direction
	 */
	public void place(int x, int y, String facing) {
		final Location proposedLocation = new Location(x,y);
		if (board.canStandAt(proposedLocation)) {
			location = proposedLocation;
			this.facing = Direction.valueOf(facing);
		}
	}
	
	/**
	 * Turn the robot left without changing location
	 */
	public void turnLeft() {
		if (isPlaced()) {
			facing = facing.turnLeft();
		}
	}
	
	/**
	 * Turn the robot right without changing location
	 */
	public void turnRight() {
		if (isPlaced()) {
			facing = facing.turnRight();
		}
	}
	
	/**
	 * Move the robot one square without changing direction
	 */
	public void move() {
		if (isPlaced()) {
			final Location proposedLocation = location.getNext(facing);
			if (board.canStandAt(proposedLocation)) {
				location = proposedLocation;
			}
		}
	}
	
	/**
	 * Return robots location and direction
	 * @return location and direction
	 */
	public String report() {
		if (isPlaced()) {
			return location + "," + facing;
		}
		return "Robot not placed";
	}
	
	/**
	 * Whether the robot has been placed successfully on the board
	 * @return
	 */
	public boolean isPlaced() {
		return location != null;
	}
	
	/**
	 * current location for testing purposes
	 * @return current location
	 */
	protected Location getLocation() {
		return location;
	}
	
	/**
	 * current direction for testing purposes
	 * @return current direction
	 */
	protected Direction getFacing() {
		return facing;
	}
}
