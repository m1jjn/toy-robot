package uk.co.newlinesystems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class AppTest {

	private static String lineSeparator = System.getProperty("line.separator");
	@Test
	void testRun() {
		InputStream inputStream = this.getClass().getResourceAsStream("/sample_input.txt");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		App app = new App(new Robot(new SquareBoard(5)));
		app.run(inputStream, printStream);
		String output = outputStream.toString();
		assertEquals("Enter command" + lineSeparator
				+ "\t0,1,NORTH" + lineSeparator
				+ "\t0,0,WEST" + lineSeparator
				+ "\t3,3,NORTH" + lineSeparator, output);
	}

}
