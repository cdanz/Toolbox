// AUTHOR: Craig Danz
// FILENAME: Sequence.cpp
// DATE: 12/8/2017
// REVISION HISTORY: 1.0
// REFERENCES (optional): Sequence.java

//
// Created by Craig Danz on 12/8/17.
//

#include "Sequence.h"
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

Sequence::Sequence() {
	active = false;
}

string Sequence::emit(){
	if(active) {
		string newString = "";
		for(unsigned j = 0; j < word.length(); j++) {
			if(j == i) {
				newString += word.at(i + 1);
				newString += word.at(i);
				j++; //covers two characters so need to move an extra
				//space up prior to the normal incrementor doing its work.
			}
			else {
				newString += word.at(j);
			}
		}
		return newString;
	}
	return "ERROR";
}

bool Sequence::setWord(string in) {
	if (in.length() >= CHARMIN) {
		word = in;
		active = true;
		i = (rand() % in.length()) - 1;
		return in == word; //return true if successfully assigned
	}
	return false;
}
bool Sequence::isOn() {
	return active;
}
bool Sequence::guess(string in) {
	if (active)
		return in == word;
	return false; //return false if the object's word isn't set and active yet.
}
void Sequence::reset() {
	active = false;
	word = "";
}