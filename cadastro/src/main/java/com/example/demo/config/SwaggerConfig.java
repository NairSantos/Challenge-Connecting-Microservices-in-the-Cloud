package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Clientes - Javer")
                        .version("1.0.0")
                        .description("Documentação da API de Gerenciamento de Clientes"));
    }
}
//@openApiDefinition(info = @Info(title = "API de Clientes - Javer", version = "1.0.0", description = "Documentação da API de Gerenciamento de Clientes"))