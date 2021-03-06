//Wenting Li
//APCS1 pd08
//HW36 -- Be Rational
//2017-11-20

//FINISHED
//=====================================

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
	}

    /*=====================================
      void divide(Rational)
      pre:  Rational b exists
      post: divides this rational by b and sets this rational to the quotient
            need not reduce the fraction
      =====================================*/
	public void divide(Rational b) {
	    if (b.p != 0){
		p *= b.q;
		q *= b.p;
	    }
	    else {
	    	System.out.println("Error. Division by 0.");
	    }
	}


	//test cases!
	public static void main(String[] args) {

	Rational r = new Rational(2,3); //Stores rational number 2/3
	Rational s = new Rational(1,2); //Stores rational number 1/2
	System.out.println(r); //prints out 2/3
	System.out.println(s); //prints out 1/2

	r.multiply(s); //Multiplies r by s, changes r to 2/6. s remains 1/2	
	System.out.print("Multiplying 2/3 by 1/2 = ");
	System.out.println(r); //prints out 2/6

	r.divide(s); //Divides new r by s, changes r to 4/6. s remains 1/2
	System.out.print("Dividing 2/6 by 1/2 = ");
	System.out.println(r); //prints out 4/6
	
	}
}//end of class Rational
