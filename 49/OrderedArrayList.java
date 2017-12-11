//Wenting Li
//APCS1 pd08    //inspired by Woosuk Lee pd08
//HW49 -- Halving the halves
//2017-12-08 

//
//=====================================

/********************************
 * class OrderedArrayList v2.0
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order

 * a binary search to locate the point of insertion for a new element
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
  // instance of class ArrayList, holding objects of type Comparable 
  // (ie, instances of a class that implements interface Comparable)
  private ArrayList<Comparable> _data;


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


  public void addBin( Comparable newVal )
  {      
    int index = _data.size() / 2; //sets index to the middle value
    int upper = _data.size(); //holds the value of the upper bound limit
    //while(true) format runs until the code hits a "break"   
    while(true){
      //if newVal fits right between or is equal to index and index-1,
      //add the new Value at index and break
       if((newVal.compareTo(_data.get(index-1)) >= 0 ) && 
          (newVal.compareTo(_data.get(index)) <= 0 )) 
        {
           _data.add(index,newVal);
           break;
        }
      //if value is greater than middle value,
      //set index to middle value of the second half
       else if(newVal.compareTo(_data.get(index)) > 0 ) 
       {
         index = (index + upper)/2;
       }
      //if value is less than middle value,
      //set upper limit to the index & index to middle value of the first half
       else
        {
         upper = index; 
         index = index / 2;
        }
      }
    }



  // main method solely for testing purposes
  public static void main( String[] args )
  {
    OrderedArrayList Franz = new OrderedArrayList();

    //Franz.add(0);
    //Franz.add(1);

    // testing linear search
    for( int i = 0; i < 15; i++ )
      Franz.add( (int)( 50 * Math.random() ) );
    System.out.println( Franz );

    //check for sorted-ness
    //if msg does not appear, list was sorted
    int foo = Franz.size() - 1;    
    for( int i=0; i<foo; i++ ) {
      System.out.println("at index "+  i + ": " + Franz.get(i) );
      if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
        System.out.println( " *** NOT sorted *** " );
        break;
      }
    }
    //printing last element without comparing
    System.out.println("at index "+ foo + ": " + Franz.get(foo ));

    Franz.addBin(24);    
    System.out.println( Franz );    /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class OrderedArrayList
