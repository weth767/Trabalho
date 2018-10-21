/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conexao.ConexaoDrive;
import dao.CandidatoDao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import uteis.Arquivo;

/**
 *
 * @author leandro
 */
public class EnviaCandidatos extends javax.swing.JFrame {

    /**
     * Creates new form EnviaPartidos
     */
    CandidatoDao candidatoDao;

    public EnviaCandidatos(CandidatoDao candidatoDao) {
        this.candidatoDao = candidatoDao;
        initComponents();
        this.setTitle("Envia Candidatos");
        this.setLocationRelativeTo(null);
    }

    public void geraJson() {
        ArrayList<Object> l = (ArrayList<Object>) (Object) candidatoDao.retornaCandidatos();
        Arquivo.criaArquivoJSON(l, "candidatos.json");
    }

    public void enviaDrive() {
        ConexaoDrive.getInstance();
        ConexaoDrive.criaArquivo("candidatos.json", "candidatos.json");
        JOptionPane.showMessageDialog(this, "Dados dos candidatos enviados com sucesso!\n");
    }

    public void apagaDrive() {
        ConexaoDrive.getInstance();
        List<com.google.api.services.drive.model.File> lista_arquivos = ConexaoDrive.listaArquivos();
        for (com.google.api.services.drive.model.File lista_arquivo : lista_arquivos) {
            if (lista_arquivo.getName().equals("candidatos.json")) {
                ConexaoDrive.removerArquivo(lista_arquivo.getId());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabelCandidato = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        enviaCandidato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlabelCandidato.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        jlabelCandidato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelCandidato.setText("Candidatos - Drive");
        jlabelCandidato.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 117, Short.MAX_VALUE)
        );

        enviaCandidato.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        enviaCandidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/enviarNuvem.png"))); // NOI18N
        enviaCandidato.setText("Enviar Candidatos");
        enviaCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviaCandidatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelCandidato, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enviaCandidato)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(enviaCandidato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviaCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviaCandidatoActionPerformed
        this.geraJson();
        this.apagaDrive();
        this.enviaDrive();
    }//GEN-LAST:event_enviaCandidatoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviaCandidato;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlabelCandidato;
    // End of variables declaration//GEN-END:variables
}
