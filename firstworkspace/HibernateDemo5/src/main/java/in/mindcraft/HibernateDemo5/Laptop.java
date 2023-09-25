package in.mindcraft.HibernateDemo5;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Laptop {
	@Id
private int lid;
private String make;
private double cost;
@ManyToMany
private List<Student> stu = new ArrayList<Student>();
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
public List<Student> getStu() {
	return stu;
}
public void setStu(List<Student> stu) {
	this.stu = stu;
}



}
