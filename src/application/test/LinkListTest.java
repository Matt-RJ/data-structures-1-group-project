package application.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.LinkList;
import application.LinkNode;

/**
 * Runs tests for the LinkList class
 * 
 * @author Mantas Rajackas
 *
 */
public class LinkListTest {
	LinkList<String> myList;
	
	LinkNode<String> node1;
	LinkNode<String> node2;
	LinkNode<String> node3;
	LinkNode<String> node4;
	LinkNode<String> node5;
	
	@BeforeEach public void setup() {
		
		myList = new LinkList<>();
		
		node1 = new LinkNode<>("First node");
		node2 = new LinkNode<>("Second node");
		node3 = new LinkNode<>("Third node");
		node4 = new LinkNode<>("Fourth node");
		node5 = new LinkNode<>("Fifth node");
		
	}
	
	@AfterEach public void reset() {
		myList = new LinkList<>();
	}
	
	@Test public void addTest() {
		
		myList.add(node1);
		assertEquals(myList.getHead(),node1);

		myList.add(node2);
		assertEquals(myList.getHead().getNext(),node2);
		assertEquals(myList.getHead().getNext().getPrevious(),node1);
		
		myList.add(node3);
		assertEquals(myList.getHead().getNext().getNext(),node3);
		assertEquals(myList.getHead().getNext().getNext().getPrevious(),node2);
		
		myList.add(node4);
		assertEquals(myList.getHead().getNext().getNext().getNext(),node4);
		assertEquals(myList.getHead().getNext().getNext().getNext().getPrevious(),node3);
		
	}
	
	@Test public void getNodeTest() {
		
		myList.add(node1);
		myList.add(node2);
		myList.add(node3);
		myList.add(node4);
		myList.add(node5);
		
		assertEquals(myList.getNode(0),node1);
		assertEquals(myList.getNode(1),node2);
		assertEquals(myList.getNode(2),node3);
		assertEquals(myList.getNode(3),node4);
		assertEquals(myList.getNode(4),node5);

	}
	
	@Test public void containsTest() {
		
		myList.add(node1);

		myList.add(node3);
	
		myList.add(node5);
		
		assertEquals(myList.contains(node1),true);
		assertEquals(myList.contains(node2),false);
		assertEquals(myList.contains(node3),true);
		assertEquals(myList.contains(node4),false);
		assertEquals(myList.contains(node5),true);

	}
	
	@Test public void removeTest() {
		
		myList.add(node1);
		myList.add(node2);
		myList.add(node3);
		myList.add(node4);
		myList.add(node5);
		
		assertThrows(ArrayIndexOutOfBoundsException.class,() -> myList.remove(-1));
		assertThrows(ArrayIndexOutOfBoundsException.class,() -> myList.remove(5));
		
		myList.remove(0);
		assertEquals(myList.getNode(0).getPrevious(),null);
		
		myList.remove(3);
		assertEquals(myList.getNode(2).getNext(),null);
		
		myList.remove(0);
		myList.remove(0);
		myList.remove(0);
		
		assertThrows(ArrayIndexOutOfBoundsException.class,() -> myList.remove(0));
		
	}
	
	@Test public void sizeTest() {
		
		assertEquals(myList.getSize(),0);
		myList.add(node1);
		assertEquals(myList.getSize(),1);
		myList.add(node2);
		assertEquals(myList.getSize(),2);
		myList.add(node3);
		assertEquals(myList.getSize(),3);
		myList.add(node4);
		assertEquals(myList.getSize(),4);
		myList.add(node5);
		
		myList.remove(0);
		assertEquals(myList.getSize(),4);
		myList.remove(0);
		assertEquals(myList.getSize(),3);
		myList.remove(0);
		assertEquals(myList.getSize(),2);
		myList.remove(0);
		assertEquals(myList.getSize(),1);
		myList.remove(0);
		assertEquals(myList.getSize(),0);
		
	}
	
	@Test public void insertTest() {
		
		myList.add(node1);
		myList.insert(0,node2);
		assertEquals(node1.getNext(),node2);
		assertEquals(node2.getNext(),null);
		assertEquals(node1.getPrevious(), null);
		assertEquals(node2.getPrevious(), node1);
		
		assertEquals(myList.getHead(),node1);
		assertEquals(myList.getLast(),node2);
		
	}
	
	@Test public void toArrayTest() {
		
		myList.add(node1);
		myList.add(node2);
		myList.add(node3);
		myList.add(node4);
		myList.add(node5);
		LinkNode<String>[] stringArray = myList.toArray();
		
		assertEquals(stringArray[0].getContents(),"First node");
		assertEquals(stringArray[1].getContents(),"Second node");
		assertEquals(stringArray[2].getContents(),"Third node");
		assertEquals(stringArray[3].getContents(),"Fourth node");
		assertEquals(stringArray[4].getContents(),"Fifth node");
		
	}
	
}
