class MyMath<G>{
	public void Swap(G a,G b) {
		G temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println(a+" "+b);
	}
}
class Laptop<U>{
	public void Swap2(U a,U b) {
	U temp;
	temp=a;
	a=b;
	b=temp;
	System.out.println(a+" "+b);
	}
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
MyMath<Integer> m1 = new MyMath<>();
m1.Swap(10,20);

MyMath <String>m2  = new MyMath<>();
m2.Swap("Abhishek","Pillai");
Laptop <String>l1 = new Laptop<>();
l1.Swap2("Lenovo", "HP");

	}

}
