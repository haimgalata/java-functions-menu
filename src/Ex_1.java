//Haim Galata:206450397//
import java.util.Scanner;
//A program that receives an array of numbers and arranges the order so that the negatives are on the left and the positives are on the right with the help of a function
public class Ex_1 {
	public static Scanner input = new Scanner(System.in);// Creating a Scanner object for user input

	public static void main(String[] args) {
		System.out.print("Please enter the array size: ");// Prompting the user to enter the array size
		int array[] = new int[input.nextInt()];// Creating an array of integers with size entered by the user
		System.out.print("Please enter the array: ");// Prompting the user to enter the array elements
		for (int col = 0; col < array.length; col++)// Loop to iterate through each element of the array
			array[col] = input.nextInt();// Creating an array of integers with size entered by the user
		arrangeArray(array);// Calling the arrangeArray method to arrange the array
		System.out.print("The result is: ");// Displaying the result array after arranging
		for (int indexValue : array)// Loop to iterate through each element of the array
			System.out.print(" " + indexValue);// print each element of the array
		input.close();// close scanner
	}
	public static void arrangeArray(int[] arr) {// Method to rearrange the array with positive numbers at the end and negative numbers at the beginning
		int temp = 0; // temporary variable
		for(int leftIndex = 0 ,rightIndex = arr.length-1; leftIndex < rightIndex;leftIndex++) // Initializing two pointers leftIndex and rightIndex for traversing the array from both ends
		if((rightIndex>leftIndex && arr[rightIndex]>0)&&(leftIndex<arr.length && arr[leftIndex]<0) )// Checks if the value at the right end of the array is positive and at the left end is negative
			rightIndex--;// Move rightIndex pointer to the left
	   	else if(rightIndex>leftIndex && arr[rightIndex]<0&& leftIndex<arr.length && arr[leftIndex]>0) { // Checks if the value at the right end of the array is negative and at the left end is positive
			// Swaps the values if the condition is met
			temp=arr[leftIndex];
		    arr [leftIndex]=arr[rightIndex];
		    arr[rightIndex]=temp;
		    rightIndex--; // Move rightIndex pointer to the left after swap
		}
		else if(rightIndex>leftIndex && arr[leftIndex]>0) {   // In case where the value at the left end of the array is positive
            // Adjusts the indices to continue working with the next value from the left side of the array
			leftIndex--;// Move leftIndex pointer to the left
			rightIndex--;// Move rightIndex pointer to the left
		}
   }
}