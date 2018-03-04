// AUTHOR: Craig Danz
// FILENAME: p2.cpp
// DATE: 10/12/2017
// REVISION HISTORY: 1.0
// REFERENCES (optional): all code that is not your own, other than standard libraries
//
// Description:
// Driver adds an EncryptWord object to the stack with a word to test. Driver
// then makes a series of guesses followed by stats on the current high, low,
// and average guess along with the number of guesses that have been made.
// All actions are done by the driver and the user merely watches.
//
// Assumptions:
// EncryptWord requires words that are greater or equal to four characters
// long and will request a new word if not in compliance.

#include "FindFault.h"
#include <iostream>
#include <string>
using namespace std;

void printCorrectGuess(bool c);
// description: translates a boolean to a message that is printed to screen.
// input: takes in a boolean value either true or false representing whether
// a guess was correct (true) or wrong (false).
// processing: basic if statement to print one message if true and another
// if false.
// output: none.

string welcome = "\nWelcome to Spot the Bad Encryption (working title)!\n\n"
        "We will pass a word through a number of different versions of a "
        "caesar cipher shift. Your job will be to guess which one doesn't "
        "work properly";
string farewell = "\nWe hope you enjoyed guessing stuff. Later, tater.";

int main() {
    cout << welcome << endl;
    FindFault a;
    cout << "\nLet's try the word \"Panda\"\n";
    cout << a.seedWord("Panda") <<endl;
    cout << "\nLet's guess that it is encryption 1\n";
    printCorrectGuess(a.makeGuess(1));
    cout << a.getGuesses();
    cout << "\nLet's guess that it is encryption 2\n";
    printCorrectGuess(a.makeGuess(2));
    cout << a.getGuesses();
    cout << "\nLet's guess that it is encryption 3\n";
    printCorrectGuess(a.makeGuess(3));
    cout << a.getGuesses();
    cout << "\nLet's guess that it is encryption 4\n";
    printCorrectGuess(a.makeGuess(4));
    cout << a.getGuesses();
    cout << "\nLet's guess that it is encryption 5\n";
    printCorrectGuess(a.makeGuess(5));
    cout << a.getGuesses();
    FindFault b;
    cout << "\nOne more. Let's try the word \"troubadour\"\n";
    cout << b.seedWord("troubadour") <<endl;
    cout << "\nLet's guess that it is encryption 1\n";
    printCorrectGuess(b.makeGuess(1));
    cout << b.getGuesses();
    cout << "\nLet's guess that it is encryption 2\n";
    printCorrectGuess(b.makeGuess(2));
    cout << b.getGuesses();
    cout << "\nLet's guess that it is encryption 3\n";
    printCorrectGuess(b.makeGuess(3));
    cout << b.getGuesses();
    cout << "\nLet's guess that it is encryption 4\n";
    printCorrectGuess(b.makeGuess(4));
    cout << b.getGuesses();
    cout << "\nLet's guess that it is encryption 5\n";
    printCorrectGuess(b.makeGuess(5));
    cout << b.getGuesses();
    return 0;
}

void printCorrectGuess(bool c) {
    if (c == 1)
        cout << "You got it!" << endl;
    if (c != 1)
        cout << "Wrong!" << endl;
}

//
// Created by Craig Danz on 10/12/17.
//

