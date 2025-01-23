package com.example.Javer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Javer.dto.ClientCreateDto;
import com.example.Javer.dto.ClientResponseDto;
import com.example.Javer.proxy.TransactionServiceProxy;

@RestController
@RequestMapping("/servico/clientes")
public class JaverController {

    @Autowired
    private TransactionServiceProxy proxy;

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAll() {
        return proxy.getAllClients();
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> create(@RequestBody ClientCreateDto dto) {
        return proxy.createClient(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> update(@PathVariable Long id, @RequestParam Float newBalance) {
        return proxy.updateBalance(id, newBalance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return proxy.deleteClient(id);
    }

}
