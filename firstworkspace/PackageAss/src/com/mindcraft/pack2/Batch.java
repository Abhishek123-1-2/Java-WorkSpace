package com.mindcraft.pack2;

public class Batch {
private String CourseName;
private int BatchStrength;
public Batch(String CourseName,int BatchStrength) {
this.CourseName = CourseName;
this.BatchStrength = BatchStrength;
}
public void display() {
	System.out.println(CourseName);
	System.out.println(BatchStrength);
}
	

}
