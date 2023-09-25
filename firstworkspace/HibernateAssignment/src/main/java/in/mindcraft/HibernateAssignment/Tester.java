package in.mindcraft.HibernateAssignment;


import java.util.List;
import java.util.Scanner;

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
		Configuration con = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session session = sf.openSession();

		Transaction tx=session.beginTransaction();
int choice;
Scanner sc = new Scanner(System.in);
while (true){
	System.out.println("1.Add a Mobile Phone");
	System.out.println("2.Read a Mobile Phone");
	System.out.println("3.Update a Mobile Phone");
	System.out.println("4.Delete a Mobile Phone");
	choice = sc.nextInt();
	switch(choice) {
	case 1:
		System.out.println("Enter the Mobile Id,Mobile Make,and Cost");
		MobilePhone m1 = new MobilePhone();
		int mid = sc.nextInt();
		String make = sc.next();
		double cost = sc.nextDouble();
		m1.setMid(mid);
		m1.setMake(make);
		m1.setCost(cost);
		session.save(m1);
		tx.commit();
	case 2:
		Query query =  session.createQuery("from MobilePhone");
		List<MobilePhone> mlist = query.list();
		for(MobilePhone m:mlist) {
			System.out.println(m);
		}
		break;
	case 3:
		System.out.println("Enter the Mobile ID to update:");
		int updateId = sc.nextInt();
		sc.nextLine();
		
		MobilePhone updateMobile = (MobilePhone) session.get(MobilePhone.class,updateId);
		
		if(updateMobile!=null) {
			System.out.println("Enter updated Make:");
			String updatedMake = sc.next();
			System.out.println("Enter updated Cost:");
			double updatedCost = sc.nextDouble();
			updateMobile.setMake(updatedMake);
			updateMobile.setCost(updatedCost);
			
			System.out.println("Mobile Phone Updated");
			session.save(updateMobile);
			tx.commit();
			
		}else {
			System.out.println("Mobile Phone not found");
		}
		break;
	case 4:
		System.out.println("Enter the mobile Id that you want to delete");
		int deleteId = sc.nextInt();
		sc.nextLine();
		
		MobilePhone deleteMobile = (MobilePhone) session.get(MobilePhone.class, deleteId);
		
		if(deleteMobile!=null) {
			session.delete(deleteId);
			
			System.out.println("Mobile Phone has been deleted");
			tx.commit();
		}else {
			System.out.println("Mobile Phone not found");
		}
		break;
	case 0:
		System.out.println("Exiting....");
		break;
	default:
		System.out.println("Invalid choice please select a valid option");
		tx.commit();


	
		
	}
	
}
	}

}
