package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/*
 * definem as entidades do domínio
 */

// Define esta classe como uma entidade JPA, ou seja, será mapeada para uma tabela no banco de dados.
@Entity
public class Client {
    // Indica que este campo é a chave primária da entidade.
    @Id
    // Define que o valor do ID será gerado automaticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Long telefone;      
    private Boolean correntista;
    private Float saldoCc;

    // Campo que não será persistido no banco de dados.
    @Transient
    private Float scoreCredito;


    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Boolean getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Boolean correntista) {
        this.correntista = correntista;
    }

    public Float getSaldoCc() {
        return saldoCc;
    }

    public void setSaldoCc(Float saldoCc) {
        this.saldoCc = saldoCc;
    }

    public Float getScoreCredito() {
        return this.saldoCc*0.1f;// Calcula o score como 10% do saldo da conta corrente.
    }

    public void setScoreCredito(Float scoreCredito) {
        this.scoreCredito = scoreCredito;
    }

}