//Haim Galata:206450397 | Netanel Rada:209409036//
import java.util.Scanner;
public class Assignment4 {
	public static Scanner sc = new Scanner(System.in);// Creating a scanner object to read user input
	public static void main(String[] args) { // The main method where the program starts
		int option;// Declaring variable to store user's menu choice
		do { // Loop to display the menu and handle user input
			option = getMenuChoice();// Calling the getMenuChoice method to display the menu and get user's choice
			switch (option) {// Switch statement to perform different actions based on user's choice
			case 1:// If user selects option 1 (Calculator)
				System.out.print("\nYour choice is " + option);
				char operator;// Declaring variables to store input operator for the calculation
				double num1, num2;// Declaring variables to store input numbers for the calculation
				System.out.println("\nPlease two numbers and operator: ");
				do {// Loop to ensure valid input for numbers and operator
					num1 = sc.nextDouble();// Reading two numbers and an operator from the user
					num2 = sc.nextDouble();
					operator = sc.next().charAt(0);
					if ((num2 == 0 && operator == '/') || operator != '+' && operator != '-' && operator != '/' && operator != '*')//Checking if the operator is valid and if division by zero is attempted
						System.out.println("Input incorrect! Please enter correct input: ");
				} while ((num2 == 0 && operator == '/') || operator != '+' && operator != '-' && operator != '*' && operator != '/');
				calculator(num1, num2, operator);// Calling the calculator method to perform the calculation based on user's input	
				break;
			case 2:// If user selects option 2 (Print parallelogram)
				System.out.print("\nYour choice is " + option);
				System.out.print("\nPlease enter number of rows of parallelogram: ");// Getting input for the number of rows of the parallelogram from the user
				float rowNum;
				do {// Loop to ensure valid input for the number of rows
					rowNum = sc.nextFloat();// Reading the number of rows for the parallelogram
					if (rowNum%1 == 0 && rowNum > 1 && rowNum < 10)// Checking if the input is a positive integer between 1 and 9
						printParallelogram((int) rowNum);// Calling the printParallelogram method to print the parallelogram pattern
					else
						System.out.print("Input incorrect! Please enter correct input: ");
				} while (rowNum%1 != 0 || rowNum <= 1 || rowNum >= 10);
				break;
			case 3: // If user selects option 3 (Print sorted numbers)
				System.out.print("\nYour choice is " + option);
				System.out.println("\nPlease enter two positive integers: ");// Getting input for two positive integers from the user
				float firstNum, secondNum;
				do {// Loop to ensure valid input for the two integers
					firstNum = sc.nextFloat();// Reading two positive integers from the user
					secondNum = sc.nextFloat();
					if (firstNum%1 == 0 && secondNum%1 == 0 && firstNum <= secondNum && firstNum>=0 && secondNum>=0)// Checking if the input consists of positive integers in ascending order
						printAllSortedNums((int)firstNum, (int)secondNum);// Calling the printAllSortedNums method to print sorted numbers within the specified range
					else
						System.out.println("incorrect! Please enter correct input: ");
				} while (firstNum%1!=0 || secondNum%1!=0 || firstNum > secondNum || firstNum<0 || secondNum<0);
				break;
			case 4:// If user selects option 4 (Decompose number)
				System.out.print("\nYour choice is " + option);
				System.out.print("\nPlease enter a number: ");// Getting input for a number from the user
				double num;
				do {// Loop to ensure valid input for the number
					num = sc.nextDouble();
					if (num >= 10 && num%1==0)// Checking if the input is a positive integer with at least two digits
						decomposeNumber((int)num);// Calling the decomposeNumber method to decompose the number into even and odd places
					else
						System.out.print("Input incorrect! Please enter correct input: ");
				} while (num < 10 || num%1!=0);
				break;
			case 5:// If user selects option 5 (Exit)
				System.out.println("Bye Bye.");
				break;
			default:// Handling incorrect input for menu choice
				System.out.print("Input incorrect! Please enter correct input:\n");
			}System.out.println();// Adding a new line for clarity after each menu option
		} while (option != 5);
		sc.close();// Closing the Scanner object to release resources
	}
	// Ex.1
	public static int getMenuChoice() {// Method to display the menu and get user's choice
		int choice;// Declaring variable to store user's choice
		System.out.print("1. Calculator\n" + "2. Print parallelogram\n" + "3. Print sorted numbers\n"
				+ "4. Decompose number\n" + "5. Exit\n" + "Please enter your choice: ");// Displaying the menu options
		choice = sc.nextInt();// Getting user's choice from the input
		return choice;// Returning the user's choice
	}
	// Ex.2
	public static void calculator(double num1, double num2, char operator) {// Method to perform arithmetic operations based on user's input
		if (operator == '+') {// Checking the operator and performing the corresponding operation
			System.out.println("The result is: " + (num1 + num2));
		} else if (operator == '-') {
			System.out.println("The result is: " + (num1 - num2));
		} else if (operator == '/') {// Handling division and formatting the result to two decimal places
			System.out.printf("The result is:%.2f\n", num1 / num2);
		} else // Handling multiplication
			System.out.println("The result is: " + num1 * num2);
	}
	// Ex.3
	public static void printParallelogram(int n) {// Method to print a parallelogram pattern
		int temp = n;
		for (int row = 0; row < n; row++, temp--) {// Loop to iterate through each row of the parallelogram
			for (int space = 0; space < row; space++)// Loop to print spaces before each row
				System.out.print(" ");
			for (int cole = 0; cole < n; cole++)// Loop to print numbers in each row
				System.out.print(temp);
			System.out.println();// Moving to the next line after printing each row
		}
	}
	// Ex.4
	public static boolean isSortedNum(int n) {// Method to check if a number is sorted
		do {// Loop to iterate through each digit of the number
			int temp = n%10;// Getting the last digit of the number
			n /=10;// Removing the last digit from the number
			if (temp < n%10) // Checking if the current digit is less than the next digit
				return false;
		} while (n != 0);
		return true;// Returning true if all digits are in non-decreasing order
	}
	// Ex.4
	public static void printAllSortedNums(int n, int m) {// Method to print sorted numbers within a specified range
		System.out.print("The sorted numbers are: \n");// Printing a message to indicate the purpose of the output
		for (int i = n; i <= m; i++, n++)// Loop to iterate through each number in the range
			if (isSortedNum(n))// Checking if the current number is sorted and printing it if true
				System.out.println(n);
	}
	// Ex.5
	public static void decomposeNumber(int userNumber) {
			int evenLocationNumbers = 0;// Variables to store the numbers at even locations
			int oddLocattionNumbers = 0;// Variables to store the numbers at odd locations
	    	int powLocation = 1;// Variable to track the position of the current digit
			int numOfDigitis = 0; // Variable to store the number of digits in the input number
			int temp = userNumber;// Temporary variable to hold the input number
			while (temp != 0) {// Loop to count the number of digits in the input number
				temp /= 10;
				numOfDigitis++;
			}if (numOfDigitis % 2 != 0)// Checking if the number of digits is odd or even
				while (userNumber != 0) {// Loop to process digits at even and odd locations if the number of digits is odd
					evenLocationNumbers += userNumber % 10 * powLocation;// Adding the digit at the even location to the even location numbers
					userNumber = userNumber / 10;// Moving to the next digit
					oddLocattionNumbers += userNumber % 10 * powLocation;// Adding the digit at the odd location to the odd location numbers
					userNumber = userNumber / 10;// Moving to the next digit
					powLocation = powLocation * 10;// Updating the position multiplier			
				}else
						while (userNumber != 0) {// Loop to process digits at even and odd locations if the number of digits is even
							oddLocattionNumbers += userNumber % 10 * powLocation;// Adding the digit at the odd location to the odd location numbers
							userNumber = userNumber / 10;// Moving to the next digit
							evenLocationNumbers += userNumber % 10 * powLocation;// Adding the digit at the even location to the even location numbers
							userNumber = userNumber / 10;// Moving to the next digit
							powLocation = powLocation * 10; // Updating the position multiplier	
	   }System.out.println("Even places: " + evenLocationNumbers); // Printing the numbers of even locations
		System.out.println("Odd places: " + oddLocattionNumbers); // Printing the numbers of odd locations	
		}
	}
