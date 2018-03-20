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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import util.JTextFieldTools;
import view.JDialogRegisterCards;
import static view.JDialogRegisterCards.jCheckBoxIsActive;
import static view.JDialogRegisterCards.jComboTypeCard;
import view.JDialogRegisterVendor_3_1;
import xml.NewXML;

/**
 *
 * @author CPU
 */
public class ClassCard {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final NewXML newXML = new NewXML();

    public static boolean newCard() {

        try {

            ps = Conn.connect().prepareStatement("INSERT INTO tbl_cards VALUES(?,?,?,?,?,?,?,?,?)");

            JTextField[] tf = JDialogRegisterCards.campos();

            ps.setString(1, tf[0].getText());
            ps.setString(2, tf[1].getText());
            ps.setObject(3, jComboTypeCard.getSelectedItem());
            ps.setString(4, tf[2].getText());
            ps.setString(5, tf[3].getText().replace(",", "."));
            ps.setBoolean(6, jCheckBoxIsActive.isSelected());
            ps.setString(7, JTextFieldTools.formatDate(tf[4].getText()));
            ps.setString(8, tf[5].getText());
            ps.setString(9, tf[6].getText().replace(",", "."));

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCard.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean deleteCard(String arg) throws SQLException {

        ps = Conn.connect().prepareStatement("DELETE FROM tbl_cards WHERE idtbl_cards = ? ");
        ps.setString(1, arg);

        return ps.executeUpdate() == 1;

    }

    public static boolean refreshCard(String arg) {

        String sql = "UPDATE tbl_cards SET"
                + " name_card = ? ,"
                + " type_card = ? ,"
                + " equipment_card =? ,"
                + " tariff_card = ? ,"
                + " expiring_date_card = ? ,"
                + " account = ? ,"
                + " isActive_card = ?,"
                + " percentage_tax = ?"
                + " WHERE idtbl_cards = ?;";

        try {
            ps = Conn.connect().prepareStatement(sql);

            JTextField[] tf = JDialogRegisterCards.campos();

            ps.setString(9, tf[0].getText());
            ps.setString(1, tf[1].getText());
            ps.setObject(2, jComboTypeCard.getSelectedItem());
            ps.setString(3, tf[2].getText());
            ps.setString(4, tf[3].getText().replace(",", "."));
            ps.setString(5, JTextFieldTools.formatDate(tf[4].getText()));
            ps.setString(6, tf[5].getText());
            ps.setBoolean(7, jCheckBoxIsActive.isSelected());
            ps.setString(8, tf[6].getText().replace(",", "."));

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterCards.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static void consultCardRegister(String arg) {

        String sql = "SELECT t.`idtbl_cards`,"
                + " t.`name_card`,"
                + " t.`type_card`,"
                + " t.`equipment_card`,"
                + " t.`tariff_card`,"
                + " t.`isActive_card`,"
                + " t.`expiring_date_card`,"
                + " t.`account`,"
                + "t.`percentage_tax`"
                + " FROM tbl_cards t WHERE t.`idtbl_cards` = ? ;";

        JTextField[] tf = JDialogRegisterCards.campos();

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);
            rs = ps.executeQuery();

            if (rs.next()) {

                tf[0].setText(rs.getString("idtbl_cards"));
                tf[1].setText(rs.getString("name_card"));
                tf[2].setText(rs.getString("equipment_card"));
                tf[3].setText(rs.getString("tariff_card").replace(".", ","));
                tf[4].setText(JTextFieldTools.formatDateSQL(rs.getString("expiring_date_card")));
                tf[5].setText(rs.getString("account"));
                jCheckBoxIsActive.setSelected(rs.getBoolean("isActive_card"));
                jComboTypeCard.setSelectedItem(rs.getString("type_card"));
                tf[6].setText(rs.getString("percentage_tax").replace(".", ","));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
