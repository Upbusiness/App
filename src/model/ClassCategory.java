/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xml.NewXML;

/**
 *
 * @author Rafiusk
 */
public class ClassCategory {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final Category bean = new Category();
    private static final boolean saida = false;
    private static final NewXML newXML = new NewXML();

    /**
     * Cadastra uma nova categoria e retorna verdadeiro se o cadastro foi
     * efetuado com sucesso
     *
     * @param category
     * @return boolean
     */
    public static boolean newCategory(Category category) {

        try {

            String sql = "INSERT INTO tbl_category_product VALUES(0,?,?,?,?)";

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, category.getDescriptionCategory());
            ps.setString(2, category.getObservationCategory());
            ps.setString(3, category.getSectorcategory());
            ps.setDouble(4, category.getPercentageProfitCategory());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    /**
     * Deleta um especifico cliente com a passagem de parametro id cliente
     *
     * @param categoryId
     * @return boolean
     */
    public static boolean deleleteCategory(String categoryId) {

        String SQL = "DELETE FROM tbl_category_product WHERE idtbl_category_product = " + categoryId;
        try {

            stmt = Conn.connect().createStatement();
            return stmt.executeUpdate(SQL) == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCategory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean refreshCategory(Category category) {

        String sql = "UPDATE tbl_category_product SET description_category = ? , observation_category = ? , sector_category = ? , percentage_profit = ?  WHERE idtbl_category_product = ?";
        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, category.getDescriptionCategory());
            ps.setString(2, category.getObservationCategory());
            ps.setString(3, category.getSectorcategory());
            ps.setDouble(4, category.getPercentageProfitCategory());
            ps.setInt(5, category.getCodCategory());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCategory.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static Category consultCategory(String nameCategory, boolean isCod) {

        String sql = null;

        if (isCod) {

            sql = "SELECT t.`idtbl_category_product`, t.`description_category`, t.`observation_category`, t.`percentage_profit`, t.`sector_category` FROM tbl_category_product t ORDER BY idtbl_category_product DESC;";

        } else if (!isCod) {

            sql = "SELECT t.`idtbl_category_product`, t.`description_category`, t.`observation_category` , t.`percentage_profit`, t.`sector_category` FROM tbl_category_product t WHERE t.`description_category`= '" + nameCategory + "'";

        }
        try {

            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                bean.setCodCategory(rs.getInt(1));
                bean.setDescriptionCategory(rs.getString(2));
                bean.setObservationCategory(rs.getString(3));
                bean.setPercentageProfitCategory(rs.getDouble(4));
                bean.setSectorcategory(rs.getString(5));

            } else {

                bean.setCodCategory(0);

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCategory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bean;
    }

    public static List<String> cotegorys() {

        String sql = "SELECT description_category FROM tbl_category_product ORDER BY description_category";
        List<String> cat = new ArrayList<>();
        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                cat.add(rs.getString(1).toUpperCase());

            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCategory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cat;
    }
}
