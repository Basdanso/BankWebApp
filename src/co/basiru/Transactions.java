package co.basiru;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "transactions", schema = "edureka")
public class Transactions {
	private int id;
	private String acno;
	private String amount;
	private String balance;
	private String TrnsDate;
	
	
	public Transactions () {
		
	}
	

	public Transactions(int id, String acno, String amount, String balance, String TrnsDate) {
		super();
		this.id = id;
		this.acno = acno;
		this.amount = amount;
		this.balance = balance;
		this.TrnsDate = TrnsDate;
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
	
	@Column(name = "amount", length = 25)
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	@Column(name = "balance", length = 25)
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "Date", length = 25)
	public String getDate() {
		return TrnsDate;
	}


	public String setDate(String trnsDate) {
	
		return trnsDate;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", acno=" + acno + ", amount=" + amount
				+ ", balance=" + balance + ", date=" + TrnsDate + "]";
	}
	
	

	public void saveTransaction(Transactions transactions) {
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
		
		
		

}
