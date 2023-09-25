import java.util.*;

class Employee{
	int employee_id;
	String employee_name;
	int salary;
	public Employee() {
		employee_id=101;
		employee_name="Abhishek Pillai";
		salary=0;
	}
	public Employee(int employee_id,String employee_name,int salary) {
		this.employee_id=employee_id;
		this.employee_name=employee_name;
		this.salary=salary;
	}
	public int getEmployeeid() {
		return employee_id;
	}
	public void setEmployeeid() {
		this.employee_id=employee_id;
	}
	public String getEmployeename() {
		return employee_name;
	}
	public void setEmployeename() {
		this.employee_name=employee_name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary() {
		this.salary=salary;
	}
	public void display() {
		System.out.println(employee_id+" "+employee_name+" "+salary);	
	}
	public void accept() {
		System.out.println("Enter the employee id:");
		Scanner id = new Scanner(System.in);
		employee_id = id.nextInt();
		System.out.println(employee_id+" ");
		System.out.println("Enter the employee name:");
		Scanner nm = new Scanner(System.in);
		employee_name = nm.next();
		System.out.println(employee_name+" ");
		System.out.println("Enter the employee salary");
		Scanner s = new Scanner(System.in);
		salary = nm.nextInt();
		System.out.println(salary+" ");

	}
}
public class Tester {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int choice;
		Employee e1 = new Employee(101,"Abhishek",28000);
		List<Employee> e = new ArrayList<Employee>();
		Scanner sc = new Scanner(System.in);
		e1.accept();
		e.add(e1);
//		System.out.println(ee1.add(e1));
		for(int i=0;i<e.size();i++) {

			System.out.println(e.get(i).employee_id+" "+e.get(i).employee_name+" "+e.get(i).salary);
		}
		while(true) {
			System.out.println("1. Add a record");
			System.out.println("2. Show all records");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Exit");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				e1.accept();
				e.add(e1);
				((Employee) e).display();
				break;
			case 2:
				
				
			}
	}
	}
}


