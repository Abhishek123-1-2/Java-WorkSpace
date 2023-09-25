class Account{
	private int balance;
	public void deposit(int amount){
		balance=balance+amount;
	}
	public void withdraw(int amount) throws Exception {
		if(amount>balance) {
			throw new Exception("Insufficient Balance...");
		}else if(amount>15000) {
			throw new Exception("Overlimit cannot withdraw more than 15000 in a transaction");
		}
		balance=balance-amount;
		System.out.println(balance);
	}
	public   Account(int b) {
		balance=b;
	}
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Account a1 = new Account(35000);
try {
	a1.withdraw(14000);
}catch(Exception e) {
	System.out.println(e);
	e.printStackTrace();
}
	}

}
