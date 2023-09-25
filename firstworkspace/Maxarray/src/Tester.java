import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter five numbers:");
		for(int i=0;i<a.length;i++)
			a[i] = sc.nextInt();
		int min = a[0];
		for(int i=1;i<a.length;i++)
			if (a[i]<min) {
				min=a[i];
			}
		System.out.println("Maximum value"+min);
	}

}
