package co.basiru;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import co.basiru.configs.HibernateUtils;

public class UserDAOImpl implements UserDAO {
	String status = "";
	private HibernateTemplate hibernateTemplate; 
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate; 
	}
	
    @Transactional
	@Override
	public String saveUsr(User usr) {
		Integer in = (Integer)hibernateTemplate.save(usr);
		if(in == usr.getId()) {
			status = "Success";
		}else {
			status = "Failure";
		}
		return status; 

	}
	
    @Transactional
	@Override
	public String updateUsr(User usr) {
		hibernateTemplate.update(usr);
		status = "success";
		return status;

	}
    @Transactional
	@Override
	public String deleteUsr(int id) {
		User usr = new User();
		usr.setId(id);
		hibernateTemplate.delete(usr);
		status = "Success";
		return status;
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUser() {
		Transaction transaction = null;
		List <User> users = null;
		try(Session session = HibernateUtils.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			users = session.createQuery("from User").list();
		//	user = session.load(User.class,  id);
			
			transaction.commit();
		}catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return users;
		

}
}
