import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuadraticEquationTest {
	
	@Test
	void test_single_solution() throws SquareEquationException {
		
		assertEquals(QuadraticEquation.solving_the_equation(0, 3, 6), "x1=:-2.0");
		
		assertEquals(QuadraticEquation.solving_the_equation(0, 5, 3), "x1=:-0.6");
		
		assertEquals(QuadraticEquation.solving_the_equation(0, 8, 0), "x1=:0.0");
		
		assertEquals(QuadraticEquation.solving_the_equation(1, -2, 1), "x1=x2:1.0");
		
		assertEquals(QuadraticEquation.solving_the_equation(0, 2, 5), "x1=:-2.5");
		
		assertEquals(QuadraticEquation.solving_the_equation(1, 0, 0), "x1=x2:0.0");
	}
	
	@Test
	void test_two_same_solutions() throws SquareEquationException {
		
		assertEquals(QuadraticEquation.solving_the_equation(1, 0, 0), "x1=x2:0.0");
		assertEquals(QuadraticEquation.solving_the_equation(1, -8, 16), "x1=x2:4.0");
	}
	
	@Test
	void test_two_solutions() throws SquareEquationException {
		
		assertEquals(QuadraticEquation.solving_the_equation(8, 0, -2.3), "x1:0.5361902647381804    x2:-0.5361902647381804");
		
		assertEquals(QuadraticEquation.solving_the_equation(5, -9, -7), "x1:2.386606874731851    x2:-0.5866068747318506");

		assertEquals(QuadraticEquation.solving_the_equation(2.2, 5.68, -7), "x1:0.9109683949674319    x2:-3.492786576785613");
		
		assertEquals(QuadraticEquation.solving_the_equation(10, 6.7, 0), "x1:0.0    x2:-0.67");
		
		assertEquals(QuadraticEquation.solving_the_equation(10, 5, 0), "x1:0.0    x2:-0.5");
		
		assertEquals(QuadraticEquation.solving_the_equation(-2.3, 5.1, 12.98), "x1:-1.5128848463076623    x2:3.730276150655489");
		
		assertEquals(QuadraticEquation.solving_the_equation(1, -5, 6), "x1:3.0    x2:2.0");
	}
	
	//this part of the test is taken from the website:
	//"JUnit 5 User Guide", https://junit.org/junit5/docs/current/user-guide/
	
	@Test
	void test_no_real_roots_error() throws SquareEquationException {
		
		SquareEquationException thrown1 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(10, 10, 3.5));
		assertEquals(thrown1.getMessage(), "Error: NO real roots!");
		
		SquareEquationException thrown2 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(4, 1, 1));
		assertEquals(thrown2.getMessage(), "Error: NO real roots!");
		
		SquareEquationException thrown3 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(-1, -2, -9));
		assertEquals(thrown3.getMessage(), "Error: NO real roots!");
		
		SquareEquationException thrown4 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(7.6, 9.3, 2.88));
		assertEquals(thrown4.getMessage(), "Error: NO real roots!");
		
		SquareEquationException thrown5 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(-7.5, -6.8, -2.3));
		assertEquals(thrown5.getMessage(), "Error: NO real roots!");
		
		SquareEquationException thrown6 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(13.5, 5.6, 0.9));
		assertEquals(thrown6.getMessage(), "Error: NO real roots!");
		
		
	}
	
	@Test
	void test_x_can_be_any_number_error() throws SquareEquationException {
		
		SquareEquationException thrown2 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(0, 0, 0));
		assertEquals(thrown2.getMessage(), "x can be any number - trivial!");
	}

	
		@Test
		void test_no_answer_error() throws SquareEquationException {
			
			SquareEquationException thrown1 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(0, 0, 2));
			assertEquals(thrown1.getMessage(), "Error, no answer!!");
			
			SquareEquationException thrown2 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(0, 0, -2));
			assertEquals(thrown2.getMessage(), "Error, no answer!!");
			
			SquareEquationException thrown3 = assertThrows(SquareEquationException.class, () -> QuadraticEquation.solving_the_equation(0, 0, -6.32));
			assertEquals(thrown3.getMessage(), "Error, no answer!!");
	}
}
