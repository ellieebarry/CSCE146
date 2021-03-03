package Homework02;

/**
 * Created by Ellie Barry 
 */

import java.io.*;
import java.util.*;

public class MovieDatabaseFrontEnd {
	
	// Instance variable
	public static int answer = 1;
	
	public static void main(String[] args) {
		
		MovieDatabase movies = new MovieDatabase();
		while (answer != 0) {
			System.out.println("Enter 1: To Add a Movie\n" + "Enter 2: To Remove a Movie by its Title\n"
					+ "Enter 3: To search for a Title\n" + "Enter 4: To search for movies by a Director\n"
					+ "Enter 5: To search for movies of a given Year\n"
					+ "Enter 6: To search for movies of a certain Rating\n" + "Enter 7: To print out all movies\n"
					+ "Enter 8: To print to a database file\n" + "Enter 9: To load a database file\n"
					+ "Enter 0: To quit");
			// Takes in the users input for what they would like to do (0-9)
			Scanner keyboard = new Scanner(System.in);
			answer = keyboard.nextInt();
			Scanner stringReader = new Scanner(System.in);

			// Lets user quit
			if (answer == 0) {
				break;
				// Adds movie to linked list
			} else if (answer == 1) {
				System.out.println("Enter the title of the movie you want to add: ");
				String movieTitle = stringReader.nextLine();
				System.out.println("Enter the director of the movie: ");
				String movieDirector = stringReader.nextLine();
				System.out.println("Enter the release year of the movie: ");
				int movieYear = keyboard.nextInt();
				System.out.println("Enter the rating of the desired movie: ");
				int movieRating = keyboard.nextInt();
				System.out.println("Enter the box office profit of the movie: ");
				int boxOffice = keyboard.nextInt();

				movies.addMovie(new Movie(movieTitle, movieYear, movieRating, movieDirector, boxOffice));
				System.out.println("Movie added!");

				// Removes Movie by its title
			} else if (answer == 2) {
				System.out.println("Enter the title of the movie you want to delete: ");
				movies.removeMovie(stringReader.nextLine());

				System.out.println("Removed movie!");

				// To search for a Title
			} else if (answer == 3) {
				System.out.println("Enter the title of the movie you want to search for: ");
				movies.find(MovieDatabase.FindType.TITLE, stringReader.nextLine());
				
				System.out.println("Searched for movie!");

				// To search for moves by a Director
			} else if (answer == 4) {
				System.out.println("Enter the director of the movie you want to search for: ");
				movies.find(MovieDatabase.FindType.DIRECTOR, stringReader.nextLine());

				// To search for movies of a given Year
			} else if (answer == 5) {
				System.out.println("Enter the release year of the movie you want to search for: ");
				movies.find(MovieDatabase.FindType.YEAR, keyboard.nextLine());

				// To search for movies of a certain Rating
			} else if (answer == 6) {
				System.out.println("Key in the rating of the movie you want to search for: ");
				movies.find(MovieDatabase.FindType.RATING, keyboard.nextLine());

				// To print out all movies
			} else if (answer == 7) {
				movies.printMovies();

				// To print to a database file
			} else if (answer == 8) {
				System.out.println("Enter the file name: ");
				String outputFileName = stringReader.nextLine();
				movies.printToFile(outputFileName);

				// To load a database file
			} else if (answer == 9) {
				System.out.println("Enter the filename for the source file you want to open: ");
				String inputFileName = stringReader.nextLine();
				movies.readFile(inputFileName);
			}

		}
	}

}
