import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[][] = new int[3][3];
int b[][] =  new int[3][3];
System.out.println("Enter the elements of the array:");
Scanner sc = new Scanner(System.in);
for(int i=0;i<a.length;i++) {
	for(int j=0;j<a[i].length;j++) {
		a[i][j] = sc.nextInt();
	}
}
System.out.println("Original Matrix:");
for(int temp[]:a) {
	for(int val:temp) {
		System.out.print(val+" ");
	}System.out.println();
	
}
for(int i=0;i<a.length;i++) {
	for(int j=0;j<a[i].length;j++) {
		b[j][i]=a[i][j];
	}
}
System.out.println("The transpose of the matrix is:");
for(int temp[]:b) {
	for(int val:temp) {
		System.out.print(val+" ");
	}
	System.out.println();
}
	}

}
