/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import dao.CandidatoDao;
import javax.swing.JPanel;
import modelo.Candidato;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author leandro
 */
public class MostraGraficos extends javax.swing.JFrame {

    /**
     * Creates new form testeGrafico
     */
    CandidatoDao candidatoDao;
    public MostraGraficos(CandidatoDao candidatoDao) {
        this.candidatoDao = candidatoDao;
        initComponents();
        this.setContentPane(createDemoPanel());
        this.setLocationRelativeTo(null);
        this.setTitle("Gráfico Eleições");
    }

    public PieDataset criaGrafico() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for (Candidato candidato : candidatoDao.retornaCandidatos()){
            dataset.setValue(candidato.getNome(), candidato.getQuantidadeVotos());
        }
        return dataset;
    }

    public JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Gráfico Eleições Presidenciais", // chart title 
                dataset, // data    
                true, // include legend   
                true,
                false);

        return chart;
    }

    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(criaGrafico());
        return new ChartPanel(chart);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
