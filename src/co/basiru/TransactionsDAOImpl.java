package co.basiru;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.SessionFactoryUtils;

import co.basiru.models.Transactions;

public class TransactionsDAOImpl implements TransactionsDAO {
	String status = "";
	private HibernateTemplate hibernateTemplate; 
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate; 
	}
	
	@Autowired
	private SessionFactoryUtils sessionFactory;

	public String saveTransaction(Transactions transaction) {
		Integer in = (Integer)hibernateTemplate.save(transaction);
		if(in == transaction.getId()) {
			status = "Success";
		}else {
			status = "Failure";
		}
		return status;
		

	}

	/*
	@Override
	public String displayTransaction(Transactions transaction) {
		return status;
		// TODO Auto-generated method stub

	}
*/
	@Override
	public String displayTransaction(co.basiru.models.Transactions transaction) {
		// TODO Auto-generated method stub
		return null;



}
	
}
