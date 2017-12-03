//Wenting Li
//APCS1 pd08    
//HW41 -- Array of Steel
//2017-11-28

//FINISHED
//=====================================

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray {

    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


  //default constructor – initializes 10-item array
    public SuperArray() {
      _size = 10;
      _data = new int[_size];
  }


  //output SuperArray in [a,b,c] format
    public String toString() {
      String str = "[";
      for (int i = 0; i < _data.length - 1; i++) {
        str += "" + _data[i] + ",";
      }
      str += _data[_data.length - 1] + "]";

      return str;
    }


  //double capacity of SuperArray
    private void expand() {
      int[] _newData = new int[_data.length * 2];

      //copies the elements in _data to new array
      for (int i = 0; i < _data.length; i++) {
        _newData[i] = _data[i];
      }

      //sets _data to newly-made array that contains its original elements
      _data = _newData;
    }


  //accessor -- return value at specified index
    public int get( int index ) {
        return _data[index];
    } 


  //mutator -- set value at index to newVal,
  //           return old value at index
    public int set( int index, int newVal ) {
      int oldVal = _data[index]; 
      _data[index] = newVal;

      return oldVal;
  }

/*  //returns the length of this current array
    //requires variable _data to be static  
    public static int getLength() {
      return _data.length;
    }
*/

  //main method for testing
    public static void main( String[] args ) {

      SuperArray curtis = new SuperArray();
      System.out.println( "Printing empty SuperArray curtis..." );
      System.out.println( curtis );

      for( int i = 0; i < curtis._data.length; i++ ) {
        curtis.set( i, i * 2 );
      }

      System.out.println("Printing populated SuperArray curtis...");
      System.out.println(curtis);

      for( int i = 0; i < 3; i++ ) {
        curtis.expand();
        System.out.println("Printing expanded SuperArray curtis...");
        System.out.println(curtis);
        //System.out.println("Capacity: " + getLength());
      }
    /*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
  }//end main()


}//end class
