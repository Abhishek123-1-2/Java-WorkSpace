package in.mindcraft;

public class Laptop{
private int lid;
private String make;
private double cost;
private static int cnt;
public Laptop() {
	lid=101;
	make="apple";
	cost=75000;
	cnt++;
}
public Laptop(int lid,String make,double cost) {
	this.lid=lid;
	this.make=make;
	this.cost=cost;
	cnt++;
}
public void show() {
	System.out.println(lid+"  "+make+"  "+cost);
}
public String toString() {
	return lid+" "+make+" "+cost;
}
public static void showCnt() {
	System.out.println("The count of the objects are:"+cnt);
}

}
