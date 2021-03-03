package Homework06;
/*
 * Created by Ellie Barry
 */

public abstract class Shape  implements Comparable<Shape> {
	
	//Implemented by each shape in their classes
	public abstract double getArea();
	
	// Implements the comparable Shape
	public int compareTo(Shape shape) {
		if (this.getArea() > shape.getArea()) return 1;
		if (this.getArea() < shape.getArea()) return -1;
		return 0;
	}
	
	// String used for the area of each shape
	public String toString() {
		return " Area: " + getArea();
	}

}