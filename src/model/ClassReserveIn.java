/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.ReserveIn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.JDialogRegisterVendor_3_1;
import xml.NewXML;

/**
 *
 * @author CPU
 */
public class ClassReserveIn {

    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static final ReserveIn reserveIn = new ReserveIn();
    private static final DecimalFormat v = new DecimalFormat("0.000");
    private static final NewXML newXML = new NewXML();

    public static boolean newLaunchReserve(ReserveIn in) {

        double reserveActual = actualProductReserve(in.getBarCodeProductReserveIn());

        try {

            conn = Conn.connect();

            if ((in.getQuantityInsertReserveIn() + reserveActual) <= 0) {

                ps = conn.prepareStatement("INSERT INTO tbl_reserve_in VALUES(?,?,?,?,?,?,?,?,?,?,?,?,1,0,0,?)");
                ps.setString(1, in.getIdReserveIn());
                ps.setString(2, in.getBarCodeProductReserveIn());
                ps.setString(3, in.getDateRegister());
                ps.setString(4, v.format(in.getQuantityInsertReserveIn()).replace(",", "."));
                ps.setString(5, v.format(in.getQuantityRemainderReserveIn()).replace(",", "."));
                ps.setString(6, v.format(in.getQuantityInsertReserveIn()).replace(",", "."));
                ps.setDouble(7, in.getValueCoastProductReserveIn());
                ps.setString(8, in.getLotProductReserveIn());
                ps.setString(9, in.getDateProductionProductReserveIn());
                ps.setString(10, in.getDateExpiringProductReserveIn());
                ps.setInt(11, in.getMonthsForExipiringProductReserveIn());
                ps.setBoolean(12, in.isControlExpiring());
                ps.setInt(13, in.getPack());
                System.err.println("1° if");

            } else if ((in.getQuantityInsertReserveIn() + reserveActual) >= in.getQuantityInsertReserveIn()) {

                if ((in.getQuantityInsertReserveIn() + reserveActual) == in.getQuantityInsertReserveIn()) {
                    ps = conn.prepareStatement("INSERT INTO tbl_reserve_in VALUES(?,?,?,?,?,0.000,?,?,?,?,?,?,0,1,0,?)");
                } else {
                    ps = conn.prepareStatement("INSERT INTO tbl_reserve_in VALUES(?,?,?,?,?,0.000,?,?,?,?,?,?,0,0,0,?)");
                }
                ps.setString(1, in.getIdReserveIn());
                ps.setString(2, in.getBarCodeProductReserveIn());
                ps.setString(3, in.getDateRegister());
                ps.setString(4, v.format(in.getQuantityInsertReserveIn()).replace(",", "."));
                ps.setString(5, v.format(in.getQuantityRemainderReserveIn()).replace(",", "."));
                ps.setDouble(6, in.getValueCoastProductReserveIn());
                ps.setString(7, in.getLotProductReserveIn());
                ps.setString(8, in.getDateProductionProductReserveIn());
                ps.setString(9, in.getDateExpiringProductReserveIn());
                ps.setInt(10, in.getMonthsForExipiringProductReserveIn());
                ps.setBoolean(11, in.isControlExpiring());
                ps.setInt(12, in.getPack());
                System.err.println("2° if");
            } else if ((in.getQuantityInsertReserveIn() + reserveActual) < in.getQuantityInsertReserveIn()) {

                double val = (reserveActual * -1);
                ps = conn.prepareStatement("INSERT INTO tbl_reserve_in VALUES(?,?,?,?,?,?,?,?,?,?,?,?,0,1,0,?)");
                ps.setString(1, in.getIdReserveIn());
                ps.setString(2, in.getBarCodeProductReserveIn());
                ps.setString(3, in.getDateRegister());
                ps.setString(4, v.format(in.getQuantityInsertReserveIn()).replace(",", "."));
                ps.setString(5, v.format(in.getQuantityRemainderReserveIn()).replace(",", "."));
                ps.setString(6, v.format(val).replace(",", "."));
                ps.setDouble(7, in.getValueCoastProductReserveIn());
                ps.setString(8, in.getLotProductReserveIn());
                ps.setString(9, in.getDateProductionProductReserveIn());
                ps.setString(10, in.getDateExpiringProductReserveIn());
                ps.setInt(11, in.getMonthsForExipiringProductReserveIn());
                ps.setBoolean(12, in.isControlExpiring());
                ps.setInt(13, in.getPack());
                System.err.println("3° if");

            }

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassReserveIn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean deleteReserveIN(ReserveIn in) {

        try {

            conn = Conn.connect();
            ps = conn.prepareStatement("DELETE FROM tbl_reserve_in WHERE idtbl_reserve_in = ? ");
            ps.setString(1, in.getIdReserveIn());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static ReserveIn consultReserveIN(String arg) {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT t.`idtbl_reserve_in`,"
                    + " t.`prod_bar_code_product`,"
                    + " t.`inv_date_register`,"
                    + " t.`inv_quantity_insert`,"
                    + " t.`inv_remainder_reserve`,"
                    + " t.`inv_value_cost`,"
                    + " t.`inv_lot`,"
                    + " t.`inv_date_production`,"
                    + " t.`inv_date_expiring`,"
                    + " t.`inv_month_for_expiring`,"
                    + " p.`prod_description_product`,"
                    + " t.`inv_isControlExpiring`,"
                    + " t.`inv_packs`,"
                    + " t.`inv_month_for_expiring`"
                    + " FROM tbl_reserve_in t INNER JOIN tbl_product p ON t.`prod_bar_code_product` = p.`prod_bar_code_product` WHERE t.`idtbl_reserve_in` = ?;");

            ps.setString(1, arg);
            rs = ps.executeQuery();

            if (rs.next()) {

                reserveIn.setIdReserveIn(rs.getString("idtbl_reserve_in"));
                reserveIn.setBarCodeProductReserveIn(rs.getString("prod_bar_code_product"));
                reserveIn.setDescriptionProductReserveIn(rs.getString("prod_description_product"));
                reserveIn.setDateRegister(rs.getString("inv_date_register"));
                reserveIn.setQuantityInsertReserveIn(rs.getDouble("inv_quantity_insert"));
                reserveIn.setQuantityRemainderReserveIn(rs.getDouble("inv_remainder_reserve"));
                reserveIn.setValueCoastProductReserveIn(rs.getDouble("inv_value_cost"));
                reserveIn.setLotProductReserveIn(rs.getString("inv_lot"));
                reserveIn.setDateProductionProductReserveIn(rs.getString("inv_date_production"));
                reserveIn.setDateExpiringProductReserveIn(rs.getString("inv_date_expiring"));
                reserveIn.setMonthsForExipiringProductReserveIn(rs.getInt("inv_month_for_expiring"));
                reserveIn.setControlExpiring(rs.getBoolean("inv_isControlExpiring"));
                reserveIn.setPack(rs.getInt("inv_packs"));
                reserveIn.setMonthsForExipiringProductReserveIn(rs.getInt("inv_month_for_expiring"));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reserveIn;
    }

    public static ReserveIn consultProductReserve() {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT t.`prod_bar_code_product`, t.`prod_description_product`, t.`prod_reserve_actual_product` FROM tbl_product t WHERE t.`prod_bar_code_product` = ?;");
            ps.setString(1, (String) ReserveIn.getBean());
            rs = ps.executeQuery();

            boolean resultado = rs.next();

            if (resultado) {

                reserveIn.setBarCodeProductReserveIn(rs.getString("prod_bar_code_product"));
                reserveIn.setDescriptionProductReserveIn(rs.getString("prod_description_product"));
                reserveIn.setQuantityRemainderReserveIn(Double.parseDouble(v.format(rs.getDouble("prod_reserve_actual_product")).replace(",", ".")));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reserveIn;
    }

    public static double priceMeanBuyProduct(String arg) {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT AVG(t.`inv_value_cost`) AS price_mean FROM tbl_reserve_in t WHERE t.`prod_bar_code_product` = ? GROUP BY t.`prod_bar_code_product`;");
            ps.setString(1, arg);
            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getDouble("price_mean");
            } else {
                return 0.00;
            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error on ClassProduct");
            return 0.00;

        }

    }

    public static void updatePriceMeanBuyProduct(String arg, double value) {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("UPDATE tbl_product SET prod_price_mean_purchase_product =  ? WHERE prod_bar_code_product = ?");
            ps.setString(2, arg);
            ps.setDouble(1, value);
            ps.executeUpdate();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(JDialogRegisterVendor_3_1.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static int dateCalculatorFoward(String dateS, String dateE) {

        System.err.println("DATE::::" + dateS);
        int yearE = Integer.parseInt(dateE.substring(6, 10));
        int monthE = Integer.parseInt(dateE.substring(3, 5));

        int yearS = Integer.parseInt(dateS.substring(6, 10));
        int monthS = Integer.parseInt(dateS.substring(3, 5));

        Calendar cStart = Calendar.getInstance();

        cStart.set(Calendar.YEAR, yearS);
        cStart.set(Calendar.MONTH, monthS);

        Calendar cEnd = Calendar.getInstance();

        cEnd.set(Calendar.YEAR, yearE);
        cEnd.set(Calendar.MONTH, monthE);

        int difMonth = cEnd.get(Calendar.MONTH) - cStart.get(Calendar.MONTH);
        int difYear = ((cEnd.get(Calendar.YEAR) - cStart.get(Calendar.YEAR)) * 12);
        int total = difYear + difMonth;
        System.err.println("TOTAL:::::" + (total));
        return total;

    }

    public static String dateCalculatorReverse(String dateStart, int months) {

        int year = Integer.parseInt(dateStart.substring(6, 10));
        int month = Integer.parseInt(dateStart.substring(3, 5));
        int day = Integer.parseInt(dateStart.substring(0, 2));

        Calendar cDay = Calendar.getInstance();
        cDay.set(Calendar.YEAR, year);
        cDay.set(Calendar.MONTH, month);
        cDay.set(Calendar.DAY_OF_MONTH, day);

        cDay.add(Calendar.MONTH, +(months - 1));

        DateFormat FORMATO = new SimpleDateFormat("dd/MM/yyyy");
        return FORMATO.format(cDay.getTime());

    }

    public static double actualProductReserve(String arg) {

        try {
            System.err.println("ARG::" + arg);
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
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassReserveIn.class.getName()).log(Level.SEVERE, null, ex);
            return 0.000;
        }

    }

    public static double actualPriceMeanAllThisProduct(String arg) {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT AVG(t.`inv_value_cost`) AS price_mean FROM tbl_reserve_in t WHERE t.`prod_bar_code_product` = ?;");
            ps.setString(1, arg);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getDouble("price_mean");
            } else {
                return 0.000;
            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassReserveIn.class.getName()).log(Level.SEVERE, null, ex);
            return 0.000;
        }

    }

    public static double actualPriceMeanThisProductExistent(String arg) {

        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT SUM(t.`inv_quantity_insert` - t.`inv_value_used`)AS reserve , SUM(t.`inv_quantity_insert` - t.`inv_value_used`) * t.`inv_value_cost` AS value_reserve,  t.`idtbl_reserve_in` FROM tbl_reserve_in t WHERE t.`prod_bar_code_product` = ? AND t.`inv_isClosed` = 0 GROUP BY  t.`idtbl_reserve_in`;");
            ps.setString(1, (String) ReserveIn.getBean());
            rs = ps.executeQuery();
            double v1 = 0;
            double v2 = 0;
            double v3;
            while (rs.next()) {

                v1 += rs.getDouble("reserve");
                v2 += rs.getDouble("value_reserve");
            }

            v3 = v2 / v1;
            if (v3 > 0) {

                return v3;

            } else {

                return 0.000;
            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassReserveIn.class.getName()).log(Level.SEVERE, null, ex);
            return 0.000;
        }

    }

    public static boolean validLot(String argLot, String argBarCode) {
        try {
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT * FROM tbl_reserve_in t WHERE t.`prod_bar_code_product` = ? AND t.`inv_lot` = ?;");
            ps.setString(1, argBarCode);
            ps.setString(2, argLot);
            rs = ps.executeQuery();
            rs.last();

            return rs.getRow() > 0;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassReserveIn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
