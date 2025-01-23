package com.example.Javer.dto;

public class ClientResponseDto {

    private int id;
    private String nome;
    private Long telefone;
    private Float saldoCc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public Long getTelephone() {
        return telefone;
    }

    public void setTelephone(Long telephone) {
        this.telefone = telephone;
    }

    public Float getSaldo() {
        return saldoCc;
    }

    public void setSaldo(Float saldo) {
        this.saldoCc = saldo;
    }
}
