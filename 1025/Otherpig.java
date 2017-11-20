//EDWIN"S CODE

/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Otherpig {

    //Q: How does this initialization make your life easier?
    private static final String VOWELS = "aeiou";
    //By listing a variable VOWELS that holds all the vowel we need in the code

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) {
        String retStr = "";
	for (int x = 0; x < w.length(); x += 1){
	    if (w.substring(x,x+1).equals(letter)){
		retStr = "t";
	    }
	}
	return retStr == "t";
    }//end hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter )  {
        String retStr = "";
	int index = 0;
	while (index < VOWELS.length()){
	    if (letter.equals(VOWELS.substring(index,index+1))){
		retStr = "t";
	    }
	    index += 1;
	}
	return retStr == "t";
    }//isAVowel()


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) {
	int vowelCount = 0;
	for (int x = 0; x < w.length(); x += 1){
	    if (isAVowel(w.substring(x,x+1))){
		vowelCount += 1;
	    }
	}
	return vowelCount;
    }//countVowels()


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	return countVowels(w) > 0;
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) {
        String retStr = "";
	for (int x = 0; x < w.length(); x += 1){
	    if (isAVowel(w.substring(x,x+1))){
		retStr += w.substring(x,x+1);
	    }
	}
	return retStr;
    }

    public static void sop(String x) {
	System.out.println(x);
    }
    
    public static void main( String[] args ) 
    {
	sop("Testing hasA()------------");
	sop("" + hasA("apple", "a") );
	sop("" + hasA("apple", "p") );
	sop("" + hasA("apple", "c") );
	sop("");

	sop("Testing isAVowel()------------");
	sop("" + isAVowel("a") );
	sop("" + isAVowel("b") );
	sop("" + isAVowel("oe") );
	sop("");
	
        sop("Testing countVowels()------------");
	sop("" + countVowels("") );
	sop("" + countVowels("ap") );
	sop("" + countVowels("apple") );
	sop("" + countVowels("ppl") );
	sop("");

	sop("Testing hasAVowel()------------");
	sop("" + hasAVowel("") );
	sop("" + hasAVowel("cat") );
	sop("" + hasAVowel("ccdr") );
	sop("" + hasAVowel("cada") );
	sop("");

	sop("Testing allVowels()------------");
	sop("" + allVowels("") );
	sop("" + allVowels("bb") );
	sop("" + allVowels("bo") );
	sop("" + allVowels("bobonos") );


    }//end main()

}//end class Pig


