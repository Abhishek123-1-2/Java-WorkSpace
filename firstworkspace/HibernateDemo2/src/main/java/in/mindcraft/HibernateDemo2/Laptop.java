package in.mindcraft.HibernateDemo2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@javax.persistence.Entity
public class Laptop {
	@javax.persistence.Id
private int lid;
private String make;
private double cost;

@OneToMany
private List<Student> list = new ArrayList<Student>();

public List<Student> getList() {
	return list;
}
public void setList(List<Student> list) {
	this.list = list;
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
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

}
