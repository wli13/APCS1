//Wenting Li
//APCS1 pd08    
//HW46 -- Al<B> Sorted!
//2017-12-05 

//FINISHED
//=====================================

/***************************
 **class ALTester
 * populate an ArrayList with 23 Integers
 * determine whether the list is sorted or not
 ***************************/

import java.util.ArrayList;

public class ALTester {

    public static void main(String[] args) {
        
        //ArrayList for Comparable?
        ArrayList<Comparable> pigeon = new ArrayList<Comparable>(23);
        System.out.println("Printing empty ArrayList pigeon...");

        //filling the array with randomly generated ints from 0 to 4
        for (int i = 0; i < 23 ; i++) {
            pigeon.add( (int) (Math.random() * 5));
        }

        System.out.println("Printing populated ArrayList pigeon...");
        System.out.println(pigeon);

        //returns if the array is sorted in ascending order from left to right
        System.out.print("ArrayList pigeon is sorted... ");
        boolean ret = true;
        //once ret is set as false/two items are not in ascending order,
        //the for loop is broken
        for (int i = 1; i < 23 && ret; i++) {
            ret = (pigeon.get(i)).compareTo(pigeon.get(i-1)) >= 0;
        }
        System.out.println(ret);

    }//end of main method

}