/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_lab9;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The is a JUnit test class that has tests for all methods in Queue class.
 * @author danzc
 *
 */
public class QueueTest {

	@Test
	public void testQueue() {
		Queue test = new Queue();
		assertNotNull("something constructed, not nothing", test);
	}

	@Test
	public void testCopy() {
        Queue test = new Queue();
        Queue testCopy = test.copy();
        assertNotSame("after copy constructed", test, testCopy);
        assertTrue("not same but still equal", test.equals(testCopy));
        Queue copyOfCopy = testCopy.copy();
        assertNotSame("after second copy constructed from first", testCopy, 
        					copyOfCopy);
        assertTrue("nothing lost when copying copies", 
        				test.equals(copyOfCopy));
	}

	@Test
	public void testEqualsQueueOfT() {
        Queue test = new Queue();
        Queue testCopy = test.copy();
        assertTrue("after copy constructed",test.equals(testCopy));
        assertFalse("not same object",test == testCopy);
        testCopy.enqueue("Thing");
        assertFalse("after only one gets new value pushed, false",
        				testCopy.equals(test));
        test.enqueue("Thing");
        assertTrue("but when the other gets the same pushed, true",
        				test.equals(testCopy));
	}

	@Test
	public void testAppend() {
		Queue test = new Queue();
	    test.enqueue(1);
	    test.enqueue(2);
	    test.enqueue(3.56);
	    test.enqueue("Pandas!");
	    test.enqueue('y');
	    test.enqueue(true);
	    	Queue testCopy = test.copy();
	    	testCopy.append(testCopy);
	    	assertEquals("Queue: \"" + test.toString() + "\" appended " +
	    					"with a copy of itself",test.toString() + 
	    					test.toString(),testCopy.toString());
	    	Queue test2 = new Queue();
	    	test2.append(test);
	    	assertEquals("Append a queue to a null queue",test2.toString(),
	    					test.toString());
	    	Queue test3 = new Queue();
	    	test.append(test3);
	    	assertEquals("Append a null queue to a queue",test.toString(),
	    					test2.toString());
	    	Queue test4 = new Queue();
	    	test3.append(test4);
	    	assertTrue("Append a null queue to a null queue",test3.empty());
	}

	@Test
	public void testEnqueue() {
        Queue test = new Queue();
        assertTrue("after construction", test.empty());
        test.enqueue(1);
        assertFalse("after enqueue", test.empty());
        assertEquals("as string should be '1'","1 ",test.toString());
        test.enqueue(2);
        assertEquals("after adding 2 should be: '1 2 '","1 2 ",test.toString());
        test.enqueue(3.56);
        assertEquals("after adding a double, '1 2 3.56 '","1 2 3.56 ",
        					test.toString());
        test.enqueue("Pandas!");
        assertEquals("after adding a String, '1 2 3.56 Pandas! '",
        					"1 2 3.56 Pandas! ",test.toString());
        test.enqueue('y');
        assertEquals("after adding a char, '1 2 3.56 Pandas! y '",
        					"1 2 3.56 Pandas! y ",test.toString());
        test.enqueue(true);
        assertEquals("after adding boolean, '1 2 3.56 Pandas! y true '",
        					"1 2 3.56 Pandas! y true ",test.toString());
	}

	@Test
	public void testEmpty() {
        Queue test = new Queue();
        assertTrue("after construction", test.empty());
        test.enqueue(1);
        assertFalse("after enqueue", test.empty());
        test.peek();
        assertFalse("after peek", test.empty());
        test.dequeue();
        assertTrue("after dequeue", test.empty());
	}

	@Test(expected = IllegalStateException.class)
	public void testPeek() {
        Queue test = new Queue();
        test.enqueue(1);
        assertEquals("Front value is integer 1",1,test.peek());
        test.enqueue(2);
        assertEquals("Front value still is integer 1",1,test.peek());
        test.dequeue();
        assertEquals("Front value is integer 2",2,test.peek());      
        test.enqueue("Pandas!");
        test.dequeue();
        assertEquals("Front value now is String \"Pandas!\"","Pandas!",
				test.peek());
        assertEquals("Front value still is String \"Pandas!\"","Pandas!",
				test.peek());
        test.dequeue();
        test.peek(); //expect exception when peeking at empty queue.
	}

	@Test(expected = IllegalStateException.class)
	public void testDequeue() {
		Queue test = new Queue();
	    test.enqueue(1);
	    test.enqueue(2);
	    test.enqueue(3.56);
	    test.enqueue("Pandas!");
	    test.enqueue('y');
	    test.enqueue(true);
	    assertEquals("Front value now is integer 1",1,test.dequeue());
	    assertEquals("Front value now is integer 2",2,test.dequeue());
	    assertEquals("Front value now is double 3.56",3.56,test.dequeue());
	    assertEquals("Front value now is String \"Pandas!\"","Pandas!",
				test.dequeue());
	    assertEquals("Front value now is char 'y'",'y',test.dequeue());
	    assertEquals("Front value of Queue is boolean true",true,
	    				test.dequeue());
	    assertTrue("Queue is now empty",test.empty());
	    test.dequeue(); //expect exception when dequeueing an empty queue
	}

	@Test
	public void testToString() {
        Queue test = new Queue();
        assertEquals("empty", "", test.toString());
        test.enqueue(1);
        assertEquals("one element", "1 ", test.toString());
        test.enqueue(2);
        assertEquals("two elements", "1 2 ", test.toString());
	}

}
