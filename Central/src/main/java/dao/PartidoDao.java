/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import modelo.Partido;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void createJSON(){
        Gson gson = new Gson();
        FileWriter arq = null;
        try {
            arq = new FileWriter("Partido.json");
        } catch (IOException ex) {
            Logger.getLogger(PartidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter gravarArq = new PrintWriter(arq);
        for (Partido partido : partidos) {
            gravarArq.printf("%s",gson.toJson(partido));
        }
        try {
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(PartidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
