import java.sql.*;
import java.util.Scanner;
public class Tester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the rollno,name and percentage:");
			int rollno=sc.nextInt();
			String name=sc.next();
			float percentage=sc.nextFloat();
			// TODO Auto-generated method stub
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/stud_schema","root","root");
	PreparedStatement pstmt = conn.prepareStatement("insert into Student values(?,?,?)");
	Statement s= conn.createStatement();
	ResultSet rs =s.executeQuery("Select * from Student");
	pstmt.setInt(1,rollno);
	pstmt.setString(2, name);
	pstmt.setFloat(3, percentage);
	boolean status = pstmt.execute();
	if(status==true) {
		System.out.println("row inserted sucessfully");
	}

	conn.close();
		}

	
	}




	