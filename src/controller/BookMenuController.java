package controller;
import application.Book;
import application.Main;
import javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BookMenuController {
	
	// Adding a new book to the system
	@FXML private TextField newTitle;
	@FXML private TextField newAuthor;
	@FXML private TextField newYearOfPublication;
	@FXML private TextField newNumberOfPages;
	@FXML private TextField newGenre;
	@FXML private TextField newPlotDescription;
	@FXML private TextField newCoverImage;
	@FXML private Button addBook;
	
	
	
	@FXML
	public void addBook(ActionEvent e) {
		String title = newTitle.getText();
		String author = newAuthor.getText();
		int pubYear = Integer.parseInt(newYearOfPublication.getText());
		int pageNum = Integer.parseInt(newNumberOfPages.getText());
		String genre = newGenre.getText();
		String plotDesc = newPlotDescription.getText();
		String coverImg = newCoverImage.getText();
		
		Book bookToAdd = new Book(title, author, pubYear, pageNum, 
								  genre, plotDesc, coverImg);
		
		Main.addBook(bookToAdd);
		
	}
	
	@FXML
	public void removeBook(ActionEvent e) {
		
	}
	
}
