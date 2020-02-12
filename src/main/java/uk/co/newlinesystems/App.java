package uk.co.newlinesystems;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
	private static Pattern PLACE_PATTERN = Pattern.compile("PLACE\\s+(\\d+),(\\d+),(NORTH|SOUTH|EAST|WEST)");

	private Robot robot;

    public static void main( String[] args ) {
        App app = new App(new Robot(new SquareBoard(5)));
        app.run(System.in, System.out);
    }
	
	public App(Robot robot) {
		this.robot = robot;
	}
	
	public void run(InputStream inputStream, PrintStream outputStream) {
		try (final Scanner scanner = new Scanner(inputStream)) {
			outputStream.println("Enter command");
			while(scanner.hasNext()) {
				String command = scanner.nextLine().trim().toUpperCase();
				Matcher matcher = PLACE_PATTERN.matcher(command);
				if (matcher.matches()) {
					final int x = Integer.valueOf(matcher.group(1));
					final int y = Integer.valueOf(matcher.group(2));
					final String facing = matcher.group(3);
					robot.place(x, y, facing);
				} else if ("MOVE".equals(command)) {
					robot.move();
				} else if ("LEFT".equals(command)) {
					robot.turnLeft();
				} else if ("RIGHT".equals(command)) {
					robot.turnRight();
				} else if ("REPORT".equals(command)) {
					outputStream.println("\t"+robot.report());
				}
			}
		}
	}
}
