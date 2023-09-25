package in.mindcraft.HibernateDemo4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AlienName an = new AlienName();
an.setFname("Abhishek");
an.setMname("Manojkumar");
an.setMname("Pillai");
Alien al = new Alien();
al.setAid(12);
al.setAname(an);
al.setColor("Blue");

Configuration con = new Configuration().configure();
ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf = con.buildSessionFactory(reg);
Session session = sf.openSession();
Transaction tx = session.beginTransaction();
session.save(al);
tx.commit();

	}

}
