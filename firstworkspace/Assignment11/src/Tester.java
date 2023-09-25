class Employee{
	protected int employee_id;
	protected String name;
	protected double basic_salary;
	public Employee() {
	employee_id=0;
	name="Abhishek";
	basic_salary=0;
	}
	public Employee(int employee_id,String name,double basic_salary) {
		this.employee_id = employee_id;
		this.name=name;
		this.basic_salary=basic_salary;
	}
	public String show() {
		return employee_id+" "+name+" "+basic_salary;
	}
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(employee_id+" "+name+" "+basic_salary);
	}
	
	
}
class Manager extends Employee{
	private float Petrol_Allowance;
	private float Food_Allowance;
	private float Other_Allowance;
	public Manager() {
		
	}
	public Manager(int employee_id,String name,int basic_salary) {
	super(employee_id,name,basic_salary);
	this.Petrol_Allowance=Petrol_Allowance;
	this.Food_Allowance=Food_Allowance;
	this.Other_Allowance=Other_Allowance;
	}
	public double getSalary() {
		return basic_salary;
	}
	double sal=getSalary();
	double allowance=(0.08*sal)+(0.12*sal)+(0.04*sal);
	public float cal_gross_sal(){
		return (float) (sal+allowance);
	}
	double pf=(0.125*sal);
	public float net_salary(){
		return (float) ((sal+allowance)-pf);
		
	}
	
}
class MarketingExecutive extends Employee{
private int Kilometers_travelled;
private int Telephone_Allowance=2000;
public MarketingExecutive() {
	
}
public MarketingExecutive(int employee_id,String name,int basic_salary,int Kilometers_travelled) {
	super(employee_id,name,basic_salary);
	this.Kilometers_travelled=Kilometers_travelled;
	this.Telephone_Allowance=Telephone_Allowance;
}
public double getSalary() {
	return basic_salary;
	
}
public String show() {
	return employee_id+" "+name+" "+basic_salary+" "+Kilometers_travelled+" "+pf;
}
double sal=getSalary();
double allowance=5*Kilometers_travelled+2000;
public double cal_gross_salary(){
return (sal+allowance);
}
double pf=(0.125*sal);
public double net_salary() {
	return (sal+allowance)-pf;
	
}
}
public class Tester {
public static void printObject(Employee e) {
	e.display();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Employee e1 = new Employee(101,"Abhishek",28000);
System.out.println();
System.out.println();
System.out.println(e1.show());
Manager m1 = new Manager(101,"Abhishek",28000);
System.out.println("Gross Salary:"+m1.cal_gross_sal());
System.out.println("Net Salary:"+m1.net_salary());
MarketingExecutive me1 = new MarketingExecutive(101,"Abhishek",24000,11);
System.out.println(me1.show());
System.out.println("Gross Salary:"+me1.cal_gross_salary());
System.out.println("Net Salary:"+me1.net_salary());
Employee e5 = new Employee(102,"Abhishek",26000);
e5.display();
	}

}
