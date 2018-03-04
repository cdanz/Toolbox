/*
 * Craig Danz
 * CPSC 5011, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */
package danz_p5;

/**
 * This interface sets the basic requirements for classes that implement it.
 * Classes that implement this interface should at a minimum encapsulate a 
 * word, emit an altered version of it and check its state. 
 * @author danzc
 */
public interface Inverter {
	/**
	 * This is a prototype of a method that emits an adjusted version of an 
	 * encapsulated word. It needs to be implemented in another class.
	 */
	String emit();
	/**
	 * This is a prototype of a method that sets a word to be encapsulated  
	 * in another class.
	 */
	boolean setWord(String in);
	/**
	 * This is a prototype of a method that checks state.
	 */
	boolean isOn();
}
