package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Client> buscarTodosClientes() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client salvar(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
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
