package com.example.demo.dto.mapper;

import org.modelmapper.ModelMapper;

import com.example.demo.dto.ClientCreateDto;
import com.example.demo.dto.ClientResponseDto;
import com.example.demo.models.Client;

public class ClientMapper {

    private ClientMapper() {}

    public static Client toClient(ClientCreateDto dto){
        return new ModelMapper().map(dto, Client.class);
    }

    public static ClientResponseDto toDto(Client client){
        return new ModelMapper().map(client, ClientResponseDto.class);
    }
    
}
