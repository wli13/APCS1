//Wenting Li
//APCS1 pd08 
//HW54 -- One File to Bring Them All...
//2017-12-14

//FINISHED
//=====================================

/***************************************
 *  class MySorts -- implements BubbleSort, SelectionSort, InsertionSort
 ***************************************/

import java.util.ArrayList;

public class MySorts {

  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSort( ArrayList<Comparable> data )
  {
    //make n-1 passes across collection
    for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );

	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
        //if element at i > element at i+1, swap
        if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) {
          data.set( i, data.set(i+1,data.get(i)) );	
        }
        //System.out.println(data); //diag: show current state of list
	    }
    }
  }


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSort( ArrayList<Comparable> data ) 
  {
    //note: this version places greatest value at rightmost end,

    //maxPos will point to position of SELECTION (greatest value)
    int maxPos;

    for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
        System.out.println( "maxPos: " + maxPos );//diag
        System.out.println( data );//diag
        if ( data.get(i).compareTo( data.get(maxPos) ) > 0 )
          maxPos = i;
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    System.out.println( "after swap: " +  data );//diag
    }
  }//end selectionSortV


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSort( ArrayList<Comparable> data )
  {
    for( int partition = 1; partition < data.size(); partition++ ) {
	    //partition marks first item in unsorted region

	    //diag:
	    System.out.println( "\npartition: " + partition + "\tdataset:");
	    System.out.println( data ); 

	    //traverse sorted region from right to left
	    for( int i = partition; i > 0; i-- ) {

        // "walk" the current item to where it belongs
        // by swapping adjacent items
        if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
          //diag:
          System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
          data.set( i, data.set( i-1, data.get(i) ) ); 
        }
        else 
          break; 
	    }
    }
  }//end insertionSortV  
  
}//end of class MySorts