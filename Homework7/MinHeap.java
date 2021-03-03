package Homework07;
/*
 * Created by Ellie Barry
 */

public class MinHeap<Sheep extends Comparable<Sheep>> {
	private Sheep[] heap;
	public static final int DEF_SIZE = 127;
	private int lastIndex; // First null element rooted at zero
	
	public MinHeap() {
		init(DEF_SIZE);
	}
	
	public MinHeap(int size) {
		init(size);
	}
	
	public void init(int size) {
		
		lastIndex = 0;
		if(size > 0)
			heap = (Sheep[]) (new Comparable[size]);
		else
			init(DEF_SIZE);
	}
	
	
	public void insert(Sheep s) {
		
		if(lastIndex >= heap.length)
			return;
		heap[lastIndex] = s;
		bubbleUp();
		lastIndex++;
		
	}
	
	// Part of insert
	private void bubbleUp() {
		int index = lastIndex;
		while(index > 0 && heap[(index-1)/2].compareTo(heap[index]) > 0) {
			Sheep temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	
	// Deletes a node from the heap
	public Sheep delete() {
		if(heap[0] == null)
			return null;
		Sheep ret = heap[0];
		heap[0] = heap[lastIndex-1];
		heap[lastIndex-1] = null;
		lastIndex--;
		bubbleDown();
		return ret;
	}
	
	// Used in the delete method
	public void bubbleDown() {
		
		int index = 0;
		while(index*2+1 < lastIndex) { // While we have a left child
			
			int bigIndex = index*2+1; // Assume left is larger
			if(index*2+2 < lastIndex && heap[index*2+1].compareTo(heap[index*2+2]) > 0) { // Have left child and left is not larger
				bigIndex = index*2+2;
			}
			// Compare larger child with parent
			if(heap[index].compareTo(heap[bigIndex]) > 0) {
				// Child was larger
				Sheep temp = heap[(index)];
				heap[index] = heap[bigIndex];
				heap[bigIndex] = temp;
			} else
				break;
			index = bigIndex;
		}
	}
	
	
	
	
	public int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	public int getRightIndex(int index) {
		return (index * 2) + 2;
	}

	public int getLeftIndex(int index) {
		return (index * 2) + 1;
	}

	public Sheep peek() {
		return heap[0];
	}

	public void sheepRollCall() {
		for (Sheep tmp : heap) {
			if (tmp == null) continue;

			Sheep sheep = (Sheep) tmp;
			System.out.printf(sheep.toString());
		}
	}

	public void sheepHeapSort() {
		/*Sheep[] result = new Sheep[lastIndex]; //sorted array
		Sheep[] copy = heap.clone(); //makes a clone of the heap
		for (int i = 0; i < result.length; i++) {
			result[i] = (Sheep) delete(); //populates the result array
		}
		heap = copy; //restores the original heap

		return result
		*/
		while(lastIndex > 0) {
			System.out.println(delete());
		}
		
	}
	
}
