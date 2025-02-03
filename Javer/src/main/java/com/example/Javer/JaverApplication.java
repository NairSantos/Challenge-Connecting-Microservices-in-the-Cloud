package com.example.Javer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

// Classe principal da aplicação Spring Boot
@SpringBootApplication
@RestController // Marca a classe como um controlador REST
public class JaverApplication {

    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot
		SpringApplication.run(JaverApplication.class, args);
	}

}
