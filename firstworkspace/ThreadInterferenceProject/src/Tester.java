class Account{
	private int balance;
	public Account() {
		balance = 10000;
	}
	public  synchronized void deposit(int amount) {
		
		synchronized(this) {
			System.out.println("Balance before deposit: "+balance);
			balance = balance+amount;
			System.out.println("Balance after Deposit: "+balance);
		}
		
		
	}
	public synchronized void withdraw(int amount) {
		synchronized(this) {
			System.out.println("Balance before withdraw: "+balance);
			balance = balance-amount;
			System.out.println("Balance afte withdraw: "+balance);
		}
		

	}
	
}
class AccountUser extends Thread{
	String name,tot;
	Account account;
	int amount;
	public AccountUser(String name,Account account,String tot,int amount) {
		this.name=name;
		this.account = account;
		this.tot=tot;
		this.amount=amount;
	}
	public void run() {
		if(tot.equals("deposit")) {
			account.deposit(amount);
		}else if(tot.equals("withdraw")) {
			account.withdraw(amount);
		}
	}
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Account account = new Account();
AccountUser user1 = new AccountUser("abc",account,"deposit",6000);
AccountUser user2 = new AccountUser("abd",account,"withdraw",2000);
user1.start();
user2.start();

	}

}
