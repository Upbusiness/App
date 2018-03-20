/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testes;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Conn;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import xml.XML_Config;

/**
 *
 * @author CPU
 */
public class ExportXMLDB {
    public static void main(String[] arg) throws SQLException, JDOMException, IOException {
        ExportXMLDB lx = new ExportXMLDB();
         lx.cookies();
    }
    private PreparedStatement ps;

    public  List<String> cookies() throws SQLException, JDOMException, IOException {
        List<String> cookies = new ArrayList<String>();

        

//          Aqui voc? informa o nome do arquivo XML.
            File f = new File(System.getProperty("user.dir")+"/PRODUTO.xml");
            //InputStream in = this.getClass().getResourceAsStream("C:/Users/CPU/Documents/DeliverySys/arquivo.xml");
//          Criamos uma classe SAXBuilder que vai processar o XML
            SAXBuilder sb = new SAXBuilder();

//          Este documento agora possui toda a estrutura do arquivo.
            Document d = sb.build(f);

//          Recuperamos o elemento root
            Element blog = d.getRootElement();

//          Recuperamos os elementos filhos (children)
            List     elements = blog.getChildren();
            Iterator i        = elements.iterator();
           
            String sql = "INSERT INTO tbl_product (prod_bar_code_product,"
                    + " idtbl_unity_measure,"
                    + " idtbl_category_product,"
                    + " prod_type_production_product,"
                    + " prod_description_product,"
                    + " prod_abbreviature,"
                    + " prod_price_purchase_product,"
                    + " prod_percentage_profit_product,"
                    + " prod_price_sale_actual_product)VALUES(?,'UN',?,0,?,?,?,?,?)";
                    
            /* String sql ="INSERT INTO tbl_category_product (idtbl_category_product,description_category,percentage_profit)values(?,?,?);";*/
            ps = Conn.connect().prepareStatement(sql);
        
            while (i.hasNext()) {
                Element element = (Element) i.next();

               
                System.out.println(":::"+ element.getChildText("DESCRICAO"));                
                System.out.println(":::"+ element.getChildText("CODIGOBARRA"));
                System.out.println(":::"+ element.getChildText("IMPRESSAO"));
                System.out.println(":::"+ element.getChildText("PERCENTUAL"));
                System.out.println(":::"+ element.getChildText("VALOR_COMPRA"));
                System.out.println(":::"+ element.getChildText("VALOR_VENDA"));
                        
               
                ps.setString(1, element.getChildText("CODIGOBARRA") );
                ps.setString(2, element.getChildText("CATEGORIA") );
                ps.setString(3, element.getChildText("DESCRICAO") );
                ps.setString(4, element.getChildText("IMPRESSAO"));
                ps.setString(5, element.getChildText("VALOR_COMPRA"));
                ps.setString(6, element.getChildText("PERCENTUAL"));              
                ps.setString(7, element.getChildText("VALOR_VENDA"));
                     /*    
                  ps.setString(1, element.getChildText("CODIGO") );
                ps.setString(2, element.getChildText("DESCRICAO") );
                 ps.setString(3, element.getChildText("PERCENTUAL"));*/
                ps.executeUpdate();
               
            }
       
        return cookies;
    }
}
