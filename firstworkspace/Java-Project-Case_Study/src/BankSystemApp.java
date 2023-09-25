import java.util.Scanner;
import java.sql.*;

class CustomerLogin {
    private Scanner scanner = new Scanner(System.in);
    
    
    
    public void deposit(int accno) throws SQLException {
    	Scanner sc = new Scanner(System.in);
    	
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system","root","root");
    	
    	System.out.print("Enter amount to deposit: ");
    	int amount = sc.nextInt();
    	
    	String searchQuery = "SELECT * FROM customer WHERE account_number = ?";
    	
    	PreparedStatement stmt = con.prepareStatement(searchQuery);
        stmt.setInt(1, accno);
    	
        ResultSet result = stmt.executeQuery();
        int newAccbalance = 0;
        
        if(result.next()) {
        	System.out.println("Account balance earlier: ");
        	System.out.println("Account balance: "+result.getInt(4));
        }
        
        newAccbalance = result.getInt(4) + amount;
        
        String updateQuery = "update customer set account_balance=? where account_number=?";
    	PreparedStatement stmt1 = con.prepareStatement(updateQuery);
    	stmt1.setInt(1, newAccbalance);
    	stmt1.setInt(2, accno);
    	
    	int rowsAffected = stmt1.executeUpdate();
    	
    	if(rowsAffected>0) {
    		System.out.println("Amount deposited successfully");
    		
    	}else {
    		System.out.println("Failed to deposit");
    	}
    	
    	
        String depositQuery = "INSERT INTO transaction_history (account_number, transaction_type, amount) VALUES (?, 'Deposit', ?)";
        PreparedStatement depositStmt = con.prepareStatement(depositQuery);
        depositStmt.setInt(1, accno);
        depositStmt.setInt(2, amount);
        depositStmt.executeUpdate();
    }
    
    
    
    
    public void withdraw(int accno) throws SQLException {
    	Scanner sc = new Scanner(System.in);
    	
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system","root","root");
    	
    	System.out.print("Enter amount to withdraw: ");
    	int amount = sc.nextInt();
    	
    	String searchQuery = "SELECT * FROM customer WHERE account_number = ?";
    	
    	PreparedStatement stmt = con.prepareStatement(searchQuery);
        stmt.setInt(1, accno);
    	
        ResultSet result = stmt.executeQuery();
        
        if(result.next()) {
        	System.out.println("Account balance earlier: ");
        	System.out.println("Account balance: "+result.getInt(4));
        }
        int newAccbalance;
        if(result.getInt(4)>amount) {
        	newAccbalance = result.getInt(4) - amount;
        	
        	String updateQuery = "update customer set account_balance=? where account_number=?";
        	PreparedStatement stmt1 = con.prepareStatement(updateQuery);
        	stmt1.setInt(1, newAccbalance);
        	stmt1.setInt(2, accno);
        	
        	int rowsAffected = stmt1.executeUpdate();
        	
        	if(rowsAffected>0) {
        		System.out.println("Amount withdraw successfully");
        	}else {
        		System.out.println("failed to withdraw");
        	}
        	
        	
        	
        }else {
        	System.out.println("Insufficient balance..Cant withdraw");
        }
        
     // Record withdrawal transaction
        String withdrawQuery = "INSERT INTO transaction_history (account_number, transaction_type, amount) VALUES (?, 'Withdrawal', ?)";
        PreparedStatement withdrawStmt = con.prepareStatement(withdrawQuery);
        withdrawStmt.setInt(1, accno);
        withdrawStmt.setInt(2, amount);
        withdrawStmt.executeUpdate();
    }
    
    
    
    
    public void transferAmount(int accno) throws SQLException {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter account no: ");
        int destinationAccNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter amount to transfer: ");
        int amount = sc.nextInt();

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "root");

