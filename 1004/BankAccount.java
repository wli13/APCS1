public class BankAccount {

    private String accName;
    private String password;
    private int pin;
    private int accNum;
    private double bal;

    public BankAccount(){
	String accName = "no name input";
	String password = "no password input";
	int pin = 0000;
	int accNum = 000000000;
	double bal = 0.0 ;
    }
	
    public String setAccName(String newName) {
	String oldName = accName;
	accName = newName;
	System.out.println("Set Account Name successfully.");
	
	return oldName;
    }

    public String setPass(String newPass) {
	String oldPass = password;
	password = newPass;
	System.out.println("Set new Password successfully.");
	
	return oldPass;
    }

    public int setPin(int newPin) {

	if (newPin <= 9998 && newPin >= 1000) {
	    int oldPin = pin;
	    pin = newPin;
	    System.out.println("Set new PIN successfully.");
	    
	    return oldPin;
	    
	} else {
	    int oldPin = pin;
	    pin = 9999;
	    System.out.println("\n=========/Error/=========\nInvalid PIN. Entered PIN was not 4 digits or was greater than 9998 or less than 1000. Your PIN is set to 9999.\n=========================");
	    
	    return oldPin;
	}
    }
	
    public int setAccNum(int newNum) {

	if (newNum <= 999999998 && newNum >= 100000000) {
	    int oldNum = accNum;
	    accNum = newNum;
	    System.out.println("Set Account Number successfully.");

	    return oldNum;
	} else {
	    int oldNum = accNum;
	    accNum = 999999999;
	    System.out.println("\n=========/Error/=========\nInvalid Account#. Entered Account# was not 9 digits or was greater than 999999998 or less than 100000000. Your Account# is set to 999999999.\n=========================");

	    return oldNum;
	}
    }

    public double setBal(double curBal) {
	double iniBal = bal;
	bal = curBal;
	System.out.println("Balance set sucessfully.");

	return iniBal;

    }
    
    public void printInfo() {
	
	String infoStr = "\nAccount info:\n=======================";
	infoStr = infoStr + "\nName: " + accName;
	infoStr = infoStr + "\nPassword: " + password;
	infoStr = infoStr + "\nPIN: " + pin;
	infoStr = infoStr + "\nAccount Number: " + accNum;
	infoStr = infoStr + "\nBalance: $" + bal;
	infoStr = infoStr + "\n=======================\n";
	
	System.out.println(infoStr);
    }
 

    public void deposit(double cashIn){
	double newBal;

        newBal = (bal + cashIn);
	bal = newBal;
	System.out.println("Deposited $"
			   + cashIn
			   +". Current Balance: $"
			   + bal);
    }

    public double withdraw(double cashOut){

	if (cashOut <= bal) {
	    double newBal = (bal - cashOut);
	    bal = newBal;
	    System.out.println("Withdrew $"
			       + cashOut
			       +". Current Balance: $"
			       + bal);

	    return newBal;
	} else {
	    double newBal = bal;
	    System.out.println("\n=========/Error/=========\nWithdrawal unsuccessful. Insufficient funds in your Balance. \nCurrent Balance: $"
			       + bal
			       + "\n=========================");
	    
	    return newBal;
	}
    }

    public boolean auth( int inpurAccNum, String inputpass) {
	
	if (inputAccNum = accNum && inputpass == password) {
	    
	
    }
    
    public static void main(String[] args) {

	BankAccount kavin = new BankAccount();

	kavin.setAccName("Kavin Seo");
	kavin.setPass("princessk");
	
	kavin.setPin(99999);
	kavin.setPin(2000);
        
	kavin.setAccNum(999999);
	kavin.setAccNum(100000000);

	kavin.setBal(0);

	kavin.printInfo();

	kavin.deposit(30);
	kavin.withdraw(21);
	kavin.withdraw(50);
    }
}
