package Homework07;
/*
 * Created by Ellie Barry
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SheepFrontEnd {

	public static Scanner keyboard = new Scanner(System.in);
	public static Sheep sheep;
	public static MinHeap<Sheep> sheepArrival = new MinHeap<Sheep>();
	public static MinHeap<Sheep> sheepHeap = new MinHeap<Sheep>();
	public static Sheep first = new Sheep("", 0, 0);
	public static Sheep current = new Sheep("", 0, 0);
	public static int minutes = 0;
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to the Sheep Shearing Scheduler!");
		System.out.println("Enter a file name");
		String filePath = keyboard.nextLine();
		// Goes through each line of the file and creates new sheeps with a Heap from it
		loadFile(filePath);
		while(sheepArrival.peek() != null) {
			Sheep s = (Sheep)sheepArrival.delete();
			s.change();
		}
		sheepArrival.sheepHeapSort();
		
		
	}
	
	// Loads the file into the heap
	static void loadFile(String filePath) {
		try {
			Scanner fileScanner = new Scanner(new File(filePath));
			// Goes through each line and creates a BS Tree and new shape
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] temp = line.split("/t");
				Sheep s = new Sheep(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
				sheepHeap.insert(s);
				if(s.getArrivalTime() == 0) {
					first = s;
				} else {
					sheepArrival.insert(s);
				}
			}
			minutes = first.getSheerTime();
			System.out.println(first);
			fileScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}