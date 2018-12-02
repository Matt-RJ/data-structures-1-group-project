package application;
	
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
		
	static Library library = new Library();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		LinkList<String> stringList = new LinkList<>();
		LinkList<Book> bookList = new LinkList<>();
		
		stringList = new LinkList<>();
		stringList.add(new LinkNode<String>("The"));
		stringList.add(new LinkNode<String>("quick"));
		stringList.add(new LinkNode<String>("brown"));
		stringList.add(new LinkNode<String>("fox"));
		stringList.add(new LinkNode<String>("jumps"));
		stringList.add(new LinkNode<String>("over"));
		stringList.add(new LinkNode<String>("the"));
		stringList.add(new LinkNode<String>("lazy"));
		stringList.add(new LinkNode<String>("dog"));
		
		bookList = new LinkList<>();
		bookList.add(new LinkNode<Book>(new Book("The Martian")));
		bookList.add(new LinkNode<Book>(new Book("The Great Gatsby")));
		bookList.add(new LinkNode<Book>(new Book("Hamlet")));
		bookList.add(new LinkNode<Book>(new Book("Life of Pi")));
		bookList.add(new LinkNode<Book>(new Book("Wonder")));
		bookList.add(new LinkNode<Book>(new Book("Death and Nightingales")));
		bookList.add(new LinkNode<Book>(new Book("To Kill a Mockingbird")));
		bookList.add(new LinkNode<Book>(new Book("Catch 22")));
		bookList.add(new LinkNode<Book>(new Book("1984")));
		
		
		Sort<Book> sort = new Sort<>();
		sort.setSortArray(bookList.toArray());
		
		sort.mergeSort(sort.getSortArray(), (a,b) -> a.getContents().getAuthor().compareTo(b.getContents().getAuthor()));
		
		for (int i = 0; i < sort.getSortArray().length; i++) {
			
			System.out.println(sort.getSortArray()[i].getContents().getTitle());
			
		}
		
		launch(args);
	}
	
	
	// TODO
	// BOOKS
	
	/**
	 * Adds a new book to the system.
	 * @param book - The book to add.
	 */
	public static void addBook(Book book) {
		Library.bookHash.add(book);
	}
	
	public static void updateBook() {
		
	}
	
	public static void removeBook() {
		
	}
	
	
	// CHARACTERS
	
	/**
	 * Adds a new character to the system.
	 * @param character - The character to add.
	 */
	public static void addCharacter(Character character) {
		
	}
	
	public static void updateCharacter() {
		
	}
	
	public static void removeCharacter() {
		
	}
	
	// MISCELLANEOUS
	
	/**
	 * Saves the current library configuration to an XML file
	 * @throws IOException
	 */
	public static void save() throws IOException {
		// Prepares the variables to save
		library.setSavedCurrentBookID(Library.currentBookID);
		library.setSavedCurrentCharacterID(Library.currentCharacterID);
		library.setSavedBookHash(Library.bookHash);
		library.setSavedCharacterHash(Library.characterHash);
		library.setSavedSortedBooks(Library.sortedBooks);
		library.setSavedSortedCharacters(Library.sortedCharacters);
		
		
		FileOutputStream fos = new FileOutputStream(new File("./library.xml"));
		XMLEncoder encoder = new XMLEncoder(fos);
		encoder.writeObject(library);
		encoder.close();
		fos.close();
	}
	
	/**
	 * Loads the library configuration from an XML file
	 * @throws IOException
	 */
	public static void load() throws IOException {
		FileInputStream fis = new FileInputStream(new File("./library.xml"));
		XMLDecoder decoder = new XMLDecoder(fis);
		
		// Loading library from XML and replacing the static Library class variables
		Library tempLibrary = (Library) decoder.readObject();
		
		Library.currentBookID = tempLibrary.getSavedCurrentBookID();
		Library.currentCharacterID = tempLibrary.getSavedCurrentCharacterID();
		Library.bookHash = tempLibrary.getSavedBookHash();
		Library.characterHash = tempLibrary.getSavedCharacterHash();
		Library.sortedBooks = tempLibrary.getSavedSortedBooks();
		Library.sortedCharacters = tempLibrary.getSavedSortedCharacters();
		
		decoder.close();
		fis.close();
	}
}
