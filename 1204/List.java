/***************************
 * interface List (for HW45)
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of an ordered sequence or collection.
 ***************************/

public interface List
{

  // Appends the argument to the end. Return true.
  boolean add( Object num );

  // Insert an int at index
  //void add( int index, int num ) ; 

  // Retrieve the int at index
  Object get( int index );

  // Overwrite the element at index
  Object set( int index, Object num );

  // Return number of elements in the list
  int size() ;

  // Remove the int at index,
  // shifting any elements after it to the left.
  // Return removed value.
  //int remove( int index );

}//end interface ListInt
