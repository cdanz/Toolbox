package danz_p5;

import java.util.Random;
import java.util.Scanner;

public class HW4 {

	private static Scanner keyboard = new Scanner(System.in);
	private static final int SIZE = 12; //Size of collection

	/**
	 * This main method acts as the driver of the program.
	 */
	public static void main(String[] args) {
		welcome();
		do {
			String providedWord; //user determined word
			do {
				System.out.print("What word would you like to use that is "
						+ "at least 3 characters long?: ");
				providedWord = keyboard.nextLine();
			} while (providedWord.length() < 3);
			Inverter [] collection = new Inverter[SIZE];
			for(int i = 0; i < collection.length; i++) {
				if (i % 4 == 0) //4 because I have 4 class types I would 
					//like to cycle through to demonstrate
					collection[i] = new Sequence();
				else if (i % 4 == 1)
					collection[i] = new SequenceEnum();
				else if (i % 4 == 2)
					collection[i] = new SeqExtract();
				else 
					collection[i] = new SpasEnum();
			}
			System.out.println("\nAll objects should be inactive initially.");
			for(int i = 0; i < collection.length; i++) {
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Active?: " + 
						collection[i].isOn());
			}
			System.out.println("\nNow initialize with the word " + 
							providedWord + ".");
			for(int i = 0; i < collection.length; i++) {
				collection[i].setWord(providedWord);
			}
			System.out.println("\nAnd all objects should now be active.");
			for(int i = 0; i < collection.length; i++) {
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Active?: " + 
						collection[i].isOn());
			}
			System.out.println("\nLet's see what each emits.");
			for(int i = 0; i < collection.length; i++) {
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - " + 
						collection[i].emit());
			}
			System.out.println("\nMany functions common to all objects are "
					+ "not defined in the \ninterface so they can't be "
					+ "called directly from the collection but \nthere is a "
					+ "work around for testing.");
			System.out.println("\nTest Guess:");
			for(int i = 0; i < collection.length; i++) {
				Sequence s = (Sequence)collection[i];
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Guess " + 
						providedWord + " - " + s.guess(providedWord));
			}
			System.out.println("\nTest Reset:");
			for(int i = 0; i < collection.length; i++) {
				Sequence s = (Sequence)collection[i];
				s.reset();
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Reset. Active? - " + s.isOn());
			}
			for(int i = 0; i < collection.length; i++) {
				collection[i].setWord(providedWord);
			}
			System.out.println("\nTwo classes have functions unique to them.");
			System.out.println("\nFind them and test them:");
			SeqExtract q = new SeqExtract();
			SpasEnum p = new SpasEnum();
			for(int i = 0; i < collection.length; i++) {
				if (collection[i].getClass() == q.getClass()) {
					//test overloaded emit
					SeqExtract s = (SeqExtract)collection[i];
					System.out.println("Element " + (i + 1) + " - " + 
							collection[i].getClass() + " - Overloaded emit: " +
							s.emit(subSequence(providedWord)));
				}
				else if (collection[i].getClass() == p.getClass()) {
					//test overloaded emit
					SpasEnum s = (SpasEnum)collection[i];
					System.out.println("Element " + (i + 1) + " - " + 
							collection[i].getClass() + " - Alternative emit: "
							+ s.emitTrunc());
				}
				else
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Nothing special.");
			}
			System.out.println("\nThat's all the functionality to test.");
		} while (repeat("\nWould you like to run through this again? Y/N: "));
		farewell();
	}
	
	
	/**
	 * Welcomes the user with a friendly message.
	 */
	public static void welcome() {
		System.out.println("\n--------------------------------\n\n" +
	                       "   P5 - The Final Frontier\n\n" +
				           "---------------------------------\n\n" +
	                       "A Craig Danz Production\n");
	}
	
	/**
	 * This helper method creates a subsequence of a string parameter. 
	 * @param s				String to pull a subsequence from
	 * @return String		Subsequence of string.
	 */
	public static String subSequence(String s) {
		Random random = new Random();
		String newString = "";
		int atSubStart = random.nextInt(s.length() - 1);
		int atSubEnd = 0;
		do {
			atSubEnd = random.nextInt(s.length());
		} while (atSubEnd <= atSubStart); //Make sure you get a character index
		// greater than the start.
		
		for (int j = 0; j < (atSubEnd - atSubStart + 1); j++) {
			newString += s.charAt(atSubStart + j);
		}
		return newString;
	}
	
	/**
	 * This method checks to see if the user wants to perform an action again
	 * specified by the message passed to it. 
	 * @param msg			What do you want them to repeat? 
	 * @return boolean		If a desire to repeat : true else false.
	 */
	public static boolean repeat(String msg) {
		String input;
		char repeat;
		
		System.out.print(msg);
		input = keyboard.nextLine();
		repeat = input.charAt(0);
		if (repeat == 'y' || repeat == 'Y')
			return true;
		return false;
	}
	
	/**
	 * Bids the user farewell before exiting the program.
	 */
	public static void farewell()
	{
		keyboard.close();
		System.out.println("\n\nWe hope you enjoyed playing with some classes!\n\n");
	}

}
