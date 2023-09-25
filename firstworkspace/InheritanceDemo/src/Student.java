
public class Student {
private int rollno;
private String name;
private String section;
public Student(int rollno, String name, String section) {
	super();
	this.rollno = rollno;
	this.name = name;
	this.section = section;
}
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSection() {
	return section;
}
public void setSection(String section) {
	this.section = section;
}
public void display() {
	System.out.println(rollno+" "+name+" "+section);
}
}
