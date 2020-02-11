package uk.co.newlinesystems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RobotTest {

	@Mock
	private Board board;
	
	private Robot robot;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		robot = new Robot(board);
	}

	@Test
	void testPlaceValid() {
		when(board.canStandAt(any())).thenReturn(true);
		assertFalse(robot.isPlaced());
		assertNull(robot.getLocation());
		assertNull(robot.getFacing());

		robot.place(1, 2, "NORTH");
		
		assertTrue(robot.isPlaced());
		assertEquals("1,2,NORTH", robot.report());
		assertEquals(1, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY());
		assertEquals(Direction.NORTH, robot.getFacing());
	}

	@Test
	void testPlaceInvalid() {
		when(board.canStandAt(any())).thenReturn(false);
		assertFalse(robot.isPlaced());
		
		robot.place(0, 0, "NORTH");
		
		assertFalse(robot.isPlaced());
		assertNull(robot.getLocation());
		assertNull(robot.getFacing());
	}

	@Test
	void testMoveUnplaced() {
		when(board.canStandAt(any())).thenReturn(false);
		assertFalse(robot.isPlaced());
		assertNull(robot.getLocation());
		assertNull(robot.getFacing());

		robot.place(1, 2, "NORTH");
		robot.turnLeft();
		robot.move();
		assertFalse(robot.isPlaced());
		assertNull(robot.getLocation());
		assertNull(robot.getFacing());
	}

	@Test
	void testTurnLeft() {
		when(board.canStandAt(any())).thenReturn(true);
		assertFalse(robot.isPlaced());
		assertNull(robot.getLocation());
		assertNull(robot.getFacing());

		robot.place(1, 2, "NORTH");
		robot.turnLeft();
		robot.move();
		assertTrue(robot.isPlaced());
		assertEquals("0,2,WEST", robot.report());
		assertEquals(0, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY());
		assertEquals(Direction.WEST, robot.getFacing());
	}

	@Test
	void testTurnRight() {
		when(board.canStandAt(any())).thenReturn(true);
		assertFalse(robot.isPlaced());
		assertNull(robot.getLocation());
		assertNull(robot.getFacing());

		robot.place(1, 2, "NORTH");
		robot.turnRight();
		robot.move();
		assertTrue(robot.isPlaced());
		assertEquals("2,2,EAST", robot.report());
		assertEquals(2, robot.getLocation().getX());
		assertEquals(2, robot.getLocation().getY());
		assertEquals(Direction.EAST, robot.getFacing());
	}

}
