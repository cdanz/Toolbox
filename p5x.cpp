// AUTHOR: Craig Danz
// FILENAME: p5x.cpp
// DATE: 12/8/2017
// REVISION HISTORY: 1.0
// REFERENCES (optional): p5.java

//
// Created by Craig Danz on 12/8/17.
//

/**
 * This class demonstrates the functionality of three different objects
 * (SequenceEnum, SeqExtract, SpasEnum) which all extend the functionality
 * of their base/parent class Sequence. Sequence also implements Inverter.
 * The interplay of the relationships amongst these 5 classes is what is being
 * looked at here.
 * @author danzc
 */

#include "Sequence.h"
#include "SequenceEnum.h"
#include "SeqExtract.h"
#include "SpasEnum.h"
#include <iostream>
#include <typeinfo>
#include <cstdlib>
#include <string>
using namespace std;

/**
 * Welcomes the user with a friendly message.
 */
void welcome() {
	cout << "\n--------------------------------\n\n"
			"   P5 - The Final Frontier\n\n"
			"---------------------------------\n\n"
			"A Craig Danz Production\n";
}

/**
 * Bids the user farewell before exiting the program.
 */
void farewell()
{
	cout << "\n\nWe hope you enjoyed playing with some classes!\n\n";
}

/**
 * This method checks to see if the user wants to perform an action again
 * specified by the message passed to it.
 * @param msg			What do you want them to repeat?
 * @return boolean		If a desire to repeat : true else false.
 */
bool repeat(const string msg) {
	string input;
	char repeat;
	
	cout << msg;
	cin >> input;
	repeat = input.at(0);
	return (repeat == 'y' || repeat == 'Y');
}

/**
 * This helper method creates a subsequence of a string parameter.
 * @param s				String to pull a subsequence from
 * @return String		Subsequence of string.
 */
std::string subSequence(std::string s) {
	string newString = "";
	unsigned atSubStart = (rand() % s.length()) - 1;
	unsigned atSubEnd = 0;
	do {
		atSubEnd = rand() % s.length();
	} while (atSubEnd <= atSubStart); //Make sure you get a character index
	// greater than the start.
	
	for (unsigned j = 0; j < (atSubEnd - atSubStart + 1); j++) {
		newString += s.at(atSubStart + j);
	}
	return newString;
}

const unsigned SIZE = 12; //Size of collection
	
	/**
	 * This main method acts as the driver of the program.
	 */
int main() {
		welcome();
		do {
			string providedWord; //user determined word
			do {
				cout << "What word would you like to use that is "
								 "at least 3 characters long?: ";
				cin >> providedWord;
			} while (providedWord.length() < 3);
			Sequence ** collection = new Sequence*[SIZE];
			for(unsigned i = 0; i < sizeof(collection); i++) {
				if (i % 4 == 0) //4 because I have 4 class types I would
					//like to cycle through to demonstrate
					collection[i] = new Sequence();
				else if (i % 4 == 1)
					collection[i] = new SequenceEnum();
				else if (i % 4 == 2)
					collection[i] = new SeqExtract();
				else
					collection[i] = new SpasEnum();
			}
			cout << "\nAll objects should be inactive initially.";
			for(unsigned i = 0; i < sizeof(collection); i++) {
				cout << "\nElement " << (i + 1) << " - Active?: " <<
					 collection[i]->isOn();
			}
			cout << "\n\nNow initialize with the word " <<
							   providedWord << ".";
			for(unsigned i = 0; i < sizeof(collection); i++) {
				collection[i]->setWord(providedWord);
			}
			cout << "\n\nAnd all objects should now be active.";
			for(unsigned i = 0; i < sizeof(collection); i++) {
				cout << "\nElement " << (i + 1) << " - Active?: "
					 				<< collection[i]->isOn();
			}
			cout << "\n\nLet's see what each emits.";
			for(unsigned i = 0; i < sizeof(collection); i++) {
				cout << "\nElement " << (i + 1) << " - " <<
								   collection[i]->emit();
			}
			cout << "\n\nTest Guess:";
			for(unsigned i = 0; i < sizeof(collection); i++) {
				Sequence s = * collection[i];
				cout << "\nElement " << (i + 1) << " - Guess " <<
								   providedWord << " - "
					 				<< s.guess(providedWord);
			}
			cout << "\n\nTest Reset:";
			for(unsigned i = 0; i < sizeof(collection); i++) {
				Sequence s = * collection[i];
				s.reset();
				cout << "\nElement " << (i + 1) << " - Reset. Active? - "
					 		<< s.isOn();
			}
			for(unsigned i = 0; i < sizeof(collection); i++) {
				collection[i]->setWord(providedWord);
			}
			cout << "\n\nTwo classes have functions unique to them.";
			cout << "\nFind them and test them:";
			SeqExtract q;
			SpasEnum p;
			for(unsigned i = 0; i < sizeof(collection); i++) {
				if (typeid(* collection[i]) == typeid(q)) {
					//test overloaded emit
					SeqExtract s = dynamic_cast<SeqExtract&>(* collection[i]);
					cout << "\nElement " << (i + 1) << " - Overloaded emit: " <<
									   s.emit(subSequence(providedWord));
				}
				else if (typeid(* collection[i]) == typeid(p)) {
					//test overloaded emit
					SpasEnum s = dynamic_cast<SpasEnum&>(* collection[i]);
					cout << "\nElement " << (i + 1) << " - Alternative emit: "
									<< s.emitTrunc();
				}
				else
					cout << "\nElement " << (i + 1) << " - Nothing special.";
			}
			cout << "\n\nThat's all the functionality to test.";
		} while (repeat("\n\nWould you like to run through this again? Y/N: "));
		farewell();
		return 0;
}
