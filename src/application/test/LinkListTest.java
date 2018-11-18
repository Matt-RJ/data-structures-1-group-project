package application.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.LinkList;
import application.LinkNode;

/**
 * This class runs tests for the LinkList class.
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
		// TODO
	}
	
	@Test public void sizeTest() {
		// TODO
	}
}
