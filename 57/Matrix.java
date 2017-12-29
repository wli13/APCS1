//Wenting Li
//APCS1 pd08 
//HW55 -- Never Fear, Big Oh is Here!
//2017-12-15

//FINISHED
//=====================================

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

  private Object[][] _matrix;

  //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
  public Matrix( ) 
	{
    _matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
  }


  //constructor intializes an a*a matrix
  public Matrix( int a ) 
  {
    _matrix = new Object[a][a];
  }


  //return size of this matrix, where size is 1 dimension
  private int size() 
  {
    return _matrix.length;
  }


  //return the item at the specified row & column   
  private Object get( int r, int c ) 
  {
    return _matrix[r-1][c-1];
  }


  //return true if the item at the specified 
  //row & column is empty, false otherwise
  private boolean isEmpty(int r, int c) 
  {
    return get(r,c) == null;
  }


  //overwrite item at specified row and column with newVal
  //return old value
  private Object set( int r, int c, Object newVal ) 
  {
    Object oldVal = get(r,c);
    _matrix[r-1][c-1] = newVal;
    return oldVal;
  }


  //return String representation of this matrix
  // (make it look like a matrix)
  public String toString() 
  {
    String retStr = "";
    for (Object[] rows : _matrix) {
      retStr += "| ";
      for (Object columns : rows) {
        retStr += columns + " ";
      }
      retStr += "|\n"; 
    }
    return retStr;
  }


  //override inherited equals method
  //criteria for equality: matrices have identical dimensions,
  // and identical values in each slot
  public boolean equals( Object rightSide ) 
  {
    boolean pigeon = false;

	  // checks for aliases  ex. m1.equals(m1) is true    
    if (this == rightSide) 
    pigeon = true;  

	  else if ( rightSide instanceof Matrix 
		  && size() == ( (Matrix)rightSide).size() ) {
        
        Matrix r = (Matrix) rightSide; //for cleaner code later
	      pigeon = true;

        //break outer returns the code to where the "outer:" marks
        outer:
	      for( int i = 1; i <= size(); i++ ) {
		      for( int j = 1; j <= size(); j++ ) {
            if ( !isEmpty(i,j) && !get(i,j).equals(r.get(i,j)  )) {
              pigeon = false;
			        break outer;        
            }
            else if (isEmpty(i,j) && !r.isEmpty(i,j) ) {
              pigeon = false;
			        break outer;
            }            
          }
        } 
      }
      return pigeon;    
  }


  //swap two columns of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapColumns( int c1, int c2  ) 
  {
	  for( int i = 1; i <= size(); i++ ) {
	    set( i, c1, set( i, c2, get(i,c1) ) );
    }
  }//O(n) b/c must visit n rows


  //swap two rows of this matrix 
  //(1,1) is top left corner of matrix
  //row values increase going down
  //column value increase L-to-R
  public void swapRows( int r1, int r2  ) 
  {
    r1 -= 1;
    r2 -= 1;
    Object[] tempRow = _matrix[r1];
    _matrix[r1] = _matrix[r2];
    _matrix[r2] = tempRow;
  }//O(1)


  //main method for testing
  public static void main( String[] args ) 
  {
    Matrix m1 = new Matrix(); // 2 x 2
    Matrix m2 = new Matrix(10); // 10 x 10
    System.out.println("m1 size: " + m1.size());
    System.out.println("m2 size: " + m2.size());
    System.out.println("m1 get(1,1) : " + m1.get(1,1));
    System.out.println("m1 isEmpty(1,1) : " + m1.isEmpty(1,1));	

    Matrix x = new Matrix(2); // 2x2
    System.out.println("Matrix x:\n" + x);
    x.set(1,1,"how"); 
    x.set(1,2,"now"); 
    x.set(2,1,"bro"); 
    x.set(2,2,"cow"); 
    System.out.println(x);

    Matrix y = new Matrix(); 
    y.set(1,1,"how"); 
    y.set(1,2,"now"); 
    y.set(2,1,"bro"); 
    y.set(2,2,"cow"); 

    System.out.println("m1 equals m2: " + m1.equals(m2)); //false
    System.out.println("m1 equals x: " + m1.equals(x)); //false
    System.out.println("x equals y: " + x.equals(y)); //true

    System.out.println("\nSwapping rows 1 and 2 of x...");
    x.swapRows(1,2);
    System.out.println(x);

    System.out.println("Swapping columns 1 and 2 of x...");
    x.swapColumns(1,2);
    System.out.println(x);
  }

}//end class Matrix
