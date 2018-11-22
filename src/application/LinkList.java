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
	public int getSize() {
		return this.size;
	}
	public void setSize(int newSize) {
		this.size = newSize;
	}
	
	
	// OTHER METHODS
	
	/**
	 * Adds a LinkNode to the end of the list
	 * @param newNode - The node to add
	 */
	public void add(LinkNode<C> newNode) {		
		if (head == null) {
			head = newNode;
			last = newNode;
		}
		else {
			last.setNext(newNode);
			newNode.setPrevious(last);
			last = newNode;
		}
		
		this.size++;
	}
	
	/**
	 * Adds a node to the start of the list
	 * @param newNode - The node to add
	 */
	public void addfirst(LinkNode<C> newNode) {
		if (head != null) {
			head.setPrevious(newNode);
			newNode.setNext(head);
			head = newNode;
		}
		else {
			head = newNode;
			last = newNode;
		}
	}
	
	/**
	 * Inserts a LinkNode into the LinkedList after another node
	 * @param index - The index of the node before the insertion point
	 * @param newNode - The node to insert
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void insert(int index, LinkNode<C> newNode) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > this.size-1) {
			throw new ArrayIndexOutOfBoundsException("There is no node at index " + index + 
													" within the list.");
		}

		LinkNode<C> temp = getNode(index);
		
		if (temp != null) {

			newNode.setPrevious(temp);
			if (temp.getNext() != null) {
				newNode.setNext(temp.getNext());
				temp.getNext().setPrevious(newNode);
			}
			else {
				last = newNode;
			}
			temp.setNext(newNode);

			this.size++;
		}
		
	}
	
	/**
	 * Gets a node at a specific index
	 * @param index - The index of the node to return
	 * @return A LinkNode that's at at the index specified
	 * @throws ArrayIndexOutOfBoundsException If the index doesn't exist in the list
	 */
	public LinkNode<C> getNode(int index) throws ArrayIndexOutOfBoundsException {
		
		LinkNode<C> node;
		
		// Iterates to the correct index from whichever side is closest
		if (index < (this.size / 2)) {
			// Iterates up from head
			node = head;
			int i = 0;
			while (i++ < index) {
				node = node.getNext();
			}
		}
		else {
			// Iterates down from last
			node = last;
			int i = this.size -1;
			while (i-- > index) {
				node = node.getPrevious();
			}
		}
		
		return node;
	}
	
	/**
	 * Removes a LinkNode from the list
	 * @param index - The index of the LinkNode to remove
	 * @throws ArrayIndexOutOfBoundsException If an index doesn't exist in the list
	 */
	public void remove(int index) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > this.size-1) {
			throw new ArrayIndexOutOfBoundsException("The index " + index + 
													" doesn't exist in the list");
		}
		
		LinkNode<C> temp = getNode(index);
		
		if (index == 0) {
			head = temp.getNext();
			if (head != null) head.setPrevious(null);
		}
		else if (index == size-1) {
			last = temp.getPrevious();
			last.setNext(null);
		}
		else {
			temp.getPrevious().setNext(temp.getNext());
			temp.getNext().setPrevious(temp.getPrevious());
		}
		
		this.size--;
		
	}
	
	/**
	 * Determines if the LinkList contains a certain node
	 * @param soughtNode - The node to look for
	 * @return True if the node is in the list, false otherwise
	 */
	public boolean contains(LinkNode<C> soughtNode) {
		
		LinkNode<C> temp = head;
		
		while (temp != null) {
			if (temp.equals(soughtNode)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	
	@Override
	public Iterator<C> iterator() {
		return new LinkIterator<C>(head);
	}

}
