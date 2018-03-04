/*
 * Craig Danz
 * CPSC 5011, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */
package danz_p5;

import java.util.*;

/**
 * This class implements the inverter class and defines the functionality 
 * common to derived classes. Aside from the prototype functions implemented,
 * common functionality also defined includes managing the state of objects -
 * either Active or Inactive - encapsulating a word, guessing and utilities 
 * like a reset function and ability to see if the state of an object is 
 * currently active.
 * @author danzc
 */
public class Sequence implements Inverter{
	private final int CHARMIN = 3; //minimum number of characters needed for 
	//an encapsulated word.
	private int i; //index - moved from interface "Inverter" because interface
	//variables must be public, static and final. Since the index we choose 
	//must take into account the word length, it needs to be initialized after
	//the interface is, requiring it to be moved here. 
	protected String word; //encapsulated word
	protected boolean active; //an object's state. 
	
	/**
	 * This is the object's constructor. Set's its state to Inactive until
	 * a word is set. 
	 */
	public Sequence() {
		active = false;
	}
	
	/**
	 * This method implements the prototype emit function in the interface. 
	 * It takes the encapsulated word and inverts two elements its sequence 
	 * at indices i and i+1. i is also encapsulated. 
	 * Precondition - Object must be active.
	 * Post condition - no change from precondition
	 * @exception 			Return string literal "ERROR"
	 * @return String		Manipulation of encapsulated word.
	 */
	@Override
    public String emit(){
		if(active) {
			String newString = "";
			for(int j = 0; j < word.length(); j++) {
				if(j == i) {
					newString += word.charAt(i + 1);
					newString += word.charAt(i);
					j++; //covers two characters so need to move an extra 
					//space up prior to the normal incrementor doing its work.
				}
				else {
					newString += word.charAt(j);
				}
			}
			return newString;
		}
		return "ERROR";
    }
	
	/**
	 * This method checks to see if the user wants to perform an action again
	 * specified by the message passed to it. 
	 * Legal input - string must have at least 3 characters or whatever limit 
	 * is set by the constant CHARMIN
	 * Precondition - Object must be inactive.
	 * Post condition - if legal string was proffered, object will now be 
	 * 					active
	 * @exception 			Return false if illegal argument is passed
	 * @param in				Word proffered to encapsulate
	 * @return boolean		True, if and only if word was encapsulated 
	 * 						successfully
	 */
	@Override
	public boolean setWord(String in) {
		if (in.length() >= CHARMIN) {
			word = in;
			active = true;
			Random random = new Random();
			i = random.nextInt(in.length() -1);
			return in == word; //return true if successfully assigned
		}
		return false;
	}
	/**
	 * This method checks the objects state. 
	 * @return boolean		True if 'Active', False if 'Inactive'. 
	 */
	@Override
	public boolean isOn() {
		return active;
	}
	/**
	 * This method takes in a guess at the string value being encapsulated 
	 * and returns a boolean true or false, true only if the string parameter 
	 * is exactly equal to the one encapsulated.
	 * @param in				A guess of the string value encapsulated
	 * @return boolean		True if and only if an exact match.
	 */
	boolean guess(String in) {
		if (active)
			return in == word;
		return false; //return false if the object's word isn't set and active yet.
	}
	/**
	 * This method resets an object back to an inactive state where no word is
	 * encapsulated.
	 */
	void reset() {
		active = false;
		word = "";
	}
}
