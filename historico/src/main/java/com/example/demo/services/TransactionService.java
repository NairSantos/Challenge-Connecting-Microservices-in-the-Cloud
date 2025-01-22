package com.example.demo.services;

import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.models.Transaction;
import com.example.demo.models.Client;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Transaction addTransaction(Long clientId, String tipo, Float valor) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Cria uma nova transação
        Transaction transaction = new Transaction();
        transaction.setClient(client);
        transaction.setTipo(tipo);
        transaction.setValor(valor);
        transaction.setData(LocalDateTime.now());

        // Salva a transação
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionHistory(Long clientId) {
        return transactionRepository.findByClientId(clientId);
    }

}
