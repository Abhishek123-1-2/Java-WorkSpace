package in.mindcraft.HibernateFetch;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import antlr.collections.List;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Configuration con = new Configuration().configure();
ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf = con.buildSessionFactory(reg);
Session session  = sf.openSession();
Transaction tx = session.beginTransaction();

Laptop l1 = new Laptop();
l1.setLid(101);
l1.setMake("Lenovo");
l1.setCost(28000);

Laptop l2 = new Laptop();
l2.setLid(102);
l2.setMake("Apple");
l2.setCost(89000);

Alien a1 = new Alien();
a1.setAid(101);
a1.setAname("Abhishek");
l1.setAlien(a1);
l2.setAlien(a1);
a1.getLap().add(l1);
a1.getLap().add(l2);
session.save(a1);
session.save(l1);
session.save(l2);

Collection<Laptop> laps = a1.getLap();
for(Laptop l:laps) {
	System.out.println(l);
}
tx.commit();
	}

}
