// Wenting Li
// APCS1 pd08
// HW17 -- Do I Repeat Myself?
// 2017-10-17

public class Repeater{
    // variable posts used in method fenceR()
    public static String posts = "|";

    // fenceW() takes non-negative integer posts, and returns a String representation of a fence with the specified number of posts
    // employs a while loop    
    public static String fenceW(int numPosts){
	int num = numPosts - 1;
	String post = "|";
	while (num != 0){
	    post += "--|";
	    num -= 1;
	}
	return post;
    }

    
    // fenceR() takes non-negative integer posts, and returns a String representation of a fence with the specified number of posts
    // emplous recursion
    // NOTE THAT THIS METHOD MAKES USE OF A VARIABLE DEFINED OUTSIDE THE METHOD SO THE VARIABLE DOES NOT GET RESET EVERY LOOP
    
    public static String fenceR(int numPosts){
	if (numPosts != 1) {
	    posts += "--|";
	    return fenceR(numPosts - 1); }
	else { return posts; }
    }

    // ^NOTE possible other way for fenceR
    
      public static String fenceR2(int numPosts){
	  String fence = "";
	  if(numPosts <= 0) {
	      return fence;
	  }
	  if (numPosts == 1){
	      return fence += "|";
	  }
	  return "|--" + fence;
	  fenceR(numPosts - 1);
      }
     
    // testing each method in main method
    public static void main(String[] args){

	// tests for fenceW() -- while loop
	System.out.println(fenceW(1));
	System.out.println(fenceW(5));
	System.out.println("");

	// tests for fenceR() -- recursion
	System.out.println(fenceR(1));
	System.out.println(fenceR(5));
	System.out.println("");
	
	// tests for fenceR2() -- recursion
	System.out.println(fenceR2(1));
	System.out.println(fenceR2(5));
	
    }
}
