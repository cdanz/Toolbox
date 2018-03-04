// AUTHOR: Craig Danz
// FILENAME: EncryptWord.h
// DATE: 9/27/2017
// Version: 1.0
// REFERENCES (optional):

// Description: -- instances of this class perform a caesar
// shift cipher on strings, emitting an encrypted version of the string. It
// allows the client to guess the value of the shift being performed and
// maintains statistics on the number of guesses along with the high, low and
// average guess made. The function that takes in a guess updates stats based
// on the guess and returns a boolean value indicating if the client's guess is
// correct or not.
// Legal States: There are two states, on and off. The purpose of these states
// is only to indicate if the instance of this object is available to make
// guesses as to the shift. Upon initialization, an instance of the EncryptWord
// class will be set to "off". The very first word proffered to be encrypted
// will switch the state of an instance to "on". The decode function will also
// turn the instance "on" if it is called while still in an "off" state. It will
// remain "on" no matter how many different words are proffered to be encrypted
// or decrypted. While in an "off" state, any attempts to use guessing functions
// or retrieval of guess statistics will return errors. The only way to return an
// instance to an "off" state from an "on" is to reset it which also
// reinitializes stats back to zero.
// Dependancies: There are no dependencies for this class.
// Anticipated Use: This class is designed to be used in an encryption guessing
// game. By either presenting encrypted or decrypted versions of strings, the
// application programmer is expected to prompt guesses from a user and report
// back the accuracy of their guess.
// Data Processed: This class takes in and returns string values for encryption
// and decryption. It works with integers that are both signed and unsigned as
// well as doubles where appropriate for guessing shifts and providing stats.
// Legal Input: Strings must be at least 4 characters long and whitespace is not
// accepted (will return error). Guesses greater than the number of letters in
// the alphabet (>26) are legal but are nonsensical in this class as shifts wrap
// from z back to a where appropriate. A nonsense guess will not error but will
// just be reported back as incorrect. Guess arguments are unsigned so they will
// not accept negative numbers.
// Output: This class emits strings that are encrypted or decrypted by the shift
// the only numerals emited are stats. The class will never output the answer
// (what the shift is), it will only confirm if a guess is correct.
//
// Assumptions:
// Application programmer will adhere to programming by contract principles.
// Although some functions will return errors or a nonsensical "-1" value for
// illegal guesses, application programmer should not assume defensive
// programming will catch all illegal function calls or illegal arguments.
// Application programmer is responsible for checking the state before calling
// functions that are dependent on the state.

#include <iostream>
#include <string>
using namespace std;
#ifndef CPSC_5011_P1_ENCRYPTWORD_H
#define CPSC_5011_P1_ENCRYPTWORD_H

class EncryptWord {
    public:
        EncryptWord();
        // description: Constructor
        // precondition: No object
        // postcondition: New EncryptWord object, EncryptWord begins as off,
        // all stats initialized to zero.
		explicit EncryptWord(unsigned);
		// description: The single argument of this constructor is a shift that
		// the programmer forces the object to have rather than letting a
		// random number generator decide.
		// legal arguments: must be less than the total number of letters in
		// the alphabet (26).
		// precondition: No object
		// postcondition: New EncryptWord object, EncryptWord begins as off,
		// all stats initialized to zero.
		EncryptWord& operator = (const EncryptWord &);
		// description: overloaded assignment operator.
		// precondition: None
		// postcondition: On if the the assigning object is on and off if it is
		// off.
        string encrypt(string);
        // description: This function applies a caesar cipher shift. It
        // takes in text as a string and returns a string with each
        // character transformed by shifting characters by their ascii
        // value over in the amount dictated by the shift variable privately
		// stored in the object's instance.
        // legal inputs: string must be 4 characters or more. 3 characters or
        // fewer will throw an error. Any character other than a letter will
        // throw an error.
        // precondition: On or off
        // postcondition: Object is on.
        string decode(string);
        // description: This function will undo a shift but most accurately it
		// shifts each letter in a string back by the shift value rather than
		// forward like encrypt does. It takes in text as a string and returns a
		// string with each character transformed by shifting characters back by
		// their ascii value in the amount dictated by the privately
		// stored shift variable.
        // legal inputs: string must be 4 characters or more. 3 characters or
		// fewer will throw an error. Any character other than a letter will
		// throw an error.
        // precondition: On or off
        // postcondition: Object is on.
        bool makeGuess(unsigned);
        // description: performs a "guess" taking in an interger representing
        // the guess of the shift being performed. Returns true if and only if
		// the argument proffered is exactly equal to the privately incapsulated
		// shift value.
		// legal inputs: Accepts all unsigned ints.
        // precondition: object is on.
        // postcondition: object is on.
        double getAverageGuess() const;
        // description: getter for the calculated average that the object
        // tracks for guesses through the makeGuess function.
        // precondition: object is on.
        // postcondition: object is on.
        int getHighGuess() const;
        // description: getter for the stored value of highest guess made
		// through the makeGuess fuction.
        // precondition: object is on.
        // postcondition: object is on.
        int getLowGuess() const;
        // description: getter for the stored value of lowest guess made through
		// the makeGuess fuction.
        // precondition: object is on.
        // postcondition: object is on.
        int getGuesses() const;
        // description: getter for the stored value number of guesses made
		// through the makeGuess fuction.
        // precondition: object is on.
        // postcondition: object is on.
        bool getOn() const;
        // description: getter of boolean "on" value. True if on, false if off.
        // precondition: none.
        // postcondition: none.
        void reset();
        // description: resets the EncryptedWord object back to its originally
        // initialized state with a new shift value and all stats zeroed out.
        // precondition: on or off.
        // postcondition: object is off.
    private:
        const unsigned MIN_CHARS = 4; //minimum number of characters
										// allowed
		const int UPCASEA = 65; //The lower end of the uppercase ascii
										// numbers
		const int UPCASEZ = 90; //The upper end of the uppercase ascii
										// numbers
		const int LOWCASEA = 97; //The lower end of the lowercase ascii
										// numbers
		const int LOWCASEZ = 122; //The upper end of the lowercase ascii
										// numbers
		const unsigned ABC = 26; //The number of letters in the alphabet
        unsigned shift; //the number used to shift-by in the caesar shift.
        int guesses; //accumulator of guesses made.
        unsigned highGuess; //tracks highest guess made offered through
										// makeGuess()
		unsigned lowGuess; //tracks lowest guess made offered through
										// makeGuess()
        double averageGuess; //tracks calculated average of guesses
        bool on; //State is "On" if true and "off" if false.
        string text; //string of text to be worked with and encrypted.
};

#endif //CPSC_5011_P1_ENCRYPTWORD_H


