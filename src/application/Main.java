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
	 * Saves the current restaurant configuration to an XML file
	 * @throws IOException
	 */
	public static void save() throws IOException {
		// Getting non-static variables ready for saving
		/*
		restaurant.setSavedTableList(Restaurant.getTableList());
		restaurant.setSavedRestaurantMenuList(Restaurant.getRestaurantMenuList());
		
		private int savedCurrentBookID;
		private int savedCurrentCharacterID;
		private Hash<Book> savedBookHsh;
		private Hash<Character> savedCharacterHash;
		private Book[] savedSortedBooks;
		private Character[] savedSortedCharacters;
		*/
		
		library.setSavedCurrentBookID(Library.currentBookID);
		library.setSavedCurrentCharacterID(Library.currentCharacterID);
		
		
		
		// Saving non-static variables
		FileOutputStream fos = new FileOutputStream(new File("./library.xml"));
		XMLEncoder encoder = new XMLEncoder(fos);
		encoder.writeObject(library);
		encoder.close();
		fos.close();
	}
	
	/**
	 * Loads the restaurant configuration from an XML file
	 * @throws IOException
	 */
	public static void load() throws IOException {
		FileInputStream fis = new FileInputStream(new File("./restaurant.xml"));
		XMLDecoder decoder = new XMLDecoder(fis);
		
		// Loading restaurant from XML and replacing the Restaurant class variables
		Restaurant tempRestaurant = (Restaurant) decoder.readObject();
		Restaurant.setTableList(tempRestaurant.getSavedTableList());
		Restaurant.setRestaurantMenuList(tempRestaurant.getSavedRestaurantMenuList());
		
		decoder.close();
		fis.close();
	}
}
