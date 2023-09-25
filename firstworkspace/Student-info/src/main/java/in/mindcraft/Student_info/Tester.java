package in.mindcraft.Student_info;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
@SuppressWarnings("deprecation")
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Student1 s1 = new Student1();
s1.setFname("Abhishek");
s1.setLname("Pillai");
s1.setRollno(812);
Laptop l1 = new Laptop();
l1.setLid(13);
l1.setMake("HP Envy 15");
l1.setCost(28000);

Configuration con = new Configuration().configure();
ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf = con.buildSessionFactory(reg);
Session session = sf.openSession();
	}

}
