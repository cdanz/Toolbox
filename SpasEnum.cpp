// AUTHOR: Craig Danz
// FILENAME: SpasEnum.cpp
// DATE: 11/6/2017
// REVISION HISTORY: 2.0
// REFERENCES (optional): SpasEnum.Java
//
// Note: SpasEnum 'is-a' SequenceEnum object.
//
// Assumptions:
// It's okay if the substring is actually the entire string. This happens when
// we randomly choose the beginning and end and what to include the first and
// last index - it is okay.


#include "SpasEnum.h"
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

SpasEnum::SpasEnum() {
		active = false;
	}

string SpasEnum::emit() {
	
	if (active) {
		newString = "";
		unsigned beforeOrAfter; //first and last index of
		// where substring is found
		
		atSubStart = (rand() % (word.length()-1));
		do {
			atSubEnd = (rand() % word.length());
		} while (atSubEnd <= atSubStart); //Make sure you get a character index
		// greater than the start.
		beforeOrAfter = rand() % 2; //Not arbitrary, need a 0 or 1, 0 denotes
		// concatenation of substring should happen at beginning and 1 denotes that
		// it should happen at the end.
		if(beforeOrAfter == 0){
			for (unsigned i = 0; i < (atSubEnd - atSubStart + 1); i++) {
				newString += word.at(atSubStart + i);
			} //mississippi start 4 end 8 2nd i and 1st p
			newString += word;
			return newString;
		}
		else {
			newString += word;
			for (unsigned i = 0; i < (atSubEnd - atSubStart + 1); i++) {
				newString += word.at(atSubStart + i);
			}
			return newString;
		}
	}
	return "ERROR";
}

string SpasEnum::emitTrunc() {
	if (active) {
		newString = "";
		atSubStart = (rand() % (word.length()-1));
		do {
			atSubEnd = (rand() % word.length());
		} while (atSubEnd <= atSubStart); //Make sure you get a character index
		// greater than the start.
		
		for (unsigned i = 0; i < (atSubEnd - atSubStart + 1); i++) {
			newString += word.at(atSubStart + i);
		}
		return newString;
	}
	return "ERROR";
}

//
// Created by Craig Danz on 11/6/17.
//