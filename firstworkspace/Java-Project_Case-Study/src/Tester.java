import java.util.*;
import java.sql.*;

class AdminUpdate{
	private int account_no;
	private String account_name;
	private double account_balance;
	private Connection conn;
	
	public AdminUpdate(String jdbcUrl, String Username, String Password) throws SQLException  {
		conn = DriverManager.getConnection(jdbcUrl, Username, Password);
	}
	
	public void getDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account Number: ");
		account_no = sc.nextInt();
		System.out.println("Enter Account Name: ");
		account_name = sc.next();
		System.out.println("Enter Account Balance: ");
		account_balance = sc.nextDouble();
	}

	
	public int getAccount_no() {
		return account_no;
	}

	public String getAccount_name() {
		return account_name;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public void insertRecord() throws SQLException {
		getDetails();
		
		PreparedStatement inst = conn.prepareStatement("Insert into bank_account values(?,?,?)");
		
		inst.setInt(1, getAccount_no());
		inst.setString(2, getAccount_name());
		inst.setDouble(3, getAccount_balance());
		
		inst.execute();
		
		inst.close();
	}
	
/*	public boolean checkRecord(int account_number) throws SQLException {

		String qry = "Select * from bank_account where account_no = ?"; 
		PreparedStatement select_all = conn.prepareStatement(qry);
		
		select_all.setInt(1, account_number);
		ResultSet rst = select_all.executeQuery();
		
		boolean result = false;
		if(rst.next()) {
			result = true;
			System.out.println("\nAccount Number:  "+rst.getString("account_no")+"\nAccount Name:  "+rst.getString("account_name")+"\nAccount Balance: "+rst.getString("account_balance")+"\n");
		} else {
			result = false;
			System.out.println("\nAccount Number:  "+account_number+ " is not present within the DataBase.");			
		}
		
		rst.close();
		select_all.close();
		return result;
	}
*/
	
	public boolean checkRecord(int accountNumber) {
	    boolean result = false;

	    try {
	        String query = "SELECT * FROM bank_account WHERE account_no = ?";
	        PreparedStatement selectStatement = conn.prepareStatement(query);
	        
	        selectStatement.setInt(1, accountNumber);
	        ResultSet resultSet = selectStatement.executeQuery();
	        System.out.println();
	        System.out.println("Updated Details of Account:-");
	        if (resultSet.next()) {
	            result = true;
	            System.out.println("Account Number:  " + resultSet.getString("account_no") + "\nAccount Name:  " + resultSet.getString("account_name") + "\nAccount Balance: " + resultSet.getString("account_balance") + "\n");
	        } else {
	            System.out.println("Account Number:  " + accountNumber + " is not present within the DataBase.");
	        }
	        
	        resultSet.close();
	        selectStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace(); // Handle or log the exception appropriately
	    }

	    return result;
	}

	public void updateRecord(String account_name, int account_no) throws SQLException {
		String qry = "Update bank_account SET account_name=? where account_no=?";
		PreparedStatement update_name = conn.prepareStatement(qry);
		update_name.setString(1, account_name);
		update_name.setInt(2, account_no);
		
		update_name.execute();
		
		update_name.close();
		checkRecord(account_no);
	}
	
	public double checkBalance(int account_no) throws SQLException {
		String qry = "Select account_balance from bank_account where account_no=?";
		PreparedStatement chkBal = conn.prepareStatement(qry);
		
		chkBal.setInt(1, account_no);
		
		ResultSet chkset = chkBal.executeQuery();
		
		
		double balance = 0.0;
		
		if(chkset.next()) {
			balance = chkset.getDouble("account_balance");
			System.out.println("\nThe Total Balance of  Account Holder "+account_no+" is "+balance);
		}
		else {
			System.out.println("Empty!!!");
		}
		
		chkset.close();
		
		return balance;
		
	}
	
	public void deleteRecord(int account_no) throws SQLException {
		String qry = "DELETE FROM bank_account WHERE account_no = ?";
		PreparedStatement delacc = conn.prepareStatement(qry);
		delacc.setInt(1, account_no);
		
		delacc.execute();
		
		delacc.close();
		System.out.println("Your Account has been Deleted. Funds are Null and Void!!!");

		checkRecord(account_no);
	}
	

	
	public void depositAmt(int account_no, double amount) throws SQLException {
		String qry = "Update bank_account SET account_balance=? where account_no=?";
		double balance = checkBalance(account_no);
		String txn_type = "Deposit";
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		account_balance = balance + amount;

		PreparedStatement deposit = conn.prepareStatement(qry);
		
		deposit.setDouble(1, account_balance);
		deposit.setDouble(2, account_no);
		
		deposit.execute();
		
		deposit.close();
		checkRecord(account_no);
		updateStatement(account_no, txn_type, amount, currentTimestamp, account_balance);	
	}
	

	public void withdrawAmt(int account_no, double amount) throws SQLException {
		String qry = "Update bank_account SET account_balance=? where account_no=?";
		double balance = checkBalance(account_no); 
		String txn_type = "Withdraw";
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		account_balance = balance - amount;
		
		PreparedStatement withdraw = conn.prepareStatement(qry);
		
		withdraw.setDouble(1, account_balance);
		withdraw.setDouble(2, account_no);
		
		withdraw.execute();
		
		withdraw.close();
		checkRecord(account_no);
		updateStatement(account_no, txn_type, amount, currentTimestamp, account_balance);
	}
	
	public void updateStatement(int account_no, String txn_type, double txn_amount, Timestamp currentTimestamp, double account_bal) throws SQLException {
		String qry = "Insert into account_statement values(?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(qry);
		stmt.setInt(1, account_no);
		stmt.setString(2, txn_type);
		stmt.setDouble(3, txn_amount);
		stmt.setTimestamp(4, currentTimestamp);
		stmt.setDouble(5, account_bal);
		
		stmt.execute();
		stmt.close();
	}

	/*	public boolean checkRecord(int account_number) throws SQLException {

	String qry = "Select * from bank_account where account_no = ?"; 
	PreparedStatement select_all = conn.prepareStatement(qry);

	select_all.setInt(1, account_number);
	ResultSet rst = select_all.executeQuery();

	boolean result = false;
	if(rst.next()) {
		result = true;
		System.out.println("\nAccount Number:  "+rst.getString("account_no")+"\nAccount Name:  "+rst.getString("account_name")+"\nAccount Balance: "+rst.getString("account_balance")+"\n");
	} else {
		result = false;
		System.out.println("\nAccount Number:  "+account_number+ " is not present within the DataBase.");			
	}

	rst.close();
	select_all.close();
	return result;
}
	 */

	
	public void getstatement(int account_no) throws SQLException {

		String qry = "Select * from account_statement where account_no = ?";

		PreparedStatement print = conn.prepareStatement(qry);

		print.setInt(1, account_no);

		ResultSet print_rst = print.executeQuery();
		
		
		if(print_rst.next()) {
			System.out.println("Account Number \t Transaction Type \t Transaction Amount \t TimeStamp \t Total Balance");
			System.out.println(account_no+ "                  "+print_rst.getString("txn_type")+"                  "+print_rst.getString("txn_amount")+"        "+print_rst.getString("process_time")+"        "+print_rst.getString("account_balance"));
		}
	}

	public void transfer(int account_no1, double amount, int account_no2) throws SQLException {
		if(checkRecord(account_no1) == true) {
				if(checkRecord(account_no2) == true) {
					if(checkBalance(account_no1) > amount) {
						withdrawAmt(account_no1, amount);
						depositAmt(account_no2, amount);
					} else {
						System.out.println("No Sufficient Funds!");
					}
				} else {					
					System.out.println(account_no2+" is not present in the database.");
				}
		} else {
			System.out.println(account_no1+" is not present in the database.");
		}
	}

	public void closeConnection() throws Exception {
		conn.close();
	}
}


