//Wenting Li
//APCS1 pd08    //Collaboration with Woosuk Lee pd01
//HW38 -- Put It Together
//2017-11-22

//FINISHED
//=====================================

/*	Class Swapper will: 
*   - create a 2D array of unique 3- or 4-character Strings 
*   - display it in the terminal 
*   - prompt the user to specify two locations 
*   - swap the items at these locations 
*   - redisplay the array
*/

import cs1.Keyboard;

public class Swapper {

	//instance variables
	private static String[][] _arr;

	private static int row1;
	private static int row2;
	private static int column1;
	private static int column2;


	public static void createArr(int rows, int columns) {
		_arr = new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
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


	public static void swapCoor() {
		System.out.println("Specify the locations of the two elements that you want to swap.");
		System.out.print("Enter row number of first element: ");
		row1 = Integer.parseInt(Keyboard.readString());
		System.out.print("Enter column number of first element: ");
		column1 = Integer.parseInt(Keyboard.readString());
		System.out.print("Enter row number of second element: ");
		row2 = Integer.parseInt(Keyboard.readString());
		System.out.print("Enter column number of second element: ");
		column2 = Integer.parseInt(Keyboard.readString());
	}

	public static void swap(int r1, int c1, int r2, int c2) {
		String temp = _arr[r1][c1];
		_arr[r1][c1] = _arr[r2][c2];
		_arr[r2][c2] = temp;
	}


	public static void main(String[] args) {
		System.out.println("~~~ Welcome to THE Swapper Program! ~~~\n");

		System.out.print("Input desired number of rows: ");
		int row = Keyboard.readInt();
		System.out.print("Input desired number of columns: ");
		int column = Keyboard.readInt();

		createArr(row, column);

		System.out.println("Current Array: ");
		displayArr();

		swapCoor();
		String e1 = "(" + row1 + "," + column1 + ")";
		String e2 = "(" + row2 + "," + column2 + ")";		
		System.out.println("\nSwapping elements " + e1 + " and " + e2 + ".");
		swap(row1, column1, row2, column2);

		System.out.println("Array after swapping: ");
		displayArr();

	}
}