  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import action.Bean;
import action.BeanLogin;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import testes.PrintCoupon;
import util.DateActual;
import static view.JFrameSale_1.fnFormatTextHeader;
import static view.JFrameSale_1.fnLoadXMLTextCoupon;

/**
 *
 * @author CPU
 */
public class ClassPrintCoupon {

    private static final DecimalFormat v = new DecimalFormat("0.00");
    private static double quantityProduct;
    private static final PrintCoupon pc = new PrintCoupon();
    private static String numberItemStr;
    private static String str_value_item;
    private static String str_qtd_vs_vl_item;

    public ClassPrintCoupon() {

        fnLoadXMLTextCoupon();

    }

    public void printHeaderCoupon(boolean isOld, String arg, String dateHour, String idCashier, List<String> headerCoupon) {

        String dateActual = DateActual.setDate(new Date(), "dd/MM/yyyy  HH:mm:ss");
        System.err.println("HEADER PRINTER:::" + headerCoupon);
        for (String headerCoupon1 : headerCoupon) {
            pc.print(fnFormatTextHeader(headerCoupon1));
        }
        pc.print("\n------------------------------------------------");
        if (isOld) {
            pc.print("\n" + dateHour + "");
        } else {
            pc.print("\n" + dateActual + "");
        }
        pc.print("\nCOD.:" + arg + "             CC.:" + idCashier);
        pc.print("\n------------------------------------------------");
        pc.print("\n************ NAO E DOCUMENTO FISCAL ************");
        pc.print("\n------------------------------------------------");
        pc.print("\nITEM COD. DESCRICAO QTD. UN. VL. UNIT. VL. ITEM ");
        pc.print("\n------------------------------------------------");

    }

    public static boolean printLineCoupon(boolean isProductBalance, String barCode, double priceProduct, String str_qtd_item, String unity, String abbreviature, int number_item) {

        String qtd = str_qtd_item;
        BigDecimal r;

        if (isProductBalance) {
            if (unity.equals("UN")) {
                str_qtd_item = str_qtd_item.substring(0, str_qtd_item.length() - 4);
            }
        } else {
            if (abbreviature.equals("PRODUTO PADRAO")) {

                str_qtd_item = str_qtd_item.substring(0, str_qtd_item.length() - 1);

            } else if (str_qtd_item.contains(".")) {
                str_qtd_item = str_qtd_item.substring(0, str_qtd_item.length() - 4);

            }
        }
        if (String.valueOf(number_item).length() == 1) {
            numberItemStr = "00" + String.valueOf(number_item);
        } else if (String.valueOf(number_item).length() == 2) {
            numberItemStr = "0" + String.valueOf(number_item);
        } else {
            numberItemStr = String.valueOf(number_item);
        }
        str_qtd_item = str_qtd_item + unity + " X " + v.format(priceProduct).replace(".", ",") + " ";
        quantityProduct = Double.parseDouble(qtd.replace(",", "."));
        r = BigDecimal.valueOf(quantityProduct * priceProduct);
        str_value_item = v.format(r);

        switch (str_qtd_item.concat(str_value_item).length()) {
            case 13:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                           " + str_value_item + "$";
                break;
            case 14:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                          " + str_value_item + "$";
                break;
            case 15:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                         " + str_value_item + "$";
                break;
            case 16:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                        " + str_value_item + "$";
                break;
            case 17:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                       " + str_value_item + "$";
                break;
            case 18:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                      " + str_value_item + "$";
                break;
            case 19:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                     " + str_value_item + "$";
                break;
            case 20:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                    " + str_value_item + "$";
                break;
            case 21:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                   " + str_value_item + "$";
                break;
            case 22:
                str_qtd_vs_vl_item = "       " + str_qtd_item.replace(".", ",") + "                  " + str_value_item + "$";
                break;
        }

        return pc.print("\n" + numberItemStr + " " + completeEspaceEmpyBarCode(barCode) + " " + completeEspaceEmpytAbbreviature(abbreviature) + str_qtd_vs_vl_item);

    }

    protected static String completeEspaceEmpytAbbreviature(String text) {
        switch (text.length()) {
            case 2:
                return text.concat("                           ");
            case 3:
                return text.concat("                          ");
            case 4:
                return text.concat("                         ");
            case 5:
                return text.concat("                        ");
            case 6:
                return text.concat("                       ");
            case 7:
                return text.concat("                       ");
            case 8:
                return text.concat("                      ");
            case 9:
                return text.concat("                     ");
            case 10:
                return text.concat("                    ");
            case 11:
                return text.concat("                   ");
            case 12:
                return text.concat("                  ");
            case 13:
                return text.concat("                 ");
            case 14:
                return text.concat("                ");
            case 15:
                return text.concat("               ");
            case 16:
                return text.concat("              ");
            case 17:
                return text.concat("             ");
            case 18:
                return text.concat("            ");
            case 19:
                return text.concat("           ");
            case 20:
                return text.concat("          ");
            case 21:
                return text.concat("         ");
            case 22:
                return text.concat("        ");
            case 23:
                return text.concat("       ");
            case 24:
                return text.concat("      ");
            case 25:
                return text.concat("     ");
            case 26:
                return text.concat("    ");
            case 27:
                return text.concat("   ");
            case 28:
                return text.concat("  ");
            case 29:
                return text.concat(" ");
            case 30:
                return text;
        }
        return null;
    }

