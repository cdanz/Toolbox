/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_p3;

/**
 * Maintains a hash table of unique words along with their frequency for a 
 * given text file. Various functions provide stats on the hash table. 
 * @author danzc
 *
 */
public class WordCounter {
	private Bucket[] table;  	// hash table, an array of linked bucket nodes
	private int uniqueCount;		// number of bucket entries in array
	private int totalCount;		// number of total words stored.
	
	/**
	 * Constructor of a WordCounter instance. 
	 * @param capacity			Size of array to house the hash table
	 */
    public WordCounter(int capacity) { 
        this.table = new Bucket[capacity];
        this.uniqueCount = 0;
        this.totalCount = 0;
    }
    
    /**
     * Capacity of hash table equal to the length of the Bucket array. 
     * Set originally with the constructor.
     * @return Array Length			How many buckets this table can hold
     * 								before linking to eachother.
     */
    public int getCapacity() {
        return table.length;
    }
    
    /**
     * Each entry stored in the hash table is unique so the overall count
     * of bucket instances in the table represents the unique word count.
     * @return count					Number of entries in the hash table.
     */
    public int getUniqueWordCount() { 
    		return uniqueCount;
    }
    
    /**
     * Accumulator tracks total number of words processed and stored in the 
     * table.
     * @return totalCount			Number of words including duplicates.
     */
    public int getTotalWordCount() { 
    		return totalCount;
    }
    
    /**
     * Returns true if the hash table has no entries.
     * @return boolean				True only if the hash table is empty.
     */  
    public boolean isEmpty() { 
    		return uniqueCount == 0;
    }
    
    /**
     * Adds a word to the table. First finds the proper index. If the
     * array is currently null at that index then it simply creates a 
     * new bucket to assign to it. If the index is already occupied, the
     * linked list is traversed looking for pre-existing instances of the
     * target word stored in a bucket. When found, it increments the count
     * of the word's bucket. If it is not found in the list than it is 
     * added as the new head. 
     * @param word					Word given to add to hash table		
     * @return totalCount			Incremented total word count
     */
    public int incrementWordCount(String word) {
        String lowWord = word.toLowerCase();
    		int hashCode = lowWord.hashCode();
        int idx = findBucketFor(hashCode);
        int wordCount = -1; 
        if(table[idx] == null) {
        		table[idx] = new Bucket(lowWord, null);
			uniqueCount++;
			totalCount++;
			wordCount = table[idx].count;
        }
        else {
        		Bucket currentNode = table[idx];
        		boolean found = false;
        		while (currentNode != null && !found) {
        			if (currentNode.word.equals(lowWord)) {
        				currentNode.count++;
        				wordCount = currentNode.count;
        				totalCount++;
        				found = true;
        			}
        			else {
        				currentNode = currentNode.next;
        			}
        		}
        		//Make new words the head of the linked list. 
        		//Next for this bucket should be the previous head.
        		if (!found) {
        			Bucket temp = table[idx];
        			table[idx] = new Bucket(lowWord, temp);
        			uniqueCount++;
        			totalCount++;
        			wordCount = table[idx].count;
        		}
        }
        return wordCount;
    }
    
    /**
     * Uses the hashCode to come up with a hash index to store a word.
     * Ensures the index returned is a positive integer.
     * @param searchKey				Hash code returned from the string.
     * @return index					Where the word will be stored in the
     * 								table. 
     */
    private int findBucketFor(int searchKey) {
        if (searchKey % table.length < 0)
        		return -(searchKey % table.length);
        else
        		return searchKey % table.length;
    }
    
    /**
     * Searches the hash table for a given word. Once found, returns
     * its individual frequency from the file it was loaded from.
     * @param word					Word to get the count for.
     * @return count					Count of occurrences of the given word
     */
    public int getWordCount(String word) {
        String lowWord = word.toLowerCase();
    		int hashCode = lowWord.hashCode();
        int idx = findBucketFor(hashCode);
        if(table[idx] == null) {
        		return 0;
        }
        else {
        		Bucket currentNode = table[idx];
        		while (currentNode != null) {
        			if (currentNode.word.equals(lowWord)) {
        				return currentNode.count;
        			}
        			else {
        				currentNode = currentNode.next;
        			}
        		}
        }
        return 0;
    }
    
    /**
     * Searches the hash table for a given word and removes its bucket 
     * when found. Takes care to maintain any linked lists that it may 
     * be a part of.
     * @param word					Word to be removed from hash table.
     */
    public void removeWord(String word) {
        String lowWord = word.toLowerCase();
    		int hashCode = lowWord.hashCode();
        int idx = findBucketFor(hashCode);
        if(table[idx] != null) {
        		Bucket previousNode = null;
        		Bucket currentNode = table[idx];
        		boolean found = false;
        		while (currentNode != null && !found) {
        			if (currentNode.word.equals(lowWord)) {
        				totalCount -= currentNode.count;
    					uniqueCount--;
    					found = true;
        				if (previousNode != null && 
        						currentNode.next != null) {
        					previousNode.next = currentNode.next;
        				}
        				else if (previousNode != null && 
        						currentNode.next == null) {
        					previousNode.next = null;
        				}
        				else if (previousNode == null && 
        						currentNode.next != null) {
        					table[idx] = currentNode.next;
        				}
        				else { //both previous node and next node are null
        					table[idx] = null;
        				}
        				
        			}
        			else {
        				previousNode = currentNode;
        				currentNode = currentNode.next;
        			}
        		}
        }
    }
    
    /**
     * Private sub class packaging up words in "Buckets" to be stored
     * and maintain basic stats on the word for.
     * @author danzc
     *
     */
    private static class Bucket {
        private String word;
        private int count;
        private Bucket next;
        /**
         * Constructor of a bucket. Needs a word and a bucket to be linked
         * to next. links to null if there is no next bucket. 
         * @param word				Word to store in a bucket
         * @param n					Bucket that this bucket should link to.
         */
		private Bucket(String word, Bucket n) {
			this.word = word;
			this.count = 1;
			this.next = n;
		}
    }
    
    @Override
    public String toString() {
    		Bucket currentNode = null;
        String s = "";
        int i;
        for(i = 0; i < table.length; i++) {
        		currentNode = table[i];
        		int node = 0;
        		while (currentNode != null) {
        			s += "Index " + i + ", Node " + node + ": \"" + 
        					currentNode.word + "\" Count: " + 
        					currentNode.count + "\n";
        			node++;
        			currentNode = currentNode.next;
        		}
        }
    		return s;
    }
}
