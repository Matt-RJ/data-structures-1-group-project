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
	
	private Hash<Book> bookHash;
	
	
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
		System.out.println(bookHash.getLoadFactor());
		assertTrue(bookHash.getLoadFactor() == 0.1);
		
	}
	
}
