/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.JDialogStarting;
import xml.NewXML;

/**
 *
 * @author Rafiusk
 */
public class Conn {

    private static Connection connection;
    public static String usuario = "root";
    public static String senha = "102230254535";
    private static final NewXML newXML = new NewXML();
    
    public static Connection connect() {

        try {
            if (connection == null) { 
                
                Class.forName("org.gjt.mm.mysql.Driver");
                
                connection = DriverManager.getConnection(JDialogStarting.config.getIp(), usuario, senha);

                //set como nao automatico a insercao de dados
                connection.setAutoCommit(true);
                System.out.println("Conexao estabelecida com sucesso!!");

            }
        } catch (com.mysql.jdbc.exceptions.MySQLSyntaxErrorException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            System.out.println("Erro Você não tem privilégios para esta operação contate o administrador:" + ex);
            JOptionPane.showMessageDialog(null, "Você não tem privilégios para esta operação contate o administrador!", "", JOptionPane.WARNING_MESSAGE);

        } catch (ClassNotFoundException driv) {
            System.err.println("ERROR::" + driv);
            //newXML.generateLog(driv.toString());
            JOptionPane.showMessageDialog(null, "Driver não localizado: " + driv, "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (com.mysql.jdbc.CommunicationsException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            System.out.println("Erro na conexao com o Banco de Dados::" + ex);
            JOptionPane.showMessageDialog(null, "Erro na Conexão com a Base de Dados!\n    Cod_23", "", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException Fonte) {
            System.err.println("ERROR::" + Fonte);
            //newXML.generateLog(Fonte.toString());
            System.out.println("Erro verifique a senha e usuario::" + Fonte);
            JOptionPane.showMessageDialog(null, "Erro! usuário ou senha inválidos.", "Login", JOptionPane.WARNING_MESSAGE);

        }
        return connection;
    }

    public static void close() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }
    }
//confirma a insercao de dados

    public static void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
            System.err.println("ERROR::" + e);
            //newXML.generateLog(e.toString());

        }
    }

}
