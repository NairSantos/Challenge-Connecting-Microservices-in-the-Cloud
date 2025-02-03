package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ClientCreateDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.dto.mapper.ClientMapper;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/*
 * Exponhem endpoints REST para operações CRUD
 */

// Indica que esta classe é um controlador REST
@RestController
// Define o endpoint base para a rotas ("/clients").
@RequestMapping("/clients")
public class ClientController {

    // Injeta automaticamente a instância do serviço de clientes gerenciada pelo Spring.
    @Autowired
    private ClientService clientService;
    
    // Define a operação de listar todos os clientes com uma documentação para o Swagger.
    @Operation(summary = "Listar todos os clientes", description = "Retorna uma lista de todos os clientes cadastrados no sistema.", method = "GET")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de clientes recuperada com sucesso."),
        @ApiResponse(responseCode = "500", description = "Erro interno ao recuperar a lista de clientes.")
    })
    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        // Busca todos os clientes cadastrados no sistema.
        List<Client> clients = clientService.buscarTodosClientes();
        // Converte a lista de clientes para uma lista de DTOs (apenas os dados relevantes são enviados).
        @SuppressWarnings("Convert2Diamond")
        List<ClientResponseDto> dtos = new ArrayList<ClientResponseDto>();
        for (Client client : clients) {
            dtos.add(ClientMapper.toDto(client));
        }
        // Retorna a lista de clientes(status 200).
        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente no sistema com base nos dados fornecidos.", method = "POST")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso.", 
        content=@Content(mediaType="application/json",schema=@Schema(implementation=ClientResponseDto.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos para criação do cliente."),
        @ApiResponse(responseCode = "500", description = "Erro interno ao criar o cliente.")
    })
    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody ClientCreateDto dto) {
        // Converte o DTO recebido para uma entidade Client e salva no banco.
        Client client = clientService.salvar(ClientMapper.toClient(dto));
        // Retorna os dados do cliente criado(status 201).
        return ResponseEntity.status(HttpStatus.CREATED).body(ClientMapper.toDto(client));
    }

    @Operation(summary = "Atualizar saldo do cliente", description = "Atualiza o saldo de conta corrente de um cliente com base no ID fornecido.", method = "PUT")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Saldo do cliente atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado."),
        @ApiResponse(responseCode = "500", description = "Erro interno ao atualizar o saldo.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> updateBalance(@PathVariable Long id, @RequestParam Float newBalance) {
        // Atualiza o saldo do cliente no sistema e retorna os dados atualizados.
        Client client = clientService.updateBalance(id, newBalance);
        // Retorna os dados do cliente atualizado(status 200).
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
       // Remove o cliente do sistema com base no ID fornecido.
        clientService.removerCliente(id);
        // Retorna uma resposta sem conteúdo (204 No Content).
        return ResponseEntity.noContent().build();
    }
}


