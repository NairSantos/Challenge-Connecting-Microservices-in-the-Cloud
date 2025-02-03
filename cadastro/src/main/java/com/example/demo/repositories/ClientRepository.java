package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Client;

/*
 * Interfaces que estendem o JpaRepository para fornecer métodos de acesso ao banco de dados.
 */

// Marca esta interface como um repositório do Spring, permitindo sua injeção e uso em outras partes do código.
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
// Esta interface herda métodos padrão para manipulação de dados de JpaRepository.
}
