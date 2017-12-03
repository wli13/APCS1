//Wenting Li
//APCS1 pd08    //collaboration with Woosuk Lee pd01
//HW45 -- In America, the Driver Sits on the Left
//2017-12-04 

//
//=====================================

/***************************
 ** class SuperArray version 4.0
  Wrapper class for growable arrays that store Objects that features:
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the
 * List interface. (List.java must be in same dir as this file)

 ** from version 3.0, modified:
 * add(Object)
 * add(int, Object)
 * size()
 * get(int)
 * set(int, Object)
 * remove(int)
 ***************************/

public class SuperArray implements List
{
  private Object[] _data;  //underlying container
  private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
  public SuperArray()
  {
    _data = new Object[1];
    _size = 0;
  }


  //output SuperArray in [a,b,c] format
  public String toString()
  {
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }


  //double capacity of SuperArray
  private void expand()
  {
    Object[] temp = new Object[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }


  //accessor -- return value at specified index
  public Object get( int index )
  {
    exceptionThrowing(index);

    return _data[index];
  }


  //mutator -- set value at index to newVal,
  //           return old value at index
  public Object set( int index, Object o )
  {
    exceptionThrowing(index);

    Object temp = _data[index];
    _data[index] = o;
    return temp;
  }


  //adds an item after the last item
  public boolean add( Object o )
  { 
    add( _size, o );
    return true;
  }


  //inserts an item at index
  public void add( int index, Object o )
  {
    if (_size != 0)
      exceptionThrowing(index);

    //first expand if necessary
    if ( _size >= _data.length )
      expand();

    for( int i = _size; i > index; i-- ) {
      _data[i] = _data[i-1]; //each slot gets value of left neighbor
    }
    _data[index] = o;
    _size++;
  }


  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  //returns removed value
  public Object remove( int index )
  {
    exceptionThrowing(index);

    Object ret = _data[index];
    for( int i = index; i < _size - 1; i++ ) {
      _data[i] = _data[i+1];
    }
    _size--;
    return ret;
  }


  //return number of meaningful items in _data
  public int size()
  {
    return _size;
  }

  //helper function for Exception throwing
  private void exceptionThrowing(int index) 
  {
    if (index < 0 || index >= size()) 
      throw new IndexOutOfBoundsException ("Reflection is required"); 
  }


  //main method for testing
  public static void main( String[] args )
  {
        /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
    List mayfield = new SuperArray();
    System.out.println("Printing empty SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.add(5);
    mayfield.add(4);
    mayfield.add(3);
    mayfield.add(2);
    mayfield.add(1);

    System.out.println("Printing populated SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.remove(3);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);
    mayfield.remove(3);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);

    mayfield.add(3,99);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(2,88);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(1,77);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);

      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