public class Tester {

	protected static void switch_customer() throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String jdbcUrl="jdbc:mysql://localhost/banking_db";
		String username="root";
		String password="root";
		
		AdminUpdate customer = new AdminUpdate(jdbcUrl, username, password);
		
		while(true) {
			int account_no;
			int customer_choice;
			double amount;
			System.out.println();
			System.out.println("Customer Here!!");
			System.out.println("Customer Dashboard!");
			System.out.println("1. Deposit Amount within your Account.");
			System.out.println("2. Withraw Amount from your Account.");
			System.out.println("3. Print Account Statement.");
			System.out.println("4. Transfer Amount in Other Account.");
			System.out.println("5. Exit.");
			System.out.print("Enter choice:");
			customer_choice = sc.nextInt();

			switch(customer_choice) {
			case 1:
				System.out.println();
				System.out.print("Enter Account Number to Deposit amount:  ");
				account_no = sc.nextInt();
				System.out.print("Enter Amount To Be Deposited:  ");
				amount = sc.nextDouble();
				customer.depositAmt(account_no, amount);
//				customer.closeConnection();
				break;

			case 2:
				System.out.println();
				System.out.print("Enter Account Number to Withdraw amount:  ");
				account_no = sc.nextInt();
				System.out.print("Enter Amount To Be Withdrawn:  ");
				amount = sc.nextDouble();
				customer.withdrawAmt(account_no, amount);
//				customer.closeConnection();
				break;

			case 3:
				System.out.println();
				System.out.print("Enter Account Number for print mini statement of your Account :  ");
				account_no = sc.nextInt();
				customer.getstatement(account_no);
//				customer.closeConnection();
				break;

			case 4:
				System.out.println();
				System.out.println("Transfer Amount Into Other Account");
				System.out.print("Enter Sender's Account Number: ");
				int account_no1 = sc.nextInt();
				System.out.print("Enter Amount To Be Sent: ");
				amount = sc.nextDouble();
				System.out.print("Enter Receiver's Account Number: ");
				int account_no2 = sc.nextInt();
				customer.transfer(account_no1, amount, account_no2);
//				customer.closeConnection();
				break;

			case 5:
				System.out.println("Thankyou For banking with us!!!");
				customer.closeConnection();
				System.exit(0);
			}
		}
	}	

	
	protected static void switch_admin() throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String jdbcUrl="jdbc:mysql://localhost/banking_db";
		String username="root";
		String password="root";
		
		AdminUpdate admin = new AdminUpdate(jdbcUrl, username, password);
	
		while(true) {
			int admin_choice;
			int account_no;
			String account_name;
			System.out.println();
			System.out.println("Admin Dashboard!");
			System.out.println("1. Add a new Customer.");
			System.out.println("2. Search for Customer Details via Account Number.");
			System.out.println("3. Update for Customer Details via Account Number.");
			System.out.println("4. Balance Inquiry via Customer Account Number.");
			System.out.println("5. Close Account.");
			System.out.println("6. Exit.");
			System.out.print("Enter choice:");
			admin_choice = sc.nextInt();
			
			switch(admin_choice) {
			case 1:
				System.out.println();
				admin.insertRecord();
//				admin.closeConnection();
				break;
			case 2:
				System.out.println();
				System.out.print("Enter Account Number to view Details:  ");
				account_no = sc.nextInt();
				admin.checkRecord(account_no);
//				admin.closeConnection();
				break;
				
			case 3:
				System.out.println();
				System.out.print("Enter Account Number for updation process:  ");
				account_no = sc.nextInt();
				System.out.print("Enter New Account Holder Name:  ");
				account_name = sc.next();
				admin.updateRecord(account_name, account_no);
//				admin.closeConnection();
				break;
		
			case 4:
				System.out.println();
				System.out.print("Enter Account Number for Balance Inquiry:  ");
				account_no = sc.nextInt();
				admin.checkBalance(account_no);
//				admin.closeConnection();
				break;
			
			case 5:
				System.out.println();
				System.out.println("Enter Account Number for Deletion Process:  ");
				account_no = sc.nextInt();
				admin.deleteRecord(account_no);
//				admin.closeConnection();
				break;		
			
			case 6:
				System.out.println("Thankyou For banking with us!!!");
				admin.closeConnection();
				System.exit(0);
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
				
		System.out.println("*** <- Welcome to Banking System -> ***");
		
		System.out.println("Press C if your a Customer!");

		System.out.println("Press A if your a Admin!");

		String choice = sc.next();
		
		if(choice.equalsIgnoreCase("c")) 
		{
			switch_customer();
		}
		else if(choice.equalsIgnoreCase("a")) 
		{
			System.out.print("Enter password: ");
			String pwd = sc.next();
			if(pwd.equalsIgnoreCase("admin")) {
				switch_admin();
			}
		}
		else 
		{
			System.out.println("Error!!!");
			System.out.println("Your are trying to enter an unknown interface!");
			System.out.println("Try Again!!!");
			System.exit(0);
		}
		
	}


}
