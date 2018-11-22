package application;

/**
 * Handles the hashing of books and chracters.
 * @author Mantas Rajackas
 *
 * @param <E>
 */
public class Hashing<E> {
	
	@SuppressWarnings("unchecked")
	private LinkList<E>[] hashTable = (LinkList<E>[]) new Object [50];
	
	
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