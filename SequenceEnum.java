/*
 * Craig Danz
 * CPSC 5011, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */
package danz_p5;

import java.util.*;

/**
 * This class extends the Sequence class inheriting most of its functionality
 * except the emit function is overridden by its own version where a random 
 * character is chosen to be repeated from the encapsulated word.
 * @author danzc
 */
public class SequenceEnum extends Sequence{
	/**
	 * This method overrides its parent's version of the emit function. 
	 * It takes the encapsulated word and repeats a randomly chosen 
	 * character. 
	 * Precondition - Object must be active to use.
	 * Post condition - no change from precondition
	 * @exception 			Return string literal "ERROR"
	 * @return String		Manipulation of encapsulated word.
	 */
	@Override
	public String emit() {
		if (active) {
			String newWord = "";
			Random random = new Random();
			int randChar = random.nextInt(word.length()); //Char to repeat
			for (int j = 0; j < word.length(); j++) {
				newWord += word.charAt(j);
				if (j == randChar)
					newWord += word.charAt(j); //repeat the character if it is in
											//the randomly chosen position.
			}
			return newWord;
		}
		return "ERROR"; //if called illegally before object is activated.
	}
}
