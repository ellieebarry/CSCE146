package Homework06;
/*
 * Created by Ellie Barry
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FrontEnd {

	static Scanner keyboard = new Scanner(System.in);
	static ShapeManager shapeManager;

	
	public static void main(String[] args) {
		shapeManager = new ShapeManager();

		System.out.println("Welcome to the shape tree tester!");
		System.out.println("Reading from file");
		String filePath = keyboard.nextLine();
		// Goes through each line of the file and creates new shapes with a BS Tree from it
		loadFile(filePath);
		// Prints out all three orders
		System.out.println();
		System.out.println("Printing pre-order");
		shapeManager.printPreOrder();
		System.out.println();
		System.out.println("Printing in-order");
		shapeManager.printInOrder();
		System.out.println();
		System.out.println("Printing post-order");
		shapeManager.printPostOrder();
		System.out.println();
		// Prints out the maximum area
		System.out.println("The max area is: " + shapeManager.getMaxArea());
		System.out.println();
		// Prints out the deleted rectangle, uses delete shape method, and then prints out the full list again after it is deleted
		System.out.println("Deleting Rectangle Side 1: 2.0 Side 2: 7.0 Area: 14.0");
		shapeManager.deleteShape(new Rectangle(2, 7));
		System.out.println("Printing in-order");
		shapeManager.printInOrder();
		System.out.println();
	
		// Deletes values greater than 30 using method and then re prints full list 
		System.out.println("Deleting values larger than 30");
		shapeManager.deleteValuesGreaterThan(30);
		System.out.println("Printing in-order");
		shapeManager.printInOrder();
		System.out.println();
	}
	
	
	
	
	static void loadFile(String filePath) {
		try {
			Scanner fileScanner = new Scanner(new File(filePath));
			// Goes through each line and creates a BS Tree and new shape
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				if(line.equals("Rombus		"))
					System.out.println("Not properly formatted line.");
				else
					System.out.println(line);
				String[] splitSides = line.split("\t");
				// Has the program continue on to next line if it is not a valid shape with valid sides
				if (splitSides.length != 3 && splitSides.length != 2 && !shapeManager.isValidType(splitSides[0])) 
					continue;
				// If there is only 1 number compared to 2 it's a circle
				if (splitSides.length == 2) {
					shapeManager.addShape(new Circle(Double.parseDouble(splitSides[1])));
				} else {
					// If there are 2 numbers
					String shapeType = splitSides[0];
					// Checks to see what the first string is (if it's rectangle or right triangle)
					if (shapeType.equals("Rectangle")) {
						shapeManager.addShape(new Rectangle(Double.parseDouble(splitSides[1]), Double.parseDouble(splitSides[2])));
					} else {
						shapeManager.addShape(new RightTriangle(Double.parseDouble(splitSides[1]), Double.parseDouble(splitSides[2])));
					}
				}
			}
			fileScanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
}