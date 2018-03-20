/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import util.FormatDate;
import static view.JDialogCostOperate.*;
import xml.NewXML;

/**
 *
 * @author Rafael Recalcatti
 */
public class ClassCostOperete {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final NewXML newXML = new NewXML();
    private static final DecimalFormat v = new DecimalFormat("0.00");
    
    public static boolean newCost(JComponent[] fields) {

        try {

            String sql = "INSERT INTO tbl_cost_operate VALUES(0,?,?,?,?,?);";

            ps = Conn.connect().prepareStatement(sql);

            for (int i = 1; i < fields.length; i++) {

                if (fields[i] instanceof javax.swing.JTextField) {

                    JTextField jTextField = (javax.swing.JTextField) fields[i];
                    if (i == 2) {
                        ps.setString(i, FormatDate.formatDate(jTextField.getText()));
                        System.err.println("VALUE::" + FormatDate.formatDate(jTextField.getText()) + "POSITION::::" + i);
                    } else {
                        ps.setString(i, jTextField.getText().replace(",", "."));
                        System.err.println("VALUE::" + jTextField.getText().replace(",", ".") + "POSITION::::" + i);
                    }

                } else if (fields[i] instanceof javax.swing.JComboBox) {
                    JComboBox jComboBox = (JComboBox) fields[i];
                    ps.setString(i, jComboBox.getSelectedItem().toString().substring(0, 5));
                    System.err.println("VALUE::" + jComboBox.getSelectedItem().toString().substring(0, 5) + "POSITION::::" + i);

                } else if (fields[i] instanceof javax.swing.JTextArea) {
                    JTextArea jTextArea = (JTextArea) fields[i];
                    ps.setString(i, jTextArea.getText());
                    System.err.println("VALUE::" + jTextArea.getText() + "POSITION::::" + i);
                }
            }

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static List<String> allTypeCost() {
        List<String> typeCost = new ArrayList<>();

        String sql = "SELECT t.`description_type_cost_operate`, t.`idtbl_type_cost_operate` FROM tbl_type_cost_operate t;";

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                typeCost.add(rs.getString("idtbl_type_cost_operate") + " - " + rs.getString("description_type_cost_operate"));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return typeCost;

    }

    public static void consultCost(String arg) {

        String sql = "SELECT t.`idtbl_cost_operate`, CONCAT(t.`idtbl_type_cost_operate` , ' - ', tc.`description_type_cost_operate`), DATE_FORMAT(t.`date_cost`,'%d/%m/%Y') AS date_cost, t.`value_cost`, t.`number_document`,  t.`observation_cost` FROM tbl_cost_operate t INNER JOIN tbl_type_cost_operate tc ON t.`idtbl_type_cost_operate` = tc.`idtbl_type_cost_operate` WHERE t.`idtbl_cost_operate` = ? ORDER BY  t.`date_cost` DESC;";
        JComponent[] fields = fields();

        try {
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {

                for (int i = 0; i < fields.length; i++) {

                    if (fields[i] instanceof javax.swing.JTextField) {

                        JTextField jTextField = (javax.swing.JTextField) fields[i];
                        if (i == 2) {
                           
                            jTextField.setText(rs.getString(i + 1));

                        } else {
                            
                            jTextField.setText(v.format(rs.getDouble(i + 1)));

                        }

                    } else if (fields[i] instanceof javax.swing.JComboBox) {
                        JComboBox jComboBox = (JComboBox) fields[i];

                        System.err.println("COMBO>>>>" + rs.getString(i + 1));
                        jComboBox.setSelectedItem(rs.getString(i + 1));

                    } else if (fields[i] instanceof javax.swing.JTextArea) {
                        JTextArea jTextArea = (JTextArea) fields[i];
                        jTextArea.setText(rs.getString(i + 1));

                    }
                }

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean refreshCost(JComponent[] fields) {

        try {

            String sql = "UPDATE tbl_cost_operate t SET "
                    + " t.`idtbl_type_cost_operate` = ? ,"
                    + " t.`date_cost` = ? ,"
                    + " t.`value_cost` = ? ,"
                    + " t.`number_document` = ? ,"
                    + " t.`observation_cost` = ?  WHERE t.`idtbl_cost_operate` = ? ;";

            ps = Conn.connect().prepareStatement(sql);

            for (int i = 0; i < fields.length; i++) {

                if (i == 0) {
                    if (fields[i] instanceof javax.swing.JTextField) {
                        JTextField jTextField = (javax.swing.JTextField) fields[i];
                        ps.setString(6, jTextField.getText());
                        System.err.println("VALUE::" + jTextField.getText() + "POSITION::::" + i);
                    }
                } else {
                    if (fields[i] instanceof javax.swing.JTextField) {

                        JTextField jTextField = (javax.swing.JTextField) fields[i];
                        if (i == 2) {
                            ps.setString(i, FormatDate.formatDate(jTextField.getText()));
                            System.err.println("VALUE::" + FormatDate.formatDate(jTextField.getText()) + "POSITION::::" + i);
                        } else {
                            ps.setString(i, jTextField.getText().replace(",", "."));
                            System.err.println("VALUE::" + jTextField.getText().replace(",", ".") + "POSITION::::" + i);
                        }

                    } else if (fields[i] instanceof javax.swing.JComboBox) {
                        JComboBox jComboBox = (JComboBox) fields[i];
                        ps.setString(i, jComboBox.getSelectedItem().toString().substring(0, 5));
                        System.err.println("VALUE::" + jComboBox.getSelectedItem().toString().substring(0, 5) + "POSITION::::" + i);

                    } else if (fields[i] instanceof javax.swing.JTextArea) {
                        JTextArea jTextArea = (JTextArea) fields[i];
                        ps.setString(i, jTextArea.getText());
                        System.err.println("VALUE::" + jTextArea.getText() + "POSITION::::" + i);
                    }
                }
            }
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean deleteCost(String arg) {

        String sql = "DELETE  FROM tbl_cost_operate  WHERE idtbl_cost_operate = ? ;";

        try {
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean newTypeCost(JComponent[] fields) {

        try {

            String sql = "INSERT INTO tbl_type_cost_operate VALUES(?,?);";

            ps = Conn.connect().prepareStatement(sql);

            for (int i = 0; i < fields.length; i++) {

                if (fields[i] instanceof javax.swing.JTextField) {

                    JTextField jTextField = (javax.swing.JTextField) fields[i];

                    ps.setString(i + 1, jTextField.getText());

                }
            }

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean consultCodTypeCost(String arg) {

        String sql = "SELECT * FROM tbl_type_cost_operate t WHERE t.`idtbl_type_cost_operate` = ?;";

        try {
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);
            rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static void consultTypeCost(String arg) {

        String sql = "SELECT t.`idtbl_type_cost_operate`, t.`description_type_cost_operate` FROM tbl_type_cost_operate t WHERE t.`idtbl_type_cost_operate` = ? ;";
        JTextField[] jTextField = fieldsTypeCost();

        try {
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {

                jTextField[0].setText(rs.getString("idtbl_type_cost_operate"));
                jTextField[1].setText(rs.getString("description_type_cost_operate"));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean refreshTypeCost(JTextField[] fields) {

        try {

            String sql = "UPDATE tbl_type_cost_operate t SET  t.`description_type_cost_operate` = ? WHERE t.`idtbl_type_cost_operate` = ? ;";

            ps = Conn.connect().prepareStatement(sql);

            JTextField[] jTextField = fields;

            ps.setString(1, jTextField[1].getText());
            ps.setString(2, jTextField[0].getText());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean deleteTypeCost(String arg) {

        String sql = "DELETE  FROM tbl_cost_operate  WHERE idtbl_type_cost_operate = ? ;";

        try {
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);
            ps.executeUpdate();

            sql = "DELETE FROM tbl_type_cost_operate WHERE idtbl_type_cost_operate = ? ;";

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
