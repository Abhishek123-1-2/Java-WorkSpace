package in.mindcraft.HibernateInhDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentAccount extends Account{
	
private double overlimit;

public double getOverlimit() {
	return overlimit;
}

public void setOverlimit(double overlimit) {
	this.overlimit = overlimit;
}

}
