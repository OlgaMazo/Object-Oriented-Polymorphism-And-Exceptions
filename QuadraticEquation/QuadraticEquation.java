import java.util.Scanner;
/**
 * In this class we can solve a quadratic equation
 * We have a option to let the user put a,b,c (for ax^2+bx+c=0) or to send the coefficients 
 * on our own
 * @author Olga and Daniel
 */

public class QuadraticEquation {
	
	/**
	 * solving_the_equation_manually
	 * this function accepts 3 entries from the user (a,b,c) 
	 * and send them to a function that calculate ax^2+bx+c=0
	 * if the user want to solve other equation - he need to tap 1, otherwise any other number 
	 * @throws SquareEquationException if there is no solution to the equation
	 */
	public static void solving_the_equation_manually() throws SquareEquationException {
		
		//with this variable we will know whether to continue the program or stop
		double ifContinue = 1;
		Scanner scanner = new Scanner(System.in);
		
		do{
			//absorption of variables for a,b,c
			System.out.println("aX^2+bX+c=0: Enter a,b,c:\nEnter a:\nEnter b:\nEnter c:");
			double a = scanner.nextDouble();
			double b = scanner.nextDouble();
			double c = scanner.nextDouble();
			
			try {
				
				//send the variables to function that calculate the equation
				solving_the_equation(a, b, c);
				
			}catch(SquareEquationException e) {
				e.printStackTrace();
			}

			
			System.out.println("Enter 0 or any number to Exit or 1 to solve aX^2+bX+c=0:");
			ifContinue = scanner.nextDouble();
		
			//if ifContinue=1 continue running the program
		}while(ifContinue == 1);
		
		System.out.println("Bye-bye!");
	}
	
	/**
	 * solving_the_equation
	 * solve the equation ax^2+bx+c=0 (for the a,b,c the function received)
	 * @param a - first variable
	 * @param b - second variable
	 * @param c - third variable
	 * @return - String presentation of the answer
	 * @throws SquareEquationException - if there is no solution to the equation
	 */
	public static String solving_the_equation(double a, double b, double c) throws SquareEquationException {
		
		//print the equation that we are going to solve
		System.out.println(a + "X^2+" + b + "X+" + c + "=0:");
		
			//if all coefficients are equal to zero the solution is trivial
			if (a==0 && b==0 && c==0) {
				
				throw new SquareEquationException("x can be any number - trivial!");
			
			//if the situation is 5=0 for example - no answer to the equation 	
			}else if (a==0 && b==0 && c!=0) {
				
				throw new SquareEquationException("Error, no answer!!");
			
			//only one x to the equation
			}else if(a==0 && b!=0) {
				
				double x = -1*c / b;
				
				//to avoid from x=-0
				if (x==-0) {
					x=0;
				}
				
				//print and return the answer
				System.out.println("x1=:" + x);
				return "x1=:" + x;
				
			}else {
				
				double delta = b*b - (4*a*c);
				
				//if delta smaller than there are no real roots to the equation
				if (delta < 0) {
					
					throw new SquareEquationException("Error: NO real roots!");
					
				}else if(delta == 0) {
					
					double x = (-1*b) / (2*a);
					
					if (x==-0) {
						x=0;
					}
					
					//print and return the answer
					System.out.println("x1=x2:" + x);
					return "x1=x2:" + x;
							
				} else {
					
					double x1 = ((-1*b) + Math.sqrt(delta)) / (2*a);
					double x2 = ((-1*b) - Math.sqrt(delta)) / (2*a);
					//print and return the answer
					System.out.println("x1:" + x1 + "    x2:" + x2);
					return "x1:" + x1 + "    x2:" + x2;
			}
		}
	}
}