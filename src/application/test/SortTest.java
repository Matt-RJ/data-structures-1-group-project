package application.test;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import application.Book;
import application.Hash;
import application.LinkList;
import application.LinkNode;
import application.Sort;

/**
 * Tests the Sort class
 * @author Mantas Rajackas
 *
 */
public class SortTest {
	
	LinkList<String> stringList = new LinkList<>();
	LinkList<Book> bookList = new LinkList<>();
	
	
	Hash<Book> bookHash = new Hash<>(9);
	
	@BeforeEach
	public void setup() {
		
		stringList.add(new LinkNode<String>("The"));
		stringList.add(new LinkNode<String>("quick"));
		stringList.add(new LinkNode<String>("brown"));
		stringList.add(new LinkNode<String>("fox"));
		stringList.add(new LinkNode<String>("jumps"));
		stringList.add(new LinkNode<String>("over"));
		stringList.add(new LinkNode<String>("the"));
		stringList.add(new LinkNode<String>("lazy"));
		stringList.add(new LinkNode<String>("dog"));
		
		
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
		stringList = new LinkList<>();
		bookList = new LinkList<>();
	}
	
	@Test
	public void mergeSortTest() {
		
		bookHash.add(new Book("The Martian"));
		bookHash.add(new Book("The Great Gatsby"));
		bookHash.add(new Book("Hamlet"));
		bookHash.add(new Book("Life of Pi"));
		bookHash.add(new Book("Wonder"));
		bookHash.add(new Book("Death and Nightingales"));
		bookHash.add(new Book("To Kill a Mockingbird"));
		bookHash.add(new Book("Catch 22"));
		bookHash.add(new Book("1984"));
		
		
		Sort<Integer> sort = new Sort<>();
		System.out.println(bookList.getSize());
		sort.setSortArray(bookHash.toNodeArray());
		sort.mergeSort(sort.getSortArray(),
				(a,b) -> bookHash.get(a.getContents().intValue()).getTitle().
				compareTo(bookHash.get(b.getContents().intValue()).getTitle()));

		LinkList<Integer> sortedKeys = sort.getSortArrayAsLinkList();
		
		for (Integer k : sortedKeys) {
			System.out.println(bookHash.get(k).getTitle());
		}
	}
	
}
