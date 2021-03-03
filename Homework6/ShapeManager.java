package Homework06;
/*
 * Created by Ellie Barry
 */

public class ShapeManager {

	private LinkedBSTree<Shape> shapeList;
	
	// Default constructor to created new BS Tree
	public ShapeManager() {
		shapeList = new LinkedBSTree<Shape>();
	}
	
	// Adds a shape and inserts it to the BS Tree
	public void addShape(Shape shape) {
		shapeList.insert(shape);
	}

	// Deletes shape from BS Tree
	public void deleteShape(Shape shape) {
		shapeList.delete(shape);
	}

	// Prints the pre-order from the BS Tree
	public void printPreOrder() {
		shapeList.printPreOrder();
	}
	
	// Prints the in-order from the BS Tree
	public void printInOrder() {
		shapeList.printInOrder();
	}
	
	// Prints the post-order from the BS Tree
	public void printPostOrder() {
		shapeList.printPostOrder();
	}
	
	// Returns the maximum area from the right side of the BS Tree
	public double getMaxArea() {
		return shapeList.getMaxArea();
	}
	
	// Uses the delete values method in the BS Tree
	public void deleteValuesGreaterThan(double value) {
		shapeList.deleteValuesGreaterThan(value);
	}

	// Checks to see if the shape is a valid type of shape based on its string name
	public boolean isValidType(String type) {
		return type.equals("Rectangle") || type.equals("Right Triangle") || type.equals("Circle");
	}
}