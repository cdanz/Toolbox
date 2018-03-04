// AUTHOR: Craig Danz
// FILENAME: Sequence.h
// DATE: 12/8/2018
// REVISION HISTORY: 1.0
// REFERENCES (optional): Sequence.java

//
// Created by Craig Danz on 12/8/17.
//

#ifndef CPSC_5011_P1_SEQUENCE_H
#define CPSC_5011_P1_SEQUENCE_H

//This class implements the inverter class and defines the functionality
//common to derived classes. Aside from the prototype functions implemented,
//common functionality also defined includes managing the state of objects -
//either Active or Inactive - encapsulating a word, guessing and utilities
//like a reset function and ability to see if the state of an object is
//currently active.

#include "Inverter.h"
#include <iostream>
#include <string>
using namespace std;


class Sequence : public Inverter {
public:
 	//This is the object's constructor. Set's its state to Inactive until
 	//a word is set.
	Sequence();
	
	//This method implements the prototype emit function in the interface.
	//It takes the encapsulated word and inverts two elements its sequence
	//at indices i and i+1. i is also encapsulated.
	//Precondition - Object must be active.
	//Post condition - no change from precondition
	//@exception 			Return string literal "ERROR"
	//@return String		Manipulation of encapsulated word.
	string emit();

	//This method checks to see if the user wants to perform an action again
	//specified by the message passed to it.
	//Legal input - string must have at least 3 characters or whatever limit
	//is set by the constant CHARMIN
	//Precondition - Object must be inactive.
	//Post condition - if legal string was proffered, object will now be
						//active
	//@exception 			Return false if illegal argument is passed
	//@param in				Word proffered to encapsulate
	//@return boolean		True, if and only if word was encapsulated
							//successfully
	bool setWord(string in);

	//This method checks the objects state.
	//@return boolean		True if 'Active', False if 'Inactive'.
	bool isOn();

	//This method takes in a guess at the string value being encapsulated
	//and returns a boolean true or false, true only if the string parameter
	//is exactly equal to the one encapsulated.
	//@param in				A guess of the string value encapsulated
	//@return boolean		True if and only if an exact match.
	bool guess(string in);

	//This method resets an object back to an inactive state where no word is
	//encapsulated.
	void reset();
	
protected:
	const unsigned CHARMIN = 3; //minimum number of characters needed for
	//an encapsulated word.
	unsigned i; //index - moved from interface "Inverter" because
	// interface variables must be public, static and final. Since the
	// index we choose must take into account the word length, it needs
	// to be initialized after the interface is, requiring it to be
	// moved here.
	std::string word; //encapsulated word
	bool active; //an object's state.
private:
};

#endif //CPSC_5011_P1_SEQUENCE_H
