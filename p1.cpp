// AUTHOR: Craig Danz
// FILENAME: p1.cpp
// DATE: 9/27/2017
// VERSION: 1.1
// REFERENCES (optional):
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

#include "EncryptWord.h"
#include <iostream>
#include <string>
using namespace std;

void printGuesses(EncryptWord &);
// description: this function prints to screen basic stats on the guesses
// that have been made
// input: takes in an EncryptWord object
// processing: uses the EncryptedWord classes getters to print the stats to
// the screen.
// output: none.

void printCorrect(bool c);
// description: translates a boolean to a message that is printed to screen.
// input: takes in a boolean value either true or false representing whether
// a guess was correct (true) or wrong (false).
// processing: basic if statement to print one message if true and another
// if false.
// output: none.

void speedGuess(EncryptWord &);
// description: Runs through every guess from 1 - 26 until the correct shift
// is found.
// input: An EncryptWord object.
// processing: traverses every possible guess until the correct one is found.
// output: none.

string welcome = "\nWelcome to Little Caesar's Cipher!\n\n"
                    "Feast your eyes on the wonder of my encryption class.\n";
string farewell = "\nWe hope you enjoyed encrypting stuff. Later, tater.";

int main() {
    cout << welcome << endl;
    cout << "\nGenerating 5 different encryption objects...";
    EncryptWord a;
    EncryptWord b;
    EncryptWord c;
    EncryptWord d;
    EncryptWord e;
    cout << "\n\nDone. Each will encrypt using a different cipher shift so "
         "the results of \nthe encryption will be unique for each. "
         "Let's try running the same words \nthrough different "
         "encryption objects.\n" << endl;
    cout << "Encrypting \"Candy\":\n" <<
         "Encyption A: " <<a.encrypt("Candy") << "\n" <<
         "Encyption B: " <<b.encrypt("Candy") << "\n" <<
         "Encyption C: " <<c.encrypt("Candy") << "\n" <<
         "Encyption D: " <<d.encrypt("Candy") << "\n" <<
         "Encyption E: " <<e.encrypt("Candy") << "\n" <<endl;
    cout << "We can then use the decode function to decrypt these "
         "encrypted strings:\n" <<
         "Encyption A: " <<a.decode(a.encrypt("Candy")) << "\n" <<
         "Encyption B: " <<b.decode(b.encrypt("Candy")) << "\n" <<
         "Encyption C: " <<c.decode(c.encrypt("Candy")) << "\n" <<
         "Encyption D: " <<d.decode(d.encrypt("Candy")) << "\n" <<
         "Encyption E: " <<e.decode(e.encrypt("Candy")) << "\n" <<endl;
    cout << "Encryption is case sensitive. Encrypting \"cAnDy\":\n" <<
         "Encyption A: " <<a.encrypt("cAnDy") << "\n" <<
         "Encyption B: " <<b.encrypt("cAnDy") << "\n" <<
         "Encyption C: " <<c.encrypt("cAnDy") << "\n" <<
         "Encyption D: " <<d.encrypt("cAnDy") << "\n" <<
         "Encyption E: " <<e.encrypt("cAnDy") << "\n" <<endl;
    cout << "It can do long words. Encrypting "
            "\"Supercalifragilisticexpialidocious\":\n" <<
         "Encyption A: " <<a.encrypt(
            "Supercalifragilisticexpialidocious") << "\n" <<
         "Encyption B: " <<b.encrypt(
            "Supercalifragilisticexpialidocious") << "\n" <<
         "Encyption C: " <<c.encrypt(
            "Supercalifragilisticexpialidocious") << "\n" <<
         "Encyption D: " <<d.encrypt(
            "Supercalifragilisticexpialidocious") << "\n" <<
         "Encyption E: " <<e.encrypt(
            "Supercalifragilisticexpialidocious") << "\n" <<endl;
    cout << "It can do short. Encrypting \"ball\":\n" <<
         "Encyption A: " <<a.encrypt("ball") << "\n" <<
         "Encyption B: " <<b.encrypt("ball") << "\n" <<
         "Encyption C: " <<c.encrypt("ball") << "\n" <<
         "Encyption D: " <<d.encrypt("ball") << "\n" <<
         "Encyption E: " <<e.encrypt("ball") << "\n" <<endl;
    cout << "But - completely arbitrarily - it can't do too short. "
         << "Must be at least \n" << c.getMin() <<
         " characters long or this happens. Encrypting \"Nah\":\n" <<
         "Encyption A: " <<a.encrypt("Nah") << "\n" <<
         "Encyption B: " <<b.encrypt("Nah") << "\n" <<
         "Encyption C: " <<c.encrypt("Nah") << "\n" <<
         "Encyption D: " <<d.encrypt("Nah") << "\n" <<
         "Encyption E: " <<e.encrypt("Nah") << "\n" <<endl;
    cout << "Another arbitrary rule - words only. No phrases! So help me, "
         << "if I see a phrase \nshow up you'll get another ERROR! "
         << "Encrypting \"Illegal for no reason\":\n" <<
         "Encyption A: " <<a.encrypt("Illegal for no reason") << "\n" <<
         "Encyption B: " <<b.encrypt("Illegal for no reason") << "\n" <<
         "Encyption C: " <<c.encrypt("Illegal for no reason") << "\n" <<
         "Encyption D: " <<d.encrypt("Illegal for no reason") << "\n" <<
         "Encyption E: " <<e.encrypt("Illegal for no reason") << "\n" <<endl;
    cout << "Here's a trick though, any other symbols or characters are \n"
        "totally cool. Only spaces throw an error, anything other than \n"
        "an upper or lowercase letter passes through without a shift.\n"
         << "Numbers and symbols pass through. "
         << "Encrypting \n\"Totally_legal*4_you.2~use*these#Loopholes\":\n" <<
         "Encyption A: " <<a.encrypt(
            "Totally_legal*4_you.2~use*these#Loopholes") << "\n" <<
         "Encyption B: " <<b.encrypt(
            "Totally_legal*4_you.2~use*these#Loopholes") << "\n" <<
         "Encyption C: " <<c.encrypt(
            "Totally_legal*4_you.2~use*these#Loopholes") << "\n" <<
         "Encyption D: " <<d.encrypt(
            "Totally_legal*4_you.2~use*these#Loopholes") << "\n" <<
         "Encyption E: " <<e.encrypt(
            "Totally_legal*4_you.2~use*these#Loopholes") << "\n" <<endl;
    cout << "Each encryption's shift is randomly chosen from 1 - 26. These "
        "objects allow \nyou to attempt to guess the shift and they will "
        "report back if you are \ncorrect.";
    cout << "\n\nGuessing a shift of 15:\n" <<
         "Encyption A: ";
    printCorrect(a.makeGuess(15));
    cout << "Encyption B: ";
    printCorrect(b.makeGuess(15));
    cout << "Encyption C: ";
    printCorrect(c.makeGuess(15));
    cout << "Encyption D: ";
    printCorrect(d.makeGuess(15));
    cout << "Encyption E: ";
    printCorrect(e.makeGuess(15));
    cout << "\nGuessing a shift of 4:\n" <<
         "Encyption A: ";
    printCorrect(a.makeGuess(4));
    cout << "Encyption B: ";
    printCorrect(b.makeGuess(4));
    cout << "Encyption C: ";
    printCorrect(c.makeGuess(4));
    cout << "Encyption D: ";
    printCorrect(d.makeGuess(4));
    cout << "Encyption E: ";
    printCorrect(e.makeGuess(4));
    cout << "\nGuessing a shift of 9:\n" <<
         "Encyption A: ";
    printCorrect(a.makeGuess(9));
    cout << "Encyption B: ";
    printCorrect(b.makeGuess(9));
    cout << "Encyption C: ";
    printCorrect(c.makeGuess(9));
    cout << "Encyption D: ";
    printCorrect(d.makeGuess(9));
    cout << "Encyption E: ";
    printCorrect(e.makeGuess(9));
    cout << "\nYou can keep track of your guesses by accessing various "
        "statistics. This \nclass tracks total guesses, high guess, low "
        "guess, and average guess. \n\nHere are the current stats for "
        "each encryption:\n"
        "Encryption A:\n";
    cout << "\nEncyption A: ";
    printGuesses(a);
    cout << "Encyption B: ";
    printGuesses(b);
    cout << "Encyption C: ";
    printGuesses(c);
    cout << "Encyption D: ";
    printGuesses(d);
    cout << "Encyption E: ";
    printGuesses(e);
    cout << "\nThere is the option to reset an encryption object. Resetting "
         "reinitializes \nall of the stats back to zero but also randomly "
         "chooses a new shift to use \nwith encryption. There is also a "
         "concept for the encryption object being \neither on or off. When "
         "the object is originally initialized or reset it is \noff but as "
         "soon as it encrypts a word it is turned on. While an object is \n"
         "off you will be unable to retrieve any stats.\n\nRecall that "
         "encryption object \"A\" encrypted \"Candy\" as "
         << a.encrypt("Candy") << ". \nNow let's reset it." << endl;
    a.reset();
    cout << "\nDone. Is this thing on? (1 = True, 0 = False): " << a.getOn()
         << ". None of our stats should \nwork while off. All stat "
        "functions return -1 when there is an error: \n";
    printGuesses(a);
    cout << "Encrypt \"Candy\" again, this time it should be different: \n"
         << a.encrypt("Candy");
    printGuesses(a);
    cout << "Guessing one by one takes a while, let's speed it up by "
        "going through every \npossible guess with a loop and reporting back "
        "when we find it.";
    cout << "\n\nEncyption A: ";
    speedGuess(a);
    cout << "Encyption B: ";
    speedGuess(b);
    cout << "Encyption C: ";
    speedGuess(c);
    cout << "Encyption D: ";
    speedGuess(d);
    cout << "Encyption E: ";
    speedGuess(e);
    cout << farewell << endl;
    return 0;
}

void printGuesses(EncryptWord &thing)
{
    cout << "Guesses: " << thing.getGuesses() <<
        ", High: " << thing.getHighGuess() <<
        ", Low: " << thing.getLowGuess() <<
        ", Average: " << thing.getAverageGuess() << "\n" << endl;
}

void printCorrect(bool c) {
    if (c == 1)
        cout << "You got it!" << endl;
    if (c != 1)
        cout << "Wrong!" << endl;
}

void speedGuess(EncryptWord &thing) {
    int i = 1;
    while (!thing.makeGuess(i))
        i++;
    cout << "Shift is " << i << endl;
    printGuesses(thing);
}