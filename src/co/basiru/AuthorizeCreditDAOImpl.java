package co.basiru;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class AuthorizeCreditDAOImpl implements AuthorizeCreditDAO {
	
	String status = "";
	private HibernateTemplate hibernateTemplate; 
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate; 
	}

	@Transactional
	public String saveCredit(AuthorizeCredit authCredit) {
		Integer in = (Integer)hibernateTemplate.save(authCredit);
		if(in == authCredit.getId()) {
			status = "Success";
		}else {
			status = "Failure";
		}
		return status;
	}

	@Override
	public String authorizeCredit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCredit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AuthorizeCredit> getAuthorizeCredit() {
		// TODO Auto-generated method stub
		return null;
	}

}
