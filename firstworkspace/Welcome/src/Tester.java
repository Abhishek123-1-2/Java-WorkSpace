import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		int a,b,c,average;
		// TODO Auto-generated method stub
Scanner a1 = new Scanner(System.in);
a = (int) a1.nextFloat();
Scanner b1 = new Scanner(System.in);
b= b1.nextInt();
Scanner c1 = new Scanner(System.in);
c= c1.nextInt();
average = (int) (a+b+c/3);
System.out.println("Average is"+average);
	}

}
