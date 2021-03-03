package Homework05;
/*
 * Created by Ellie Barry
 */

public class SortingMethods {

	
	public static int selectionSort(int[] toSort) {
		int checks = 0;
		int minIndex = 0;
		// Goes through full array and makes smallest in the array the leftmost value of the unsorted part
		for (int i = 0; i < toSort.length - 1; i++) {
			minIndex = i;
			for (int j = i; j < toSort.length; j++) {
				checks++;
				if (toSort[j] < toSort[minIndex]) {
					minIndex = j;
				}
			}
			// Switches values
			int temp = toSort[minIndex];
			toSort[minIndex] = toSort[i];
			toSort[i] = temp;
		}
		checks++;
		return checks;
	}

	
	public static int bubbleSort(int[] toSort) {
		int checks = 0;
		boolean hasSwapped = true;
		while (hasSwapped) {
			hasSwapped = false;
			checks++;
			for (int i = 0; i < toSort.length - 1; i++) {
				checks++;
				// Compares each item in array to the one on the right and switches them if it is larger
				if (toSort[i] > toSort[i + 1]) {
					int temp = toSort[i];
					toSort[i] = toSort[i + 1];
					toSort[i + 1] = temp;
					hasSwapped = true;
				}
			}
		}
		return checks;
	}


	public static int mergeSort(int[] toSort) {
		int checks = 0;
		int size = toSort.length;
		if (size < 2) {
			checks++;
			return 0;
		}
		int mid = size / 2;
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		// Populates each array
		for (int i = 0; i < mid; i++) {
			left[i] = toSort[i];
		}
		for (int i = mid; i < size; i++) {
			right[i - mid] = toSort[i];
		}
		checks += mergeSort(left);
		checks += mergeSort(right);
		// Merges left and right array
		checks += merge(left, right, toSort);

		return checks;
	}

	// Merges the left and right array for the merge sort method
	public static int merge(int[] left, int[] right, int[] result) {
		int checks = 0;
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0; // Left index
		int j = 0; // Right index
		int k = 0; // Combined array index

		while (i < leftSize && j < rightSize) {
			checks++;
			if (left[i] <= right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		while (i < leftSize) {
			result[k++] = left[i++];
			checks++;
		}
		while (j < rightSize) {
			result[k++] = right[j++];
			checks++;
		}
		return checks;
	}

	
	public static int quickSort(int[] toSort, int leftPointer, int rightPointer) {
		int[] partitionInfo = partition(toSort, leftPointer, rightPointer);
		int checks = partitionInfo[1];
		int pivot = partitionInfo[0];
		// Sorts everything to the left if it is less than or equal to the pivot
		if (leftPointer <= pivot)
			checks += quickSort(toSort, leftPointer, pivot - 1);
		// Sorts everything to the right if it is greater than the pivot
		if (rightPointer > pivot)
			checks += quickSort(toSort, pivot, rightPointer);
		return checks;
	}


	// Goes through and keeps smaller elements on left and larger elements on right
	// Switches the elements if they are not on the correct (left or right) side
	public static int[] partition(int[] a, int leftPointer, int rightPointer) {
		int checks = 0;
		int i = leftPointer;
		int j = rightPointer;
		int pivot = a[(leftPointer + rightPointer) / 2];
		while (i <= j) {
			while (a[i] < pivot) {
				i++;
				checks++;
			}
			while (a[j] > pivot) {
				j--;
				checks++;
			}
			if (i <= j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		return new int[] {i, checks};
	}
	
}
