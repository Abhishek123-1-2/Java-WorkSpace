
public class Deposit {
private int accountnumber;
private String accountholdername;
private int accountbalance;
public Deposit(int accountnumber,String accountholdername,int accountbalance) {
	this.accountnumber = accountnumber;
	this.accountholdername = accountholdername;
	this.accountbalance = accountbalance;
}
public int getaccountnumber(int accountnumber) {
	return accountnumber;
}
public String accountholdername(String accountholdername) {
	return accountholdername;
	
}
public int getaccountbalance(int accountbalance) {
	return accountbalance;
	
}
public void setaccountnumber(int accountnumber) {
	this.accountnumber = accountnumber;
}
public void setaccountholdername(String accountholdername) {
	this.accountholdername = accountholdername;
}
public void setaccountbalance(int accountbalance) {
	this.accountbalance = accountbalance;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
int [][]a = new int[3][3];
Deposit a1 = new Deposit(11001,"Abhishek",11000);
Deposit a2 = new Deposit(10101,"Raman",12350);
Deposit a3 = new Deposit(10135,"Jadhav",165000);
for(i=0;i<a.length;i++) {
	
	
}
	}

}
