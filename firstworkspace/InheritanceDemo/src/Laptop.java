
public class Laptop extends Student{
private int lid;
private String make;
private double cost;
public Laptop(int rollno,String name,String section) {
	super(rollno,name,section);
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
public void display() {
	
	System.out.println(lid+" "+make+" "+cost);
}

}
