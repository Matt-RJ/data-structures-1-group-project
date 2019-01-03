package application;

import java.util.Comparator;

/**
 * This class contains the hash tables of books and characters, as well
 * as the relevant methods to manage them.
 * @author Mantas Rajackas
 *
 */
public class Library {
	
	// Keeps track of the available IDs when creating
	public static int currentBookID = 1;
	public static int currentBookCharacterID = 1;
	
	// The primary form storage for the program
	public static Hash<Book> bookHash = new Hash<>(25);
	public static Hash<BookCharacter> bookCharacterHash = new Hash<>(25);
	
	
	// Arrays of keys for retrieving Book and Character objects (Sorted).
	public static int[] bookKeys;
	public static int[] bookCharacterKeys;
	
	// Variables for saving the program
	private int savedCurrentBookID;
	private int savedCurrentBookCharacterharacterID;
	private Hash<Book> savedBookHash;
	private Hash<BookCharacter> savedBookCharacterHash;
	private int[] savedBookKeys;
	private int[] savedBookCharacterKeys;
	
	public Library() {
		
	}

	public int getSavedCurrentBookID() {
		return savedCurrentBookID;
	}
	public void setSavedCurrentBookID(int savedCurrentBookID) {
		this.savedCurrentBookID = savedCurrentBookID;
	}
	public int getSavedCurrentBookCharacterID() {
		return savedCurrentBookCharacterharacterID;
	}
	public void setSavedCurrentBookCharacterID(int savedCurrentBookCharacterID) {
		this.savedCurrentBookCharacterharacterID = savedCurrentBookCharacterID;
	}
	public Hash<Book> getSavedBookHash() {
		return savedBookHash;
	}
	public void setSavedBookHash(Hash<Book> savedBookHash) {
		this.savedBookHash = savedBookHash;
	}
	public Hash<BookCharacter> getSavedBookCharacterHash() {
		return savedBookCharacterHash;
	}
	public void setSavedBookCharacterHash(Hash<BookCharacter> savedBookCharacterHash) {
		this.savedBookCharacterHash = savedBookCharacterHash;
	}
	public int[] getSavedBookKeys() {
		return savedBookKeys;
	}
	public void setSavedBookKeys(int[] savedBookKeys) {
		this.savedBookKeys = savedBookKeys;
	}
	public int[] getSavedBookCharacterKeys() {
		return savedBookCharacterKeys;
	}
	public void setSavedBookCharacterKeys(int[] savedBookCharacterKeys) {
		this.savedBookCharacterKeys = savedBookCharacterKeys;
	}
	
	
	
	// SORTING
	
	/**
	 * Encapsulates each int in an int array with a LinkNode
	 * @return
	 */
	public LinkNode<Integer>[] toNodeArray(int[] intArray) {
		@SuppressWarnings("unchecked")
		LinkNode<Integer>[] linkNodeArray = new LinkNode[intArray.length];
		
		for (int i = 0; i < intArray.length; i++) {
			linkNodeArray[i] = new LinkNode<Integer>(intArray[i]);
		}
		
		return linkNodeArray;
	}
	
	/**
	 * Sorts the books in bookHash by their titles
	 */
	public static void sortBooksByTitle() {
		// Preparation for sorting
		Sort<Integer> sort = new Sort<Integer>(Library.bookHash.toNodeArray());
		sort.setSortArray(Library.bookHash.toNodeArray());
		
		// Using merge sort on all books
		sort.mergeSort(sort.getSortArray(),(a,b) -> 
		bookHash.get(a.getContents()).getTitle()
		.compareTo(bookHash.get(b.getContents()).getTitle()));
		
		// Updates the Library's sorted book key field with the books
		Library.bookKeys = sort.getSortArrayAsPrimitive();
	}
	
	/**
	 * Sorts the books in bookHash by their authors
	 */
	public static void sortBooksByAuthor() {
		// Preparation for sorting
		Sort<Integer> sort = new Sort<Integer>(Library.bookHash.toNodeArray());
		sort.setSortArray(Library.bookHash.toNodeArray());
		
		// Using merge sort on all books
		sort.mergeSort(sort.getSortArray(),(a,b) -> 
		bookHash.get(a.getContents()).getAuthor()
		.compareTo(bookHash.get(b.getContents()).getAuthor()));
		
		// Updates the Library's sorted book key field with the books
		Library.bookKeys = sort.getSortArrayAsPrimitive();
	}
	
