/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xml.NewXML;

/**
 *
 * @author Rafiusk
 */
public class ClassInventory {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final Product bean = new Product();
    private static final boolean saida = false;
    private static final NewXML newXML = new NewXML();

    public static boolean newProduct(Product product) {

        try {

            String sql = "INSERT INTO tbl_product VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0,0,NOW(),NOW(),1);";

            ps = Conn.connect().prepareStatement(sql);

            ps.setString(1, product.getBarCodeProduct());
            ps.setString(2, product.getUnityMensurationProduct());
            ps.setObject(3, product.getCategoryProduct());
            ps.setInt(4, product.getTypeProductionProduct());
            ps.setString(5, product.getDescriptionProduct());
            ps.setString(6, product.getAbbreviature());
            ps.setDouble(7, product.getBudgetActual());
            ps.setDouble(8, product.getBudgetMin());
            ps.setDouble(9, product.getBudgetMax());
            ps.setDouble(10, product.getPriceBuyProduct());
            ps.setDouble(11, product.getPercentagemProfit());
            ps.setDouble(12, product.getPercentagemQuotaProduct());
            ps.setDouble(13, product.getPriceActualSale());
            ps.setDouble(14, product.getPriceTab1Sale());
            ps.setDouble(15, product.getPriceTab2Sale());
            ps.setDouble(16, product.getPriceMeanBuyProduct());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean refreshProduct(Product productInventory) {

        String sql = "UPDATE tbl_product t SET "
                + " idtbl_category_product = ?,"
                + " idtbl_unity_measure = ?,"
                + " prod_reserve_actual_product = ?,"
                + " prod_reserve_minimum_product = ?,"
                + " prod_reserve_maximum_product = ?, "
                + " prod_observation = ?,"
                + " prod_price_purchase_product = ?, "
                + " prod_control_reserve = ? ,"
                + " prod_price_sale_actual_product = ? "
                + "  WHERE prod_bar_code_product = ? ;";
        try {

            ps = Conn.connect().prepareStatement(sql);
            
            String cod_category = productInventory.getCategoryProduct().toString().substring(0,productInventory.getCategoryProduct().toString().indexOf("-")).trim();
            
            ps.setObject(1, cod_category);
            ps.setString(2, productInventory.getUnityMensurationProduct());
            ps.setDouble(3, productInventory.getBudgetActual());
            ps.setDouble(4, productInventory.getBudgetMin());
            ps.setDouble(5, productInventory.getBudgetMax());
            ps.setString(6, productInventory.getObservationProduct());
            ps.setDouble(7, productInventory.getPriceBuyProduct());
            ps.setBoolean(8, productInventory.isIsControlReserve());
            ps.setDouble(9, productInventory.getPriceActualSale());
            ps.setString(10, productInventory.getBarCodeProduct());
 
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public static Product consultProduct(String barCod) {

        String sql = "SELECT CONCAT(t.`idtbl_category_product`,' - ',c.`description_category`) AS idtbl_category_product,"
                + " t.`idtbl_unity_measure`,"
                + " t.`prod_bar_code_product`,"
                + " t.`prod_description_product`,"
                + " t.`prod_reserve_actual_product`,"
                + " t.`prod_reserve_minimum_product`,"
                + " t.`prod_reserve_maximum_product`,"
                + " t.`prod_price_purchase_product`,"
                + " t.`prod_percentage_profit_product`,"
                + " t.`prod_price_sale_actual_product`,"
                + " t.`prod_price_mean_purchase_product`,"
                + " t.`prod_observation`,"
                + " t.`prod_control_reserve`"
                + " FROM tbl_product t INNER JOIN tbl_category_product c ON t.`idtbl_category_product` =  c.`idtbl_category_product` WHERE t.`prod_bar_code_product` = ?";

        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, barCod);
            rs = ps.executeQuery();

            if(rs.next()) {
               
                
                bean.setCategoryProduct(rs.getString("idtbl_category_product").toUpperCase());
                bean.setUnityMensurationProduct(rs.getString("idtbl_unity_measure"));
                bean.setBarCodeProduct(rs.getString("prod_bar_code_product"));
                bean.setOldBarCodeProduct(rs.getString("prod_bar_code_product"));
                bean.setDescriptionProduct(rs.getString("prod_description_product"));
                bean.setBudgetActual(rs.getDouble("prod_reserve_actual_product"));
                bean.setBudgetMin(rs.getDouble("prod_reserve_minimum_product"));
                bean.setBudgetMax(rs.getDouble("prod_reserve_maximum_product"));
                bean.setPriceBuyProduct(rs.getDouble("prod_price_purchase_product"));
                bean.setPercentagemProfit(rs.getDouble("prod_percentage_profit_product"));
                bean.setPriceActualSale(rs.getDouble("prod_price_sale_actual_product"));
                bean.setPriceMeanBuyProduct(rs.getDouble("prod_price_mean_purchase_product"));
                bean.setObservationProduct(rs.getString("prod_observation"));
                bean.setIsControlReserve(rs.getBoolean("prod_control_reserve"));                
          
                return bean;
            }else{
                return null;
            }

            

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error on ClassProductInventory");
            return null;
        }
       

    }

    public static void vendorName() {

        String sql = "SELECT t.`idtbl_vendor`, t.`ven_name` FROM tbl_vendor t;";
        List<String> ven_name = new ArrayList<>();
        List<Object> ven_cod = new ArrayList<>();
        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                ven_cod.add(rs.getString("idtbl_vendor"));
                ven_name.add(rs.getString("idtbl_vendor") + " - " + rs.getString("ven_name").toUpperCase());

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void categoryName() {

        String sql = "SELECT idtbl_category_product,description_category FROM tbl_category_product";
        List<String> cat_name = new ArrayList<>();
        List<Object> cat_cod = new ArrayList<>();
        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                cat_cod.add(rs.getString("idtbl_category_product"));
                cat_name.add(rs.getString("idtbl_category_product") + " - " + rs.getString("description_category").toUpperCase());

            }
            System.out.println("COD CAT::" + cat_cod);
            System.out.println("COD+NAME CAT::" + cat_name);  

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Object verifyDaysForAlertExpiringLot() {

        String sql = "SELECT t.`days_control_expiring` FROM tbl_config t;";

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getObject("days_control_expiring");

        } catch (SQLException ex) {
            ////newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static int verifyExpiringLot() {

        String sql = "SELECT * FROM tbl_product t INNER JOIN tbl_reserve_in i ON t.`prod_bar_code_product` = i.`prod_bar_code_product`  WHERE  DATE_ADD(i.`inv_date_expiring`, INTERVAL -(SELECT t.`days_control_expiring` FROM tbl_config t) DAY) <= CURRENT_DATE()  AND  t.`prod_isActive` = 1  AND i.`inv_isControlExpiring` = 1 AND i.`inv_verify_expiring` = 0 AND i.`inv_isClosed` = 0 ORDER BY i.`inv_date_expiring`;";

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);
            rs.last();
            return rs.getRow();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }

    public static List<String> allCategorys() {

        String sql = "SELECT t.`idtbl_category_product`, t.`description_category`, t.`sector_category`, t.`observation_category`, t.`percentage_profit` FROM tbl_category_product t ORDER BY description_category;";
        List<String> cat = new ArrayList<>();
        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                cat.add(rs.getString("idtbl_category_product") + " - " + rs.getString("description_category").toUpperCase());

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cat;
    }
 

    public static String setSelectedLotExpiring(String par) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void setAlertExpiring() {

        String sql = "UPDATE tbl_config SET date_active_message = DATE_FORMAT(DATE_ADD(CURRENT_DATE(), INTERVAL 2 DAY),'%Y/%m/%d')";

        try {
            stmt = Conn.connect().createStatement();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }
    }

    public static boolean isAlertExpiring() {

        String sql = "SELECT * FROM tbl_config t WHERE t.`date_active_message` <= CURRENT_DATE();";

        try {

            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            return rs.next();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean setLotVerifyControl(List<String> list_arg, boolean isView) {

        try {

            String sql;
            if (isView) {
                sql = "UPDATE tbl_reserve_in t SET t.`inv_verify_expiring` = 1 WHERE t.`inv_lot` IN" + list_arg.toString().replace("[", "(").replace("]", ")") + ";";
            } else {
                sql = "UPDATE tbl_reserve_in t SET t.`inv_verify_expiring` = 0 WHERE t.`inv_lot` IN" + list_arg.toString().replace("[", "(").replace("]", ")") + ";";
            }

            stmt = Conn.connect().createStatement();

            return stmt.executeUpdate(sql) == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassInventory.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
    }

    public static boolean setDaysForAlertExipiring(String arg) {

        try {

            String sql = "UPDATE tbl_config t SET t.`days_control_expiring` = ? ;";

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
