/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_lab6;
import java.util.*;

/**
 * This class creates a new instance of a reverse Polish notation calculator. 
 * @author danzc
 *
 */
public class RPN {
	Stack stack = new Stack(); //create a new stack to work with.
	int operandCount = 0; //Accumulator tracking the number of operands.
	int operatorCount = 0; //Accumulator tracking the number of operators.
	
	
	public RPN(String in) {
		Scanner input = new Scanner(in); //Scanning a string.
		while (input.hasNext()) {
			if (input.hasNextDouble()) {
				stack.push(input.nextDouble());
				operandCount++;	
			}
			else {
				operators(input.next());
				operatorCount++;
			}
		}
		if (operandCount != operatorCount + 1) {
			if (operandCount >= operatorCount) {
				throw new IllegalArgumentException("Too many operands!");			
			}
			else {
				throw new IllegalArgumentException("Too few operands!");	
			}
		}
	}
	
	private void operators(String o) {
		char r = o.charAt(0); //character at the beginning of the passed string.
		double a; //holds values from the stack to operate on.
		double b; //holds a second value to operate on.

		switch (r) {
		case '+':
			a = stack.pop(); 
			b = stack.pop();
			stack.push(a + b);
			break;
		case '-':
			a = stack.pop(); 
			b = stack.pop();
			stack.push(a - b);
			break;
		case '*':
			a = stack.pop(); 
			b = stack.pop();
			stack.push(a * b);
			break;
		case '/':
			a = stack.pop(); 
			b = stack.pop();
			stack.push(a / b);
			break;
		default:
			throw new IllegalArgumentException("Unknown operator: " + r);
		}
	}
	
	/*
	 * Whatever value remains at the bottom of the stack is the solution 
	 * to the expression.
	 * @return value of item left in stack. 		Peeks at the stack.
	 */
	public double evaluate() {
		return stack.peek();
	}

}
