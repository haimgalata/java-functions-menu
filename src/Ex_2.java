//Haim Galata:206450397//
import java.util.Scanner;
//A program that returns the overlapping part of two arrays that is shared between the end of the first array and the beginning of the second array
public class Ex_2 {
	public static Scanner input = new Scanner(System.in);// Creating a Scanner object for user input
	public static void main(String[] args) {
		System.out.print("Plaese enter the size of the first array: ");// Requesting the size of the first array from the user
		int[] firstArray = new int[input.nextInt()];// Creating the first array with the size provided by the user
		System.out.print("Plaese enter the first array: ");// Requesting the elements of the first array from the user
		for (int col = 0; col < firstArray.length; col++)// Looping through the first array to fill it with user input
			firstArray[col] = input.nextInt();
		System.out.print("Plaese enter the size of the second array: ");// Asking the user to enter the size of the second array
		int[] secondArray = new int[input.nextInt()];// Creating the second array with the size provided by the user
		System.out.print("Plaese enter the second array: ");// Asking the user to enter the elements of the second array
		for (int col = 0; col < secondArray.length; col++) // Looping through the second array to fill it with user input
			secondArray[col] = input.nextInt();
		int[] overlapArray = maxOverlap(firstArray, secondArray);// Calling the maxOverlap to finding the maximum overlap between the two arrays
		System.out.print("The max overlap is: ");// Displaying the maximum overlap
		for (int col = 0; col < overlapArray.length; col++)// Looping through the overlap array to display its elements
			System.out.print(overlapArray[col] + " ");
		input.close(); // Closing the Scanner object
	}
	public static int[] maxOverlap(int[] arr1, int[] arr2) {
		int[] overlapArray; // Array to store the overlapping elements
		int count = 0;// Counter for the number of overlapping elements
		int colArray2 = 0;// Column pointer for the second array
		int index = 0;// Index for aligning the arrays if one is longer than the other
		if (arr1.length > arr2.length)// Adjusting the starting index for arr1 if it is longer than arr2
			index = arr1.length - arr2.length;
		for (int colArray1 = index; colArray1 < arr1.length; colArray1++) {
			if (arr1[colArray1] == arr2[colArray2]) {// Check if the current elements match
				colArray2++;// Move to the next element in arr2
				count++;// Increment the count of matched elements
			} else {
				colArray2 = 0;
				count = 0;
			}
			if (colArray2 == arr2.length)
				colArray1 = arr1.length;
		}
		overlapArray = new int[count];// Creating the overlapArray with the size of the number of matched elements
		for (int col = 0; col < count; col++)// Copying the matched elements from arr2 to overlapArray
			overlapArray[col] = arr2[col];
		return overlapArray;// Returning the overlapArray
	}
}
