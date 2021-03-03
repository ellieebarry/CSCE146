package Homework04;
/*
 /* Created by Ellie Barry
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;


public class TriangleFractals extends Canvas {
		// Instance variables for points of the triangle
		public Point point1;
		public Point point2;
		public Point point3;
		// The limit for amount of triangles created in recursion
		public static int amount = 5;
		
	
	public static void main(String[] args) {
		// Creates the frame and canvas and sets the size of it
        JFrame frame = new JFrame("Triangles! Oh Fractals!");
        Canvas canvas = new TriangleFractals();
        frame.setSize(600, 520);
        
        // Makes the frame and canvas visible
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
	
	// Method that is part of java and implements drawIt
	public void paint(Graphics g) {
		drawIt(g);
	}
	
	// Implements the drawTriangles method
    public void drawIt(Graphics g) {
    	// Initializes the original triangles points
    	point1 = new Point(0, getSize().height); // Left
    	point2 = new Point(getSize().width, getSize().height); // Right
    	point3 = new Point(getSize().width/2, 0); // Upper
    
    	drawTriangles(g, point1, point2, point3, amount);
    }
    
    
    // Draws each triangle and implements recursion
    public void drawTriangles(Graphics g, Point point1, Point point2, Point point3, int level) {
    	
		if(level == 0) {
			// Creates the arrays of x and y values for the drawPolygon method
			int[] xPoints = {point1.x, point2.x, point3.x};
			int[] yPoints = {point1.y, point2.y, point3.y};
			// Draws the black triangle
			g.drawPolygon(xPoints,yPoints,3);
			g.setColor(Color.black); 
			// Draws the white triangle
			g.fillPolygon(xPoints, yPoints, 3);
			g.setColor(Color.white); 
        }
        else {
        	// Finds the midpoint of the current triangle's points 
        	Point midpoint1 = getMidPoint(point1, point2);
        	Point midpoint2 = getMidPoint(point2, point3);
        	Point midpoint3 = getMidPoint(point3, point1);
        	
        	// Recursive call for each of the 3 new triangles for each level (creates all the other triangles)
        	drawTriangles(g, point1, midpoint1, midpoint3, level - 1);
        	drawTriangles(g, point2, midpoint2, midpoint1, level - 1);
        	drawTriangles(g, point3, midpoint3, midpoint2, level - 1);
        }
	}
    
    
    // Finds the mid-point for each set of points
    public Point getMidPoint(Point p, Point q) {
        return new Point((p.x + q.x) / 2, (p.y + q.y) / 2);
    } 
	
	
}
