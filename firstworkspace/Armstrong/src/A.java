import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n,arm=0,rem,c;
System.out.println("Enter any number");
Scanner sc = new Scanner(System.in);
n = sc.nextInt();
c=n;
while(n>0) {
	rem=n%10;
arm = rem*rem*rem+arm;
n=n/10;
}
if(c==arm) {
	System.out.println("The number is an armstrong number");
}
else {
	System.out.println("The number is not an amrstrong number");
}
	}

}
