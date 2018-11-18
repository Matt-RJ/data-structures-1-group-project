package application.test;

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
		// TODO
		myList.add(node1);
		myList.add(node2);
		myList.add(node3);
		myList.add(node5);
		
		/** TODO: Fix type mismatch
		for (LinkNode<String> n : myList) {
			
		}
		**/
	}
	
	@Test public void removeTest() {
		// TODO
	}
	
	@Test public void sizeTest() {
		// TODO
	}
}
