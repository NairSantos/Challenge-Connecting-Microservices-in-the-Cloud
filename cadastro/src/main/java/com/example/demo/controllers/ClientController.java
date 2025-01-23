package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public Client updateBalance(@PathVariable Long id, @RequestParam Float newBalance) {
        return clientService.updateBalance(id, newBalance);
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/calcular-score/{id}")
    public ResponseEntity<Float> calcularScore(@PathVariable Long id) {
        // Busca os dados do cliente na Segunda Aplicação
        String url = "http://localhost:8081/client/" + id;
        Client client = restTemplate.getForObject(url, Client.class);

        if (client == null || client.getSaldoCc() == null) {
            return ResponseEntity.notFound().build();
        }

        // Cálculo do score de crédito
        Float scoreCredito = client.getSaldoCc() * 0.1f;
        return ResponseEntity.ok(scoreCredito);
    }
}
