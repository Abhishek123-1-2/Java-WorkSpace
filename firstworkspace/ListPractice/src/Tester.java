import java.util.ArrayList;
import java.util.List;

class Laptop{
	private int Lid;
	private String L_model;
	private String L_name;
	public Laptop() {
		Lid = 101;
		L_model = "HP101";
		L_name = "HP";
	}
	public Laptop(int Lid,String L_model,String L_name) {
		this.Lid = Lid;
		this.L_model = L_model;
		this.L_name = L_name;
		
	}
	public void display() {
		System.out.println(Lid+" "+L_model+" "+L_name);
	}
	
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Laptop> list = new ArrayList<>();
		list.add(new Laptop(101,"HP101","HP"));
		list.add(new Laptop(101,"HP101","HP"));
		list.add(new Laptop(101,"HP101","HP"));
		System.out.println(list);
		

	}

}
