package com.example.Javer.dto.mapper;

import org.modelmapper.ModelMapper;

import com.example.Javer.dto.ClientCreateDto;
import com.example.Javer.dto.ClientResponseDto;
import com.example.Javer.models.Client;

public class ClientMapper {

    private ClientMapper() {}

    public static Client toClient(ClientCreateDto dto){
        return new ModelMapper().map(dto, Client.class);
    }

    public static ClientResponseDto toDto(Client client){
        return new ModelMapper().map(client, ClientResponseDto.class);
    }

}
