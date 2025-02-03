package com.example.Javer.dto;

import jakarta.persistence.Transient;

// Classe DTO (Data Transfer Object) para representar os dados de resposta ao cliente.
public class ClientResponseDto {

    private int id;
    private String nome;
    private Long telefone;
    private boolean correntista;
    private Float saldoCc;

    // Campo que não será persistido no banco de dados, mas será usado na lógica de negócios ou apresentado como resposta.
     @Transient
    private Float scoreCredito;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    public boolean isCorrentista() {
        return correntista;
    }

    public void setCorrentista(boolean correntista) {
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
