/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_lab3;

import java.util.Scanner;

/*
 * This class takes users through a guessing game. 
 */
public class Lab3 {
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		welcome();
		playGame();
		farewell();
	}
	
	/*
	 * Welcomes the user and takes them through how the game works.
	 */
	public static void welcome()
	{
		System.out.println("\n\n--------------------------------\n\n" +
	                       "   GUESS THE NUMBER\n\n" +
				           "---------------------------------\n\n" +
	                       "Test your powers of perception!\n" +
				           "The computer has a secret, can you guess it? " +
	                       "\nGive the computer a range and it will come up " +
	                       "with a number. Then try to guess. \n" +
				           "See how few guesses you need.\n\n");
	}
	
	/*
	 * Main gameplay method
	 */
	public static void playGame() {
		int rangeLo;
		int rangeHi;
		int input;
		
		do {
			System.out.print("What should be the low end of the range?: ");
			rangeLo = keyboard.nextInt();
			System.out.print("What should be the high end of the range?: ");
			rangeHi = keyboard.nextInt();
		    
			//Generate game instance based on user parameters
			GuessGame thisGame = new GuessGame(rangeLo , rangeHi);
			do {
				System.out.println("Okay, I have a number.");
				do {
					do {
						System.out.print("What is your guess between " + 
			                         	thisGame.getRangeMinimum() + " and " + 
			                         	thisGame.getRangeMaximum() + "?: ");
						input = keyboard.nextInt();
					} while (input < thisGame.getRangeMinimum() || 
							 input > thisGame.getRangeMaximum());
				} while (!thisGame.guess(input));
				thisGame.displayStatistics();
			} while (repeat("Like to try for fewer guesses? Y/N: "));
		} while (repeat("Would you like to play with a different range? " +
		                "Y/N: "));
	}
	
	/**
	 * This method checks to see if the user wants to perform an action again
	 * specified by the message passed to it. 
	 * @param msg			What do you want them to repeat? 
	 * @return boolean		If a desire to repeat : true else false.
	 */
	public static boolean repeat(String msg)
	{
		String input;
		char repeat;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print(msg);
		input = keyboard.nextLine();
		repeat = input.charAt(0);
		if (repeat == 'y' || repeat == 'Y')
			return true;
		return false;
	}
	
	/**
	 * Bids the user farewell before exiting the program.
	 */
	public static void farewell()
	{
		System.out.println("\n\nThanks for playing!\n\n");
	}
}
