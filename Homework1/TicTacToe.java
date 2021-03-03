/**
 * Created by Ellie Barry on 9/4/19
 */

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
  // Sets instance variables
  static int SIZE = 4;
  static int row = 0;
  static int col = 0;
  static boolean stop = false;
  // Counts how many times a player wins in a tournament
  static int counter = 0;

  public static void main(String[] args) { 
    // Creates empty game board
    char[][] board = new char[SIZE][SIZE];
    createBoard(board);
    System.out.println("Welcome to Tic Tac Toe Tourney! How many games can you win in a row?");
    // Runs through the game to play multiple games
    while(stop == false){
      createBoard(board);
      play(board);
    } 
  }
  
 // Plays one full game of tic tac toe
  public static void play(char[][] board){
    row = 0;
    col = 0;
    while(winner(row,col,board)){
      // Plays the user's turn
      printBoard(board);
      enterMove(board);
      // Checks if the board is full and exits while loop if it is
      if(CAT(board)){
        System.out.println("You tied because all spaces are full!");
        return;
      }
      // Checks if the user won and exits while loop if it did
      if(winner(row,col,board) == false){
        System.out.println("You win! \nThe computer demands a rematch!");
        createBoard(board);
        return;
      }
      // Plays computer's turn
      computerTurn(board);
      // Checks if the board is full and exits while loop if it is
      if(CAT(board)){
        System.out.println("You tied because all spaces are full!");
        return;
      }
      // Checks if the computer won and exits while loop if it did
      if(winner(row,col,board) == false){
        printBoard(board);
        System.out.println("You lost but you won " + counter);
        createBoard(board);
        System.out.println("Would you like to play again? Yes or no");
        Scanner keyboard = new Scanner(System.in);
        String answer = keyboard.nextLine();
        if(answer.equals("yes")){
          stop = false;
        } else{
          stop = true;
        }
        return;
      }
    }
  }
  
  // Sets each space on the board equal to ' ' to signify that it is empty
  public static char[][] createBoard(char[][] board){
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
        board[0][1] = '0';
        board[0][2] = '1';
        board[0][3] = '2';
        board[1][0] = '0';
        board[2][0] = '1';
        board[3][0] = '2';
        
        return board;
  }
  
  // Plays computer's turn using java.Random and making sure it is in bounds
  public static void computerTurn(char[][] board){
    boolean invalid = true;
    while(invalid){
      Random rand = new Random();
      row = rand.nextInt(3);
      col = rand.nextInt(3) + 1;
      // Checks that the position is in 2D array
      if(row >= 0 && row < SIZE && col >= 0 && col < SIZE){
        // Checks that the position is not taken
        if(board[row][col] == ' '){
          invalid = false;
        }
      }
    }
    // Sets the computer's turn
    board[row][col] = 'O';
  }
  
  // Creates the set up for each row with the correct spacing so that printing the board is easier
  public static void printRow(int r, char[][] board){
    System.out.println(board[r][0] + " | " + board[r][1] + " | " + board[r][2] + " | " + board[r][3] + " | " + " ");
  }
  // Implements printRow to print out the board with proper lines
  public static void printBoard(char[][] board){
    printRow(0, board);
    System.out.println("-----------------");
    printRow(1, board);
    System.out.println("-----------------");
    printRow(2, board);
    System.out.println("-----------------");
    printRow(3, board);
    System.out.println("-----------------");
  }
  
  // Takes in user's turn, makes sure it is valid and sets the turn on the board
  public static void enterMove(char[][] board){
    boolean invalid = true;
    // Keeps asking for row and column till they enter valid ones
    while(invalid){
      System.out.println("Enter the coordinates to place an 'X'. Row then Column. Or enter a negative number to quit");
      Scanner keyboard = new Scanner(System.in);
      row = keyboard.nextInt();
      col = keyboard.nextInt();
      // Checks that the position is in 2D array
      if(row >= 0 && row < SIZE && col >= 0 && col < SIZE){
        // Checks that the position is not taken
        if(board[row][col] == ' '){
          invalid = false;
        }
      }
    }
    // Sets user's turn on the board
    board[row][col] = 'X';
  }
  
  // Determines if someone won the game
  public static boolean winner(int row, int col, char[][] board){
    boolean winner = true;
    // Checks left and right to see if they won
    int numFound = 0;
    for(int c = 1; c < SIZE; c++){
      if(board[row][c] == board[row][col]){
        numFound++;
      }
    }
    if(numFound == 3){
        winner = false;
        counter++;
    }
    // Checks up and down to see if they won
    numFound = 0;
    for(int r = 1; r < SIZE; r++){
      if(board[r][col] == board[row][col]){
        numFound++;
      }
    }
      if(numFound == 3){
        winner = false;
        counter++;
      }
      // Checks both diagonals to see if they won
      numFound = 0;
      for(int i = 0; i < SIZE; i++){
        if(board[i][i] == board[row][col]){
          numFound++;
        }
      }
      if(numFound == 3){
        winner = false;
        counter++;
      }
  // Returns if winner was found
  return winner;
 } 
  
  // Checks to see if the board is full
  public static boolean CAT(char[][] board){
    int count = 0;
    for (int i = 1; i < SIZE; i++){
            for (int j = 1; j < SIZE; j++) {
              if(board[i][j] != ' '){
                count++;
              }
            }
        }
    if(count == 9){
      return true;
    } else{
      return false;
    }
  }
  
}
