// AUTHOR: Craig Danz
// FILENAME: SpasEnum.h
// DATE: 11/6/2017
// REVISION HISTORY: 1:0
// REFERENCES (optional): SpasEnum.java

#ifndef CPSC_5011_P1_SPASENUM_H
#define CPSC_5011_P1_SPASENUM_H

// Description: -- Once set with a valid string, instances of this object emit a
// a variation of the string. This derived class inherits most of its
// functionality and attributes from its parent class, SequenceEnum. Children,
// this class included, modify the emission of a manipulated string. This
// particular class concatenates an internal subsequence, randomly chosen and
// appended either to the beginging or end of the original word to be emitted.
// For example, if the word ‘seesaw’ is encapsulated, ‘seesawse’,’ ‘saseesaw’,
// ‘seesaws’, etc., could be returned. There is an alternative emission that
// emits only a subsequence without concatenating it to the base word as well.
// Legal States: There are two states, Active or Inactive which are inherited
// from the parent. The state indicates whether the word an instance will work
// with has been set or not. Instances are initialized in an inactive state and
// only become active once a word is set. Each instance will remain active until
// reset which will make it inactive until a new word is set. While in an
// "Inactive" state, any attempts to use the guessing function will return an
// error.
// Dependancies: This class is dependent upon its parent to inherit necessary
// functionality. Its only functionality is dependent upon the state inherited
// from the parent being active.
// Anticipated Use: This class is designed to be used in a guessing game. By
// presenting a manipulated version of the set string, the application
// programmer is expected to prompt guesses from a user as to what
// the string value is exactly and report back the accuracy of their guess.
// Data Processed: This class takes in and returns string values only.
// Legal Input: Strings that serve as the word being set must be at least 3
// characters long and whitespace is not accepted (will return error). Only
// strings made of alphabetic characters are accepted. substring arguments need
// only be one character long or more but also do not accept whitespace, numbers
// or any other non-alphabetic characters.
// Output: This class emits strings that are manipulations of a set word held
// privately. All other functions are either void or return boolean values.
//
// Assumptions:
// The application programmer has access to and will read all necessary legal
// inputs and uses of the parent class's declaration file. AP will adhere to
// programming by contract principles while following instructions elucidated in
// both the parent and the child's declaration files. Application programmer is
// responsible for checking the state before calling functions that are
// dependent on the state.
//

#include "SequenceEnum.h"
#include <iostream>
#include <string>
using namespace std;

class SpasEnum : public Sequence{
public:
	SpasEnum();
	// description: constructor, calls parent constructor first.
	// precondition: no object
	// postcondition: inactive - no word set.
	string emit();
	// description: emits a varient of the protected word attribute where an
	// internal subsequence is concatenated to it, randomly chosen and
	// appended either to the beginging or end of the original word to be
	// emitted. For example, if the word ‘seesaw’ is encapsulated, ‘seesawse’,’
	// ‘saseesaw’, ‘seesaws’, etc., could be returned.
	// Note: This function overwrites the parent version of emit so if the AP,
	// wishes to access the parent version from a calling child object she must
	// explicitly call the parent classes version from the parent class.
	// precondition: parent class is active Check with getOn().
	// postcondition: parent class is active
	string emitTrunc();
	// description: emits a varient of the protected word attribute of an
	// internal subsequence. For example, if the word ‘seesaw’ is encapsulated,
	// ‘see’, ‘sees’, etc. could be returned.
	// precondition: parent class is active Check with getOn().
	// postcondition: parent class is active

private:
	std::string newString; //built string of word plus appended substring
	unsigned atSubStart, atSubEnd; //beginning and ending index of a substring
	
};

#endif //CPSC_5011_P1_SPASENUM_H

//
// Created by Craig Danz on 11/6/17.
//
