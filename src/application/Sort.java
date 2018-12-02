package application;

import java.util.Comparator;

/**
 * This class 
 * @author Mantas Rajackas
 *
 * @param <C>
 */
public class Sort<C> {
	
	private C[] sortArray;
	
	public Sort() {
		
	}
	
	@SuppressWarnings("unchecked")
	public Sort(Object[] sortArray) {
		this.sortArray = (C[]) new Object[sortArray.length];
	}
	
	public C[] getSortArray() {
		return sortArray;
	}

	public void setSortArray(C[] sortArray) {
		this.sortArray = sortArray;
	}

	/**
	 * 
	 * @param nodes
	 * @param comp
	 */
	@SuppressWarnings({ "unchecked" })
	public void mergeSort(LinkNode<C>[] nodes, Comparator<LinkNode<C>> comp) {
		
		if (nodes.length > 1) {
			
			// Creating two sublists
			int x = nodes.length/2;
			int y = nodes.length-x;
			LinkNode<C>[] xa = new LinkNode[x];
			LinkNode<C>[] ya = new LinkNode[y];
			
			// Copying to sublists from the starting list
			int i;
			for (i = 0; i<x; i++) {
				xa[i] = nodes[i];
			}
			for (int i2 = 0; i2 < y; i2++,i++) {
				ya[i2] = nodes[i];
			}
			
			// mergeSort recursive calls
			mergeSort(xa,comp);
			mergeSort(ya,comp);
			
			// Merges the sublists back into one
			i=0;
			int xai = 0;
			int yai = 0;
			while (xai < xa.length && yai<ya.length) {
								// TODO: Make sure the below is correct
				nodes[i++] = ( (comp.compare(xa[xai], ya[yai]) < 1) ? xa[xai++] : ya[yai++]);
			}
			while (xai < xa.length) {
				nodes[i++] = xa[xai++];
			}
			while (yai < ya.length) {
				nodes[i++] = ya[yai++];
			}
			
		}
		
	}
	
}
