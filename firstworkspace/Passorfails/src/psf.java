import java.util.Scanner;

public class psf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
byte sub1_mark,sub2_mark,sub3_mark;
System.out.println("Enter your marks for subject 1");
Scanner sub_1 = new Scanner(System.in);
sub1_mark=sub_1.nextByte();
System.out.println("Enter your marks for subject 2");
Scanner sub_2 = new Scanner(System.in);
sub2_mark=sub_2.nextByte();
System.out.println("Enter your marks for subject 3");
Scanner sub_3 = new Scanner(System.in);
sub3_mark=sub_3.nextByte();
float total_percent = sub1_mark+sub2_mark+sub3_mark/3;
System.out.println(total_percent);
	}
}
