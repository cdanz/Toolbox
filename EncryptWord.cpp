// AUTHOR: Craig Danz
// FILENAME: EncryptWord.cpp
// DATE: 9/27/17
// VERSION: 1.1
// REFERENCES (optional):

#include "EncryptWord.h"
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

EncryptWord::EncryptWord() {
    shift = (rand() % 26) + 1;
    guesses = 0;
    highGuess = 0;
    lowGuess = 0;
    averageGuess = 0;
    on = false;
}

string EncryptWord::encrypt(string in) {
    if (in.length() < MIN_CHARS)
        return "ERROR";
    on = true;
    string out = "";
    //go through text character by character
    for (int i = 0; i < in.length(); i++) {
        //check to see if character is uppercase and return a shift that is
        //also uppercase if it is.
        if (in[i] >= 65 && in[i] <= 90)
            out += char((int(in[i])+shift-65)%26 +65);
        //if not upper, check if lower and shift to another lowercase value.
        else if (in[i] >= 97 && in[i] <= 122)
            out += char((int(in[i])+shift-97)%26 +97);
        //to stop any phrases, detection of a space will throw an error.
        else if (in[i] == 32)
            return "ERROR";
        //if the character is a non-letter than just return as is.
        else
            out += in[i];
    }

    return out;
}
string EncryptWord::decode(string in) {
    if (!on)
        return "ERROR";
    if (in.length() < MIN_CHARS)
        return "ERROR";
    string out = "";
    //go through text character by character
    for (int i = 0; i < in.length(); i++) {
        //check to see if character is uppercase and return a shift that is
        //also uppercase if it is.
        if (in[i] >= 65 && in[i] <= 90)
            out += char((int(in[i]) + (26 - shift) - 65) % 26 + 65);
            //if not upper, check if lower and shift to another lowercase value.
        else if (in[i] >= 97 && in[i] <= 122)
            out += char((int(in[i]) + (26 - shift) - 97) % 26 + 97);
            //to stop any phrases, detection of a space will throw an error.
        else if (in[i] == 32)
            return "ERROR";
            //if the character is a non-letter than just return as is.
        else
            out += in[i];
    }

    return out;
}

//Process a guess at what the shift is. takes in a number "guess", adjusts
//the statics of the guesses accordingly by incrementing the number of
//guesses, adjusting the high guess if it is a new high, adjusting low if
//new low and recalculating the average guess. Finally a boolean is returned
//true if and only if the guess is equal to the shift.
bool EncryptWord::makeGuess(int g) {
    //check to see if encryption has been used yet.
    if (!on)
        return false;
    //first guess is both the high and low guess
    if (guesses == 0) {
        highGuess = g;
        lowGuess = g;
    }
    //check for new high
    if (g > highGuess)
        highGuess = g;
    //check for new low
    if (g < lowGuess)
        lowGuess = g;
    //increment
    guesses++;
    //recalculate average
    averageGuess = ((averageGuess * (guesses - 1)) + g ) / guesses;

    return g == shift;
}


int EncryptWord::getHighGuess() const{
    //check to see if encryption has been used yet.
    if (!on)
        return -1;
    return highGuess;
}

int EncryptWord::getLowGuess() const{
    //check to see if encryption has been used yet.
    if (!on)
        return -1;
    return lowGuess;
}

double EncryptWord::getAverageGuess() const{
    //check to see if encryption has been used yet.
    if (!on)
        return -1;
    return averageGuess;
}

int EncryptWord::getGuesses() const{
    //check to see if encryption has been used yet.
    if (!on)
        return -1;
    return guesses;
}

bool EncryptWord::getOn() const {
    return on;
}

int EncryptWord::getMin() const {
    return MIN_CHARS;
}

void EncryptWord::reset() {
    //check to see if encryption has been used yet.
    if (!on)
        return;
    //reset everything, new shift, and all guess stats back to zero.
    shift = (rand() % 26) + 1;
    guesses = 0;
    highGuess = 0;
    lowGuess = 0;
    averageGuess = 0;
    on = false;
}


//
// Created by Craig Danz on 9/27/17.
//

