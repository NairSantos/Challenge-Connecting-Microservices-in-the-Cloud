package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

// O Spring gerencia esta classe para definir configurações do Swagger.
@Configuration
public class SwaggerConfig {

    // Bean para configurar o OpenAPI (Swagger).
    @Bean
    public OpenAPI customOpenAPI() {
        // Cria e retorna uma instância (OpenAPI) 
        return new OpenAPI()
                .info(new Info()
                        .title("API de Clientes - Javer")
                        .version("1.0.0")
                        .description("Documentação da API de Gerenciamento de Clientes"));
    }
}
