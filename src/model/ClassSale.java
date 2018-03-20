/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.BeanConfig;
import action.BeanDetailSale;
import action.PaymentCoupon;
import action.Sale;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import util.JTextFieldTools;
import view.ClassPrintCoupon;
import static view.JFrameSale_1.*;
import xml.NewXML;

/**
 *
 * @author Rafiusks
 */
public class ClassSale {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final Connection conn = Conn.connect();
    private static final List<String> list_type_pay_coupon = new ArrayList<>();
    private static final List<Double> list_value_pay_coupon = new ArrayList<>();
    private static final List<Double> list_value_cash_pay_coupon = new ArrayList<>();
    private static final NewXML newXML = new NewXML();
    private static boolean isCigarreteAddPrice;
    private static ClassPrintCoupon cpc;
    private static final DecimalFormat v = new DecimalFormat("0.00");

    public static int searchProduct(String productCode, boolean isCoolingRate, double valueCoolingRate, boolean isTab1, boolean isTab2) {

        Pattern p = Pattern.compile("[0-9]");
        System.out.println("BAR CODE:::::::::::" + productCode);
        String sql;
        isCigarreteAddPrice = BeanConfig.isIsAddCigarreteRate();

        if (isCigarreteAddPrice) {

            sql = "SELECT  t.`prod_description_product`,"
                    + " t.`prod_abbreviature`,"
                    + "  t.`idtbl_unity_measure`,"
                    + "   CASE WHEN  t.`idtbl_category_product` = 70 AND (SUBSTRING(?,1,1) = 'D')"
                    + "        THEN (CASE WHEN CURRENT_TIME() BETWEEN '1:00:00' AND '6:00:00' THEN CEIL(t.`prod_price_tab1_product`) ELSE t.`prod_price_tab1_product` END)"
                    + "        WHEN  t.`idtbl_category_product` = 70 AND (SUBSTRING(?,1,1) = 'C')"
                    + "        THEN (CASE WHEN CURRENT_TIME() BETWEEN '1:00:00' AND '6:00:00' THEN CEIL(t.`prod_price_tab2_product`) ELSE t.`prod_price_tab2_product` END)"
                    + "        WHEN  t.`idtbl_category_product` = 70"
                    + "        THEN (CASE WHEN CURRENT_TIME() BETWEEN '1:00:00' AND '6:00:00' THEN CEIL(t.`prod_price_sale_actual_product`) ELSE t.`prod_price_sale_actual_product` END)"
                    + "        WHEN (SUBSTRING(?,1,1) = 'D')"
                    + "        THEN  t.`prod_price_tab1_product`"
                    + "        WHEN (SUBSTRING(?,1,1) = 'C')"
                    + "        THEN  t.`prod_price_tab2_product`"
                    + "        ELSE t.`prod_price_sale_actual_product`"
                    + "        END AS prod_price_sale_actual_product, c.`description_category`, t.`prod_price_tab1_product`, t.`prod_price_tab2_product`, t.`prod_price_purchase_product`, t.`prod_isActive` FROM tbl_product t INNER JOIN tbl_category_product c ON  t.`idtbl_category_product` =  c.`idtbl_category_product` WHERE t.`prod_bar_code_product` = ?;";

        } else {

            sql = "SELECT t.`prod_description_product`, t.`prod_abbreviature`, t.`idtbl_unity_measure`, t.`prod_price_sale_actual_product` AS prod_price_sale_actual_product,  c.`description_category`, t.`prod_price_tab1_product`, t.`prod_price_tab2_product`, t.`prod_price_purchase_product`, t.`prod_isActive` FROM tbl_product t INNER JOIN tbl_category_product c ON  t.`idtbl_category_product` =  c.`idtbl_category_product` WHERE t.`prod_bar_code_product` = ?;";

        }

        try {

            ps = conn.prepareStatement(sql);
            if (isCigarreteAddPrice) {
                ps.setString(1, productCode);
                ps.setString(2, productCode);
                ps.setString(3, productCode);
                ps.setString(4, productCode);
                ps.setString(5, (productCode.substring(0, 1).equalsIgnoreCase("c") || productCode.substring(0, 1).equalsIgnoreCase("d")) ? (productCode.substring(1)) : productCode);
            } else {
                ps.setString(1, productCode);
            }
            rs = ps.executeQuery();

            System.out.println("COD::" + productCode);
            if (rs.next()) {

                if (rs.getInt("prod_isActive") == 1) {

                    Sale.setProductName(rs.getString("prod_description_product"));
                    Sale.setProductCost(rs.getDouble("prod_price_purchase_product"));
                    if (isTab1) {
                        if (isCoolingRate) {
                            if ((rs.getString("description_category").toUpperCase().contains("BEBIDAS")) || (rs.getString("description_category").toUpperCase().contains("CERVEJAS") || rs.getString("description_category").toUpperCase().contains("REFRIGERANTES"))) {
                                Sale.setProductPrice(rs.getDouble("prod_price_tab1_product") + valueCoolingRate);
                            } else {
                                Sale.setProductPrice(rs.getDouble("prod_price_tab1_product"));
                            }
                        } else {
                            Sale.setProductPrice(rs.getDouble("prod_price_tab1_product"));
                        }
                    } else if (isTab2) {
                        if (isCoolingRate) {
                            if ((rs.getString("description_category").toUpperCase().contains("BEBIDAS")) || (rs.getString("description_category").toUpperCase().contains("CERVEJAS") || rs.getString("description_category").toUpperCase().contains("REFRIGERANTES"))) {
                                Sale.setProductPrice(rs.getDouble("prod_price_tab2_product") + valueCoolingRate);
                            } else {
                                Sale.setProductPrice(rs.getDouble("prod_price_tab2_product"));
                            }
                        } else {
                            Sale.setProductPrice(rs.getDouble("prod_price_tab2_product"));
                        }

                    } else {
                        if (isCoolingRate) {
                            if ((rs.getString("description_category").toUpperCase().contains("BEBIDAS")) || (rs.getString("description_category").toUpperCase().contains("CERVEJAS") || rs.getString("description_category").toUpperCase().contains("REFRIGERANTES"))) {
                                Sale.setProductPrice(rs.getDouble("prod_price_sale_actual_product") + valueCoolingRate);
                            } else {
                                Sale.setProductPrice(rs.getDouble("prod_price_sale_actual_product"));
                            }
                        } else {
                            Sale.setProductPrice(rs.getDouble("prod_price_sale_actual_product"));
                        }
                    }

                    Sale.setCategoryName(rs.getString("description_category").toUpperCase());
                    Sale.setProductAbbreviature(rs.getString("prod_abbreviature"));
                    Sale.setUnityMeasure(rs.getString("idtbl_unity_measure"));

                    return 0;

                } else {

                    return -1;
                }
            } else {

                return 1;

            }
        } catch (SQLException ex) {
            ////newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return 1;

        }
    }

