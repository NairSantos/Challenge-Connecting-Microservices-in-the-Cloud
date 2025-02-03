package com.example.Javer.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Javer.dto.ClientCreateDto;
import com.example.Javer.dto.ClientResponseDto;
import com.example.Javer.proxy.TransactionServiceProxy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
/*
 * aqui é onde serao gerenciados as requisições HTTP e onde é direcionadas as chamadas para os serviços apropriados.    
 */


// Indica que esta classe é um controlador REST
@RestController
// Define o endpoint base para a rotas ("/servico/clientes").
@RequestMapping("/servico/clientes")
@Tag(name = "Clientes", description = "Gerenciamento de Clientes")
public class JaverController {

    // Proxy para comunicação com outro serviço
    private TransactionServiceProxy proxy;

    // Endpoint para listar todos os clientes
    @Operation(summary = "Listar todos os clientes", description = "Recupera a lista completa de clientes registrados.", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAll() {
        return proxy.getAllClients();
    }

    // Endpoint para criar um novo cliente
    @Operation(summary = "Criar um novo cliente", description = "Cria um novo cliente no sistema com as informações fornecidas.",method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação nos dados fornecidos"),
        @ApiResponse(responseCode = "500", description = "Erro interno ao criar o cliente.")
    })
    @PostMapping
    public ResponseEntity<ClientResponseDto> create(
            @RequestBody (description = "Informações do cliente a ser criado", required = true)
            @org.springframework.web.bind.annotation.RequestBody ClientCreateDto dto) {
        return proxy.createClient(dto);
    }

    // Endpoint para atualizar o saldo de um cliente
    @Operation(summary = "Atualizar saldo do cliente", description = "Atualiza o saldo de conta corrente de um cliente existente.",method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Saldo atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno ao atualizar o saldo.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDto> update(
            @PathVariable Long id,
            @RequestParam Float newBalance) {
        return proxy.updateBalance(id, newBalance);
    }

    // Endpoint para deletar um cliente
        @Operation(summary = "Deletar cliente", description = "Remove um cliente do sistema com base no ID fornecido.",method = "DELETE")
        @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao remover o cliente.")
        })
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            return proxy.deleteClient(id);
        }
}
