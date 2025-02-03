package com.example.Javer.dto.mapper;

import org.modelmapper.ModelMapper;

import com.example.Javer.dto.ClientCreateDto;
import com.example.Javer.dto.ClientResponseDto;
import com.example.Javer.models.Client;

public class ClientMapper {

    // Construtor privado para evitar instâncias da classe
    private ClientMapper() {}

    public static Client toClient(ClientCreateDto dto){
        return new ModelMapper().map(dto, Client.class); // Converte ClientCreateDto em Client
    }

    public static ClientResponseDto toDto(Client client){
        return new ModelMapper().map(client, ClientResponseDto.class);// Converte Client em ClientResponseDto
    }

}
