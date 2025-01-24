package com.example.Javer.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Javer.dto.ClientCreateDto;
import com.example.Javer.dto.ClientResponseDto;


@FeignClient(name = "service", url = "http://localhost:8081")
public interface TransactionServiceProxy {

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients();

    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody ClientCreateDto dto);

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> updateBalance(@PathVariable Long id, @RequestParam Float newBalance);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id);


}
