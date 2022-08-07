package org.najmin.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.najmin.javabrains.dto.UserDetails;
import org.najmin.javabrains.dto.Vehicle;

public class HibernateTest {
	
	public static void main(String args[])
	{
		UserDetails user=new UserDetails();
		user.setUserId(1);
		user.setUserName("Najmin");
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleId(1);
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleId(2);
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(vehicle2);
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}
