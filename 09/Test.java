public class Test {

    public static void main(String[] args){

	BankAccount kavin = new BankAccount();
	kavin.setAccInfo("Kavin Seo","kavinseo01",1000,100000000);
        kavin.printInfo();
        kavin.deposit(30);
	kavin.withdraw(21);
    }
}
	
	
