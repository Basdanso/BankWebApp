package co.basiru.configs;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

public class HibernateUtils {
/*	
	public static SessionFactory getSessionFactory() {
		Configuration config = new Configuration();
		config.configure("co/basiru/configs/hibernate.cfg.xml");
		
		SessionFactory sfactory = config.buildSessionFactory();
		return sfactory;
	}
*/
	public static SessionFactory getSessionFactory() { // I change type of session to SessionFactory, any error undo once.
		Configuration config = new Configuration();
		config.configure("co/basiru/configs/hibernate.cfg.xml");
		
		SessionFactory sfactory = config.buildSessionFactory();
		// TODO Auto-generated method stub
		return sfactory;
	}

}
