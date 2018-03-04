// AUTHOR: Craig Danz
// FILENAME: p4.cpp
// DATE: 11/6
// REVISION HISTORY: 1.0
// REFERENCES (optional):
//
// Description: Driver for three other classes demonstrating encapsulation in a
// 'is-a' relationship. There is one base/parent/bottom and two classes that are
// children that have an 'is-a' relationship to the parent but do not have a
// relationship to eachother. This driver demonstrates their functionality and
// how functionality can be inherited.
//
//
// Assumptions:
// It is okay for the Application Programmer to know the word being set even
// though it would make guessing easy for her.

//#include "SequenceEnum.h"
//#include "SeqExtract.h"
//#include "SpasEnum.h"
/*
#include <iostream>
#include <string>
using namespace std;

class Base
{
	int x;
public:
	virtual void fun() = 0;
	int getX() { return x; }
};

// This class ingerits from Base and implements fun()
class Derived: public Base
{
	int y;
public:
	void fun() override { cout << "fun() called\n"; }
};

int main(void)
{
	Base * bp = new Derived();
	bp->fun();
	return 0;
}
*/
/*
int main() {



std::string inputString1, inputString2, inputString3, inputString4,
		inputStringTemp;

string welcome = "\nWelcome to the 'is-a' relationship driver!\n"
		"Let's demonstrate some aspects of inheritence.\n";
string farewell = "\nWe hope you enjoyed seeing inheritence in action. "
		"Later, tater.";
cout << welcome << endl;

SequenceEnum parentObj1; //Only one we will work with directly as parent obj
SequenceEnum parentObj2; //Only used to confirm string proffered is valid.
SequenceEnum parentObj3; //Only used to confirm string proffered is valid.
SequenceEnum parentObj4; //Only used to confirm string proffered is valid.
cout << "Is the initialized SequenceEnum obj Active?: " <<
	 (parentObj1.isOn() == 0 ? "FALSE" : "TRUE") << endl;
cout << "\nStart by providing a few words with more than 3 characters to "
		"work with.\n";
do {
	cout << "First word: ";
	cin >> inputString1 ;
} while (!parentObj1.setWord(inputString1));
do {
	cout << "Second word: ";
	cin >> inputString2 ;
} while (!parentObj2.setWord(inputString2));
do {
	cout << "Third word: ";
	cin >> inputString3 ;
} while (!parentObj3.setWord(inputString3));
do {
	cout << "Fourth (and final) word: ";
	cin >> inputString4 ;
} while (!parentObj4.setWord(inputString4));
cout << "\nWords are:\n1: " << inputString1 << "\n2: " << inputString2 <<
	 "\n3: " << inputString3 << "\n4: " <<inputString4 << endl;

cout << "\nNow that the SequenceEnum obj has been set, is it Active?: " <<
	 (parentObj1.isOn() == 0 ? "FALSE" : "TRUE") << endl;
cout << "Test emission: " << parentObj1.emit() << endl;
cout << "Emission can change, test again: " << parentObj1.emit() << endl;
cout << "And again: " << parentObj1.emit() << endl;

cout << "\nNow we can guess the set word. Guess correctly: " <<
	 (parentObj1.guess(inputString1) ? "Correct!" : "Swing and a miss.")
	 << endl;
cout << "Guess incorrectly: " <<
	 (parentObj1.guess(inputString2) ? "Correct!" : "Swing and a miss.")
	 << endl;
cout << "\nNow we'll reset the object..." << endl;
parentObj1.reset();
cout << "Attempt emission from inactive: "<< parentObj1.emit() << endl;
cout << "Attempt Guess?: " << (parentObj1.guess(inputString1)
											   ? "True" : "False") << endl;
cout << "\nBut we can set the word again. Let's use \"" << inputString3
	 << "\"" << endl;
parentObj1.setWord(inputString3);
cout << "And then emittion functions properly again: "<<
	 parentObj1.emit() << endl;
cout << "As well as the guess. Guessing \"" << inputString3 << "\": " <<
	 (parentObj1.guess(inputString3) ? "True" : "False") << endl;
cout << "\nNow for a child. SeqExtract first." << endl;
SeqExtract childObj1;
cout << "Is the initialized SeqExtract obj Active?: " <<
	 (childObj1.isOn() == 0 ? "FALSE" : "TRUE") << endl;
cout << "\nNow set the child using \"" << inputString2
	 << "\"" << endl;
childObj1.setWord(inputString2);
cout << "Test emission by providing a substring of " << inputString2 <<
																	 endl;
cout << "Substring: ";
cin >> inputStringTemp;
cout << "\nIf \"" << inputStringTemp << "\" is a valid substring, all "
		"characters not in \nthe substring are emitted: " <<
	 childObj1.emit(inputStringTemp) << endl;
cout << "Access parent's emit function with child as the calling object: "
	 << childObj1.SequenceEnum::emit() << endl;
cout << "Access parent's guess function with child as the calling object: "
	 << (childObj1.guess(inputString2) ? "TRUE" : "FALSE") << endl;
cout << "Access parent's reset function with child as the calling object."
	  << endl;
childObj1.reset();
cout << "Is child obj Active?: " <<
	 (childObj1.isOn() == 0 ? "FALSE" : "TRUE") << endl;
cout << "Test emission of inactive object by providing a substring of "
		 << inputString2 << endl;
cout << "Substring: ";
cin >> inputStringTemp;
cout << "Even if " << inputStringTemp << " is a valid substring the object "
		"is inactive and should return \nan ERROR: " <<
	 childObj1.emit(inputStringTemp) << endl;
cout << "Attempt Guess?: " << (childObj1.guess(inputString1)
							   ? "True" : "False") << endl;
cout << "\nBut we can set the word again. Let's use \"" << inputString4
	 << "\"" << endl;
childObj1.setWord(inputString4);
cout << "Use same substring \"" << inputStringTemp << "\": " <<
	 childObj1.emit(inputStringTemp) << endl;

cout << "\nNow for the other child, SpasEnum." << endl;
SpasEnum childObj2;
cout << "Is the initialized SpasEnum obj Active?: " <<
	 (childObj2.isOn() == 0 ? "FALSE" : "TRUE") << endl;
cout << "\nNow set the child using \"" << inputString3
	 << "\"" << endl;
childObj2.setWord(inputString3);
cout << "Test emission: " <<
	 childObj2.emit() << endl;
cout << "Test emission of second type of emission - just substring: " <<
	 childObj2.emitTrunc() << endl;
cout << "Two more just to be sure, 1: " <<
	 childObj2.emitTrunc() << endl;
cout << "And 2: " <<
	 childObj2.emitTrunc() << endl;
cout << "Access parent's emit function with child as the calling object: "
	 << childObj2.SequenceEnum::emit() << endl;
cout << "Access parent's guess function with child as the calling object: "
	 << (childObj2.guess(inputString3) ? "True" : "False") << endl;
cout << "Access parent's reset function with child as the calling object."
	 << endl;
childObj2.reset();
cout << "Is child obj Active?: " <<
	 (childObj2.isOn() ? "TRUE" : "FALSE") << endl;
cout << "Test emission of inactive: " <<
	 childObj2.emit() << endl;
cout << "Second emission type of inactive: " <<
	 childObj2.emitTrunc() << endl;
cout << "Attempt Guess?: " << (parentObj1.guess(inputString1)
							   ? "True" : "False") << endl;
cout << "\nBut we can set the word again. Let's use \"" << inputString4
	 << "\"" << endl;
childObj2.setWord(inputString4);
cout << "Test emission: " << childObj2.emit() << endl;
cout << "Test 2nd emission type: " << childObj2.emitTrunc() << endl;

cout << farewell << endl;

	
	return 0;
}*/
//
// Created by Craig Danz on 11/6/17.
//

