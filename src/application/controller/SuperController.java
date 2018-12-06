package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SuperController {
	
	@FXML private Button toMainMenuButton;
	@FXML private Button toBookMenuButton;
	@FXML private Button toCharacterMenuButton;
	
	@FXML
	public void exitProgram(ActionEvent event) {
		Main.exitProgram();
	}
	
	@FXML
	public void switchScene(ActionEvent event) throws IOException {
		Stage stage = null;
		FXMLLoader loader;
		Parent root = null;
				
		// Loads the main menu
		if (event.getSource().equals(toMainMenuButton)) {
			stage = (Stage) toMainMenuButton.getScene().getWindow();
			loader = new FXMLLoader(getClass().getResource("../scene/MainMenu.fxml"));
			root = loader.load();
		}
		
		// Loads the books menu
		if (event.getSource().equals(toBookMenuButton)) {
			stage = (Stage) toBookMenuButton.getScene().getWindow();
			loader = new FXMLLoader(getClass().getResource("../scene/BookMenu.fxml"));
			root = loader.load();
		}
		 
		// Loads the book menu
		if (event.getSource().equals(toCharacterMenuButton)) {
			stage = (Stage) toCharacterMenuButton.getScene().getWindow();
			loader = new FXMLLoader(getClass().getResource("../scene/BookMenu.fxml"));
			root = loader.load();
		}
		
		
		// Changes to new scene
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
