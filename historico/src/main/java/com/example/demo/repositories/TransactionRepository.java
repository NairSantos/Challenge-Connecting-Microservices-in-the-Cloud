package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Buscar transações por cliente
    List<Transaction> findByClientId(Long clientId);
}