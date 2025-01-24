package com.example.demo.dto;

import jakarta.persistence.Transient;

public class ClientCreateDto {

    private String nome;
    private Long telefone;
    private boolean correntista;
    private Float saldoCc;

     @Transient
    private Float scoreCredito;

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
        return this.saldoCc*0.1f;
    }

    public void setScoreCredito(Float scoreCredito) {
        this.scoreCredito = scoreCredito;
    }
}
