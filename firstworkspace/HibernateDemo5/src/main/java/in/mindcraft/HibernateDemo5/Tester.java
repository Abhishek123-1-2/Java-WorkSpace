package in.mindcraft.HibernateDemo5;

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
		l1.setLid(101);
		l1.setMake("Lenovo");
		l1.setCost(12000);
		
		Laptop l2 = new Laptop();
		l2.setLid(102);
		l2.setMake("Apple");
		
Student s1 = new Student();
s1.setName("Abhishek");
s1.setMarks(98);
s1.setRollno(812);
s1.getLap().add(l1);
l1.getStu().add(s1);
Student s2 = new Student();
s2.setName("Yash");
s2.setMarks(91);
s2.setRollno(811);
l2.setCost(120000);
s2.getLap().add(l1);
l2.getStu().add(s1);






Configuration con = new Configuration().configure();
ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf = con.buildSessionFactory(reg);
Session session = sf.openSession();
Transaction tx = session.beginTransaction();

session.save(s1);
session.save(l1);
session.save(l2);

tx.commit();


	}

}
