/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conexao.ConexaoDrive;
import dao.CandidatoDao;

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
    
    public void geraJson(){
        candidatoDao.createJSON();
    }
    public void enviaDrive(){
        ConexaoDrive.getInstance();
        ConexaoDrive.criaArquivo("Candidato.json", "Candidato.json");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabelCandidato = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        enviaCandidato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlabelCandidato.setFont(new java.awt.Font("aakar", 0, 24)); // NOI18N
        jlabelCandidato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelCandidato.setText("Candidatos - Drive");
        jlabelCandidato.setToolTipText("");

        enviaCandidato.setText("Enviar Candidatos");
        enviaCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviaCandidatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(enviaCandidato)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(enviaCandidato)
                .addContainerGap(39, Short.MAX_VALUE))
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelCandidato, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviaCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviaCandidatoActionPerformed
        this.geraJson();
        this.enviaDrive();
    }//GEN-LAST:event_enviaCandidatoActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviaCandidato;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlabelCandidato;
    // End of variables declaration//GEN-END:variables
}
