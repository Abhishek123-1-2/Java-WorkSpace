import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tran;
		int [][]a = new int [3][3];
		int [][]b = new int [3][3];
		int [][]c = new int [3][3];
		System.out.println("Enter elements for the array A:");
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for(int temp[]:a) {
        	for(int val:temp) {
        		System.out.print(val+"  ");
        	}
        	System.out.println();
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				b[j][i] = a[i][j];	
			}
		}
		System.out.println("Transpose matrix:");
		for(int []temp:b) {
        	for(int val:temp) {
        		System.out.print(val+"  ");
        	}
        	System.out.println();
		}
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				c[i][j] = a[i][j]+b[i][j];
		}
		}
		System.out.println("Addition of the matrix:");
		for(int []temp:c) {
        	for(int val:temp) {
        		System.out.print(val+"  ");
        	}
        	System.out.println();
		}
		
	}
}

