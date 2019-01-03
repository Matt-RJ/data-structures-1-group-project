package application.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import application.Book;
import application.Hash;
import application.LinkList;
import application.LinkNode;

public class HashTest {
	
	LinkNode<Integer>[] keys;
	
	private Hash<Book> bookHash;
	private Book book1 = new Book("The Martian");
	private Book book2 = new Book("Harry Potter");
	private Book book3 = new Book("Artemis");
	private Book book4 = new Book("The Great Gatsby");
	private Book book5 = new Book("Moby Dick");
	private Book book6 = new Book("Hamlet");
	
	private Book book7 = new Book("Book number 7");
	private Book book8 = new Book("Book number 8");
	private Book book9 = new Book("Book number 9");
	private Book book10 = new Book("Book number 10");
	private Book book11 = new Book("Book number 11");
	private Book book12 = new Book("Book number 12");
	
	@BeforeEach
	public void setup() {
		bookHash = new Hash<Book>(25);
	}
	
	@AfterEach
	public void reset() {
		
	}
	
	@Test
	public void loadFactorTest() {
		bookHash = new Hash<Book>(10);
		LinkList<Book>[] bookHashTable = bookHash.getHashTable();
		
		bookHashTable[5].add(new LinkNode<Book>(new Book()));
		assertTrue(bookHash.getLoadFactor() == 0.1);
		
		bookHashTable[5].add(new LinkNode<Book>(new Book()));
		assertTrue(bookHash.getLoadFactor() == 0.1);
		
	}
	
	
	@Test
	public void addTest() {
		bookHash = new Hash<Book>(10);
		bookHash.add(book1);
		bookHash.add(book2);
		bookHash.add(book3);
		bookHash.add(book4);
		bookHash.add(book5);
		bookHash.add(book6);

		
		listItems();
	}
	
	
	@Test
	public void removeTest() {
		bookHash = new Hash<Book>(10);
		bookHash.add(book1);
		bookHash.add(book2);
		bookHash.add(book3);
		bookHash.add(book4);
		bookHash.add(book5);
		bookHash.add(book6);
	}
	
	public void listItems() {
		LinkList<Book>[] hashTable = bookHash.getHashTable();
		
		for (int i = 1; i < bookHash.getHashTable().length; i++) {
			System.out.print(i + " contains: ");
			for (Book b : hashTable[i]) {
				System.out.println(b.getTitle());
			}
			System.out.println();
		}
	}
	
	public void toLinkListTest() {
		// TODO
	}
	
	@Test
	public void toNodeArrayTest() {
		// TODO
		bookHash = new Hash<Book>(10);
		bookHash.add(book1);
		bookHash.add(book2);
		bookHash.add(book3);
		bookHash.add(book4);
		bookHash.add(book5);
		bookHash.add(book6);
		
		keys = bookHash.toNodeArray();
		
		System.out.println("Number of keys converted: " + keys.length);
		
		for (LinkNode<Integer> k : keys) {
			System.out.println(k.getContents());
		}
	}
	
	@Test
	public void getSizeTest() {
		bookHash = new Hash<Book>(10);
		bookHash.add(book1);
		bookHash.add(book2);
		bookHash.add(book3);
		bookHash.add(book4);
		bookHash.add(book5);
		bookHash.add(book6);
		
		assertEquals(6, bookHash.getSize(bookHash.getHashTable()));
	}
	
	@Test
	public void rehashTest() {
		bookHash = new Hash<Book>(6);
		bookHash.add(book1);
		bookHash.add(book2);
		bookHash.add(book3);
		bookHash.add(book4);
		bookHash.add(book5);
		bookHash.add(book6);
		bookHash.add(book7);
		bookHash.add(book8);
		bookHash.add(book9);
		bookHash.add(book10);
		bookHash.add(book11);
		bookHash.add(book12);
		
	}
	
}
