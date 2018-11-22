package application;

/**
 * Handles the hashing of books and chracters.
 * @author Mantas Rajackas
 *
 * @param <E>
 */
public class Hashing<E> {
	
	private LinkList<E>[] hashTable;
	

	@SuppressWarnings("unchecked")
	public Hashing(int size) {
		hashTable = (LinkList<E>[]) new Object [size];
	}
	
	public LinkList<E>[] getTable() {
		return hashTable;
	}
	public void setTable(LinkList<E>[] table) {
		this.hashTable = table;
	}


	public int map(E object) {
		
		return 1;
	}
	
	
	
}