package com.money.manager.service;

import com.money.manager.model.Transaction;
import com.money.manager.repository.TransactionJpaRepository;
import com.money.manager.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class TransactionService implements TransactionRepository {

    @Autowired
    private TransactionJpaRepository transactionJpaRepository;
    @Override
    public List<Transaction> getTransactions() {
        return transactionJpaRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(int id) {
        try {
            return transactionJpaRepository.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "transactionId " + id + " not found");
        }
    }

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionJpaRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(int id, Transaction transaction) {
        try {
            Transaction newTransaction = transactionJpaRepository.findById(id).get();
            if (transaction.getName() != null) {
                newTransaction.setName(transaction.getName());
            }

            return transactionJpaRepository.save(newTransaction);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "transactionId " + id + " not found");
        }
    }

    @Override
    public void deleteTransaction(int id) {
        transactionJpaRepository.deleteById(id);
    }
}
