
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//~--- JDK imports ------------------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import view.JDialogStarting;
import xml.NewXML;

/**
 *
 * @author Rafael
 */
public class ConnRel {

    public static String usuario = "root";
    public static String senha = "102230254535";
    private static final NewXML newXML = new NewXML();

    public static Connection getConnection() throws Exception {
        try {
            //192.168.1.19
            //localhost
           Class.forName("org.gjt.mm.mysql.Driver");

            System.err.println("Ip::"+JDialogStarting.config.getIp());
            return DriverManager.getConnection(JDialogStarting.config.getIp(), usuario, senha);

        } catch (ClassNotFoundException | SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            throw new Exception(ex.getMessage());
        }
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt) throws Exception {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            throw new Exception(ex.getMessage());
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
