/*
 * Craig Danz
 * CPSC 5003, Seattle University
 * This is free and unencumbered software released into the public domain.
 */

package danzc_lab5;

/**
 * This is an implementation of a hash table. It takes in a key and a value
 * to store, it then gets an index to store the key/value pair within a
 * bucket in an array of buckets. If a collision happens it uses linear 
 * probing to find the next available slot.
 * @author danzc
 *
 */
public class HashTable {
	private static HashBucket[] table;
	private static int size;
	private HashBucket bucket;
    public HashTable(int capacity) {
    		table = new HashBucket[capacity];
    		size = 0;
    }
    
	/**
	 * Associates the specified value with the specified key in this 
	 * HashTable. If the HashTable previously contained a mapping 
	 * for the key, the old value is replaced. Collisions are 
	 * resolved using linear probing. It returns the previous value 
	 * associated with key, or -1 if there was no mapping for key. 
	 * A -1 return can also indicate that the HashTable previously 
	 * associated -1 with key, this ambiguity is easily resolved 
	 * using the contains method described below.
	 * @param key			key value to code and match to a storage index
	 * @param value			int value to be stored
	 */   
    public int put(int key, int value) {
    		int temp;
		if (table[getCode(key) + probe(key, 0)] == null) {
    			bucket = new HashBucket(key, value);
    			table[getCode(key) + probe(key, 0)] = bucket;
    			return -1;
    		}
    		else {
    			temp = table[getCode(key) + probe(key, 0)].value;
    			table[getCode(key) + probe(key, 0)].value = value;
    			return temp;
    		}
    }
    
    /**
     * Does any of the necessary linear probing to find the right shift in
     * order to map the key.
     * @param key				Given key from the key/value pair
     * @param shift				Number of shifts needed to find an opening
     * @return shift				Necessary shifts to make. 
     */
    private int probe(int key, int shift) {
   		if (key < 0)
   			shift += -key;
    		if ((getCode(key) + shift) >= table.length)
    			//wrap to the beginning of the array
    			shift = -(getCode(key));
    		if (table[getCode(key) + shift] == null)
			return shift;
    		if (table[getCode(key) + shift].key == key)
			return shift;
    		else
    			return probe(key, ++shift);
    }
    
    
    /**
     * Returns the value to which the specified key is mapped, or -1 
     * if this HashTable contains no mapping for the key. A return 
     * value of -1 does not necessarily indicate that the HashTable 
     * contains no mapping for the key; it's also possible that the 
     * HashTable explicitly maps the key to -1. It returns a value 
     * associated with the specified key or -1 if it does not exist.
     * @param key				Given key from the key/value pair
     * @return value				Value stored at the mapping for the 
     * 							key or -1 if no value is stored. 
     */
    public int get(int key) {
    		if (contains(key) == false)
			return -1;
    		else if (table[getCode(key) + probe(key, 0)] != null)
    			return table[getCode(key) + probe(key, 0)].value;
    		else
    			return -1;
    }
    
    /**
     * Returns true if this HashTable contains a mapping for the 
     * specified key.
     * @param key				Given key from the key/value pair
     * @return boolean			True if and only if there is an existing 
     * 							mapping for the given key.
     */
    public boolean contains(int key) {
    		if (size != table.length)
    			return table[getCode(key) + probe(key, 0)] != null;
    		else 
    			for (int i = 0; i < table.length; i++) {
    				if(table[i].key == key)
    					return true;
    			}
    		return false;
    }
    
    /**
     * Returns the number of unique keys stored in the table.
     * @return size			Number of buckets in the table. 
     */
    public int size() {
    		return size;
    }
    
    /**
     * Returns true if the HashTable is empty.
     * @return boolean		True if and only if the table is empty.
     */
    public boolean isEmpty() {
    		return size == 0;
    }
    
    /**
     * Takes in a key and generates a hash code for it. 
     * @param key
     * @return index			Where the key/value pair should be stored
     * 						in the array if available.
     */
    private int getCode(int key) {
    		return key % table.length;
    }
    
    /**
     * Private class that packages up the key/value pairs in a "bucket"
     * @author danzc
     *
     */
    private static class HashBucket {
        private final int key;
        private int value;

        /**
         * Constructor of private bucket class
         * @param key			int key to be stored
         * @param value			int value to be stored
         */
        public HashBucket(int key, int value) {
            this.key = key;
            this.value = value;
            size++;
        }
    }
}
