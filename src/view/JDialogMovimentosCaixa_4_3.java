/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import action.BeanTbl;
import java.util.logging.Level;
import java.util.logging.Logger;
//import relatorio.ViewRelatorio;
import util.Sons;
import xml.NewXML;

/**
 *
 * @author Rafael Recalcatti
 */
public class JDialogMovimentosCaixa_4_3 extends javax.swing.JDialog {

    public static String SQL = "SELECT t.`idtbl_caixa`, date_format(t.`hora_abertura_caixa`,'%H:%i:%s %d/%m/%Y'), date_format(t.`hora_fechamento_caixa`,'%H:%i:%s %d/%m/%Y'), t.`valor_inicial`, t.`valor_vendas_dinheiro`, t.`valor_vendas_cartao`, t.`valor_vendas_ticket` FROM tbl_caixa t";
    public static String[] head_tbl_caixa = {"Cod.", "Data Abertura", "Data Fechamento", "Valor Inicial", "Venda Dinheiro", "Venda Cartão", "Venda Ticket"};
    private static final NewXML newXML = new NewXML();

    public JDialogMovimentosCaixa_4_3(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel37 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        table_acomp_caixa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Movimentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Impact", 2, 14), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel37.setLayout(new java.awt.BorderLayout());

        table_acomp_caixa.setSelectionBackground(new java.awt.Color(255, 255, 0));
        table_acomp_caixa.setSelectionForeground(new java.awt.Color(102, 102, 102));
        table_acomp_caixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_acomp_caixaMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(table_acomp_caixa);
        table_acomp_caixa.setDefaultRenderer(Object.class, new MyCellRenderer());

        jPanel37.add(jScrollPane8, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_acomp_caixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_acomp_caixaMouseClicked

        System.err.println(table_acomp_caixa.getValueAt(table_acomp_caixa.getSelectedRow(), 0));

        if (table_acomp_caixa.getRowCount() > 0 && table_acomp_caixa.isRowSelected(table_acomp_caixa.getSelectedRow())) {

            if (evt.getClickCount() == 1) {

                new Sons().tocarDuploClique();
                //ViewRelatorio imp = new ViewRelatorio();

                System.err.println(table_acomp_caixa.getValueAt(table_acomp_caixa.getSelectedRow(), 0)
                );
                Object[] valPar = {table_acomp_caixa.getValueAt(table_acomp_caixa.getSelectedRow(), 0)};

                Object[] par = {"PAR_COD"};
                try {

                    //imp.visualizarRelatorio(valPar, par, "AcompanhamentoCaixa.jasper");
                } catch (Exception ex) {
                    System.err.println("ERROR::" + ex);
                    //newXML.generateLog(ex.toString());
                    Logger.getLogger(JDialogMovimentosCaixa_4_3.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }//GEN-LAST:event_table_acomp_caixaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            java.util.logging.Logger.getLogger(JDialogMovimentosCaixa_4_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JDialogMovimentosCaixa_4_3 dialog = new JDialogMovimentosCaixa_4_3(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel37;
    private javax.swing.JScrollPane jScrollPane8;
    public static javax.swing.JTable table_acomp_caixa;
    // End of variables declaration//GEN-END:variables
}
