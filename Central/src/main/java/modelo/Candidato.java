/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author leandro
 */
public class Candidato implements Comparable {

    private String nome;
    private int numero;
    private String cpf;
    private Partido partido;
    private int quantidadeVotos;

    public int getQuantidadeVotos() {
        return quantidadeVotos;
    }

    public Candidato() {
        this.quantidadeVotos = 0;
    }

    public void setQuantidadeVotos(int quantidadeVotos) {
        this.quantidadeVotos = quantidadeVotos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Override
    public int compareTo(Object objeto) {
        Candidato candidato = (Candidato) objeto;
        if (this.getQuantidadeVotos() < candidato.getQuantidadeVotos()) {
            return 1;
        }
        if (this.getQuantidadeVotos() > candidato.getQuantidadeVotos()) {
            return -1;
        }
        return 0;
    }
}
