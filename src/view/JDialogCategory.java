/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import action.BeanLogin;
import action.Category;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.ClassCategory;
import util.JTextFieldTools;
import static view.JFrameSale_1.jTextProductCode;
import xml.NewXML;

/**
 *
 * @author Rafael Recalcatti
 */
public class JDialogCategory extends javax.swing.JDialog {

    private Category category = new action.Category();
    public DefaultListModel listModel = new DefaultListModel();
    public static boolean control_close_window_product = false;
    private static final NewXML newXML = new NewXML();

    public JDialogCategory(java.awt.Frame parent, boolean modal) {
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

        panel_cadastro_category = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_categorias = new javax.swing.JList();
        text_code_category = new javax.swing.JTextField();
        text_description_category = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        text_observation_category = new javax.swing.JTextField();
        text_percentage_profit_category = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        text_sector_category = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        bt_excluir_categoria = new javax.swing.JButton();
        bt_cancelar_nova_categoria = new javax.swing.JButton();
        bt_gravar_nova_categoria = new javax.swing.JButton();
        bt_nova_categoria = new javax.swing.JButton();
        bt_first_category = new javax.swing.JButton();
        bt_back_category = new javax.swing.JButton();
        bt_forward_category = new javax.swing.JButton();
        bt_last_category = new javax.swing.JButton();
        bt_sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel_cadastro_category.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lista_categorias.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        lista_categorias.setForeground(new java.awt.Color(51, 51, 51));
        lista_categorias.setModel(listModel);
        lista_categorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_categoriasMouseClicked(evt);
            }
        });
        lista_categorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lista_categoriasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(lista_categorias);

        text_code_category.setColumns(12);
        text_code_category.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        text_code_category.setForeground(new java.awt.Color(51, 51, 51));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${category.codCategory}"), text_code_category, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        text_code_category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_code_categoryKeyReleased(evt);
            }
        });

        text_description_category.setColumns(40);
        text_description_category.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        text_description_category.setForeground(new java.awt.Color(51, 51, 51));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${category.descriptionCategory}"), text_description_category, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        text_description_category.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                text_description_categoryFocusGained(evt);
            }
        });
        text_description_category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_description_categoryKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Categoria:");

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Código:");

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Observações:");

        text_observation_category.setColumns(40);
        text_observation_category.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        text_observation_category.setForeground(new java.awt.Color(51, 51, 51));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${category.observationCategory}"), text_observation_category, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        text_observation_category.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                text_observation_categoryFocusGained(evt);
            }
        });
        text_observation_category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_observation_categoryKeyReleased(evt);
            }
        });

        text_percentage_profit_category.setColumns(12);
        text_percentage_profit_category.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        text_percentage_profit_category.setForeground(new java.awt.Color(51, 51, 51));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${category.percentageProfitCategory}"), text_percentage_profit_category, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        text_percentage_profit_category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_percentage_profit_categoryKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Percentual Lucro(%):");

        text_sector_category.setColumns(12);
        text_sector_category.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        text_sector_category.setForeground(new java.awt.Color(51, 51, 51));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${category.sectorcategory}"), text_sector_category, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        text_sector_category.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_sector_categoryKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 3, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Setor:");

        javax.swing.GroupLayout panel_cadastro_categoryLayout = new javax.swing.GroupLayout(panel_cadastro_category);
        panel_cadastro_category.setLayout(panel_cadastro_categoryLayout);
        panel_cadastro_categoryLayout.setHorizontalGroup(
            panel_cadastro_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_cadastro_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_observation_category, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                        .addGroup(panel_cadastro_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(text_code_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_cadastro_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(text_description_category, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)))
                    .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                        .addGroup(panel_cadastro_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(text_percentage_profit_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel_cadastro_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(text_sector_category))))
                .addContainerGap())
        );
        panel_cadastro_categoryLayout.setVerticalGroup(
            panel_cadastro_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_cadastro_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel_cadastro_categoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_code_category, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_description_category, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_percentage_profit_category, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_cadastro_categoryLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_sector_category, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_observation_category, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        bt_excluir_categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/TrashFull.png"))); // NOI18N
        bt_excluir_categoria.setToolTipText("Excluir cadastro");
        bt_excluir_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluir_categoriaActionPerformed(evt);
            }
        });
        jPanel4.add(bt_excluir_categoria);

        bt_cancelar_nova_categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/[001166].png"))); // NOI18N
        bt_cancelar_nova_categoria.setToolTipText("Cancelar novo cadastro");
        bt_cancelar_nova_categoria.setEnabled(false);
        bt_cancelar_nova_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelar_nova_categoriaActionPerformed(evt);
            }
        });
        jPanel4.add(bt_cancelar_nova_categoria);

        bt_gravar_nova_categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save_large.png"))); // NOI18N
        bt_gravar_nova_categoria.setToolTipText("Salvar");
        bt_gravar_nova_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_gravar_nova_categoriaActionPerformed(evt);
            }
        });
        jPanel4.add(bt_gravar_nova_categoria);

        bt_nova_categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/annotate_large.png"))); // NOI18N
        bt_nova_categoria.setToolTipText("Inserir novo registro");
        bt_nova_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_nova_categoriaActionPerformed(evt);
            }
        });
        jPanel4.add(bt_nova_categoria);

        bt_first_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_first_category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/b_firstpage.png"))); // NOI18N
        bt_first_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_first_categoryActionPerformed(evt);
            }
        });
        jPanel4.add(bt_first_category);

        bt_back_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_back_category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/b_prevpage.png"))); // NOI18N
        bt_back_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_back_categoryActionPerformed(evt);
            }
        });
        jPanel4.add(bt_back_category);

        bt_forward_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_forward_category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/b_nextpage.png"))); // NOI18N
        bt_forward_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_forward_categoryActionPerformed(evt);
            }
        });
        jPanel4.add(bt_forward_category);

        bt_last_category.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_last_category.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/b_lastpage.png"))); // NOI18N
        bt_last_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_last_categoryActionPerformed(evt);
            }
        });
        jPanel4.add(bt_last_category);

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/[000787].png"))); // NOI18N
        bt_sair.setToolTipText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });
        jPanel4.add(bt_sair);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_cadastro_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_cadastro_category, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lista_categoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_categoriasMouseClicked

        String nameCategory = lista_categorias.getSelectedValue().toString();
        refreshBean(nameCategory);

    }//GEN-LAST:event_lista_categoriasMouseClicked

    private void lista_categoriasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lista_categoriasKeyPressed

        String nameCategory = null;

        switch (evt.getKeyCode()) {

            case KeyEvent.VK_DOWN:
                try {

                    nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex() + 1).toString();

                } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                    System.err.println("ERROR::" + ex);
                    //newXML.generateLog(ex.toString());

                    nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
                }

                break;

            case KeyEvent.VK_UP:
                try {

                    nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex() - 1).toString();

                } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                    System.err.println("ERROR::" + ex);
                    //newXML.generateLog(ex.toString());

                    nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
                }
                break;

        }

        refreshBean(nameCategory);

    }//GEN-LAST:event_lista_categoriasKeyPressed

    private void text_code_categoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_code_categoryKeyReleased

        //Limita e valida os caracteres digitados
        if (text_code_category.getText().length() > 4) {

            text_code_category.setText(text_code_category.getText().substring(0, 4));

        }
    }//GEN-LAST:event_text_code_categoryKeyReleased

    private void text_description_categoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_description_categoryFocusGained

        bt_gravar_nova_categoria.setEnabled(true);

    }//GEN-LAST:event_text_description_categoryFocusGained

    private void text_description_categoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_description_categoryKeyReleased

        text_description_category.setText(JTextFieldTools.formatName(text_description_category.getText()));

    }//GEN-LAST:event_text_description_categoryKeyReleased

    private void text_observation_categoryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_observation_categoryFocusGained

        bt_gravar_nova_categoria.setEnabled(true);

    }//GEN-LAST:event_text_observation_categoryFocusGained

    private void text_observation_categoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_observation_categoryKeyReleased

        text_observation_category.setText(JTextFieldTools.formatName(text_observation_category.getText()));

    }//GEN-LAST:event_text_observation_categoryKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        //Preeche a lista categorias        
        list(lista_categorias);

    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     
    }//GEN-LAST:event_formWindowClosed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed

        this.dispose();

    }//GEN-LAST:event_bt_sairActionPerformed

    private void bt_nova_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_nova_categoriaActionPerformed

        //Insere novo registro(categoria)
        text_description_category.requestFocus(true);
        bt_nova_categoria.setEnabled(false);
        bt_cancelar_nova_categoria.setEnabled(true);
        bt_gravar_nova_categoria.setEnabled(true);

        int codCateg = ClassCategory.consultCategory(null, true).getCodCategory();
        codCateg++;
        clear(panel_cadastro_category);
        text_code_category.setText(String.valueOf(codCateg));
        text_code_category.setBackground(Color.YELLOW);
        text_code_category.setEditable(false);
    }//GEN-LAST:event_bt_nova_categoriaActionPerformed

    private void bt_last_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_last_categoryActionPerformed

        //Vai para ultima posição na lista
        if (lista_categorias.getModel().getSize() > 0) {
            lista_categorias.setSelectedIndex(lista_categorias.getModel().getSize() - 1);
            int pos = lista_categorias.getSelectedIndex();
            String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
            bt_nova_categoria.setEnabled(true);
            bt_cancelar_nova_categoria.setEnabled(false);
            text_code_category.setBackground(Color.WHITE);
            refreshBean(nameCategory);
            lista_categorias.requestFocus(true);

        }
    }//GEN-LAST:event_bt_last_categoryActionPerformed

    private void bt_forward_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_forward_categoryActionPerformed

        //Avança uma posição na lista
        if (lista_categorias.getModel().getSize() > 0) {
            try {

                int pos = lista_categorias.getSelectedIndex();
                String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex() + 1).toString();
                lista_categorias.setSelectedIndex(pos + 1);
                bt_nova_categoria.setEnabled(true);
                bt_cancelar_nova_categoria.setEnabled(false);
                text_code_category.setBackground(Color.WHITE);
                refreshBean(nameCategory);

            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                System.err.println("ERROR::" + ex);
                //newXML.generateLog(ex.toString());

                int pos = lista_categorias.getSelectedIndex();
                String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
                lista_categorias.setSelectedIndex(pos);
                bt_nova_categoria.setEnabled(true);
                bt_cancelar_nova_categoria.setEnabled(false);
                text_code_category.setBackground(Color.WHITE);
                refreshBean(nameCategory);

            }
        }
    }//GEN-LAST:event_bt_forward_categoryActionPerformed

    private void bt_back_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_back_categoryActionPerformed

        //Retorna uma posição na lista
        if (lista_categorias.getModel().getSize() > 0) {
            try {

                int pos = lista_categorias.getSelectedIndex();
                String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex() - 1).toString();
                lista_categorias.setSelectedIndex(pos - 1);
                bt_nova_categoria.setEnabled(true);
                bt_cancelar_nova_categoria.setEnabled(false);
                text_code_category.setBackground(Color.WHITE);
                refreshBean(nameCategory);
                lista_categorias.requestFocus(true);

            } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
                System.err.println("ERROR::" + ex);
                //newXML.generateLog(ex.toString());

                int pos = lista_categorias.getSelectedIndex();
                String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
                lista_categorias.setSelectedIndex(pos);
                bt_nova_categoria.setEnabled(true);
                bt_cancelar_nova_categoria.setEnabled(false);
                text_code_category.setBackground(Color.WHITE);
                refreshBean(nameCategory);
                lista_categorias.requestFocus(true);

            }
        }
    }//GEN-LAST:event_bt_back_categoryActionPerformed

    private void bt_first_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_first_categoryActionPerformed

        //Vai para a primeira posição da lista
        if (lista_categorias.getModel().getSize() > 0) {
            lista_categorias.setSelectedIndex(0);
            int pos = lista_categorias.getSelectedIndex();
            String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
            bt_nova_categoria.setEnabled(true);
            bt_cancelar_nova_categoria.setEnabled(false);
            text_code_category.setBackground(Color.WHITE);
            refreshBean(nameCategory);
            lista_categorias.requestFocus(true);
        }
    }//GEN-LAST:event_bt_first_categoryActionPerformed

    private void bt_gravar_nova_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_gravar_nova_categoriaActionPerformed

        //insere nova categoria
        if (!text_description_category.getText().isEmpty() && !bt_nova_categoria.isEnabled()) {

            if (ClassCategory.newCategory(category)) {
                JOptionPane.showMessageDialog(this, "Categoria Inserida com Sucesso.");

                list(lista_categorias);
                bt_nova_categoria.setEnabled(true);
                bt_cancelar_nova_categoria.setEnabled(false);
                text_code_category.setBackground(Color.WHITE);
                clear(panel_cadastro_category);
                String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
                refreshBean(nameCategory);

            }

        } else if (bt_nova_categoria.isEnabled()) {

            int op = JOptionPane.showConfirmDialog(this, "Deseja Realmente Editar a Categoria?", "", JOptionPane.YES_NO_OPTION);

            if (op == 0) {

                if (ClassCategory.refreshCategory(category)) {

                    bt_nova_categoria.setEnabled(true);
                    bt_cancelar_nova_categoria.setEnabled(false);
                    text_code_category.setBackground(Color.WHITE);
                    clear(panel_cadastro_category);
                    list(lista_categorias);
                    String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
                    refreshBean(nameCategory);
                    JOptionPane.showMessageDialog(this, "Categoria Atualizada com Sucesso.");

                }
            }
        }
    }//GEN-LAST:event_bt_gravar_nova_categoriaActionPerformed

    private void bt_cancelar_nova_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelar_nova_categoriaActionPerformed

        //Cancela cadastro nova categoria
        int op = JOptionPane.showConfirmDialog(this, "Deseja Realmente Cancelar o Novo Cadastro?", "", JOptionPane.YES_NO_OPTION);
        if (op == 0) {

            bt_nova_categoria.setEnabled(true);
            bt_cancelar_nova_categoria.setEnabled(false);
            text_code_category.setBackground(Color.WHITE);
            clear(panel_cadastro_category);

            if (lista_categorias.getModel().getSize() > 0) {

                String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
                refreshBean(nameCategory);

            }

        } else {

            text_description_category.requestFocus(true);

        }
    }//GEN-LAST:event_bt_cancelar_nova_categoriaActionPerformed

    private void bt_excluir_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluir_categoriaActionPerformed

        //Deleta a Categoria Selecionada
        if (!text_code_category.getText().isEmpty()) {

            int op = JOptionPane.showConfirmDialog(this, "Deseja Realmente Deletar a Categoria Selecionada?", "", JOptionPane.YES_NO_OPTION);

            if (op == 0) {

                if (ClassCategory.deleleteCategory(text_code_category.getText())) {

                    clear(panel_cadastro_category);
                    list(lista_categorias);
                    JOptionPane.showMessageDialog(this, "Categoria Deletada com Sucesso.");

                } else {

                    JOptionPane.showMessageDialog(this, " Erro ao excluir a categoria.\n Consulte o administrador do sistema.");
                }
            }
        }
    }//GEN-LAST:event_bt_excluir_categoriaActionPerformed

    private void text_percentage_profit_categoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_percentage_profit_categoryKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_text_percentage_profit_categoryKeyReleased

    private void text_sector_categoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_sector_categoryKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_text_sector_categoryKeyReleased

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
            java.util.logging.Logger.getLogger(JDialogCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JDialogCategory dialog = new JDialogCategory(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_back_category;
    private javax.swing.JButton bt_cancelar_nova_categoria;
    private javax.swing.JButton bt_excluir_categoria;
    private javax.swing.JButton bt_first_category;
    private javax.swing.JButton bt_forward_category;
    private javax.swing.JButton bt_gravar_nova_categoria;
    private javax.swing.JButton bt_last_category;
    private javax.swing.JButton bt_nova_categoria;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lista_categorias;
    private javax.swing.JPanel panel_cadastro_category;
    private javax.swing.JTextField text_code_category;
    private javax.swing.JTextField text_description_category;
    private javax.swing.JTextField text_observation_category;
    private javax.swing.JTextField text_percentage_profit_category;
    private javax.swing.JTextField text_sector_category;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    public action.Category getCategory() {
        return category;
    }

    /**
     * Sets client to edit.
     *
     * @param client client to edit.
     */
    public void setCategory(action.Category category) {
        action.Category oldCategory = this.category;
        this.category = category;
        firePropertyChange("category", oldCategory, category);
    }

    public JDialogCategory() {
        initComponents();
    }

    private void refreshBean(String nameCategory) {

        action.Category newcategory = (ClassCategory.consultCategory(nameCategory, false));
        action.Category oldCategory = category;
        this.category = newcategory;
        firePropertyChange("category", oldCategory, category);

    }

    /**
     * Limpa os campos JText de um Painel indicado no parametro
     *
     * @param JPanel
     * @return void
     */
    private static void clear(JPanel panel) {

        java.awt.Component[] components = panel.getComponents();

        javax.swing.JTextField jTextField = null;

        for (int i = 0; i < components.length; i++) {

            if (components[i] instanceof javax.swing.JTextField) {

                jTextField = (javax.swing.JTextField) components[i];
                jTextField.setText("");

            }

        }

    }

    public void list(JList list) {

        List<String> lista = new ArrayList<>(ClassCategory.cotegorys());

        ((DefaultListModel) (list.getModel()))
                .removeAllElements();

        for (int u = 0; u < lista.size(); u++) {
            ((DefaultListModel) (list.getModel()))
                    .addElement(lista.get(u));
        }

        if (list.getModel().getSize() > 0) {

            list.setSelectedIndex(0);
            String nameCategory = lista_categorias.getModel().getElementAt(lista_categorias.getSelectedIndex()).toString();
            refreshBean(nameCategory);
            lista_categorias.requestFocus(true);

        }
    }
}
