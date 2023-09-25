package classprogram;

public class Tester {
private int marks;
private String student_name;
private int age;
public Tester(int marks,String student_name,int age) {
this.marks = marks;
this.student_name = student_name;
this.age = age;
}

public String show() {
	return marks+" "+student_name+" "+age;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Tester t1 = new Tester(75,"Aditya Manojkumar Pillewgegeawai",14);
System.out.println(t1.show());

	}

}
