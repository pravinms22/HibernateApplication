package com.scp.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

	public static SessionFactory factory=null;
	
	public static SessionFactory genarateFacrory() {
		
		if (null==factory)
		{
		 factory=new Configuration().configure().buildSessionFactory();
		}
		return factory;
	}
	
	
}
