package Homework06;


/*
 * Created by Ellie Barry
 */

public class Rectangle extends Shape {

	public double side1;
	public double side2;

	// Constructor to set the sides
	public Rectangle(double newSide1, double newSide2) {
		side1 = newSide1;
		side2 = newSide2;
	}

	// Returns the first side
	public double getSide1() {
		return side1;
	}

	// Returns the second side
	public double getSide2() {
		return side2;
	}

	// Finds the area of the rectangle
	public double getArea() {
		return side1 * side2;
	}

	// To string for the rectangle that returns the sides and super string of area
	public String toString() {
		return "Rectangle Side 1: " + getSide1() + " Side 2: " + getSide2() + super.toString();
	}
}