import Turtle.*;

/**
 * A drunken turtle is a regular tortoise that has slightly drunk 
 * and as a result it is a little difficult for him to go.
 * @author Daniel and Olga
 */
public class DrunkTurtle extends SimpleTurtle {
	
	/**
	 * DrunkTurtle
	 * DrunkTurtle constructor
	 */
	public DrunkTurtle() {
	}
	
	/**
	 * moveForward
	 * move forward to a random distance between 0 and x 
	 * and turn at a random angle between 30 and 30 degrees (override).
	 * @param distance - the distance
	 */
	public void moveForward (double distance) {
		
		double random_distance = Math.random()*2*distance; //random distance lottery
		int random_degrees = (int) ((Math.random()*60) -30); //Random degrees lottery
		
		//for positive degrees the turtle turns left
		if (random_degrees > 0) {
			super.turnLeft(random_degrees);
			
		//for negative degrees the turtle turns right
		} else {
			super.turnRight(random_degrees);
		}
		
		//by the saved word 'super' we call to 'moveForward' function in 'SimpleTurtle' class from that we inherit her
		super.moveForward(random_distance);
	}
	
	/**
	 * moveBackward
	 * move back to a random distance between 0 and x 
	 * and turn at a random angle between 30 and 30 degrees (override).
	 * @param distance - the distance
	 */
	public void moveBackward (double distance) {
		
		double random_distance = Math.random()*2*distance; //random distance lottery
		int random_degrees = (int) ((Math.random()*60) -30); //Random degrees lottery
		
		//for positive degrees the turtle turns left
		if (random_degrees > 0) {
			super.turnLeft(random_degrees);
			
		//for negative degrees the turtle turns right
		} else {
			super.turnRight(random_degrees);
		}
		
		//by the saved word 'super' we call to 'moveBackward' function in 'SimpleTurtle' class from that we inherit her
		super.moveBackward(random_distance);
	}
}
