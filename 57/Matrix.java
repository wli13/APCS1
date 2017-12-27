/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
  //constant for default matrix size
  private final static int DEFAULT_SIZE = 2;

  private Object[][] matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix( ) 
	{
    matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
  public Matrix( int a ) 
  {
    matrix = new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
  private int size() 
  {
    return matrix.length;
  }


  //return the item at the specified row & column   
  private Object get( int r, int c ) 
  {
    return matrix[r-1][c-1];
  }


  //return true if this matrix is empty, false otherwise
  private boolean isEmpty() 
  {
    return true;
  }


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal ) 
  {
    return 1;
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString() 
  {
    return "gotee";
  }


  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Object rightSide ) 
  {
    return true;
  }


  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  ) 
  {
  }


  //swap two rows of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  ) 
  {
  }


  //main method for testing
  public static void main( String[] args ) 
  {
	Matrix m1 = new Matrix(); // 2 x 2
	Matrix m2 = new Matrix(10); // 10 x 10
	System.out.println("m1 size: " + m1.size());
	System.out.println("m2 size: " + m2.size());
	System.out.println("m1 get(1,1) : " + m1.get(1,1));
	System.out.println("m1 isEmpty() : " + m1.isEmpty());	

	Matrix x = new Matrix(2); // 2x2
	System.out.println(x);
	x.set(1,1,"how"); 
	x.set(1,2,"now"); 
	x.set(2,1,"bro"); 
	x.set(2,2,"cow"); 
	System.out.println(x);

	Matrix m3 = new Matrix(3); //3x3
	System.out.println(m1);    
  }

}//end class Matrix
