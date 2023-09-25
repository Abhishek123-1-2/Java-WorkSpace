import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter the student name,student Id,rollno,and marks");
		Scanner sc  = new Scanner(System.in);
		String student_name = sc.next();
		int Stu_id = sc.nextInt();
		int rollno = sc.nextInt();
		int marks = sc.nextInt();
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student_db","root","root");
		PreparedStatement stmt = conn.prepareStatement("insert into Student values(?,?,?,?)");
		stmt.setString(1, student_name);
		stmt.setInt(2, Stu_id);
		stmt.setInt(3,rollno);
		stmt.setInt(4, marks);
		boolean status = stmt.execute();
		if(status==true) {
			System.out.println("Rows Inserted successfully....");
		}
conn.close();
	}

}
