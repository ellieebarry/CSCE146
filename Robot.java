package Homework03;
/* Created by Ellie Barry on 9/25/19 */

import java.util.*;
import java.io.*;

public class Robot {

	// Instance Variables
	public static int magicN = 10;
	private static GenQueue<String> robotc = new GenQueue<String>();
	
	// Checks to see if the robot is still in the board and did not hit object
	static boolean isSafe(int a, int b, char board[][]) {
		if (a >= 0 && b >= 0 && a < magicN && b < magicN && board[a][b] == '_')
			return true;
		System.out.println("CRASH!");
		return false;
	}

	// Moves the robot up one space on the board
	static void moveUp(int a, int b, char board[][]) {
		board[a][b] = '_';
		board[a - 1][b] = 'O';
	}

	// Moves the robot down one space on the board
	static void moveDown(int a, int b, char board[][]) {
		board[a][b] = '_';
		board[a + 1][b] = 'O';
	}

	// Moves the robot left one space on the board
	static void moveLeft(int a, int b, char board[][]) {
		board[a][b] = '_';
		board[a][b - 1] = 'O';
	}
	
	// Moves the robot right one space on the board
	static void moveRight(int a, int b, char board[][]) {
		board[a][b] = '_';
		board[a][b + 1] = 'O';
	}

	// Prints out the board
	static void print(char board[][]) {
		for (int i = 0; i < magicN; i++) {
			System.out.println(board[i]);
		}
	}

	// Main method which runs the robot game
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Welcome to the Robot Simulator");
		// Takes in the board from a text file that the user provides
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file for the Board");
		String path = scan.nextLine();
		Scanner input = new Scanner(new File(path));
		int i = 0;
		// Creates board
		char board[][];
		board = new char[magicN][magicN];
		while (input.hasNextLine()) {
			Scanner boardScan = new Scanner(input.nextLine());
			board[i] = boardScan.nextLine().toCharArray();
			i++;
		}
		// Prints out the board created from the text file
		print(board);
		System.out.println("Enter file for the Robot Commands");
		// Moves in a direction based on the users input
		String pathTwo = scan.nextLine();
		Scanner commands = new Scanner(new File(pathTwo));
		String comm;
		int a = 0;
		int num = 0;
		int b = 0;
		System.out.println("Simulation begin");
		while (commands.hasNextLine()) {
			Scanner simulation = new Scanner(System.in);
			comm = simulation.nextLine();

			System.out.println("Command " + num);
			num++;
			robotc.enqueue(comm);
			simulation.close();
		}
		comm = "";
		while(robotc.peek()!=null) {
			// Moves the robot up one
			comm = (String)(robotc.dequeue());
			if (comm == "Move Up") {
				if (isSafe(a - 1, b, board)) {
					moveUp(a, b, board);
					a = a - 1;
					print(board);
				} else {
					System.out.println("Simulation end");
					System.out.println("Quit? Enter 'true' to quit or hit enter to run another simulation");
					if(commands.nextLine() == "true") {
						break;
					}
				}
			// Moves the robot down one
			} else if (comm == "Move Down") {
				if (isSafe(a + 1, b, board)) {
					moveDown(a, b, board);
						a = a + 1;
						print(board);
					} else {
						System.out.println("Simulation end");
						System.out.println("Quit? Enter 'true' to quit or hit enter to run another simulation");
						if(commands.nextLine() == "true") {
							break;
						}
				}
			// Moves the robot right one
			} else if (comm == "Move Right") {
				if (isSafe(a, b + 1, board)) {
					moveRight(a, b, board);
					b = b + 1;
					print(board);
				} else {
					System.out.println("Simulation end");
					System.out.println("Quit? Enter 'true' to quit or hit enter to run another simulation");
					if(commands.nextLine() == "true") {
						break;
					}
				}
			// Moves the robot left one
			} else if (comm == "Move Left") {
				if (isSafe(a, b - 1, board)) {
					moveLeft(a, b, board);
					b = b - 1;
					print(board);
				} else {
					System.out.println("Simulation end");
					System.out.println("Quit? Enter 'true' to quit or hit enter to run another simulation");
					if(commands.nextLine() == "true") {
						break;
					}
				}
			// If commands are not entered properly it returns that the command was invalid
			} else {
				System.out.println("Invalid command");
			}
			if (a == 9 && b == 9) {
				System.out.println("Simulation end");
				break;
			}
		commands.close();
		scan.close();
		input.close();
		}
	}
}