import java.util.Scanner;

class AccountHolder
{
	private int accno;
	private String name;
	private double balance;
	public AccountHolder(int accno,String name,double balance) {
		this.accno = accno;
		this.name = name;
		this.balance = balance;
	}
	public void deposit(double amount) {
		balance=balance+amount;
	}
	public void withdraw(double amount) {
		balance=balance-amount;
	}
	public void show() {
		System.out.println(accno+" "+name+" "+balance);
	}
	public int getAccno(){
		return accno;
	}
	public String getName() {
		return name;
}
	public double getBalance() {
		return balance;
	}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int choice = 0,cnt=0,accno;
AccountHolder []arr=new AccountHolder[10];
Scanner sc = new Scanner(System.in);
while(true) {
	System.out.println("1.Add a Record");
	System.out.println("2.Show all Records");
	System.out.println("3.Deposit");
	System.out.println("4.Withdraw");
	System.out.println("5.Exit");
	switch(choice) {
	case 1:
		System.out.println("Enter account number,new and balance");
		arr[cnt++]= new AccountHolder(sc.nextInt(),sc.next(),sc.nextDouble());
		break;
	case 2:
		for(int i=0;i<cnt;i++) { 
			arr[i].show();
		}
			break;
	case 3:
		System.out.println("Enter account number:");
		accno = sc.nextInt();
		for(int i=0;i<cnt;i++) {
			if(arr[i].getAccno()==accno) {
			System.out.println("Enter amount to be deposited:");
			arr[i].deposit(sc.nextInt());
			}
		}
		break;
	case 4:
		System.out.println("Enter account number:");
		accno = sc.nextInt();
		for(int i=0;i<cnt;i++) {
			if(arr[i].getAccno()==accno) {
				System.out.println("Enter amount to be withdrawn:");
				arr[i].withdraw(sc.nextInt());
			}
		}
		break;
	case 5:
		System.exit(0);
		
		}
}
	}
}
}

	


