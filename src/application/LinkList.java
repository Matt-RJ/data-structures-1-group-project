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
	 * @param newNode - The node to add
	 */
	public void add(LinkNode<C> newNode) {		
		if (head == null) {
			head = newNode;
			last = newNode;
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
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void insert(int index, LinkNode<C> newNode) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > this.size) {
			throw new ArrayIndexOutOfBoundsException("The index " + index + " doesn't exist in the list");
		}

		// TODO: Test index iteration
		LinkNode<C> temp = getNode(index);
		
		// Works for middle
		if (temp != null) {
			newNode.setPrevious(temp.getPrevious());
			newNode.setNext(temp);
			temp.setPrevious(newNode);
			if (index != 0) newNode.getPrevious().setNext(newNode); //TODO: Test index 0
		}
		else {
			
		}
	}
	
	/**
	 * Gets a node at a specific index
	 * @param index - The index of the node to return
	 * @return A LinkNode that's at at the index specified
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public LinkNode<C> getNode(int index) throws ArrayIndexOutOfBoundsException {
		
		LinkNode<C> node = head;
		
		// Iterates to the correct index from whichever side is closest
		if (index < (this.size / 2)) {
			// Iterates up from head
			int i = 0;
			while (i < index) {
				node = node.getNext();
				i++;
			}
		}
		else {
			// Iterates down from last
			int i = this.size -1;
			while (i > index) {
				node = node.getPrevious();
				i--;
			}
		}
		
		return node;
	}
	
	/**
	 * Removes a LinkNode from the list
	 * @param index - The index of the LinkNode to remove
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
