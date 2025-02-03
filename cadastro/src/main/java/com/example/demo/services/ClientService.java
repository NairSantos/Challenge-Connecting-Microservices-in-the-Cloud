package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;

/*
 *  Implementam a lógica de negócios para manipulação dos dados
 */

// Marca esta classe como um serviço do Spring, permitindo sua injeção em controladores e outros componentes.
@Service
public class ClientService {

    // Injeta automaticamente o repositório de clientes.
    @Autowired
    private ClientRepository clientRepository;

     /**
     * Método para buscar todos os clientes cadastrados.
     * Este método é apenas de leitura, indicado pela anotação @Transactional(readOnly = true),
     * para melhorar a performance ao desabilitar operações de escrita na transação.
     */
    @Transactional(readOnly = true)
    public List<Client> buscarTodosClientes() {
        return clientRepository.findAll();// Retorna a lista de todos os clientes
    }

    /**
     * Método para salvar um cliente.
     * Este método é transacional, garantindo que a operação de escrita seja atômica.
     */
    @Transactional
    public Client salvar(Client client) {
        return clientRepository.save(client); // Salva ou atualiza o cliente
    }

     //Método para atualizar o saldo de um cliente.
    @Transactional
    public Client updateBalance(Long id, Float newBalance) {
        if(newBalance < 0) {
            throw new RuntimeException("Invalid balance");
        }
        // Busca o cliente pelo ID ou lança uma exceção caso ele não seja encontrado.
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Atualiza o saldo
        client.setSaldoCc(newBalance);

        // Salva o cliente atualizado
        return clientRepository.save(client);
    }

  
     //Método para remover um cliente pelo ID.
    @Transactional
    public void removerCliente(Long id) {
        // Verifica se o cliente existe no banco de dados.
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Remove o cliente
        clientRepository.delete(client);
    }

}
