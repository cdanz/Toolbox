// AUTHOR: Craig Danz
// FILENAME: SequenceEnum.cpp
// DATE: 11/6/2017
// REVISION HISTORY: 2.0
// REFERENCES (optional): SequenceEnum.java


#include "SequenceEnum.h"
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

SequenceEnum::SequenceEnum() {
	active = false;
}

string SequenceEnum::emit() {
	if (active) {
		std::string newWord;
		unsigned randChar = (rand() % word.length()); //Random char to repeat
		for (unsigned i = 0; i < word.length(); i++) {
			newWord += word.at(i);
			if (i == randChar)
				newWord += word.at(i); //repeat the character if it is in the
										// randomly chosen position.
		}
		return newWord;
	}
	return "ERROR"; //if called illegally before object is activated.
}

//
// Created by Craig Danz on 11/6/17.
//

/* Code that was only relevent in previous assignments
 * bool SequenceEnum::setWord(string in) {
	if (in.length() >= CHARMIN) {
		word = in;
		active = true;
		return in == word; //return true if successfully assigned
	}
	return false;
}
 bool SequenceEnum::isOn() {
	return active;
}

bool SequenceEnum::guess(string in) {
	if (active)
		return in == word;
	return false; //return false if the object's word isn't set and active yet.
}

void SequenceEnum::reset() {
	active = false;
	word = "";
}
 */