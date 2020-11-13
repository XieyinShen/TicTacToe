package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

  private static final int SIZE = 3;
  private static final char POSITION_EMPTY = '-';
  private static final char POSITION_PLAY_ONE = 'x';
  private static final char POSITION_PLAY_TWO = 'o';

  public static void main(String[] args) {
	
	// Init.
	char[][] matrix = new char[SIZE][SIZE];
	for (int i = 0; i < SIZE; i++) {
	  for (int j = 0; j < SIZE; j++) {
		matrix[i][j] = POSITION_EMPTY;
	  }
	}

	// Ask for the player's name to map x and o.
	String pOne = null;
	String pTwo = null;
	try (Scanner in = new Scanner(System.in)) {
	  System.out.println("Tic-Tac-Toe started!");
	  System.out.print("Player 1 name: ");
	  pOne = in.nextLine();
	  System.out.print("Player 2 name: ");
	  pTwo = in.nextLine();
	  
	  boolean isPlayOneTurn = true;
	  boolean isGameOver = false;
	  
	  while (!isGameOver) {
		printMatrix(matrix);

		// Print the player's turn.
		if (isPlayOneTurn) {
		  System.out.println(pOne + "'s Turn (" + POSITION_PLAY_ONE + "):");
		} else {
		  System.out.println(pTwo + "'s Turn (" + POSITION_PLAY_TWO + "):");
		}

		char c = isPlayOneTurn ? POSITION_PLAY_ONE : POSITION_PLAY_TWO;
		int row = 0;
		int col = 0;

		while (true) {

		  // Ask for player's input for matrix position.
		  System.out.print("Enter the row number (1, 2, or 3): ");
		  row = in.nextInt() - 1;
		  System.out.print("Enter the column number (1, 2, or 3): ");
		  col = in.nextInt() - 1;

		  // Check the boundary of row and column.
		  if (row < 0 || col < 0 || row > SIZE - 1 || col > SIZE - 1) {
			System.out.println("Invalid postion!");

			// Check if it an empty position.
		  } else if (matrix[row][col] != POSITION_EMPTY) {
			System.out.println("Non-empty position!");
			
		  } else { // valid
			break;
		  }
		}
		
		matrix[row][col] = c;

		if (hasPlayerWon(matrix) == POSITION_PLAY_ONE) {
		  System.out.println(pOne + " won!!!");
		  isGameOver = true;
		} else if (hasPlayerWon(matrix) == POSITION_PLAY_TWO) {
		  System.out.println(pTwo + " won!!!");
		  isGameOver = true;
		} else {

		  // For tie.
		  if (isMatrixFull(matrix)) {
			System.out.println("Tie!!!");
			isGameOver = true;
		  } else {
			isPlayOneTurn = !isPlayOneTurn; // turn around...
		  }
		}
	  }
	}
	printMatrix(matrix);
  }

  /**
   * Print the matrix for the game playing.
   * 
   * @param grid
   */
  public static void printMatrix(char[][] grid) {
	System.out.println("Matrix:");
	for (int i = 0; i < SIZE; i++) {
	  for (int j = 0; j < 3; j++) {
		System.out.print(grid[i][j]);
	  }
	  System.out.println();
	}
  }

  /**
   * Validate if player has own.
   * 
   * @param matrix
   * @return
   */
  public static char hasPlayerWon(char[][] matrix) {
	
	// Validate row.
	for (int i = 0; i < SIZE; i++) {
	  if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][0] != POSITION_EMPTY) {
		return matrix[i][0];
	  }
	}

	// Validate column
	for (int j = 0; j < SIZE; j++) {
	  if (matrix[0][j] == matrix[1][j] && matrix[1][j] == matrix[2][j] && matrix[0][j] != POSITION_EMPTY) {
		return matrix[0][j];
	  }
	}

	// Validate 2 diagonals
	if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != POSITION_EMPTY) {
	  return matrix[0][0];
	}
	if (matrix[2][0] == matrix[1][1] && matrix[1][1] == matrix[0][2] && matrix[2][0] != POSITION_EMPTY) {
	  return matrix[2][0];
	}

	return ' ';
  }

  /**
   * Validate if matrix is full with input position.
   * @param matrix
   * @return
   */
  public static boolean isMatrixFull(char[][] matrix) {
	for (int i = 0; i < SIZE; i++) {
	  for (int j = 0; j < SIZE; j++) {
		if (matrix[i][j] == POSITION_EMPTY) {
		  return false;
		}
	  }
	}
	return true;
  }
}
