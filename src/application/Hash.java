package application;

/**
 * Handles hashing for Book and Character objects.
 * Its hash table uses separate chaining for collision resolution.
 * 
 * @author Mantas Rajackas
 *
 * @param <E> - The object being stored in the hash table
 */
public class Hash<E> {
	
	@SuppressWarnings("unchecked")
	private LinkList<E>[] hashTable = new LinkList[1];

	@SuppressWarnings("unchecked")
	public Hash(int size) {
		// Creates a hashTable of the correct size when instantiating
		hashTable = new LinkList[size];
		
		// Fills the hash table with empty LinkLists
		for (int i = 0; i < size; i++) {
			hashTable[i] = new LinkList<>();
		}
	}
	
	public Hash() {
		
	}
	
	public LinkList<E>[] getHashTable() {
		return hashTable;
	}
	
	public void setHashTable(LinkList<E>[] table) {
		this.hashTable = table;
	}
	
	/**
	 * Determines how full the hash table is - 0.0 is empty, 1.0 is full
	 * @return The load factor of the current hash table
	 */
	public double getLoadFactor() {
		double slotsFull = 0.0;
		
		for (LinkList<E> l : hashTable) {
			if (l.getHead() != null) slotsFull += 1;
		}
		
		try {
			return slotsFull / hashTable.length;
		}
		catch (ArithmeticException e) {
			return 0; // If the hashTable length is 0
		}
	}
	
	/**
	 * Determines where an object will be stored by its key
	 * @param key - The object key
	 * @param table - The hash table to map the key to
	 * @return - The location of where the object is to be stored
	 */
	@SuppressWarnings("rawtypes")
	public int hash(E key, LinkList[] table) {
		return Math.abs(key.hashCode())%table.length;
	}
	
	/**
	 * Determines where an object is in the hash table by its key
	 * @param key - The key of the object
	 * @return - The bucket's index that the key maps to
	 */
	public int hash(int key) {
		return Math.abs(key)%hashTable.length;
	}
	
	public int hash(int key, LinkList<E>[] table) {
		return Math.abs(key)%table.length;
	}
	
	/**
	 * Adds an object into the hashTable.
	 * @param object - The object to add
	 * @return The index of the object location in the hash table
	 */
	public int add(E object) {
		int location = hash(object, hashTable);
		
		if (getLoadFactor() >= 0.6) {
			reHash();
		}
		hashTable[location].add(new LinkNode<E>(object));
		return location;
	}
	
	/**
	 * Adds an object into a different hash table.
	 * @param object - The object to add
	 * @param table - The hash table to add to
	 * @return The index of the object location in the hash table
	 */
	public int add(E object, LinkList<E>[] table) {
		int location = hash(object, table);
		
		table[location].add(new LinkNode<E>(object));
		return location;
	}
	
	/**
	 * Removes an object from the hash table.
	 * @param toRemove - The object to remove
	 */
	public void remove(E toRemove) {
		// TODO: Test
		int location = hash(toRemove, hashTable);
		int i = 0;
		for (E item : hashTable[location]) {
			if (item.equals(toRemove)) {
				hashTable[location].remove(i);
			}
			i++;
		}
	}
	
	/**
	 * Removes an object from the hash table.
	 * @param key - The key of the object to remove
	 */
	public void removeByKey(int key) {
		// TODO: Test
		int i = 0;
		for (Object item : hashTable[key]) {
			if (item.hashCode() == key) {
				hashTable[key].remove(i);
			}
		}
	}
	
	/**
	 * Gets an item from the HashTable.
	 * @param key - The key of the object to search for
	 * @return An object with the same key
	 */
	public E get(int key) {
	
		E foundObject = null;
		
		// Gets the correct bucket
		LinkList<E> bucketFound = hashTable[hash(key)];
		
		// Linear searches through the bucket's LinkList
		for (E e : bucketFound) {
			if (e.hashCode() == key) foundObject = e;
		}
		
		return foundObject;
	}
	
	/**
	 * Rehashes the hash table with double its size.
	 */
	@SuppressWarnings("unchecked")
	public void reHash() {
		
		// TODO: Test this
		
		LinkList<E>[] newHashTable = new LinkList[hashTable.length * 2];
		
		for (LinkList<E> list : hashTable) {
			for (E e : list) {
				if (!e.equals(null)) {
					add(e, newHashTable);
				}
			}
		}
		
		this.hashTable = newHashTable;
	}
	
	/**
	 * Returns the hash table's contents as a LinkList
	 */
	public LinkList<E> toLinkList() {
		LinkList<E> list = new LinkList<E>();
		
		for (LinkList<E> l : this.hashTable) {
			for (E e : l) {
				if (!e.equals(null)) {
					list.add(new LinkNode<E>(e));
				}
			}
		}
		
		return list;
	}
	
	
	/**
	 * Turns the instance's hash table into an array of LinkNode objects,
	 * each containing a key present in the hash table. This conversion
	 * is required for MergeSort() to work.
	 * @return A LinkNode array of hash table keys
	 */
	public LinkNode<Integer>[] toNodeArray() {
		int pos = 0;
		
		@SuppressWarnings("unchecked")
		LinkNode<Integer>[] nodeArray = new LinkNode[this.getSize(hashTable)];
		
		// Checks each bucket
		for (LinkList<E> l : hashTable) {
			// Checks all nodes on each bucket's chain for non-empty nodes
			for (E m : l) {
				if (!m.equals(null)) {
					nodeArray[pos] = new LinkNode<Integer>(m.hashCode()); pos++;
				}
			}
		}
		
		return nodeArray;
	}
	
	
	/**
	 * Calculates how many items are in the hash table
	 * @return The number of non-empty nodes
	 */
	public int getSize(LinkList<E>[] hashTable) {
		int itemsInHashTable = 0;
		
		for (LinkList<E> l : hashTable) {
			itemsInHashTable += l.getSize();
		}
		return itemsInHashTable;
	}
	
}