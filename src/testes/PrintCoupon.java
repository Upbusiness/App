/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import javax.print.*;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import xml.NewXML;

// Essa classe é a responsavel pela impressao. Ela detecta a impressora  
// instalada, recebe o texto e o imprime.  
public final class PrintCoupon {

    // variavel estatica porque será utilizada por inumeras threads  
    private static PrintService impressora;
    private static final NewXML newXML = new NewXML();

    public PrintCoupon() {

        detectaImpressoras();

    }

    // O metodo verifica se existe impressora conectada e a  
    // define como padrao.  
    public void detectaImpressoras() {

        try {

            PrintService[] servicosImpressao = PrintServiceLookup.lookupPrintServices(
                    DocFlavor.INPUT_STREAM.AUTOSENSE, null);

            System.out.println("Impressoras com suporte: " + servicosImpressao.length);

            // Localiza a impressora padrão
            impressora = PrintServiceLookup.lookupDefaultPrintService();

            System.out.println("Impressora: " + impressora.getName());

        } catch (Exception ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

    }

    public synchronized boolean print(String texto) {

        // se nao existir impressora, entao avisa usuario  
        // senao imprime texto  
        if (impressora == null) {

            String msg = "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.";
            System.out.println(msg);

        } else {

            try {
              texto = texto.replace("ç", "c").
                        replace("Ç", "C").
                        replace("ã", "a").
                        replace("Ã", "A").
                        replace("á", "&a").
                        replace("Á", "A").
                        replace("é", "e").
                        replace("É", "E");
                        
                DocPrintJob dpj = impressora.createPrintJob();
                InputStream stream = new ByteArrayInputStream(texto.getBytes());

                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc doc = new SimpleDoc(stream, flavor, null);
                dpj.print(doc, null);

                return true;

            } catch (PrintException ex) {
                System.err.println("ERROR::" + ex);
                ////newXML.generateLog(ex.toString());
            }

        }

        return false;

    }

    public synchronized boolean openDrawer() {

        try {
            DocPrintJob dpj = impressora.createPrintJob();
            InputStream stream = new ByteArrayInputStream(("" + (char) 27 + (char) 112 + (char) 0 + (char) 100 + (char) 200 + "\n").getBytes());//aciona gaveta ""+(char)27 + (char)118 + (char)140+ "\n"    
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(stream, flavor, null);
            dpj.print(doc, null);

            return true;

        } catch (PrintException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }

        return false;
    }

    public synchronized boolean openDrawer2() {

        try {
            FileOutputStream os = new FileOutputStream("USB001");
            try ( //FileOutputStream fs = new FileOutputStream("USB001");
                    PrintStream ps = new PrintStream(os)) {
                ps.print((char) 27);
                ps.print((char) 112);
                ps.print((char) 0);
                ps.print((char) 100);
                ps.print((char) 200);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        return true;
    }

    public synchronized boolean actionGuillotine() {

        try {
            DocPrintJob dpj = impressora.createPrintJob();
            InputStream stream = new ByteArrayInputStream(("" + (char) 27 + (char) 109 + "\n").getBytes());//aciona gaveta ""+(char)27 + (char)118 + (char)140+ "\n"    
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc doc = new SimpleDoc(stream, flavor, null);
            dpj.print(doc, null);

            return true;

        } catch (PrintException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }

        return false;

    }

}
