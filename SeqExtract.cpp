// AUTHOR: Craig Danz
// FILENAME: SeqExtract.cpp
// DATE: 11/6/2017
// REVISION HISTORY: 2.0
// REFERENCES (optional): SeqExtract.java

// Note: SeqExtract 'is-a' SequenceEnum object.

#include "SeqExtract.h"
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

SeqExtract::SeqExtract() {
		active = false;
	}

string SeqExtract::emit(std::string in) {
	bool match = false;
	std::string newString; //built string of characters not in parameter string
	unsigned atSubStart, atSubEnd; //first and last index of where substring
									// is found
	
	if (active && (in.length() < word.length())) { //substring can't be longer
		for (unsigned i = 0; i < word.length(); i++) { //go through char by char
			if ((word.at(i) == in.at(0)) &&
					((i + in.length()) <= word.length())) { //must match and have
									// enough remaining characters to evaluate.
				match = true;
				atSubStart = i;
				atSubEnd = atSubStart + in.length() - 1;
				for (unsigned j = 0, k = i; j < in.length(); j++, k++) {
					if (word.at(k) == in.at(j) && match) {
						match = true;
					} else
						match = false;
					
					}
				}
				if (match) {
					for (unsigned m = 0; m < word.length(); m++) {
						if (m < atSubStart || m > atSubEnd)
							newString += word.at(m);
					}
					return newString;
				}
		}
		return "No Match";
	}
	return "ERROR";
}

//
// Created by Craig Danz on 11/6/17.
//