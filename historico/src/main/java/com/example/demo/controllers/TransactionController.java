package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Transaction;
import com.example.demo.services.TransactionService;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Adicionar transação
    @PostMapping("/{clientId}")
    public Transaction addTransaction(@PathVariable Long clientId,
                                      @RequestParam String tipo,
                                      @RequestParam Float valor) {
        return transactionService.addTransaction(clientId, tipo, valor);
    }

    // Listar histórico de transações de um cliente
    @GetMapping("/{clientId}")
    public List<Transaction> getTransactionHistory(@PathVariable Long clientId) {
        return transactionService.getTransactionHistory(clientId);
    }
}


