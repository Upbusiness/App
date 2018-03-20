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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import xml.NewXML;

/**
 *
 * @author Rafael recalcatti
 */
public class ClassRefreshLots {

    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static final ReserveIn reserveIn = new ReserveIn();
    private static final DecimalFormat v = new DecimalFormat("0.000");
    private static final NewXML newXML = new NewXML();

    public static void refreshLot(String idCoupon) {

        List<String> listBarCodes = new ArrayList<>();
        List<Double> listQuantitys = new ArrayList<>();
        int count;

        try {

            //AQUI CAPTURA OS CODIGOS DE BARRA DOS PRODUSTO DO CUPOM INFORMADO 
            conn = Conn.connect();
            ps = conn.prepareStatement("SELECT  pc.`prod_bar_code_product`, pc.`quantity_iten` AS quantity_iten, pc.`product_quantity` AS prod_qtd FROM tbl_product_coupon pc WHERE idtbl_coupon = ? AND pc.`isToCancel` !=1;");
            ps.setString(1, idCoupon);
            rs = ps.executeQuery();

            while (rs.next()) {

                //if (!listBarCodes.contains(rs.getString("prod_bar_code_product"))) {
                listBarCodes.add(rs.getString("prod_bar_code_product"));
                listQuantitys.add(rs.getDouble("prod_qtd"));

                //  }
            }

            //AQUI CAPTURA AS QUANTIDADES DOS PRODUTOS DO CUPOM INFORMADO
            for (int i = 0; i < listBarCodes.size(); i++) {

                System.out.println("LIST PRODUCT USED::>>>>>>>>>>>>>>>>>>>>>" + listBarCodes + listQuantitys);
                System.out.println("LIST BARCODE ON USE::>>>>>>>>>>>>>>>>>>>>>" + listBarCodes.get(i));
                System.out.println("LIST QTD ON USE::>>>>>>>>>>>>>>>>>>>>>" + listQuantitys.get(i));
                double par = listQuantitys.get(i);
                boolean control = false;
                count = 1;

                while (count != 0) {
                    ps = conn.prepareStatement("SELECT i.`inv_quantity_insert`, i.`inv_value_used`,i.`idtbl_reserve_in` FROM tbl_reserve_in i WHERE i.`inv_isClosed` = 0 AND i.`inv_inUse` = 1 AND i.`prod_bar_code_product` = ? ;");
                    ps.setString(1, listBarCodes.get(i));
                    rs = ps.executeQuery();
                    if (rs.next()) {

                        double valuelaunchReserve = rs.getDouble("inv_quantity_insert");
                        double valueUsedReserve = rs.getDouble("inv_value_used");

                        if (((valuelaunchReserve - valueUsedReserve) > par)) {

                            control = true;

                        } else {

                            par = par - (valuelaunchReserve - valueUsedReserve);

                        }

                        if (control) {

                            count = 0;
                            ps = conn.prepareStatement("UPDATE tbl_reserve_in i  SET  i.`inv_value_used` = i.`inv_value_used` + ? WHERE i.`inv_isClosed` = 0 AND i.`inv_inUse` = 1 AND i.`prod_bar_code_product` = ? ;");
                            ps.setDouble(1, par);
                            ps.setString(2, listBarCodes.get(i));
                            if (ps.executeUpdate() == 1) {
                                System.err.println("VALUE USED ON ACTUAL RESERVE ACTUALIZED WITH SUSSEFUL");
                            } else {
                                System.err.println("ERROR ON REFRESH ACTUAL RESERVE");
                            }
                        } else {

                            //SENÃO FECHA O LOTE ATUAL
                            ps = conn.prepareStatement("UPDATE tbl_reserve_in i SET i.`inv_isClosed` = 1 ,  i.`inv_verify_expiring` = 1, i.`inv_inUse` = 0 , i.`inv_value_used` = i.`inv_quantity_insert`    WHERE  i.`inv_inUse` = 1 AND i.`prod_bar_code_product` = ? ORDER BY i.`inv_date_expiring` LIMIT 1;");
                            ps.setString(1, listBarCodes.get(i));
                            if (ps.executeUpdate() == 1) {
                                System.err.println("LOT CLOSED.");
                            } else {
                                System.err.println("ERROR CLOSER LOT!!!");
                            }
                            //E ABRE NOVO LOTE
                            ps = conn.prepareStatement("UPDATE tbl_reserve_in i SET  i.`inv_inUse` = 1  WHERE i.`inv_isClosed` = 0 AND i.`prod_bar_code_product` = ? ORDER BY i.`inv_date_expiring` LIMIT 1;");
                            ps.setString(1, listBarCodes.get(i));
                            if (ps.executeUpdate() == 1) {
                                System.err.println("NEW LOT OPENED AND ACTUALIZED VALUE USED THIS.");
                            } else {
                                System.err.println("ERROR ON OPENING LOT!!!");
                            }

                        }

                        System.err.println("RESREVE REFRESH::" + listQuantitys + "-" + listBarCodes);

                    } else {
                        System.err.println("LIST NOT USED::" + listBarCodes + listQuantitys);
                        count = 0;
                    }
                }

            }
            listQuantitys.clear();
            listBarCodes.clear();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            System.err.println("LIST NOT USED::" + listQuantitys);

        }

    }

