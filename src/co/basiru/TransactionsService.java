package co.basiru;

public interface TransactionsService {
	public String saveTransaction(Transactions transaction);
	public String displayTransaction(Transactions transaction);
	public String debitTransaction(Transactions transaction);
	public String creditTransaction(Transactions transaction);

}
