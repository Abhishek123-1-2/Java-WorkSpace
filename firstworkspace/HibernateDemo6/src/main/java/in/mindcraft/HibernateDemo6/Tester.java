package in.mindcraft.HibernateDemo6;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Configuration con = new Configuration().configure();
ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf = con.buildSessionFactory(reg);
Session session = sf.openSession();
Transaction tx = session.beginTransaction();

Account a1 = new Account();
a1.setAccid(101);
a1.setName("Abhishek Pillai");
a1.setBalance(12000);
CurrentAccount ca = new CurrentAccount();
ca.setAccid(102);
ca.setName("Yash Gavanang");
ca.setBalance(9000);
ca.setOverlimit(5000);
SavingsAccount sa = new SavingsAccount();
sa.setAccid(103);
sa.setName("Om Rane");
sa.setBalance(6000);
sa.setInterestrate(3);
session.save(a1);
session.save(ca);
session.save(sa);
tx.commit();
	}

}
