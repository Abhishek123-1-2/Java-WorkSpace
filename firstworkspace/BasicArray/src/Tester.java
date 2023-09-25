import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[][] = new int [3][3];
Scanner sc = new Scanner(System.in);
for(int i=0;i<a.length;i++) {
	for(int j=0;j<a.length;j++) {
	a[i][j] = sc.nextInt();
}
	}
for(int temp[]:a) {
	for(int val:temp) {
		System.out.print(val);
	}
	System.out.println();
}

}
}
