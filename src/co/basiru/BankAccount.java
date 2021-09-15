package co.basiru;

public class BankAccount {
	private String acno;
	int balance;
	int minBal;
	int attempts;
	
	
	BankAccount() {
		balance = 1000;
		minBal = 500;
		attempts = 0;
		System.out.println("bank acc created, initial balance"+ balance);
	}
	
	void withdraw (int amount) {
		
		balance -= amount; // balance = balance - amaount;
		
		if(balance >= minBal) {
			balance += amount;
			System.out.println("Insufficient Fund");
			attempts ++;
		}else {
		
		   System.out.println( amount + "withdrawn. New balance is: " +  balance);
		}
		
		// Give user 3 attempts
		if(attempts == 3) {
			ArithmeticException aRef = new ArithmeticException("Illegal Attempts:" + attempts);
			throw aRef;  // Explecit throw error to crash program.
		}
	}
	
	void deposit (int amount) {
		
		balance += amount;
	}
	
	
	
	//Transfer fund
	public void transferFunds(BankAccount destination, int amount) {
		
		destination.balance = destination.balance + amount;
		this.balance = this.balance - amount;
		
		  System.out.println( amount + "transferred. New balance is: " +  balance);
		
	}



}
