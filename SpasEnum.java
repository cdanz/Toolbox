/*
 * Craig Danz
 * CPSC 5011, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */
//package danz_p5;

import java.util.*;

/**
 * This class extends the Sequence class inheriting most of its functionality
 * except the emit function is overridden by its own version where a random 
 * subsequence is concatenated to the beginning or end. There is also an 
 * additional function added that returns only a random subsequence of characters 
 * rather than concatenating it to the encapsulated word. 
 * @author danzc
 */
public class SpasEnum extends Sequence{
	/**
	 * This method overrides its parent's version of the emit function. 
	 * It randomly chooses a subsequence of the encapsulated word and 
	 * concatenates it either to the beginning or the end of the full string's
	 * sequence.
	 * Precondition - Object must be active to use.
	 * Post condition - no change from precondition
	 * @exception 			Return string literal "ERROR" if illegally called
	 * @return String		Manipulation of encapsulated word.
	 */
	@Override
	public String emit() {
		Random random = new Random();
		if (active) {
			String newString = "";
			int beforeOrAfter; //first and last index of
			// where substring is found
			
			int atSubStart = random.nextInt(word.length() - 1);
			int atSubEnd = 0;
			do {
				atSubEnd = random.nextInt(word.length());
			} while (atSubEnd <= atSubStart); //Make sure you get a character 
			// index greater than the start.
			beforeOrAfter = random.nextInt(2); //Not arbitrary, need a 0 or 1,
			// 0 denotes concatenation of substring should happen at beginning
			// and 1 denotes that it should happen at the end.
			if(beforeOrAfter == 0){
				for (int j = 0; j < (atSubEnd - atSubStart + 1); j++) {
					newString += word.charAt(atSubStart + j);
				} 
				newString += word;
				return newString;
			}
			else {
				newString += word;
				for (int j = 0; j < (atSubEnd - atSubStart + 1); j++) {
					newString += word.charAt(atSubStart + j);
				}
				return newString;
			}
		}
		return "ERROR";
	}

	/**
	 * This method offers an alternative emit function. 
	 * It returns a randomly chosen subsequence of the encapsulated word.
	 * Precondition - Object must be active to use.
	 * Post condition - no change from precondition
	 * @exception 			Return string literal "ERROR" if illegally called
	 * @return String		Manipulation of encapsulated word.
	 */
	public String emitTrunc() {
		Random random = new Random();
		if (active) {
			String newString = "";
			int atSubStart = random.nextInt(word.length() - 1);
			int atSubEnd = 0;
			do {
				atSubEnd = random.nextInt(word.length());
			} while (atSubEnd <= atSubStart); //Make sure you get a character index
			// greater than the start.
			
			for (int j = 0; j < (atSubEnd - atSubStart + 1); j++) {
				newString += word.charAt(atSubStart + j);
			}
			return newString;
		}
		return "ERROR";
	}
}
