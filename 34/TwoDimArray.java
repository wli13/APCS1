//Wenting Li
//APCS1 pd08
//HW34 -- Arrays of Arrays
//2017-11-17

//FINISHED
//=====================================

/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

public class TwoDimArray {

  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOR loop
  public static void print1( int[][] a ) {
    for (int i = 0; i < a.length; i++) {
      for (int i2 = 0; i2 < a[i].length; i2++) {
        System.out.print(a[i][i2]);
      }
      System.out.println();
    }
    System.out.println("-------------");
  }


  //postcond: prints each row of 2D int array a on its own line
  //          uses a FOREACH loop
  public static void print2( int[][] a ) {
    for (int[] rows : a ) {
      for (int columns : rows ) {
      System.out.print(columns);
      }
      System.out.println();
    }
    System.out.println("-------------");
  }


  //postcond: returns sum of all items in 2D int array a
  public static int sum1( int[][] a ) {
    int sum = 0;
    for (int[] rows : a) {
      for (int columns : rows) {
        sum += columns;
      }
    }

    return sum;
  }


  //postcond: returns sum of all items in 2D int array a
  //          * uses helper fxn sumRow(FOR) or sumRow2(FOREACH)
  public static int sum2( int [][] m ) {
    //NOTE:this works because (int[] rows : m) sets the limitation/when to stop for counter

    int sum = 0;
    int counter = 0;
    for (int[] rows : m) {
      //System.out.println(counter);
      sum += sumRow(counter++, m);
    }
    
    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOR loop
  public static int sumRow( int r, int[][] a ) {
    int sum = 0;
    for (int i = 0; i < a[r].length; i++) {
      sum += a[r][i];
    }

    return sum;
  }


  //postcond: returns sum of all items on row r of 2D int array a
  //          uses a FOREACH loop
  public static int sumRow2(int r, int[][] m) {
    int sum = 0;
    for (int columns : m[r] ) {
      sum += columns;
    }

    return sum;
  }


  public static void main( String [] args )
  {
      int [][] m1 = new int[4][2];
      int [][] m2 = { {2,4,6}, {3,5,7} };
      int [][] m3 = { {2}, {4,6}, {1,3,5} };

      print1(m1);
      print1(m2);
      print1(m3);
      print2(m1);
      print2(m2);
      print2(m3);

      System.out.print("testing sum1...\n");
      System.out.println("sum m1 : " + sum1(m1)); //prints out 0
      System.out.println("sum m2 : " + sum1(m2)); //prints out 27
      System.out.println("sum m3 : " + sum1(m3)); //prints out 21
    
      System.out.print("testing sum2...\n");
      System.out.println("sum m1 : " + sum2(m1));
      System.out.println("sum m2 : " + sum2(m2));
      System.out.println("sum m3 : " + sum2(m3));

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class TwoDimArray