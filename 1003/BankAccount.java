public class BankAccount {

    String accName;
    String password;
    int pin;
    int accNum;
    double accBal;

    public BankAccount(){
	String accName = "no name input";
	String password = "no password input";
	int pin = 0000;
	int accNum = 000000000;
	double accBal = 0.0 ;
    }
	
    public void setAccInfo(String name, String pass, int newpin, int newAccNum ) {
	accName = name;
	password = pass;
	pin = newpin;
	accNum = newAccNum;
	System.out.println("Set Account Information successfully.");
    }
    
    public void printInfo() {
        
 	System.out.println("Account Name: " + accName);
        System.out.println("Account Password: " + password);
	System.out.println("PIN: " + pin);
	System.out.println("Account#: " + accNum);
	System.out.println("Account Balance: $" + accBal);
	System.out.println(" ");
    } 

    public void deposit(double cashIn){
	double newBal;

        newBal = (accBal + cashIn);
	accBal = newBal;
	System.out.println("Deposited $"
			   + cashIn
			   +". Current Balance: $"
			   + accBal);
    }

    public void withdraw(double cashOut){
	double newBal;

	newBal = (accBal - cashOut);
	accBal = newBal;
	System.out.println("Withdrew $"
			   + cashOut
			   +". Current Balance: $"
			   + accBal);
    }

    public static void main(String[] args){
	
	BankAccount grace = new BankAccount();
	grace.setAccInfo("Grace","12345",2000,100000001);
	
        grace.printInfo();
	
	grace.deposit(20);
	grace.withdraw(10);
    }
}

