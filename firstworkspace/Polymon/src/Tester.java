abstract class  Polygon{
public abstract double calcArea();
public  abstract double calcPeri();
}
 class Circle extends Polygon{
	private int radius;
	public Circle() {
		radius=1;
	}
	public Circle(int r) {
		radius=r;
	}
	public double calcArea() {
		return 3.142*radius*radius;
		
	}
	public double calcPeri() {
		return 2*3.142*radius;
	}
}
class Rectangle extends Polygon{
	private int len,brd;
	public Rectangle() {
		len=brd=1;
	}
	public Rectangle(int l,int b) {
		len=l;
		brd=b;
	}
	public double calcArea() {
		return len*brd;
	}
	public double calcPeri() {
		return 2*(len+brd);
	}
	
}
class Square extends Rectangle{
	public Square() {
		
	}
	public Square(int s) {
		super(s,s);
	}
	public double calcArea() {
		return super.calcArea();
		
	}
	public double calcPeri() {
		return super.calcPeri();
	}
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Circle c1 = new Circle(3);
System.out.println("Area of circle:"+c1.calcArea());
System.out.println("Perimeter of circle:"+c1.calcPeri());
Rectangle r1 = new Rectangle(3,5);
System.out.println("Area of Rectangle:"+r1.calcArea());
System.out.println("Perimeter of Rectangle:"+r1.calcPeri());
Square s1 = new Square(3);
Rectangle s2 = new Square(5);
System.out.println("Area of square:"+s2.calcArea());
System.out.println("Perimeter of Square:"+s2.calcPeri());
	}

}

