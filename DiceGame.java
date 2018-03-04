/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_lab2;
import java.util.*;

/**
 * This class simulates a dice game played between a user and the computer
 * @author danzc
 */
public class DiceGame {
	public static void main(String[] args) {
		final int ROUNDS = 10; //Total number of rounds to play
		final int COM_LOAD = 6; //Number the computer is favored to roll
		final int COM_PER = 30; //Percentage of rolls that will result in
		                           //a roll that is favored for computer.
		final int PLYR_LOAD = 1; //Number the user is favored to roll
		final int PLYR_PER = 30; //Percentage of rolls that will result in
		                            //a roll that is favored for user.
		
		welcome(ROUNDS);
		LoadedDie comDie = new LoadedDie(COM_LOAD , COM_PER);
		LoadedDie plyrDie = new LoadedDie(PLYR_LOAD , PLYR_PER);
		do
		{
		   playGame(ROUNDS , comDie, plyrDie);
		} while (repeat("Would you like to play again? Y/N: "));
		farewell();

	}
	
	/**
	 * Welcomes the user to the program and explains what it does
	 * @param rounds		The number of rounds we will play
	 */
	public static void welcome(int rounds)
	{
		System.out.println("\n\n--------------------------------\n\n" +
	                       "              DICE\n\n" +
				           "---------------------------------\n\n" +
	                       "Get ready to throw dem bones!\n" +
				           "You will be competing in a harrowing game of " +
	                       "dice \nagainst the most skilled player of all - " +
				           "A MACHINE!!!\n" +
	                       "The player with the most wins after " + rounds + 
	                       " rounds will \nclaim the title of ULTIMATE " +
	                       "CHAMPION!\n\n" +
	                       "Computers are known for their superior skills " +
				           "at \nrolling die so this is surely going to be a " +
	                       "difficult \nmatch ...unless you have some sort of " +
				           "trick \nup your sleeve. ;)\n\n");
	}
	
	/**
	 * This method simulates gameplay.
	 * @param dieCom		The die object the computer should use
	 * @param diePlyr		The die object the user should use
	 */
	public static void playGame(int rounds , LoadedDie dieCom , LoadedDie diePlyr) {
		int round; //tracks the round
		int comScore = 0; //tracks the computer's score initialized to zero
		int plyrScore = 0; //tracks the user's score initialized to zero
		
		Scanner enter = new Scanner(System.in);
		
		for (round = 1; round <= rounds; round++) {
			System.out.println("\n     **ROUND " + round + "**\n" +
		                       "Computer\tHuman\n" +
					           "   " + comScore + "\t\t  " + plyrScore + 
					           "\n\nPress enter to roll...");
			enter.nextLine();
			diePlyr.roll();
			System.out.println("You rolled " + diePlyr.getRoll());
			dieCom.roll();
			System.out.println("The computer rolls " + dieCom.getRoll());
			if (dieCom.getRoll() > diePlyr.getRoll()) {
				System.out.println("Round " + round + " goes to the " +
					               "computer.");
				comScore++;
			}
			else if (dieCom.getRoll() < diePlyr.getRoll()) {
				System.out.println("Round " + round + " goes to the " +
					               "human."); 
				plyrScore++;
			}
			else {
				System.out.println("Lame. Its a tie. Push.");
			}
			
		}
		displayWinner(comScore , plyrScore);
	}

	
	/**
	 * This method checks the score and displays a message crowning a winner
	 * @param scoreCom		The computer's score at the end of all rounds
	 * @param scorePlyr		The user's score at the end of all rounds
	 */
	public static void displayWinner(int scoreCom , int scorePlyr) {
		if (scoreCom > scorePlyr) {
			System.out.println("\n\nCOMPUTER WINS!\n" +
			                   "A harbinger of humankind's decline???");
		}
		else if (scoreCom < scorePlyr) {
			System.out.println("YOU WIN!\n" +
	                   "Not today, SkyNet!");
		}
		else {
			System.out.println("It is a tie. [cough] [crickets]");
		}
	}
	
	/**
	 * This method checks to see if the user wants to perform an action again
	 * specified by the message passed to it. 
	 * @param msg
	 * @return boolean
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
