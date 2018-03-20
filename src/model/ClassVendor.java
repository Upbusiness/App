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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import static view.JDialogProductVendor_3_2.*;
import view.JDialogRegisterVendor_3_1;
import xml.NewXML;

/**
 *
 * @author CPU
 */
public class ClassVendor {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final NewXML newXML = new NewXML();

    public static boolean newVendor() {

        try {

            ps = Conn.connect().prepareStatement("INSERT INTO tbl_vendor VALUES(?,?,?,?,?,?,?,?,?,?,?)");

            JTextField[] tf = JDialogRegisterVendor_3_1.campos();

            ps.setString(1, tf[0].getText());
            ps.setString(2, tf[1].getText());
            System.err.println(tf[2].getText().replace("(", "").replace(")", "").replace("_", "").replace(".", "").replace("-", "").replace("/", "").trim());
            ps.setString(3, tf[2].getText().replace("(", "").replace(")", "").replace("_", "").replace(".", "").replace("-", "").replace("/", "").trim());
            ps.setString(4, tf[3].getText().replace("(", "").replace(")", "").replace("_", "").replace(".", "").replace("-", "").replace("/", "").trim());
            ps.setString(5, tf[4].getText());
            ps.setString(6, tf[5].getText().replace("(", "").replace(")", "").replace("_", "").replace(".", "").replace("-", "").replace("/", "").trim());
            ps.setString(7, tf[6].getText().replace("(", "").replace(")", "").replace("_", "").replace(".", "").replace("-", "").replace("/", "").trim());
            ps.setString(8, tf[7].getText());
            ps.setString(9, tf[8].getText());
            ps.setString(10, tf[9].getText());
            ps.setString(11, tf[10].getText());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassVendor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean deleteVendor(String arg) throws SQLException {

        ps = Conn.connect().prepareStatement("DELETE FROM tbl_vendor WHERE idtbl_vendor = ?");
        ps.setString(1, arg);

        return ps.executeUpdate() == 1;

    }

    public static boolean refreshVendor(String arg) {

        String sql = "UPDATE tbl_vendor SET ven_name = ? , ven_cnpj = ? , ven_state_inscription = ? , ven_uf = ? , ven_phone = ? , ven_celular = ? , ven_contact = ? , ven_city = ? , ven_address = ? , ven_email = ? WHERE idtbl_vendor = ?";

        try {
            ps = Conn.connect().prepareStatement(sql);

            JTextField[] tf = JDialogRegisterVendor_3_1.campos();

            ps.setString(1, tf[1].getText());
            ps.setString(2, tf[2].getText().replace("(", "").replace(")", "").replace("_", "").replace(".", "").replace("-", "").replace("/", "").trim());
            ps.setString(3, tf[3].getText().replace("(", "").replace(")", "").replace("_", "").replace(".", "").replace("-", "").replace("/", "").trim());
            ps.setString(4, tf[4].getText());
            ps.setString(5, tf[5].getText().replace("(", "").replace(")", "").replace("_", "").replace(".", "").replace("-", "").replace("/", "").trim());
            ps.setString(6, tf[6].getText().replace("(", "").replace(")", "").replace("_", "").replace(".", "").replace("-", "").replace("/", "").trim());
            ps.setString(7, tf[7].getText());
            ps.setString(8, tf[8].getText());
            ps.setString(9, tf[9].getText());
            ps.setString(10, tf[10].getText());
            ps.setString(11, tf[0].getText());
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public static void consultVendor(String rowId) {

        String sql = "SELECT t.`idtbl_vendor`, t.`ven_name`,CASE WHEN (t.`ven_cnpj` != '') THEN  t.`ven_cnpj` WHEN (t.`ven_cnpj` = '') THEN  '00.000.000/0000-00' END AS 'ven_cnpj' ,CASE WHEN (t.`ven_state_inscription` != '') THEN  t.`ven_cnpj` WHEN (t.`ven_state_inscription` = '') THEN  '000/0000000' END AS 'ven_state_inscription' , t.`ven_uf`, CASE WHEN (t.`ven_phone` != '') THEN  t.`ven_phone` WHEN (t.`ven_phone`= '') THEN  '(00)00000-0000' END AS 'ven_phone', CASE WHEN ( t.`ven_celular` != '') THEN   t.`ven_celular` WHEN ( t.`ven_celular`= '') THEN  '(00)00000-0000' END AS 'ven_celular' , t.`ven_contact`, t.`ven_city`, t.`ven_address`, t.`ven_email`  FROM tbl_vendor t WHERE idtbl_vendor = ?";
        JTextField[] tf = JDialogRegisterVendor_3_1.campos();

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, rowId);
            rs = ps.executeQuery();

            boolean resultado = rs.next();

            if (resultado) {

                tf[0].setText(rs.getString(1));
                tf[1].setText(rs.getString(2));
                tf[2].setText(rs.getString(3));
                tf[3].setText(rs.getString(4));
                tf[4].setText(rs.getString(5));
                tf[5].setText(rs.getString(6));
                tf[6].setText(rs.getString(7));
                tf[7].setText(rs.getString(8));
                tf[8].setText(rs.getString(9));
                tf[9].setText(rs.getString(10));
                tf[10].setText(rs.getString(11));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static List<String> allProductsVendor(String arg) {

        String sql = "SELECT t.`prod_bar_code_product`, p.`prod_description_product` FROM tbl_product_vendor t INNER JOIN tbl_product p ON t.`prod_bar_code_product` =  p.`prod_bar_code_product` WHERE  t.`idtbl_vendor` = ? ";
        List<String> list = new ArrayList<>();

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {

                list.add(rs.getString("prod_bar_code_product") + " - " + rs.getString("prod_description_product"));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public static boolean addProductVendor(Object barCode, Object idVendor) {

        try {

            ps = Conn.connect().prepareStatement("INSERT INTO tbl_product_vendor VALUES(0,?,?)");
            ps.setObject(1, barCode);
            ps.setObject(2, idVendor);

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassVendor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean removeProductVendor(Object barCode, Object idVendor) {
        try {

            ps = Conn.connect().prepareStatement("DELETE FROM tbl_product_vendor WHERE prod_bar_code_product = ? AND  idtbl_vendor = ?");
            ps.setObject(1, barCode);
            ps.setObject(2, idVendor);

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassVendor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean consultProductVendor(String barCode) {

        String sql = "SELECT t.`prod_bar_code_product`, t.`prod_description_product` FROM tbl_product t WHERE t.`prod_bar_code_product` = " + barCode;

        try {

            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                jTextFieldBarCodeProductVendor.setText(rs.getString(1));
                jTextFieldDescriptionProductProductVendor.setText(rs.getString(2));

                return true;

            } else {

                return false;

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean conteinIsProductVendor(String barCode, String idVendor) {

        String sql = "SELECT t.`prod_bar_code_product`, p.`prod_description_product` FROM tbl_product_vendor t INNER JOIN tbl_product p ON t.`prod_bar_code_product` =  p.`prod_bar_code_product` WHERE t.`prod_bar_code_product` = ? AND t.`idtbl_vendor` = ? ";

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, barCode);
            ps.setString(2, idVendor);
            rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
