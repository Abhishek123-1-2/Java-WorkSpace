package in.mindcraft.HibernateDemo6;

import javax.persistence.Entity;


@Entity
public class SavingsAccount extends Account{
	
private int interestrate;

public int getInterestrate() {
	return interestrate;
}

public void setInterestrate(int interestrate) {
	this.interestrate = interestrate;
}

}
