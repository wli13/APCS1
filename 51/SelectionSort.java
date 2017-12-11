//Wenting Li
//APCS1 pd08 
//HW51 -- Selection
//2017-12-12

//FINISHED
//=====================================

/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/

import java.util.ArrayList;

public class SelectionSort 
{
  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond: lo < hi && size > 0
  //postcond: returns an ArrayList of random integers
  //          from lo to hi, inclusive
  public static ArrayList populate( int size, int lo, int hi ) {
    ArrayList<Integer> retAL = new ArrayList<Integer>();
    while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
    }
    return retAL;
  }

  //randomly rearrange elements of an ArrayList
  public static void shuffle( ArrayList al ) {
    int randomIndex;
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSortV( ArrayList<Comparable> data ) {
    int smallest; //holds the index of the smallest element

    //for data with size i, i-1 passes are required
    for(int i = 0; i < data.size() - 1; i++ ) {
      //System.out.println("pass: " + (i+1) );

      //sets index to index of last element of data before each pass
      smallest = data.size() - 1;

      //NOTE: (n > i) checks for swapping until the i-th element,
      //because after i passes, the first i elements are in the correct place
      for (int n = data.size() - 1; n > i ; n-- ) {

        //compares element at smallest (starting from last element) to each element in the list
        //and sets smallest to index of smaller element of each comparison
        if (data.get(smallest).compareTo(data.get(n-1)) > 0)
          smallest = n - 1;     
      }

      //swaps element
      data.set( i , data.set( smallest , data.get(i)) );
    }
  }//end selectionSortV

  /* Alternatively (pass from left to right):
  public static void selectionSortV( ArrayList<Comparable> data ) {
    int smallest;
    for(int i = 0; i < data.size() - 1; i++){
      smallest = i;
      for(int n = i; n < data.size(); n++){
        if(data.get(smallest).compareTo(data.get(n)) > 0){
          smallest = n;
        }
      }
      data.set(i,data.set(smallest,data.get(i)));
    }      
  }//end selectionSortV */

  // ArrayList-returning selectionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) 
  {
    //NOTE: this creates a NEW ArrayList
    //instead of just creating an alias, where input would still be modified
    ArrayList foo = new ArrayList<Comparable>();
    for (Comparable n : input) {
      foo.add(n); //for every element n in input, add it to ArrayList foo
    }
    selectionSortV(foo);
    return foo;
  }//end selectionSort 


  public static void main( String [] args ) 
  {
    /*===============for VOID methods=============    
    ArrayList glen = new ArrayList<Integer>();
    glen.add(7);
    glen.add(1);
    glen.add(5);
    glen.add(12);
    glen.add(3);
    System.out.println( "ArrayList glen before sorting:\n" + glen );
    selectionSortV(glen);
    System.out.println( "ArrayList glen after sorting:\n" + glen );


      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      selectionSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );

      ============================================*/

    /*==========for AL-returning methods==========      
    	ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = selectionSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = selectionSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );

      ============================================*/

  }//end main

}//end class SelectionSort
