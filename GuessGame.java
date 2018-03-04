/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_lab3;

import java.util.*;

/**
 * This class creates instances of a GuessGame 
 */
public class GuessGame {
	private int rangeLo; //low end of guessing range
	private int rangeHi; //high end of guessing range
	private int target; //the number the computer is "thinking of"
	private int counter = 0; //accumulates number of guesses
	private ArrayList<Integer> counts = new ArrayList<Integer>(); //tracks
	                                    //number of guesses it takes for each
	                                    //attempt in a given games range
	private int countsTotal;            //sum of each rounds guesses to get
	                                    //average
	
	private static Random random = new Random();
	
	/**
	 * The constructor for a GuessGame instance.
	 * @param lo		User specified low range for a target
	 * @param hi		User specified high range for a target
	 */
	public GuessGame(int lo , int hi) {
		rangeLo = lo;
		rangeHi = hi;
		newTarget();
	}
	
	/**
	 * Shows the stats of the current game and previous rounds if they exist
	 * then resets the target for future games along with the counters
	 */
	public void displayStatistics() {
		System.out.println("That took you " + counter + " guesses.");
		counts.add(counter);
		
		if (counts.size() > 1) {
			countsTotal = 0;
			for (int i = 0; i < counts.size(); i++) {
				countsTotal += counts.get(i);
			}
			System.out.println("On average, it takes you " + 
		                       (countsTotal/counts.size()) + 
					           " guesses in this range.");
		}
		counter = 0;
		newTarget();
		
	}
	
	/**
	 * Generates a new number for the computer to be "thinking of" for the
	 * user to guess.
	 */
	public void newTarget() {
		target = random.nextInt(1 + rangeHi - rangeLo) + rangeLo;
	}
	
	/**
	 * Evaluates a users guess against the target. Provides a hint when wrong
	 * @param num			The number the user is passing as a guess.
	 * @return boolean		You guess right it is true, otherwise false
	 */
	public boolean guess(int num) {
		counter++;
		if (num == target) {
			System.out.println("You got it!");
			return true;
		}
		else {
			displayHint(num);
			return false;
		}
	}
	
	/**
	 * Getter for the instance's low range number.
	 * @return rangeLo 		The low range number.
	 */
	public int getRangeMinimum() {
		return rangeLo;
	}
	
	/**
	 * Getter for the instance's high range number.
	 * @return rangeHi		The high range number. 
	 */
	public int getRangeMaximum() {
		return rangeHi;
	}
	
	/**
	 * Only to be accessed after making a guess, this method tells you 
	 * if your guess is low or high.
	 * @param num			The number the user guessed
	 */
	private void displayHint(int num) {
		if (num < target) {
			System.out.println("Guess too low, Joe.");
		}
		else {
			System.out.println("Guess too high, Sly.");
		}
	}
}
