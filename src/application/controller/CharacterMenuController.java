package application.controller;

import application.Book;
import application.BookCharacter;
import application.Library;
import application.Main;
import application.Sort;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * The controller for the character menu
 * 
 * @author Matt
 *
 */
public class CharacterMenuController extends SuperController {
	
	@FXML private TextField newName;
	@FXML private TextField newGender;
	@FXML private TextField newAge;
	@FXML private TextField newDescription;
	
	@FXML private Button addCharacterButton;
	
	@FXML private TextField toDeleteCharIndex;
	@FXML private Button deleteCharacter;
	
	
	
	/**
	 * Adds a new character to the system
	 */
	@FXML
	public void addCharacter() {
		
		// Gathers information from text fields
		String name = newName.getText();
		String gender = newGender.getText();
		int age = Integer.parseInt(newAge.getText());
		String description = newDescription.getText();
		
		BookCharacter characterToAdd = new BookCharacter(name, gender, age, description);
		
		Main.addCharacter(characterToAdd);
		
	}
	
	@FXML
	public void deleteCharacter() {
		int charIndex = Integer.parseInt(toDeleteCharIndex.getText());
		int charKey = Library.bookCharacterKeys[charIndex];
		BookCharacter charToRemove = null;
		
		charToRemove = Library.bookCharacterHash.get(charKey);
		
		Main.removeCharacter(charToRemove);
	}
	
	
	/**
	 * Sorts all books by their titles and displays them
	 * @param e
	 */
	public void sortByName(ActionEvent e) {
		Library.sortBookCharactersByName();
		String sortedBookCharacters = "Showing all characters, sorted by name: \n\n";
		for (int i = 0; i < Library.bookCharacterKeys.length; i++) {
			sortedBookCharacters += "Index: " + i + "\n";
			sortedBookCharacters += Library.bookCharacterHash.get(Library.bookCharacterKeys[i]).toString();
			sortedBookCharacters += "\n\n";
		}
		printToInfoPanel(sortedBookCharacters);
		
	}
	
	/**
	 * Sorts all books by their titles and displays them
	 * @param e
	 */
	public void sortByAge(ActionEvent e) {
		Library.sortBookCharactersByAge();
		String sortedBookCharacters = "Showing all characters, sorted by age: \n\n";
		for (int i = 0; i < Library.bookCharacterKeys.length; i++) {
			sortedBookCharacters += "Index: " + i + "\n";
			sortedBookCharacters += Library.bookCharacterHash.get(Library.bookCharacterKeys[i]).toString();
			sortedBookCharacters += "\n\n";
		}
		printToInfoPanel(sortedBookCharacters);
		
	}
	
	/**
	 * Sorts all books by their titles and displays them
	 * @param e
	 */
	public void sortByGender(ActionEvent e) {
		Library.sortBookCharactersByGender();
		String sortedBookCharacters = "Showing all characters, sorted by gender: \n\n";
		for (int i = 0; i < Library.bookCharacterKeys.length; i++) {
			sortedBookCharacters += "Index: " + i + "\n";
			sortedBookCharacters += Library.bookCharacterHash.get(Library.bookCharacterKeys[i]).toString();
			sortedBookCharacters += "\n\n";
		}
		printToInfoPanel(sortedBookCharacters);
		
	}
	
	/**
	 * Sorts all books by their titles and displays them
	 * @param e
	 */
	public void sortByDescription(ActionEvent e) {
		Library.sortBookCharactersByDescription();
		String sortedBookCharacters = "Showing all characters, sorted by description: \n\n";
		for (int i = 0; i < Library.bookCharacterKeys.length; i++) {
			sortedBookCharacters += "Index: " + i + "\n";
			sortedBookCharacters += Library.bookCharacterHash.get(Library.bookCharacterKeys[i]).toString();
			sortedBookCharacters += "\n\n";
		}
		printToInfoPanel(sortedBookCharacters);
		
	}
}
