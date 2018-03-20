/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import testes.PrintCoupon;
import view.JDialogStarting;
import xml.NewXML;

public class ImpressaoJPS {

    private static final NewXML newXML = new NewXML();

    public static void main(String[] arg) {
        ImpressaoJPS impressaoJPS = new ImpressaoJPS(true);

    }

    public ImpressaoJPS(boolean mostrarDialogo) {
        System.out.println(mostrarDialogo);
        try {
            // Localiza todas as impressoras com suporte a arquivos txt
            PrintService[] servicosImpressao = PrintServiceLookup.lookupPrintServices(
                    DocFlavor.INPUT_STREAM.AUTOSENSE, null);

            System.out.println("Impressoras com suporte: " + servicosImpressao.length);

            // Localiza a impressora padrão
            PrintService impressora = PrintServiceLookup.lookupDefaultPrintService();

            System.out.println("Impressora: " + impressora.getName());

            System.out.println("Imprimindo arquivo-texto");

            // Definição de atributos do conteúdo a ser impresso:
            DocFlavor docFlavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

            // Atributos de impressão do documento
            HashDocAttributeSet attributes = new HashDocAttributeSet();
            System.err.println("Diretorio do arquivo de resumo caixa:"+JDialogStarting.config.getDir()+"resumo caixa.txt");
            // InputStream apontando para o conteúdo a ser impresso
            FileInputStream fi = new FileInputStream(JDialogStarting.config.getDir()+"resumo caixa.txt");

            // Cria um Doc para impressão a partir do arquivo exemplo.txt
            Doc documentoTexto = new SimpleDoc(fi, docFlavor, attributes);

            // Configura o conjunto de parametros para a impressora
            PrintRequestAttributeSet printerAttributes = new HashPrintRequestAttributeSet();

            System.out.println(mostrarDialogo);

            mostrarDialogo = false;

            if (mostrarDialogo) {
                // exibe um dialogo de configuracoes de impressao
                PrintService servico = ServiceUI.printDialog(null, 20, 40,
                        servicosImpressao, impressora, docFlavor, printerAttributes);

                if (servico != null) {
                    DocPrintJob printJob = servico.createPrintJob();
                    printJob.print(documentoTexto, printerAttributes);
                }
            } else {
                // Cria uma tarefa de impressão
                DocPrintJob printJob = impressora.createPrintJob();

                // Adiciona propriedade de impressão: imprimir duas cópias
                printerAttributes.add(new Copies(2));

                // Imprime o documento sem exibir uma tela de dialogo
                printJob.print(documentoTexto, printerAttributes);

                PrintCoupon pc = new PrintCoupon();
                pc.actionGuillotine();
            }
        } catch (FileNotFoundException ex) {
            System.err.println("ERROR::" + ex);
           // //newXML.generateLog(ex.toString());
            System.out.println("Arquivo resumo caixa.txt não encontrado!");
        } catch (PrintException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            System.out.println("Erro de impressão: " + ex.getMessage());
        }
    }

}
