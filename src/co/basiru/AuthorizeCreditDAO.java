package co.basiru;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public interface AuthorizeCreditDAO {
	public static void saveCredit(AuthorizeCredit authCredit) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(authCredit);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}
	
	
	public String authorizeCredit(int id);
	public String deleteCredit(int id);
	List<AuthorizeCredit> getAuthorizeCredit();

}
