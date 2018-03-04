/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package lundeenk_lab7;

import java.util.*;

/**
 * This class implements a double linked list based queue. 
 * @author danzc
 *
 */
public class RenderQueue {
	
	/**
	 * Nexted node class to create nodes to link.
	 * @author danzc
	 *
	 */
	private class Node {
		RenderCommand value;	//Node payload holding an enumerated type
							//RenderCommand
		Node next; //A reference to the next node in the list.
		Node prev; //A reference to the node that precedes this node in the list.
		
		/**
		 * Node constructor
		 * @param val			An enumerated type value of RenderCommands
		 * @param n				The following node to link to.
		 * @param p				The preceding node to link to.
		 */
		Node (RenderCommand val, Node n, Node p) {
			value = val;
			next = n;
			prev = p;
		}
	}
	
	private Node front; //The head of the linked list.
	private Node rear; //The tail of the linked list. 
	
	/**
	 * RenderQueue class constructor, initializes the head and tail to null.
	 */
	public RenderQueue () {
		front = null;
		rear = null;
	}
	
	/**Copy method creates a new RenderQueue object from the current one.
	 * @return r				A reference to a new RenderQueue object that
	 * 						is otherwise identical to this.
	 */
	public RenderQueue copy() {
		RenderQueue r = new RenderQueue();
		Node p = front;
		while (p != null) {
			r.enqueue(p.value);
			p = p.next;
		}
		return r;
	}
	
	/**Append takes a RenderQueue as an argument, copies it and appends its 
	 * nodes onto the back of this RenderQueue's queue of nodes.
	 * @param q					A RenderQueue to append on to this one. 
	 */
	public void append(RenderQueue q) {
		RenderQueue r = q.copy();
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
	public void enqueue(RenderCommand e) {
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
	public RenderCommand peek() {
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
	public RenderCommand dequeue() {
		if (empty()) {
			throw new EmptyStackException();
		}
		else {
			RenderCommand retValue = front.value;
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
	 * The fromString converts a string to a series of RenderCommands and 
	 * queues them up. 
	 * @param s						A string of render commands
	 *     							In traditional notation:
	 *     							'F' FORWARD
	 *								'R' FORWARD2
	 *								'X' IGNORE
	 *								'-' RIGHT
	 *								'+' LEFT
	 *								'[' PUSH
	 *								']' POP
	 */  
	public static RenderQueue fromString(String s) {
		RenderQueue r = new RenderQueue();
		for(int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'F':
				r.enqueue(RenderCommand.FORWARD);
				break;
			case 'R':
				r.enqueue(RenderCommand.FORWARD2);
				break;
			case 'X':
				r.enqueue(RenderCommand.IGNORE);
				break;
			case '-':
				r.enqueue(RenderCommand.RIGHT);
				break;
			case '+':
				r.enqueue(RenderCommand.LEFT);
				break;
				
			case '[':
				r.enqueue(RenderCommand.PUSH);
				break;
				
			case ']':
				r.enqueue(RenderCommand.POP);
				break;
			}
		}
		return r;
	}
	
	/**
	 * The toString method translates a linked list of enumerated
	 * RenderCommands and turns them into a single line of characters
	 * matching the traditional notation for each command. 
	 * return s				String of notations
	 */
	public String toString() {
		String s = "";
		Node pred = front;
		
			while (pred != null) {
				switch (pred.value) {
					case FORWARD:
						s += "F";
						break;
					case FORWARD2:
						s += "R";
						break;
					case IGNORE:
						s += "X";
						break;
					case RIGHT:
						s += "-";
						break;
					case LEFT:
						s += "+";
						break;
					case PUSH:
						s += "[";
						break;
					case POP:
						s += "]";
						break;
				}
			pred = pred.next;
			}
		return s;
	}
}
