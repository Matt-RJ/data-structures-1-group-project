package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	/**
	 * TODO:
	 *	- Add hashing overall
	 *		- Add hash tables (Where the books and characters are stored)
	 *		- Add hash methods to return an int of where each book/char go in the table
	 *		- Add collision resolution to the hash tables 
	 *
	 */
	
	
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
	
	public void addBook() {
		
	}
	
	public void updateBook() {
		
	}
	
	public void removeBook() {
		
	}
	
	
	// CHARACTERS
	
	public void addCharacter() {
		
	}
	
	public void updateCharacter() {
		
	}
	
	public void removeCharacter() {
		
	}
	
}
