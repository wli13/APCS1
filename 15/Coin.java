// Wenting Li
// APCS1 pd08
// HW15 -- Wayne's World (Coin!)
// 2017-10-12

public class Coin{
    private double value, bias;
    private String upFace, name;
    private int flipCtr, headsCtr, tailsCtr;

    public Coin(){
	// default constructor setting intial values

	upFace = "heads";
	bias = 0.5;
    }

    public Coin(String denom){
	//takes String input to indicate denomination

	this();
	name = denom;
    }

    public Coin(String denom, String face){
	//takes String input to indicate denomination
	//takes String input to indicate current face

	this(denom);
	upFace = face;
    }

    public String flip(){
	//simulates a coin flip
	//Returns a String (heads or tails) with probability of getting heads determined by bias
	//Math.random() returns a double consisting of [0.0, 1.0)

	double ranDbl = Math.random();
	
	if (ranDbl < bias){
	    upFace = "heads";
	    return "heads";
	} else {
	    upFace = "tails";
	    return "tails";
	}
    }
    
     public String toString(){
	//returns a coin's denomincation and current face

	String retStr = name;
	retStr += " -- ";
	retStr += upFace;
	return retStr;
    }
    
    public boolean equals(Coin other){
	//compares this Coin to another
	//returns true if they show the same face
	//returns false if they are NOT the same face

	//THINGS to note: The use of Coin as the parameter type 
	
	return upFace == other.upFace;
    }

    public void assignValue(){
	//assigns a Coin's monetary value to its name

	if (name == "penny") value = 0.01;
	if (name == "nickel") value = 0.05;
	if (name == "dime") value = 0.10;
	if (name == "quarter") value = 0.25;
	if (name == "dollar") value = 1.0;
    }
    
    public static void main(String[] args){
	    
    }
    
}//end of Coin class
    
	