    public static void setLaunch(String code) {

        try {

            conn = Conn.connect();

            ps = conn.prepareStatement("UPDATE tbl_coupon SET isLaunch = 1 WHERE idtbl_coupon = ? ;");
            ps.setString(1, code);
            ps.executeUpdate();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }
    }

    public static boolean refreshLotReserveOut(String barCode, double quantitys) {

        boolean control = false;
        double par = quantitys;

        try {
            ps = conn.prepareStatement("SELECT i.`inv_quantity_insert`, i.`inv_value_used`,i.`idtbl_reserve_in` FROM tbl_reserve_in i WHERE i.`inv_isClosed` = 0 AND i.`inv_inUse` = 1 AND i.`prod_bar_code_product` = ? ;");
            ps.setString(1, barCode);
            rs = ps.executeQuery();
            if (rs.next()) {

                double valuelaunchReserve = rs.getDouble("inv_quantity_insert");
                double valueUsedReserve = rs.getDouble("inv_value_used");

                if (((valuelaunchReserve - valueUsedReserve) > par)) {

                    control = true;

                } else {

                    par = par - (valuelaunchReserve - valueUsedReserve);

                }

                if (control) {

                    ps = conn.prepareStatement("UPDATE tbl_reserve_in i  SET  i.`inv_value_used` = i.`inv_value_used` + ? WHERE i.`inv_isClosed` = 0 AND i.`inv_inUse` = 1 AND i.`prod_bar_code_product` = ? ;");
                    ps.setDouble(1, par);
                    ps.setString(2, barCode);
                    if (ps.executeUpdate() == 1) {
                        System.err.println("VALUE USED ON ACTUAL RESERVE ACTUALIZED WITH SUSSEFUL");
                    } else {
                        System.err.println("ERROR ON REFRESH ACTUAL RESERVE");
                    }
                } else {

                    //SENÃO FECHA O LOTE ATUAL
                    ps = conn.prepareStatement("UPDATE tbl_reserve_in i SET i.`inv_isClosed` = 1 ,  i.`inv_verify_expiring` = 1, i.`inv_inUse` = 0 , i.`inv_value_used` = i.`inv_quantity_insert`    WHERE  i.`inv_inUse` = 1 AND i.`prod_bar_code_product` = ? ORDER BY i.`inv_date_expiring` LIMIT 1;");
                    ps.setString(1, barCode);
                    if (ps.executeUpdate() == 1) {
                        System.err.println("LOT CLOSED.");
                    } else {
                        System.err.println("ERROR CLOSER LOT!!!");
                    }
                    //E ABRE NOVO LOTE
                    ps = conn.prepareStatement("UPDATE tbl_reserve_in i SET  i.`inv_inUse` = 1  WHERE i.`inv_isClosed` = 0 AND i.`prod_bar_code_product` = ? ORDER BY i.`inv_date_expiring` LIMIT 1;");
                    ps.setString(1, barCode);
                    if (ps.executeUpdate() == 1) {
                        System.err.println("NEW LOT OPENED AND ACTUALIZED VALUE USED THIS.");

                    } else {
                        System.err.println("ERROR ON OPENING LOT!!!");
                    }

                }

                return true;

            } else {

                return false;
            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;

        }

    }

    public static List<String> allCoupons() {

        List<String> list = new ArrayList<>();

        try {
            conn = Conn.connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT t.`idtbl_coupon` FROM tbl_coupon t WHERE isLaunch = 0;");

            while (rs.next()) {
                list.add(rs.getString("idtbl_coupon"));
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

        return list;
    }

}
