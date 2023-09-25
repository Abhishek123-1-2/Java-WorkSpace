package in.mindcraft.HibernateFetch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Alien {
	@Id
private int aid;
private String aname;
@OneToMany
private List<Laptop> lap = new ArrayList<Laptop>();
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public List<Laptop> getLap() {
	return lap;
}
public void setLap(List<Laptop> lap) {
	this.lap = lap;
}

}
