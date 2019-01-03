package application;

/**
 * A single node of a LinkedList
 * 
 * @author Mantas Rajackas
 *
 * @param <C> - The contents of the node
 */
public class LinkNode<C> {
	
	
	// FIELDS
	
	private C contents; // The contents of the node
	
	private LinkNode<C> next = null;		// The next node in the LinkedList
	private LinkNode<C> previous = null;	// The previous node in the LinkedList
	
	
	// CONSTRUCTORS
	
	public LinkNode() {
		
	}
	
	public LinkNode(C contents) {
		this.contents = contents;
	}
	
	
	// GETTERS / SETTERS
	
	public C getContents() {
		return contents;
	}

	public void setContents(C contents) {
		this.contents = contents;
	}

	public LinkNode<C> getNext() {
		return next;
	}

	public void setNext(LinkNode<C> next) {
		this.next = next;
	}

	public LinkNode<C> getPrevious() {
		return previous;
	}

	public void setPrevious(LinkNode<C> previous) {
		this.previous = previous;
	}
}
