class Employee{
	protected int id;
	protected String name;
	protected int basic_salary;
	public Employee() {
		id=1;
		name="Abhishek";
		basic_salary=0;
	}
	public Employee(int id,String name,int basic_salary) {
		this.id = id;
		this.name=name;
		this.basic_salary = basic_salary;
	}
	public void show() {
		System.out.println(id+" "+name+" "+basic_salary);
	}
	public void display() {
		
	}
	
}
class Manager extends Employee{
	private int petrol_allowance;
	private int food_allowance;
	private int other_allowance;
	public Manager() {
		petrol_allowance=0;
		food_allowance=0;
		other_allowance=0;
	}
	public Manager(int id,String name,int basic_salary) {
		super(id,name,basic_salary);
		this.id = id;
		this.name = name;
		this.basic_salary = basic_salary;
		
		
	}
	public int getSalary() {
		return basic_salary;
	}
	double sal=getSalary();
	double pf = 0.125*sal;
	double allowances = 0.8*sal+0.12*sal+0.04*sal;
	double gross_salary = sal+allowances;
	double net_salary = gross_salary-pf;
	public int calcGrossSal() {
		return (int) gross_salary;
	}
	public int calcNetSalary(){
		return (int) net_salary;
		
	}
	public void display() {
		System.out.println("Gross Salary:"+gross_salary);
		System.out.println("Net Salary:"+net_salary);
	}
	
}
class MarketiveExecutive extends Employee{
	private int Kilometers;
	private int telephone_allowance=2000;
	public void MarektExecutive(){
		Kilometers=0;
		telephone_allowance=0;
	}
	public MarketiveExecutive(int id,String name,int basic_salary,int Kilometers,int telephone_allowance) {
		super(id,name,basic_salary);
		
	}
	
}
public class Tester {

	public static void main(String[] args) {
		// TO Auto-generated method stub
Employee e1 = new Employee(101,"Abhishek Pillai",100000);
e1.show();
Manager m1 = new Manager(102,"Abhishek Pillai",28000);
m1.display();
	}

}
