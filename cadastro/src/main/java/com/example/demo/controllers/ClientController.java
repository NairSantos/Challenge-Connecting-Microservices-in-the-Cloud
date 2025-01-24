package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.ClientCreateDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.dto.mapper.ClientMapper;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Listar todos os clientes", description = "Retorna uma lista de todos os clientes cadastrados no sistema.", method = "GET")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de clientes recuperada com sucesso."),
        @ApiResponse(responseCode = "500", description = "Erro interno ao recuperar a lista de clientes.")
    })
    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        List<Client> clients = clientService.buscarTodosClientes();
        @SuppressWarnings("Convert2Diamond")
        List<ClientResponseDto> dtos = new ArrayList<ClientResponseDto>();
        for (Client client : clients) {
            dtos.add(ClientMapper.toDto(client));
        }
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente no sistema com base nos dados fornecidos.", method = "POST")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do cliente."),
        @ApiResponse(responseCode = "500", description = "Erro interno ao criar o cliente.")
    })
    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody ClientCreateDto dto) {
        Client client = clientService.salvar(ClientMapper.toClient(dto));
        return ResponseEntity.ok(ClientMapper.toDto(client));
    }

    @Operation(summary = "Atualizar saldo do cliente", description = "Atualiza o saldo de conta corrente de um cliente com base no ID fornecido.", method = "PUT")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Saldo do cliente atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado."),
        @ApiResponse(responseCode = "500", description = "Erro interno ao atualizar o saldo.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> updateBalance(@PathVariable Long id, @RequestParam Float newBalance) {
        Client client = clientService.updateBalance(id, newBalance);
        return ResponseEntity.ok(ClientMapper.toDto(client));
    }

    
    @Operation(summary = "Deletar um cliente", description = "Remove um cliente do sistema com base no ID fornecido.", method = "DELETE")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Cliente removido com sucesso."),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado."),
        @ApiResponse(responseCode = "500", description = "Erro interno ao remover o cliente.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.removerCliente(id);
        return ResponseEntity.noContent().build();
    }
}


