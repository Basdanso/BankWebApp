package co.basiru.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.basiru.configs.HibernateUtils;
import co.basiru.models.AccountDetails;

public interface AccountDetailsDAO {
//	public static String saveAccountDetails(AccountDetails accoubtDetails) {
//	
//		return null;
//	}
	
      public static void saveAccountDetails(AccountDetails accountDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(accountDetails);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

	
	
	
	public String displayAccountDetails(AccountDetails accountDetails);

	public String saveAccdt(AccountDetails accountDetails);
	public String updateAccdt(AccountDetails accountDetails);
	public String deleteAccdt(int id);
	List<AccountDetails> getAccdt();
}
