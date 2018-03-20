/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import action.BeanConfig;
import action.Config;
import java.io.*;
import java.util.Date;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import util.DateActual;
import util.JTextFieldTools;
import view.JDialogStarting;

public class NewXML {
    
    private static String dir;
    private static final NewXML newXML = new NewXML();

    public NewXML(){
        
      BeanConfig bc = new BeanConfig();
      dir = BeanConfig.getPath();  
      
    }
    public void generateXML(String id_node,
            String id_lot,
            String description,
            String bar_code,
            String date_reg,
            String date_exp,
            String date_prod,
            String num_lot,
            String qtd_insert,
            String packs,
            String qtd_vol,
            String unity
    ) {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        Document doc = null;
        try {
            System.err.println("DIR ON DEL::"+JDialogStarting.config.getDir());
            String arquivo = JDialogStarting.config.getDir()+"\\lots_products_1.xml";
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(arquivo);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.err.println("ERROR XML LOG::" + ex);
           
        }

        Node lot = doc.getFirstChild();
        Node volume = doc.createElement("vol");
        Attr id = doc.createAttribute("id");
        if (id_node == null) {
            id_node = "1";
        }

        id.setValue((new StringBuilder()).append("").append(id_node).toString());

        NamedNodeMap encomendaAttributes = volume.getAttributes();
        encomendaAttributes.setNamedItem(id);

        Node id_Lot = doc.createElement("id_lot");
        id_Lot.setTextContent(id_lot);

        Node num_Lot = doc.createElement("num_lot");
        num_Lot.setTextContent(num_lot);

        Node bar_Code = doc.createElement("bar_code");
        bar_Code.setTextContent(bar_code);

        Node description_ = doc.createElement("description");
        description_.setTextContent(description);

        Node date_Reg = doc.createElement("date_reg");
        date_Reg.setTextContent(date_reg);

        Node date_Prod = doc.createElement("date_prod");
        date_Prod.setTextContent(date_prod);

        Node date_Exp = doc.createElement("date_exp");
        date_Exp.setTextContent(date_exp);

        Node qtd_Insert = doc.createElement("qtd_insert");
        qtd_Insert.setTextContent(qtd_insert);

        Node unity_ = doc.createElement("unity");
        unity_.setTextContent(unity);

        Node qtd_Vol = doc.createElement("qtd_vol");
        qtd_Vol.setTextContent(qtd_vol);

        Node packs_ = doc.createElement("packs");
        packs_.setTextContent(packs);

        volume.appendChild(id_Lot);
        volume.appendChild(num_Lot);
        volume.appendChild(bar_Code);
        volume.appendChild(description_);
        volume.appendChild(date_Reg);
        volume.appendChild(date_Prod);
        volume.appendChild(date_Exp);
        volume.appendChild(qtd_Insert);
        volume.appendChild(unity_);
        volume.appendChild(qtd_Vol);
        volume.appendChild(packs_);
        lot.appendChild(volume);

        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException | TransformerFactoryConfigurationError ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        transformer.setOutputProperty("indent", "yes");
        StreamResult result = null;
        try {

            String arquivo = JDialogStarting.config.getDir()+"\\lots_products_1.xml";
            result = new StreamResult(new FileWriter(new File(arquivo)));
            // result = new StreamResult(new FileWriter(new File("src/reports/lots_products.xml")));
        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        DOMSource source = new DOMSource(doc);
        try {
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        String xmlString = result.getWriter().toString();
        System.out.println(xmlString);
    }
/*
    public void generateLog(String exeption) {

        
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        Document doc = null;
        try {
            String arquivo = JDialogStarting.config.getDir() + "\\log.xml";
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(arquivo);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }

        Node dady = doc.getFirstChild();
        Node log_exception = doc.createElement("LOG_EXCEPTION");
        Attr id = doc.createAttribute("ID");
        String id_node = DateActual.setDate(new Date(), "dHHmmss");;

        String date_Log = DateActual.setDate(new Date(), "d/MM/yyyy HH:mm:ss ");

        id.setValue((new StringBuilder()).append(id_node).toString());

        NamedNodeMap encomendaAttributes = log_exception.getAttributes();
        encomendaAttributes.setNamedItem(id);

        Node dateLog = doc.createElement("DATA_HORA_LOG");
        dateLog.setTextContent(date_Log);
        Node exeptionlOG = doc.createElement("EXCEPTION");
        exeptionlOG.setTextContent(JTextFieldTools.invalidCaracterString(exeption));

        log_exception.appendChild(dateLog);
        log_exception.appendChild(exeptionlOG);
        dady.appendChild(log_exception);

        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException | TransformerFactoryConfigurationError ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        transformer.setOutputProperty("indent", "yes");
        StreamResult result = null;
        try {

            String arquivo = JDialogStarting.config.getDir() + "\\log.xml";
            result = new StreamResult(new FileWriter(new File(arquivo)));
             //result = new StreamResult(new FileWriter(new File(dir+"log.xml")));
        } catch (IOException ex) {
            System.err.println("ERROR IO::" + ex);
            //newXML.generateLog(ex.toString());
        }
        DOMSource source = new DOMSource(doc);
        try {
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        String xmlString = result.getWriter().toString();
        System.out.println(xmlString);
    }
*/
    public void copyXML() {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        Document doc = null;
        try {
            System.err.println("DIR ON COPY::"+JDialogStarting.config.getDir());
            String arquivo = JDialogStarting.config.getDir()+"\\lots_products.xml";
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(arquivo);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }

        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException | TransformerFactoryConfigurationError ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        transformer.setOutputProperty("indent", "yes");
        StreamResult result = null;
        try {
            String arquivo = "lots_products_1.xml";
            result = new StreamResult(new FileWriter(new File(arquivo)));
            // result = new StreamResult(new FileWriter(new File("src/reports/lots_products.xml")));
        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        DOMSource source = new DOMSource(doc);
        try {
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        String xmlString = result.getWriter().toString();
        System.out.println(xmlString);
    }

    public void deleteXMLFile() {

        String arquivo = "lots_products_1.xml";
        File origem = new File(arquivo);
        try {

            origem.delete();
            origem.createNewFile();
            System.out.println(origem.exists());

        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        } finally {
            System.out.println("Finalizando");
        }

    }
}
