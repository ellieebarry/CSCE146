package Homework08;

/*
 * Created by Ellie Barry
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordFinderGame {
	
	// Instance variables
	public static final int DEF_SIZE = 5;
	public static final int DICT_SIZE = 25144;

	public static void main(String[] args) {
		// Uses scanner to read in dictionary file
		try {
			Scanner fileScanner = new Scanner(new File("Dictionary.txt"));
			// Creates a new String array with the amount of spaces for words in dictionary file
			String dictionary[] = new String[DICT_SIZE];
			for(int i = 0; i < DICT_SIZE; i++) {
				// Adds each word from the dictionary to the dictionary array
				dictionary[i] = fileScanner.nextLine().toUpperCase();
			}
			// Creates the words array with all letters
			String[][] LettersArr = { { "R", "A", "H", "J", "M" }, 
					{ "Y", "U", "W", "W", "K" },
					{ "R", "X", "N", "F", "M" }, 
					{ "Q", "G", "E", "E", "B" }, 
					{ "E", "O", "A", "P", "E" } };
			for(int i = 0; i < LettersArr.length; i++) {
				System.out.println();
				for(int j = 0; j < LettersArr.length; j++) {
					System.out.print(LettersArr[i][j] + " ");
				}
			}
			System.out.println();
			System.out.println();
			// Find all of the words in the array that are between 2 and 6 letters
			findAllWords(LettersArr, dictionary);
			fileScanner.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void findAllWords(String lettersArr[][], String dictionary[]) {
		String word = "";
		// Creates boolean array of if each letter has been checked
		boolean marked[][] = new boolean[DEF_SIZE][DEF_SIZE];
		for(int i = 0; i < DEF_SIZE; i++) {
			for(int j = 0; j < DEF_SIZE; j++) {
				marked[i][j] = false;
			}
		}
		for(int i = 0; i < DEF_SIZE; i++) {
			for(int j = 0; j < DEF_SIZE; j++) {
				System.out.println("Starting " + i + " " + j);
				checkWords(lettersArr, marked, dictionary, i, j, word);
			}
		}
	}

	// Recursive method that checks for words created by the current string or the string + neighbor
	public static void checkWords(String lettersArr[][], boolean marked[][], String dictionary[], int i, int j, String word) {
		//
		word += lettersArr[i][j];
		marked[i][j] = true;
		// Checks if the current word is a word, if it is it's printed out
		if(isWord(word, dictionary))
			System.out.println("Found Word: " + word);
		for(int row = i - 1; row < DEF_SIZE && row <= i + 1; row++) {
			for(int col = j - 1; col < DEF_SIZE && col <= j + 1; col++) {
				// Checks surrounding letters (if not marked) and if it creates a word in the dictionary the word is printed
				if(row >= 0 && col >= 0 && !marked[row][col] && word.length() < 6) {
					checkWords(lettersArr, marked, dictionary, row, col, word);
				}
			}
		}
		// If no more words it goes back to the last letter that did created a word and removes it from marked list
		word = "" + word.charAt(word.length() - 1);
		marked[i][j] = false;
	}

	public static boolean isWord(String word, String dictionary[]) {
		// Goes through and checks if the word is equal to the dictionary word for the full dictionary
		for(int i = 0; i < dictionary.length; i++) {
			if(word.equals(dictionary[i]) && word.length() >= 2)
				return true;
		}
		return false;
	}
}
