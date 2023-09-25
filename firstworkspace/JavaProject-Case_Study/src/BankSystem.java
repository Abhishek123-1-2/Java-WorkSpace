import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Customer{
	private int accountNumber;
	private String name;
	private double balance;
	List<String> transactions;
	
	public Customer(int accountNumber,String name,double balance) {
		this.accountNumber=accountNumber;
		this.name=name;
		this.balance=balance;
		this.transactions=new ArrayList<>();
		
	}
	public int getAccountNumber() {
		return accountNumber;
		
	}
	public String getName() {
		return name;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		balance=balance+amount;
		transactions.add("Deposited: " + amount);
	}
	public void withdraw(double amount) throws InsufficientBalanceException {
		 if (balance < amount) {
	            throw new InsufficientBalanceException("Insufficient balance");
	        }
	        balance = balance-amount;
	        transactions.add("Withdrawn: " + amount);
	}
	public List<String> getTransactions() {
        return transactions;
    }
}
public class BankSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner = new Scanner(System.in);
        
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "root");

            while (true) {
                System.out.println("\nBank System Menu:");
                System.out.println("1. Login as Customer");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.print("Enter your account number: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine();

                    Customer customer = getCustomerFromDatabase(connection, accountNumber);

                    if (customer != null) {
                        System.out.println("Welcome, " + customer.getName() + "!");
                        while (true) {
                            System.out.println("\nCustomer Menu:");
                            System.out.println("1. Deposit money");
                            System.out.println("2. Withdraw money");
                            System.out.println("3. Print mini statement");
                            System.out.println("4. Transfer amount");
                            System.out.println("5. Logout");
                            System.out.print("Enter your choice: ");
                            int subChoice = scanner.nextInt();
                            scanner.nextLine();

                            if (subChoice == 1) {
                                System.out.print("Enter the amount to deposit: ");
                                double amount = scanner.nextDouble();
                                scanner.nextLine();
                                customer.deposit(amount);
                                updateCustomerBalanceInDatabase(connection, customer.getAccountNumber(), customer.getBalance());
                                System.out.println("Deposit successful.");
                            } else if (subChoice == 2) {
                                System.out.print("Enter the amount to withdraw: ");
                                double amount = scanner.nextDouble();
                                scanner.nextLine();
                                try {
                                    customer.withdraw(amount);
                                    updateCustomerBalanceInDatabase(connection, customer.getAccountNumber(), customer.getBalance());
                                    System.out.println("Withdrawal successful.");
                                } catch (InsufficientBalanceException e) {
                                    System.out.println("Insufficient balance.");
                                }
                            } else if (subChoice == 3) {
                                System.out.println("Mini Statement for " + customer.getName());
                                List<String> transactions = customer.getTransactions();
                                for (int i = 0; i < transactions.size(); i++) {
                                    System.out.println(transactions.get(i));
                                }
                            } else if (subChoice == 4) {
                               
                            } else if (subChoice == 5) {
                                System.out.println("Logging out.");
                                break;
                            } else {
                                System.out.println("Invalid choice. Please enter a valid option.");
                            }
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                } else if (choice == 2) {
                    System.out.println("Exiting the bank system.");
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Customer getCustomerFromDatabase(Connection connection, int accountNumber) throws SQLException {
        String query = "SELECT * FROM customers WHERE account_number = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                return new Customer(accountNumber, name, balance);
            }
        }
        return null;
    }

    private static void updateCustomerBalanceInDatabase(Connection connection, int accountNumber, double balance) throws SQLException {
        String query = "UPDATE customers SET balance = ? WHERE account_number = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, balance);
            statement.setInt(2, accountNumber);
            statement.executeUpdate();
        }
    }

	}


