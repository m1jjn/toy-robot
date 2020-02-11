# toy-robot
Toy Robot Simulator by Jim Nicholson

## Design
The project is built using Maven and comprises the following classes:

* `App` - The main program instantiates a board and a robot and provides a loop for user 
  interaction.
* `Board` - An interface for a board that the robot can move around on.
* `Direction` - An enumeration of all the different directions that a robot can move on 
  the board
* `Location` - a location on the board
* `Robot` - the robot, it knows its location and direction and how to move.  This contains 
  the "business rules" of placing the robot and moving it
* `SquareBoard` - an implementation of the Board interface that represents a square grid

The `Robot` is dependency injected with an instance of the `Board`, this allows the robot 
to be used on different sized boards or those with obstacles on without any modification by 
providing a new board implementation. It also allows for mocking of the Board.

The `App` takes its input from `System.in`, so can be driven from a text file or pipe via 
operating system redirection

Where possible classes are immutable to simplify testing and reasoning about the code.

## Building the project

Clone the project, cd into the directory containing the pom.xml and execute the command:

```
mvn install
```

This will create a target directory and generate a jar file in it called
`toy-robot-1.0-SNAPSHOT-jar-with-dependencies.jar`

## Executing the project:

From the directory containing the pom.xml execute the following command:

```
java -jar target/toy-robot-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Testing the project

The project contains unit tests that are executed as part of the build process.

An integration test can be performed by

```
java -jar target\toy-robot-1.0-SNAPSHOT-jar-with-dependencies.jar < src\test\resources\sample_input.txt
```

Which should produce the following output:

```
Enter command
        0,1,NORTH
        0,0,WEST
        3,3,NORTH
```

## Scope for improvement

Location could be put behind an interface so that for instance a 3D board and location 
could be used with extra commands to move in 3 dimensions.