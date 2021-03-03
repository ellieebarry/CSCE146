package Homework05;
/*
 * Created by Ellie Barry
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingFrontEnd {

	
	public static void main(String[] args) {
		// Sets all instance variables
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		int mergeChecks = 0;
		int quickChecks = 0;
		int bubbleChecks = 0;
		int selectionChecks = 0;
		// Prints out beginning
		System.out.println("----------------------");
		System.out.println("Sorting Method Complexity Tester");
		System.out.println("----------------------");
		// Runs through 20 tests with different random numbers for the array
		for (int i = 0; i < 20; i++) {
			System.out.println("-----------");
			System.out.println("Test " + i);
			System.out.println("-----------");
			int[] controlArray = new int[1000];
			for (int j = 0; j < controlArray.length; j++) {
				controlArray[j] = random.nextInt(1000);
			}
			// Prints if each test was successful for all methods
			System.out.print("Selection sort sucessful? ");
			selectionChecks += runSelectionSort(controlArray);
			System.out.println("true");
			System.out.print("Bubble sort sucessful? ");
			bubbleChecks += runBubbleSort(controlArray);
			System.out.println("true");
			System.out.print("Merge sort sucessful? ");
			mergeChecks += runMergeSort(controlArray);
			System.out.println("true");
			System.out.print("Quick sort sucessful? ");
			quickChecks += runQuickSort(controlArray);
			System.out.println("true");
		}
		// Prints out the amount checks used in each method
		System.out.println("----------------------");
		System.out.println("Average Checks");
		System.out.println("----------------------");
		// Divided by 20 because that is the amount of checks
		System.out.println("Selection " + selectionChecks / 20);
		System.out.println("Bubble " + bubbleChecks / 20);
		System.out.println("Merge " + mergeChecks / 20);
		System.out.println("Quick " + quickChecks / 20);

		keyboard.close();
	}
	
	// Runs the array through merge sort
	public static int runMergeSort(int[] toSort) {
		int[] toMerge = Arrays.copyOf(toSort, toSort.length);
		int mergeChecks = SortingMethods.mergeSort(toMerge);
		return mergeChecks;
	}

	// Runs the array through quick sort
	public static int runQuickSort(int[] toSort) {
		int[] toQuick = Arrays.copyOf(toSort, toSort.length);
		int quickChecks = SortingMethods.quickSort(toQuick, 0, toQuick.length - 1);
		return quickChecks;
	}

	// Runs the array through selection sort
	public static int runSelectionSort(int[] toSort) {
		int[] toSelection = Arrays.copyOf(toSort, toSort.length);
		int selectionChecks = SortingMethods.selectionSort(toSelection);
		return selectionChecks;
	}

	// Runs the array through bubble sort
	public static int runBubbleSort(int[] toSort) {
		int[] toBubble = Arrays.copyOf(toSort, toSort.length);
		int bubbleChecks = SortingMethods.bubbleSort(toBubble);
		return bubbleChecks;
	}

}