        String searchQuery = "SELECT account_balance FROM customer WHERE account_number = ?";
        PreparedStatement stmt = con.prepareStatement(searchQuery);
        stmt.setInt(1, accno);

        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            int sourceAccBalance = result.getInt(1);
            if (sourceAccBalance >= amount) {
                int newSourceAccBalance = sourceAccBalance - amount;

                String updateSourceQuery = "UPDATE customer SET account_balance = ? WHERE account_number = ?";
                PreparedStatement updateStmt = con.prepareStatement(updateSourceQuery);
                updateStmt.setInt(1, newSourceAccBalance);
                updateStmt.setInt(2, accno);
                int rowsAffectedSource = updateStmt.executeUpdate();

                if (rowsAffectedSource > 0) {
                    String updateDestinationQuery = "UPDATE customer SET account_balance = account_balance + ? WHERE account_number = ?";
                    PreparedStatement updateDestinationStmt = con.prepareStatement(updateDestinationQuery);
                    updateDestinationStmt.setInt(1, amount);
                    updateDestinationStmt.setInt(2, destinationAccNo);
                    int rowsAffectedDestination = updateDestinationStmt.executeUpdate();

                    if (rowsAffectedDestination > 0) {
                        System.out.println("Amount transferred successfully");
                    } else {
                        System.out.println("Failed to transfer to destination account");
                    }
                } else {
                    System.out.println("Failed to update source account");
                }
            } else {
                System.out.println("Insufficient balance in source account");
            }
        } else {
            System.out.println("Source account not found");
        }
    }
    
    
    
    public void printMiniStatement(int accno) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "root");

        String historyQuery = "SELECT transaction_type, amount, transaction_date FROM transaction_history WHERE account_number = ? ORDER BY transaction_date DESC LIMIT 5";
        PreparedStatement stmt = con.prepareStatement(historyQuery);
        stmt.setInt(1, accno);

        ResultSet result = stmt.executeQuery();

        System.out.println("Mini Statement:");
        while (result.next()) {
            String transactionType = result.getString(1);
            int amount = result.getInt(2);
            String transactionDate = result.getTimestamp(3).toString();
            System.out.println("Transaction Type: " + transactionType + ", Amount: " + amount + ", Date: " + transactionDate);
        }
    }


    
    

    public void login() throws SQLException {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system","root","root");
        
        String searchQuery = "SELECT * FROM customer WHERE account_number = ?";
        PreparedStatement stmt = con.prepareStatement(searchQuery);
        stmt.setInt(1, accountNumber);
        
        ResultSet result = stmt.executeQuery();
        
        if(result.next()) {
        	System.out.println("Customer login successfull");
        	while (true) {
                System.out.println("Customer Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Print Mini Statement");
                System.out.println("4. Transfer Amount");
                System.out.println("5. Logout");
                System.out.print("Enter your choice: ");
                int customerChoice = scanner.nextInt();

                switch (customerChoice) {
                    case 1:
                        deposit(accountNumber);
                        break;
                    case 2:
                        withdraw(accountNumber);
                        break;
                    case 3:
                        printMiniStatement(accountNumber);
                        break;
                    case 4:
                        transferAmount(accountNumber);
                        break;
                    case 5:
                    	System.out.println("Logging out from customer account");
                    	System.out.println("Thank you...");
                    	con.close();
                    	System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
        else {
        	System.out.println("Customer login failed");
        }
        
       
    }

    private boolean isValidAccount(int accountNumber) {
        // Check if the account number is valid (you can replace this with your actual logic)
        return true;
    }
}






class AdministratorLogin {
    private Scanner sc = new Scanner(System.in);
    
    public void searchCustomer() throws SQLException {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter account no: ");
    	int accno = sc.nextInt();
    	
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system","root","root");
        
        String searchQuery = "SELECT * FROM customer WHERE account_number = ?";
        PreparedStatement stmt = con.prepareStatement(searchQuery);
        stmt.setInt(1, accno);
        
        ResultSet result = stmt.executeQuery();
        
        if(result.next()) {
        	System.out.println("Customer found: ");
        	
        	System.out.println("Account Holder name: "+result.getString(2));
        	System.out.println("Account no: "+result.getInt(3));
        	System.out.println("Account balance: "+result.getInt(4));
        }
    }
    
    
    public void modifyCustomer() throws SQLException {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter account no: ");
    	int accno = sc.nextInt();
    	sc.nextLine(); 
    	
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system","root","root");
        
        String searchQuery = "SELECT * FROM customer WHERE account_number = ?";
        PreparedStatement stmt = con.prepareStatement(searchQuery);
        stmt.setInt(1, accno);
        
        ResultSet result = stmt.executeQuery();
        
        if(result.next()) {
        	System.out.println("Okay, lets change the details");
        	System.out.println();
        	System.out.print("Enter New Name: ");
        	String newName = sc.nextLine();
        	
        	System.out.print("Enter account no: ");
        	int newAccNo = sc.nextInt();
        	sc.nextLine();
        	
        	System.out.print("Enter updated balance: ");
        	int newBal = sc.nextInt();
        	
        	String updateQuery = "update customer set name=?,account_number=?,account_balance=? where account_number=?";
        	PreparedStatement stmt1 = con.prepareStatement(updateQuery);
        	stmt1.setString(1, newName);
        	stmt1.setInt(2, newAccNo);
        	stmt1.setInt(3, newBal);
        	stmt1.setInt(4, accno);
        	
        	int rowsAffected = stmt1.executeUpdate();
        	
        	if(rowsAffected>0) {
        		System.out.println("Customer updated successfully");
        	}else {
        		System.out.println("Failed to update");
        	}
        	
        	
        }
    }
    
    
    
    public void deleteCustomer() throws SQLException {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter account no: ");
    	int accno = sc.nextInt();
    	sc.nextLine(); 
    	
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system","root","root");
        
    	String deleteQuery = "DELETE FROM customer WHERE account_number = ?";
        PreparedStatement stmt = con.prepareStatement(deleteQuery);
        stmt.setInt(1, accno);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Customer deleted successfully");
        } else {
            System.out.println("Failed to delete customer");
        }
    }
    
    
    public void balanceEnquiry() throws SQLException {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter account no: ");
    	int accno = sc.nextInt();
    	sc.nextLine(); 
    	
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system","root","root");
        
    	String searchAccBalance = "SELECT * FROM customer WHERE account_number = ?";
        PreparedStatement stmt = con.prepareStatement(searchAccBalance);
        stmt.setInt(1, accno);

        ResultSet result = stmt.executeQuery();
        if (result.next()) {
            System.out.println("Account balance: "+result.getString(4));
        } else {
            System.out.println("Account not found");
        }
    }
    
   
    
   
    
    public void addCustomer() throws SQLException {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter name: ");
    	String name = sc.nextLine();
    	System.out.print("Enter account number: ");
    	int accno = sc.nextInt();
    	sc.nextLine();
    	System.out.println("Enter initial balance: ");
    	int inibal = sc.nextInt();
    	
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system","root","root");
    	
    	String insertQuery = "INSERT INTO customer(name,account_number,account_balance) values(?,?,?)";
    	PreparedStatement stmt = con.prepareStatement(insertQuery);
    	stmt.setString(1, name);
    	stmt.setInt(2, accno);
    	stmt.setInt(3, inibal);
    	
    	int rowsAffected = stmt.executeUpdate();
    	
    	if(rowsAffected>0) {
        	System.out.println("Customer added successfully");
        }else {
        	System.out.println("Sorry, customer not added!");
        }
    	
    	
    	
    }

    public void login() throws SQLException {
        System.out.print("Enter administrator username: ");
        String adminUsername = sc.nextLine();
        System.out.print("Enter administrator password: ");
        String adminPassword = sc.nextLine();
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system","root","root");
        
        String searchQuery = "SELECT * FROM admin WHERE username = ? AND password = ?";
        PreparedStatement stmt = con.prepareStatement(searchQuery);
        stmt.setString(1, adminUsername);
        stmt.setString(2, adminPassword);
        
        ResultSet result = stmt.executeQuery();
        
        if (result.next()) {
            System.out.println("Admin logged in successfully.");
            
            while (true) {
                System.out.println("Administrator Menu:");
                System.out.println("1. Add Customer");
                System.out.println("2. Search Customer");
                System.out.println("3. Modify Customer");
                System.out.println("4. Delete Customer");
                System.out.println("5. Balance Inquiry");
                System.out.println("6. Logout");
                System.out.print("Enter your choice: ");
                int adminChoice = sc.nextInt();

                switch (adminChoice) {
                    case 1:
                        addCustomer();
                        break;
                    case 2:
                        searchCustomer();
                        break;
                    case 3:
                    	modifyCustomer();
                        break;
                    case 4:
                        deleteCustomer();
                        break;
                    case 5:
                        balanceEnquiry();
                        break;
                    case 6:
                    	System.out.println("Logging out from admin account");
                    	System.out.println("Thank you...");
                    	con.close();
                    	System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            
            
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }

    }
}
public class BankSystemApp {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Administrator Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    AdministratorLogin adminLogin = new AdministratorLogin();
                    adminLogin.login();
                    break;
                case 2:
                    CustomerLogin customerLogin = new CustomerLogin();
                    customerLogin.login();
                    break;
                case 3:
                	System.out.println("Visit again..");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

	}


