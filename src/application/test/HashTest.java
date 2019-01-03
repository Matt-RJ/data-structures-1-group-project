package application.test;

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
	
	/*
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
	*/
	
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
		// TODO: Fix null pointer here
		bookHash.getSize();
	}
	
}
