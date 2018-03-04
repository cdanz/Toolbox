/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_lab6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * Driver class that tests various sort methods in the sort class and times 
 * them.
 * @author danzc
 *
 */
public class Lab6 {

	public static void main(String[] args) {
		for(int n = 125; n <= 16384000; n *= 2) {
			int[] myArray = new int[n];
			int[] insertSort = new int[n];
			int[] selectSort = new int[n];
			int[] bubbleSort = new int[n];
			int[] mergeSort = new int[n];
			int[] heapSort = new int[n];
			int[] quickSort = new int[n];
			int[] arraySort = new int[n];
			long startTime;
		    long endTime;
		    int i;
			myArray = new int[n];
			myArray = fillRandom(myArray);
			
			System.out.println("\n\nTesting n of " + n);
			
			/**
			//Test Selection Sort
			for (i = 0; i < myArray.length; i++)
				selectSort[i] = myArray[i];
			startTime = System.nanoTime();
			selectSort = Sort.SelectionSort(selectSort);
			endTime = System.nanoTime();
			System.out.print("\nSelection Sort Time: " + 
					(endTime - startTime) / 1000000000.0);
			
			//Test Bubble Sort
			for (i = 0; i < myArray.length; i++)
				bubbleSort[i] = myArray[i];
			startTime = System.nanoTime();
			bubbleSort = Sort.BubbleSort(bubbleSort);
			endTime = System.nanoTime();
			System.out.print("\nBubble Sort Time: " + 
					(endTime - startTime) / 1000000000.0);
			*/
			
			//Test Merge Sort
			for (i = 0; i < myArray.length; i++)
				mergeSort[i] = myArray[i];
			startTime = System.nanoTime();
			Sort.MergeSort(mergeSort);
			endTime = System.nanoTime();
			System.out.print("\n" + //Merge Sort Time: 
					(endTime - startTime) / 1000000000.0);
			
			//Test Heap Sort
			for (i = 0; i < myArray.length; i++)
				heapSort[i] = myArray[i];
			startTime = System.nanoTime();
			Sort.HeapSort(heapSort);
			endTime = System.nanoTime();
			System.out.print("\n" + //Heap Sort Time: 
					(endTime - startTime) / 1000000000.0);
			
			//Test Quick Sort
			for (i = 0; i < myArray.length; i++)
				quickSort[i] = myArray[i];
			startTime = System.nanoTime();
			quickSort = Sort.QuickSort(quickSort, 0, quickSort.length - 1);
			endTime = System.nanoTime();
			System.out.print("\n" + //Quick Sort Time: 
					(endTime - startTime) / 1000000000.0);	
		
			//Test Array Sort
			for (i = 0; i < myArray.length; i++)
				arraySort[i] = myArray[i];
			startTime = System.nanoTime();
			Arrays.sort(arraySort);
			endTime = System.nanoTime();
			System.out.print("\n" + //Array Sort Time: 
					(endTime - startTime) / 1000000000.0);	
			
			//Test Insertion Sort
			if (n < 256000) {
				for (i = 0; i < myArray.length; i++)
					insertSort[i] = myArray[i];
				startTime = System.nanoTime();
				insertSort = Sort.InsertionSort(insertSort);
				endTime = System.nanoTime();
				System.out.print("\n" + //Insertion Sort Time: 
						(endTime - startTime) / 1000000000.0);	
			}
		}
	}

	public static int[] fillRandom(int[] myArray) {
		Random random = new Random();
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = random.nextInt(1000000);
		}
		return myArray;
	}

}
