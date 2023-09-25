package circle;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
float radius,pi=(float) 3.142,area;
System.out.println("Enter the radius of the circle:");
Scanner sc = new Scanner(System.in);
radius = sc.nextFloat();
area=pi*radius*radius;
System.out.println("Radius of the circle is:"+area);

	}

}
