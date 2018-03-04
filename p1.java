/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_p1x;

import java.io.*;
import java.util.*;

/**
 * This class demonstrates the various functions of the BST class.
 * @author danzc
 *
 */
public class p1 {

	public static void main(String[] args) throws IOException{

		welcome();
		System.out.println("Creating a tree");
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		System.out.println("Tree after inserting:");
		BSTX tree = new BSTX(list);
		printTreeStatus(tree);
		System.out.println("Copy that tree:");
		BSTX treeCopy = new BSTX(tree);
		printTreeStatus(treeCopy);
		System.out.println("\nTESTING EQUALS AFTER COPY");
		System.out.println("Tree is equal to treeCopy: " + 
							tree.equalsTree(treeCopy));
		
		System.out.println("\nTESTING ELEMENTS IN RANGE");
		System.out.println("Elements within 25 and 65: " + 
							tree.getElementsInRange(25, 65));

		System.out.println("\n\n\nPrevious code\n\n\n");
		System.out.println("\nTESTING TRAVERSALS");
		System.out.println("\nPre-order traversal:\n" + 
						combineToString(tree.getPreOrderTraversal()));
		System.out.println("\nIn-order traversal:\n" + 
				combineToString(tree.getInOrderTraversal()));
		System.out.println("\nPost-order traversal:\n" + 
				combineToString(tree.getPostOrderTraversal()));
		System.out.println("\nTree is empty: " + tree.empty());
		System.out.println("\nTESTING CONTAINS/n");
		//I'm testing numbers from my personal test file. If you are using
		//a different file you should probably use different numbers
		System.out.println("Should contain these..." +
				"\ncontains(-435): " + tree.contains(-435) + 
				"\ncontains(-64): " + tree.contains(-64) +
				"\ncontains(98): " + tree.contains(98) +
				"\ncontains(876): " + tree.contains(876) + "\n");
		System.out.println("Should NOT contain these..." +
				"\ncontains(-237): " + tree.contains(-237) + 
				"\ncontains(-5): " + tree.contains(-5) +
				"\ncontains(103): " + tree.contains(103) +
				"\ncontains(500): " + tree.contains(500) + "\n");
		System.out.println("\nTESTING REMOVE: removing some values: " +
				"-214 -64 4 7 57 98 234 2169 2342\n");
		//Still my personal file that these relate to. Need to be changed for
		//other files.
		tree.remove(-214);
		tree.remove(-64);
		tree.remove(4);
		tree.remove(7);
		tree.remove(	57);
		tree.remove(	98);
		tree.remove(	234);
		tree.remove(	2169);
		tree.remove(	2342);
		System.out.println("Tree after removals:");
		printTreeStatus(tree);
		System.out.println("\nAdding back some values: 99 20 -2 40 10 70 59 43 \n");
		tree.insert(99);
		tree.insert(20);
		tree.insert(-2);
		tree.insert(40);
		tree.insert(10);
		tree.insert(70);
		tree.insert(59);
		tree.insert(43);
		System.out.println("Tree after adding back some nodes:");
		printTreeStatus(tree);
		System.out.println("\nTESTING getElementLevel:\n" +
			"getElementLevel(0): " + tree.getElementLevel(0) + "\n" +
			"getElementLevel(-2): " + tree.getElementLevel(-2) + "\n" +
			"getElementLevel(43): " + tree.getElementLevel(43) + "\n" +
			"getElementLevel(99): " + tree.getElementLevel(99) + "\n");
		System.out.println("\nTESTING getAncestorsOf:\n" +
				"getElementLevel(0): " + 
					combineToString(tree.getAncestorsOf(0)) + "\n" +
				"getElementLevel(-2): " + 
					combineToString(tree.getAncestorsOf(-2)) + "\n" +
				"getElementLevel(43): " + 
					combineToString(tree.getAncestorsOf(43)) + "\n" +
				"getElementLevel(99): " + 
					combineToString(tree.getAncestorsOf(99)) + "\n");

		farewell();

	}
	
	/**
	 * Prints basic stats of a tree's current state. 
	 * @param tree			Tree we want stats on.
	 */
	public static void printTreeStatus(BSTX tree) {
		System.out.println("Tree height: " + tree.getTreeHeight());
		System.out.println("# of Elements: " + tree.size());
		System.out.println("# of Leaves: " + tree.getLeafNodeCount());
	}
	
	/**
	 * Prompts the user for a file to read.
	 * @return user input		String representing a file name
	 */
	public static String getFile() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Load file: ");
		return keyboard.nextLine();
	}
	
	/**
	 * Reads the file and loads its contents into the BST
	 * @param name				Filename to be read
	 * @param tree				Tree to add the values to.
	 * @return
	 */
	public static void readFile(String name, BSTX tree) throws IOException{
		final int MAX = 15; //max numbers listed per line.
		int number;
		int counter = 0;
		
		File file = new File(name);
		Scanner inputFile = new Scanner(file);
		System.out.println("\nTESTING INSERT: inserting elements in " +
							"this order: ");
		while (inputFile.hasNext()) {
			number = inputFile.nextInt();
			if(counter >= MAX) {
				System.out.print(number + "\n");
				counter = 0;
			}
			else 
				System.out.print(number + " ");
			tree.insert(number);
			counter++;
		}
		inputFile.close();
	}
	
	/**
	 * Returns a String that represents the elements of the list. Each list
	 * element toString() value is joined by a single space. An empty string is
	 * returned if the list is null or empty.
	 * @param list  List of elements' toString() values to join
	 * @param <E>   an object with a properly overloaded toString()
	 * @return String representation of the list of elements
	 */
	private static <E> String combineToString(ArrayList<E> list) {
	 final String DELIMITER = " ";
	 StringBuilder sb = new StringBuilder();
	 for (E e : list) {
	 sb.append(e.toString()).append(DELIMITER);
	 }
	 return sb.toString();
	}
	
	/**
	 * This method displays a welcome message. 
	 */
	private static void welcome() {
		System.out.print("\n\nWelcome to the BST test program.\n\n");
	}
	
	/**
	 * This method displays a goodbye message. 
	 */
	private static void farewell() {
		System.out.print("\n\nThanks for using the BST test program. " +
						"Goodbye.\n\n");
	}
}
