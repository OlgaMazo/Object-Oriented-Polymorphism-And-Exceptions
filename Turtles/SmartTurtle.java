import Turtle.*;

/**
 * A smart turtle, beyond being a regular tortoise for all intents and purposes, understands something too
 * in geometry, he can draw a square of a given length and a polygon with a number of sides in given length
 * @author Daniel and olga
 */
public class SmartTurtle extends SimpleTurtle {

	/**
	 * SmartTurtle
	 * SmartTurtle constructor.
	 */
	public SmartTurtle() {
	}

	/**
	 * drawSquare
	 * Draw a square in the given size.
	 * @param size - the side length
	 */
	public void drawSquare(double size) {
		
		//if the size is a negative number, throw an error
		if (size <= 0) {
			throw new RuntimeException("Errordaniel - invalid size");
		}

		//by the saved word 'super' we call to 'tailDown' function in 'SimpleTurtle' class from that we inherit her
		//take the turtle tail down so he will leave traces
		super.tailDown();

		//a square has 4 sides so the turtle should be rotated after 3 sides.
		for (int i = 0; i < 3; i++) {
			super.moveForward(size); //draw the side
			super.turnRight(90); //head toward the next side
		}

		//paint the last side
		super.moveForward(size);
	}

	/**
	 * drawPolygon
	 * draw a polygon in the given sides and size
	 * @param sides - the number of sides
	 * @param size - the side length
	 */
	public void drawPolygon(int sides, double size) {
		
		//if the sides is a negative number, throw an error
		if (sides <= 0) {
			throw new RuntimeException("Errordaniel - invalid sides");
		
		//if the size is a negative number, throw an error
		} else if (size <= 0) {
			throw new RuntimeException("Errordaniel - invalid size");
		}

		//by the saved word 'super' we call to 'tailDown' function in 'SimpleTurtle' class from that we inherit her
		//take the turtle tail down so he will leave traces
		super.tailDown();
		
		//calculate the degrees (total degrees in any form is 360)
		int degrees = 360/sides;
		
		//go into the loop as long as we have not reached the last side
		while (sides > 1) {
			super.moveForward(size); //draw the side
			super.turnRight(degrees); //head toward the next side
			sides--; 
		}
		
		//paint the last side
		super.moveForward(size);
	}
}
