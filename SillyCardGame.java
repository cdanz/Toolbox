/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_p3;

import java.util.*;

/**
 * This class utilizes the GameModel class to take users through a full
 * session of a silly little card game. 
 * @author danzc
 *
 */
public class SillyCardGame {
	private static Scanner keyboard = new Scanner(System.in);
	private static String [] plyrs;

	public static void main(String[] args) {
		welcome();
		do {
			plyrs = gameSetUp(); //Sets number of players and player names.
			int turn = 0; //Initialize which player's turn it is to zero.
			GameModel game = new GameModel(plyrs); //Create a new game object
			while (!game.getWinner()) {
				System.out.println(game.turnDetails(turn));
				//System.out.print("Press RETURN to take a turn.");
				//keyboard.nextLine();
				System.out.println(game.takeTurn(turn));
				if (turn == plyrs.length - 1) {
					turn = 0;
				}
				else {
					turn++;
				}
			}
			displayWinner(game); 
		} while (repeat("Would you like to play again? Y/N: "));
		farewell();
	}
	
	/**
	 * Gets basic info to needed to initialize a new game. 
	 * @return players			A String array containing player names. 
	 */
	private static String[] gameSetUp() {
		final int NUMPLAYERS = 2; //Only two players
		String[] players = new String[NUMPLAYERS];
		
		for (int i = 0; i < players.length; i++) {
			System.out.print("Enter player " + (i+1) + " name: ");
			players[i] = keyboard.nextLine();
		}
		return players;	
	}
	
	/**
	 * Welcomes the user and takes them through how the game works.
	 */
	public static void welcome() {
		System.out.println("\n\n--------------------------------\n\n" +
	                       "   Silly Card Game\n\n" +
				           "---------------------------------\n\n" +
	                       "A 'Silly Little Games' Joint\n" +
				           "This game takes zero skill or strategy.\n\n");
	}
	
	/**
	 * This method is called when we have a winner. Displays result of game.
	 * @param a				Needs a GameModel to reference
	 */
	public static void displayWinner(GameModel a) {
		System.out.println("\n\n*******************************\n" +
							"\"" + plyrs[a.getWinnerIndex()] + "\" WINS!\n" +
							"*******************************\n\n");
	}
	
	/**
	 * This method checks to see if the user wants to perform an action again
	 * specified by the message passed to it. 
	 * @param msg			What do you want them to repeat? 
	 * @return boolean		If a desire to repeat : true else false.
	 */
	public static boolean repeat(String msg) {
		String input;
		char repeat;
		
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
		keyboard.close();
		System.out.println("\n\nThanks for playing!\n\n");
	}
}
