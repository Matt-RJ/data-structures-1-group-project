package application.test;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import application.Book;
import application.LinkList;
import application.LinkNode;
import application.Sort;

public class SortTest {
	
	LinkList<String> stringList = new LinkList<>();
	LinkList<Book> bookList = new LinkList<>();
	// TODO
	
	@BeforeEach
	public void setup() {
		stringList = new LinkList<>();
		stringList.add(new LinkNode<String>("The"));
		stringList.add(new LinkNode<String>("quick"));
		stringList.add(new LinkNode<String>("brown"));
		stringList.add(new LinkNode<String>("fox"));
		stringList.add(new LinkNode<String>("jumps"));
		stringList.add(new LinkNode<String>("over"));
		stringList.add(new LinkNode<String>("the"));
		stringList.add(new LinkNode<String>("lazy"));
		stringList.add(new LinkNode<String>("dog"));
		
		bookList = new LinkList<>();
		bookList.add(new LinkNode<Book>(new Book("The Martian")));
		bookList.add(new LinkNode<Book>(new Book("The Great Gatsby")));
		bookList.add(new LinkNode<Book>(new Book("Hamlet")));
		bookList.add(new LinkNode<Book>(new Book("Life of Pi")));
		bookList.add(new LinkNode<Book>(new Book("Wonder")));
		bookList.add(new LinkNode<Book>(new Book("Death and Nightingales")));
		bookList.add(new LinkNode<Book>(new Book("To Kill a Mockingbird")));
		bookList.add(new LinkNode<Book>(new Book("Catch 22")));
		bookList.add(new LinkNode<Book>(new Book("1984")));
		
	}
	
	@AfterEach
	public void reset() {
		
	}
	
	@Test
	public void mergeSortTest() {
		
		// TODO
		
	}
	
}
