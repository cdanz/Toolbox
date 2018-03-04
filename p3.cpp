// AUTHOR: Craig Danz
// FILENAME: p3.cpp
// DATE: 10/27/2017
// VERSION: 1.0
// REFERENCES (optional):
// Description:
// Driver demonstrates the functionality of the FindFault class which now has
// a number of overloaded operators to work with and allows you to use some of
// the overloaded operators of the incapsulated EncryptWord class.
//
// Assumptions:
// EncryptWord requires words that are greater or equal to four characters
// long and will request a new word if not in compliance. Arithemetic operators
// merge two findfault classes together and combines the stats so if you have
// three guesses on one FindFault object and four on the other, both adding
// and subtracting will result in your guesses now equaling 7. Without exception
// though, all operators that are destructive only destroy the left operand
// while leaving the right intact.
/*
#include "FindFault.h"
#include <iostream>
#include <string>
using namespace std;

int main() {
	string welcome = "\nWelcome to Little Caesar's Cipher!\n\n"
			"We got some new tricks up our sleeves.\n";
	string farewell = "\nWe hope you enjoyed encrypting stuff and operating "
			"all over it. Later, tater.";
    cout << welcome << endl;
    cout << "We have overloaded a bunch of operators, lets check them out."
		 	<< endl;
	cout << "\nStart by initializing three find fault objects of different "
			"sizes and seeding \nthem with the words \"candleabra\", "
			"\"shoebox\", \"kafkaesque\"" << endl;
	FindFault a;
    FindFault b(7);
	FindFault c(3);
	cout << "Collection A of \"candleabra\":\n" << a.seedWord("candleabra")
		 << endl;
	cout << "Collection B of \"shoebox\":\n" << b.seedWord("shoebox") << endl;
	cout << "Collection C of \"kafkaesque\":\n" << c.seedWord("kafkaesque")
		 << endl;
	cout << "\nYou can add two collections together so that one shift can be "
			"added to the \nother resulting in a combined shift." << endl;
	a + b;
	cout << "A + B: \n" << a.seedWord("candleabra") << endl;
	cout << "Notice that when you combine a collection of 5 EncryptWords with "
			"a collection \nof 7, the result is a collection of 7. Whenever "
			"you use an arithmetic operator \nthe resulting object's array is "
			"the size of the largest array involved." << endl;
	cout << "\nYou can also subtract, let's undo the combined shift with "
			"A - B:" << endl;
	a - b;
	cout << a.seedWord("candleabra") << endl;
	cout << "You can increment. Shifting each shift one more." << endl;
	a++;
	cout << a.seedWord("candleabra") << endl;
	cout << "Or deincrement. Shifting them all back." << endl;
	a--;
	cout << a.seedWord("candleabra") << endl;
	cout << "We also have relational operators that compare the FindFault "
			"array sizes." << endl;
	cout << "\nTesting A (Array size 7) < C (Array size 3): " <<
		 (a<c?"True":"False") << endl;
	cout << "\nTesting A (Array size 7) > C (Array size 3): " <<
		 (a>c?"True":"False") << endl;
	cout << "\nTesting A (Array size 7) == B (Array size 7): " <<
		 (a==b?"True":"False") << endl;
	cout << "\nTesting A (Array size 7) == C (Array size 3): " <<
		 (a==c?"True":"False") << endl;
	cout << "\nYou can also manipulate and compare EncryptWord elements "
			"within FindFault \nby passing the element numbers as an "
			"argument." << endl;
	cout << "Here is what A currently looks like: \n" <<
			a.seedWord("candleabra") << endl;
	cout << "Add encryption 2 and 5 together." << endl;
	a.add(2,5);
	cout << "Here is the result, left operand is changed while right remains: "
			"\n" << a.seedWord("candleabra") << endl;
	cout << "Now subtract to return it back." << endl;
	a.subtract(2,5);
	cout << "Here is the result of Encryption 2 - Encryption 5:"
			"\n" << a.seedWord("candleabra") << endl;
	cout << "Next, let's compare elements within a collection." << endl;
	cout << "Compare the shift of Encryption 3 with 6. " << endl;
	cout << "Encryption 3 < Encryption 6: " << (a.lessthan(3,6) ? "True" :
												"False") << endl;
	cout << "Encryption 3 > Encryption 6: " << (a.greaterthan(3,6) ? "True" :
												"False") << endl;
	cout << "Encryption 3 == Encryption 6: " << (a.equalto(3,6) ? "True" :
												 "False") << endl;
	cout << "Encryption 1 and 6 happen to be the same, let's try those: "
		 << (a.equalto(1,6) ? "True" :
												 "False") << endl;
    cout << farewell << endl;

    return 0;
}


//
// Created by Craig Danz on 10/29/17.
//
*/
