/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import action.Product;
import javax.swing.JOptionPane;
import model.ClassUnityMeasure;
import util.JTextFieldTools;
import xml.NewXML;

/**
 *
 * @author Gabriel
 */
public class JDialog_Unity_Measure extends javax.swing.JDialog {

    private Product product = new Product();
    private MyModelUnity modelUnity;
    private static final NewXML newXML = new NewXML();

    /**
     * Creates new form JDialog_Unity_Measure
     *
     * @param parent
     * @param modal
     */
    public JDialog_Unity_Measure(java.awt.Frame parent, boolean modal) {
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        panelBackground = new javax.swing.JPanel();
        panelInsert = new javax.swing.JPanel();
        text_unity_measure = new javax.swing.JTextField();
        text_abbreviature = new javax.swing.JTextField();
        label_help_1 = new javax.swing.JLabel();
        panelActions = new javax.swing.JPanel();
        buttonSave = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUnityMeasure = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panelBackground.setLayout(new java.awt.BorderLayout());

        panelInsert.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Unidade de Medida", javax.swing.border.TitledBorder.TRAILING, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 0, 10), new java.awt.Color(0, 51, 102))); // NOI18N
        panelInsert.setForeground(new java.awt.Color(51, 51, 51));

        text_unity_measure.setColumns(5);
        text_unity_measure.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_unity_measure.setForeground(new java.awt.Color(51, 51, 51));
        text_unity_measure.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unidade de Medida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${product.unity_measure}"), text_unity_measure, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        text_unity_measure.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_unity_measureKeyReleased(evt);
            }
        });

        text_abbreviature.setColumns(2);
        text_abbreviature.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_abbreviature.setForeground(new java.awt.Color(51, 51, 51));
        text_abbreviature.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Abreviatura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${product.abbreviature}"), text_abbreviature, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        text_abbreviature.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_abbreviatureKeyReleased(evt);
            }
        });

        label_help_1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        label_help_1.setForeground(new java.awt.Color(51, 51, 51));
        label_help_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_help_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Icon.png"))); // NOI18N
        label_help_1.setToolTipText("Clique duas vezes para Ajuda");
        label_help_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_help_1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelInsertLayout = new javax.swing.GroupLayout(panelInsert);
        panelInsert.setLayout(panelInsertLayout);
        panelInsertLayout.setHorizontalGroup(
            panelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_unity_measure, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInsertLayout.createSequentialGroup()
                        .addComponent(text_abbreviature, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_help_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
        );
        panelInsertLayout.setVerticalGroup(
            panelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_help_1)
                    .addComponent(text_abbreviature, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(text_unity_measure, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        panelActions.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelActions.setForeground(new java.awt.Color(0, 51, 51));
        panelActions.setLayout(new java.awt.GridLayout(1, 0));

        buttonSave.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        buttonSave.setForeground(new java.awt.Color(51, 51, 51));
        buttonSave.setText("Salvar");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        panelActions.add(buttonSave);

        buttonDelete.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        buttonDelete.setForeground(new java.awt.Color(51, 51, 51));
        buttonDelete.setText("Deletar");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        panelActions.add(buttonDelete);

        buttonExit.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        buttonExit.setForeground(new java.awt.Color(51, 51, 51));
        buttonExit.setText("Cancelar");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });
        panelActions.add(buttonExit);

        tableUnityMeasure.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        tableUnityMeasure.setForeground(new java.awt.Color(51, 51, 51));
        tableUnityMeasure.setRowHeight(35);
        tableUnityMeasure.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUnityMeasureMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUnityMeasure);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(panelInsert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelActions, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed

        if (!text_abbreviature.getText().isEmpty() && !text_unity_measure.getText().isEmpty()) {

            if (ClassUnityMeasure.newUnityMeasure(product)) {

                JOptionPane.showMessageDialog(null, "Unidade de medida inserida com sucesso.");

                modelUnity = new MyModelUnity();
                tableUnityMeasure.setModel(modelUnity);

            } else {

                JOptionPane.showMessageDialog(null, "Unidade de medida já cadastrada.");

            }

        } else {

            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");

        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed

        JDialog_Unity_Measure.this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed

        if (!text_abbreviature.getText().isEmpty()) {

            if (ClassUnityMeasure.deleleteUnityMeasure(product)) {

                JOptionPane.showMessageDialog(null, "Unidade de medida deletada com sucesso.");

                modelUnity = new MyModelUnity();
                tableUnityMeasure.setModel(modelUnity);

            } else {

                JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.");

            }
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void label_help_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_help_1MouseClicked
    }//GEN-LAST:event_label_help_1MouseClicked

    private void tableUnityMeasureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUnityMeasureMouseClicked

        if (tableUnityMeasure.getModel().getRowCount() > 0) {

            refreshBean(tableUnityMeasure.getModel().getValueAt(tableUnityMeasure.getSelectedRow(), 0).toString());
        }

    }//GEN-LAST:event_tableUnityMeasureMouseClicked

    private void text_abbreviatureKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_abbreviatureKeyReleased

        text_abbreviature.setText(text_abbreviature.getText().toUpperCase());

    }//GEN-LAST:event_text_abbreviatureKeyReleased

    private void text_unity_measureKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_unity_measureKeyReleased
        JTextFieldTools.validarValor(text_unity_measure);

    }//GEN-LAST:event_text_unity_measureKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        modelUnity = new MyModelUnity();
        tableUnityMeasure.setModel(modelUnity);
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
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
            java.util.logging.Logger.getLogger(JDialog_Unity_Measure.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JDialog_Unity_Measure dialog = new JDialog_Unity_Measure(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_help_1;
    private javax.swing.JPanel panelActions;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JPanel panelInsert;
    private javax.swing.JTable tableUnityMeasure;
    private javax.swing.JTextField text_abbreviature;
    private javax.swing.JTextField text_unity_measure;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        Product oldProduct = this.product;
        this.product = product;
        firePropertyChange("product", oldProduct, product);
    }
    //Atualiza o bean product com valores vindos do DB

    private void refreshBean(String id) {

        Product newProduct = (ClassUnityMeasure.consultUnity(id));
        Product oldProduct = product;
        this.product = newProduct;
        firePropertyChange("product", oldProduct, product);

    }
}
