package in.mindcraft.HibernateFetch;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
private int lid;
private String make;
private double cost;
@ManyToOne
private Alien alien;
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
public Alien getAlien() {
	return alien;
}
public void setAlien(Alien alien) {
	this.alien = alien;
}
@Override
public String toString() {
	return "Laptop [lid=" + lid + ", make=" + make + ", cost=" + cost + ", alien=" + alien + "]";
}

}
