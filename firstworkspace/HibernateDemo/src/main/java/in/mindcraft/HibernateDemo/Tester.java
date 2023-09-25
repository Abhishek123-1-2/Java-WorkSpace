package in.mindcraft.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Laptop l1 = new Laptop();
l1.setLid(13);
l1.setMake("HP Omen");
l1.setCost(12000);

Laptop l2 = new Laptop();
l2.setLid(14);
l2.setMake("MSI Bravo");
l2.setCost(79990);
Student s1 = new Student();
s1.setName("Rukmani");
s1.getName();
s1.setRollno(812);
s1.getRollno();
s1.getList().add(l1);
s1.getList().add(l2);
l1.getList().add(s1);
Student s2 = new Student();
s2.setName("Abhishek");
s2.setRollno(125);
s2.getList().add(l1);
s2.getList().add(l2);
l1.getList().add(s2);




Configuration con = new Configuration().configure();
ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf = con.buildSessionFactory(reg);
Session session = sf.openSession();

Transaction tx=session.beginTransaction();
session.save(s1);
session.save(s2);
session.save(l1);
session.save(l2);
tx.commit();
	}

}
