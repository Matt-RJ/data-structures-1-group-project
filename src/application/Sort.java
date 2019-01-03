package application;

import java.util.Comparator;

/**
 * This class is used for sorting comparable objects using merge sort.
 * 
 * @author Mantas Rajackas
 *
 * @param <C>
 */
public class Sort<C> {
	
	private LinkNode<C>[] sortArray; // The array that mergeSort() sorts
	
	public Sort() {
		
	}
	
	@SuppressWarnings("unchecked")
	public Sort(Object[] sortArray) {
		this.sortArray = new LinkNode[sortArray.length];
	}
	
	public LinkNode<C>[] getSortArray() {
		return sortArray;
	}

	public void setSortArray(LinkNode<C>[] sortArray) {
		this.sortArray = sortArray;
	}

	/**
	 * Sorts the instance's sortArray using MergeSort
	 * @param nodes - The array of LinkNode objects to sort
	 * @param comp - The Comparator object for node comparison
	 */
	@SuppressWarnings({ "unchecked" })
	public void mergeSort(LinkNode<C>[] nodes, Comparator<LinkNode<C>> comp) {
		
		// Checks the base case - An array of length 1 is already sorted
		if (nodes.length > 1) {
			
			// Divides the array to sort into 2 sub-arrays
			int x = nodes.length/2;
			int y = nodes.length-x;
			LinkNode<C>[] xa = new LinkNode[x];
			LinkNode<C>[] ya = new LinkNode[y];
			
			// Copies values into the 2 sub-arrays
			int i;
			for (i = 0; i<x; i++) {
				xa[i] = nodes[i];
			}
			for (int i2 = 0; i2 < y; i2++,i++) {
				ya[i2] = nodes[i];
			}
			
			// Recursive calls
			mergeSort(xa,comp);
			mergeSort(ya,comp);
			
			// Merges the sublists back into one, sorting them as it does so.
			i=0;
			int xai = 0;
			int yai = 0;
			while (xai < xa.length && yai<ya.length) {
						
				nodes[i++] = ( (comp.compare(xa[xai], ya[yai]) < 0) ? xa[xai++] : ya[yai++]);
			}
			while (xai < xa.length) {
				nodes[i++] = xa[xai++];
			}
			while (yai < ya.length) {
				nodes[i++] = ya[yai++];
			}
			
		}
		
	}
	
	/**
	 * Returns the instance's array of nodes back into a LinkList
	 * @return - This instance's sortArray as a LinkList
	 */
	public LinkList<C> getSortArrayAsLinkList() {
		LinkList<C> linkList= new LinkList<>();
		
		for (LinkNode<C> n : sortArray) {
			linkList.add(n);
		}
		
		return linkList;
	}
	
	/**
	 * Converts the array of LinkNodes into a primitive array
	 * @return
	 */
	public int[] getSortArrayAsPrimitive() {
		int[] primArray = new int[sortArray.length];
		
		for (int i = 0; i < sortArray.length; i++) {
			primArray[i] = (int) sortArray[i].getContents();
		}
		return primArray;
	}
	
}
