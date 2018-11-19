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
	 * Inserts a LinkNode into the LinkedList
	 * @param index - The index where the node will be inserted
	 * @param newNode - The node to insert
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void insert(int index, LinkNode<C> newNode) throws ArrayIndexOutOfBoundsException {
		if (index < 0 || index > this.size) {
			throw new ArrayIndexOutOfBoundsException("The index " + index + 
													" doesn't exist in the list");
		}

		LinkNode<C> temp = getNode(index);
		
		if (temp != null) {
			newNode.setPrevious(temp.getPrevious());
			newNode.setNext(temp);
			temp.setPrevious(newNode);
			
			if (index != 0) {
				this.head = newNode; // TODO: Test index 0
			}
			else if (index == this.size){
				this.last = newNode; // TODO: Test last index
			}
			else {
				newNode.getPrevious().setNext(newNode); //TODO: Test other indices
			}
			
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
		
		// TODO: Add removal
		
		
		
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
