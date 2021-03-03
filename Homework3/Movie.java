package Homework02;
/**
 * Created by Ellie Barry
 */

public class Movie {

	// Instance variables
	public String name;
	public int year;
	public int rating;
	public String director;
	public int boxOffice;

	// Default constructor
	public Movie() {
		name = "CSCE 146";
		year = 0;
		rating = 0;
		director = "JJ Shepard";
		boxOffice = 0;
	}
	
	
	// Constructor
	public Movie(String n, int y, int r, String d, int b) {
		name = n;
		year = y;
		rating = r;
		director = d;
		boxOffice = b;
	}

	// Getter method for name
	public String getName() {
		return name;
	}

	// Getter method for year
	public int getYear() {
		return year;
	}

	// Getter method for rating
	public int getRating() {
		return rating;
	}

	// Getter method for director
	public String getDirector() {
		return director;
	}

	// Getter method for box office gross
	public int getBoxOffice() {
		return boxOffice;
	}

	// Setter method for name
	public void setName(String n) {
		name = n;
	}

	// Setter method for year
	public void setYear(int y) {
		year = y;
	}

	// Setter method for rating
	public void setRating(int r) {
		rating = r;
	}

	// Setter method for director
	public void setDirector(String d) {
		director = d;
	}

	// Setter method for box office gross
	public void setBoxOffice(int b) {
		boxOffice = b;
	}
	
	// Checks to see if the two movies are equal to each other and returns true or false
	public boolean equals(Movie m) {
		return m != null && m.getName().equals(this.getName()) && m.getDirector().equals(this.getDirector()) && m.getYear() == this.getYear() && m.getBoxOffice() == this.getBoxOffice();
	}
	
	// Checks to see if the two movies are equal to each other and returns 1
	public int compareTo(Movie m) {
		if (m.getName().equals("") && m.getDirector().equals("") && m.getYear() == 0 && m.getRating() == 1 && m.getBoxOffice() == 0) 
			return 0;
		return 1;
	}
	
	// Returns all information about the movie
	public String toString() {
		return "Name: " + this.getName() + "\nDirector: " + this.getDirector() + "\nYear: " + this.getYear() + "\nRating: " + this.getRating() + "\nBox Office Gross: " + this.getBoxOffice();
	}


}
