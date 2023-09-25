import java.sql.*;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the lid,make and cost:");
		int lid=sc.nextInt();
		String make=sc.next();
		double cost=sc.nextInt();
		// TODO Auto-generated method stub
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/test_schema","root","root");
PreparedStatement pstmt = conn.prepareStatement("insert into Laptop values(?,?,?)");
pstmt.setInt(1,lid);
pstmt.setString(2, make);
pstmt.setDouble(3, cost);
boolean status = pstmt.execute();
if(status==true) {
	System.out.println("row inerted sucessfully");
}

conn.close();
	}

}
