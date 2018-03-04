// AUTHOR: Craig Danz
// FILENAME: FindFault.cpp
// DATE: 10/12/2017
// REVISION HISTORY: 1.0
// REFERENCES (optional):

// Description: -- Has-A relationship to the EncryptWord class. FindFault
// creates a collection of EncryptWord objects in an array. The point of this
// class is to corrupt just one of the EncryptWord objects so a user can guess
// which one it is. EncryptWord objects don't corrupt themselves so a private
// "corrupt" function is used. Other functions are used to facilitate guesses.
/*
#include "FindFault.h"
#include "EncryptWord.h"
#include <iostream>
#include <cstdlib>
#include <string>
using namespace std;

FindFault::FindFault(unsigned el) {
	numEncryptWords = el;
    corrupted = (rand() % numEncryptWords) + 1;
	eWords = new EncryptWord[numEncryptWords];
    guesses = 0;
}
FindFault::~FindFault() {
	delete [] eWords;
}
FindFault::FindFault(const FindFault &obj){
	this->corrupted = obj.corrupted;
	this->guesses = obj.guesses;
	this->eWords = new EncryptWord[numEncryptWords];
	for (unsigned i = 0; i < numEncryptWords; i++)
		this->eWords[i] = obj.eWords[i];
}

FindFault& FindFault::operator = (const FindFault &obj){
	if (this != &obj)
	{
		delete [] eWords;
		this->corrupted = obj.corrupted;
		this->guesses = obj.guesses;
		this->eWords = new EncryptWord[numEncryptWords];
		for (unsigned i = 0; i < numEncryptWords; i++)
			this->eWords[i] = obj.eWords[i];
	}
	return *this;
}

FindFault FindFault::operator + (const FindFault &obj){
	this->guesses += obj.guesses;
	if (obj.numEncryptWords <= this->numEncryptWords) {
		for (unsigned i = 0; i < obj.numEncryptWords; i++){
			this->eWords[i] + obj.eWords[i];
		}
	}
	else {
		resize(obj.numEncryptWords);
		for (unsigned i = 0; i < numEncryptWords; i++) {
			this->eWords[i] + obj.eWords[i];
		}
	}
	return *this;
}

FindFault FindFault::operator - (const FindFault &obj){
	this->guesses += obj.guesses;
	if (obj.numEncryptWords <= this->numEncryptWords) {
		for (unsigned i = 0; i < obj.numEncryptWords; i++){
			this->eWords[i] - obj.eWords[i];
		}
	}
	else {
		resize(obj.numEncryptWords);
		for (unsigned i = 0; i < numEncryptWords; i++) {
			this->eWords[i] + obj.eWords[i];
		}
	}
	return *this;
}

FindFault FindFault::operator ++ (){
	for(unsigned i = 0; i < this->numEncryptWords; i++)
		eWords[i]++;
	return *this;
}

FindFault FindFault::operator ++ (int){
	FindFault temp(*this);
	for(unsigned i = 0; i < this->numEncryptWords; i++)
		eWords[i]++;
	return temp;
}

FindFault FindFault::operator -- (){
	for(unsigned i = 0; i < this->numEncryptWords; i++)
		eWords[i]--;
	return *this;
}

FindFault FindFault::operator -- (int){
	FindFault temp(*this);
	for(unsigned i = 0; i < this->numEncryptWords; i++)
		eWords[i]--;
	return temp;
}

bool FindFault::operator > (const FindFault &obj){
	if (this->numEncryptWords > obj.numEncryptWords)
		return true;
	else
		return false;
}

bool FindFault::operator >= (const FindFault &obj){
	if (this->numEncryptWords >= obj.numEncryptWords)
		return true;
	else
		return false;
}

bool FindFault::operator < (const FindFault &obj){
	if (this->numEncryptWords < obj.numEncryptWords)
		return true;
	else
		return false;
}

bool FindFault::operator <= (const FindFault &obj){
	if (this->numEncryptWords <= obj.numEncryptWords)
		return true;
	else
		return false;
}

bool FindFault::operator == (const FindFault &obj){
	if (this->numEncryptWords == obj.numEncryptWords)
		return true;
	else
		return false;
}

bool FindFault::operator != (const FindFault &obj){
	if (this->numEncryptWords != obj.numEncryptWords)
		return true;
	else
		return false;
}


string FindFault::seedWord(string in) {
	string out = "";
	
	for (unsigned i = 0; i < numEncryptWords; i++)
		//corrupt the one associated with the int determined randomaly at
		// construction
		if ((i + 1) == corrupted) {
			out += "Encryption " + std::to_string(i + 1);
			out += ": " + corrupt(eWords[i].encrypt(in)) + "\n";
		}
		else {
			out += "Encryption " + std::to_string(i + 1);
			out += ": " + eWords[i].encrypt(in) + "\n";
		}
	return out;
}

string FindFault::corrupt(string in) {
    int corruptionShift = 2;
    string out = "";
    for (unsigned i = 0; i < in.length(); i++) {
        if (i == in.length() / 2) {//corrupt the character in the middle
            //for uppercase
            if (in[i] >= 65 && in[i] <= 90)
                out += char((int(in[i]) + (26 - corruptionShift) - 65) % 26 + 65);
                //for lower
            else
                out += char((int(in[i]) + (26 - corruptionShift) - 97) % 26 + 97);
        }
        else
            out += in[i];
    }
    return out;
}
void FindFault::add(unsigned a, unsigned b){
	eWords[a-1] + eWords[b-1];
}
void FindFault::subtract(unsigned a, unsigned b){
	eWords[a-1] - eWords[b-1];
}
bool FindFault::lessthan(unsigned a, unsigned b){
	return eWords[a-1] < eWords[b-1];
}
bool FindFault::greaterthan(unsigned a, unsigned b){
	return eWords[a-1] > eWords[b-1];
}
bool FindFault::equalto(unsigned a, unsigned b){
	return eWords[a-1] == eWords[b-1];
}
bool FindFault::makeGuess(unsigned guess) {
    guesses++;
    return guess == corrupted;
}
int FindFault::getGuesses() {
    return guesses;
}
bool FindFault::on(){
	for (unsigned i = 0; i < numEncryptWords; i++)
		if (!eWords[i].getOn())
			return false;
	return true;
}
void FindFault::resize(unsigned el) {
	unsigned tempNum = numEncryptWords;
	numEncryptWords = el;
	EncryptWord *tempArr = new EncryptWord[numEncryptWords];
	for (unsigned i = 0; i < tempNum; i++)
		tempArr[i] = eWords[i];
	delete[] eWords;
	eWords = tempArr;
}

//
// Created by Craig Danz on 10/12/17.
//

*/