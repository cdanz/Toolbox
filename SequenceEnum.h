// AUTHOR: Craig Danz
// FILENAME: SequenceEnum.h
// DATE: 11/6/2017
// REVISION HISTORY: 2.0
// REFERENCES (optional): SequenceEnum.java


#ifndef CPSC_5011_P1_SEQUENCEENUM_H
#define CPSC_5011_P1_SEQUENCEENUM_H


#include "Sequence.h"
#include <iostream>
#include <string>
using namespace std;

class SequenceEnum : public Sequence{
public:
	SequenceEnum();
	// description: constructor
	// precondition: no object
	// postcondition: inactive - no word set.
	string emit();
	// description: returns string representing the set word after being
	// manipulated in a way that is unique to this object. This object chooses
	// a single character in the set string and repeats it in the returned
	// value.
	// precondition: active
	// postcondition: active

private:


};
#endif //CPSC_5011_P1_SEQUENCEENUM_H

//
// Created by Craig Danz on 11/6/17.
//

