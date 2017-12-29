//Wenting Li
//APCS1 pd08 
//HW58 -- Make the Matrix Work for You
//2017-12-21

//
//=====================================


/***
 * class Matrix -- models a square matrix
 * VERSION 2
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
            else if (!r.isEmpty(i,j) ) {
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


    //            PHASE 2
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //returns copy of row r
    public Object[] getRow( int r )
    {
      r -= 1;
      Object[] row = new Object[size()];
      for (int i = 0; i < size(); i++) {
        row[i] = _matrix[r][i];
      }
      return row;      
    }//O(n)

    //replaces row r with 1D array newRow
    //returns old row
    public Object[] setRow( int r, Object[] newRow )
    {
    	//first check for proper dimension:
	    if (newRow.length != size() ) 
        return null;

      r -= 1;
      Object[] temp = _matrix[r];
      _matrix[r] = newRow;
      return temp;
    }//O(1)

    public Object[] setCol( int c, Object[] newCol )
    {
    }//O(?)

    //M[i,j] -> M[j,i] for all i,j
    public void transpose()
    {
    }//O(?)
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
   
    
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
	System.out.println(x);
	x.set(1,1,"how"); 
	x.set(1,2,"now"); 
	x.set(2,1,"bro"); 
	x.set(2,2,"cow"); 
	System.out.println(x);

	Matrix m3 = new Matrix(3); //3x3
	System.out.println(m1);
    }//end main()

}//end class Matrix
