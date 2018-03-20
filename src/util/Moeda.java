/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

     import java.text.DecimalFormat;
     import java.text.DecimalFormatSymbols;
     import java.util.Locale;

     /**
    12.  * Classe que padroniza a internacionalizacao de valores monetarios
    13.  * @author Luiz Cavalcanti
    14.  * @version 0.1
    15.  * @see java.util.Locale
    16.  * @see java.text.DecimalFormat
    17.  * @see java.text.DecimalFormatSymbols
    18.  */
     public final class Moeda {

         /**
          * Simbolos especificos do Dolar Americano
          */
         private static final DecimalFormatSymbols DOLAR = new DecimalFormatSymbols(Locale.US);
         /**
          * Mascara de dinheiro para Dolar Americano
          */
         public static final DecimalFormat DINHEIRO_DOLAR = new DecimalFormat("¤ ###,###,##0.00",DOLAR);
        /**
         * Simbolos especificos do Euro
         */
         private static final DecimalFormatSymbols EURO = new DecimalFormatSymbols(Locale.GERMANY);
         /**
          * Mascara de dinheiro para Euro
          */
         public static final DecimalFormat DINHEIRO_EURO = new DecimalFormat("¤ ###,###,##0.00",EURO);
         /**
          * Locale Brasileiro
          */
         private static final Locale BRAZIL = new Locale("pt","BR");
         /**
          * Sï¿½mbolos especificos do Real Brasileiro
          */
         private static final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
         /**
          * Mascara de dinheiro para Real Brasileiro
          */
         public static final DecimalFormat DINHEIRO_REAL = new DecimalFormat("¤ ###,###,##0.00",REAL);

         /**
          * Mascara texto com formatacao monetaria
          * @param valor Valor a ser mascarado
          * @param moeda Padrao monetario a ser usado
          * @return Valor mascarado de acordo com o padrao especificado
          */
         public static String mascaraDinheiro(double valor, DecimalFormat moeda){
            return moeda.format(valor);
        }
         
         public static void main(String[] arg){
             
             double vl = 9672352.0909;
             System.err.println(mascaraDinheiro(vl, DINHEIRO_REAL));
             
         }
     }
