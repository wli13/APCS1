//Wenting Li
//APCS1 pd08
//HW21 -- Karmacomma
//2017-10-24
//___3hrs___

public class Commafier {

    //commafyR() takes a non-negative integer input and returns the number as a String with commas inserted appropriately using RECURSION
    
    public static String commafyR(int num){

	//numStr holds the String value of num
	//length holds the num of charaters in numStr
	String numStr = Integer.toString(num);
	int length = numStr.length();

	//takes care of all int with 3 digits or less
	if (length <= 3)
	    {return numStr;}

	//takes care of int with at least 4 digits
	//adds a "," in front of every 3 digits starting from the right
	//if what remains on the left is less than 3 digits, call base case
	else {
	    String front = numStr.substring(0,length - 3);
	    String back = numStr.substring(length - 3);
	 
	    return ( commafyR(Integer.parseInt(front)) )
		+ ","
		+ back;
	}
    }//end of commafyR

     //commafyF() takes a non-negative integer input and returns the number as a String with commas inserted appropriately using FOR LOOP

    // THERES AN ISSUE HERE AHAHAAHA
    public static String commafyF(int num){
	
	//numStr holds the String value of num
	//length holds the num of charaters in numStr
	String numStr = Integer.toString(num);
	int length = numStr.length();
	String retStr = "";
	
	//n holds the number of 3 digits starting from the right
	//for every n, a "," is added before every 3 digits from the right and numstr is reset to digits before the placed comma
	for ( int n = (length - 1)  / 3 ; n > 0 ; n -= 1) {
	    retStr = retStr + "," + numStr.substring(length - 3);
	    System.out.println(retStr);
	    numStr = numStr.substring(0,length - 3);
	    System.out.println(numStr);
	}

	//fixes the remaining digits to retStr after all commas are added
	retStr = numStr + retStr;	
	    
	return retStr;
    }
    
    
    public static void main(String[] args){
	/*
	System.out.println("Tests for commafyR() ");
        System.out.println(commafyR(1));
	System.out.println(commafyR(10));
	System.out.println(commafyR(101));
	System.out.println(commafyR(1000));
	System.out.println(commafyR(12345));
	System.out.println("");
	*/
	System.out.println("Tests for commafyF() ");
	//System.out.println(commafyF(12345));
	//System.out.println(commafyF(123456));
	System.out.println(commafyF(1234567));
	//System.out.println(commafyF(12345678));
	//System.out.println(commafyF(123456789));
	System.out.println("");
	
	//System.out.println(Integer.parseInt(1));
	
	System.out.println("Tests for FOREACH loop ");
	//FOREACH LOOP
	for(String x : args){
	    System.out.println( commafyF( Integer.parseInt(x) ) );
	}
    }
    
}// end of class Commafier




