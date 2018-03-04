/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_lab6;
import java.util.*;

/**
 * This class allows users to calculate using reverse polish notation. It
 * will take in a string input and send it to the RPN class to parse and 
 * evaluate. 
 * @author danzc
 *
 */
public class RPNCalculator {
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		String input; //whatever string the user enters to calculate
		
		welcome();
		System.out.print("calc> ");
		input = keyboard.nextLine();
		while (!input.equals("")) {
			RPN rpn = new RPN(input);
			System.out.println(rpn.evaluate());
			System.out.print("calc> ");
			input = keyboard.nextLine();
		} 
		farewell();
	}
	
	/**
	 * Welcomes the user to the program. 
	 * @param a				A string for the name of the file being read
	 */
	public static void welcome() {
		System.out.println("\n\n--------------------\n" +
							"    RPN Calculator   \n" +
							"-----------------------\n\n" +
							"Put your slide ruler down, flip it and reverse " +
							"it. Accepts any double as an operand and " +
							" '+', '-', '*', or '/' as operands.\n\n" +
							"(blank line to quit)\n\n");
	}
	
	/**
	 * Wishes the user well before exiting. 
	 */
	public static void farewell() {
		System.out.println("\n\nThanks for taking a stroll down the " +
							"computer science memor- ...I mean, history " + 
							"hole.\n\n");
	}
}
