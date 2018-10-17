/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Candidato;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author leandro
 */
public class CandidatoDao {
    private ArrayList<Candidato> candidatos;

    public CandidatoDao() {
        candidatos = new ArrayList();
    }
    public void cadastraCandidato(Candidato candidato){
        this.candidatos.add(candidato);
    }
    public void removeCandidato(Candidato candidato){
        for (Candidato c : candidatos) {
            if(c.getNumero() == candidato.getNumero()){
                candidatos.remove(c);
            }
        }
    }
    public ArrayList<Candidato> retornaCandidatos(){
        return this.candidatos;
    }
}
