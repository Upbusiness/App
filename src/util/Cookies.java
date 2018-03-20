package util;

import xml.XML_Config;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rafael
 */
public class Cookies {

    public static String[] list;

    public static List<String> autoComplete(String str) {
        List<String> a = new ArrayList<>();

        //  Conexao con = new Conexao();
        //  con.conecta(false);
        //a = XML_Config.cookies(str);
        // a = con.selectSQL("select palavra from cookies where palavra like '"+str+"%'order by palavra");

        //  con.desconecta(false);


        return a;
    }

    public static void gravaCookies(String str) {
        
        List<String> a = new ArrayList<>();
       // a = XML_Config.cookies(str);
        // Conexao con = new Conexao();
        //  con.conecta(false);
        //if(con.selectSQL("select palavra from cookies where palavra ='"+str+"'").isEmpty())
        //  con.upDateSQL("insert into cookies values('"+str+"');");

        //  con.desconecta(false);
        if (a.isEmpty()) {
            Novo.insereCookies(str);
        }
    }
}
