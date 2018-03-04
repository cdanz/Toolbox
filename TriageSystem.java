/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_p2x;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is an instance of a modified min heap. This heap evaluates both the
 * order in which a patient arrives and the severity of their condition to 
 * assess proper priority.
 * @author danzc
 */
public class TriageSystem {
    private static final String MSG_WELCOME = "Welcome to the triage " +
    								"system. Enter \"help\" for assistance.";
    private static final String MSG_GOODBYE = "I hope your triage went " +
    								"well. Goodbye.";
    private static final String MSG_HELP = 
    		"add <priority-code> <patient-name>\r\n" + 
    		"            Adds the patient to the triage system.\r\n" + 
    		"            <priority-code> must be one of the 4 accepted " +
    						"priority codes:\r\n" + 
    		"                1. immediate 2. emergency 3. urgent 4. " +
    						"minimal\r\n" + 
    		"            <patient-name>: patient's full legal name " +
    						"(may contain spaces)\r\n" + 
    		"next        Announces the patient to be seen next. Takes " +
    						"into account the\r\n" + 
    		"            type of emergency and the patient's arrival " +
    						"order.\r\n" + 
    		"peek        Displays the patient that is next in line, but " +
    						"keeps in queue\r\n" + 
    		"list        Displays the list of all patients that are still " +
    						"waiting\r\n" + 
    		"            in the order that they have arrived.\r\n" + 
    		"load <file> Reads the file and executes the command on each " +
    						"line\r\n" + 
    		"help        Displays this menu\r\n" + 
    		"quit        Exits the program";
    private static boolean keepAsking = true;

    /**
     * Entry point of the program
     * @param args not used
     */
    public static void main(String[] args) throws IOException {
        System.out.println(MSG_WELCOME);

        Scanner console = new Scanner(System.in);
        PatientPriorityQueue
            priQueue = new PatientPriorityQueue();
        while (keepAsking) {
            System.out.print("\ntriage> ");
            String line = console.nextLine();
            processLine(line, priQueue);
        }

        System.out.println(MSG_GOODBYE);
        console.close();
    }

    /**
     * Process the line entered from the user or read from the file
     * @param line     String command to execute
     * @param priQueue Priority Queue to operate on
     */
    private static void processLine(String line,
                          PatientPriorityQueue priQueue) throws IOException{

        Scanner lineScanner = new Scanner(line); // Scanner to extract words
        String cmd = lineScanner.next();         // The first is user's command

        // A switch statement could be used on strings, but not all have JDK7
        if (cmd.equals("help")) {
            System.out.println(MSG_HELP);
        } else if (cmd.equals("add")) {
            addPatient(lineScanner, priQueue);
        } else if (cmd.equals("peek")) {
            peekNextPatient(priQueue);
        } else if (cmd.equals("next")) {
            dequeueNextPatient(priQueue);
        } else if (cmd.equals("list")) {
            showPatientList(priQueue);
        } else if (cmd.equals("load")) {
            executeCommandsFromFile(lineScanner, priQueue);
        } else if (cmd.equals("debug")) {
            System.out.println(priQueue.toString());
        } else if (cmd.equals("change")) {
            changePriority(lineScanner, priQueue);
        } else if (cmd.equals("save")) {
            saveState(lineScanner, priQueue);
        } else if (cmd.equals("quit")) {
            keepAsking = false;
        } else {
            System.out.println("Error: unrecognized command: " + line);
        }
    }
    
    /**
     * Changes the priority of an existing patient in the queue. 
     * @param lineScanner 	Scanner remaining characters after the 
     * 						command `change`
     * @param priQueue    	priority queue to operate on
     */
    private static void changePriority(Scanner lineScanner, 
    			PatientPriorityQueue priQueue) {
    	int code = -1;
    int arrival = lineScanner.nextInt();
    int index;
    String priority = lineScanner.nextLine().trim();
        // A switch statement could be used on strings, but not all have JDK7
        if (priority.equals("immediate")) {
            code = 1;
        } else if (priority.equals("emergency")) {
            code = 2;
        } else if (priority.equals("urgent")) {
            code = 3;
        } else if (priority.equals("minimal")) {
            code = 4;
        } else {
            System.out.println("Error: unrecognized priority code: " + 
            						priority);
            return;
        }
        if (arrival < 1) {
        		System.out.println("Invalid arrival number: " + 
					arrival);
        		return;
        }
       index = priQueue.changePatientPriority(arrival, code);
       if (index == -1) {
    	   		System.out.println("ERROR - Please enter valid command:\n" +
    	   							"EXAMPLE: triage> change <arrival #> " +
    	   							"<new priority>");
       }
       else 
    	   		System.out.println("Patient priority changed to " + priority);
    }
    
