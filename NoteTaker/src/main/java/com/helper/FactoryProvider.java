package com.helper;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

	public static SessionFactory factory;
	
	
	//Static method so we call it without an object
	public static SessionFactory getfactory()
	{
		//Create new factory if factory is null
		if(factory==null) {
		
			factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		}
		return factory;
	}
	
	//Close factory method
	public void closefactory() {
		//if factory is Open and want to close it that time we can use it
		if (factory.isOpen()) {
			
			factory.close();
		}
	}
}
 