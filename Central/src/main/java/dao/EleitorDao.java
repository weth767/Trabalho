/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Eleitor;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leandro
 */
public class EleitorDao{
    private ArrayList<Eleitor> eleitores;

    public EleitorDao() {
        eleitores = new ArrayList();
    }
    public void cadastraEleitor(Eleitor eleitor){
        this.eleitores.add(eleitor);
    }
    public void removeEleitor(Eleitor eleitor){
        for (Eleitor e : eleitores) {
            if(e.getCpf().equals(eleitor.getCpf())){
                eleitores.remove(e);
            }
        }
    }
    public ArrayList<Eleitor> retornaEleitores(){
        return this.eleitores;
    }
    public void createJSON(){
        Gson gson = new Gson();
        FileWriter arq = null;
        try {
            arq = new FileWriter("Eleitor.json");
        } catch (IOException ex) {
            Logger.getLogger(EleitorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        PrintWriter gravarArq = new PrintWriter(arq);
        for (Eleitor eleitor : eleitores) {
            gravarArq.printf("%s",gson.toJson(eleitor));
        }
        try {
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(EleitorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
