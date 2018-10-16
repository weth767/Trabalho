/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Eleitor;
import java.util.ArrayList;


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
}
