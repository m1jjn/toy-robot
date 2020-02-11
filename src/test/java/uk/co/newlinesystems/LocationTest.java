package uk.co.newlinesystems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LocationTest {

	@Test
	void testGetX() {
		final Location location = new Location(1, 4);
		assertEquals(1, location.getX());
	}

	@Test
	void testGetY() {
		final Location location = new Location(1, 4);
		assertEquals(4, location.getY());
	}

	@Test
	void testGetNextNorth() {
		final Location location = new Location(1, 4);
		Location next = location.getNext(Direction.NORTH);
		assertEquals(1, next.getX());
		assertEquals(5, next.getY());
	}

	@Test
	void testGetNextSouth() {
		final Location location = new Location(1, 4);
		Location next = location.getNext(Direction.SOUTH);
		assertEquals(1, next.getX());
		assertEquals(3, next.getY());
	}

	@Test
	void testGetNextWest() {
		final Location location = new Location(1, 4);
		Location next = location.getNext(Direction.WEST);
		assertEquals(0, next.getX());
		assertEquals(4, next.getY());
	}

	@Test
	void testGetNextEast() {
		final Location location = new Location(1, 4);
		Location next = location.getNext(Direction.EAST);
		assertEquals(2, next.getX());
		assertEquals(4, next.getY());
	}

	@Test
	void testToString() {
		final Location location = new Location(1, 4);
		assertEquals("1,4", location.toString());
	}

}