	/**
	 * Sorts the books in bookHash by their years
	 */
	public static void sortBooksByYear() {
		// Preparation for sorting
		Sort<Integer> sort = new Sort<Integer>(Library.bookHash.toNodeArray());
		sort.setSortArray(Library.bookHash.toNodeArray());
		
		// Using merge sort on all books
		sort.mergeSort(sort.getSortArray(),(a,b) -> 
		new Integer(bookHash.get(a.getContents()).getYearOfPublication())
		.compareTo(new Integer(bookHash.get(b.getContents()).getYearOfPublication())));
		
		// Updates the Library's sorted book key field with the books
		Library.bookKeys = sort.getSortArrayAsPrimitive();
	}
	
	/**
	 * Sorts the books in bookHash by their page counts
	 */
	public static void sortBooksByPages() {
		// Preparation for sorting
		Sort<Integer> sort = new Sort<Integer>(Library.bookHash.toNodeArray());
		sort.setSortArray(Library.bookHash.toNodeArray());
		
		// Using merge sort on all books
		sort.mergeSort(sort.getSortArray(),(a,b) -> 
		new Integer(bookHash.get(a.getContents()).getNumberOfPages())
		.compareTo(new Integer(bookHash.get(b.getContents()).getNumberOfPages())));
		
		// Updates the Library's sorted book key field with the books
		Library.bookKeys = sort.getSortArrayAsPrimitive();
	}
	
	/**
	 * Sorts the books in bookHash by their genres
	 */
	public static void sortBooksByGenre() {
		// Preparation for sorting
		Sort<Integer> sort = new Sort<Integer>(Library.bookHash.toNodeArray());
		sort.setSortArray(Library.bookHash.toNodeArray());
		
		// Using merge sort on all books
		sort.mergeSort(sort.getSortArray(),(a,b) -> 
		bookHash.get(a.getContents()).getGenre()
		.compareTo(bookHash.get(b.getContents()).getGenre()));
		
		// Updates the Library's sorted book key field with the books
		Library.bookKeys = sort.getSortArrayAsPrimitive();
	}
	
	/**
	 * Sorts the characters in characterHash by their names
	 */
	public static void sortBookCharactersByName() {
		// Preparation for sorting
		Sort<Integer> sort = new Sort<Integer>(Library.bookCharacterHash.toNodeArray());
		sort.setSortArray(Library.bookCharacterHash.toNodeArray());
		
		// Using merge sort on all books
		sort.mergeSort(sort.getSortArray(),(a,b) -> 
		bookCharacterHash.get(a.getContents()).getName()
		.compareTo(bookCharacterHash.get(b.getContents()).getName()));
		
		// Updates the Library's sorted book key field with the books
		Library.bookCharacterKeys = sort.getSortArrayAsPrimitive();
	}
	
	/**
	 * Sorts the characters in characterHash by their genders
	 */
	public static void sortBookCharactersByGender() {
		// Preparation for sorting
		Sort<Integer> sort = new Sort<Integer>(Library.bookCharacterHash.toNodeArray());
		sort.setSortArray(Library.bookCharacterHash.toNodeArray());
			
		// Using merge sort on all books
		sort.mergeSort(sort.getSortArray(),(a,b) -> 
		bookCharacterHash.get(a.getContents()).getGender()
		.compareTo(bookCharacterHash.get(b.getContents()).getGender()));
			
		// Updates the Library's sorted book key field with the books
		Library.bookCharacterKeys = sort.getSortArrayAsPrimitive();
	}
	
	/**
	 * Sorts the characters in characterHash by their ages
	 */
	public static void sortBookCharactersByAge() {
		// Preparation for sorting
		Sort<Integer> sort = new Sort<Integer>(Library.bookCharacterHash.toNodeArray());
		sort.setSortArray(Library.bookCharacterHash.toNodeArray());
			
		// Using merge sort on all books
		sort.mergeSort(sort.getSortArray(),(a,b) -> 
		new Integer(bookCharacterHash.get(a.getContents()).getAge())
		.compareTo(new Integer(bookCharacterHash.get(b.getContents()).getAge())));
			
		// Updates the Library's sorted book key field with the books
		Library.bookCharacterKeys = sort.getSortArrayAsPrimitive();
	}
	
	/**
	 * Sorts the characters in characterHash by their descriptions
	 */
	public static void sortBookCharactersByDescription() {
		// Preparation for sorting
		Sort<Integer> sort = new Sort<Integer>(Library.bookCharacterHash.toNodeArray());
		sort.setSortArray(Library.bookCharacterHash.toNodeArray());
			
		// Using merge sort on all books
		sort.mergeSort(sort.getSortArray(),(a,b) -> 
		bookCharacterHash.get(a.getContents()).getDescription()
		.compareTo(bookCharacterHash.get(b.getContents()).getDescription()));
			
		// Updates the Library's sorted book key field with the books
		Library.bookCharacterKeys = sort.getSortArrayAsPrimitive();
	}
	
}
