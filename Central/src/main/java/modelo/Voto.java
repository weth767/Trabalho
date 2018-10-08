/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author leandro
 */
public class Voto {
    private Eleitor eleitor;
    private Candidato candidato;
    private int numero_urna;
    private Date data_hora;

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public int getNumero_urna() {
        return numero_urna;
    }

    public void setNumero_urna(int numero_urna) {
        this.numero_urna = numero_urna;
    }

    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }
    
}
