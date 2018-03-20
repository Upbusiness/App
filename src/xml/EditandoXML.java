// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EditandoXML.java
package xml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class EditandoXML {

    private static final NewXML newXML = new NewXML();

    public EditandoXML()
            throws ParserConfigurationException {
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
    }

    public void parse(String arquivoLeitura, List valores, String id) {

        try {

            doc = db.parse(arquivoLeitura);

            Element raiz = doc.getDocumentElement();
            NodeList listaContatos = raiz.getElementsByTagName("contato");
            for (int i = 0; i < listaContatos.getLength(); i++) {
                Element elementoContato = (Element) listaContatos.item(i);
                System.err.println("ID::" + id);
                if (elementoContato.getAttribute("id").equals(id)) {

                    System.err.println("ACHOU ID NO ARQUIVO::" + id);
                    Element nome = doc.createElement("nome");
                    nome.appendChild(doc.createTextNode((String) valores.get(0)));
                    org.w3c.dom.Node xNome = elementoContato.getElementsByTagName("nome").item(0);
                    elementoContato.replaceChild(nome, xNome);
                    Element endereco = doc.createElement("endereco");
                    endereco.appendChild(doc.createTextNode((String) valores.get(1)));
                    org.w3c.dom.Node xEndereco = elementoContato.getElementsByTagName("endereco").item(0);
                    elementoContato.replaceChild(endereco, xEndereco);
                    Element tel = doc.createElement("telefone");
                    tel.appendChild(doc.createTextNode((String) valores.get(2)));
                    org.w3c.dom.Node telefone = elementoContato.getElementsByTagName("telefone").item(0);
                    elementoContato.replaceChild(tel, telefone);
                }

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new FileOutputStream(arquivoLeitura));
                TransformerFactory transFactory = TransformerFactory.newInstance();
                Transformer transformer = transFactory.newTransformer();
                transformer.transform(source, result);

            }

        } catch (SAXException | IOException | TransformerException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            Logger.getLogger(EditandoXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirValorXML(String arquivoLeitura, String arquivoSaida, String id)
            throws SAXException, IOException, TransformerException {
        doc = db.parse(arquivoLeitura);
        Element raiz = doc.getDocumentElement();
        NodeList listaContatos = raiz.getElementsByTagName("contato");
        for (int i = 0; i < listaContatos.getLength(); i++) {
            Element elementoContato = (Element) listaContatos.item(i);
            if (elementoContato.getAttribute("id").equals(id)) {
                raiz.removeChild(elementoContato);
            }
        }

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(arquivoSaida));
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        transformer.transform(source, result);
    }

    private final DocumentBuilderFactory dbf;
    private final DocumentBuilder db;
    private Document doc;
}
