package co.basiru;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionsServiceImpl implements TransactionsService {
	String status = "";
	
	@Autowired
	private TransactionsDAO transactionDao;
	
	public void setTransactionsDao(TransactionsDAO transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Override
	public String saveTransaction(Transactions transaction) {
		
		TransactionsDAO.saveTransaction(transaction);
		
		return status;
	
	
	}

	@Override
	public String displayTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String debitTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String creditTransaction(Transactions transaction) {
		// TODO Auto-generated method stub
		return null;
	}

}
