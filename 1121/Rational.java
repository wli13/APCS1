//Wenting Li
//APCS1 pd08
//HW37 -- Be More Rational
//2017-11-21

//FINISHED
//=====================================

/* Phase II:
 * Add a static gcd method with two int parameters.
 *  add:
 *  - Takes 1 Rational object (just like multiply) and adds it to the current rational number object
 *  - Need not reduce
 *  subtract:
 *  - Works the same as add, except the operation is subtraction
 *  gcd:
 *  - Returns the gcd of the numerator and denominator of this Rational
 *  reduce:
 *  - Changes this Rational to one in reduced form (should use gcd)
 *  compareTo:
 *  - Takes a Rational parameter and compares it to the calling object
 *  - Returns 0 if the two numbers are equal
 *  - Returns a positive integer if the calling number is larger than the parameter
 *  - Returns a negative integer if the calling number is smaller than the parameter
 * ===================================== */

public class Rational {
    //represents a rational number
    //A rational number may be expressed as p/q, where p & q are both ints and q!= 0

    //instance variables
    private int p; //denoting the numerator
    private int q; //denoting the denominator

    /*=====================================
      Rational() -- default constructor
      pre:  Integer variables p and q exist
      post: creates a new Rational with the value of 0/1
      =====================================*/
    public Rational() {
	p = 0;
	q = 1;
    }
    
    /*=====================================
      Rational(int, int) overloaded constructor
      pre:  a and b are integers
      post: creates a new Rational with the value of a/b
      if b = 0, displays error message and sets the value to 0/1
      =====================================*/
    public Rational(int a, int b){
	this();
	if (b != 0){
	    p = a;
	    q = b;
	}
	else {
	    System.out.println("Invalid denominator attempted. Number set to 0/1.");
	}
    }

    /*=====================================
      String toString() -- overrides inherited toString()
      pre:  
      post: returns String of p/q
      =====================================*/
    public String toString() {
	String str = "";
	str += p;
	str += "/";
	str += q;

	return str;
    }

    /*=====================================
      double floatValue() 
      pre: p and q exist and are initialized 
      post: returns (most precise) float point approximation of the number p/q
      =====================================*/
    public double floatValue() {
	return (double) p / q;
    }
	
    /*=====================================
      void multiply(Rational)
      pre:  Rational b exists
      post: multiplies this rational by b and sets this rational to the product
      need not reduce the fraction
      =====================================*/
    public void multiply(Rational b) {
	p *= b.p;
	q *= b.q;
	reduce();
    }

    /*=====================================
      void divide(Rational)
      pre:  Rational b exists
      post: divides this rational by b and sets this rational to the quotient
      need not reduce the fraction
      ** a/b / 
      =====================================*/
    public void divide(Rational b) {
	if (b.p != 0){
	    p *= b.q;
	    q *= b.p;
	}
	else {
	    System.out.println("Error. Division by 0.");
	}
	reduce();
    }

    //===============================================
    //Phase II of development:

    /*=====================================
      void add(Rational) 
      pre:  Rational b exists
      post: adds b to this rational and sets this rational to the sum
      need not reduce the fraction
      =====================================*/
    public void add(Rational b) {
    	p = p * b.q + b.p * q;
    	q *= b.q;
	reduce();
    }

    /*=====================================
      void subtract(Rational) 
      pre:  Rational b exists
      post: subtracts this rational from b and sets this rational to the sum
      need not reduce the fraction
      =====================================*/
    public void subtract(Rational b) {
    	p = p * b.q - b.p * q;
    	q *= b.q;
	reduce();
    }

    /*=====================================
      int gcd(int,int) **HELPER FUNCTION from hw19 11/19
      pre:  int a and b exists
      post: returns the greatest common denominator of a and b, recursively
      =====================================*/
    public static int gcd(int a,int b) {
	//rearranges numbers to (larger,smaller)
	if (b > a) {
	    return gcd(b, a); }
	
	if (a % b == 0) { 
	    return b; } //returns smaller number
	return gcd(a % b, b);//recursion on (remainder,smaller)	    
    }

    /*=====================================
      int gcd()
      pre:  
      post: returns the gcd of the numerator and denominator of this Rational
      =====================================*/
    public int gcd() {
      	return gcd(p,q);
    }

    /*=====================================
      void reduce()
      pre:  
      post: changes this Rational to one in reduced form
      =====================================*/
    public void reduce() {
      	int gcd = gcd();
      	p /= gcd;
      	q /= gcd; 
    }

    /*=====================================
      int compareTo(Rational)
      pre:  rational b exists
      post: returns 0 if this rational and b are equal
      returns 1 if this rational is greater than b
      returns -1 if this rational is less than b 
      =====================================*/
    public int compareTo(Rational b) {
      	if (p * b.q == q * b.p)
	    { return 0; }
      	if (p * b.q > q * b.p)
	    { return 1; }
      	else 
	    { return -1; }
    }      


	//test cases!
	public static void main(String[] args) {

	Rational r = new Rational(2,3); //Stores rational number 2/3
	Rational s = new Rational(1,2); //Stores rational number 1/2
	Rational t = new Rational(4,18); //Stores the rational number 4/18
	System.out.println(r); //prints out 2/3
	System.out.println(s); //prints out 1/2
	System.out.println(t); //prints out 4/18

	r.multiply(s); //Multiplies r by s, changes r to 1/3. s remains 1/2	
	System.out.print("2/3 * 1/2 = ");
	System.out.println(r); //prints out 1/3

	r.divide(s); //Divides new r by s, changes r to 2/3. s remains 1/2
	System.out.print("1/3 / 1/2 = ");
	System.out.println(r); //prints out 2/3
	
	r.add(s);  //Adds s to new r, Changes r to 7/6. s remains 1/2
	System.out.print("2/3 + 1/2 = ");
	System.out.println(r); //prints out 7/6

	r.subtract(s);  //Subtracts s from new r, Changes r to 2/3. s remains 1/2
	System.out.print("14/12 - 1/2 = ");
	System.out.println(r); //prints out 2/3

	t.reduce(); //Changes t to 2/9
	System.out.print("4/18 --> ");
	System.out.println(t); //prints 2/9
	
	//compareTo() test cases
	System.out.println();
	Rational u = new Rational (3,4);
	System.out.println(r.compareTo(r)); //prints 0
	System.out.println(r.compareTo(s)); //prints 1
	System.out.println(r.compareTo(u)); //prints -1

	}

}//end of class Rational
