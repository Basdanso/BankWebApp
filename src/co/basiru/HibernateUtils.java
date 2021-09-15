package co.basiru;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
/*	
	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration();
		config.configure("co/basiru/configs/hibernate.cfg.xml");
		
		SessionFactory sfactory = config.buildSessionFactory();
		return sfactory;
	}
*/
	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration();
		config.configure("co/basiru/configs/hibernate.cfg.xml");
		
		SessionFactory sfactory = config.buildSessionFactory();
		// TODO Auto-generated method stub
		return sfactory;
	}

}
