// AUTHOR: Craig Danz
// FILENAME: hw1.cpp
// DATE: 1/18/18
// REVISION HISTORY: 1.0
// REFERENCES (optional): all code that is not your own, other than standard libraries

//
// Created by Craig Danz on 1/18/18.
//

#include <iostream>

using namespace std;

/* Task 1: Write a function called power that has the following prototype:
 * int power ( int num, int exp);
 * The power function should compute numexp and return the answer as an int.
 * If exp is negative, power should return 0. If it is 0 then power should
 * return 1. You should use a loop to compute this (and not pow (x, y) or
 * anything else in the Math library <cmath>). You can use the following
 * comment to describe your power function.

 * Function:      power
 * Purpose:       computes num to the exp power
 * Parameters:  The number – num, and the exponent – exp
 * Returns:       0 if exp is negative; 1 if exp is 0; raise num to the exp
 *                      power otherwise.
*/

int power(int num, int exp) {
	int answer = num;
	if (num < 0)
		return 0;
	else if (num == 0)
		return 1;
	else if (num == 1)
		return answer;
	else
		for(int i = 1; i < exp; i++)
			answer = answer * num;
	return answer;
};

int myLog(int base, int num) {
	const int MAXITT = 1000;
	for(int i = 1; i < MAXITT; i++)
			if (power(base,i) > num)
				return i - 1;
	return -1;
};

void swap(int &x, int *y){
	int temp = x;
	x = *y;
	*y = temp;
}


int main(void) {
	int a = 10;
	int b = 20;
	swap(a,&b);
	cout << "a = " << a << " b = " << b;
	
	/*int num1, num2;
	cout << "Power" << endl;
	cout << "Enter a base: ";
	cin >> num1;
	cout << "Enter an exponent: ";
	cin >> num2;
	cout << num1 << " to the " << num2 << " is " << power(num1,num2) << endl;
	
	cout << "\nmyLog" << endl;
	cout << "Enter a base: ";
	cin >> num1;
	cout << "Enter an number: ";
	cin >> num2;
	cout << "Log " << num2 << " in base " << num1 << " is " << myLog(num1,num2)
		 << endl;*/
	return 0;
}