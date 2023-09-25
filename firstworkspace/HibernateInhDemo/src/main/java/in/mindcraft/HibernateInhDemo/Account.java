package in.mindcraft.HibernateInhDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="acctable")
public class Account {
	@Id
	@GeneratedValue
	@Column(name="AccountID")
private int accid;
	@Column(name="AccountName")
private String name;
	@Column(name="AccountBalance")
private double balance;
public int getAccid() {
	return accid;
}
public void setAccid(int accid) {
	this.accid = accid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

}
