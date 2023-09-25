import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a[] = new int[5];
System.out.println("Enter the elements of the array:");
Scanner sc = new Scanner(System.in);
for(int i=0;i<a.length;i++) {
	a[i]=sc.nextInt();
}
int max=a[0];
for(int i=0;i<a.length;i++) {
	if(a[i]>max) {
		max=a[i];
	}
	
}
System.out.println("The maxium number is:"+max);

	}

}
