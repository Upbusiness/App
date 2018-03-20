/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import action.Cashier;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import view.JDialogStarting;
import xml.NewXML;

/**
 *
 * @author Rafael
 */
public class CriaArquivoResumoCaixa {

    private static final DecimalFormat v = new DecimalFormat("0.00");
    private static final NewXML newXML = new NewXML();

    public static void criaArquivo(Cashier cashier, boolean isOld) {

        String rec = "\r\n";
        double v1 = cashier.getValue_removed_cashier();
        double v2 = cashier.getValue_started_cashier() + cashier.getValue_sales_cash() + cashier.getValue_add_cashier();
        double v3 = v2 - v1;
        int casasDecimais = 2;

        BigDecimal bd = new BigDecimal(v3);
        bd = bd.setScale(casasDecimais, BigDecimal.ROUND_HALF_UP);

        rec += "###############################################\t\r\n";
        rec += "#########           Resumo            #########\t\r\n";
        rec += "#########     Fechamento de Caixa     #########\t\r\n";
        rec += "###############################################\t\r\n";
        rec += "\r\n";
        rec += "     Usuario Inicial: " + cashier.getName_user_start_cashier() + "\t\r\n";
        rec += "     Data: " + cashier.getDate_open_cashier() + " Hora: " + cashier.getHour_open_cashier() + "\t\r\n";
        rec += "     Terminal: " + cashier.getTerminal_cashier() + " Turno: " + cashier.getTurn_cashier() + " Controle: " + cashier.getIdCashier() + "\t\r\n";
        rec += "_________________________________\t\r\n";
        rec += "\r\n";
        rec += "     Valor  Inicial R$: " + v.format(cashier.getValue_started_cashier()).replace(".", ",") + "\t\r\n";
        rec += "\r\n";
        rec += "---------------------------------\t\r\n";
        rec += "\r\n";
        rec += "     Valor Dinheiro R$: " + v.format(cashier.getValue_sales_cash()).replace(".", ",") + "\t\r\n";
        rec += "\r\n";
        rec += "     Quantidade Vendas: " + cashier.getQuantyti_sales_cash() + "\t\r\n";
        rec += "---------------------------------\t\r\n";
        rec += "\r\n";
        rec += "     Valor  Descontos  Dinheiro R$: " + v.format(cashier.getValue_discount_cash()).replace(".", ",") + "\t\r\n";
        rec += "\r\n";
        rec += "     Quantidade Descontos Dinheiro: " + cashier.getQuantyti_discount_cash()+ "\t\r\n";
        rec += "---------------------------------\t\r\n";
        rec += "\r\n";
        rec += "     Valor  Cartao  R$: " + v.format(cashier.getValue_sales_card()).replace(".", ",") + "\t\r\n";
        rec += "\r\n";
        rec += "     Quantidade Vendas: " + cashier.getQuantyti_sales_card() + "\t\r\n";
        rec += "---------------------------------\t\r\n";
        rec += "\r\n";
        rec += "     Valor  Descontos  Cartão R$: " + v.format(cashier.getValue_discount_card()).replace(".", ",") + "\t\r\n";
        rec += "\r\n";
        rec += "     Quantidade Descontos Cartão: " + cashier.getQuantyti_discount_card() + "\t\r\n";
        rec += "---------------------------------\t\r\n";
        rec += "\r\n";
        rec += "     Valor Removido R$: " + v.format(cashier.getValue_removed_cashier()).replace(".", ",") + "\t\r\n";
        rec += "\r\n";
        rec += "---------------------------------\t\r\n";
        rec += "\r\n";
        rec += "     Valor Adicionado R$: " + v.format(cashier.getValue_add_cashier()).replace(".", ",") + "\t\r\n";
        rec += "\r\n";
        rec += "---------------------------------\t\r\n";
        rec += "\r\n";
        rec += "     Valor  Total (Dinheiro)  R$: " + v.format(bd).replace(".", ",") + "\t\r\n";
        rec += "\r\n";
        rec += "---------------------------------\t\r\n";
        rec += "\r\n";
        if (isOld) {
            rec += "     Usuario Final: " + cashier.getName_user_end_cashier() + "\t\r\n";
            rec += "     Data: " + cashier.getDate_close_cashier() + " Hora: " + cashier.getHour_close_cashier() + "\t\r\n";
        } else {
            rec += "     Usuario Final: " + cashier.getName_user_end_cashier() + "\t\r\n";
            rec += "     Data: " + DateActual.setDate(new Date(), "dd/MM/yyyy") + " Hora: " + DateActual.setHour(new Date()) + "\t\r\n";
        }
        rec += "\r\n";
        rec += "###############################################\t\r\n";
        rec += "\r\n";
        rec += "\r\n";
        rec += "\r\n";
        rec += "\r\n";
        rec += "\r\n";

        FileReader fr;
        FileWriter fw;

        File copia = new File(JDialogStarting.config.getDir()+"resumo caixa.txt");
        try {
            //fr=new FileReader(origem);
            fw = new FileWriter(copia);
            System.out.println("Copiando Para:" + copia);
            if (copia.canRead()) {
                char c = 0;
                for (int i = 0; i < rec.length(); i++) {
                    c = rec.charAt(i);
                    fw.write(c);
                    //char caracter=(char)c;

                    System.out.println(c);
                }
            }

            fw.close();
        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            System.out.println("ERRO:" + ex.getMessage());
        } finally {
            System.out.println("Finalizando");
        }

    }
}
