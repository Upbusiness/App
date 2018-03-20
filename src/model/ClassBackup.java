/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import xml.NewXML;

/**
 *
 * @author Rafiusks
 */
public class ClassBackup {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final NewXML newXML = new NewXML();

    public static void newDateControl() {

        try {

            String sql = "INSERT INTO tbl_backup_control VALUES(CURRENT_DATE())";
            ps = Conn.connect().prepareStatement(sql);

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }
    }

    public static boolean isStartBackup() {

        String sql = "SELECT (DATE_FORMAT(CURRENT_DATE(),'%Y-%d-%m') - DATE_FORMAT((SELECT date_last_backup FROM tbl_backup_control),'%Y-%d-%m') ) > 7";

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassProduct.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
