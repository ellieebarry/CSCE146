package Homework06;
/*
 * Created by Ellie Barry
 */

public class RightTriangle extends Shape {

	public double side1;
	public double side2;

	// Constructor to set the sides
	public RightTriangle(double newSide1, double newSide2) {
		newSide1 = side1;
		newSide2 = side2;
	}

	// Returns the first side
	public double getSide1() {
		return side1;
	}

	// Returns the second side
	public double getSide2() {
		return side2;
	}

	// Finds the area of the right triangle
	public double getArea() {
		return (int) (side1 * side2 / 2);
	}

	// To string for the right triangle that returns the sides and super string of area
	public String toString() {
		return "Right Triangle Side 1: " + getSide1() + " Side 2: " + getSide2() + super.toString();
	}
}