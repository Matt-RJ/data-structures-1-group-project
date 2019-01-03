package application.controller;

import application.BookCharacter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * The controller for the character menu
 * 
 * @author Matt
 *
 */
public class CharacterMenuController {
	
	@FXML private TextField newName;
	@FXML private TextField newGender;
	@FXML private TextField newAge;
	@FXML private TextField newDescription;
	
	@FXML private Button addCharacterButton;
	
	
	
	/**
	 * 
	 */
	@FXML
	public void addCharacter() {
		
		// Gathers information from text fields
		String name = newName.getText();
		String gender = newGender.getText();
		int age = Integer.parseInt(newAge.getText());
		String description = newDescription.getText();
		
		BookCharacter characterToAdd = new BookCharacter(name, gender, age, description);
		
	}
	
}
