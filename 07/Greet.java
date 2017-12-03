public class Greet {
    public static void main(String[] args) {
	String greeting;
	
	BigSib kavin = new BigSib("Hi");
	BigSib lilboi = new BigSib("You're okay");
	BigSib shanii = new BigSib();
	
	greeting = kavin.greet("Kavin");
	System.out.println(greeting);
	greeting = lilboi.greet("Lilboi");
	System.out.println(greeting);
	greeting = shanii.greet("Shanii");
	System.out.println(greeting);
	
    } //end main()
}//end Greet
