package co.basiru.dao;

import co.basiru.models.Transactions;

public interface TransactionsDAO {
	public String saveTransaction(Transactions transaction);
	public String displayTransaction(Transactions transaction);

}
