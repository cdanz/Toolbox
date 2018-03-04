/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_lab4;
import java.util.*;
import java.io.*;

/**
 * This class demonstrates a linked list. Reading a non-sorted file and adding
 * the values into a linked list in numerical order.
 * @author danzc
 */
public class Lab4 {
	
	/**
	 * Node class stores a list value and makes a reference to the next node.
	 */
	private class Node {
		int value;
		Node next;
		
		/**
		 * Constructor of the node. 
		 * @param val			A value to be stored.
		 * @param n				A reference to the next node
		 */
		Node(int val , Node n) {
			value = val;
			next = n;
		}
		
		/**
		 * Constructor of the node without a reference to next. Calls sister
		 * constructor and pass a null argument for the node reference. 
		 * @param val			A value to be stored.
		 */
		Node(int val) {
			this(val, null);
		}
	}
	private Node first; //list head
	
	/**
	 * Constructor of Lab4. Initializes head reference to use that starts
	 * as null.
	 */
	public Lab4() {
		first = null;
	}
	
	/**
	 * This method walks through a sorted linked list evaluating existing
	 * member values against a new value. A new node should be created where
	 * the value being passed to it is less than its successor but greater than
	 * its predecessor.
	 * @param val				A value to be evaluated and store in the 
	 * 							correct order.
	 */
	public void insertInOrder(int val) {
		Node pred = first; //start at head and traverse the list. 
		if (first == null) {
			first = new Node(val);
			return;
		}
		if (val <= pred.value) {
			first = new Node (val, pred);
					return;
		}
		if (pred.next == null) {
			pred.next = new Node(val);
			return;
		}	
		while (pred.next != null) {
			if (val <= pred.next.value) {
				pred.next = new Node(val , pred.next);
				return;
			}
			else {
				pred = pred.next;
			}
		}
		pred.next = new Node (val);
	}
	
	/**
	 * Displays the contents of a linked list in a single column. 
	 */
	private void printLinkedList() {
		for (Node q = first; q != null; q = q.next)
			System.out.println(q.value);
	}
	
	public static void main(String[] args)throws IOException {
		final String FNAME = "lab4.dat";
		int value; //The value from the file that we are looking to store.
		Lab4 list = new Lab4();
		
		welcome(FNAME);
		File inputFile = new File(FNAME);
		Scanner inputData = new Scanner(inputFile);
		while (inputData.hasNext()) {
			value = Integer.parseInt(inputData.nextLine());
			list.insertInOrder(value);
		}
		System.out.println("Linked list contents:");
		list.printLinkedList();
		farewell();
		
	}
	
	/**
	 * Welcomes the user to the program. 
	 * @param a				A string for the name of the file being read
	 */
	public static void welcome(String a) {
		System.out.println("\n\nThis program reads the file " + a + " and " +
							"inserts the elements into a linked list in " +
							"nondescending order. \nThe contents of the " +
							"linked list are then displayed to the user " +
							"in column form.\n\n");
	}
	
	/**
	 * Wishes the user well before exiting. 
	 */
	public static void farewell() {
		System.out.println("\n\nThanks for using the linked list program!\n");
	}

	

}
