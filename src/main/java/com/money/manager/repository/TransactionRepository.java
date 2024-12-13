package com.money.manager.repository;
import com.money.manager.model.Transaction;
import java.util.*;

public interface TransactionRepository {
    List<Transaction> getTransactions();
    Transaction getTransactionById(int id);

    Transaction addTransaction(Transaction transaction);

    Transaction updateTransaction(int id, Transaction transaction);

    void deleteTransaction(int id);
}
