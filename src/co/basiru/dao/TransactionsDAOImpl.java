package co.basiru.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import co.basiru.models.Transactions;

public class TransactionsDAOImpl implements TransactionsDAO {
	String status = "";
	private HibernateTemplate hibernateTemplate; 
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate; 
	}
	
//	@Autowired
//	private SessionFactory sessionFactory;

	@Override
	public String saveTransaction(Transactions transaction) {
		Integer in = (Integer)hibernateTemplate.save(transaction);
		if(in == transaction.getId()) {
			status = "Success";
		}else {
			status = "Failure";
		}
		return status;
	
/*		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(transaction!=null) {
			try {
				session.save(transaction);
				tx.commit();
				session.close();
				
			} catch (Exception ex) {
				tx.rollback();
				session.close();
				ex.printStackTrace();
			}
		}
		
*/
	}

	@Override
	public String displayTransaction(Transactions transaction) {
		return status;
		// TODO Auto-generated method stub

	}


}
