package in.mindcraft.HibernateAssignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MobilePhone {
	@Id
private int mid;
private String make;
private double cost;
public MobilePhone(int mid, String make, double cost) {
	super();
	this.mid = mid;
	this.make = make;
	this.cost = cost;
}
public MobilePhone() {
	
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}
@Override
public String toString() {
	return "MobilePhone [mid=" + mid + ", make=" + make + ", cost=" + cost + "]";
}


}
