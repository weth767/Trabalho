/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author weth
 */
public class Arquivo {
    public Integer [][] leImagem(String caminho){
        Integer [][] imagem = null;
        int altura,largura;
        try {
            File arquivo = new File(caminho);
            if(arquivo.canRead()){
                BufferedImage im = ImageIO.read(arquivo);
                altura = im.getHeight();
                largura = im.getWidth();
                imagem = new Integer[altura][largura];
                for(int i = 0; i < largura; i++){
                    for(int j = 0; j < altura; j++){
                        imagem[i][j] = im.getRGB(i, j);
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagem;
    }
    
    public String leImagemString(String caminho){
        String imagem = "";
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine(); // lê a primeira linha
            imagem = linha;
            while(linha != null){
                linha = lerArq.readLine(); // lê da segunda linha em diante
                imagem += linha;//passa o que foi lido para a string
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return imagem;
    }
    
}
