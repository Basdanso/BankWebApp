package co.basiru;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.basiru.models.Transactions;

public interface TransactionsDAO {
	public static void saveTransaction(co.basiru.Transactions transactions) {
	       Transaction transaction = null;
	        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.save(transactions);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	}
	
	
	
	
	public String displayTransaction(Transactions transaction);

}
