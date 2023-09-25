package in.mindcraft.HibernateInhDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Account a1 = new Account();
//a1.setAccid(181);
a1.setName("Bank Account HDFC");
a1.setBalance(26000);
CurrentAccount c1 = new CurrentAccount();
//c1.setAccid(182);
c1.setOverlimit(30000);
SavingsAccount s1 = new SavingsAccount();
//s1.setAccid(183);
s1.setInterestRate(5);

Configuration con = new Configuration().configure();
ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf = con.buildSessionFactory(reg);
Session session = sf.openSession();

Transaction tx=session.beginTransaction();
session.save(a1);
session.save(c1);
session.save(s1);
tx.commit();
	}

}
