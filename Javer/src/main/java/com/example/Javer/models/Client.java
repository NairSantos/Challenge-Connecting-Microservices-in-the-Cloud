package com.example.Javer.models;

import jakarta.persistence.Transient;


public class Client {
    
    private Long id;
    private String nome;
    private Long telefone;      
    private Boolean correntista;
    private Float saldoCc;
    @Transient
    private Float scoreCredito;//esta amarelo pq não está sendo usado diretamente pois é um atributo calculado


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
        return this.saldoCc*0.1f;
    }

    public void setScoreCredito(Float scoreCredito) {
        this.scoreCredito = scoreCredito;
    }

}