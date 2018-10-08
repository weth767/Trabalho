/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.CandidatoDao;
import dao.PartidoDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Candidato;
import modelo.Partido;

/**
 *
 * @author leandro
 */
public class CadastraCandidato extends javax.swing.JFrame {

    /**
     * Creates new form CadastraEleitor
     */
    CandidatoDao candidatoDao;
    ArrayList<Partido> arrayPartido;
    PartidoDao partidoDao;

    public CadastraCandidato(CandidatoDao candidatoDao, PartidoDao partidoDao) {
        this.partidoDao = partidoDao;
        this.candidatoDao = candidatoDao;
        arrayPartido = partidoDao.retornaPartidos();
        if(arrayPartido == null || arrayPartido.isEmpty() || arrayPartido.size() == 0){
            this.mostra_erro();
            this.setVisible(false);
            this.dispose();
            return;
        }
        initComponents();
        this.setLocationRelativeTo(null);
        jCpf.setEditable(true);
        this.setTitle("Cadastra Candidato");
        preenchePartidoCombo(arrayPartido);
        
    }
    public void mostra_erro(){
        JOptionPane.showConfirmDialog(this, "Não existe partidos cadastrados, cadaste um partido para continuar","Erro Partido",JOptionPane.ERROR_MESSAGE); 
    }
    public void preenchePartidoCombo(ArrayList<Partido> arrayPartido){
        for (Partido partido : arrayPartido) {
            jComboPartido.addItem(partido.getNome());
        }
    }

    public Candidato novoCandidato() {
        Candidato candidato = new Candidato();
        candidato.setCpf(jCpf.getText());
        candidato.setNome(jtfNome.getText());
        candidato.setNumero(Integer.parseInt(jtfNumero.getText()));
        candidato.setPartido(this.partidoDao.retornaPartido(jComboPartido.getSelectedItem().toString()));
        return candidato;
    }

    public void limparCampos() {
        jCpf.setText("");
        jtfNome.setText("");
        jtfNumero.setText("");
        jComboPartido.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jlabelEleitor = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jLabelCpf = new javax.swing.JLabel();
        jCpf = new javax.swing.JFormattedTextField();
        LabelPartido = new javax.swing.JLabel();
        jComboPartido = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        ButttonLimpar = new javax.swing.JButton();
        ButtonCadastrar = new javax.swing.JButton();
        ButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlabelEleitor.setFont(new java.awt.Font("aakar", 0, 24)); // NOI18N
        jlabelEleitor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelEleitor.setText("Candidato");
        jlabelEleitor.setToolTipText("");

        jLabelNome.setText("Nome:");

        jLabelNumero.setText("Número:");

        jtfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNumeroActionPerformed(evt);
            }
        });

        jLabelCpf.setText("CPF:");

        jCpf.setEditable(false);
        try {
            jCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCpfActionPerformed(evt);
            }
        });

        LabelPartido.setText("Partido:");

        jComboPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboPartidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCpf)
                            .addComponent(LabelPartido))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNumero)
                            .addComponent(jLabelNome))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCpf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelPartido, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jComboPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ButttonLimpar.setText("Limpar");
        ButttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButttonLimparActionPerformed(evt);
            }
        });

        ButtonCadastrar.setText("Cadastrar");
        ButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastrarActionPerformed(evt);
            }
        });

        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(ButtonCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(ButttonLimpar)
                .addGap(99, 99, 99)
                .addComponent(ButtonCancelar)
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButttonLimpar)
                    .addComponent(ButtonCadastrar)
                    .addComponent(ButtonCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabelEleitor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabelEleitor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCpfActionPerformed

    private void ButttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButttonLimparActionPerformed
        this.limparCampos();
    }//GEN-LAST:event_ButttonLimparActionPerformed

    private void ButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastrarActionPerformed
        candidatoDao.cadastraCandidato(this.novoCandidato());
        this.limparCampos();
    }//GEN-LAST:event_ButtonCadastrarActionPerformed

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_ButtonCancelarActionPerformed

    private void jComboPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboPartidoActionPerformed

    }//GEN-LAST:event_jComboPartidoActionPerformed

    private void jtfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNumeroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCadastrar;
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JButton ButttonLimpar;
    private javax.swing.JLabel LabelPartido;
    private javax.swing.JComboBox<String> jComboPartido;
    private javax.swing.JFormattedTextField jCpf;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlabelEleitor;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNumero;
    // End of variables declaration//GEN-END:variables
}
