package com.money.manager.controller;

import com.money.manager.model.Transaction;
import com.money.manager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://ajay-money.vercel.app")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/api/transactions")
    public List<Transaction> getTransactions(){
        return transactionService.getTransactions();
    }

    @GetMapping("/api/transactions/{id}")
    public Transaction getTransactionById(@PathVariable Integer id){
        return transactionService.getTransactionById(id);
    }


    @PostMapping("/api/transactions")
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionService.addTransaction(transaction);
    }


    @PutMapping("/api/transactions/{id}")
    public Transaction updateTransaction(@RequestBody Transaction transaction, @PathVariable("id") int id) {
        return transactionService.updateTransaction(id, transaction);
    }


    @DeleteMapping("/api/transactions/{id}")
    public void deleteTransaction(@PathVariable("id") int id) {
        transactionService.deleteTransaction(id);
    }

}
