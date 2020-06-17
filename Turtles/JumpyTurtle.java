import Turtle.*;

/**
 * Jumpy turtle is a smart and faltering tortoise: 
 * as it progresses he goes on and off, the result is that when the tail is lowered it leaves a dashed line.
 * @author Daniel and Olga
 */
public class JumpyTurtle extends SmartTurtle {
	
	//down = true
	//up = false
	boolean tail_mode; 
	
	/**
	 * JumpyTurtle
	 * JumpyTurtle constructor.
	 */
	public JumpyTurtle() {
	}
	
	/**
	 * tailDown
	 * set the turtle tail down (override).
	 */
	public void tailDown () {
		tail_mode = true;
		super.tailDown();
	}
	
	/**
	 * tailUp
	 * set the turtle tail up (override).
	 */
	public void tailUp  () {
		tail_mode = false;
		super.tailUp();
	}
	
	/**
	 * moveForward
	 * he goes on and off, the result is that when the tail is lowered it leaves a dashed line (override).
	 * @param distance - the distance
	 */
	public void moveForward (double distance) {
		
		//if the tail is lowered it leaves a dashed line
		if (tail_mode) {
			
			//skips (tail up and down) of distances of 10
			for (int i=0; i<distance; i=i+20) {
				super.moveForward(10);
				tailUp();
				super.moveForward(10);
				tailDown();
			}
			
		//if the tail is up he move forward without leaving trails
		} else {
			super.moveForward(distance);
		}
	}
	
	/**
	 * drawSquare
	 * Draw a square in the given size (override).
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
			moveForward(size);
			super.turnRight(90);
		}

		//paint the last side
		moveForward(size);
	}

	/**
	 * drawPolygon
	 * draw a polygon in the given sides and size (override).
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
			moveForward(size); //draw the side
			super.turnRight(degrees); //head toward the next side
			sides--;
		}
		
		//paint the last side
		moveForward(size);
	}
}
