package com.example.demo.controllers;

import java.util.ArrayList;
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

import com.example.demo.dto.ClientCreateDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.dto.mapper.ClientMapper;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        List<Client> clients = clientService.buscarTodosClientes();
        List<ClientResponseDto> dtos = new ArrayList<ClientResponseDto>();
        for (Client client : clients) {
            dtos.add(ClientMapper.toDto(client));
        }
        return ResponseEntity.ok(dtos);

    }
    
    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody ClientCreateDto dto) {
        Client client = clientService.salvar(ClientMapper.toClient(dto));
        return ResponseEntity.ok(ClientMapper.toDto(client));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> updateBalance(@PathVariable Long id, @RequestParam Float newBalance) {
        Client client = clientService.updateBalance(id, newBalance);
        return ResponseEntity.ok(ClientMapper.toDto(client));
    }

}
