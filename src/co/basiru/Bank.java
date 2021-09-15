package co.basiru;

import java.util.Date;

import javax.transaction.Transaction;

import co.basiru.models.Transactions;

public class Bank {
	private int id;
	private String acno;
	private static double balance;
	private String username;
	


	public Bank() {
		
	}
	
	
	public Bank(int id, String acno, double balance) {
		super();
		this.id = id;
		this.acno = acno;
		this.balance = balance;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAcno() {
		return acno;
	}


	public void setAcno(String acno) {
		this.acno = acno;
	}
	

	public static double getBalance() {
		return balance;
	}
	

	public void setBalance(double balance) {
		Bank.balance = balance;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	@Override
	public String toString() {
		return "Bank [id=" + id + ", acno=" + acno + ", balance=" + balance + " username= "+ username+ "]";
	}
	
	
//	public static Bank getAccountDetails(String acno) {
//		return((getAccountDetails("acno")));
//	}



	public void deposit() {
		System.out.println("Inside Generic deposit");
	}
	public void withdraw() {
		System.out.println("Inside generic withdraw");
	}
	public static void transfer() {
		System.out.println("Inside Generic transfer");
	}
	
/*	
	public void deposit(String acno, float amnt) {
		System.out.println("Rs. "+amnt+" deposited in A/C. "+acno);
	}
	
	public void withdraw() {
		System.out.println("Inside Generic deposit");
	}
	public void withdraw(String acno, float amnt) {
		System.out.println("Rs. "+amnt+" withdrawal from A/C. "+acno);
	}
*/	
	public void log() {
		System.out.println("Log: method invocation - "+new Date());
	}

	public double deposit( double amount) {
		if (amount < 0) {
			System.out.println("Deposit amount is Zero");
		}
		else
			balance = balance + amount;
		return balance;
	}
	
	public double withdraw (double amount) {
		if(amount < 0) {
			System.out.println("Withdraw amount is Zero");
		}
		else
		if (amount > balance){
			System.out.println("withdrawal amount Exceed balance, Insufficent fund");
		}
		else
			balance = balance - amount;
		return balance;
	}

	
	
  	
	public void transfer(double amount, Bank acno) {
		
		if (balance < amount) {
			System.out.println("Transfer failed");
		}
		else {
			balance -= amount;  // convert this equation for 
			balance += amount;
		//	Transactions.setBalance(Transactions.getBalance() + balance);   // the debit from button
			System.out.println("Account of " +this.acno + " becomes $" + amount);
			System.out.println("Account of " + Transactions.getAcno() + " becomes $" + balance);
		}
		
		
	}


	public static Bank getAccountDetails(String acno) {
		// TODO Auto-generated method stub
		return ((Bank)AccountDetails.get(acno));
	}
	

    
	
/*
	public static void transfer(Bank acnoFrm,  Bank acnoTo, double amount) {
		
//		acnoFrm.withdraw(amount);
//		acnoTo.deposit(amount);
		Bank.transfer(acnoFrm, acnoTo, amount);
	}
		
*/
	}



