/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;
import util.DateActual;

/**
 *
 * @author Rafiusks
 */
public class Teste {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    public static void main(String[] args) throws ParseException {

    System.err.println(DateActual.weekYear(new Date()));
    
    }
 
}
