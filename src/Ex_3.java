//Haim Galata:206450397//
import java.util.Scanner;
//A program that accepts a matrix and performs several operations upon request
public class Ex_3 {
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int[][] matrix;// Declare a 2D array to store the matrix
		System.out.print("Please enter the number of row of the matrix: ");// Prompt the user to enter the number of rows
		int rowSize = input.nextInt();// Read the number of rows from the user
		System.out.print("Please enter the number of col of the matrix: ");// Prompt the user to enter the number of column
		int colSize = input.nextInt();// Read the number of columns from the user
		matrix = new int[rowSize][colSize];// Initialize the matrix with the specified dimensions
		System.out.print("Please enter the the numbers of the matrix:\n");// Prompt the user to enter the matrix elements
		for (int row = 0; row < matrix.length; row++)// Iterate over each row of the matrix
			for (int col = 0; col < matrix[row].length; col++)// Iterate over each column of the current row
				matrix[row][col] = input.nextInt();// Read the matrix element from the user
		System.out.print("Choose a column number and value: \n");// Prompt the user to choose a column number and value
		System.out.println("The number of shows is: " + numInColumn(matrix, input.nextInt(), input.nextInt()) + "\n");//Using the function and printing the result
		System.out.print("Select two columns: \n");// Prompt the user to select two columns
		System.out.println("They are simlar (true/false): " + similarColumns(matrix, input.nextInt(), input.nextInt()) + "\n");//Using the function and printing the result
		System.out.println("If the matrix has identical columns (false) else (true): " + allDiffColumns(matrix));//Using the function and printing the result
	}
	// Function to find the number of occurrences of a value in a specific column of the matrix
	public static int numInColumn(int[][] matrix, int col, int val) {
		int count = 0;// Initialize a counter for the number of occurrences
		for (int row = 0; row < matrix.length; row++)// Iterate over each row of the matrix
			if (val == matrix[row][col])// If the current element in the specified column matches the value
				count++;// Increment the counter
		return count;// Return the number of occurrences
	}
	// Function to check if two columns in the matrix are similar
	public static boolean similarColumns(int[][] matrix, int col1, int col2) {
		for (int row = 0; row < matrix.length; row++) {// Iterate over each row of the matrix
			int currentCellVal = matrix[row][col1];// Get the value of the current cell in the first column
			if (1 != numInColumn(matrix, col1, currentCellVal) || 1 != numInColumn(matrix, col2, currentCellVal))// If the number of occurrences of the current cell value in either column is not equal to 1
				return false;// The columns are not similar, return false
		}
		return true;// All cells in the two columns are similar, return true
	}
	// Function to check if all columns in the matrix are different
	public static boolean allDiffColumns(int[][] matrix) {
		int colSize = matrix[0].length;// Get the number of columns in the matrix
		for (int currentColumn = 0; currentColumn < colSize - 1; currentColumn++) {// Iterate over each column (except the last one)
			for (int runningColumn = currentColumn; runningColumn < colSize - 1; runningColumn++) 
				if (true == similarColumns(matrix, currentColumn, runningColumn + 1))// If the current column is similar to any of the following columns
					return false;// Columns are not all different, return false
		}
		return true;// All columns are different, return true
	}
}