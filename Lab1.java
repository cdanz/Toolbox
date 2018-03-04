/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package danzc_lab1;

import java.util.Scanner;

/**
 * This class demonstrates binary searches using iterative and recursive 
 * approaches. Feed the program integers in any order and it will perform a 
 * binary search using both approaches. 
 * @author danzc
 *
 */
public class Lab1 {
	private static Scanner keyboard = new Scanner(System.in);
	

	public static void main(String[] args) {
		int[] arr; //Array of numbers to search
		int key, index;
		
		
		welcome();
		do {		
			arr = getNumbers();
			System.out.print("Here is the array we will be searching:\n" +
							"Search Array = {");
			for (int i = 0; i < arr.length-1; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println(arr[arr.length-1] + "}\n");
			arr = selectionSort(arr);
			System.out.print("Here it is sorted:\n" +
					"Search Array = {");
			for (int i = 0; i < arr.length-1; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println(arr[arr.length-1] + "}\n");
			System.out.print("Let's search! What number would you like to " +
							"look for?: ");
			key = keyboard.nextInt();
			System.out.println("\nFirst, an iterative approach:\n");
			index = binaryIterative(arr, key);
			if (index == -1) {
				System.out.println(key + " was not found.");
			}
			else {
				System.out.println(key + " was found in the sorted array at " +
									"index: " + index);
			}
			System.out.println("\nNow, a recursive approach:\n");
			index = binaryRecursive(arr, 0, arr.length - 1, key);
			if (index == -1) {
				System.out.println(key + " was not found.");
			}
			else {
				System.out.println(key + " was found in the sorted array at " +
									"index: " + index);
			}
			
			keyboard.nextLine();
		} while (repeat("\nWould you like to search another array? Y/N: "));
		farewell();
		

	}
	
	/**
	 * This method performs a binary search on a sorted array using an 
	 * iterative approach. 
	 * @param a					A sorted array of integers to search.
	 * @param target				A search term to search the array for.
	 * @return 					The index where the target was found or 
	 * 							the sentinel value -1 if it is not found. 	
	 */
	private static int binaryIterative(int[] a, int target) {  
		int lo = 0;
		int hi = a.length - 1;
		
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] == target) {
				//make sure you get the first instance in the array
				while (a[mid] == a[mid - 1]) {
					mid--;
				}
				return mid;
			}
			else if (a[mid] > target) {
				hi = mid - 1;
			}
			else {
				lo = mid + 1;
			}
		}
		return -1;
	}
	
	/**
	 * This method performs a binary search on a sorted array using a 
	 * recursive approach. 
	 * @param a					A sorted array of integers to search.
	 * @param target				A search term to search the array for.
	 * @return 					The index where the target was found or 
	 * 							the sentinel value -1 if it is not found. 	
	 */
	private static int binaryRecursive(int[] a, int lo, int hi, int target) {  
		int mid;
		if (lo > hi)
			return -1;
		mid = (lo + hi) / 2;
		if (a[mid] == target) {
			while (a[mid] == a [mid - 1])
				mid--;
			return mid;
		}
		else if (a[mid] < target)
			return binaryRecursive(a, mid + 1, hi, target);
		else
			return binaryRecursive(a, lo, mid - 1, target);
	}
	
	/**
	 * This method requests numbers from the user, entered into the 
	 * keyboard, to load up an array with. 
	 * @return searchArr 		An integer array only as big as needed 
	 * 							for the numbers the user entered.
	 */
	private static int[] getNumbers() {
		final int MIN = 20; //minimum number of integers needed
		final int MAX = 10000; //arbitrary limit on array size
		
		int[] inputArr = new int[MAX]; //load up with keyboard inputs
		int[] searchArr; //properly sized array to return. 
		int count;
		String input = ""; 
		
		for(count = 0; count < MIN || !input.isEmpty(); count++) {
			if (count == 0) 
				System.out.print("Start entering integers, we need at least " +
								MIN + ": ");
			else if (count < MIN) {
				System.out.print(count + " of " + MIN + ". Enter next: ");
			}
			else {
				System.out.print(count + " values. Enter more or just " +
								"press enter to quit: ");
			}
			input = keyboard.nextLine();
			while (input.isEmpty() && count < MIN) {
				System.out.print("Sorry, we need more numbers. Enter " + 
								(MIN - count) + " more: ");
				input = keyboard.nextLine();
			}
			if (!input.isEmpty()) {
				inputArr[count] = Integer.parseInt(input);
			}
		}

		searchArr = new int[count-1];
		for (int i = 0; i < searchArr.length; i++) {
			searchArr[i] = inputArr[i];
		}
		return searchArr;
	}
	
	/**
	 * This method performs a standard selection sort of a given array.
	 * @param a				An integer array to be sorted
	 * @return a				The array after it has been sorted
	 */
	private static int[] selectionSort(int[] a) {
		int startScan, index, minIndex, minValue;
		
		for (startScan = 0; startScan < (a.length-1); startScan++) {
			minIndex = startScan;
			minValue = a[startScan];
			for(index = startScan + 1; index < a.length; index++) {
				if (a[index] < minValue) {
					minValue =a[index];
					minIndex = index;
				}
			}
			a[minIndex] = a[startScan];
			a[startScan] = minValue;
		}
		return a;
	}
	
	/**
	 * This method displays a welcome message. 
	 */
	private static void welcome() {
		System.out.print("\n\nWelcome. This program takes in a number of " +
						"integers, sorts them and then performs a \n" +
						"binary search on them using both an iteratieve " +
						"and recursive approach.\n\n");
	}
	
	/**
	 * This method displays a goodbye message. 
	 */
	private static void farewell() {
		System.out.print("\n\nThanks for playing.\n\n");
	}
	
	/**
	 * This method finds turns keyboard input into a boolean statement so
	 * the user's desire to repeat the program can be evaluated.
	 * @param msg			String message phrasing what the user is being 
	 * 						asked to repeat.
	 * @return boolean		True if the user answers in the affirmative. 
	 */
	public static boolean repeat(String msg)
	{
		String input;
		char repeat;
		
		System.out.print(msg);
		input = keyboard.nextLine();
		repeat = input.charAt(0);
		if (repeat == 'y' || repeat == 'Y')
			return true;
		return false;
	}
}
