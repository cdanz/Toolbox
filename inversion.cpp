// AUTHOR: Craig Danz
// FILENAME: inversion.cpp
// DATE: 1/30/2018
// VERSION: 1.0

/*The following program demonstrates a method of counting inversions in a
 * semi-sorted array that has an efficiency of O(nlogn). A pair (A[i], A[j]) is
 * said to be an inversion if these numbers are out of order, i.e., i < j but
 * A[i] > A[j]. This can be achieved by realizing that the standard merge sort
 * algorithm is already of O(nlogn) efficiency and that the comparison to detect
 * inverted element values happens during the process of merging the reduced and
 * sorted arrays together step by step. By adding an accumulator and
 * incrementing each time an inversion is detected, these modified merge and
 * mergesort functions can detect the number of inversions in the semi-sorted
 * array.*/

#include <iostream>

using namespace std;

int counter = 0; //Accumulater used globally to keep this all in a single file
                 //with the specified characteristics.

/*This is a slightly modified version of a standard merge function that adds an
 * incrementer for the accumulator*/
void swap(int &x, int &y){
	int temp = x;
	x = y;
	y = temp;
}

void mergeModInversionCounter(int arr[], int l, int m, int r) {
	int i, j, k;
	int n1 = m - l + 1;
	int n2 = r - m;
	// create temp arrays
	int L[n1], R[n2];
	// Copy data to temp arrays L[] and R[]
	for (i = 0; i < n1; i++)
		L[i] = arr[l + i];
	for (j = 0; j < n2; j++)
		R[j] = arr[m + 1 + j];
	i = 0; // Initial index of first subarray
	j = 0; // Initial index of second subarray
	k = l; // Initial index of merged subarray
	while (i < n1 && j < n2) {
		if (L[i] <= R[j]) {
			arr[k] = L[i];
			i++;
		} else {
			counter++; //Here we increment the counter because we are required
			//to pull an element from the rightside array which we
			//we expect to be larger than the left normally
			arr[k] = R[j];
			j++;
		}
		k++;
	}
	//Copy the remaining elements of L[], if there are any
	while (i < n1) {
		arr[k] = L[i];
		i++;
		k++;
	}
	
	// Copy the remaining elements of R[], if there are any
	while (j < n2) {
		arr[k] = R[j];
		j++;
		k++;
	}
}
/* Here is a slightly modified version of the standard mergesort algorithm, the
 * only change is that it calls the modified version of merge rather than a
 * standard merge function.
 * l is for left index and r is right index of the sub-array of arr to be
 * sorted */
void mergeSortModInversionCounter(int arr[], int l, int r) {
	if (l < r) {
		// Same as (l+r)/2, but avoids overflow for
		// large l and h
		int m = l+(r-l)/2;
		
		// Sort first and second halves
		mergeSortModInversionCounter(arr, l, m);
		mergeSortModInversionCounter(arr, m+1, r);
		
		mergeModInversionCounter(arr, l, m, r);
	}
}

/* Primary method being demonstrated. This method takes in an array of
 * semi-sorted elements along with the size of the array as parameters. It does
 * not return to the number of inversions but updates the globabl accumulator to
 * adhere to the specified prototype function provided as the assignment. */
void countInversions(int *arr, int size){
	counter = 0; //Reset the global accumulator to zero
	mergeSortModInversionCounter(arr, 0, size-1);
}

int partition(int *arr, int lo, int hi){
	int pivot = arr[lo];
	int i = lo - 1;
	int j = hi + 1;
	do
		i = i + 1;
	while (arr[i] < pivot);
	do
		j = j - 1;
	while(arr[j] > pivot);
	
	if (i >= j)
		return j;
		
	swap(arr[i], arr[j]);
}

void quicksort(int *arr, int lo, int hi) {
	if (lo < hi)
		int p = partition(arr, lo, hi);
		quicksort(arr, lo, p);
		quicksort(A, p + 1, hi);
}


/* Utility function to display the array */
void printArray(int A[], int size) {
	int i;
	for (i=0; i < size; i++)
		printf("%d ", A[i]);
	printf("\n");
}

/* Driver program to demonstrate the functioning of the countInversions
 * method */
int main() {
	int A1[] = {1, 2, 3, 5, 4, 6, 7, 8, 10, 9, 11, 15, 14, 13, 12, 16, 17, 18,
				 20, 19, 22, 21, 23, 24, 25};
	int A1_size = sizeof(A1)/sizeof(A1[0]);
	int A2[] = {1, 4, 3, 2};
	int A2_size = sizeof(A2)/sizeof(A2[0]);
	int A3[] = {2, 4, 6, 10, 8, 12, 14, 18, 16, 20, 22, 26};
	int A3_size = sizeof(A3)/sizeof(A3[0]);
	
	cout << "First array: \n";
	printArray(A1, A1_size);
	countInversions(A1, A1_size);
	cout << "Has "<< counter << " inversions.";
	
	cout << "\n\nSecond array: \n";
	printArray(A2, A2_size);
	countInversions(A2, A2_size);
	cout << "Has "<< counter << " inversions.";
	
	cout << "\n\nThird array: \n";
	printArray(A3, A3_size);
	countInversions(A3, A3_size);
	cout << "Has "<< counter << " inversions.";
	return 0;
}