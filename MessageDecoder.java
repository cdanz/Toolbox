package danzc_p2;
/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

import java.io.*;
import java.util.*;

/**
 * This class decodes a secret message from a file that has its characters
 * scrambled. It reads the file into a sorted file that connects the
 * character values in order revealing the hidden message.  
 * @author danzc
 */
public class MessageDecoder {
	private Node first = null; //Linked list head variable, initialized
								//to null.
		
	/**
	 * Node class stores a list value and makes a reference to the next node.
	 */
	private static class Node {
		private char value; 		//A single character that is scrambled
								//in the file.
		private int index;		//The index of where the scrambled value
								//rightfully belongs.
		private Node next;		//The node that follows in linked list
		
		/**
		 * Constructor of the node. 
		 * @param val			A char value to be stored.
		 * @param dex			A integer representing the proper index
		 * @param n				A reference to the next node
		 */
		Node(char val , int dex , Node n) {
			value = val;
			index = dex;
			next = n;
		}
		
		/**
		 * Constructor of the node without a reference to next. Calls sister
		 * constructor and pass a null argument for the node reference. 
		 * @param val			A value to be stored.
		 */
		Node(char val , int dex) {
			this(val, dex , null);
		}
	}
	
	public MessageDecoder(String a) throws IOException {
		String input; //full string read from a line
		String inputPart; //portion of the full string to parse an int from
		int index; //index position of scrambled character 
					//found after the character.
		char value; //the character we want to put in order
		
		File inputFile = new File(a);
		Scanner inputData = new Scanner(inputFile);
		while (inputData.hasNext()) {
			input = inputData.nextLine();
			value = input.charAt(0);
			inputPart = ""; //initialize the partial string
			for (int i = 2; i < input.length(); i++)
				inputPart += input.charAt(i); //add each remaining char
			index = Integer.parseInt(inputPart);
			insertInOrder(value , index);
		}
		inputData.close();
	}

	/**
	 * This method walks through a sorted linked list using the provided
	 * index value to put it in the proper order. A new node should be created where
	 * the value being passed to it is less than its successor but greater than
	 * its predecessor.
	 * @param val				A value to be evaluated and store in the 
	 * 							correct order.
	 */
	private void insertInOrder(char val , int dex) {
		Node pred = first; //start at head and traverse the list. 
		if (first == null) {
			first = new Node(val , dex);
		}
		else if (dex <= pred.index) {
			first = new Node (val , dex , pred);
		}
		else if (pred.next == null) {
			pred.next = new Node(val , dex);
		}	
		else {
			while (pred.next != null) {
				if (dex <= pred.next.index) {
					pred.next = new Node(val , dex , pred.next);
					return;
				}
				else {
					pred = pred.next;
				}
			}
			pred.next = new Node(val , dex);
		}
	}
	
	/**
	 * This method converts all the sorted char values in a linked list
	 * into a single string.
	 * @return builtString			The string the method builds from 
	 * 								from characters. 
	 */
	public String getPlainTextMessage() {
		String builtString = ""; //String built from individual characters
		for (Node q = first; q != null; q = q.next) {
				builtString += q.value;
		}
		return builtString;
	}
}