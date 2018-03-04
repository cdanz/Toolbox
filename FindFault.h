// AUTHOR: Craig Danz
// FILENAME: FindFault.h
// DATE: 10/12/2017
// VERSION: 1.0
// REFERENCES (optional): all code that is not your own, other than standard libraries

// Description: -- this class creates a number of encryption objects to pass
//a word through but randomly corrupts one of the encryptions so that a user
//can guess which encryption isn't being done consistently.
//
// Assumptions:
// 5 is the ideal number of encryptions. Any more would be silly.

#include <iostream>
#include <string>
#include "EncryptWord.h"
using namespace std;
#ifndef CPSC_5011_P1_FINDFAULT_H
#define CPSC_5011_P1_FINDFAULT_H

class FindFault {
public:
    FindFault();
    // description: Constructor
    // precondition: No object
    // postcondition: New FindFault object.
    string seedWord(string);
    // description: This function runs the provided string through all
    // encapsulated EncryptWord object returning an encrypted version for
    // all but one which will be corrupted.
    // precondition: none
    // postcondition: none
    bool makeGuess(int);
    // description: Performs guess of which EncryptWord object is corrupted.
    // precondition: none
    // postcondition: none
    int getGuesses();
    // description: Returns the running total of guesses made.
    // precondition: none
    // postcondition: none
private:
    const int numEncryptWords = 5; //number of EncryptWord objects the
                                    // FindFault class will encapsulate
    int guesses; //accumulator of guesses made.
    int corrupted; //a number (randomly chosen) associated to one of the
                        //EncryptWords to be corrupted
    string corrupt(string);
};

//
// Created by Craig Danz on 10/12/17.
//


#endif //CPSC_5011_P1_FINDFAULT_H
