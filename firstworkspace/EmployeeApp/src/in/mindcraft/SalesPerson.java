package in.mindcraft;

public class SalesPerson extends WageEmployee{
private int sales;
private int comm;
public SalesPerson() {
	super();
	sales=0;
	comm=0;
	System.out.println("SalesPerson Constructor");
}
public SalesPerson(int id,String n,int d,int m,int y,int h,int r,int s,int c) {
	super(id,n,d,m,y,h,r);
	sales = s;
	comm = c;
}
public void show() {
	super.show();
	System.out.println(sales);
	System.out.println(comm);
}
public int CalcSalary() {
	return super.CalcSalary()+sales*comm;

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
SalesPerson s1 = new SalesPerson(101,"Abhi",10,10,100,20,100,30,40);
s1.show();
	}

}
