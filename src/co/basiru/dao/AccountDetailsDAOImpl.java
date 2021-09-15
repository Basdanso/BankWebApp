package co.basiru.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import co.basiru.models.AccountDetails;

public class AccountDetailsDAOImpl implements AccountDetailsDAO {
	String status = "";
	private HibernateTemplate hibernateTemplate; 
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate; 
	}
	
    @Transactional
    @Override
	public String saveAccdt(AccountDetails accountDetails) {
		Integer in = (Integer)hibernateTemplate.save(accountDetails);
		if(in == accountDetails.getId()) {
			status = "Success";
		}else {
			status = "Failure";
		}
		return status; 

	}
	
	
    @Transactional
	@Override
	public String updateAccdt(AccountDetails accountDetails) {
		hibernateTemplate.update(accountDetails);
		status = "success";
		return status;

	}
    @Transactional
	@Override
	public String deleteAccdt(int id) {
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setId(id);
		hibernateTemplate.delete(accountDetails);
		status = "Success";
		return status;
		

	}

	@Override
	public List<AccountDetails> getAccdt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String displayAccountDetails(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return null;
	}
}
