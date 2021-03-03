package Homework06;

/*
 * Created by Ellie Barry
 */

public class Circle extends Shape {

	public double radius;

	// Constructor to set the radius
	public Circle(double Aradius) {
		radius = Aradius;
	}

	// Returns the radius
	public double getRadius() {
		return radius;
	}

	// Finds the area of the circle
	public double getArea() {
		return (int) (Math.PI * Math.pow(radius, 2));
	}
	
	// To string for the circle that returns the radius and super string of area
	public String toString() {
		return "Circle Radius: " + getRadius() + super.toString();
	}
}
