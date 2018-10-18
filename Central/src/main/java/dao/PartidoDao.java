/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import modelo.Partido;
import java.util.ArrayList;
import modelo.Eleitor;


/**
 *
 * @author leandro
 */
public class PartidoDao {
    private ArrayList<Partido> partidos;

    public PartidoDao() {
        partidos = new ArrayList();
    }
    public void cadastraPartido(Partido partido){
        this.partidos.add(partido);
    }
    public void removePartido(Partido partido){
        for (Partido p : partidos) {
            if(p.getNumero() == partido.getNumero()){
                partidos.remove(p);
            }
        }
    }
    public ArrayList<Partido> retornaPartidos(){
        return this.partidos;
    }
    public Partido retornaPartido(String nome){
        for (Partido partido : partidos) {
            if(partido.getNome().equals(nome)){
                return partido;
            }
        }
        return null;
    }
    public void appendArrayList(ArrayList<Partido> partidos){
        for (Partido partido : partidos) {
            this.partidos.add(partido);
        }
    }
}
