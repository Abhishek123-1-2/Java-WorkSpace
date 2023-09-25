import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
float income_slab;
System.out.println("Enter the income slab");
Scanner inc = new Scanner(System.in);
income_slab = inc.nextFloat();
if (income_slab>=2.5f||income_slab<=5.0f) {
	System.out.println("Tax is 5%");
}else if(income_slab>=5.0f||income_slab<=10.0f){
System.out.println("Tax is 20%");	
}else if(income_slab>10.0f) {
	System.out.println("Tax is 30%");
}
	}

}
