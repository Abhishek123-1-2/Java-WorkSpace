import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[][] = new int[2][3];
int b[][] = new int[2][3];
int sum = 0;
System.out.println("Enter the elements of the Array 1:");
Scanner sc  = new Scanner(System.in);
for(int i=0;i<a.length;i++) {
	for(int j=0;j<a[i].length;j++) {
		a[i][j] = sc.nextInt();
	}
}
for(int temp[]:a) {
	for(int val:temp) {
		System.out.print(val+" ");
	}
	System.out.println();
}
System.out.println("Enter the elements of Array 2");
for(int i=0;i<a.length;i++) {
	for(int j=0;j<a[i].length;j++) {
		b[i][j] = sc.nextInt();
	}
}
for(int temp[]:b) {
	for(int val:temp) {
		System.out.print(val+" ");
	}
	System.out.println();
}
for(int i=0;i<a.length;i++) {
	for(int j=0;j<a[i].length;j++) {
		sum = a[i][j]+b[i][j];
		System.out.println("The addition of array 1 and array 2 is:"+sum);
	}
	System.out.println(sum);
}
}
}