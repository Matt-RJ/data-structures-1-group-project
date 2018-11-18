package application;

public class Book {
	
	
	// FIELDS
	
	private String title = "";				// The title of the book
	private String author = "";				// The author of the book
	private int yearOfPublication = 1900;	// The year the book was first published
	private int numberOfPages = 0;			// The number of pages in the book
	private String genre = "";				// The genre of the book - "Thriller, Drama", etc
	private String plotDescription;			// A brief description of the book's plot
	private String coverImage = "";			// A URL to an image of the book's cover
	
	
	// CONSTRUCTORS
	
	public Book() {
		
	}
	
	public Book(String title, String author, int pubYear, int pageNum,
			String genre, String plotDesc, String coverImg) {
		
		this.title = title;
		this.author = author;
		this.yearOfPublication = pubYear;
		if (pageNum > 0) this.numberOfPages = pageNum;
		this.genre = genre;
		this.plotDescription = plotDesc;
		this.coverImage = coverImg;
		
	}
	
	
	// GETTERS / SETTERS
	
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
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	
	
}
