package uk.co.newlinesystems;

public interface Board {
	/**
	 * Returns whether the robot is allowed to move to the specified location.
	 * @param location the location to check.
	 * @return true if the robot is allowed to move to the square, false otherwise.
	 */
	boolean canStandAt(Location location);
}
