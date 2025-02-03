package com.example.demo.dto.mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.ClientCreateDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.models.Client;

// Classe responsável pelo mapeamento entre entidades e DTOs.
public class ClientMapper {

    // Construtor privado para impedir a criação de instâncias da classe, já que ela é apenas utilitária.
    private ClientMapper() {}

    // Método estático que converte um objeto ClientCreateDto para uma entidade Client.
    public static Client toClient(ClientCreateDto dto){
         // Cria uma instância de ModelMapper para realizar o mapeamento automático entre os campos correspondentes.
        return new ModelMapper().map(dto, Client.class);
    }

    // Método estático que converte uma entidade Client para um objeto ClientResponseDto.
    public static ClientResponseDto toDto(Client client){
        // Utiliza o ModelMapper para mapear automaticamente os campos da entidade Client para o DTO ClientResponseDto.
        return new ModelMapper().map(client, ClientResponseDto.class);
    }
    
}
