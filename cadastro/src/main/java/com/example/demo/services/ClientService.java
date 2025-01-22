package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client updateBalance(Long id, Float newBalance) {
        // Busca o cliente pelo ID
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Atualiza o saldo
        client.setSaldoCc(newBalance);

        // Salva o cliente atualizado
        return clientRepository.save(client);
    }
}
