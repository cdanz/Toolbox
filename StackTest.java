/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

package danzc_lab9;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * The is a JUnit test class that has tests for all methods in Stack class.
 * @author danzc
 *
 */
public class StackTest {

	@Test
	public void testStack() {
		Stack test = new Stack();
		assertNotNull("something constructed, not nothing", test);
	}

	@Test
	public void testCopy() {
        Stack test = new Stack();
        Stack testCopy = test.copy();
        assertNotSame("after copy constructed", test, testCopy);
        assertTrue("not same but still equal", test.equals(testCopy));
        Stack copyOfCopy = testCopy.copy();
        assertNotSame("after second copy constructed from first", testCopy, 
        					copyOfCopy);
        assertTrue("nothing lost when copying copies", 
        				test.equals(copyOfCopy));
	}

	@Test
	public void testEmpty() {
        Stack test = new Stack();
        assertTrue("after construction", test.empty());
        test.push(1);
        assertFalse("after push", test.empty());
        test.peek();
        assertFalse("after push/peek", test.empty());
        test.pop();
        assertTrue("after push/pop", test.empty());
	}

	@Test
	public void testPush() {
        Stack test = new Stack();
        assertTrue("after construction", test.empty());
        test.push(1);
        assertFalse("after push", test.empty());
        assertEquals("as string should be '1'","1 ",test.toString());
        test.push(2);
        assertEquals("after adding 2 should be: '2 1'","2 1 ",test.toString());
        test.push(3.56);
        assertEquals("after adding a double, '3.56 2 1'","3.56 2 1 ",
        					test.toString());
        test.push("Pandas!");
        assertEquals("after adding a String, 'Pandas! 3.56 2 1'",
        					"Pandas! 3.56 2 1 ",test.toString());
        test.push('y');
        assertEquals("after adding a char, 'y Pandas! 3.56 2 1 '",
        					"y Pandas! 3.56 2 1 ",test.toString());
        test.push(true);
        assertEquals("after adding boolean, 'true y Pandas! 3.56 2 1 '",
        					"true y Pandas! 3.56 2 1 ",test.toString());
	}

	@Test(expected = IllegalStateException.class)
	public void testPop() {
        Stack test = new Stack();
        test.push(1);
        test.push(2);
        test.push(3.56);
        test.push("Pandas!");
        test.push('y');
        test.push(true);
        assertEquals("Value at top of stack is boolean true",true,
        					test.pop());
        assertEquals("Value at top now is char 'y'",'y',test.pop());
        assertEquals("Value at top now is String \"Pandas!\"","Pandas!",
        					test.pop());
        assertEquals("Value at top now is double 3.56",3.56,test.pop());
        assertEquals("Value at top now is integer 2",2,test.pop());
        assertEquals("Value at top now is integer 1",1,test.pop());
        assertTrue("Stack is now empty",test.empty());
        test.pop(); //expect exception when popping empty stack
	}

	@Test(expected = IllegalStateException.class)
	public void testPeek() {
        Stack test = new Stack();
        test.push(1);
        assertEquals("Value at top is integer 1",1,test.peek());
        test.push(2);
        assertEquals("Value at top now is integer 2",2,test.peek());
        test.pop();
        assertEquals("Value at top is integer 1",1,test.peek());      
        test.push("Pandas!");
        assertEquals("Value at top now is String \"Pandas!\"","Pandas!",
				test.peek());
        assertEquals("Value at top still is String \"Pandas!\"","Pandas!",
				test.peek());
        test.push('y');
        assertEquals("Value at top now is char 'y'",'y',test.peek());       
        test.push(true);
        assertEquals("Value at top of stack is boolean true",true,
        					test.peek());
        test.push(3.56);
        assertEquals("Value at top now is double 3.56",3.56,test.pop());
        test.pop();
        test.pop();
        test.pop();
        test.pop();
        test.pop();
        test.peek();  //expect exception when peeking at empty stack
	}

	@Test
	public void testEqualsStackOfT() {
        Stack test = new Stack();
        Stack testCopy = test.copy();
        assertTrue("after copy constructed",test.equals(testCopy));
        assertFalse("not same object",test == testCopy);
        testCopy.push("Thing");
        assertFalse("after only one gets new value pushed, false",
        				testCopy.equals(test));
        test.push("Thing");
        assertTrue("but when the other gets the same pushed, true",
        				test.equals(testCopy));
	}

	@Test
	public void testToString() {
        Stack test = new Stack();
        assertEquals("empty", "", test.toString());
        test.push(1);
        assertEquals("one element", "1 ", test.toString());
        test.push(2);
        assertEquals("two elements", "2 1 ", test.toString());
	}

}
