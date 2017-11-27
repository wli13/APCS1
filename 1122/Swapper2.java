/*============================
  Woosuk Lee
  APCS1 pd1
  HW 38 -- Put It Together
  2017-11-22
==============================
Summary:
This java file includes a static variable _arr that creates rows and columns depending on user inputs and returns an array with random strings. It can also swap elements by specifying which element to swap (by physically typing in which one).
*/

import cs1.Keyboard;

public class Swapper2{
    ///inst var
    private static String[][] _arr;
    
    //idea inspired by William Lu pd 8
    private static boolean good = false;
    //this variable works as a "switch," so to speak, which checks if the swapping has been done correctly in the main method.
    
    public static void makeArr( int rows, int columns){
        int ctr = 0;
        _arr = new String[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                _arr[i][j] = ""+(int)(Math.random() * 1000);
                //sets the element equal to a random 3 digit number
            }
        }
    }
    
    public static void printArr(){
        String line = "   ";
        //******************************************//
        //Printing out the column numbers on top
        for(int i = 0; i < _arr[0].length; i++){
            line = line + i + "   ";
        }
        line = line.substring(0,line.length()-2);
        System.out.println(line);
        //******************************************//
        line="";
        for(int i = 0; i < _arr.length; i++){
            line = i + ""; 
            //adding the integer i to the variable "line" ensures that the row numbers will be printed at the beginning of each row.
            
            for(int j = 0; j < _arr[0].length; j++){
                line = line + " " + _arr[i][j] + " ";
                // save all entities in one line and print it outside the loop.
            }
            System.out.println(line + "\n");
            line = ""; //reset it to an empty string so it can be used to store the next row of entities.
        }
    }
    
    public static boolean inArr( String str ){
        for (String[] line : _arr){
            for (String chr : line){
                if (chr.equals(str)){
                    return true;
                }
            }
        }
        return false;
        //helper function which basically checks to see if an element is in the function.
    }
    
    public static void swap( int a, int b, int c, int d){
        if( inArr(_arr[a][b]) && inArr(_arr[c][d]) )
        //first check to make sure that the input values are in the array
        {
            //***********************
            String temp = _arr[a][b];
            _arr[a][b] = _arr[c][d];
            _arr[c][d] = temp;
            //swtich the numbers
            //***********************
            
            good = true; 
            //set this "switch" to true if swapping has been done correctly.
            }
        
        else{
            System.out.println("Error: Input strings are not in the array."); //if the input is not found in the array, return the error message.
        }
    }
    
    public static void main( String[] args ){
        System.out.print("Input number of rows: ");
        int row = Keyboard.readInt();
        System.out.print("Input number of columns: ");
        int column = Keyboard.readInt();
        
        makeArr(row, column);
        printArr();
        
        while (! good){
            System.out.print("Type the row number followed by the the column number." + "\n");                         
            System.out.print("Row Number of the first element: ");
            int a = Integer.parseInt(Keyboard.readString());
            System.out.print("Column Number of the first element: ");
            int b = Integer.parseInt(Keyboard.readString());
            System.out.print("Row Number of the second element: ");
            int c = Integer.parseInt(Keyboard.readString());
            System.out.print("Column Number of the second element: ");
            int d = Integer.parseInt(Keyboard.readString());
            swap(a, b, c, d);
        }
        System.out.println("Printing the new array.");
        printArr();
    }
}