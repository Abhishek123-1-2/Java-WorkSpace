package in.mindcraft;

public class Employee {
private int empId;
private String name;
private Date dob;
public Employee() {
	empId = 101;
	name = "abc";
	dob = new Date(12,9,1990);
}
public Employee(int id,String n,int d,int m,int y) {
	empId=id;
	name=n;
	dob=new Date(d,m,y);
}
public void show() {
	System.out.println(empId);
	System.out.println(name);
	dob.show();
}
}
