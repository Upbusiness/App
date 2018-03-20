/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import model.Conn;

/**
 *
 * @author CPU
 */
public class NovoCookie {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final NewXML newXML = new NewXML();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        novoCookie();
    }

    public static void novoCookie() {

        try {
            NewXML newXml = new NewXML();
            EditandoXML editXml = new EditandoXML();
            List<String> list = new ArrayList<>();

            String sql = "SELECT idtbl_cliente, nome_cliente, endereco_cliente,fone_cliente, email_cliente FROM tbl_cliente t";

            stmt = Conn.connect().createStatement();

            rs = stmt.executeQuery(sql);

            list.add("Rafael");
            list.add("Maciel 70");
            list.add("86301094");

            while (rs.next()) {
                System.out.println("ID CLIENT::" + rs.getString("idtbl_cliente"));
                //newXml.insereCookie(rs.getString("idtbl_cliente"),rs.getString("nome_cliente"),rs.getString("endereco_cliente"), rs.getString("fone_cliente"));

            }

            editXml.parse("arquivo.xml", list, "11");
        } catch (ParserConfigurationException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            Logger.getLogger(NovoCookie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());

        }

    }
}
