package in.mindcraft.HibernateDemo4;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	@Id
private int aid;
private AlienName aname;
private String color;
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}

public AlienName getAname() {
	return aname;
}
public void setAname(AlienName aname) {
	this.aname = aname;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}

}
