// AUTHOR: Craig Danz
// FILENAME: Inverter.h
// DATE: 12/8/2017
// REVISION HISTORY: 1.0
// REFERENCES (optional): Inverter.java

//
// Created by Craig Danz on 12/8/17.
//

#ifndef CPSC_5011_P1_INVERTER_H
#define CPSC_5011_P1_INVERTER_H

//This interface sets the basic requirements for classes that implement it.
//Classes that implement this interface should at a minimum encapsulate a
//word, emit an altered version of it and check its state.

#include <iostream>
#include <string>
using namespace std;

class Inverter {
		/**
		 * This is a prototype of a method that emits an adjusted version of an
		 * encapsulated word. It needs to be implemented in another class.
		 */
		virtual string emit();
		/**
		 * This is a prototype of a method that sets a word to be encapsulated
		 * in another class.
		 */
		virtual bool setWord(string in);
		/**
		 * This is a prototype of a method that checks state.
		 */
		virtual bool isOn();
};

#endif //CPSC_5011_P1_INVERTER_H
