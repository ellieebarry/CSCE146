package Homework02;
/**
 * Created by Ellie Barry 
 */

import java.io.*;
import java.util.*;

public class MovieDatabase extends GenLinkedList<Movie>{

	public GenLinkedList<Movie> movies;
	public static final String DELIM = "\t";
	
	public MovieDatabase() {
		movies = new GenLinkedList<Movie>();
	}
	// Adds movie to Linked List
	public void addMovie(Movie m) {
		movies.insert(m);
	}
	
	// Removes movie by title that user enters
	public void removeMovie(String t) {
		Movie aMovie = new Movie();
		aMovie.setName(t);
		movies.resetCurrent();
		while(movies.moreToIterate()) {
			if(movies.getCurrent().getName() == aMovie.getName())
				movies.deleteCurrent();
			movies.goToNext();
		}
	}
	
	// Creates a list of the types to be used to search for movie by these sections
	static enum FindType {
		TITLE, DIRECTOR, YEAR, RATING;
	}
	
	
	public GenLinkedList<Movie> find(FindType findType, String parameter) {

		GenLinkedList<Movie> result = new GenLinkedList<Movie>();
		movies.reset();

		do {
			Movie currentMovie = movies.getCurrent();

			switch (findType) {
			case DIRECTOR:
				if (currentMovie.getDirector().equals(parameter)) result.insert(currentMovie);
				break;
			case TITLE:
				if (currentMovie.getName().equals(parameter)) result.insert(currentMovie);
				break;
			case RATING:
				if (currentMovie.getRating() == Integer.parseInt(parameter)) result.insert(currentMovie);
				break;
			case YEAR:
				if (currentMovie.getYear() == Integer.parseInt(parameter)) result.insert(currentMovie);
				break;
			}
			movies.goToNext();
		} while (movies.getCurrent() != null);
		return result;
	}
	
	
	
	// Prints out all movies in linked list
	public void printMovies() {
			movies.print();
	}
	
	// Prints out all movies and information about them to a text file
	public void printToFile(String fileName) {
		try {
			movies.resetCurrent();
			Movie m = movies.getCurrent();
			PrintWriter fileWriter = new PrintWriter(new File(fileName));
			while(movies.hasNext()) {
				fileWriter.println(m.getName() + DELIM + m.getYear() + DELIM + m.getRating() + DELIM + m.getDirector() + DELIM + m.getBoxOffice());
				movies.goToNext();
			}
			fileWriter.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	// Reads file and adds it to the linked list
	public void readFile(String fileName) {
		if (fileName == null)
			return;
		// Uses file scanner to read through the file and create a new movie object for each movie
		try {
			Scanner scanner = new Scanner(new File(fileName));
			int count = 0;
			while (scanner.hasNextLine()) {
				String inputLine = scanner.nextLine();
				String[] split = inputLine.split("\t");
				if (split.length != 5) {
					for (String s : split) {
						System.err.println(s);
					}
					continue;
				}
				split[4] = split[4].replaceAll(",", "");
				addMovie(new Movie(split[0], Integer.parseInt(split[2]), Integer.parseInt(split[3]), split[1], Integer.parseInt(split[4])));
				count++;

			}
			scanner.close();
			System.out.println("Movies have been loaded from " + fileName);
		// Checks to make sure it worked
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
