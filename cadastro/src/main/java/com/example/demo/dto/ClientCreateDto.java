package com.example.demo.dto;

public class ClientCreateDto {

    private String nome;
    private Long telefone;
    private boolean correntista;

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
}
