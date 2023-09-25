class Laptop{
private int lid;
private String make;
private double cost;
public Laptop() {
	lid=101;
	make="apple";
	cost=75000;
}
public Laptop(int lid,String make,double cost) {
	this.lid=lid;
	this.make=make;
	this.cost=cost;
	
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public String getMake(String make) {
	return make;
}
public void setMake(String make) {
	this.make=make;
}
public double setCost(double cost) {
	return cost;
}
public double getCost() {
	return cost;
}
public void show() {
	System.out.println(lid+"  "+make+"  "+cost);
}
public String toString() {
	return lid+" "+make+" "+cost;
}
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Laptop l1 = new Laptop(102,"Lenovo",74000);
		System.out.println(l1.getCost());
		l1.setCost(550000);
		l1.show();
		System.out.println(l1);

	}

}
