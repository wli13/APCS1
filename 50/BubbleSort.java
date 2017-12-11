//Wenting Li
//APCS1 pd08 
//HW50 -- Dat Bubbly Tho
//2017-12-11

//FINISHED
//=====================================

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 ******************************/

import java.util.ArrayList;

public class BubbleSort {

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
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    boolean _switch; //checks if any swaps were required in a pass

    //for data with size n, n-1 passes are required
    for(int i = 0; i < data.size() - 1; i++ ) { 
      //System.out.println("pass "+ (i+1));

      _switch = true; //resets _switch to true at the beginning of each pass
      
      //NOTE: (n > i) checks for swapping until the i-th element,
      //because after i passes, the first i elements are in the correct place
      for (int n = data.size() - 1; n > i ; n--) {
        if (data.get(n).compareTo(data.get(n-1)) < 0) {
          data.set( n-1 , data.set(n,data.get(n-1)) );
          _switch = false; //set _switch to false if any swapping occurs
        }
      }
      
      //if _switch remains true after one entire pass,
      //no swapping has occured, data is sorted and no more passes are necessary
      if (_switch) {
        break;
      }
    }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    //NOTE: this creates a NEW ArrayList
    //instead of just creating an alias, where input would still be modified
    ArrayList foo = new ArrayList<Comparable>();
    for (Comparable n : input) {
      foo.add(n); //for every element n in input, add it to ArrayList foo
    }
    bubbleSortV(foo);
    return foo;
  }


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
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
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
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );

      ============================================*/

  }//end main

}//end class BubbleSort
