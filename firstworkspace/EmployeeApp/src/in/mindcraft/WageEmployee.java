package in.mindcraft;

public  class WageEmployee extends Employee {
protected int hours;
protected int rate;
public WageEmployee() {
	hours=0;
	rate = 0;
	System.out.println("WageEmployee Constructor");
}
public WageEmployee(int id,String n,int d,int m,int y,int h,int r) {
super(id,n,d,m,y);
hours=h;
rate=r;
}
public void show() {
	super.show();
	System.out.println(hours);
	System.out.println(rate);
}
public int CalcSalary() {
	return hours*rate;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
