package in.mindcraft.EmployeeDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Adress a1 = new Adress();
a1.setCity("Mumbai");
a1.setState("Maharashtra");
a1.setStreet("Andheri");
Employee e1 = new Employee();
e1.setEmpid(13);
e1.setName("Abhishek");
e1.getList().add(a1);

Configuration con = new Configuration().configure();
ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf = con.buildSessionFactory(reg);
Session session = sf.openSession();

Transaction tx=session.beginTransaction();

session.save(e1);
session.save(a1);
tx.commit();


	}

}
