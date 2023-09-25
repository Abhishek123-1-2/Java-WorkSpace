import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class BankSystemApp {
	private Connection connection;

    public BankSystemApp() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
  }

    public void createTables() {
        try {
            Statement statement = connection.createStatement();
            String createCustomersTable = "CREATE TABLE  customers (" +
                                         "account_number INT PRIMARY KEY, " +
                                         "name VARCHAR(255), " +
                                         "balance DOUBLE)";
            statement.executeUpdate(createCustomersTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      public void addCustomer(BankCustomer customer) {
    
    
        try {
        	String insertQuery = "INSERT INTO customers (account_number, name, balance) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, customer.getAccountNumber());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setDouble(3, customer.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete_Details(BankCustomer customer) {
    	try {
        	
    		   
            String deleteQuery = "DELETE FROM customers where account_number=?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, customer.getAccountNumber());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setDouble(3, customer.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    

public static void main(String[] args) throws SQLException {
    BankSystemApp bankSystem = new BankSystemApp();
    bankSystem.createTables();
    bankSystem.addCustomer(new BankCustomer(101,"Abhishek Pillai",36000));
    bankSystem.addCustomer(new BankCustomer(102,"Radhika Sanap",28000));
    bankSystem.addCustomer(new BankCustomer(103,"Rukmani Sharma",26000));
    bankSystem.addCustomer(new BankCustomer(104,"Koushin Roy",29000));
    bankSystem.addCustomer(new BankCustomer(105,"Raj Singh",31000));
    bankSystem.delete_Details(new BankCustomer(105,"Raj Singh",31000));


    
}
}


