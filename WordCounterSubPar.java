/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_p3x;

/**
 * 
 * @author danzc
 *
 */
public class WordCounterSubPar {
	private Bucket[] table;  	// hash table, an array of linked bucket nodes
	private int uniqueCount;		// number of bucket entries in array
	private int totalCount;		// number of total words stored.
	private int[] primes = {
		    11, 13, 17, 19, 23, 29, 31, 37, 43, 53, 67, 79, 97, 107, 131, 
		    157, 191, 223, 269, 331, 389, 461, 557, 673, 797, 967, 1151, 
		    1381, 1657, 1979, 2377, 2851, 3433, 4111, 4931, 5923, 7103, 
		    8513, 10211, 12251, 14699, 17657, 21169, 25409, 30491, 36583, 
		    43889, 52667, 63199, 75853, 91009, 109211, 131059, 157259, 
		    188707, 226451, 271753, 326087, 391331, 469583, 563489, 676171, 
		    811411, 973691, 1168451, 1402123, 1682531, 2019037, 2422873, 
		    2907419, 3488897, 4186673, 5024009, 6028807, 7234589, 8681483,
		    10417769, 12501331, 15001603, 18001909, 21602311, 25922749, 
		    31107317, 37328761, 44794513, 53753431, 64504081, 77404907, 
		    92885893, 111463049, 133755659, 160506817, 192608173, 231129781, 
		    277355759, 332826869,399392243, 479270713, 575124829, 690149821, 
		    828179753, 993815743};
	
	//TODO what if the capacity is bigger than the available primes?
    public WordCounterSubPar(int capacity) { 
    		int index = 0;
    		while (capacity < primes[index])
    			index++;
        this.table = new Bucket[primes[index]];
        this.uniqueCount = 0;
        this.totalCount = 0;
    }
    
    public WordCounterSubPar() { 
    this.table = new Bucket[23]; //About 20 but prime
    this.uniqueCount = 0;
    this.totalCount = 0;
}
    
    /**
     * Capacity of hash table equal to the length of the Bucket array. 
     * Set originally with the constructor.
     * @return Array Length			How many buckets this table can hold
     */
    public int getCapacity() {
        return table.length;
    }
    
    /**
     * Each entry stored in the hash table is unique so the overall count
     * of entries in the table represents the unique word count.
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
     * @param startWord				Word given to add. 			
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
     * @param searchKey				Hashcode returned from the string.
     * @return index					Where the word will be stored in the
     * 								table. 
     */
    private int findBucketFor(int searchKey) {
        if (searchKey % table.length < 0)
        		return -(searchKey % table.length);
        else
        		return searchKey % table.length;
    }
    
    public int getWordCount(String word) {
        String lowWord = word.toLowerCase();
    		int hashCode = lowWord.hashCode();
        int idx = findBucketFor(hashCode);
        if(table[idx] == null) {
        		return -1;
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
        return -2;
    }
    
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
        				if (previousNode != null && currentNode.next != null) {
        					previousNode.next = currentNode.next;
        				}
        				else if (previousNode != null && currentNode.next == null) {
        					previousNode.next = null;
        				}
        				else if (previousNode == null && currentNode.next != null) {
        					table[idx] = currentNode.next;
        				}
        				else { //both previous node and next node are null
        					table[idx] = null;
        				}
        				
        			}
        			else {
        				currentNode = currentNode.next;
        			}
        		}
        }
    }

    private static class Bucket {
        private String word;
        private int count;
        private Bucket next;
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
        			s += "Index " + i + ", Node " + node + ": " + 
        					currentNode.word + currentNode.count + "\n";
        			node++;
        			currentNode = currentNode.next;
        		}
        }
    		return s;
    }
}
