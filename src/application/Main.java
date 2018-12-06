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
import javafx.scene.layout.BorderPane;


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
