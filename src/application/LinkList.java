package application;

import java.util.Iterator;

/**
 * A doubly-linked list
 * @author Mantas Rajackas
 *
 * @param <C>
 */
public class LinkList<C> implements Iterable<C> {
	
	
	// FIELDS
	
	private LinkNode<C> head = null;
	private LinkNode<C> last = null;
	private int size;
	
	
	// CONSTRUCTORS
	
	public LinkList() {
		
	}
	
	
	// GETTERS / SETTERS
	
	public LinkNode<C> getHead() {
		return this.head;
	}
	public void setHead(LinkNode<C> newHead) {
		this.head = newHead;
	}
	
	public LinkNode<C> getLast() {
		return this.last;
	}
	public void setLast(LinkNode<C> newLast) {
		this.last = newLast;
	}
	
	
	// OTHER METHODS
	
	/**
	 * Adds a LinkNode to the start of the list
	 * @param newNode
	 */
	public void add(LinkNode<C> newNode) {
		head = (head == null) ? newNode : null; // TODO
		
		if (head == null) {
			head = newNode;
		}
		else {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}
		
		this.size++;
	}
	
	/**
	 * Inserts a LinkNode into the LinkedList
	 * @param index - The index where the node will be inserted
	 * @param newNode - The node to insert
	 */
	public void insert(int index, LinkNode<C> newNode) {
		if (index < 0 || index > this.size) {
			throw new ArrayIndexOutOfBoundsException("The index " + index + " doesn't exist in the list");
		}
		
		LinkNode<C> temp = this.head;
		int i = 0;
		while (i < index) {
			temp = temp.getNext();
		}
		
		// TODO: Finish
		
		if (temp != null) {
			newNode.setPrevious(temp.getPrevious());
			newNode.setNext(temp);
			temp.setPrevious(newNode);
			newNode.getPrevious().setNext(newNode);
		}
	}
	
	/**
	 * Removes a LinkNode from the list
	 * @param index - The index to remove
	 */
	public void remove(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > this.size-1) {
			throw new ArrayIndexOutOfBoundsException("The index " + index + " doesn't exist in the list");
		}
		
		// TODO: Finish
		LinkNode<C> temp = this.head;
		int i = 0;
		while (i < index) {
			temp = temp.getNext();
		}
		
		
	}
	
	@Override
	public Iterator<C> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
