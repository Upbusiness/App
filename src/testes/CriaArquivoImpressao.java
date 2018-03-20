/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import xml.NewXML;

/**
 *
 * @author root
 */
public class CriaArquivoImpressao {

    private static final NewXML newXML = new NewXML();

    public static void main(String[] arg) {

        criaarquivo();

    }

    public static void criaarquivo() {
        //ESCREVER TXT      
        try {
            File arquivo = new File("E:\\Nova pasta\\resumo caixa.txt");
            if (arquivo.exists()) {
                //se existir  
                FileWriter arquivoTxt = new FileWriter(arquivo, true);
                PrintWriter linhasTxt = new PrintWriter(arquivoTxt);
                //ACREDITO QUE SO PODE TER 42 CARACTERES  
                linhasTxt.println("==============================================");
                linhasTxt.println("              Nome da empresa                 ");
                linhasTxt.println("==============================================");
                linhasTxt.println("*********** NAO E DOCUMENTO FISCAL ***********");
                linhasTxt.println("==============================================");
                linhasTxt.println("ITEM CODIGO DESCRICAO QTD. UN. VL UNIT VL ITEM");
                linhasTxt.println("----------------------------------------------");
                int i = 0;
                while (i < 10) {
                    i++;
                    linhasTxt.println();
                }
                arquivoTxt.close();
          //emiteComanda();  

            } else {
                //se naum existir  
                arquivo.createNewFile();
                //criaTxt();  
            }
        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            System.out.println("nao encontrei arquivo");
        }

        // imprime arquivo   
        try {
            java.io.InputStream is = new FileInputStream("E:\\Nova pasta\\resumo caixa.txt");
            Scanner sc = new Scanner(is);
            FileOutputStream fs = new FileOutputStream("COM1");

      //fs.getFD().sync();
            //fs.getChannel().lock();
            PrintStream ps = new PrintStream(fs);

            while (sc.hasNextLine()) {
                String linhas = sc.nextLine();
                ps.println(linhas);
                ps.println("");
            }
            fs.close();
        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            JOptionPane.showMessageDialog(null, "Erro encontrado ao imprimir comanda.");
        }

    }

}
