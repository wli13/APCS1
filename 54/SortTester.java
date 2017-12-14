//Wenting Li
//APCS1 pd08 
//HW53 -- Solid Comparative Analyis
//2017-12-14

//FINISHED
//=====================================

/***************************************
 *  class SortTester -- Driver for class MySorts
 *  Includes:
    - helper methods populate() and shuffle()
    - descriptions & comments for best/worse cases for each sort
 ***************************************/

import java.util.ArrayList;

public class SortTester {

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

  public static void main( String [] args )
  {
/*===============for BubbleSort=============    
    System.out.println("\n*** Testing BubbleSort method... *** ");
    //The best case is when the elements in a list of n elements are 
    //already in ascending order. After n-1 passes, 0 swaps are required
    //to sort the list.      
    ArrayList bestCase = new ArrayList<Integer>();
    bestCase.add(1);
    bestCase.add(2);
    bestCase.add(3);
    bestCase.add(4);
    bestCase.add(5);
    System.out.println( "\nArrayList bestCase before sorting:\n" + bestCase );
    MySorts.bubbleSort(bestCase);
    System.out.println( "\nArrayList bestCase after sorting:\n" + bestCase );
    
    //The worst case is when the elements in a list of n elements are 
    //in descending order. After n-1 passes, nC2 swaps are required
    //to sort the list. In this example, 10 swaps are necessary.
    ArrayList worstCase = new ArrayList<Integer>();
    worstCase.add(5);
    worstCase.add(4);
    worstCase.add(3);
    worstCase.add(2);
    worstCase.add(1);
    System.out.println( "\nArrayList worstCase before sorting:\n" + worstCase );
    MySorts.bubbleSort(worstCase);
    System.out.println( "\nArrayList worstCase after sorting:\n" + worstCase );

      ============================================*/

/*===============for SelectionSort=============
    System.out.println("\n*** Testing SelectionSort method... *** ");
    //Arguably, there is no best or worse case. Seletion Sort functions
    //such that for a list of n elements, there is always n-1 passes 
    //and a total of n-1 swaps (even if element has to swap with itself).

    //In the potential best case when the elements in a list of n 
    //elements are already in ascending order, after n-1 passes, 
    //n-1 swaps occurred. In this case, 4 passes and swaps occurred.
    ArrayList bestCase = new ArrayList<Integer>();
    bestCase.add(1);
    bestCase.add(2);
    bestCase.add(3);
    bestCase.add(4);
    bestCase.add(5);
    System.out.println( "\nArrayList bestCase before sorting:\n" + bestCase );
    MySorts.selectionSort(bestCase);
    System.out.println( "\nArrayList bestCase after sorting:\n" + bestCase );
    
    //In a potential worse case when the elements in a list of n 
    //elements cannot be sorted through one swap, after n-1 passes, 
    //n-1 swaps occurred. In this case, 4 passes and swaps occurred too.    
    ArrayList worstCase = new ArrayList<Integer>();
    worstCase.add(5);
    worstCase.add(3);
    worstCase.add(4);
    worstCase.add(1);
    worstCase.add(2);
    System.out.println( "\nArrayList worstCase before sorting:\n" + worstCase );
    MySorts.selectionSort(worstCase);
    System.out.println( "\nArrayList worstCase after sorting:\n" + worstCase );

      ============================================*/      

/*===============for InsertionSort=============    
    System.out.println("\n*** Testing InsertionSort method... *** ");
    //NOTE: the best and worse cases are similar to that of BubbleSorts?

    //The best case is when the elements in a list of n elements are 
    //already in ascending order. After n-1 passes, 0 swaps are required
    //to sort the list.      
    ArrayList bestCase = new ArrayList<Integer>();
    bestCase.add(1);
    bestCase.add(2);
    bestCase.add(3);
    bestCase.add(4);
    bestCase.add(5);
    System.out.println( "\nArrayList bestCase before sorting:\n" + bestCase );
    MySorts.insertionSort(bestCase);
    System.out.println( "\nArrayList bestCase after sorting:\n" + bestCase );
    
    //The worst case is when the elements in a list of n elements are 
    //in descending order. After n-1 passes, nC2 swaps are required
    //to sort the list. In this example, 10 swaps are necessary.
    ArrayList worstCase = new ArrayList<Integer>();
    worstCase.add(5);
    worstCase.add(4);
    worstCase.add(3);
    worstCase.add(2);
    worstCase.add(1);
    System.out.println( "\nArrayList worstCase before sorting:\n" + worstCase );
    MySorts.insertionSort(worstCase);
    System.out.println( "\nArrayList worstCase after sorting:\n" + worstCase );

      ============================================*/
  }//end of main

}//end of class SortTester