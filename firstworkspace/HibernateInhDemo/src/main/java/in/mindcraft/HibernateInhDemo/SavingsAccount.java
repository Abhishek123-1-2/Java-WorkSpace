package in.mindcraft.HibernateInhDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SavingsAccount extends Account{
	
private int interestRate;

public int getInterestRate() {
	return interestRate;
}

public void setInterestRate(int interestRate) {
	this.interestRate = interestRate;
}

}
