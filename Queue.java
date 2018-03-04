/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_p3x;

import java.util.*;

/**
 * This class implements a double linked list based queue. 
 * @author danzc
 *
 */
public class Queue {
	
	/**
	 * Nested node class to create nodes to link.
	 * @author danzc
	 *
	 */
	private class Node {
		int value;	 //Node payload holding integer
		Node next; //A reference to the next node in the list.
		Node prev; //A reference to the node that precedes this node in the list.
		
		/**
		 * Node constructor
		 * @param val			An integer
		 * @param n				The following node to link to.
		 * @param p				The preceding node to link to.
		 */
		Node (int val, Node n, Node p) {
			value = val;
			next = n;
			prev = p;
		}
	}
	
	private Node front; //The head of the linked list.
	private Node rear; //The tail of the linked list. 
	
	/**
	 * Queue class constructor, initializes the head and tail to null.
	 */
	public Queue () {
		front = null;
		rear = null;
	}
	
	/**Copy method creates a new Queue object from the current one.
	 * @return r				A reference to a new Queue object that
	 * 						is otherwise identical to this.
	 */
	public Queue copy() {
		Queue r = new Queue();
		Node p = front;
		while (p != null) {
			r.enqueue(p.value);
			p = p.next;
		}
		return r;
	}
	
	/**
	 * The equals checks to see if one queue is equal to another.
	 * return boolean			True if and only if all values are
	 * 							stored in the same order and all values
	 * 							are equal.
	 */
	public boolean equals(Queue that) {
		for (Node pred1 = this.front, pred2 = that.front; pred1 != null && 
				pred2 != null; pred1 = pred1.next, pred2 = pred2.next) {
			if(pred1.value == pred2.value);
			else {
				return false;
			}
				
		}
		return true;
	}
	
	/**Append takes a Queue as an argument, copies it and appends its 
	 * nodes onto the back of this Queue's queue of nodes.
	 * @param q					A Queue to append on to this one. 
	 */
	public void append(Queue q) {
		Queue r = q.copy();
		if (this.rear == null) {
			this.front = r.front;
			this.rear = r.rear;
		}
		else {
			this.rear.next = r.front;
			r.front.prev = this.rear;
			this.rear = r.rear;
		}
	}
	
	/**Enqueue method adds a value to the rear of the queue.
	 * @param e 			The value to be added
	 */
	public void enqueue(int e) {
		if (rear != null) {
			rear.next = new Node(e, null, rear);
			rear = rear.next;
		}
		else {
			rear = new Node(e, null, null);
			front = rear;
		}
	}
	
	/**
	 * Empty method checks to see if the queue is empty.
	 * @return boolean 			True if and only if queue is empty.
	 */
	public boolean empty() {
		return front == null;
	}
	
	/**
	 * Peek returns the value from the front of the queue without dequeuing.
	 * @return front.value				Value at front of queue.
	 * @exception EmptyQueueException	When queue is empty.
	 */
	public int peek() {
		if (empty()) {
			throw new EmptyStackException();
		}
		else {
			return front.value;
		}
	}
	
	/**
	 * Dequeue method removes a node from the front of the queue and 
	 * returns its value. 
	 * @return value						Holds value of front node.
	 *  @exception EmptyQueueException	When queue is empty. 
	 */
	public int dequeue() {
		if (empty()) {
			throw new EmptyStackException();
		}
		else {
			int retValue = front.value;
			front = front.next;
			if (front == null) {
				rear = null;
			}
			else {
				front.prev = null;
			}
			return retValue;
		}
	}
	
	/**
	 * The toString method translates a linked list of integer
	 * values and turns them into a single string deliminated by
	 * '|'.
	 * return s				String of all node values in list.
	 */
	public String toString() {
		String s = "";

		for (Node pred = front; pred != null; pred = pred.next) {
			s += pred.value + "|";
		}
		return s;
	}
}
