package co.basiru;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//		UserDAO dao = (UserDAO)context.getBean("Usrdao");
//		Bank bank = (Bank)context.getBean("bank");
//		TransactionsDAO dao = (TransactionsDAO)context.getBean("trnsdao");
//		AccountDetailsDAO dao = (AccountDetailsDAO)context.getBean("accdtdao");
		AuthorizeCreditDAO dao = (AuthorizeCreditDAO)context.getBean("authCreditdao");
/*		
		Bank tom = new Bank();
		tom.deposit(500.0);
		Bank sandy = new Bank();
		sandy.deposit(200.0);
//		tom.transfer(100, sandy);
		sandy.withdraw(50.0);
		sandy.withdraw(600.0);
		System.out.println(sandy.getBalance());
*/
		
//		bank.deposit(); // Includes log method
/*		
		Bank bank1 = new Bank();
		bank1.setAcno(123);
		bank1.setBalance(0);
		
		bank1.deposit();
		bank1.deposit(500.0);
*/
/*
		Bank bank11 = new Bank();
		bank11.setAcno(899);
		bank11.deposit(100);
		bank1.transfer(200.0, bank11);
		bank11.withdraw(50.0);
		bank11.withdraw(500.0);
		System.out.println(bank11.getBalance());
	//	bank.deposit("SBIN10015", 2500f);
//		bank.withdraw("SBIN10015", 1000f);
*/
		/*
		User user = new User();
		user.setUsername("Amin");
		user.setPassword("GHI");
		String status = dao.saveUsr(user);
		System.out.println(status);
	*/	
/*		
		Transactions transaction = new Transactions();
		transaction.setId(26);
		transaction.setAcno("105");
		transaction.setDebit("Withdraw");
		transaction.setCredit("Deposit");
		transaction.setAmount("100");
		transaction.setBalance("200");
		transaction.setDate("12/10/2020");

		String status = dao.saveTransaction(transaction);
		System.out.println(status);
*/   
	/*	
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setId(26);
		accountDetails.setAcno("110");
		accountDetails.setName("Joe");
		accountDetails.setDob("03");
		accountDetails.setAddress("10 Broadway, NY");
		accountDetails.setEmail("clark@hotmail.com");
		accountDetails.setAccType("CT");
        String status = dao.saveAccdt(accountDetails);
        System.out.println(status);
        
      */
/*		
		Bank defaultAcc = new Bank();
		Bank a = new Bank();
		Bank b = new Bank();
		System.out.println(Bank.getBalance());
		
		a.withdraw(500);
		System.out.println(Bank.getBalance());
		b.deposit(800);
		System.out.println(Bank.getBalance());
  */
	/*	
		List<User> users = dao.getUser();
//		users.forEach(user -> System.out.println(user.getId()));
		List<User> userList = new ArrayList<>();
		for(int i=0;i<userList.size();i++){
		    System.out.println(users.get(i));
		}
		*/
	/*	
		AuthorizeCredit authCredit = new AuthorizeCredit();
		authCredit.setId(01);
		authCredit.setName("Basiru");
		authCredit.setCardNumber("A01");
		authCredit.setCvv("111");
		authCredit.setAmount("2000");
        String status = dao.saveCredit(authCredit);
        System.out.println(status);
      */  
        
        
	}
	
}
