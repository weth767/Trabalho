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

    public Integer[][] leImagemMatriz(String caminho) {
        Integer matriz[][] = null;
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine(); // lê a primeira linha
            linha = lerArq.readLine(); // lê a segunda linha contendo o tamanho da matriz
            String vetor_string[] = linha.split(" ");
            int x = 0;
            int y = 0;
            if (vetor_string != null) {
                x = Integer.parseInt(vetor_string[1]);
                y = 3 * Integer.parseInt(vetor_string[0]);
            }
            linha = lerArq.readLine(); // Le a terceira linha
            matriz = new Integer[x][y];
            for (int i = 0; i < x; i++) {
                linha = lerArq.readLine();// le da quarta linha em diante
                String vet_imagem[] = linha.split(" ");//quebra a linha para pegar cada elemento
                for (int j = 0; j < y; j++) {
                    matriz[i][j] = Integer.parseInt(vet_imagem[j]);//joga o valor do elemento na matriz
                }
            }
            arq.close();//fecha o arquivo para evitar erro
        } catch (IOException e) {//captura o erro
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return matriz;
    }

}
