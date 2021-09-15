package co.basiru.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import co.basiru.Bank;

import java.util.Date;

@Entity
@Table(name = "Transaction", schema = "edureka")
public class Transactions {
	private int id;
	private static String acno;
	private double amount;
	private double balance;
	private Date date;
	
	public Transactions () {
		
	}
	

	public Transactions(int id, String acno, double amount, double balance, String date) {
		super();
		this.id = id;
		this.acno = acno;
		this.amount = amount;
		this.balance = balance;
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
	public static String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	
	@Column(name = "amount", length = 25)
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Column(name = "balance", length = 5)
	public  double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "Date", length = 25)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Transaction [id=" + id + ", acno=" + acno + ", amount=" + amount
				+ ", balance=" + balance + ", date=" + date + "]";
	}


	public void saveTransaction(Transactions transactions) {
		
		
	}
		
		
	
	

	public void displayTransaction(Transactions transactions) {
		
	}
	
		
	
	
	

}
