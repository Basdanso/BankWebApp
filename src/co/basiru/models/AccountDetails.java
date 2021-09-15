package co.basiru.models;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import co.basiru.configs.HibernateUtils;

@Entity
@Table(name= "accountdetails", schema="edureka")
public class AccountDetails {
	
	private int id;
	private String acno;
	private String name;
	private String dob;
	private String address;
	private String email;
	private String accType;
	
	public AccountDetails(){
		
	}

	public AccountDetails(int id, String name, String dob, String address, String email, String accType) {
		super();
		this.id= id;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.accType = accType;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 5)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
    
	@Column(name = "acno", length = 5)
	public String getAcno() {
		return acno;
	}

	public void setAcno(String acno) {
		this.acno = acno;
	}

	@Column(name = "name", length = 5)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "dob", length = 5)
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name = "address", length = 5)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "email", length = 25)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "accType", length = 3)
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", acno=" + acno + ", name=" + name + ", dob=" + dob + ", address=" + address + ", email="+ email + ", accType=" + accType +"]";
	}

	public void saveAccdt(AccountDetails accountDetails) {
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
	
	

}
