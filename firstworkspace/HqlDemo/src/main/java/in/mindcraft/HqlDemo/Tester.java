package in.mindcraft.HqlDemo;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//MobilePhone m1 = new MobilePhone(101,"Iphone",120000);
//MobilePhone m2 = new MobilePhone(102,"Samsung",19000);
//MobilePhone m3 = new MobilePhone(103,"Nokia",17000);
//MobilePhone m4= new MobilePhone(104,"Xiamoi",21000);

Configuration con = new Configuration().configure();
ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
SessionFactory sf = con.buildSessionFactory(reg);
Session session = sf.openSession();
//MobilePhone m = (MobilePhone) session.get(MobilePhone.class, 102);
//System.out.println("Details of Mobile:"+m);
Transaction tx=session.beginTransaction();

Query query =  session.createQuery("from MobilePhone");
List<MobilePhone> mlist = query.list();
for(MobilePhone m:mlist) {
	System.out.println(m);
}
//session.save(m1);
//session.save(m2);
//session.save(m3);
//session.save(m4);
tx.commit();
	}

}
