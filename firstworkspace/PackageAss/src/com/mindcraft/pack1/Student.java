package com.mindcraft.pack1;

public class Student {
private int Rollno;
private String Name;
public Student() {
	Rollno=101;
	Name="Abhishek";
}
public Student(int Rollno,String Name) {
	this.Rollno = Rollno;
	this.Name = Name;
}
public void display() {
	System.out.println(Rollno);
	System.out.println(Name);
}
}	
