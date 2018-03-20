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
public class ClassUnityMeasure {

    private static final NewXML newXML = new NewXML();
    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final Product bean = new Product();
    private static boolean saida = false;

    /**
     * Cadastra uma nova categoria e retorna verdadeiro se o cadastro foi
     * efetuado com sucesso
     *
     * @param product
     * @return boolean
     */
    public static boolean newUnityMeasure(Product product) {

        try {

            String sql = "INSERT INTO tbl_unity_measure VALUES(?,?)";

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, product.getAbbreviature());
            ps.setDouble(2, product.getUnity_measure());

            if (ps.executeUpdate() == 1) {

                System.err.println("Inseriu");
                saida = true;

            }

        } catch (SQLException ex) {

            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            saida = false;
        }

        return saida;

    }

    /**
     * Deleta um especifico cliente com a passagem de parametro id cliente
     *
     * @param bean
     * @return boolean
     */
    public static boolean deleleteUnityMeasure(Product bean) {

        String sql = "DELETE FROM tbl_unity_measure WHERE idtbl_unity_measure = ? ";
        try {

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, bean.getAbbreviature());

            if (ps.executeUpdate() == 1) {

                saida = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassUnityMeasure.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("ERRO::" + ex);

        }

        return saida;

    }

    public static Product consultUnity(String idUnity) {

        String sql = "SELECT idtbl_unity_measure, unity_measure FROM tbl_unity_measure WHERE idtbl_unity_measure ='" + idUnity + "'";
        System.err.println("SQL::" + sql);
        try {

            stmt = Conn.connect().createStatement();

            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                bean.setAbbreviature(rs.getString("idtbl_unity_measure"));
                bean.setUnity_measure(rs.getDouble("unity_measure"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassUnityMeasure.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

        return bean;
    }

    public static List<Double> codProduct() {

        String sql = "SELECT idtbl_category_product,name_category FROM tbl_category_product";
        List<Double> cat = new ArrayList<>();
        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                cat.add(rs.getDouble(1));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassUnityMeasure.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

        return cat;
    }

    public static List<String> nameProduct() {

        String sql = "SELECT idtbl_category_product,name_category FROM tbl_category_product";
        List<String> cat = new ArrayList<>();
        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                cat.add(rs.getString("idtbl_category_product") + " - " + rs.getString("name_category").toUpperCase());

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassUnityMeasure.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

        return cat;
    }

    public static List<String> allCategorys() {

        String sql = "SELECT idtbl_category_product,name_category FROM tbl_category_product";
        List<String> cat = new ArrayList<>();
        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);

            cat.add("[TODAS CATEGORIAS]");
            while (rs.next()) {

                cat.add(rs.getString("idtbl_category_product") + " - " + rs.getString("name_category").toUpperCase());

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClassUnityMeasure.class.getName()).log(Level.SEVERE, null, ex);
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

        return cat;
    }
}
