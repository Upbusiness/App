
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

//~--- non-JDK imports --------------------------------------------------------
//~--- JDK imports ------------------------------------------------------------
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrinterName;
import model.ConnRel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JasperViewer;
import xml.NewXML;

/**
 *
 * @author Rafael
 */
public class ImprimirRelatorio_2 {

    private static Connection conn;
    private static final NewXML newXML = new NewXML();
    
    public void visualizarRelatorio(Object[] valPar, Object[] par, String relatorioName, boolean isView) {
        try {
            conn = ConnRel.getConnection();
        } catch (Exception ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            Logger.getLogger(ImprimirRelatorio_2.class.getName()).log(Level.SEVERE, null, ex);
        }

        // parametros
        try {

            HashMap<String, Object> parametros = new HashMap<>();

            for (int i = 0; i < par.length; i++) {
                parametros.put(par[i].toString(), valPar[i]);
                System.out.println(par[i] + "==" + valPar[i]);

                // parametros.put("PAR_CAT",categ);
            }

            String a = relatorioName;

            // lê o arquivo dentro do pacote
            // mecessário caso gere um JAR para distribuir
            InputStream in = this.getClass().getResourceAsStream(a);

            String arquivoJasper = System.getProperty("user.dir") + "/src/reports/" + a;
            // chama fillReport
            JasperPrint jp = JasperFillManager.fillReport(in, parametros, conn);

            if (!jp.getPages().isEmpty()) {
                // exibe o relatório com viewReport
                if (isView) {
                    JasperViewer.viewReport(jp, false);
                } else {
                    imprimir(jp);
                }
            } else {
                //JOptionPane.showMessageDialog(null, "Não há dados a serem exibidos.");
            }
        } catch (JRException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.err.println("ERROR::" + ex);
                //newXML.generateLog(ex.toString());
            }
        }
    }

    private void imprimir(JasperPrint impressao) {
        try {
            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRPrintServiceExporterParameter.JASPER_PRINT, impressao);
            PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
            aset.add(new Copies(1));
            aset.add(MediaSizeName.E);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, aset);
            PrintServiceAttributeSet serviceAttributeSet = new HashPrintServiceAttributeSet();
            PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();
            System.out.println((new StringBuilder()).append("Impressora padrão:: ").append(impressora.getName()).toString());
            serviceAttributeSet.add(new PrinterName(impressora.getName(), Locale.getDefault()));
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, serviceAttributeSet);
            System.out.println("Inicializando impressão");
            exporter.exportReport();
            System.out.println("Impressão finalizada");
        } catch (JRException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            Logger.getLogger(ImprimirRelatorio_cupom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

//Aqui método donwload


//~ Formatted by Jindent --- http://www.jindent.com
