/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_p3x;

import java.util.*;

/**
 * This class is an implementation of a stack using a linked list.
 * @author danzc
 *
 */
public class Stack {
	private Node top; //Top of the stack
	
	/**
	 * Constructor simply initializes the stack with a top set to null.
	 */
	Stack() {
		top = null; //initialize to null
	}
	
	/**
	 * Constructor initialized with an ArrayList of values. Pushes all values 
	 * from list into the stack and sets a top.
	 */
	Stack(ArrayList<Integer> arr) {
		top = null;
		for (int i = 0; i < arr.size(); i++) {
			push(arr.get(i));
		}
		
	}
	
	/**
	 * Nested node class stores a list value and makes a reference to the 
	 * next node.
	 */
	private class Node {
		int value; //value to store in the stack.
		Node next; // the next member of the stack
		
		/**
		 * Constructor of the node. 
		 * @param val			An integer value to be stored.
		 * @param n				A reference to the next node
		 */
		Node(int val, Node n) {
			value = val;
			next = n;
		}
	}
	
	/**Copy method creates a new Stack object from the current one.
	 * @return r				A reference to a new Stack object that
	 * 						is otherwise identical to this.
	 */
	public Stack copy() {
		Stack s = new Stack(); //A stack in reverse of this
		Stack t = new Stack(); //A stack in reverse of the reverse
		for (Node p = top; p != null; p = p.next) {
			s.push(p.value);
		}
		for (Node q = s.top; q != null; q = q.next) {
			t.push(q.value);
		}
		return t;
	}
	
	/**
	 * Checks to see if the top of the stack is empty or not. 
	 * @return boolean			True if top is empty, false otherwise
	 */
	public boolean empty() {
		return top == null;
	}
	
	/**
	 * Pushes the old top down and adds a new value to the top.
	 * @param a					integer value to store
	 */
	public void push(int a) {
		top = new Node(a, top);
	}
	
	/**
	 * Pops the top of the stack and returns its value
	 * @return retValue			Value of old top. 
	 */
	public int pop() {
		if (empty()) {
			throw new IllegalArgumentException("Nothing to pop!");	
		}
		else {
			int retValue = top.value;
			top = top.next;
			return retValue;
		}
	}
	
	/**
	 * Takes a look at the top without popping it. 
	 * @return top.value			The value at the top of the stack.
	 */
	public int peek() {
		if (empty()) {
			throw new IllegalArgumentException("No peeking!");	
		}
		else {
			return top.value;
		}
	}
	
	/**
	 * The equals checks to see if one stack is equal to another.
	 * return boolean			True if and only if all values are
	 * 							stored in the same order and all values
	 * 							are equal.
	 */
	public boolean equals(Stack that) {
		for (Node pred1 = this.top, pred2 = that.top; pred1 != null && 
				pred2 != null; pred1 = pred1.next, pred2 = pred2.next) {
			if(pred1.value == pred2.value);
			else {
				return false;
			}
				
		}
		return true;
	}
	
	/**
	 * The toString method translates a linked list of integer
	 * data values and turns them into a single string deliminated by
	 * '|'.
	 * return s				String of all node values in list.
	 */
	public String toString() {
		String s = "";
		
		for (Node pred = top; pred != null; pred = pred.next) {
			s += pred.value + "|";
		}
		return s;
	}	
}
		


