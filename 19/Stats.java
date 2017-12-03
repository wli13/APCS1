// Wenting Li
// APCS1 pd08
// HW19 -- gcd 3 ways
// 2017-10-19

public class Stats{

    //IntMean finds the sum of integers a and b and divides it by 2, returning an interger
    public static int mean(int a, int b){
	return (int) (a+b)/2;
    }

    //DoubleMean finds the sum of double a and b and divides it by 2, returning a double
    public static double mean(double a,double b){
	return (a+b)/2;
    }

    //IntMax returns the max of two integers a and b
    public static int max(int a,int b){
	int retNum;
        if (a >= b){
	    retNum = a;	}
	else {
	    retNum = b;
	}
	return retNum;
    }

    //DoubleMax returns the max of two doubles a and b
    public static double max(double a, double b){
	double retNum;
	if (a >= b){
	    retNum = a;	}
        else {
	    retNum = b;
	}
	return retNum;
    }

    //IntgeoMean returns the square root of the product of integers a and b
    public static int geoMean(int a,int b){
	return (int) Math.sqrt(a * b);
    }

    //DoublegeoMean returns the square root of the product of doubles a and b
    public static double geoMean(double a, double b){
	return Math.sqrt(a * b);
    }

    //This IntMax returns the max of three integers a, b, and c
    public static int max(int a, int b, int c){
        int retNum = max(max(a,b),c);
	return retNum;
    }
    
    //This DoubleMax returns the max of three doubles a, b, and c
    public static double max(double a,double b,double c){
        double retNum = max(max(a,b),c);
	return retNum;
    }

    //This IntgeoMean returns the cube root of the product of integers a, b, and c
    public static int geoMean(int a,int b,int c){
	return (int) Math.pow(a*b*c,(1.0/3));
    }

    //This DoublegeoMean returns the cube root of the product of doubles a, b, and c
    public static double geoMean(double a,double b,double c){
	return Math.pow(a*b*c,(1.0/3));
    }

    
    //--------------------------------------------------------------
    
    //Start of GCD methods

    //brute force approach,beginning at 1 and working up to lesser input
    public static int gcd(int a,int b) {
	int gcd = 1;
	int retNum = 1;
	while (gcd < a && gcd < b){
	    if (a % gcd == 0 && b % gcd == 0){
		retNum = gcd;
	    }
	    gcd += 1;
      	}
	return retNum;
    }

    //Euclid's algorithm recursively
    public static int gcdER(int a,int b){
	//rearranges numbers to (smaller,larger)
	if (b > a) {
	    return gcdER(b, a); }
	
	if (a % b == 0) { 
	    return b; } //returns smaller number
	return gcdER(a % b, b);//recursion on (remainder,smaller)	    
    }

    //Euclid's algorithm with a while loop
    public static int gcdEW(int a,int b){
	// rearranges numbers to (smaller,larger)
	if (a > b) {
	    return gcdEW(b, a); }
	
	while (b % a != 0){
	    int remainder = b % a; // to keep track of b % a
	    b = a;
	    a = remainder;
	}
	return a;
    }
    /* Euclid's Algorithm takes two positive integers, a and b, and return their greatest common factor. It states that if a is less than b, then exchange a and b so then the first number is the larger one. Then, you divide a by b, and if the remainder is 0, then b is the GCD. If the remainder is not 0, you repeat the steps but substitute b in for a and substitute the remainder in for b. */
    
    //MAIN METHOD
    public static void main(String[] args){
	System.out.println("testing gcd -- brute force!");
	System.out.println(gcd(15,20));
	System.out.println(gcd(100,99));
	System.out.println(gcd(20,15));
	System.out.println("testing gcd -- recursion!");
	System.out.println(gcdER(15,20));
	System.out.println(gcdER(100,99));
	System.out.println(gcdER(20,15));
	System.out.println("testing gcd -- while loop!");
	System.out.println(gcdEW(15,20));
	System.out.println(gcdEW(100,99));
	System.out.println(gcdEW(20,15));
	System.out.println();

	//System.out.println(3%15);

    }
}
