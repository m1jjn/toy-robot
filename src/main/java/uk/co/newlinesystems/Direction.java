package uk.co.newlinesystems;

import java.util.EnumMap;
import java.util.Map;

/**
 * Direction that the robot is facing
 * @author Jim Nicholson
 *
 */
public enum Direction {
	NORTH, EAST, SOUTH, WEST;

	private static final Map<Direction, Direction> LEFT_TURN = new EnumMap<>(Direction.class);
	private static final Map<Direction, Direction> RIGHT_TURN = new EnumMap<>(Direction.class);
	
	static {
		LEFT_TURN.put(NORTH, WEST);
		LEFT_TURN.put(WEST, SOUTH);
		LEFT_TURN.put(SOUTH, EAST);
		LEFT_TURN.put(EAST, NORTH);

		RIGHT_TURN.put(NORTH, EAST);
		RIGHT_TURN.put(EAST, SOUTH);
		RIGHT_TURN.put(SOUTH, WEST);
		RIGHT_TURN.put(WEST, NORTH);
	}
	
	/**
	 * Return the direction that the robot would be facing if it were to turn left from its current direction.
	 * @return the new direction.
	 */
	public Direction turnLeft() {
		return LEFT_TURN.get(this);
	}
	
	/**
	 * Return the direction that the robot would be facing if it were to turn right from its current direction.
	 * @return the new direction.
	 */
	public Direction turnRight() {
		return RIGHT_TURN.get(this);
	}
} 
