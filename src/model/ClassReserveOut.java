/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.ReserveOut;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.JDialogRegisterVendor_3_1;
import xml.NewXML;

/**
 *
 * @author root
 */
public class ClassReserveOut {

    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static final ReserveOut reserveOut = new ReserveOut();
    private static final DecimalFormat v = new DecimalFormat("0.000");
    private static final NewXML newXML = new NewXML();

    public static boolean newLaunchReserveOut(ReserveOut out) {

        try {

            conn = Conn.connect();
            ps = conn.prepareStatement("INSERT INTO tbl_reserve_out VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, out.getIdReserveOut());
            ps.setString(2, out.getBarCodeProductReserveOut());
            ps.setString(3, out.getDateRegisterReserveOut());
            ps.setString(4, out.getLotProductReserveOut());
            ps.setDouble(5, out.getQuantityRemoveReserveOut());
            ps.setObject(6, out.getDescriptionReserveOut());
            ps.setString(7, out.getObservationReserveOut());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(ClassReserveIn.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }
    }

    public static ReserveOut consultProductReserveOut() {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT t.`prod_bar_code_product`, t.`prod_description_product`, t.`prod_reserve_actual_product` FROM tbl_product t WHERE t.`prod_bar_code_product` = ?;");
            ps.setString(1, (String) ReserveOut.getBean());
            rs = ps.executeQuery();

            boolean resultado = rs.next();

            if (resultado) {

                reserveOut.setBarCodeProductReserveOut(rs.getString("prod_bar_code_product"));
                reserveOut.setDescriptionProductReserveOut(rs.getString("prod_description_product"));
                reserveOut.setQuantityActualReserveOut(Double.parseDouble(v.format(rs.getDouble("prod_reserve_actual_product")).replace(",", ".")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

        return reserveOut;
    }

    public static double actualProductReserve(String arg) {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT  t.`prod_reserve_actual_product` FROM tbl_product t WHERE t.`prod_bar_code_product` = ?;");
            ps.setString(1, arg);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("prod_reserve_actual_product");
            } else {
                return 0.000;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassReserveIn.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return 0.000;
        }

    }

    public static ReserveOut consultReserveOUT(String arg) {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT t.`idtbl_reserve_out`,"
                    + " t.`data_register_output`,"
                    + " t.`lot_product_output`,"
                    + " t.`description_output`,"
                    + " t.`quantity_output`,"
                    + " t.`observation_output`,"
                    + " t.`prod_bar_code_product`,"
                    + " p.`prod_description_product`"
                    + " FROM tbl_reserve_out t INNER JOIN tbl_product p ON t.`prod_bar_code_product` = p.`prod_bar_code_product` WHERE t.`idtbl_reserve_out` = ? ;");

            ps.setString(1, arg);
            rs = ps.executeQuery();

            if (rs.next()) {

                reserveOut.setIdReserveOut(rs.getString("idtbl_reserve_out"));
                reserveOut.setBarCodeProductReserveOut(rs.getString("prod_bar_code_product"));
                reserveOut.setDescriptionProductReserveOut(rs.getString("prod_description_product"));
                reserveOut.setDateRegisterReserveOut(rs.getString("data_register_output"));
                reserveOut.setQuantityRemoveReserveOut(rs.getDouble("quantity_output"));
                reserveOut.setLotProductReserveOut(rs.getString("lot_product_output"));
                reserveOut.setDescriptionReserveOut(rs.getString("description_output"));
                reserveOut.setObservationReserveOut(rs.getString("observation_output"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

        return reserveOut;
    }

    public static boolean deleteReserveOut(ReserveOut out) {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("DELETE FROM tbl_reserve_out  WHERE idtbl_reserve_out =  ? ");
            ps.setString(1, out.getIdReserveOut());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

}