    protected static String completeEspaceEmpyBarCode(String text) {
        switch (text.length()) {
            case 1:
                return "000000000000".concat(text);
            case 2:
                return "00000000000".concat(text);
            case 3:
                return "0000000000".concat(text);
            case 4:
                return "000000000".concat(text);
            case 5:
                return "00000000".concat(text);
            case 6:
                return "0000000".concat(text);
            case 7:
                return "000000".concat(text);
            case 8:
                return "00000".concat(text);
            case 9:
                return "0000".concat(text);
            case 10:
                return "000".concat(text);
            case 11:
                return "00".concat(text);
            case 12:
                return "0".concat(text);
            case 13:
                return text;
            case 14:
                return text.substring(1, 14);
        }
        return null;
    }

    public boolean printFooterCoupon(boolean isOld, List<Double> list_value_pay_coupon, List<String> list_type_pay_coupon, double value_coupon, double value_pay_coupon, List<Double> list_value_cash_pay_coupon, boolean validate, List<String> footerCoupon) {

        String str_value_total = null;
        String str_value_type_pag;
        String str_change_sale = null;
        String str_sum_sale = null;
        List<Object> listLinePrint = new ArrayList<>();
        double changeSale;
        double sumValuePaySale = 0;
        double sumValueDiscount = 0;
        String dateActual = DateActual.setDate(new Date(), "EEE, dd MMM yyyy HH:mm:ss ");

        System.err.println("TIPO PAG::"+list_type_pay_coupon);
        for (int i = 0; i < list_value_pay_coupon.size(); i++) {
            if (list_type_pay_coupon.get(i).equals("DESCONTO")) {
                sumValueDiscount += list_value_pay_coupon.get(i);
            } else {
                sumValuePaySale += list_value_pay_coupon.get(i);
            }
        }

        changeSale = (sumValuePaySale + (sumValueDiscount * -1)) - value_coupon;
        sumValuePaySale = sumValuePaySale + sumValueDiscount;
        
        
        for (int i = 0; i < list_type_pay_coupon.size(); i++) {
            System.err.println("VALU PAG::"+list_value_cash_pay_coupon);
            if (list_value_cash_pay_coupon == null) {
                switch (v.format(value_pay_coupon).length()) {

                    case 4:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                                " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                                  " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;
                    case 5:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                               " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                                 " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;
                    case 6:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                              " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                                " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;
                    case 7:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                             " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                               " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;
                    case 8:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                            " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                              " + v.format(list_value_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;

                }
            } else {
                switch (v.format(list_value_cash_pay_coupon.get(i)).length()) {

                    case 4:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                                " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                                  " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;
                    case 5:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                               " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                                 " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;
                    case 6:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                              " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                                " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;
                    case 7:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                             " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                               " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;
                    case 8:
                        if (!list_type_pay_coupon.get(i).equals("CARTAO")) {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                            " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        } else {
                            str_value_type_pag = "\n" + list_type_pay_coupon.get(i) + " R$                              " + v.format(list_value_cash_pay_coupon.get(i)).replace(".", ",");
                        }
                        listLinePrint.add(str_value_type_pag);
                        break;

                }
            }
        }
        switch (v.format(changeSale).length()) {

            case 4:
                str_change_sale = "\nTROCO R$                                   " + v.format(changeSale).replace(".", ",");
                break;
            case 5:
                str_change_sale = "\nTROCO R$                                  " + v.format(changeSale).replace(".", ",");
                break;
            case 6:
                str_change_sale = "\nTROCO R$                                 " + v.format(changeSale).replace(".", ",");
                break;
            case 7:
                str_change_sale = "\nTROCO R$                                " + v.format(changeSale).replace(".", ",");
                break;
            case 8:
                str_change_sale = "\nTROCO R$                               " + v.format(changeSale).replace(".", ",");
                break;

        }

        switch (v.format(sumValuePaySale).length()) {

            case 4:
                str_sum_sale = "\nSOMA R$                                    " + v.format(sumValuePaySale).replace(".", ",");
                break;
            case 5:
                str_sum_sale = "\nSOMA R$                                   " + v.format(sumValuePaySale).replace(".", ",");
                break;
            case 6:
                str_sum_sale = "\nSOMA R$                                  " + v.format(sumValuePaySale).replace(".", ",");
                break;
            case 7:
                str_sum_sale = "\nSOMA R$                                 " + v.format(sumValuePaySale).replace(".", ",");
                break;
            case 8:
                str_sum_sale = "\nSOMA R$                                " + v.format(sumValuePaySale).replace(".", ",");
                break;

        }
        switch (v.format(value_coupon).length()) {

            case 4:
                str_value_total = "\nTOTAL R$                                   " + v.format(value_coupon).replace(".", ",");
                break;
            case 5:
                str_value_total = "\nTOTAL R$                                  " + v.format(value_coupon).replace(".", ",");
                break;
            case 6:
                str_value_total = "\nTOTAL R$                                 " + v.format(value_coupon).replace(".", ",");
                break;
            case 7:
                str_value_total = "\nTOTAL R$                                " + v.format(value_coupon).replace(".", ",");
                break;
            case 8:
                str_value_total = "\nTOTAL R$                               " + v.format(value_coupon).replace(".", ",");
                break;

        }

        pc.print("\n                                ----------------");
        pc.print(str_value_total);
           
        for (Object listLinePrint1 : listLinePrint) {
            System.err.println("LINE PRINT::"+listLinePrint1);
             pc.print(ajustSpace(listLinePrint1.toString()));    
            
        }
        if (list_type_pay_coupon.size() > 1) {
             System.err.println("****IF1:"+str_sum_sale);
            pc.print(str_sum_sale);
        }
        if (changeSale > 0) {
            System.err.println("****IF2:"+str_change_sale);
            pc.print(str_change_sale);
        }

        pc.print("\n");
        pc.print("\n================================================");
        for (String footerCoupon1 : footerCoupon) {
            pc.print(footerCoupon1 + "\n");
        }
        pc.print("\n================================================");
        if (validate) {
            pc.print("\nEU: "+Bean.getNameClient());
            pc.print("\nCPF: "+Bean.getCpfClient()+", RECONHECO A DIVIDA ");
            pc.print("\nACIMA IDENTIFICADA E REGISTRADA POR ESTE CUPOM. ");
            pc.print("\n");
            pc.print("\nASS.:_______________________________________    ");
        } else {
            if (isOld) {
                pc.print("\n--------------***REIMPRESSAO***-----------------");
            }
        }
        pc.print("\nUSER:" + BeanLogin.getUser() + "           " + dateActual);
        pc.print("\n\n\n\n");
        pc.print("" + (char) 27 + (char) 112 + (char) 0 + (char) 100 + (char) 200 + "\n");

        //valuePayList.clear();
        //valueTypeList.clear();
        return pc.print("" + (char) 27 + (char) 109 + "\n");

    }

    public void printUserCashier(int type, String user, String description, String value, String idCashier, String control, List<String> headerCoupon) {

        String dateActual = DateActual.setDate(new Date(), "dd/MM/yyyy HH:mm:ss");

        for (String headerCoupon1 : headerCoupon) {
            pc.print(fnFormatTextHeader(headerCoupon1));
        }
        pc.print("\n------------------------------------------------");
        pc.print("\n##### RELATORIO GERENCIAL MOVIMENTOS CAIXA #####");
        pc.print("\n------------------------------------------------");

        if (type == 1) {
            pc.print("\n################################################");
            pc.print("\n############### SANGRIA CAIXA ##################");
            pc.print("\n################################################");

        } else if (type == 2) {
            pc.print("\n################################################");
            pc.print("\n############## INSERCAO CAIXA ##################");
            pc.print("\n################################################");
        } else if (type == 3) {
            pc.print("\n################################################");
            pc.print("\n############## ABERTURA CAIXA ##################");
            pc.print("\n################################################");
        }

        pc.print("\nCOD.:" + control + "             CC.:" + idCashier);
        pc.print("\n------------------------------------------------");
        pc.print("\nValor R$: " + value);
        pc.print("\nUsuario: " + user);
        pc.print("\nResponsavel:");
        pc.print(description.equals(null) ? "" : "\nDescricao:"+description);
        pc.print("\n");
        pc.print("\nAss./Carimbo:__________________________________ ");
        pc.print("\nData: " + dateActual + "  Terminal: " + JFrameSale_1.jLabelTerminalNumber.getText() + "  Turno: " + JFrameSale_1.jLabelTurnNumber.getText());
        pc.print("\n------------------------------------------------");
        pc.print("\n################################################");
        pc.print("\n");
        pc.print("\n");
        pc.print("\n################################################");

    }
    
    public static String ajustSpace(String str){
        
        if(str.contains("                                ")){
             
            return  str.replace("                                ",(str.contains("ALIMENTAÇÃO") ? "                     ":"                         "));
            
        }else if(str.contains("                               ")){
           
            return  str.replace("                               ",(str.contains("ALIMENTAÇÃO") ? "                    ":"                        "));
            
        }else if(str.contains("                              ")){
            
            return  str.replace("                              ",(str.contains("ALIMENTAÇÃO") ? "                   ":"                       "));
            
        }else if(str.contains("                             ")){
            
            return  str.replace("                             ",(str.contains("ALIMENTAÇÃO") ? "                  ":"                      "));
            
        }else{ 
            
            return  str;
            
        }
        
        
    }
}
