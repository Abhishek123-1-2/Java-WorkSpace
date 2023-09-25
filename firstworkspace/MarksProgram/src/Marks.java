import java.util.Scanner;

public class Marks {

	public static void main(String[] args) {
	int phy_score,comp_score,math_score,chem_score,bio_score;
		// TODO Auto-generated method stub
System.out.println("Enter Physics Score:");
Scanner phy = new Scanner(System.in);
phy_score = phy.nextInt();
System.out.println("Enter Computer Score:");
Scanner comp = new Scanner(System.in);
comp_score = comp.nextInt();
System.out.println("Enter Math Score:");
Scanner math = new Scanner(System.in);
math_score = math.nextInt();
System.out.println("Enter Chemistry Score:");
Scanner chem = new Scanner(System.in);
chem_score = chem.nextInt();
System.out.println("Enter Biology Score:");
Scanner bio = new Scanner(System.in);
bio_score = bio.nextInt();
float total_score = (float) (((phy_score+comp_score+math_score+chem_score+bio_score)/500.0)*100);
System.out.println(total_score);
	}

}
