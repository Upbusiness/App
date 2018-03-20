package util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import xml.NewXML;

/**
 *
 * @author Rafael
 */
/*
 * manipulaarquivo2.java
 *
 * Created on 2 de Fevereiro de 2008, 20:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

public class Novo {

    private static final NewXML newXML = new NewXML();

    public static void insereCookies(String palavra) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        Document doc = null;

        try {

            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse("cookies.xml");

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        Node cookie = doc.getFirstChild();

        Node p = doc.createElement("palavra");

        Node no = doc.createElement("valor");
        no.setTextContent(palavra);
        p.appendChild(no);
        cookie.appendChild(p);

        Transformer transformer = null;

        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        } catch (TransformerFactoryConfigurationError ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        //initialize StreamResult with File object to save to file  
        StreamResult result = null;

        try {
            result = new StreamResult(new FileWriter(new File("cookies.xml")));
        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            ;
        }

        DOMSource source = new DOMSource(doc);

        try {
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

    }

}
