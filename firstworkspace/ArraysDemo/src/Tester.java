import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = new int[5];
		float [] c = new float[5];
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter five floats");
		for (int i=0;i<c.length;i++)
			c[i]=sc.nextFloat();
		for(int i=0;i<c.length;i++)
			System.out.print(c[i]+" ");
		for(float val:c)
			System.out.println(val+"  ");
		
			
		
	}

}
//System - It is a class
//out - It is a static reference of class PrintStream
//println - method of class print