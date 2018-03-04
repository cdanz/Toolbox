/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_p1;
import java.util.*;

/**
 * This class creates instances of game boards with the necessary functions
 * for each to be played. 
 * @author danzc
 */
public class TicTacToe {
	private static final int DIM = 3; //Dimensions of the game board
	private static final int MAX = DIM * DIM; //Max number of turns a game 
											//can have
	private int count; //keeps count of how many turns
	private char turn; //Holds either an 'X' or 'O' depending on the turn
	private static final char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 
											'G', 'H', 'I', 'J', 'K', 'L',
											'M', 'N', 'O', 'P', 'Q', 'R',
											'S', 'T', 'U', 'V', 'W', 'X',
											'Y', 'Z'}; //Need these to label rows

	private char[][] board;
	private Random random = new Random();
	
	/**
	 * Constructor - takes no arguments, just fills a 2D array with spaces to
	 * to start
	 */
	public TicTacToe() {
		board = new char[DIM][DIM];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = ' ';
			}
		}
		count = 0;
		//randomly choose who goes first
		if (random.nextInt(2) == 0) {
			turn = 'O';
		}
		else {
			turn = 'X';
		}
	}
	
	/**
	 * Displays the board in its current state.
	 */
	public void displayBoard() {
			//Line by line. 5 lines for each initial box row and 3 more for
			//each subsequent line. This is line 1 not repeated.  
			System.out.print("     1  ");
			for (int i = 1; i < DIM; i++) {
				System.out.print("   " + (i + 1) + "  ");
			}
			System.out.println();
			//line 2 not repeated
			System.out.print("   _____");
			for (int i = 1; i < DIM; i++) {
				System.out.print("______");
			}
			System.out.println();
			//Lines that get repeated as many times as the size of the board
			//dictates
			for (int row = 0; row < DIM; row++) {
				//line 3 - gets repeated as line +3 ex. line 6, line 9, etc.
				System.out.print("  |     |");
				for (int col = 1; col < DIM; col++) {
					System.out.print("     |");
				}
				System.out.println();
				//line 4 - gets repeated as line +3 ex. line 7, line 10, etc.
				System.out.print(" " + letters[row] + "|  " + board[row][0] + "  |");
				for (int col= 1; col < DIM; col++) {
					System.out.print("  " + board[row][col] + "  |");
				}
				System.out.println();
				//line 5 - gets repeated as line +3 ex. line 8, line 11, etc.
				System.out.print("  |_____|");
				for (int i = 1; i < DIM; i++) {
					System.out.print("_____|");
				}
				System.out.println();
			}
		//What I'm going for. 
		//     1     2     3
		//	 _________________
		//  |     |     |     |
		// A|  O  |  X  |  O  |
		//  |_____|_____|_____|
		//  |     |     |     |
		// B|  O  |  X  |  X  |
		//  |_____|_____|_____|
		//  |     |     |     |
		// C|  O  |  X  |  X  |
		//  |_____|_____|_____|
		//
	}
	
	/**
	 * Receives a requested move input from the user who's turn it is. 
	 * @param r		String that should have a valid letter representing a row
	 * @param c		Int should represent a valid column
	 */
	public void makeMove(String r , int c) {
		board[parseRow(r)][c - 1] = turn;
		count++;
	}
	
	
	/**
	 * Tests user input for a validity. Must start with a valid letter for row.
	 * @param r				String representing a row letter.
	 * @return boolean		True if input has valid letter.
	 * 						False otherwise. 
	 */
	public boolean validRow(String r) {
		String s = r;	
		s = s.toUpperCase();
		char row = s.charAt(0);
		
		for (int i = 0; i < DIM; i++) {
			if (letters[i] == row) {
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Tests user input for a validity. Must end with a valid number for 
	 * column.
	 * @param col			Column of the space user wants.
	 * @return boolean		True if input has valid number.
	 * 						False otherwise. 
	 */
	public boolean validCol(int col) {
		if (col > 0 && col <= DIM) {
			return true;
		}
		return false;
	}
	
	/**
	 * Tests user input for a validity. Move can only be to a blank space.
	 * @param r				String representing a letter for a row
	 * @param c				Int representing a column.
	 * @return boolean		True if input is valid.
	 * 						False otherwise. 
	 */
	public boolean isBlank(String r , int c) {
		if (board[parseRow(r)][c - 1] == ' ') {
				return true;
		}
		System.out.println("Not Available");
		return false;
	}
	
	/**
	 * Turn the first valid character into a row index for 2D board array. 
	 * @param m				String to be parsed and pull out the letter at the
	 * 						first character.
	 * @return row			The integer of the index for the 2D array row value.
	 */
	public int parseRow(String m) {
		String r = m.toUpperCase(); //Get all letters to uppercase
		char row = r.charAt(0); //Get just the first letter
		int index = -1; //index we are trying to find initialized to -1. 
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == row) {
				index = i;
			}
		}
		return index;
	} 
	
	/**
	 * Returns the turn, either "X" or "O". 
	 * @return turn		Character 'X' or 'O'
	 */
	public char getTurn() {
		return turn;
	}
	
	/*
	 * Toggles turns between "X" and "O" when called.
	 */
	public void switchTurn() {
		if (turn == 'X') {
			turn = 'O';
		}
		else {
			turn = 'X';
		}
	}
	
	/**
	 * Gets the max number of turns a board can handle
	 * @return MAX			The most turns that can be taken before cats game.
	 */
	public int getMAX() {
		return MAX;
	}
	
	/**
	 * Gets the count of turns taken.
	 * @return count			The current count of turns taken 
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Checks to see if we have a winner for our game yet. 
	 * @return winner		true if winning criteria is met and false if not.
	 */
	public boolean winner() {
		int xCounter; 	//counter to see how many X's are in a row, column or
						//diagonal
		int oCounter;	//counter to see how many X's are in a row, column or
						//diagonal

		//Evaluate rows
		for (int i = 0; i < DIM; i++) {
			xCounter = 0; //reset for each row
			oCounter = 0; //reset for each row
			for (int j = 0; j < DIM; j++) {
				if (board[i][j] == 'X') {
					xCounter++;
				} else if (board[i][j] == 'O') {
					oCounter++;
				}
			} 
			if (xCounter == DIM || oCounter == DIM) {
				return true;
			}
		}
		//Evaluate columns
		for (int j = 0; j < DIM; j++) {
			xCounter = 0; //reset for new column
			oCounter = 0; //reset for new column
			for (int i = 0; i < DIM; i++) {
				if (board[i][j] == 'X') {
					xCounter++;
				} else if (board[i][j] == 'O') {
					oCounter++;
				}
			} 
			if (xCounter == DIM || oCounter == DIM) {
				return true;
			}
		}
		//Evaluate diagonals
		xCounter = 0; //reset
		oCounter = 0; //reset
		for (int i = 0; i < DIM; i++) {
			if (board[i][i] == 'X') {
				xCounter++;
			} else if (board[i][i] == 'O') {
				oCounter++;
			}
		}
		if (xCounter == DIM || oCounter == DIM) {
			return true;
		}
		xCounter = 0;
		oCounter = 0;
		for (int i = 0, j = DIM - 1; i < DIM; i++, j--) {
			if (board[i][j] == 'X') {
				xCounter++;
			}
			else if (board[i][j] == 'O') {
				oCounter++;
			}
		}
		if (xCounter == DIM || oCounter == DIM) {
			return true;
		}
		return false;
	}
}

