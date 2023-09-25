import java.util.Scanner;

class Account {
	
	private int accNum;
	private String accName;
	private double accBalance;
	
	public Account(int accNum, String accName, double accBalance) {
		this.accNum = accNum;
		this.accName = accName;
		this.accBalance = accBalance;
	}
	
	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}
	public void deposit(double amount) {
		accBalance = accBalance + amount;
	}
	public void withdrawl(double amount) {
		accBalance = accBalance - amount;
	}
	public void show() {
		System.out.println(accNum+" "+accName+" "+accBalance);
	}
};

public class AccountHolder {
	public static void main(String[] args) {
		int choice, cnt=0, acno;
		Account [] arr = new Account[10];
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Add a record");
			System.out.println("2. Show all records");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the account number, name and balance: ");
				arr[cnt++] = new Account(sc.nextInt(),sc.next(),sc.nextDouble());
				break;
			case 2:
				for(int i=0;i<cnt;i++)
					arr[i].show();
				break;
			case 3:
				System.out.println("Enter account number: ");
				acno = sc.nextInt();
				for(int i=0; i<cnt; i++) {
					if(arr[i].getAccNum()==acno) {
						System.out.println("Enter amount to be deposited: ");
						arr[i].deposit(sc.nextDouble());
					}
				}
				break;
			case 4:
				System.out.println("Enter account number: ");
				acno = sc.nextInt();
				for(int i=0;i<cnt;i++) {
					if(arr[i].getAccNum()==acno) {
						System.out.println("Enter amount to be withdrawn: ");
						arr[i].withdrawl(sc.nextDouble());
					}
				}
				break;
			case 5:
			System.exit(0);
			}
		}
	}
}
