package application;

public class Book {
	
	// FIELDS
	
	private int ID = 0;						// A unique ID for the book
	private String title = "";				// The title of the book
	private String author = "";				// The author of the book
	private int yearOfPublication = 1900;	// The year the book was first published
	private int numberOfPages = 0;			// The number of pages in the book
	private String genre = "";				// The genre of the book - "Thriller, Drama", etc
	private String plotDescription;			// A brief description of the book's plot
	
	
	// CONSTRUCTORS
	
	public Book() {
		
	}
	
	public Book(String title) {
		this.title = title;
	}
	
	/**
	 * 
	 * @param title - The title of the book
	 * @param author - The author's full name
	 * @param pubYear - The year it was published
	 * @param pageNum - The number of pages
	 * @param genre - Genre of the story
	 * @param plotDesc - A brief plot description
	 */
	public Book(String title, String author, int pubYear, int pageNum,
			String genre, String plotDesc) {
		
		this.ID = Library.currentBookID;
		Library.currentBookID++;

		this.title = title;
		this.author = author;
		this.yearOfPublication = pubYear;
		if (pageNum > 0) this.numberOfPages = pageNum;
		this.genre = genre;
		this.plotDescription = plotDesc;
		
	}
	
	
	// GETTERS / SETTERS
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		if (numberOfPages > 0) this.numberOfPages = numberOfPages;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPlotDescription() {
		return plotDescription;
	}
	public void setPlotDescription(String plotDescription) {
		this.plotDescription = plotDescription;
	}
	
	@Override
	public String toString() {
		String bookString = "";
		
		bookString += "Title: " + this.title + "\n";
		bookString += "Author: " + this.author + "\n";
		bookString += "Year: " + this.yearOfPublication + "\n";
		bookString += "Pages: " + this.numberOfPages + "\n";
		bookString += "Genre: " + this.genre + "\n";
		bookString += "Description: " + this.plotDescription + "\n";
		
		return bookString;
	}
	
	@Override
	public int hashCode() {
		
		int hashCode = 0;
		
		for (int i = 0; i < title.length(); i++) { 
			hashCode += title.charAt(i);
		}
		
		return hashCode;	
	}
	
}
