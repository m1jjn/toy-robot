package uk.co.newlinesystems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DirectionTest {

	@Test
	void testTurnLeft() {
		assertEquals(Direction.WEST, Direction.NORTH.turnLeft());
		assertEquals(Direction.NORTH, Direction.EAST.turnLeft());
		assertEquals(Direction.EAST, Direction.SOUTH.turnLeft());
		assertEquals(Direction.SOUTH, Direction.WEST.turnLeft());
	}

	@Test
	void testTurnRight() {
		assertEquals(Direction.EAST, Direction.NORTH.turnRight());
		assertEquals(Direction.SOUTH, Direction.EAST.turnRight());
		assertEquals(Direction.WEST, Direction.SOUTH.turnRight());
		assertEquals(Direction.NORTH, Direction.WEST.turnRight());
	}

}
