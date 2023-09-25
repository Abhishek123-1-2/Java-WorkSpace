import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Vehicle implements Comparable<Vehicle>{
	private int number;
	private String name;
	private int price;
	public Vehicle() {
		number=101;
		name="Toyota";
		price=1500000;
	}
	public Vehicle(int number,String name,int price) {
		this.number = number;
		this.name= name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Vehicle [number=" + number + ", name=" + name + ", price=" + price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, number, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(name, other.name) && number == other.number && price == other.price;
	}
	@Override
	public int compareTo(Vehicle o) {
		// TODO Auto-generated method stub
		if(this.price<o.price) {
			return -1;
		}else if(this.price>o.price) {
			return 1;
		}else
			return 0;
	}
	public int getPrice() {
		return price;
	}
	
}
class VehicleCompare implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		// TODO Auto-generated method stub
		if(o1.getPrice()<o2.getPrice()) {
			return -1;
		}else if(o1.getPrice()>o2.getPrice()) {
			return 1;
		}else
		return 0;
	}
	
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Set<Vehicle> set = new TreeSet<>();
set.add(new Vehicle(101,"Toyota",120000));
set.add(new Vehicle(102,"Mercedes",1400000));
set.add(new Vehicle(103,"Lamborghini",12000000));
System.out.println(set);
VehicleCompare v1 = new VehicleCompare();
List<Vehicle> list = new ArrayList<>();
list.add(new Vehicle(101,"Toyota",120000));
list.add(new Vehicle(102,"Mercedes",1400000));
list.add(new Vehicle(103,"Lamborghini",12000000));
System.out.println(list);
Collections.sort(list,v1);
	}

}
