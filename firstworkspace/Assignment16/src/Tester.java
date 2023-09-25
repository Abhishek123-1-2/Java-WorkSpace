import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Student{
	protected int rollno;
	protected String name;
	protected double percentage;
	protected Set<String> skillset;
	public Student() {
		rollno=812;
		name = "Abhishek";
		percentage=91.6;
		skillset=null;
	}
	public Student(int rollno,String name,double percentage,String <Set> string) {
		this.rollno=rollno;
		this.name=name;
		this.percentage=percentage;
		this.skillset=string;
	}
	public void display() {
		System.out.println(rollno+" "+name+" "+percentage+" "+skillset);
	}
}
class UtilityList extends Student{
	private List<Student> list;
	public UtilityList(int rollno,String name,double percentage,String string) {
		super(rollno,name,percentage,string);
		this.rollno = rollno;
		this.name=name;
		this.percentage = percentage;
		this.skillset = string;
	}
	public void createList() {
		System.out.println("Enter the rollno:");
		Scanner rn = new Scanner(System.in);
		rollno = rn.nextInt();
		System.out.println("Enter the name:");
		Scanner nm = new Scanner(System.in);
		name = rn.next();
		System.out.println("Enter the percentage:");
		Scanner pr = new Scanner(System.in);
		percentage = pr.nextDouble();
		System.out.println("Enter the skillset:");
		Scanner sk = new Scanner(System.in);
		skillset=sk.next();
	}
	public void printList() {
		System.out.println(rollno+" "+name+" "+percentage+" "+skillset);
	}
	public int getRollno() {
		return rollno;
	}
	public String getName() {
		return name;
	}
	public double getPercentage() {
		return percentage;
	}
	public Set<String> getSkillset() {
		return skillset;
	}
	public void setRollno() {
		this.rollno = rollno;
	}
	public void setName() {
		this.name=name;
	}
	public void setPercentage() {
		this.percentage=percentage;
	}
	public void setSkillset() {
		this.skillset = skillset;
	}
	class UtilityReport{
		private Map<String,Double>m;
	}
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		Scanner sc = new Scanner(System.in);
Student st = new Student(812,"Abhishek",95,"Python");
//st.display();
UtilityList ut = new UtilityList(812,"Abhishek",95,"Python");
//ut.createList();
//ut.printList();
List<Student> st1 = new ArrayList<>();
//st1.add(st);

while(true) {
	System.out.println("1. Add a record");
	System.out.println("2. Show all records");
	choice = sc.nextInt();
	switch(choice) {
	case 1:
		ut.createList();
		for(int i=0;i<st1.size();i++) {
			System.out.println(st1.get(i).name+" "+st1.get(i).percentage+" "+st1.get(i).rollno+" "+st1.get(i).skillset);
				}
		st1.add(st);
	case 2:
		ut.printList();
	}
}


}
}
