// Wenting Li
// APCS1 pd8
// HW#16 -- Get it While You Can
// 2017-10-16

public class Driver {
    
    public static void main( String[] args ) {

	Coin wenting = new Coin("dime");
	Coin friend = new Coin("nickel");

	//=================================================================

	int target = 50;
	int head = wenting.getheadsCtr() + friend.getheadsCtr();
	while (target >= head){
	    wenting.flip();
	    friend.flip();
	    if (wenting.getupFace() == "heads")
		head += 1;
	    if (friend.getupFace() == "heads")
		head += 1;
	}
	System.out.println("It took me " + (wenting.getflipCtr()) + " flips to get to " + target + " head counts");

	//===================================================================

	target = 25;
	int match = 0;
	int flip = 0;
cdx	while (target >= match) {
	    wenting.flip();
	    flip += 1;
	    friend.flip();
	    flip += 1;

	    
	    if (wenting.equals(friend))
		match += 1; 
}
	System.out.println();
	System.out.println("It took me " + flip + " flips to get to " + target + " matches");

	//===================================================================

	int matches = 0;
	int flips = 0;
	while (matches <= 14000){
	    // the next integer greather than 13000 divisible by year 2000 is 14000
	    wenting.flip();
	    flips += 1;
	    friend.flip();
	    flips += 1;
	    if (wenting.equals(friend))
		matches += 1;
	}

	System.out.println();
	System.out.println("It took me " + flips + " flips to get to " + 13000 + " matches and the number of matches is divisible by 2000");

    }//end main

}//end class
