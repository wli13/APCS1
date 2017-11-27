//Wenting Li
//APCS1 pd08    //Collaboration with Woosuk Lee pd01
//HW40
//2017-11-27

//
//=====================================

/*	Class Swapper will: 
*   - create a 2D array of unique 3- or 4-character Strings 
*   - display it in the terminal 
*   - prompt the user to specify two locations 
*   - swap the items at these locations 
*   - redisplay the array
*/

/*  ____

*/

import cs1.Keyboard;

public class Swapper {

	//instance variables
	private static String[][] _arr;

	private static int row;
	private static int column;

	private static int erow1;
	private static int erow2;
	private static int ecolumn1;
	private static int ecolumn2;

	public static void newArr() {
		System.out.println("~~~ Welcome to THE Swapper Program! ~~~\n");

		System.out.print("Input desired number of rows: ");
		row = Keyboard.readInt();
		System.out.print("Input desired number of columns: ");
		column = Keyboard.readInt();
	}

	public static void createArr() {
		_arr = new String[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				_arr[i][j] = "" + ((int) (Math.random() * 899) + 100);
			}
		}
	}


	public static void displayArr() {
		for (String[] rows : _arr) {
			for (String columns : rows) {
				System.out.print(columns + "   ");
			}
			System.out.println();
		}
	System.out.println();
	}


	public static void getCoor() {
		System.out.println("Specify the locations of the two elements that you want to swap.");
		System.out.print("Enter row number of first element: ");
		erow1 = Integer.parseInt(Keyboard.readString());
		System.out.print("Enter column number of first element: ");
		ecolumn1 = Integer.parseInt(Keyboard.readString());
		System.out.print("Enter row number of second element: ");
		erow2 = Integer.parseInt(Keyboard.readString());
		System.out.print("Enter column number of second element: ");
		ecolumn2 = Integer.parseInt(Keyboard.readString());
	}


	public static void swap() {
		String temp = _arr[erow1][ecolumn1];
		_arr[erow1][ecolumn1] = _arr[erow2][ecolumn2];
		_arr[erow2][ecolumn2] = temp; 			
	} 


	public static void main(String[] args) {

		newArr();
		createArr();

		System.out.println("Randomly generated array: ");
		displayArr();

		getCoor();
		
		try {
			swap();
		}
		catch (Exception e) {
			System.out.println("Error has occured. Re-enter passable coordinates!\n");
			getCoor();
		}

		String e1 = "(" + erow1 + "," + ecolumn1 + ")";
		String e2 = "(" + erow2 + "," + ecolumn2 + ")";		
		System.out.println("\nSwapping elements " + e1 + " and " + e2 + ".");
		//String s = Keyboard.readString(); //confirm yes or no 

		System.out.println("Array after swapping: ");
		displayArr();

	}
}