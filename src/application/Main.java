package application;
	
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/*
 * TODO: Add searching:
 * 			- Sort by the field being searched (e.g. if searching or a title, sort by title. Then do a binary search to find a match)
 * 
 */

/**
 * This is a book and character management system.
 * Books and characters can be added, removed. They are stored in hash tables.
 * When viewing the contents of the hash tables, the contents are sorted by a 
 * chosen property.
 * 
 * @author Mantas Rajackas
 *
 */
public class Main extends Application {
		
	static Library library = new Library();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("scene/MainMenu.fxml"));
			Scene scene = new Scene(root,1280,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			load();
		} catch (IOException e) {
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
		System.out.println("Book with the name " + book.getTitle() + " added.");
	}
	
	public static void removeBook(Book bookToRemove) {
		Library.bookHash.remove(bookToRemove);
		System.out.println("Book with the name " + bookToRemove.getTitle() + " removed.");
	}
	
	
	// CHARACTERS
	
	/**
	 * Adds a new character to the system.
	 * @param character - The character to add.
	 */
	public static void addCharacter(BookCharacter character) {
		Library.bookCharacterHash.add(character);
		System.out.println("Character with the name " + character.getName() + " added.");
	}
	
	public static void removeCharacter(BookCharacter charToRemove) {
		Library.bookCharacterHash.remove(charToRemove);
		System.out.println("Character with the name " + charToRemove.getName());
	}
	
	// MISCELLANEOUS
	
	/**
	 * Saves the current library configuration to an XML file
	 * @throws IOException
	 */
	public static void save() throws IOException {
		// Prepares the variables to save
		library.setSavedCurrentBookID(Library.currentBookID);
		library.setSavedCurrentBookCharacterID(Library.currentBookCharacterID);
		library.setSavedBookHash(Library.bookHash);
		library.setSavedBookCharacterHash(Library.bookCharacterHash);
		library.setSavedBookKeys(Library.bookKeys);
		library.setSavedBookCharacterKeys(Library.bookCharacterKeys);
		
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
		Library.currentBookCharacterID = tempLibrary.getSavedCurrentBookCharacterID();
		Library.bookHash = tempLibrary.getSavedBookHash();
		Library.bookCharacterHash = tempLibrary.getSavedBookCharacterHash();
		Library.bookKeys = tempLibrary.getSavedBookKeys();
		Library.bookCharacterKeys = tempLibrary.getSavedBookCharacterKeys();
		
		decoder.close();
		fis.close();
	}
	
	/**
	 * Saves the current Library setup and exits the program.
	 */
	public static void exitProgram() {
		try {
			save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
}
