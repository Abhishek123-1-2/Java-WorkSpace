class Vehicle implements Cloneable{
	private int vnumber;
	private String vname;
	private double vprice;
	public Vehicle() {
		
	}
	public Vehicle(int vnumber,String vname,double vprice) {
		this.vnumber=vnumber;
		this.vname=vname;
		this.vprice=vprice;
	}
	public  Object clone() throws CloneNotSupportedException {
		return super.clone();
		
	}
	public void show() {
		System.out.println(vnumber+" "+vname+" "+vprice);
	}
}
public class Tester {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
Vehicle v=new Vehicle(102,"Volvo",1100000);
Vehicle v2 = (Vehicle)v.clone();
v2.show();
v.show();
	}

}
