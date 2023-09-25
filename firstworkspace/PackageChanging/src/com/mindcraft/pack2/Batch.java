package com.mindcraft.pack2;

public class Batch {
String CourseName;
int BatchStrength;
public Batch(String CourseName,int BatchStrength) {
	this.CourseName = CourseName;
	this.BatchStrength = BatchStrength;
}
public void display() {
	System.out.println(CourseName+" "+BatchStrength);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
