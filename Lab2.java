/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package danz_lab2;

import java.util.*;

/**
 * This class is a palindrome checker. Give it any word and it will tell you
 * if it is a palindrome or not. 
 * @author danzc
 *
 */
public class Lab2 {

	public static void main(String[] args) {
		String text;
		
		welcome();
		do {
			text = getText();
			if (!text.isEmpty()) {
				if (palindromeCheck(text))
					System.out.println("This is a palindrome!\n");
				else 
					System.out.println("This is NOT a palindrome.\n");
			}
		} while (!text.isEmpty());
		farewell();	

	}
	
	/**
	 * This method request input text from the user to use in the class. 
	 * @return input				String of text user entered with keyboard.
	 */
	private static String getText() {
		Scanner keyboard = new Scanner(System.in);
		String input;
		
		System.out.print("Test text (ENTER to exit): ");
		input = keyboard.nextLine();
		return input;
	}
	
	/**
	 * Checks to see if the string argument should be considered a palindrome
	 * or not. This method takes just a string and calls an overloaded version
	 * of itself which adds the parameters necessary to use it recursively.
	 * @param s					String of text.
	 * @return boolean			True if the text is considered a palindrome.
	 */
	public static boolean palindromeCheck(String s) {
		return palindromeCheck (s, 0, s.length() - 1);
	}
	
	/**
	 * Takes in the string along with points on the left and on the right 
	 * where characters should be evaluated. 
	 * @param s					String of text.
	 * @param left				Index of left character to be evaluated 
	 * 							against its mirror on the right. 
	 * @param right				Index of right character to be evaluated
	 * 							against its mirror on the left. 
	 * @return boolean			True if the text is considered a palindrome.
	 */
	public static boolean palindromeCheck(String s, int left, int right) {
		while (Character.isWhitespace(s.charAt(left))) 
			left++;
		while(Character.isWhitespace(s.charAt(right)))
			right--;
		if (right == left)
			return true;
		if (left > right)
			return true;
		
		return Character.toLowerCase(s.charAt(left)) == 
					Character.toLowerCase(s.charAt(right)) && 
						palindromeCheck(s, left + 1, right - 1);
	}



	/**
	 * This method displays a welcome message. 
	 */
	private static void welcome() {
		System.out.print("\n\nWelcome. This program is a " +
						"palindrome checker. Enter text to see \n" +
						"if it is a palindrome!\n\n");
	}
	
	/**
	 * This method displays a goodbye message. 
	 */
	private static void farewell() {
		System.out.print("\n\nThanks for playing.\n\n");
	}

}
