/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_lab2;
import java.util.*;

public class LoadedDie {
	 private int loadedNumber;
	 private int moreTimesPerHundred;
	 private int rollResult; 
	 private Random random;
	 
	/**
	 * The constructor performs an initial roll of the die.
	 * @param loadedNumber        Which number should come up more often
	 * @param moreTimesPerHundred How many times per 100 rolls to come up with 
	 *                            the loaded number (instead of uniform random)
	 */
	public LoadedDie(int loadedNumber , int moreTimesPerHundred) {
		this.loadedNumber = loadedNumber;
		this.moreTimesPerHundred = moreTimesPerHundred;
		random = new Random();
		roll();

	}
	
	/**
	 * The roll method simulates the rolling of the die.
	 * It will typically set this die's value to a random value
	 * with uniform distribution between 1 and 6. Occasionally,
	 * it will a priori return the favored value (with frequency
	 * determined by the moreTimesPerHundred argument that was passed
	 * to the constructor).
	 */
	public void roll() {
		if (random.nextInt(100) >= moreTimesPerHundred) {
			rollResult = random.nextInt(6) + 1;
		}
		else {
			rollResult = loadedNumber;
		}
	}
	
	/**
	 * This method gets the result of the last roll of the die.
	 * @return rollResult		The integer stored in the instance field
	 */
	public int getRoll() {
		return rollResult;
	}
}
