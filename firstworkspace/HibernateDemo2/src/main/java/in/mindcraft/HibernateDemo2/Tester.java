package in.mindcraft.HibernateDemo2;

import java.util.Collection;

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
		Transaction tx=session.beginTransaction();
		Laptop l3 = new Laptop();
		l3.setLid(106);
		l3.setMake("Apple Macbook air m1");
		l3.setCost(1000000);
				
		Student s1 = new Student();
		s1.setName("Abhishek");
		s1.setRollno(812);
		s1.setMarks(100);
		l3.getList().add(s1);
		
		Student s2 = new Student();
		s2.setName("Yash");
		s2.setRollno(816);
		s2.setMarks(94);
		l3.getList().add(s2);
		
		
		
		session.save(s1);
		session.save(l3);
		tx.commit();
		
		
		
		

	}
}
