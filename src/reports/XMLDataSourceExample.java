/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

/**
 *
 * @author Rafael recalcatti
 */
// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   XMLDataSourceExample.java
import java.io.InputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import xml.NewXML;

public class XMLDataSourceExample {

    private static InputStream in;
    private static InputStream report;
    private static final NewXML newXML = new NewXML();

    public XMLDataSourceExample() {
    }

    public static void main(String args[])
            throws Exception {
        XMLDataSourceExample example = new XMLDataSourceExample();
        example.print();

    }

    public void print() throws JRException {
        String reportFileName = "reportRegisterLot.jasper";
        String outFileName = "addressbook.pdf";
        String xmlFileName = "lots_products.xml";
        String recordPath = "/src/";

        in = this.getClass().getResourceAsStream(xmlFileName);
        report = this.getClass().getResourceAsStream(xmlFileName);
        JRXmlDataSource jrxmlds = new JRXmlDataSource(reportFileName);
        HashMap hm = new HashMap();
        try {

            net.sf.jasperreports.engine.JasperPrint print = JasperFillManager.fillReport(reportFileName, hm, jrxmlds);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.exportReport();
            System.out.println((new StringBuilder()).append("Created file: ").append(outFileName).toString());
        } catch (JRException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            System.exit(1);
        }
    }
}
