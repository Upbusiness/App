/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.Product;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DateActual;
import xml.NewXML;

/**
 *
 * @author Rafiusk
 */
public class ClassProduct {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static boolean saida = false;
    private static final NewXML newXML = new NewXML();

    /**
     * Cadastra um novo produto e retorna verdadeiro se o cadastro foi efetuado
     * com sucesso
     *
     * @param product
     * @return boolean
     */
    public static boolean newProduct(Product product) {

        try {

            String sql = "INSERT INTO tbl_product VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW(),NOW(),1,null,1);";

            ps = Conn.connect().prepareStatement(sql);

            String cod_category = product.getCategoryProduct().toString().substring(0,product.getCategoryProduct().toString().indexOf("-")).trim();
            
            ps.setString(1, product.getBarCodeProduct());
            ps.setString(2, product.getUnityMensurationProduct());            
            ps.setObject(3, cod_category);
            ps.setInt(4, product.getTypeProductionProduct());
            ps.setString(5, product.getDescriptionProduct());
            ps.setString(6, product.getAbbreviature());
            ps.setDouble(7, product.getBudgetActual());
            ps.setDouble(8, product.getBudgetMin());
            ps.setDouble(9, product.getBudgetMax());
            ps.setDouble(10, product.getPriceBuyProduct());
            ps.setDouble(11, product.getPercentagemProfit());
            if (product.getAbbreviature().contains("DESCONTO")) {
                ps.setDouble(12, product.getPriceActualSale() * (-1));
                ps.setDouble(13, product.getPriceTab1Sale() * (-1));
                ps.setDouble(14, product.getPriceTab2Sale() * (-1));
            } else {
                ps.setDouble(12, product.getPriceActualSale());
                ps.setDouble(13, product.getPriceTab1Sale());
                ps.setDouble(14, product.getPriceTab2Sale());
            }
            ps.setDouble(15, product.getPriceMeanBuyProduct());
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    /**
     * Deleta um especifico produto com a passagem de parametro bar code product
     *
     * @param barCodProduct
     * @return boolean
     */
    public static boolean deleleteProduct(String barCodProduct) {

        try {
            System.err.println("Bar code no delete::" + barCodProduct);
            ps = Conn.connect().prepareStatement("DELETE FROM tbl_product WHERE prod_bar_code_product = ? ;");
            ps.setString(1, barCodProduct);

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean refreshProduct(Product product) {

        String sql = "UPDATE tbl_product t SET "
                + " idtbl_category_product = ? ,"
                + " idtbl_unity_measure = ? ,"
                + " prod_bar_code_product = ? ,"
                + " prod_description_product = ? ,"
                + " prod_type_production_product = ? ,"
                + " prod_reserve_actual_product = ? ,"
                + " prod_reserve_minimum_product = ? ,"
                + " prod_reserve_maximum_product = ? ,"
                + " prod_price_purchase_product = ? ,"
                + " prod_percentage_profit_product = ? ,"
                + " prod_price_sale_actual_product = ? ,"
                + " prod_price_tab1_product = ? ,"
                + " prod_price_tab2_product = ? ,"
                + " prod_price_mean_purchase_product = ? ,"
                + " prod_abbreviature = ? ,"
                + " prod_date_creation = ? ,"
                + " prod_date_last_modification = NOW(),"
                + " prod_isActive = ? "
                + "  WHERE prod_bar_code_product = ? ;";
        try {

            ps = Conn.connect().prepareStatement(sql);

            String cod_category = product.getCategoryProduct().toString().substring(0,product.getCategoryProduct().toString().indexOf("-")).trim();

            ps.setString(3, product.getBarCodeProduct());
            ps.setString(2, product.getUnityMensurationProduct());
            ps.setObject(1, cod_category);
            ps.setInt(5, product.getTypeProductionProduct());
            ps.setString(4, product.getDescriptionProduct());
            ps.setDouble(6, product.getBudgetActual());
            ps.setDouble(7, product.getBudgetMin());
            ps.setDouble(8, product.getBudgetMax());
            ps.setDouble(9, product.getPriceBuyProduct());
            ps.setDouble(10, product.getPercentagemProfit()); 
                ps.setDouble(11, product.getPriceActualSale());
                ps.setDouble(12, product.getPriceTab1Sale());
                ps.setDouble(13, product.getPriceTab2Sale());            
            ps.setString(18, product.getOldBarCodeProduct());
            ps.setString(15, product.getAbbreviature());
            ps.setString(16, product.getDateCreation());
            ps.setBoolean(17, product.isIsActiveProduct());
            ps.setDouble(14, product.getPriceMeanBuyProduct());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }
    }

    public static Product consultProduct(String arg) {

        Product product = new Product();
       

        try {

            ps = Conn.connect().prepareStatement("SELECT CONCAT(t.`idtbl_category_product`,' - ',c.`description_category`), t.`idtbl_unity_measure`, t.`prod_bar_code_product`, t.`prod_description_product`, t.`prod_type_production_product`, t.`prod_reserve_actual_product`, t.`prod_reserve_minimum_product`, t.`prod_reserve_maximum_product`,  t.`prod_price_purchase_product`, t.`prod_percentage_profit_product`, t.`prod_price_sale_actual_product`, t.`prod_price_tab1_product`, t.`prod_price_tab2_product`, AVG(i.`inv_value_cost`) AS price_mean, t.`prod_abbreviature`, t.`prod_date_creation`, t.`prod_date_last_modification`, t.`prod_isActive` FROM tbl_product t INNER JOIN tbl_category_product c ON t.`idtbl_category_product` =  c.`idtbl_category_product` LEFT JOIN tbl_reserve_in i ON t.`prod_bar_code_product` = i.`prod_bar_code_product` WHERE t.`prod_bar_code_product` = ? GROUP BY t.`prod_bar_code_product`;");
            ps.setString(1, arg);

            rs = ps.executeQuery();

            if (rs.next()) {

                System.err.println("CATEGORY::"+rs.getString(1).toUpperCase());
                product.setCategoryProduct(rs.getString(1).toUpperCase());
                product.setUnityMensurationProduct(rs.getString(2));
                product.setBarCodeProduct(rs.getString(3));
                product.setOldBarCodeProduct(rs.getString(3));
                product.setDescriptionProduct(rs.getString(4));
                product.setTypeProductionProduct(rs.getInt(5));
                product.setBudgetActual(rs.getDouble(6));
                product.setBudgetMin(rs.getDouble(7));
                product.setBudgetMax(rs.getDouble(8));
                product.setPriceBuyProduct(rs.getDouble(9));
                product.setPercentagemProfit(rs.getDouble(10));
                product.setPriceActualSale(rs.getDouble(11));
                product.setPriceTab1Sale(rs.getDouble(12));
                product.setPriceTab2Sale(rs.getDouble(13));
                product.setPriceMeanBuyProduct(rs.getDouble(14));
                product.setAbbreviature(rs.getString(15));
                product.setDateCreation((rs.getString(16)));
                product.setDateLastModification((rs.getString(17)));
                product.setIsActiveProduct(rs.getBoolean(18));                
                
                return product;
            }else{
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error on ClassProduct");
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);
            return  null;

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

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
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

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cat;
    }

    public static Object[][] allPerceProfitCategory() {

        String sql = "SELECT t.`idtbl_category_product`, t.`description_category`, t.`sector_category`, t.`observation_category`, t.`percentage_profit` FROM tbl_category_product t ORDER BY description_category;";
        Object[][] codCatProf = null;

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);
            rs.last();
            int count = rs.getRow();
            int sz = 0;
            int i = 0;
            for (int c = 0; c < count; c++) {
                sz++;
            }
            codCatProf = new Object[sz][sz];
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

                codCatProf[i][0] = rs.getString("idtbl_category_product");
                codCatProf[i][1] = rs.getDouble("percentage_profit");
                i++;
            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codCatProf;
    }

    public static List<String> vendorProduct(String arg) {

        List<String> cat = new ArrayList<>();
        try {
            ps = Conn.connect().prepareStatement("SELECT t.`idtbl_vendor`, t.`prod_bar_code_product`, v.`ven_name` FROM tbl_product_vendor t INNER JOIN tbl_vendor v ON v.`idtbl_vendor` = t.`idtbl_vendor` WHERE t.`prod_bar_code_product` = ?");
            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {

                cat.add(rs.getString("ven_name").toUpperCase());

            }

        } catch (SQLException ex) {

            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cat;
    }

    public static List<String> allUnityMeasure() {

        String sql = "SELECT idtbl_unity_measure FROM tbl_unity_measure;";
        List<String> cat = new ArrayList<>();
        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                cat.add(rs.getString("idtbl_unity_measure"));

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cat;
    }
    
    public static List<String> meanSaleLastYear(String arg) {

        String sql = "SELECT  SUM(pc.`product_quantity`) AS sum_qtd, p.`idtbl_unity_measure` AS un_measure, SUM(pc.`quantity_iten`) AS sum_sales, DATE_FORMAT(c.`date_hour_coupon`,'%m/%Y') AS mouth_year  FROM tbl_product_coupon pc INNER JOIN tbl_coupon c ON pc.`idtbl_coupon` = c.`idtbl_coupon` JOIN tbl_product p ON pc.`prod_bar_code_product` = p.`prod_bar_code_product`  WHERE pc.`prod_bar_code_product` = ? AND DATE_FORMAT(c.`date_hour_coupon`,'%Y') = DATE_FORMAT(NOW(),'%Y') GROUP BY DATE_FORMAT(c.`date_hour_coupon`,'%M/%Y') ORDER BY DATE_FORMAT(c.`date_hour_coupon`,'%m/%Y') DESC;";
        List<String> cat = new ArrayList<>();
        try {
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {
                
                String qtd = rs.getString("sum_qtd");
                String str_qtd = (qtd.length() == 5 ? "   "+String.format("%-3s", qtd) : qtd.length() == 6 ? "  "+String.format("%-3s", qtd) : qtd.length() == 7 ? " "+String.format("%-3s", qtd) : qtd);                
                cat.add(" "+rs.getString("mouth_year")+"  "+str_qtd+" "+rs.getString("un_measure"));
            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cat;
    }

    //Varedura de % lucro
    public static boolean setPercentageProfit(String value, String arg) {

        String sql = "UPDATE tbl_product SET prod_percentage_profit_product = " + value + " , prod_price_sale_actual_product = ((prod_price_purchase_product / 100) * " + value + ") + prod_price_purchase_product WHERE idtbl_category_product IN(" + arg + ");";
        try {

            stmt = Conn.connect().createStatement();
            int res = stmt.executeUpdate(sql);
 

            if (res == 1) {

                saida = true;

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return saida;

    }

    public static boolean isExistProduct(String arg) {

        try {

            ps = Conn.connect().prepareStatement("SELECT t.`idtbl_category_product`, t.`idtbl_unity_measure`, t.`prod_bar_code_product`, t.`prod_description_product`, t.`prod_type_production_product`, t.`prod_reserve_actual_product`, t.`prod_reserve_minimum_product`, t.`prod_price_purchase_product`, t.`prod_percentage_profit_product`, t.`prod_price_sale_actual_product`, t.`prod_price_tab1_product`, t.`prod_price_tab2_product`, t.`prod_price_mean_purchase_product`, t.`prod_abbreviature` FROM tbl_product t INNER JOIN tbl_category_product c ON t.`idtbl_category_product` =  c.`idtbl_category_product` WHERE t.`prod_bar_code_product` = ? ;");
            ps.setString(1, arg);
            rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean isExistInactiveProduct() {

        try {

            ps = Conn.connect().prepareStatement("SELECT * FROM tbl_product t WHERE t.`prod_isActive` = ?;");
            ps.setBoolean(1, false);
            rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static double coolingRate() {

        String sql = "SELECT t.`value_rate` FROM tbl_cooling_rate t;";

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();

            return rs.getDouble("value_rate");

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            return 0.00;
        }
    }

    public static int demandIndicator(String barCod) {

        String monthYearActual = DateActual.setDate(new Date(), "MM-yyyy");
        int year = Integer.parseInt(DateActual.setDate(new Date(), "yyyy"));
        int month = Integer.parseInt(DateActual.setDate(new Date(), "MM"));
        if (month == 01) {
            month = 12;
            year = year - 1;
        }
        String monthYearLasted = String.valueOf(month - 1) + "-" + String.valueOf(year);
        if (month - 1 < 10) {
            monthYearLasted = "0" + monthYearLasted;
        }

        try {

            ps = Conn.connect().prepareStatement("SELECT((SELECT SUM(pc.`quantity_iten`) FROM tbl_coupon t INNER JOIN  tbl_product_coupon pc ON t.`idtbl_coupon`  =  pc.`idtbl_coupon` WHERE DATE_FORMAT(t.`date_hour_coupon`,'%m-%Y') = ?   AND pc.`prod_bar_code_product` = ? GROUP BY DATE_FORMAT(t.`date_hour_coupon`,'%m-%Y'))"
                    + " - ((SELECT SUM(pc.`quantity_iten`) FROM tbl_coupon t INNER JOIN  tbl_product_coupon pc ON t.`idtbl_coupon`  =  pc.`idtbl_coupon` WHERE DATE_FORMAT(t.`date_hour_coupon`,'%m-%Y') = ?   AND pc.`prod_bar_code_product` = ? GROUP BY DATE_FORMAT(t.`date_hour_coupon`,'%m-%Y')))) AS demand;");
            ps.setString(1, monthYearActual);
            ps.setString(2, barCod);
            ps.setString(3, monthYearLasted);
            ps.setString(4, barCod);
            rs = ps.executeQuery();
            System.err.println("month lasted::" + monthYearLasted);
            System.err.println("month actual::" + monthYearActual);

            if(rs.next()) {

               return rs.getInt("demand");

                 
            } else {
                System.err.println("DEMAND NULL");
                return 0;
            }

        } catch (SQLException ex) {
            
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error on class DemandGrafic::" + ex);
            return 0;
        }
    }

    public static String meanSaleIndicator(String arg, String unity) {

        DecimalFormat v;
        if (unity.equals("UN")) {
            v = new DecimalFormat("0.00");
        } else {
            v = new DecimalFormat("0.000");
        }
        int months = 0;
        double sales = 0;
        double value;

        try {
            System.err.println("****ARG MEAN SALE::"+arg);
            ps = Conn.connect().prepareStatement("SELECT  (SUM(pc.`quantity_iten`)) AS sum_sales, DATE_FORMAT(c.`date_hour_coupon`,'%m/%Y')  FROM tbl_product_coupon pc INNER JOIN tbl_coupon c ON pc.`idtbl_coupon` = c.`idtbl_coupon`  WHERE pc.`prod_bar_code_product` = ? AND DATE_FORMAT(c.`date_hour_coupon`,'%Y') = DATE_FORMAT(NOW(),'%Y') GROUP BY DATE_FORMAT(c.`date_hour_coupon`,'%m/%Y');");
            ps.setString(1, arg);
            rs = ps.executeQuery();
            rs.last();
            months = rs.getRow();
            System.err.println("MOUNTS::" + months);
            if (months != 0) {
                ps = Conn.connect().prepareStatement("SELECT  SUM(pc.`product_quantity`) AS sum_sales FROM tbl_product_coupon pc INNER JOIN tbl_coupon c ON pc.`idtbl_coupon` = c.`idtbl_coupon`  WHERE pc.`prod_bar_code_product` = ? AND DATE_FORMAT(c.`date_hour_coupon`,'%Y') = DATE_FORMAT(NOW(),'%Y') GROUP BY DATE_FORMAT(c.`date_hour_coupon`,'%Y');");
                ps.setString(1, arg);
                rs = ps.executeQuery();
                rs.next();
                sales = rs.getDouble("sum_sales");
                System.err.println("SALES::" + sales);
                
            } else {

                return "0.00";

            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        value = sales / months;
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(3, BigDecimal.ROUND_CEILING);
        value = bd.doubleValue();
        return v.format(value).replace(",", ".");

    }


    public static List<List<String>> viewProductsRapidCode() {

        List<List<String>> arrayList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        try {

            stmt = Conn.connect().createStatement();
            int i = 1;
            rs = stmt.executeQuery("SELECT t.`prod_bar_code_product`, t.`prod_description_product` FROM tbl_product t  WHERE character_length(`prod_bar_code_product`) <= 7 ORDER BY t.`prod_description_product`;");
            rs.last();
            int rows = rs.getRow() / 3;

            rs.first();
            if (rows < 35) {
                rows = 35;
            }

            while (rs.next()) {

                if (i <= rows) {
                    i++;
                    list1.add(rs.getString("prod_bar_code_product") + " - " + rs.getString("prod_description_product"));

                } else if ((i > rows) && (i <= rows + rows)) {
                    i++;
                    list2.add(rs.getString("prod_bar_code_product") + " - " + rs.getString("prod_description_product"));

                } else if ((i > rows + rows)) {
                    i++;
                    list3.add(rs.getString("prod_bar_code_product") + " - " + rs.getString("prod_description_product"));

                }
                arrayList.add(list1);
                arrayList.add(list2);
                arrayList.add(list3);
            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return arrayList;

    }

    public static void blockProduct(String arg, int statusProduct) {
       
        
         String sql = "UPDATE tbl_product t SET prod_isActive = ? WHERE prod_bar_code_product IN("+arg+") ;";
        try {

            ps = Conn.connect().prepareStatement(sql);

            System.err.println("########ARG BLOCK#########" + arg);
            System.err.println("########STATUS BLOCK#########" + statusProduct);

            ps.setInt(1, statusProduct);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR MODEL BLOCK PRODUCT::" + ex);

        }
        
    }

}
