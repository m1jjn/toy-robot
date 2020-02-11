package uk.co.newlinesystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquareBoardTest {

	@Test
	void testCanStandAtTrue() {
		final Board board = new SquareBoard(3);
		assertTrue(board.canStandAt(new Location(0, 0)));
		assertTrue(board.canStandAt(new Location(1, 0)));
		assertTrue(board.canStandAt(new Location(2, 0)));
		assertTrue(board.canStandAt(new Location(0, 1)));
		assertTrue(board.canStandAt(new Location(1, 1)));
		assertTrue(board.canStandAt(new Location(2, 1)));
		assertTrue(board.canStandAt(new Location(0, 2)));
		assertTrue(board.canStandAt(new Location(1, 2)));
		assertTrue(board.canStandAt(new Location(2, 2)));
	}

	@Test
	void testCanStandAtFalse() {
		final Board board = new SquareBoard(3);
		assertFalse(board.canStandAt(new Location(0, -1)));
		assertFalse(board.canStandAt(new Location(-1, 0)));
		assertFalse(board.canStandAt(new Location(0, 3)));
		assertFalse(board.canStandAt(new Location(3, 0)));
	}

}
