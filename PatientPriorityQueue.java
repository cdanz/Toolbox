/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_p2;

import java.util.ArrayList;

/**
 * Hospital triage system implemented using a heap.
 * @author bc3soln and danzc
 */
public class PatientPriorityQueue {
    private ArrayList<Patient> patients; // heap property is always satisfied
    private int nextPatientNumber;       // num assigned to next added patient

    /**
     * Creates an empty triage system with no patients.
     */
    public PatientPriorityQueue() {
        this.patients = new ArrayList<Patient>();
        this.nextPatientNumber = 1;
    }

    /**
     * Gets the list of patients currently in the waiting room
     * @return the list of patients that have not been called
     */
    public ArrayList<Patient> getPatientList() {
        return patients;
    }

    /**
     * This method adds a new patient into the priority heap. This method 
     * calls a recursive helper method if this isn't the first patient in the
     * heap so that it can percolate up if needed.
     * @param priorityCode				Int priority, 1 is highest 4 lowest
     * @param patientName				String holding patients name
     */
    public void addPatient(int priorityCode, String patientName) {
    		Patient incoming = new Patient(priorityCode, nextPatientNumber, 
    								patientName);
    		patients.add(incoming);
    		nextPatientNumber++;
    		percolateUp(patients.size() - 1);
    	}
    
    /**
     * Private recursive helper method. Reorganizes the heap so that the new
     * patient is given proper priority.
     * @param i						Current index of the new patient in 
     * 								the ArrayList
     */
	private void percolateUp(int i) {
		Patient temp;
		if (getParentIndex(i) >= 0) {
			if (hasHigherPriority(i, getParentIndex(i))) {
				temp = patients.get(getParentIndex(i));
				patients.add(getParentIndex(i), patients.get(i));
				patients.remove(getParentIndex(i) + 1);
				patients.add(i, temp);
				patients.remove(i + 1);
				percolateUp(getParentIndex(i));
			}
		}
	}
	
	   /**
	    * Removes the patient at the top of the heap and returns it.
	    * @return				Patient object with highest priority
	    */
	    public Patient dequeue() {
	    		Patient temp = peek();
	    		patients.remove(0);
	    		if (patients.size() > 0) { 
	    			patients.add(0, patients.get(patients.size() - 1));
	    			patients.remove(patients.size() - 1);
	    			percolateDown(0);
	    		}
	    		return temp;
	    }
	    
	    /**
	     * Recursive helper function. Looks at the element at the given
	     * index and swaps with its highest priority child if that child
	     * has a higher priority than it. 
	     * @param i					index of a patient element to be
	     * 							evaluated against its children
	     */
		private void percolateDown(int i) {
			Patient temp;
			if (i < patients.size()) {
				if (getLeftChildIndex(i) < patients.size() && 
						getRightChildIndex(i) < patients.size()) {
					if (hasHigherPriority(getLeftChildIndex(i), 
							getRightChildIndex(i))) {
						if (hasHigherPriority(getLeftChildIndex(i), i)) {
							temp = patients.get(i);
							patients.add(i, 
									patients.get(getLeftChildIndex(i)));
							patients.remove(i + 1);
							patients.add(getLeftChildIndex(i), temp);
							patients.remove(getLeftChildIndex(i) + 1);
							percolateDown(getLeftChildIndex(i));
						}
					}
					else if (hasHigherPriority(getRightChildIndex(i), 
							getLeftChildIndex(i))) {
						if (hasHigherPriority(getRightChildIndex(i), i)) {
							temp = patients.get(i);
							patients.add(i, 
									patients.get(getRightChildIndex(i)));
							patients.remove(i + 1);
							patients.add(getRightChildIndex(i), temp);
							patients.remove(getRightChildIndex(i) + 1);
							percolateDown(getRightChildIndex(i));
						}
					}
				}
				else if (getLeftChildIndex(i) < patients.size()) {
					if (hasHigherPriority(getLeftChildIndex(i), i)) {
						temp = patients.get(i);
						patients.add(i, patients.get(getLeftChildIndex(i)));
						patients.remove(i + 1);
						patients.add(getLeftChildIndex(i), temp);
						patients.remove(getLeftChildIndex(i) + 1);
						percolateDown(getLeftChildIndex(i));
					}
				}
			}
		}

	/**
	 * Calculates the index of this element index's parent.
	 * @param i						index of a patient element
	 * @return						index where the patient's parent
	 * 								would be found in the ArrayList.
	 */
	private int getParentIndex(int i) {
		return (i-1) / 2;
	}
	
	/**
	 * Calculates the index of this element index's left branch child.
	 * @param i						index of a patient element
	 * @return						index where the patient's left child
	 * 								would be found in the ArrayList.
	 */
	private int getLeftChildIndex(int i) {
		return i * 2 + 1;
	}
	
	/**
	 * Calculates the index of this element index's right branch child.
	 * @param i						index of a patient element
	 * @return						index where the patient's right child
	 * 								would be found in the ArrayList.
	 */
	private int getRightChildIndex(int i) {
		return i * 2 + 2;
	}

    /**
     * This method evaluates the priority of patients at two indexes first 
     * by priority code and then by arrival order. 
     * @param current					index of the patient we are evaluating
     * 									the priority of.
     * @param target						patient index against whom we are 
     * 									the current patient
     * @return boolean					True if and only if current has higher
     * 									priority than target. 
     */
    private boolean hasHigherPriority(int current, int target) {
    		if (patients.get(current).getPriorityCode() < 
    				patients.get(target).getPriorityCode()) 
    			return true;
    		if (patients.get(current).getPriorityCode() > 
    		patients.get(target).getPriorityCode()) 
    			return false;
    		if (patients.get(current).getArrivalOrder() < 
    				patients.get(target).getArrivalOrder())
    			return true;
    		if (patients.get(current).getArrivalOrder() > 
    		patients.get(target).getArrivalOrder())
    			return false;
    		return false;
    }

   /**
    * This method gets the patient at the front of the line without removing
    * it.
    * @return				Patient object with highest priority 
    */
    public Patient peek() {
        return patients.get(0);
    }

    /**
     * Returns the current size of the priority queue which is the same
     * as the current size of the ArrayList they are stored in.
     * @return					Integer representing heap size.
     */
    public int size() {
        return patients.size();
    }
    
    /**
     * Overrides provided toString with a more user-friendly string.
     * return string				String build from ArrayList Patient 
     * 							elements.
     */
    public String toString() {
    		String string = "";
    		for (int i = 1; i <= patients.size(); i++) {
    			string += "\n" + i + ") " + patients.get(i-1);
    		}
    		return string;
    }
}


