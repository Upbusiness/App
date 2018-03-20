package xml;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.xpath.XPathAPI;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML_Config {

    private static final NewXML newXML = new NewXML();
    private static DocumentBuilderFactory dbf;
    private static DocumentBuilder db;
    private static org.w3c.dom.Document doc;

    @SuppressWarnings("empty-statement")
    public static List<Object> loadConfig(String file) {

        List<Object> config = new ArrayList<>();

        try {

            dbf = DocumentBuilderFactory.newInstance();
            //dbf.setNamespaceAware(false);
            db = dbf.newDocumentBuilder();
            doc = db.parse(file);
            org.w3c.dom.Element raiz = doc.getDocumentElement();
            NodeList nodelist = XPathAPI.selectNodeList(raiz, "configValues");

            String str = nodelist.item(0).getTextContent();
            String[] configValues = str.trim().replaceAll("\n", ",").split(",");

            for (String configValue : configValues) {
               
                config.add(configValue.trim());
            }

        } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());

        }
        return config;
    }

    public static void saveConfig(String file, List<String> valuesConfig) {

        try {

            dbf = DocumentBuilderFactory.newInstance();
            db = dbf.newDocumentBuilder();
            doc = db.parse(file);

            org.w3c.dom.Element raiz = doc.getDocumentElement();
            NodeList listaContatos = raiz.getElementsByTagName("configValues");

            org.w3c.dom.Element elementoContato = (org.w3c.dom.Element) listaContatos.item(0);
            
            int position;
            if (elementoContato.getAttribute("id").equals("1")) {

                if (valuesConfig.contains("ip")) {

                    position = valuesConfig.indexOf("ip");
                    position++;
                    System.err.println("Arquivo config.xml modificado com sucesso >>IP<<.");
                    org.w3c.dom.Element newIp = doc.createElement("ip");
                    newIp.appendChild(doc.createTextNode((String) valuesConfig.get(position).trim()));
                    org.w3c.dom.Node oldIp = elementoContato.getElementsByTagName("ip").item(0);
                    elementoContato.replaceChild(newIp, oldIp);
                }
                if (valuesConfig.contains("path")) {

                    position = valuesConfig.indexOf("path");
                    position++;
                    System.err.println("Arquivo config.xml modificado com sucesso >>Path<<.");
                    org.w3c.dom.Element newPath = doc.createElement("path");
                    newPath.appendChild(doc.createTextNode((String) valuesConfig.get(position).trim()));
                    org.w3c.dom.Node oldPath = elementoContato.getElementsByTagName("path").item(0);
                    elementoContato.replaceChild(newPath, oldPath);
                }
                if (valuesConfig.contains("logo")) {

                    position = valuesConfig.indexOf("logo");
                    position++;
                    System.err.println("Arquivo config.xml modificado com sucesso >>Logo<<.");
                    org.w3c.dom.Element newLogo = doc.createElement("logo");
                    newLogo.appendChild(doc.createTextNode((String) valuesConfig.get(position).trim()));
                    org.w3c.dom.Node oldLogo = elementoContato.getElementsByTagName("logo").item(0);
                    elementoContato.replaceChild(newLogo, oldLogo);
                }
                if (valuesConfig.contains("isPrintService")) {

                    position = valuesConfig.indexOf("isPrintService");
                    position++;
                    System.err.println("Arquivo config.xml modificado com sucesso >>PrintService<<.");
                    org.w3c.dom.Element newPrintService = doc.createElement("isPrintService");
                    newPrintService.appendChild(doc.createTextNode((String) valuesConfig.get(position).trim()));
                    org.w3c.dom.Node oldPrintService = elementoContato.getElementsByTagName("isPrintService").item(0);
                    elementoContato.replaceChild(newPrintService, oldPrintService);
                }
                if (valuesConfig.contains("isCoolRate")) {

                    position = valuesConfig.indexOf("isCoolRate");
                    position++;
                    System.err.println("Arquivo config.xml modificado com sucesso >>CoolRate<<.");
                    org.w3c.dom.Element newCoolRate = doc.createElement("isCoolRate");
                    newCoolRate.appendChild(doc.createTextNode((String) valuesConfig.get(position).trim()));
                    org.w3c.dom.Node oldCoolRate = elementoContato.getElementsByTagName("isCoolRate").item(0);
                    elementoContato.replaceChild(newCoolRate, oldCoolRate);
                }

                if (valuesConfig.contains("valueCoolRate")) {

                    position = valuesConfig.indexOf("valueCoolRate");
                    position++;
                    System.err.println("Arquivo config.xml modificado com sucesso >>ValueCoolRate<<.");
                    org.w3c.dom.Element newValueCoolRate = doc.createElement("valueCoolRate");
                    newValueCoolRate.appendChild(doc.createTextNode((String) valuesConfig.get(position).trim()));
                    org.w3c.dom.Node oldValueCoolRate = elementoContato.getElementsByTagName("valueCoolRate").item(0);
                    elementoContato.replaceChild(newValueCoolRate, oldValueCoolRate);
                }
                if (valuesConfig.contains("isAddCigarreteRate")) {

                    position = valuesConfig.indexOf("isAddCigarreteRate");
                    position++;
                    System.err.println("Arquivo config.xml modificado com sucesso >>footerCoupon<<.");
                    org.w3c.dom.Element newAddCigarreteRate = doc.createElement("isAddCigarreteRate");
                    newAddCigarreteRate.appendChild(doc.createTextNode((String) valuesConfig.get(position).trim()));
                    org.w3c.dom.Node oldnewAddCigarreteRate = elementoContato.getElementsByTagName("isAddCigarreteRate").item(0);
                    elementoContato.replaceChild(newAddCigarreteRate, oldnewAddCigarreteRate);
                }
    
                
                if (valuesConfig.contains("headerCoupon")) {

                    position = valuesConfig.indexOf("headerCoupon");
                    position++;
                    System.err.println("Arquivo config.xml modificado com sucesso >>headerCoupon<<.");
                    org.w3c.dom.Element newAddHeaderCoupon = doc.createElement("headerCoupon");
                    newAddHeaderCoupon.appendChild(doc.createTextNode((String) valuesConfig.get(position).trim()));
                    org.w3c.dom.Node oldAddHeaderCoupon = elementoContato.getElementsByTagName("headerCoupon").item(0);
                    elementoContato.replaceChild(newAddHeaderCoupon, oldAddHeaderCoupon);
                }

                if (valuesConfig.contains("footerCoupon")) {

                    position = valuesConfig.indexOf("footerCoupon");
                    position++;
                    System.err.println("Arquivo config.xml modificado com sucesso >>footerCoupon<<.");
                    org.w3c.dom.Element newFooterCoupon = doc.createElement("footerCoupon");
                    newFooterCoupon.appendChild(doc.createTextNode((String) valuesConfig.get(position).trim()));
                    org.w3c.dom.Node oldFooterCoupon = elementoContato.getElementsByTagName("footerCoupon").item(0);
                    elementoContato.replaceChild(newFooterCoupon, oldFooterCoupon);
                }

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new FileOutputStream(file));
                TransformerFactory transFactory = TransformerFactory.newInstance();
                Transformer transformer = transFactory.newTransformer();
                transformer.transform(source, result);
                
               

            }

        } catch (SAXException | IOException | TransformerException | ParserConfigurationException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());

        }
    }
}
