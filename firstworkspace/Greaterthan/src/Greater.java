import java.util.Scanner;

public class Greater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int given_number=100,user_entered_number;
System.out.println("Enter the number:");
Scanner gn = new Scanner(System.in);
user_entered_number = gn.nextInt();
if(given_number<user_entered_number) {
	System.out.println("Given number is greater then the user entered number");
}else {
	System.out.println("Given number is not greater than the user entered number");
}
	}

}
