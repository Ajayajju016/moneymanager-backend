package com.money.manager.repository;
import com.money.manager.model.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionJpaRepository extends JpaRepository<Transaction , Integer> {
}
