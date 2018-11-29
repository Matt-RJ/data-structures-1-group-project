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
		
		Book book1 = new Book("The Martian");
		Book book2 = new Book("Harry Potter");
		Book book3 = new Book("Artemis");
		Book book4 = new Book("The Great Gatsby");
		Book book5 = new Book("Moby Dick");
		Book book6 = new Book("Hamlet");
		
		Library.bookHash.add(book1);
		Library.bookHash.add(book2);
		Library.bookHash.add(book3);
		Library.bookHash.add(book4);
		Library.bookHash.add(book5);
		Library.bookHash.add(book6);
		
		try {
			save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
