// AUTHOR: Craig Danz
// FILENAME: SeqExtract.h
// DATE: 11/6/2017
// REVISION HISTORY: 1.0
// REFERENCES (optional):


#ifndef CPSC_5011_P1_SEQEXTRACT_H
#define CPSC_5011_P1_SEQEXTRACT_H

// Description: -- Once set with a valid string, instances of this object emit a
// a variation of the string. This derived class inherits most of its
// functionality and attributes from its parent class, SequenceEnum. Children,
// this class included, modify the emission of a manipulated string. This
// particular class takes in a string for its emission function and checks it
// against the protected word stored in the parent to see if it matches a
// substring of it. If it is equal to a valid substring of the protected word,
// then it will emit all other characters of the string as a substring that were
// not part of that substring. For example, if the string is "career" and the
// emission function had "car" as a parameter than it would be a valid substring
// and would return "eer". The parameter "reeer" would not be valid so an
// "ERROR" would be returned. The ability to guess the set word is inherited its
// parent.
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
// strings made of alphabetic characters are accepted - all of this is inherited
// by the parent. substring arguments need only be one character long or more
// but also do not accept whitespace, numbers or any other non-alphabetic
// characters.
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

class SeqExtract : public Sequence {
public:
	SeqExtract();
	// description: constructor, calls parent constructor first.
	// precondition: no object
	// postcondition: inactive - no word set.
	string emit(std::string);
	// description: extracts a subsequence from the encapsulated word, if the
	// subsequence parameter is found. For example, if the word ‘believe’ is
	// stored with the parent and the subsequence ‘beli’ proffered, ‘eve’ would
	// be emitted; likewise, if the word ‘evening’ were encapsulated and the
	// subsequence ‘ning’ proffered, ‘eve’ would be emitted.
	// Note: if the substring proffered appears more than once in the
	// encapsulated string than only the first instance will be removed.
	// precondition: parent class is active. Check with getOn().
	// postcondition: parent class is active

private:


};

#endif //CPSC_5011_P1_SEQEXTRACT_H


//
// Created by Craig Danz on 11/6/17.
//