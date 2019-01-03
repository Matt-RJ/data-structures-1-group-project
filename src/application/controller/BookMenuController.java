package application.controller;
import application.Book;
import application.Library;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * The controller for the books menu
 * 
 * @author Mantas rajackas
 *
 */
public class BookMenuController extends SuperController {
	
	// Adding a new book to the system
	@FXML private TextField newTitle;
	@FXML private TextField newAuthor;
	@FXML private TextField newYearOfPublication;
	@FXML private TextField newNumberOfPages;
	@FXML private TextField newGenre;
	@FXML private TextField newPlotDescription;
	@FXML private Button addBook;
	
	// Sorting and Printing
	@FXML private Button sortByTitleButton;
	@FXML private Button sortByAuthorButton;
	@FXML private Button sortByYearButton;
	@FXML private Button sortByPagesButton;
	@FXML private Button sortByGenreButton;
	
	// Deleting
	@FXML private TextField toDeleteBookIndex;
	@FXML private Button deleteBookButton;
	
	/**
	 * Adds a book to the system.
	 * @param e
	 */
	@FXML
	public void addBook(ActionEvent e) {
		
		// Gathers information from text fields
		String title = newTitle.getText();
		String author = newAuthor.getText();
		int pubYear = Integer.parseInt(newYearOfPublication.getText());
		int pageNum = Integer.parseInt(newNumberOfPages.getText());
		String genre = newGenre.getText();
		String plotDesc = newPlotDescription.getText();
		
		Book bookToAdd = new Book(title, author, pubYear, pageNum, 
								  genre, plotDesc);
		
		Main.addBook(bookToAdd);
		printToInfoPanel("Book added.\nPress one of the 'Show by...' buttons to view the books.");
	}
	
	/**
	 * Deletes a book from the system by its title.
	 * @param e
	 */
	@FXML
	public void deleteBook(ActionEvent e) {
		int bookIndex = Integer.parseInt(toDeleteBookIndex.getText());
		int bookKey = Library.bookKeys[bookIndex];
		Book bookToRemove = null;
		
		// TODO: Get book removal to work
		Library.bookHash.remove(bookToRemove);
	}
	
	/**
	 * Sorts all books by their titles and displays them
	 * @param e
	 */
	public void sortByTitle(ActionEvent e) {
		Library.sortBooksByTitle();
		String sortedBooks = "Showing all books, sorted by title: \n\n";
		for (int i = 0; i < Library.bookKeys.length; i++) {
			sortedBooks += "Index: " + i + "\n";
			sortedBooks += Library.bookHash.get(Library.bookKeys[i]).toString();
			sortedBooks += "\n\n";
		}
		printToInfoPanel(sortedBooks);
		
	}
	
	/**
	 * Sorts all books by the author name and displays them
	 * @param e
	 */
	public void sortByAuthor(ActionEvent e) {
		Library.sortBooksByAuthor();	
		String sortedBooks = "Showing all books, sorted by author: \n\n";
		for (int i = 0; i < Library.bookKeys.length; i++) {
			sortedBooks += "Index: " + i + "\n";
			sortedBooks += Library.bookHash.get(Library.bookKeys[i]).toString();
			sortedBooks += "\n\n";
		}
		printToInfoPanel(sortedBooks);
	}
	
	/**
	 * Sorts all books by their year of publication and displays them
	 * @param e
	 */
	public void sortByYear(ActionEvent e) {
		Library.sortBooksByYear();	
		String sortedBooks = "Showing all books, sorted by year: \n\n";
		for (int i = 0; i < Library.bookKeys.length; i++) {
			sortedBooks += "Index: " + i + "\n";
			sortedBooks += Library.bookHash.get(Library.bookKeys[i]).toString();
			sortedBooks += "\n\n";
		}
		printToInfoPanel(sortedBooks);
	}
	
	/**
	 * Sorts all books by their number of pages and displays them
	 * @param e
	 */
	public void sortByPages(ActionEvent e) {
		Library.sortBooksByPages();
		String sortedBooks = "Showing all books, sorted by number of pages: \n\n";
		for (int i = 0; i < Library.bookKeys.length; i++) {
			sortedBooks += "Index: " + i + "\n";
			sortedBooks += Library.bookHash.get(Library.bookKeys[i]).toString();
			sortedBooks += "\n\n";
		}
		printToInfoPanel(sortedBooks);
	}
	
	
	public void sortByGenre(ActionEvent e) {
		Library.sortBooksByGenre();
		String sortedBooks = "Showing all books, sorted by their genres: \n\n";
		for (int i = 0; i < Library.bookKeys.length; i++) {
			sortedBooks += "Index: " + i + "\n";
			sortedBooks += Library.bookHash.get(Library.bookKeys[i]).toString();
			sortedBooks += "\n\n";
		}
		printToInfoPanel(sortedBooks);
	}
}
