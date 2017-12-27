//Wenting Li
//APCS1 pd08 
//HW55 -- Never Fear, Big Oh is Here!
//2017-12-15

//
//=====================================

/***************************************
 *  class MySorts -- implements BubbleSort, SelectionSort, InsertionSort

 ...V2 extends comments categorizing execution times in best and worse
    cases and its justification for each method of OrderedArrayList
 ***************************************/

import java.util.ArrayList;

public class MySorts {

  private ArrayList<Comparable> _data; //ins var for 

  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSort( ArrayList<Comparable> data )
  {
    //int swaps = 0;
    //make n-1 passes across collection
    for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );

	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
        //if element at i > element at i+1, swap
        if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) {
          data.set( i, data.set(i+1,data.get(i)) );	
          //swaps++;
        }
        //System.out.println(data); //diag: show current state of list
	    }
    }
    //System.out.println("total swaps: "+swaps);
  }


  // VOID version of SelectionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void selectionSort( ArrayList<Comparable> data ) 
  {
    //int swaps = 0;

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
      //swaps++;
    }
    //System.out.println("total swaps: "+swaps);    
  }//end selectionSortV


  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void insertionSort( ArrayList<Comparable> data )
  {
    //int swaps = 0;

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
          //swaps++;           
        }
        else 
          break; 
	    }
    }
    //System.out.println("total swaps: "+swaps);    
  }//end insertionSortV  
  
//--------------------------------------------------
//v2: methods from OrderedArrayList


  // default constructor initializes instance variable _data
  public OrderedArrayList()
  {
    _data = new ArrayList<Comparable>();    
  }


  public String toString()
  {
    return _data.toString(); 
  }


  public Comparable remove( int index )
  {	
    return _data.remove(index); 
  }


  public int size()
  { 
    return _data.size();
  }

    
  public Comparable get( int index )
  { 
    return _data.get(index); 
  }


  /***
   * add takes as input any comparable object 
   * (i.e., any object of a class implementing interface Comparable)
   * inserts newVal at the appropriate index
   * maintains ascending order of elements
   * uses a linear search to find appropriate index
   ***/
  public void add( Comparable newVal )
  { 
    for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
	    }
    }
    _data.add( newVal ); //newVal > every item in oal, so add to end 
  }


  /***
   * addBin takes as input any comparable object 
   * (i.e., any object of a class implementing interface Comparable)
   * inserts newVal at the appropriate index
   * maintains ascending order of elements
   * uses a binary search to find appropriate index
   ***/
  public void addBin( Comparable newVal ) { 
    //initialize upperbound, lowerbound and median
    int lo = 0;
    int med = 0;
    int hi = _data.size()-1;

    while ( lo <= hi ) { //running until target is found or bounds cross

	    med = (lo + hi) / 2;
	    int x = _data.get(med).compareTo( newVal );
	        
	    if ( x == 0 ) { //equal value found, insert here
        _data.add( med, newVal );
        return;
	    }
	    else if ( x > 0 ) //newVal < med, so look at lower half of data
        hi = med - 1;
	    else //newVal > med, so look at upper half of data
        lo = med + 1;
    }
    // If you make it this far, newVal was not in the ArrayList.
    // So insert at lo. Q: How do you know lo is correct insertion index?
    _data.add( lo, newVal );
  }	
  
}//end of class MySorts