    public static boolean newSale(String cod, String id_cashier, String terminal, String user) {

        String sql = "INSERT INTO tbl_coupon VALUES(?,?,?,NOW(),NULL,0,0,?,0,0,0,0)";
        isGenerateCodeCoupon = false;

        try {

            //JOptionPane.showMessageDialog(null, "Vededor:"+user);
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, cod);
            ps.setString(2, id_cashier);
            ps.setString(3, user);
            ps.setString(4, terminal);

            if (ps.executeUpdate() == 1) {
                System.err.println("True");
                return true;

            } else {
                System.err.println("False");
                return false;

            }

        } catch (SQLException ex) {
            // //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }
    }

    public static boolean newProductCoupon(String codCoupon, double quantity, String barCode, double cost, double price, int number_iten) {

        String sql = "INSERT INTO tbl_product_coupon VALUES(0,?,?,?,?,?,0,?,?);";
        int qtd;
        if (quantity % 1 == 0) {

            qtd = (int) quantity;

        } else {

            qtd = 1;

        }
        try {

            ps = conn.prepareStatement(sql);
            ps.setObject(2, (barCode.substring(0, 1).equalsIgnoreCase("c") || barCode.substring(0, 1).equalsIgnoreCase("d")) ? (barCode.substring(1)) : barCode);
            ps.setObject(1, codCoupon);
            ps.setDouble(3, cost);
            ps.setDouble(4, price);
            ps.setDouble(5, quantity);
            ps.setInt(6, number_iten);
            ps.setInt(7, qtd);

            if (ps.executeUpdate() == 1) {

                return true;

            } else {
                System.err.println("False");
                return false;

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }
    }

    public static boolean totalSale(String cod_coupon) {

        String sql = "SELECT SUM(t.`quantity_iten`) AS quantity_sale,"
                + " SUM(ROUND(t.`product_quantity` * t.`product_price`,2)) AS price_total,"
                + " SUM(ROUND(t.`product_quantity` * t.`product_cost`,2)) AS cost_total "
                + " FROM tbl_product_coupon t INNER JOIN tbl_product p ON "
                + "t.prod_bar_code_product = p.prod_bar_code_product "
                + "WHERE t.`idtbl_coupon` = ? AND t.quantity_iten >= 1 ORDER BY t.`idtbl_product_coupon` DESC;";

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, cod_coupon);
            rs = ps.executeQuery();

            if (rs.next()) {

                Sale.setQuantityTotal(rs.getInt("quantity_sale"));
                Sale.setPriceTotal(rs.getDouble("price_total"));
                Sale.setCostTotal(rs.getDouble("cost_total"));
                System.err.println("PRICE TOTAL COUPON:::" + rs.getDouble("price_total"));
                System.err.println("COST TOTAL COUPON:::" + rs.getDouble("cost_total"));

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

    public static List<Object> allCards() {

        String sql = "SELECT t.`name_card`, t.`type_card` FROM tbl_cards t ORDER BY t.`name_card`;";
        List<Object> objects = new ArrayList<>();

        try {

            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                objects.add(rs.getString("name_card") + " " + rs.getString("type_card"));

            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

        return objects;
    }

    public static boolean closeSale(String cod, boolean isClosed, double totalCoupon, double cost_coupon, double discount_coupon) {

        String sql = "UPDATE tbl_coupon SET isClosed = ? , total_coupon = ? , cost_coupon = ? , discount_coupon = ? , date_hour_close_coupon = NOW()  WHERE idtbl_coupon = ? ;";

        try {

            System.err.println("COD COUPON::" + cod);
            System.err.println("isClosed Coupon::" + isClosed);
            ps = Conn.connect().prepareStatement(sql);
            ps.setBoolean(1, isClosed);
            ps.setDouble(2, totalCoupon);
            ps.setDouble(3, cost_coupon);
            ps.setDouble(4, discount_coupon);
            ps.setObject(5, cod);

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }
    }

    public static boolean setTypePayment(String cod_coupon, String type_payment, double value_type_payment, double valueCashPay, double discount_type_pay) {

        String sql = "INSERT INTO tbl_type_payment_coupon VALUES(0,?,?,?,0,?,?)";

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setObject(1, cod_coupon);
            ps.setObject(2, type_payment);
            ps.setDouble(3, value_type_payment);
            ps.setDouble(4, valueCashPay);
            ps.setDouble(5, discount_type_pay);

            if (ps.executeUpdate() == 1) {
                System.err.println("True");
                return true;

            } else {
                System.err.println("False");
                return false;

            }

        } catch (SQLException ex) {
            ////newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }
    }

    public static boolean conteinItenCancel(String codCoupon, String barCode, Double quantity_total, int numberIten, boolean isCancelByNumberIten) {
        String sql;
        if (isCancelByNumberIten) {
            System.err.println("NUMBER ITEN>>>>" + numberIten);
            sql = "SELECT c.`idtbl_product_coupon`, c.`prod_bar_code_product`, c.`idtbl_coupon`, c.`product_quantity`, c.`number_iten`, c.`product_price` FROM tbl_product_coupon c WHERE  c.`number_iten` = " + numberIten + " AND c.`idtbl_coupon` = '" + codCoupon + "'";
        } else {
            sql = "SELECT c.`idtbl_product_coupon`, c.`prod_bar_code_product`, c.`idtbl_coupon`, c.`product_quantity`, c.`number_iten`, c.`product_price` FROM tbl_product_coupon c WHERE  c.`prod_bar_code_product` = " + barCode + " AND c.`idtbl_coupon` = '" + codCoupon + "'";
        }
        boolean saida = false;
        System.err.println("SQL Cancel Item:");
        try {

            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.err.println("Quantidade informada::" + quantity_total + " Quantidade no DB::" + rs.getInt("product_quantity"));
                if (rs.getDouble("product_quantity") == quantity_total) {

                    codeProductCoupon = rs.getString("idtbl_product_coupon");
                    numberItenCancel = rs.getInt("number_iten");
                    valueItenCanceled = rs.getDouble("product_price") * quantity_total;
                    saida = true;
                }
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;

        }

        return saida;
    }

    public static int searchProductBalance(String productCode) {

        String sql = "SELECT t.`prod_description_product`, t.`prod_abbreviature`, t.`idtbl_unity_measure`,  t.`prod_price_sale_actual_product`, t.`prod_isActive` FROM tbl_product t WHERE prod_bar_code_product = ?;";

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, productCode);
            rs = ps.executeQuery();

            System.out.println("COD BALANCE::" + productCode);
            if (!rs.next()) {

                return 1;
                //atualiza o valor no DB    
                // productBalance(jTextProductCode.getText().substring(0,7), JTextFieldTools.formatJTextNumberString(jTextProductCode.getText().substring(7, 12)));
            } else {

                double price = Double.parseDouble(JTextFieldTools.formatJTextNumberString(jTextProductCode.getText().substring(7, 12)).replace(",", "."));
                BigDecimal r;

                // r = BigDecimal.valueOf(dinheiro - total);
                ps = Conn.connect().prepareStatement(sql);
                ps.setString(1, productCode);
                rs = ps.executeQuery();
                if (rs.next()) {

                    if (rs.getInt("prod_isActive") == 1) {

                        r = BigDecimal.valueOf(price / rs.getDouble("prod_price_sale_actual_product"));
                        Sale.setProductName(rs.getString("prod_description_product"));
                        Sale.setProductPrice(rs.getDouble("prod_price_sale_actual_product"));
                        Sale.setQuantity(price / rs.getDouble("prod_price_sale_actual_product"));
                        Sale.setProductAbbreviature(rs.getString("prod_abbreviature"));
                        Sale.setUnityMeasure(rs.getString("idtbl_unity_measure"));
                        System.err.println("QUANTITY::::::::" + r);
                        return 0;
                    } else {

                        return -1;

                    }
                } else {

                    return 1;

                }
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return 1;

        }
    }

    public static boolean cancelProduct(String codCoupon, boolean isToCancel, Double quantity, String codProductCoupon, int numberIten, boolean isCancelByNumberIten) {

        try {

            if (isCancelByNumberIten) {

                ps = Conn.connect().prepareStatement("UPDATE tbl_product_coupon SET isToCancel = ? , product_quantity = ? , quantity_iten = ?  WHERE idtbl_coupon = ? AND number_iten = ?;");
                ps.setBoolean(1, isToCancel);
                ps.setDouble(2, quantity);
                ps.setInt(3, quantity.intValue());
                ps.setString(4, codCoupon);
                ps.setInt(5, numberIten);

            } else {

                ps = Conn.connect().prepareStatement("UPDATE tbl_product_coupon SET isToCancel = ? , product_quantity = ? , quantity_iten = ?  WHERE idtbl_coupon = ? AND idtbl_product_coupon = ? ;");
                ps.setBoolean(1, isToCancel);
                ps.setDouble(2, quantity);
                ps.setInt(3, quantity.intValue());
                ps.setString(4, codCoupon);
                ps.setString(5, codProductCoupon);
            }

            if (ps.executeUpdate() == 1) {
                System.err.println("Item cancelado.");
                return true;

            } else {
                System.err.println("Erro ao cancelar produto");
                return false;

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }
    }

    public static void clearTypePayment(String codeCoupon) {

        try {

            ps = Conn.connect().prepareStatement("DELETE FROM tbl_type_payment_coupon  WHERE idtbl_coupon = ?;");
            ps.setString(1, codeCoupon);
            ps.executeUpdate();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }
    }

    public static boolean setPriceProductStandart(double value) {

        try {

            ps = Conn.connect().prepareStatement("UPDATE tbl_product SET prod_price_sale_actual_product = ?  WHERE prod_bar_code_product = 0000000000001;");
            ps.setDouble(1, value);
            int res = ps.executeUpdate();

            if (res == 1) {

                return true;

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static boolean cancelCoupon(String arg) {

        try {

            ps = Conn.connect().prepareStatement("UPDATE tbl_coupon SET isCanceled = ? WHERE idtbl_coupon = ? AND isCanceled = 0;");
            ps.setBoolean(1, true);
            ps.setString(2, arg);

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean cancelTypePaymentCoupon(String arg) {

        try {

            ps = Conn.connect().prepareStatement("UPDATE tbl_type_payment_coupon SET isCanceled = 1 WHERE idtbl_coupon = ?;");
            ps.setString(1, arg);
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static void refreshReserve(String arg, boolean isAddInventory) {

        try {

            List<String> listId = new ArrayList<>();
            List<Integer> listArg = new ArrayList<>();
            ps = Conn.connect().prepareStatement("SELECT  pc.`prod_bar_code_product`,"
                    + " SUM(pc.`quantity_iten`) AS quantity_iten,"
                    + " SUBSTRING(p.`prod_abbreviature`,(LENGTH(p.`prod_abbreviature`)-3),1) AS qtd_promo FROM tbl_product_coupon pc INNER JOIN tbl_product p ON pc.`prod_bar_code_product` = p.`prod_bar_code_product` WHERE idtbl_coupon = ? AND pc.`isToCancel` !=1 GROUP BY pc.`prod_bar_code_product`;");
            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                if(rs.getString("prod_bar_code_product").startsWith("p") || rs.getString("prod_bar_code_product").startsWith("P")){
                
                listId.add(rs.getString("prod_bar_code_product").replace("p", "").replace("P", ""));
                listArg.add(rs.getInt("quantity_iten") * Integer.parseInt(rs.getString("qtd_promo")));
                listId.add(rs.getString("prod_bar_code_product"));
                listArg.add(rs.getInt("quantity_iten"));
                
                }else{
                    
                listId.add(rs.getString("prod_bar_code_product"));
                listArg.add(rs.getInt("quantity_iten"));
                
                }

            }
            System.err.println("QTD::"+listArg.toString());
            if (isAddInventory) {
                ps = Conn.connect().prepareStatement("UPDATE tbl_product SET prod_reserve_actual_product = prod_reserve_actual_product + ?  WHERE prod_bar_code_product = ?;");
            } else {
                ps = Conn.connect().prepareStatement("UPDATE tbl_product SET prod_reserve_actual_product = prod_reserve_actual_product - ? WHERE prod_bar_code_product = ?;");
            }
            for (int i = 0; i < listId.size(); i++) {

                ps.setString(2, listId.get(i));
                ps.setInt(1, listArg.get(i));
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

    }

    public static String cancelLastCouponClosed(String terminal) {

        try {

            ps = Conn.connect().prepareStatement("SELECT `idtbl_coupon` FROM tbl_coupon  WHERE terminal_coupon = ? AND isClosed = 1 ORDER BY date_hour_coupon DESC LIMIT 1;");
            ps.setString(1, terminal);
            rs = ps.executeQuery();
            String arg = null;

            while (rs.next()) {

                arg = rs.getString("idtbl_coupon");

            }

            ps = Conn.connect().prepareStatement("UPDATE tbl_coupon SET isCanceled = 1 WHERE idtbl_coupon = ?;");
            ps.setString(1, arg);

            if (ps.executeUpdate() == 1) {
                cancelTypePaymentCoupon(arg);
                return arg;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return null;

        }

    }

    public static boolean reprintCoupon(String arg, boolean validate) {

        list_value_cash_pay_coupon.clear();
        cpc = new ClassPrintCoupon();
        double v1 = 0;
        String dateHour = null;
        list_type_pay_coupon.clear();
        list_value_pay_coupon.clear();
        try {

            ps = Conn.connect().prepareStatement("SELECT  t.`description_type_payment_coupon`, t.`value_type_payment_coupon`, t.`cashPay`, c.`total_coupon`, DATE_FORMAT(c.`date_hour_coupon`,'%d/%m/%Y %H:%i:%s' ) AS date_hour FROM tbl_type_payment_coupon t INNER JOIN tbl_coupon c ON t.`idtbl_coupon` = c.`idtbl_coupon` WHERE t.`idtbl_coupon` = ? AND t.`isCanceled` = 0;");

            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                dateHour = rs.getString("date_hour");
                list_type_pay_coupon.add(rs.getString("description_type_payment_coupon"));
                list_value_pay_coupon.add(rs.getDouble("value_type_payment_coupon"));
                list_value_cash_pay_coupon.add(rs.getDouble("cashPay"));
                v1 = rs.getDouble("total_coupon");
            }

            cpc.printHeaderCoupon(true, arg, dateHour, idCashier, headerCoupon);

            ps = Conn.connect().prepareStatement("SELECT c.`idtbl_coupon`,"
                    + " pc.`prod_bar_code_product`,"
                    + " pc.`product_price`,"
                    + " pc.`product_quantity`,"
                    + " pc.`number_iten`,"
                    + " pc.`quantity_iten`,"
                    + " p.`idtbl_unity_measure`,"
                    + " p.`prod_abbreviature` FROM tbl_coupon c INNER JOIN tbl_product_coupon pc ON c.`idtbl_coupon` = pc.`idtbl_coupon` JOIN tbl_product p ON p.`prod_bar_code_product` = pc.`prod_bar_code_product` WHERE c.`idtbl_coupon`= ?;");

            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {

                boolean b = rs.getString("prod_bar_code_product").startsWith("2");
                ClassPrintCoupon.printLineCoupon(b, rs.getString("prod_bar_code_product"), rs.getDouble("product_price"), rs.getString("product_quantity"), rs.getString("idtbl_unity_measure"), rs.getString("prod_abbreviature"), rs.getInt("number_iten"));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;

        }
        System.err.println("VALUE PAY"+list_value_pay_coupon);
        System.err.println("TYPE PAY"+list_type_pay_coupon);
        System.err.println("VALUE CASH"+list_value_cash_pay_coupon);
        if (validate) {
            return cpc.printFooterCoupon(true, list_value_pay_coupon, list_type_pay_coupon, v1, 0, list_value_cash_pay_coupon, true, footerCoupon);
        } else {
            return cpc.printFooterCoupon(true, list_value_pay_coupon, list_type_pay_coupon, v1, 0, list_value_cash_pay_coupon, false, footerCoupon);
        }
    }

    public static boolean deleteSale(String sql) {

        try {

            stmt = Conn.connect().createStatement();
            return stmt.executeUpdate(sql) > 0;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);
            return false;
        }

    }

    public static BeanDetailSale detaialSale(String codeSale) {

        String sql = "SELECT c.`idtbl_coupon`,"
                + " DATE_FORMAT(c.`date_hour_coupon`, '%d/%m/%Y %H:%i') AS date_hour_coupon,"
                + " c.`isCanceled`,"
                + " c.`isClosed`,"
                + " c.`idtbl_user`,"
                + " c.`terminal_coupon`,"
                + " c.`total_coupon`,"
                + " c.`discount_coupon`"
                + " FROM tbl_coupon c INNER JOIN tbl_product_coupon pc ON c.`idtbl_coupon` = pc.`idtbl_coupon` INNER JOIN tbl_product p ON pc.`prod_bar_code_product` = p.`prod_bar_code_product` WHERE c.`idtbl_coupon` = ?;";
        BeanDetailSale detailSale = new BeanDetailSale();
        System.err.println("ARG DETAIL SALE::" + codeSale);
        try {
            System.out.println("SQL::" + sql);
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, codeSale);
            rs = ps.executeQuery();

            while (rs.next()) {

                detailSale.setCodeSale(rs.getString("idtbl_coupon"));
                detailSale.setDateHourSale(rs.getString("date_hour_coupon"));
                detailSale.setTerminal(rs.getInt("terminal_coupon"));
                detailSale.setIsCanceled(rs.getBoolean("isCanceled"));
                detailSale.setIsClosed(rs.getBoolean("isClosed"));
                detailSale.setUser(rs.getString("idtbl_user"));
                detailSale.setDiscount(rs.getDouble("discount_coupon"));
                detailSale.setTotal(rs.getDouble("total_coupon"));

            }
            System.out.println("TOTAL SALE::" + detailSale.getTotal());
        } catch (SQLException ex) {
            ////newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

        return detailSale;
    }

    public static String consultItenSale(String codeCoupon, int numberIten) {
        try {

            ps = Conn.connect().prepareStatement("SELECT t.`prod_bar_code_product` FROM tbl_product_coupon t WHERE t.`idtbl_coupon` = ? AND t.`number_iten` = ?;");
            ps.setString(1, codeCoupon);
            ps.setInt(2, numberIten);
            rs = ps.executeQuery();
            rs.next();

            return rs.getString("prod_bar_code_product");

        } catch (SQLException ex) {

            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return null;

        }
    }

    public static boolean registerPaymentAccountClient(String arg) {

        try {

            String sql = "UPDATE tbl_account SET `date_payment` = NOW() , `status_acount` = '1'  WHERE `idtbl_account` IN"+arg+";";            
            stmt = Conn.connect().createStatement();
            System.err.println("SQL:::"+sql);

            return stmt.executeUpdate(sql) == 1;

        } catch (SQLException ex) {

            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean registerSaleAccountClient(String CPF, String arg, double value) {

        try {

            String sql = "INSERT INTO tbl_account VALUES(0,?,(SELECT idtbl_client FROM tbl_client WHERE cpf_client = ?),NOW(),NULL,?,'0');";

            ps = Conn.connect().prepareStatement(sql);

            ps.setString(1, CPF);
            ps.setString(2, arg);
            ps.setDouble(3, value);

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {

            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }
    
    public static void paymentCoupon(String codCoupon) {

        String sql = "SELECT (SUM(t.`valor_pagamento` + t.`desconto_pagamento`) - ?) AS troco_pagamento, t.`valor_pagamento`, t.`desconto_pagamento` FROM tbl_pagamento_pedido t WHERE  t.`idtbl_pedido` = ? GROUP BY t.`idtbl_pedido`;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setDouble(1, PaymentCoupon.getTotalCoupon());
            ps.setString(2, codCoupon);

            rs = ps.executeQuery();

            if (rs.next()) {

                PaymentCoupon.setSmallCash(rs.getBigDecimal("troco_pagamento"));
                PaymentCoupon.setValuepayment(rs.getDouble("valor_pagamento"));
                PaymentCoupon.setDiscoutPayment(rs.getDouble("desconto_pagamento"));

            }
        } catch (SQLException e) {
            //System.err.println("ERRO::" + e);

        }

    }
    
    public static List<String> searchPaymentCoupon(String arg) {

        List<String> listaPag = new ArrayList<>();

        String sql = "SELECT  CASE  WHEN t.`idtbl_cartao` THEN '     CARTÃO:' ELSE '  DINHEIRO:' END AS tipo_pag, t.`valor_pagamento`, t.`desconto_pagamento`  FROM tbl_pagamento_pedido t LEFT JOIN tbl_cartao c ON t.`idtbl_cartao` = c.`idtbl_cartao` WHERE t.`idtbl_pedido` = ?;";
        double soma = 0;
        double desconto = 0;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {
                listaPag.add(rs.getString("tipo_pag") + "  " + v.format(rs.getDouble("valor_pagamento")));
                if (rs.getDouble("desconto_pagamento") != 0.00) {
                    listaPag.add("DESCONTO:  " + v.format(rs.getDouble("desconto_pagamento")));
                    desconto += rs.getDouble("desconto_pagamento");
                }
                soma += rs.getDouble("valor_pagamento");
            }
            listaPag.add("                      ______");
            listaPag.add("         SOMA:  " + v.format(soma + desconto));
        } catch (SQLException ex) {
            Logger.getLogger(ClassSale.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPag;

    }


}
