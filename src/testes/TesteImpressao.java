/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.JOptionPane;
import xml.NewXML;

/**
 *
 * @author User
 */
public class TesteImpressao {

    private static PrintService impressora;
    private static final NewXML newXML = new NewXML();

    public static void main(String[] arg) {

        TesteImpressao ti = new TesteImpressao();
        ti.acionarGuilhotina();

    }

    public static List<String> retornaImressoras() {
        try {
            List<String> listaImpressoras = new ArrayList<>();
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
            for (PrintService p : ps) {
                listaImpressoras.add(p.getName());
            }
            return listaImpressoras;
        } catch (Exception ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        return null;
    }
  // O Atributo citado anteriormente  

    public void detectaImpressoras(String impressoraSelecionada) {  //Passa por parâmetro o nome salvo da impressora  
        try {
            DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
            PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
            for (PrintService p : ps) {
                if (p.getName() != null && p.getName().contains(impressoraSelecionada)) {
                    impressora = p;
                }
            }
        } catch (Exception ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
    }

    public boolean imprime(String texto) {

        if (impressora == null) {
            JOptionPane.showMessageDialog(null, "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.");
        } else {
            try {
                DocPrintJob dpj = impressora.createPrintJob();
                InputStream stream = new ByteArrayInputStream((texto + "\n").getBytes());
                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new SimpleDoc(stream, flavor, null);
                dpj.print(doc, null);
                return true;
            } catch (PrintException ex) {
                System.err.println("ERROR::" + ex);
                //newXML.generateLog(ex.toString());
            }
        }
        return false;
    }

    public void acionarGuilhotina() {
        //imprime(""+(char)27+(char)109);  
        imprime("F" + (char) 1 + 'p' + (char) 0 + (char) 25 + (char) 250);
    }
}