    /**
     * Saves the current state of the triage queue. 
     * @param lineScanner 	Scanner remaining characters after the 
     * 						command `save` holding target file name
     * @param priQueue    	priority queue to operate on
     */
    private static void saveState(Scanner lineScanner, 
    		PatientPriorityQueue priQueue) throws IOException {
    		int i;
    		String fileName = lineScanner.nextLine().trim();
    		PrintWriter outputFile = new PrintWriter(fileName);
    		ArrayList<Patient> arr = priQueue.getArrivalOrderList();
    		for (i = 0; i < arr.size(); i++) {
    			outputFile.println("add " + 
    					(arr.get(i).getPriorityCode() == 1 ? 
        						"immediate" : (
        					arr.get(i).getPriorityCode() == 2 ? 
        						"emergency" : (
        					arr.get(i).getPriorityCode() == 3 ? 
        						"urgent" : (
        					arr.get(i).getPriorityCode() == 4 ? 
        							"minimal" : "ERROR")))) + " " +
        				arr.get(i).getName());
    			System.out.println("Saved " + arr.get(i).getName());
    		}
    		System.out.println("Saved " + i + " patients to file " + fileName);
    		outputFile.close();
    	}

    /**
     * Reads a text file with each command on a separate line and executes the
     * lines as if they were typed into the command prompt.
     * @param lineScanner Scanner remaining characters after the command `load`
     * @param priQueue    priority queue to operate on
     */
    private static void executeCommandsFromFile(Scanner lineScanner,
                           PatientPriorityQueue priQueue) throws IOException {
        // read the rest of the line into a single string
        String fileName = lineScanner.nextLine().trim();

        try {
            Scanner file = new Scanner(new File(fileName));
            while (file.hasNext()) {
                final String line = file.nextLine();
                System.out.println("\ntriage> " + line);
                processLine(line, priQueue);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.out.printf("File %s was not found.%n", fileName);
        }
    }

    /**
     * Displays the next patient in the waiting room that will be called.
     * @param priQueue priority queue to operate on
     */
    private static void peekNextPatient(PatientPriorityQueue priQueue) {
        if(priQueue.size() > 0)
    			System.out.println("Highest priority patient to be " +
    								"called next: " + 
    								priQueue.peek().getName());
        else
        		System.out.println("Patient queue is currently empty.");
    }

    /**
     * Displays the list of patients in the waiting room.
     * @param priQueue priority queue to operate on
     */
    private static void showPatientList(PatientPriorityQueue priQueue) {
    		ArrayList<Patient> patients = priQueue.getPatientList();
        System.out.println("# patients waiting: " + priQueue.size() + "\n");
        System.out.println("  Arrival #   Priority Code   Patient Name\n" +
                           "+-----------+---------------+--------------+");
        for (int i = 0; i < priQueue.size(); i++) {
        		System.out.printf("%7d       %-16s%-40s\n", 
        					patients.get(i).getArrivalOrder(), 
        					(patients.get(i).getPriorityCode() == 1 ? 
        						"Immediate" : (
        					patients.get(i).getPriorityCode() == 2 ? 
        						"Emergency" : (
        					patients.get(i).getPriorityCode() == 3 ? 
        						"Urgent" : (
        					patients.get(i).getPriorityCode() == 4 ? 
        							"Minimal" : "ERROR")))),
        				patients.get(i).getName());
        }
        System.out.println();
    }

    /**
     * Removes a patient from the waiting room and displays the name on the
     * screen.
     * @param priQueue priority queue to operate on
     */
    private static void dequeueNextPatient(
			PatientPriorityQueue priQueue) {
    		if (priQueue.size() > 0) {
    			Patient patient = priQueue.dequeue();
    			System.out.println("This patient will now be seen: " +
        						patient.getName());
    		}
    		else
    			System.out.println("Patient queue is currently empty.");
    }

    /**
     * Adds the patient to the waiting room.
     * @param lineScanner Scanner with remaining chars after the command
     * @param priQueue    priority queue to operate on
     */
    private static void addPatient(Scanner lineScanner,
                                   PatientPriorityQueue priQueue) {
    	int code = -1;
    	String parsed1 = lineScanner.next();
    String parsed2 = lineScanner.nextLine().trim();
    //Find how many spaces are at the end of the name string.
        // A switch statement could be used on strings, but not all have JDK7
        if (parsed1.equals("immediate")) {
            code = 1;
        } else if (parsed1.equals("emergency")) {
            code = 2;
        } else if (parsed1.equals("urgent")) {
            code = 3;
        } else if (parsed1.equals("minimal")) {
            code = 4;
        } else {
            System.out.println("Error: unrecognized priority code: " + 
            						parsed1);
            return;
        }
        priQueue.addPatient(code, parsed2);
        System.out.println("Added patient \"" + parsed2 + 
        						"\" to the priority system.");
    }
}
