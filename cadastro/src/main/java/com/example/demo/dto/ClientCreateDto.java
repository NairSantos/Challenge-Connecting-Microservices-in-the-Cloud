package com.example.demo.dto;
public class ClientCreateDto {

    public ClientCreateDto(String nome, Long telefone, boolean correntista, Float saldoCc) {
        this.nome = nome;
        this.telefone = telefone;
        this.correntista = correntista;
        this.saldoCc = saldoCc;
    }
    
    private String nome;
    private Long telefone;
    private boolean correntista;
    private Float saldoCc;

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


}
