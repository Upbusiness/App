/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.Invoice;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.FormatDate;
import xml.NewXML;

/**
 *
 * @author Rafiusk
 */
public class ClassProductInvoice {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    //private static Invoice invoice =  new Invoice();
    private static boolean saida = false;
    private static final Invoice invoice = new Invoice();
    private static final NewXML newXML = new NewXML();

    /**
     * Cadastra o cabeçario da nota e retorna verdadeiro se o cadastro foi
     * efetuado com sucesso
     *
     * @param Invoice
     * @return boolean
     */
    public static boolean newHeaderInvoice(Invoice Invoice) {

        try {

            String sql = "INSERT INTO tbl_invoice VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            ps = Conn.connect().prepareStatement(sql);

            ps.setString(1, Invoice.getIdInvoice());
            ps.setString(2, Invoice.getVendorInvoice());
            ps.setInt(3, Invoice.getNumberInvoice());
            ps.setInt(4, Invoice.getFilialInvoice());
            ps.setString(5, FormatDate.formatDate(Invoice.getDateEntryInvoice()));
            ps.setInt(6, Invoice.getSeriesInvoive());
            ps.setString(7, FormatDate.formatDate(Invoice.getDateEmissionInvoice()));
            ps.setBigDecimal(8, Invoice.getValueTotalInvoice());
            ps.setBigDecimal(9, Invoice.getTotalIcmsInvoice());
            ps.setBigDecimal(10, Invoice.getBaseIcmsInvoice());
            ps.setBigDecimal(11, Invoice.getValueDutyInvoice());
            ps.setBigDecimal(12, Invoice.getValueOthersInvoice());
            ps.setBigDecimal(13, Invoice.getValueSubstInvoice());
            ps.setString(14, Invoice.getValueAllProductsInvoice());
            ps.setString(15, Invoice.getObservationInvoice());
            ps.setString(16, Invoice.getTransporter());

            int res = ps.executeUpdate();
            return res == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean newProductInvoice(Invoice productInvoice) {

        try {

            String sql = "INSERT INTO tbl_product_invoice VALUES(0,?,?,?,?,?,?,0);";

            ps = Conn.connect().prepareStatement(sql);
            System.err.println("ID" + productInvoice.getIdInvoice());
            ps.setString(1, productInvoice.getIdInvoice());
            ps.setString(2, productInvoice.getCodBarProductInvoice());
            ps.setString(3, productInvoice.getDescriptionProductInvoice());
            ps.setDouble(4, productInvoice.getValueProductInvoice());
            ps.setDouble(5, productInvoice.getQuantityProductInvoice());
            ps.setString(6, productInvoice.getObservationProductInvoice());
            int res = ps.executeUpdate();
         

            if (res == 1) {

                saida = true;

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            saida = false;
        }

        return saida;

    }

    public static boolean validNumberInvoice(String paramter1, String paramter2) {

        String sql = "SELECT * FROM tbl_invoice t WHERE inv_number_invoice = ? AND idtbl_vendor = ?;";

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, paramter1);
            ps.setString(2, paramter2);
            rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProductInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean deleteProductInvoice(String par, String par2) {

        String SQL = "DELETE  FROM tbl_product_invoice WHERE  idtbl_invoice = '" + par2 + "' AND idtbl_product_invoice IN" + par + ";";
        System.err.println("SQL NO DELETE:::" + SQL);
        try {

            stmt = Conn.connect().createStatement();

            return stmt.executeUpdate(SQL) == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void setSelected(String paramter1) {
        String sql = "UPDATE tbl_product_invoice SET prod_inv_isSelected = 1 WHERE idtbl_product_invoice IN" + paramter1 + ";";
        System.err.println("SQL NO setIsSelected::" + sql);
        try {

            System.err.println("PAR::" + paramter1);
            stmt = Conn.connect().createStatement();
            stmt.executeUpdate(sql);
           

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProductInvoice.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static Invoice consultProductInvoice(Object valueAt, Object valueAt2) {

        String sql = "SELECT t.`idtbl_invoice`,"
                + " t.`idtbl_vendor`, "
                + "t.`inv_number_invoice`,"
                + " t.`inv_filial`,"
                + " t.`inv_date_entry`,"
                + " t.`inv_series_invoice`,"
                + " t.`inv_date_emission`,"
                + " t.`inv_total_invoice`,"
                + " t.`inv_total_icms`,"
                + " t.`inv_base_icms`,"
                + " t.`inv_value_duty`,"
                + " t.`inv_value_others`,"
                + " t.`inv_value_subistitution`,"
                + " t.`inv_value_products`,"
                + " t.`inv_transporter`,"
                + "  t.`inv_observation`,"
                + " p.`idtbl_product_invoice`,"
                + " p.`idtbl_invoice`,"
                + " p.`prod_bar_code_product`,"
                + " p.`prod_inv_description_product`,"
                + " p.`prod_inv_cost_price`,"
                + " p.`prod_inv_quantity`,"
                + " p.`prod_inv_observation` FROM tbl_invoice t INNER JOIN tbl_product_invoice p ON t.`idtbl_invoice` = p.`idtbl_invoice` WHERE t.`idtbl_invoice` = ?  AND p.`idtbl_product_invoice` = ? ;";

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setObject(1, valueAt);
            ps.setObject(2, valueAt2);

            rs = ps.executeQuery();
            System.err.println("ARG NO CONSULT PRODUCT:::" + valueAt2);

            while (rs.next()) {

                invoice.setDescriptionProductInvoice(rs.getString("prod_inv_description_product"));
                invoice.setCodBarProductInvoice(rs.getString("prod_bar_code_product"));
                invoice.setValueProductInvoice(rs.getDouble("prod_inv_cost_price"));
                invoice.setQuantityProductInvoice(rs.getDouble("prod_inv_quantity"));
                invoice.setObservationProductInvoice(rs.getString("prod_inv_observation"));

                invoice.setIdInvoice(rs.getString("idtbl_invoice"));
                invoice.setNumberInvoice(rs.getInt("inv_number_invoice"));
                invoice.setFilialInvoice(rs.getInt("inv_filial"));
                invoice.setDateEntryInvoice(FormatDate.formatDateSQL(rs.getString("inv_date_entry")));
                invoice.setSeriesInvoive(rs.getInt("inv_series_invoice"));
                invoice.setDateEmissionInvoice(FormatDate.formatDateSQL(rs.getString("inv_date_emission")));
                invoice.setValueTotalInvoice(rs.getBigDecimal("inv_total_invoice"));
                invoice.setValueAllProductsInvoice(rs.getString("inv_value_products"));
                invoice.setValueDutyInvoice(rs.getBigDecimal("inv_value_duty"));
                invoice.setValueOthersInvoice(rs.getBigDecimal("inv_value_others"));
                invoice.setValueSubstInvoice(rs.getBigDecimal("inv_value_subistitution"));
                invoice.setBaseIcmsInvoice(rs.getBigDecimal("inv_base_icms"));
                invoice.setTotalIcmsInvoice(rs.getBigDecimal("inv_total_icms"));
                invoice.setTransporter(rs.getString("inv_transporter"));
                invoice.setObservationInvoice(rs.getString("inv_observation"));

            }
            System.err.println("Value product no invoice::" + invoice.getValueProductInvoice());

            /*

     
             */
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProductInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }

        return invoice;
    }

    public static List<String> allVendor() {

        String sql = "SELECT idtbl_vendor FROM tbl_vendor ;";
        List<String> list = new ArrayList<>();

        try {

            stmt = Conn.connect().createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                list.add(rs.getString("idtbl_vendor"));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProductInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
