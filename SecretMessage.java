package danzc_p2EC;
/*
 * Craig Danz
 * CPSC 5002, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */

import java.util.Scanner;
import java.io.*;

/**
 * This class makes use of the MessageDecoder class in this package to decode
 * a file of the user's choosing. 
 * @author danzc
 *
 */
public class SecretMessage {
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		welcome();
		do {
			MessageDecoder secret1 = new MessageDecoder(getFile("Enter " +
									"secret file name: "));
			String secondFile = getFile("Enter another secret file name " +
									"(or blank): ");
			if (!secondFile.equals("")) {
				MessageDecoder secret2 = new MessageDecoder(secondFile);
				System.out.println("\nFirst file decoded is:\n" +
									secret1.getPlainTextMessage());
				System.out.println("\nSecond file decoded is:\n" +
						secret2.getPlainTextMessage());
				System.out.println("\nIntertwined:\n" +
						secret1.intertwine(secret2));
			}
			else {
				System.out.println("\nDecoded: " + 
						secret1.getPlainTextMessage());
			}
		} while (repeat("Would you like to decode another file? Y/N: "));
		
		farewell();
	}
	
	/**
	 * This method requests a file path to an encoded message from the user.
	 * Calls isValid method to ensure a proper file path is used. 
	 * @param msg			String message to ask for a file. 
	 * @return String 		String containing the file name. 
	 */
	private static String getFile(String msg) throws IOException {
		String input;
		
		System.out.print("\n" + msg);
		input = keyboard.nextLine();
		if (input.equals(""))
			return input;
		while (!isValidFile(input)) {
			System.out.print("\n" + msg);
			input = keyboard.nextLine();
		}
		return input;
	}
	
	/**
	 * Checks to see that the user-specified file name refers to a valid
	 * file on the disk and not a directory. Displays an error message to the
	 * user if that is not the case.
	 * @param fname 			File name string to check
	 * @return boolean 		True if file exists on disk and is not a directory
	 */
	private static boolean isValidFile(String fname) throws IOException {
	    File path = new File(fname);
	    boolean isValid = path.exists() && !path.isDirectory();
	    if (!isValid) {
	        System.out.println("File does not exist or is a directory.");
	    }
	    return isValid;
	}
	
	/**
	 * This method checks to see if the user wants to perform an action again
	 * specified by the message passed to it. 
	 * @param msg			What do you want them to repeat? 
	 * @return boolean		If a desire to repeat : true else false.
	 */
	private static boolean repeat(String msg)
	{
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
	 * Welcomes the user to the program. 
	 */
	private static void welcome() {
		System.out.println("\n\nThis program reads a coded file provided by " +
							"the user then decodes it and displays the " +
							"secret message inside.\n");
	}
	
	/**
	 * Wishes the user well before exiting. 
	 */
	private static void farewell() {
		System.out.println("\n\nThanks for using the message decoder!\n");
	}
}
