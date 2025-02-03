package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

      // Define um bean para o RestTemplate. 
      //@Bean indica que o método retorna um bean gerenciado pelo Spring, permitindo sua injeção em outras partes da aplicação.
    @Bean
    public RestTemplate restTemplate() {
        // Cria e retorna uma nova instância do RestTemplate.
        return new RestTemplate();
    }

}