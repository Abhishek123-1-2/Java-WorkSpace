package in.mindcraft.Just_Practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import in.mindcraft.Just_Practice.Laptop;
import in.mindcraft.Just_Practice.Student;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		s1.setFname("Abhishek");
		s1.setLname("Pillai");
		s1.setAge(21);
		s1.setRollno(812);
		Laptop l1 = new Laptop();
		l1.setLid(13);
		l1.setMake("HP ENVY 15");
		l1.setCost(130000);
		Configuration con = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(s1);
		session.save(l1);
		tx.commit();
	}

}
