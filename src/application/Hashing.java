package application;

/**
 * Handles hashing for Book and Character objects.
 * Its hash table uses separate chaining for collision resolution.
 * @author Mantas Rajackas
 *
 * @param <E>
 */
public class Hashing<E> {
	
	private LinkList<E>[] hashTable;

	@SuppressWarnings("unchecked")
	public Hashing(int size) {
		// Creates a hashTable of the correct size when instantiating
		hashTable = (LinkList<E>[]) new Object [size];
		
		// Inserts a 
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new LinkList<E>();
		}
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
	public float getLoadFactor() {
		float lf = 0.0f;
		int slotsFull = 0;
		
		for (LinkList<E> l : hashTable) {
			if (l.getHead() != null) slotsFull += 1;
		}
		
		lf = slotsFull / hashTable.length;
		return lf;
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
	
	// TODO: Add way to get objects from hash table
	
	/**
	 * Rehashes the hash table with a double hash table size
	 */
	public void reHash() {
		// TODO
	}
	
	
}