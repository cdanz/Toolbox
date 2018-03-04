/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */
package danzc_lab1;

import java.util.*;

/**
 * This class demonstrates the creation of a two-dimensional array and some 
 * basic methods to provide some characteristics of the array. 
 * @author - danzc
 */ 
public class TwoDimArray

{
	public static void main(String[] args)
	{
		final int MAX = 10; //Max number of rows and columns allowed.
		int size; //Hold user input of how many rows and columns
		          //they would like.
		int[][] myArray; //The 2D array we are working with.
		
		Scanner keyboard = new Scanner(System.in);
		
		welcome();
		do
		{
		   System.out.print("How many rows and columns would you like " + 
		                    "to have in your array? (Max of " + MAX + "): ");
		   size = keyboard.nextInt();
		   while (size <= 0 || size > MAX)
		   {   
			   System.out.print("Stick to 1 through 10. How many rows and " + 
		                        "columns?: ");
	           size = keyboard.nextInt();
		   }
		   keyboard.nextLine();
		   myArray = squareArray(size);
		   displayArray(myArray);
		} while (repeat("Would you like to try again? Y/N: "));
		farewell();
		
	}
	
	/**
	 * Welcomes the user to the program and explains what it does
	 */
	public static void welcome()
	{
		System.out.println("\n\nThis program asks for an integer and then " +
	                       "builds a 2D array that is a square with that " + 
				           "many rows and columns filled with random " +
	                       "numbers. It also gives you the sum of each row, " +
				           "column and, its two major diagonals.\n\n");
	}
	
	/**
	 * Takes the size of array indicated by the user and initializes an array
	 * of that many rows and columns filled with random numbers.
	 * @param num 		Indicates the number of rows and columns which must be
	 * 					the same.
	 */
	public static int[][] squareArray(int num)
	{
		int[][] array = new int[num][num];
		array = fillRand(array);
		return array;
	}
	
	/**
	 * Takes an array and fills each element with a random number.
	 * @param a		A two-dimensional int array
	 * @return a	A two-dimensional array filled with random numbers
	 */
	public static int[][] fillRand(int[][] a)
	{
		final int RANGE = 100; //Limits the range of the random numbers
		                       //from 0 to 99.
		Random rand = new Random();
		for (int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
			    a[i][j] = rand.nextInt(RANGE);
			}
		}
		return a;
	}
	
	/**
	 * Displays the contents of a 2D array.
	 * @param a		A 2D integer array.
	 */
	public static void displayArray(int[][] a)
	{	
		System.out.println();
		for(int i = 0; i < a.length; i++)
	    {
		   System.out.print(" \t");
		   for(int j = 0; j < a.length; j++)
		   {
		      System.out.print(a[i][j] + "\t");
		   }
		   rowTotal(a , i);
		   System.out.println();
		}
		diagonalTLBR(a);
		System.out.print("\t");
		for (int j = 0; j < a.length; j++)
		{
			colTotal(a , j);
			System.out.print("\t");
		}
	    diagonalTRBL(a);
	    System.out.println();
	}   
	
	/**
	 * Sums up all the elements in a given row of an array and 
	 * displays the total
	 * @param a			A 2D integer array.
	 * @param row		The index of the row to sum.
	 */
	public static void rowTotal(int[][] a, int row)
	{
		int total = 0; 
		
		for(int i = 0; i < a.length; i++)
		{
			total += a[row][i];
		}
		System.out.print("= " + total);
	}
	
	/**
	 * Sums up all the elements in a given column of an array and 
	 * displays the total.
	 * @param a			A 2D integer array.
	 * @param col		The index of the column to sum.
	 */
	public static void colTotal(int[][] a, int col)
	{
       int total = 0;
	   for(int i = 0; i < a.length; i++)
	   {
	      total += a[i][col];
	   }
	   System.out.print(total);
	}
	
	/**
	   Sums up all the elements that make up the major diagonal from 
	   the Top Left to the Bottom Right.
	   @param a			A 2D integer array.
	 */
	public static void diagonalTLBR(int[][] a)
	{
		int total; 
		//first diagonal from top left to bottom right.
		total = 0;
		for(int i = 0, j = 0; i < a.length; i++, j++)
		{    
			total += a[i][j];
		}
	    System.out.print(total);
	    
	}
	
	/**
	 * Sums up all the elements that make up major diagonal from
	 * the Top Right to the Bottm Left.
	 * @param a			A 2D integer array.
	 */
	public static void diagonalTRBL(int[][] a)
	{
		int total = 0;
		for(int i = 0, j = a.length - 1; i < a.length; i++, j--)
		{
			total += a[i][j];
		}
	    System.out.println(total);
	}
	
	/**
	 * Asks the user if they would like to run the program again.
	 * @param msg			How the question of repeating is phrased for
	 * 						this case.
	 * @return boolean		True if the user wants to repeat and False if not  
	*/
	public static boolean repeat(String msg)
	{
		String input;
		char repeat;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print(msg);
		input = keyboard.nextLine();
		repeat = input.charAt(0);
		if (repeat == 'y' || repeat == 'Y')
			return true;
		return false;
	}
	
	/**
	 * Bids the user farewell before exiting the program.
	 */
	public static void farewell()
	{
		System.out.println("\n\nThanks for playing!\n\n");
	}
	
}