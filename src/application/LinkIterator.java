package application;

import java.util.Iterator;

/**
 * Used for iterating over a LinkList
 * @author Mantas Rajackas
 *
 */
public class LinkIterator<I> implements Iterator<I> {
	
	private LinkNode<I> pos; // Current position
	
	public LinkIterator(LinkNode<I> firstNode) {
		this.pos = firstNode;
	}

	@Override
	public boolean hasNext() {
		return pos != null;
	}

	@Override
	public I next() {
		LinkNode<I> temp = pos;
		pos = pos.getNext();
		return temp.getContents();
	}

}
