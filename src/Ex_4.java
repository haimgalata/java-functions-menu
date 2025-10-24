//Haim Galata:206450397//
import java.util.Scanner;
//This program takes a square matrix as input from the user
//Then calculates and prints the diagonal with the maximum sum.
public class Ex_4 {
	public static Scanner input = new Scanner(System.in);// Creating a Scanner object for user input
	public static void main(String[] args) {
		System.out.print("Please enter the matrix size: ");// Asking the user to enter the size of the matrix
		int size = input.nextInt();// Reading the size of the matrix
		int[][] matrix = new int[size][size];// Creating a square matrix with the given size
		System.out.println("Please enter the matrix:");// Asking the user to enter the matrix elements
		for (int row = 0; row < matrix.length; row++)
			for (int col = 0; col < matrix[row].length; col++)
				matrix[col][row] = input.nextInt();
		printMaxDiagonal(matrix);// Calling the function to calculate and print the diagonal with the maximum sum
		input.close();// Closing the Scanner object
	}
	// This function calculates and prints the diagonal with the maximum sum
	public static void printMaxDiagonal(int[][] matrix) {
		int maxSum1 = matrix[0][0];// Initialize the maximum sum for the diagonal of the first half of a matrix
		int maxSum2 = matrix[matrix.length - 1][matrix.length - 1];// Initialize the maximum sum for the diagonal of the second half of a matrix
		int location1 = 0;// initialize the position of the maximum sum for the diagonal of the first half in the matrix
		int location2 = matrix.length;// initialize the position of the maximum sum for the diagonal of the second half in the matrix
		for (int row = 0; row < matrix.length; row++) {//First loop that finds the largest diagonal sum up to half the matrix
			int temp = 0;// Initializing a temporary sum for each diagonal
			int col = 0;// Initializing the column index for each diagonal
			for (int i = row; i >= 0; i--, col++) {// Calculating the sum of the diagonal starting from the current row
				temp += matrix[i][col];
			}
			if (maxSum1 < temp) {// Updating the maximum sum and its location if a larger sum is found
				maxSum1 = temp;
				location1 = col - 1;
			}
		}
		for (int col = matrix.length - 1; col > 0; col--) {// A second loop that finds the largest diagonal sum for the second half of the matrix
			int temp = 0;// Initializing a temporary sum for each diagonal
			int row = matrix.length - 1;// Initializing the row index for each diagonal
			for (int i = col; i < matrix.length; row--, i++) {// Calculating the sum of the diagonal starting from the current column
				temp += matrix[row][i];
			}
			if (maxSum2 <= temp) {// Updating the maximum sum and its location if a larger sum is found
				maxSum2 = temp;
				location2 = row + 1;
			}
		}
		System.out.print("The max diagonal is: ");
		if (maxSum1 >= maxSum2)// Check which diagonal sum is greater
			for (int col = location1, row = 0; col >= 0; col--, row++)// Iterate over the elements of the diagonal with the maximum sum
				System.out.print(matrix[row][col] + " ");// Print each element of the diagonal
		else
			for (int row = location2, col = matrix.length - 1; row <= matrix.length-1; row++, col--)// Iterate over the elements of the diagonal with the maximum sum
				System.out.print(matrix[row][col] + " ");// Print each element of the diagonal
	}
}
