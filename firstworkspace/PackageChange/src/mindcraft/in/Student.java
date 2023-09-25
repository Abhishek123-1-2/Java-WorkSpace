package mindcraft.in;

public class Student{
	protected int roll_no;
	protected String name;
	public Student(int roll_no,String name) {
		this.roll_no = roll_no;
		this.name = name;
	}
	public void display() {
		System.out.println(roll_no+" "+name);
	}
}