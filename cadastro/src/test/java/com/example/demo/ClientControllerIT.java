package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.demo.dto.ClientCreateDto;
import com.example.demo.dto.ClientResponseDto;

//inicializa o teste em porta aleatoria
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerIT {
    @Autowired
    WebTestClient webTestClient;

    @Test
    public void testCreateClients_return201() {
        //armazena no responseBody o resultado da requisição
        ClientResponseDto responseBody = webTestClient//faz a requisição post na uri /clients
                .post()
                .uri("/clients")
                .contentType(MediaType.APPLICATION_JSON)//configura o tipo de conteudo (json)
                .bodyValue(new ClientCreateDto("jonas",40028922L,true,1500f))//passando um novo valor ao clientdto
                .exchange()//executa a requisição
                .expectStatus().isCreated()//espera que retorna o status 201
                .expectBody(ClientResponseDto.class)//espera que o corpo da resposta seja um clientdto
                .returnResult()//retorna o resultado
                .getResponseBody();//pegar o corpo da resposta


        //assertions compara o valor esperado com o valor retornado (nn pode ser nulo)
        //verifica se o corpo da resposta é nulo ou não (espera que não seja nulo)
        org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
        org.assertj.core.api.Assertions.assertThat(responseBody.getId()).isNotNull();//espera que o id não seja nulo
        org.assertj.core.api.Assertions.assertThat(responseBody.getNome()).isNotNull();//espera que o nome seja igual a jonas
        org.assertj.core.api.Assertions.assertThat(responseBody.getNome()).hasSize(5);//espera que o nome tenha 5 caracteres
        org.assertj.core.api.Assertions.assertThat(responseBody.getNome().length()).isGreaterThan(0);//espera que o nome tenha mais de 0 caracteres
        org.assertj.core.api.Assertions.assertThat(responseBody.getNome()).isEqualTo("jonas");//espera que o nome seja igual a jonas
        org.assertj.core.api.Assertions.assertThat(responseBody.getTelefone()).isNotNull();//espera que o telefone não seja nulo
        org.assertj.core.api.Assertions.assertThat(responseBody.getTelefone()).isEqualTo(40028922L);//espera que o telefone seja igual a 40028922
        org.assertj.core.api.Assertions.assertThat(responseBody.isCorrentista()).isNotNull();//espera que o correntista não seja nulo
        org.assertj.core.api.Assertions.assertThat(responseBody.isCorrentista()).isEqualTo(true);//espera que o correntista seja verdadeiro
        org.assertj.core.api.Assertions.assertThat(responseBody.isCorrentista()).isNotEqualTo(false);//espera que o correntista não seja falso
        org.assertj.core.api.Assertions.assertThat(responseBody.getSaldoCc()).isNotNull();//espera que o saldoCc não seja nulo
        org.assertj.core.api.Assertions.assertThat(responseBody.getSaldoCc()).isEqualTo(1500f);//espera que o saldoCc seja igual a 1500
        org.assertj.core.api.Assertions.assertThat(responseBody.getSaldoCc()).isGreaterThanOrEqualTo(0f);//espera que o saldoCc seja maior ou igual a 0
        
    }

    @Test
    public void testDeleteClient_return204() {
        // Primeiro cria um cliente
        ClientResponseDto createdClient = webTestClient
                .post()
                .uri("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new ClientCreateDto("joao", 55555555L, false, 1000f))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(ClientResponseDto.class)
                .returnResult()
                .getResponseBody();

        // Deleta o cliente
        webTestClient
                .delete()
                .uri("/clients/" + createdClient.getId())
                .exchange()
                .expectStatus().isNoContent();

        // Verifica se o cliente foi deletado
        webTestClient
                .get()
                .uri("/clients/" + createdClient.getId())
                .exchange()
                .expectStatus();
                if (webTestClient.equals(404)) {
                    System.out.println("Cliente não foi deletado!");
                }
                else {
                    System.out.println("Cliente deletado com sucesso!");
                }
                
    }
}
