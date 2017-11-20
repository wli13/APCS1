//Wenting Li
//APCS1 pd08
//HW22 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
//2017-10-25

//MY CODE FOR PIG

/* **
* class Pig
* a Pig Latin translator
* ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
*           9
*     ,--.-'-,--.
*     \  /-~-\  /
*    / )' a
*a `(						\
*   ( (  ,---.  ) )
*    \ `(_o_o_)' /
*     \   `-'   /
*      | |---| |
*      [_]   [_]
*      PROTIP: Make this class compilable first,
*      then develop and test one method at a time.
*      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
** */

/*** Polish your Pig Latin translator to accommodate each aspect below.
 Incorporate Scanner functionality to allow your translator to read and process a plaintext file containing one word per line.
**GENERAL RULES:
1. Move leading consonant to end of word, append ay
2. If word begins with a vowel, append way
**EXTRA RULES:
3. Consider y a vowel when appropriate.
                ( yellow = ellowyay,  tryst = ysttray )
4. Handle multiple consonants at beginning of word ( stew, thrice, etc. )
5. Capitalization ( Pig = Igpay )
6. Punctuation ( Pig is king. = Igpay isway ingkay. )
***/

public class Pig {
    
    //Q: How does this initialization make your life easier?
    private static final String VOWELS = "aeiouAEIOU";
    //A: provides a String containing all vowels to which we can refer to

    private static final String PUNCT = ".,!?;";

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) {
	return w.indexOf(letter) >= 0;
	
    }//end of hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) {
        return VOWELS.indexOf(letter) >= 0;
	
    }//end of isAVowel()


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) {
	int count = 0;
	for (int i = 0; i < w.length(); i++) {
	    if ( isAVowel(w.substring(i,i+1)) )
		{count += 1;};
	}
	return count;
	
    }//end of countVowels()

    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) {
	return countVowels(w) > 0;
	
    }//end of hasAVowels()
    

    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) {
	String str = "";
	for (int i = 0; i < w.length() ; i++) {
	    if ( isAVowel(w.substring(i,i+1)) )
		{str += w.substring(i,i+1); }
	}
	return str;
	
    }//end of allVowels
    
//PART TWO CODING FOR PIGLATIN---------------------------------------

    /*=====================================
      String firstVowel(String) -- returns first vowel in a String
      pre: w != null
      post: firstVowel("") --> ""
            firstVowel("zzz") --> ""
            firstVowel("meatball") --> "e"
      =====================================*/
    public static String firstVowel(String w) {
	String str = "";
	if (countVowels(w) > 0)
	    { str += allVowels(w).substring(0,1); }
	return str;
	
    }//end of firstVowel()
    
    /*=====================================
      String beginsWithVowel(String) -- returns whether a String begins with a Vowel
      pre: w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =====================================*/
    public static boolean beginsWithVowel(String w) {
	return isAVowel(w.substring(0,1));
    }

    /*=====================================
      String engToPig(String) -- returns the English to PigLatin translation for a singular word   
      pre: w.length() > 0
      post: engToPig("apple")  --> "appleway"
            engToPig("strong") --> "ongstray"
            engToPig("java")   --> "avajay"
      =====================================*/
    public static String engToPig(String w) {
	String str = "";

	//if no vowels are present
	/*	if (countVowels(w) = 0) {
	    if (hasA(w,"y"))
		{str = w.substring(w.indexOf("y"))
			+ w.substring(0,w.indexOf("y"))
			+ "ay";
		}
	    else {str = w + "ay";}
	    }*/

	//if the word starts off with a vowel, add "way" to the end
	if (beginsWithVowel(w))
	    {str = w + "way";}

	//if the work starts off with consonant// (s), move them to back and add "ay" 
	else
	     { str = w.substring(w.indexOf(firstVowel(w)))
	 	    + w.substring(0,w.indexOf(firstVowel(w)))
	 	    + "ay";
	     }
	 return str;
    }


    public static void main( String[] args ) {

	//test cases for hasA(String,String)
	System.out.println("hasA() test cases:");	
	System.out.println("cat, a --> " + hasA("cat","a"));
	System.out.println("cat, p --> " + hasA("cat","p"));
	System.out.println("Cat, C --> " + hasA("Cat","C"));
	System.out.println("c, c --> " + hasA("c","c"));
	System.out.println(" , c --> " + hasA("","c"));
	System.out.println();

	//test cases for isAVowel(String)
	System.out.println("isAVowel() test cases:");
	System.out.println("p --> " + isAVowel("p"));	
	System.out.println("a --> " + isAVowel("a"));
	System.out.println("A --> " + isAVowel("A"));
	System.out.println();	

	//test cases for countVowels(String)
	System.out.println("countVowels() test cases:");
	System.out.println("cat --> " + countVowels("cat"));
	System.out.println("meatball --> " + countVowels("meatball"));
	System.out.println("Ask --> " + countVowels("Ask"));
	System.out.println("try --> " + countVowels("try"));
	System.out.println();	

	//test cases for hasAVowel(String)
	System.out.println("hasAVowel() test cases:");
	System.out.println("cat --> " + hasAVowel("cat"));
	System.out.println("try --> " + hasAVowel("try"));
	System.out.println("Ask --> " + hasAVowel("Ask"));
	System.out.println();	

	//test cases for allVowels(String)
	System.out.println("allVowels() test cases:");
	System.out.println("cat --> " + allVowels("cat"));
	System.out.println("meatball --> " + allVowels("meatball"));
	System.out.println("Ask --> " + allVowels("Ask"));
	System.out.println("try --> " + allVowels("try"));
	System.out.println();

	//test cases for firstVowel(String)
	System.out.println("firstVowel() test cases:");
	System.out.println("cat --> " + firstVowel("cat"));
	System.out.println("meatball --> " + firstVowel("meatball"));
	System.out.println("Ask --> " + firstVowel("Ask"));
	System.out.println("try --> " + firstVowel("try"));
	System.out.println();

	//test cases for beginsWithVowel(String)
	System.out.println("beginsWithVowel() test cases:");
	System.out.println("cat --> " + beginsWithVowel("cat"));
	System.out.println("apple --> " + beginsWithVowel("apple"));
	System.out.println("Ask --> " + beginsWithVowel("Ask"));
	System.out.println();

	//test cases for engToPig(String)
	System.out.println("apple --> " + engToPig("apple"));
	System.out.println("strong --> " + engToPig("strong"));
	System.out.println("java --> " + engToPig("java"));
	

    }//end main()

}//end class Pig

    
