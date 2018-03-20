/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ClassCashier;
import model.Conn;
import java.util.logging.Level;
import java.util.logging.Logger;
import testes.ClassSerialHD;
import xml.NewXML;

/**
 *
 * @author Rafael recalcatti
 */
public class ClassValidTerminal {

    private static int numberTerminal;
    private static int serialHD;
    private static boolean isActiveTerminal;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static final NewXML newXML = new NewXML();

    public static String valid_terminal() throws IOException {

        try {

            ps = Conn.connect().prepareStatement("SELECT t.`idtbl_terminal`, t.`serialHD`, t.`isActive`, t.`isLoged`, t.`dateActived` FROM tbl_terminal t WHERE t.`serialHD` = ?;");
            ps.setString(1, ClassSerialHD.getHDSerial());
            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("idtbl_terminal");

            } else {

                return null;

            }
        } catch (SQLException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
