/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package danzc_lab8;

public class Lab8 {
	public static void main(String[] args) {
		Double d = new Double(2.35);
		Integer i = new Integer(92);
		String s = "Candy makes you dandy.";
		Character c = new Character('^');
		Boolean b = new Boolean(false);
		
		welcome();
		System.out.println("We have a number of varibles that are all " +
							"different data types.\n\n" +
							"d is a double: " + d + "\n" +
							"i is an integer: " + i + "\n" +
							"s is a String: " + s + "\n" +
							"c is a character: " + c + "\n" +
							"b is a boolean: " + b + "\n" +
							"\nLet's see if we can store them in stacks " +
							"and queues together. Then try all the common \n" +
							"methods for a stack and a queue to makes sure " +
							"they work despite their mismatched data \ntype " +
							"payloads.\n" +
							"\nFirst let's load up a stack and a queue with " +
							"all five variables.");
		Stack stack = new Stack();
		
		Queue queue = new Queue();
		stack.push(c);
		stack.push(s);
		stack.push(d);
		stack.push(b);
		stack.push(i);
		queue.enqueue(d);
		queue.enqueue(i);
		queue.enqueue(s);
		queue.enqueue(c);
		queue.enqueue(b);
		
		System.out.println("\nBoth have a toString method:\n" +
							"\ntoString with my stack: \n" + stack.toString() +
							"\n\nNow toString with my queue: \n" + 
							queue.toString());
		System.out.println("\nBoth have a copy method:\n"); 
		Stack stack2 = stack.copy();
		Queue queue2 = queue.copy();
		System.out.println("Stack 1: " + stack.toString() + 
							"\nStack 2: " + stack2.toString() +
							"\nQueue 1: " + queue.toString() +
							"\nQueue 2: " + queue2.toString());
		System.out.println("\nLet's make sure they are actually equal using " +
							"both's equals method. \nWe'll use an if " +
							"statement to print \"Suh-weet\" if the equals " +
							"returns true \nand a sad trumpet noise if it " +
							"doesn't.\n\nStack:");
		if (stack.equals(stack2)) {
			System.out.println("Suh-weet.");
		}
		else {
			System.out.println("Wah-waaaaaah");
		}
		System.out.println("\nQueue:");
		if (queue.equals(queue2)) {
			System.out.println("Suh-weet.\n");
		}
		else {
			System.out.println("Wah-waaaaaah");
		}
		
		System.out.println("Stack has the typical methods, push, pop, peek, " +
						   "empty");
		System.out.print("\nLet's make sure they all work as expected by " +
						   "pushing another two doubles... ");
		stack.push(d);
		stack.push(d);
		System.out.print("\nOur stack looks like this: " + stack.toString());
		System.out.print("\n\nNow pop all but the last one off, take a " +
						"peek at the remaining value, then pop it, and \n" +
						"finally use our empty method to make sure it is " +
						"empty:" +
						"\nPop: " + stack.pop() +
						"\nPop: " + stack.pop() +
						"\nPop: " + stack.pop() +
						"\nPop: " + stack.pop() +
						"\nPop: " + stack.pop() +
						"\nPop: " + stack.pop() +
						"\nPeek: " + stack.peek() +
						"\nPop: " + stack.pop() +
						"\nNow it should be empty, is it?: " + stack.empty());

		System.out.println("\n\nQueue also has typical methods, enqueue, " +
							"dequeue, peek, and empty. But it also has\n" +
							"append left over from a previous lab.");
		System.out.print("\nLet's make sure they all work as expected by " +
							"enqueuing another three characters... ");
		queue.enqueue(c);
		queue.enqueue(c);
		queue.enqueue(c);
		System.out.print("\nOur queue looks like this: " + queue.toString());
		System.out.print("\n\nNow dequeue all but the last value, take a " +
						"peek at the remaining one, dequeue it, and \n" +
						"finally use our empty method to make sure it is " +
						"empty:" +
						"\nDequeue: " + queue.dequeue() +
						"\nDequeue: " + queue.dequeue() +
						"\nDequeue: " + queue.dequeue() +
						"\nDequeue: " + queue.dequeue() +
						"\nDequeue: " + queue.dequeue() +
						"\nDequeue: " + queue.dequeue() +
						"\nDequeue: " + queue.dequeue() +					
						"\nPeek: " + queue.peek() +
						"\nDequeue: " + queue.dequeue() +
						"\nNow it should be empty, is it?: " + queue.empty() +
						"\n\nWe are almost done, hang in there. The final " +
						"thing we must do to prove all the \ngenerics work " +
						"is to use the append method. \n" +
						"We just dequeued our whole queue but we made a copy" +
						" earlier.\nLet's just append that to the emptied" +
						" queue twice and we will have\na queue that holds " +
						"all five data type values twice. \n" +
						"\nHere it goes, the grand finale:\n");
		queue.append(queue2);
		queue.append(queue2);
		System.out.println(queue.toString());
		farewell();
	}
	
	/**
	 * Welcomes the user to the program. 
	 */
	public static void welcome() {
		System.out.println("\n-------------------------\n" +
							"Generic Stacks and Queues   \n" +
							"----------------------------\n\n" +
							"Here we will demonstrate how generic stacks " +
							"and queues work.\n");
	}
	
	/**
	 * Wishes the user well before exiting. 
	 */
	public static void farewell() {
		System.out.println("\n\nWe did it! Thanks for sticking around to " +
							"evaluate my stacks and queues.\n\n");
	}
}
