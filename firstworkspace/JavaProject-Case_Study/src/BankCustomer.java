
public class BankCustomer {
	private int accountNumber;
    private String name;
    private double balance;
    public BankCustomer() {
    	accountNumber = 0;
    	name = "Abhishek";
    	balance = 10000;
    }
    public BankCustomer(int accountNumber,String name,double balance) {
    	this.accountNumber = accountNumber;
    	this.name = name;
    	this.balance = balance;
    }
    public int getAccountNumber() {
    	return accountNumber;
    }
    public String getName() {
    	return name;
    }
  
	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}
	public void display() {
    	System.out.println(accountNumber+" "+name+" "+balance);
    }

}
