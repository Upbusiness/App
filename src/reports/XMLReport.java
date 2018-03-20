/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.io.File;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.view.JasperViewer;
import view.JDialogStarting;
import xml.NewXML;

/**
 *
 * @author Rafael recalcatti
 */
public class XMLReport {

    private static final NewXML newXML = new NewXML();
    
    public static void main(String args[])
            throws Exception {
        XMLReport xml = new XMLReport();
        xml.imprimir("R1592036536C-1");

    }

    public void imprimir(String id) {
        try {
            System.out.println("Gerando relatario...");
            HashMap parameterMap = new HashMap();
            String path = JDialogStarting.config.getDir();
            File file = new File(path);
            file = file.getAbsoluteFile();
            String repStr2 = file.getPath();
            System.out.println(repStr2);
            parameterMap.put("id", id);
            JRXmlDataSource xmlDataSource = new JRXmlDataSource(new File(path + "lots_products_1.xml"), "/lots/vol");
            String arquivo = path + "reportRegisterLot.jasper";
            JasperPrint jp = JasperFillManager.fillReport(arquivo, null, xmlDataSource);

            JasperViewer.viewReport(jp, false);

        } catch (JRException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
    }

}
