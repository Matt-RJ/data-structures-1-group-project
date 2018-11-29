package application;

public class Library {
	
	// Keeps track of the available IDs when creating
	public static int currentBookID = 1;
	public static int currentCharacterID = 1;
	
	// The primary storage for the program
	public static Hash<Book> bookHash = new Hash<>(25);
	public static Hash<Character> characterHash = new Hash<>(25);
	
	
	// SORTED FOR DISPLAYING
	public static Book[] sortedBooks;
	public static Character[] sortedCharacters;
	
	// Variables for saving the program
	private int savedCurrentBookID;
	private int savedCurrentCharacterID;
	private Hash<Book> savedBookHash;
	private Hash<Character> savedCharacterHash;
	private Book[] savedSortedBooks;
	private Character[] savedSortedCharacters;
	
	public Library() {
		
	}

	public int getSavedCurrentBookID() {
		return savedCurrentBookID;
	}
	public void setSavedCurrentBookID(int savedCurrentBookID) {
		this.savedCurrentBookID = savedCurrentBookID;
	}
	public int getSavedCurrentCharacterID() {
		return savedCurrentCharacterID;
	}
	public void setSavedCurrentCharacterID(int savedCurrentCharacterID) {
		this.savedCurrentCharacterID = savedCurrentCharacterID;
	}
	public Hash<Book> getSavedBookHsh() {
		return savedBookHash;
	}
	public void setSavedBookHsh(Hash<Book> savedBookHsh) {
		this.savedBookHash = savedBookHsh;
	}
	public Hash<Character> getSavedCharacterHash() {
		return savedCharacterHash;
	}
	public void setSavedCharacterHash(Hash<Character> savedCharacterHash) {
		this.savedCharacterHash = savedCharacterHash;
	}
	public Book[] getSavedSortedBooks() {
		return savedSortedBooks;
	}
	public void setSavedSortedBooks(Book[] savedSortedBooks) {
		this.savedSortedBooks = savedSortedBooks;
	}
	public Character[] getSavedSortedCharacters() {
		return savedSortedCharacters;
	}
	public void setSavedSortedCharacters(Character[] savedSortedCharacters) {
		this.savedSortedCharacters = savedSortedCharacters;
	}
	
}
