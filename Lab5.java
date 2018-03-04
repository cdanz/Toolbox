/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_lab5;

import java.util.Random;

/**
 * Driver demonstrating the capabilities of the HashTable Class.
 * @author danzc
 *
 */
public class Lab5 {
	private static HashTable hashTable;
	private static HashTable hashTable2;
	private static Random random = new Random();
	private static final int SIZE = 4093;

	public static void main(String[] args) {
		final int RUNS = 10;
		welcome();
		System.out.println("Creating a HashTable with capacity 4093 " +
							"and inserting 3993 \nrandom key-value " +
							"pairs with unique keys ...done.");
		hashTable = generateHashTable(hashTable, 3993);
		printStatus(hashTable);
		System.out.println("\nPerforming timing test as the HashTable " +
							"starts to become full:");
		for(int i = 0; i < RUNS; i++) 
			System.out.printf("%4d to %4d, %.1f%%: %8f\n", 
								hashTable.size(), 
								hashTable.size() + 9,
								((double)(hashTable.size() + 9))/
									((double)(SIZE)) * 100,
								timeTest(hashTable));
		System.out.println("\nCreating a new HashTable with capacity 4093 " +
				"and inserting 4083\nrandom key-value " +
				"pairs with unique keys ...done.");
		hashTable2 = generateHashTable(hashTable2, 4083);
		System.out.println("Inserting 10 additional key-values...");
		System.out.println("(1179 , 120)");
		hashTable2.put(1179 , 120);
		System.out.println("(9702 , 121)");
		hashTable2.put(9702 , 121);
		System.out.println("(7183 , 122)");
		hashTable2.put(7183 , 122);
		System.out.println("(50184 , 123)");
		hashTable2.put(50184 , 123);
		System.out.println("(4235 , 124)");
		hashTable2.put(4235 , 124);
		System.out.println("(644 , 125)");
		hashTable2.put(644 , 125);
		System.out.println("(77 , 126)");
		hashTable2.put(77 , 126);
		System.out.println("(3077 , 127)");
		hashTable2.put(3077 , 127);
		System.out.println("(23477 , 128)");
		hashTable2.put(23477 , 128);
		System.out.println("(90777 , 129)");
		hashTable2.put(90777 , 129);
		System.out.println("\nTesting contains...");
		System.out.printf("contains(%5d): " + hashTable2.contains(50184),50184);
		System.out.printf("\ncontains(%5d): " + hashTable2.contains(77),77);
		System.out.printf("\ncontains(%5d): " + hashTable2.contains(0),0);
		System.out.printf("\ncontains(%5d): " + hashTable2.contains(-1),-1);
		System.out.println("\n\nTesting get...");
		System.out.printf("get(%5d): " + hashTable2.get(50184),50184);
		System.out.printf("\nget(%5d): " + hashTable2.get(77),77);
		System.out.printf("\nget(%5d): " + hashTable2.get(0),0);
		System.out.printf("\nget(%5d): " + hashTable2.get(-1),-1);
		farewell();

	}
	
	/**
	 * performs a time test on the put function as the hash table begins
	 * to fill up.
	 * @param h					Hash table to perform the test on.
	 * @return time				Difference between the system start time 
	 * 							end time after performing the task.
	 */
	public static double timeTest(HashTable h) {
		final int INTERVAL = 10;
		int end = h.size() + INTERVAL;
		final long startTime = System.nanoTime();
		while (h.size() < end) {
			h.put(random.nextInt(100000), random.nextInt(100000));
		}
		final long endTime = System.nanoTime();
		return (endTime - startTime) / 1000000000.0;
	}
	
	/**
	 * Generates a new hash table and loads it up with random key/value
	 * pairs
	 * @param h							Hash table to generate and load
	 * @param generate					number of key/value pairs to generate
	 * 									and load into the table
	 * @return h							The hash table after it has 
	 * 									been generated
	 */
	public static HashTable generateHashTable(HashTable h, int generate) {
		h = new HashTable(SIZE);
		while(h.size() < generate)
			h.put(random.nextInt(100000), random.nextInt(100000));
		return h;
	}
	
	/**
	 * Prints to screen the current status of a hash table.
	 * @param h						Hash table you wish to know the 
	 * 								status of.
	 */
	public static void printStatus(HashTable h) {
		System.out.println("Hashtable empty: " + h.isEmpty());
		System.out.println("Hashtable size: " + h.size());
	}
	
	/**
	 * Prints to screen a welcome message.
	 */
	public static void welcome() {
		System.out.println("\n\nWelcome to the HashTable timing and " +
							"testing program.\n\n");
	}
	
	/**
	 * Prints to screen a farewell message. 
	 */
	public static void farewell() {
		System.out.println("\n\nThanks for using the HashTable testing " +
							"program. Goodbye.\n\n");
	}
}
