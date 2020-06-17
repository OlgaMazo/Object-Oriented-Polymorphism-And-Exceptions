import Turtle.*;
import java.util.Scanner;

/**
 * This class represents a management of an army (array) of 5 turtles.
 * @author Daniel and Olga
 */
public class Army {
	
	SimpleTurtle[] arr; //this array will contains the turtles army
	
	/**
	 * Army
	 * Army constructor
	 */
	public Army() {
		arr = new SimpleTurtle[5]; //the army includes 5 turtles
		create_the_army();
		army_action();
	}
	
	/**
	 * create_the_army
	 * Create the turtle army according to the user's choice.
	 */
	private void create_the_army() {
		
		//print a message to the user to choose the composition of the army
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose the type of a turtle:\n\n"
				           + "1. Simple\n"
				           + "2. Smart\n"
				           + "3. Drunk \n"
				           + "4. Jumpy");
		
		//create the turtles according to the user's choice
		for (int i=0; i<5; i++) {
			
			//scan the input into type
			int type = scanner.nextInt();
			
			switch(type) {
			
			//if the input is '1' create simple turtle
			case 1:
				arr[i] = new SimpleTurtle();
				break;
				
			//if the input is '2' create smart turtle
			case 2:
				arr[i] = new SmartTurtle();
				break;
			
			//if the input is '3' create drunk turtle
			case 3:
				arr[i] = new DrunkTurtle();
				break;
				
			//if the input is '4' create jumpy turtle
			case 4:
				arr[i] = new JumpyTurtle();
				break;
			}
		}
	}
	
	/**
	 * army_action
	 * Promote the turtles army together according to defined stages
	 */
	private void army_action() {
		
		//the first step is to turn down the turtle tail
		for (int i=0; i<5; i++) {
			
			//if it is a jumpy turtle, call 'tailDown' function of 'JumpyTurtle' class (override)
			if (arr[i] instanceof JumpyTurtle) {
				((JumpyTurtle) arr[i]).tailDown();
			
			//otherwise, call 'tailDown' function of 'SimpleTurtle' class
			} else {
				arr[i].tailDown();
			}
		}
		
		//the second step is to move forward for a distance of 100
		for (int i=0; i<5; i++) {
		
			//if it is a drunk turtle, call 'moveForward' function of 'DrunkTurtle' class (override)
			if (arr[i] instanceof DrunkTurtle) {
				((DrunkTurtle) arr[i]).moveForward(100);
				
			//if it is a jumpy turtle, call 'moveForward' function of 'JumpyTurtle' class (override)
			}else if (arr[i] instanceof JumpyTurtle) {
				((JumpyTurtle) arr[i]).moveForward(100);
				
			//otherwise, call 'moveForward' function of 'SimpleTurtle' class
			} else {
				arr[i].moveForward(100);
			}
		}
		
		//the third stage is to turn right in 90 degree
		for (int i=0; i<5; i++) {
			
			//call 'turnRight' function of 'SimpleTurtle' class (there are no overrides for this function)
			arr[i].turnRight(90);
		}
		
		//the fourth step is to step forward for a distance of 60
		for (int i=0; i<5; i++) {
			
			//if it is a drunk turtle, call 'moveForward' function of 'DrunkTurtle' class (override)
			if (arr[i] instanceof DrunkTurtle) {
				((DrunkTurtle) arr[i]).moveForward(60);
				
			//if it is a jumpy turtle, call 'moveForward' function of 'JumpyTurtle' class (override)
			}else if (arr[i] instanceof JumpyTurtle) {
				((JumpyTurtle) arr[i]).moveForward(60);
				
			//otherwise, call 'moveForward' function of 'SimpleTurtle' class
			} else {
				arr[i].moveForward(60);
			}
		}
		
		//the fifth stage is for anyone who knows how to draw a polygon, drawing a 6-sided polygon of length 7
		for (int i=0; i<5; i++) {
			
			//if it is a smart turtle or jumpy turtle (he extend from the smart), 
			//call 'moveForward' function of 'JumpyTurtle' class (override)
			if (arr[i] instanceof SmartTurtle) {
				((SmartTurtle) arr[i]).drawPolygon(6, 70);
			}
		}
		
		//the sixth stage is disappearances
		for (int i=0; i<5; i++) {
			
			//call 'hide' function of 'SimpleTurtle' class (there are no overrides for this function)
			arr[i].hide();
		}
	}
}
