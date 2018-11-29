package application;

/**
 * Handles hashing for Book and Character objects.
 * Its hash table uses separate chaining for collision resolution.
 * @author Mantas Rajackas
 *
 * @param <E> - The object being stored in the hash table
 */
public class Hash<E> {
	
	private LinkList<E>[] hashTable;

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
		// Only to be used for saving/loading
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
	 * @return - The location of where the object is to be stored
	 */
	public int hash(E key) {
		return Math.abs(key.hashCode())%hashTable.length;
	}
	
	/**
	 * Adds an object into the hashTable
	 * @param object - The object to add
	 * @return The index of the object location in the hash table
	 */
	public int add(E object) {
		// TODO: Test
		int location = hash(object);
		hashTable[location].add(new LinkNode<E>(object));
		return location;
	}
	
	/**
	 * Removes an object from the hash table
	 * @param toRemove
	 */
	public void remove(E toRemove) {
		// TODO: Test
		int location = hash(toRemove);
		int i = 0;
		for (E item : hashTable[location]) {
			if (item.equals(toRemove)) {
				hashTable[location].remove(i);
			}
			i++;
		}
	}
	
	// TODO: Add way to get objects from hash table
	
	/**
	 * TODO
	 * @return
	 */
	public E get() {
		E objectToReturn = null;
		
		// 1. Get the key of the item you want (Or other property)
		// 2. Get the correct bucket
		// 3. Iterate through the LinkList until the right item is found
		
		return objectToReturn;
	}
	
	/**
	 * Rehashes the hash table with a double hash table size
	 */
	public void reHash() {
		// TODO
	}
	
	
}