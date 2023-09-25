import java.util.Objects;
import java.util.*;

class Laptop implements Comparable<Laptop>{
	private int lid;
	private String make;
	private double cost;
	public Laptop() {
		lid = 101;
		make = "apple";
		cost=75000;
	}
	public Laptop(int lid,String make,double cost) {
		this.lid = lid;
		this.make=  make;
		this.cost = cost;
	}
	public void show() {
		System.out.println(lid+" "+make+" "+cost);
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", make=" + make + ", cost=" + cost + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(cost, lid, make);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && lid == other.lid
				&& Objects.equals(make, other.make);
	}
	@Override
	public int compareTo(Laptop o) {
		// TODO Auto-generated method stub
		if(this.lid<o.lid) {
			return -1;
		}else if(this.lid>o.lid) {
			return 1;
		}
		else
		return 0;
	}
	public int getLid() {
		return lid;
	}
	
}
class LaptopCompare implements Comparator<Laptop>{

	@Override
	public int compare(Laptop o1, Laptop o2) {
		// TODO Auto-generated method stub
		if(o1.getLid()<o2.getLid()) {
			return -1;
		}else if(o1.getLid()>o2.getLid()) {
			return 1;
		}else
		return 0;
	}
	
}
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Set<Laptop> set = new TreeSet<>();
set.add(new Laptop(101,"Lenovo",1000000));
set.add(new Laptop(102,"Asus",10000));
set.add(new Laptop(103,"HP",12000));
set.add(new Laptop(104,"Apple",9000));
System.out.println(set);
List<Laptop> list = new ArrayList<>();
list.add(new Laptop(101,"Lenovo",1000000));
list.add(new Laptop(102,"Asus",10000));
list.add(new Laptop(103,"HP",12000));
list.add(new Laptop(104,"Apple",9000));
System.out.println(set);
Collections.sort(list,new LaptopCompare());
System.out.println(list);
	}

}
