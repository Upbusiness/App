/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author root
 */ 
public class NumberInFull {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.err.println(numberInFull("999,17"));
        
    }

    public static String numberInFull(String arg) {
        System.err.println("ARG LENGTH"+arg.length());
        String value = "";
        int decimal;
        int decimal_2;
        int dezena;
        int dezena_2;
        int centena;
        int milhar = 0;

        if(arg.length()<5){
           arg = "0" + arg;
        }
        System.err.println("ARG LENGTH>>>>>>>>"+arg.length());
        decimal = Integer.parseInt(arg.substring(arg.length() - 1, arg.length()));
        decimal_2 = Integer.parseInt(arg.substring(arg.length() - 2, arg.length() - 1));
        dezena = Integer.parseInt(arg.substring(arg.length() - 4, arg.length() - 3));
        dezena_2 = Integer.parseInt(arg.substring(arg.length() - 5, arg.length() - 4));

        if (Integer.parseInt(arg.substring(arg.length() - 5, arg.length() - 3)) < 20) {

            switch (Integer.parseInt(arg.substring(arg.length() - 5, arg.length() - 3))) {

                case 1:
                    value += "um real";
                    break;
                case 2:
                    value += "dois reais";
                    break;
                case 3:
                    value += "trez reais";
                    break;
                case 4:
                    value += "quatro reais";
                    break;
                case 5:
                    value += "cinco reais";
                    break;
                case 6:
                    value += "seis reais";
                    break;
                case 7:
                    value += "sete reais";
                    break;
                case 8:
                    value += "oito reais";
                    break;
                case 9:
                    value += "nove reais";
                    break;
                case 10:
                    value += "dez reais";
                    break;
                case 11:
                    value += "onze reais";
                    break;
                case 12:
                    value += "doze reais";
                    break;
                case 13:
                    value += "treze reais";
                    break;
                case 14:
                    value += "quatorze reais";
                    break;
                case 15:
                    value += "quinze reais";
                    break;
                case 16:
                    value += "dezesseis reais";
                    break;
                case 17:
                    value += "dezessete reais";
                    break;
                case 18:
                    value += "dezoito reais";
                    break;
                case 19:
                    value += "dezenove reais";
                    break;

            }

        } else {

            switch (dezena_2) {

                case 2:
                    if(dezena == 0){
                    value += "vinte reais";
                    }else{  
                     value += "vinte";    
                    }                   
                    break;
                case 3:
                    if(dezena == 0){
                    value += "trinta reais";
                    }else{
                    value += "trinta";
                    }
                    break;
                case 4:
                    if(dezena == 0){
                    value += "quarenta reais";
                    }else{
                    value += "quarenta";
                    }
                    break;
                case 5:
                    if(dezena == 0){
                    value += "cinquenta reais";
                    }else{
                     value += "cinquenta";    
                    }
                    break;
                case 6:
                    if(dezena == 0){
                    value += "sessenta reais";
                    }else{
                     value += "sessenta";    
                    }
                    break;
                case 7:
                    if(dezena == 0){
                    value += "setenta reais";
                    }else{
                     value += "setenta";    
                    }
                    break;
                case 8:
                    if(dezena == 0){
                    value += "ointenta reais";
                    }else{
                    value += "ointenta";    
                    }
                    break;
                case 9:
                    if(dezena == 0){
                    value += "noventa reais";
                    }else{
                    value += "noventa";                         
                    }
                    break;

            }

            switch (dezena) {

                case 0:
                    value += "";
                    break;
                case 1:
                      
                    if(dezena > 0){
                    value += " e um reais";    
                    }else{
                    value += " e um real";   
                    }
                   
                    break;
                case 2:
                    value += " e dois reais";
                    break;
                case 3:
                    value += " e tres reais";
                    break;
                case 4:
                    value += " e quatro reais";
                    break;
                case 5:
                    value += " e cinco reais";
                    break;
                case 6:
                    value += " e seis reais";
                    break;
                case 7:
                    value += " e sete reais";
                    break;
                case 8:
                    value += " e oito reais";
                    break;
                case 9:
                    value += " e nove reais";
                    break;

            }

        }

        if (dezena != 0 || dezena_2 != 0 ) {
            //if(dezena_2 != 0)
            value += " e ";
        }

        //calculo dos centavos
        if (Integer.parseInt(arg.substring(arg.length() - 2, arg.length())) < 10) {

            switch (Integer.parseInt(arg.substring(arg.length() - 2, arg.length()))) {

                case 1:
                    value += "um centavo";
                    break;
                case 2:
                    value += "dois centavos";
                    break;
                case 3:
                    value += "três centavos";
                    break;
                case 4:
                    value += "quantro centavos";
                    break;
                case 5:
                    value += "cinco centavos";
                    break;
                case 6:
                    value += "seis centavos";
                    break;
                case 7:
                    value += "sete centavos";
                    break;
                case 8:
                    value += "ointo centavos";
                    break;
                case 9:
                    value += "nove centavos";
                    break;
                case 10:
                    value += "dez centavos";
                    break;

            }

        } else if (Integer.parseInt(arg.substring(arg.length() - 2, arg.length())) > 10 && Integer.parseInt(arg.substring(arg.length() - 2, arg.length())) < 20) {

            switch (Integer.parseInt(arg.substring(arg.length() - 2, arg.length()))) {
                case 11:
                    value += "onze centavos";
                    break;
                case 12:
                    value += "doze centavos";
                    break;
                case 13:
                    value += "treze centavos";
                    break;
                case 14:
                    value += "quatorze centavos";
                    break;
                case 15:
                    value += "quinze centavos";
                    break;
                case 16:
                    value += "dezesseis centavos";
                    break;
                case 17:
                    value += "dezessete centavos";
                    break;
                case 18:
                    value += "dezointo centavos";
                    break;
                case 19:
                    value += "dezenove centavos";
                    break;

            }

        } else {

            switch (decimal_2) {

                case 1:
                    value += "dez";
                    break;
                case 2:
                    value += "vinte";
                    break;
                case 3:
                    value += "trinta";
                    break;
                case 4:
                    value += "quarenta";
                    break;
                case 5:
                    value += "cinquenta";
                    break;
                case 6:
                    value += "sessenta";
                    break;
                case 7:
                    value += "setenta";
                    break;
                case 8:
                    value += "ointenta";
                    break;
                case 9:
                    value += "noventa";
                    break;

            }

            switch (decimal) {

                case 0:
                    value += " centavos";
                    break;
                case 1:
                    if(dezena == 0 && dezena_2 == 0 && decimal_2 == 0){
                    value += "um centavo";
                    }else{
                    value += " e um centavo";    
                    }
                    break;
                case 2:
                    if(dezena + dezena_2 + decimal_2 == 0){
                    value += "dois centavos";
                    }else{
                    value += " e dois centavos";
                    }                   
                    break;
                case 3:
                    if(dezena + dezena_2 + decimal_2 == 0){
                    value += "tres centavos";
                    }else{
                    value += " e tres centavos";
                    }                   
                    break;
                case 4:
                    if(dezena + dezena_2 + decimal_2 == 0){
                    value += "quatro centavos";
                    }else{
                    value += " e quatro centavos";
                    }                     
                    break;
                case 5:
                    if(dezena + dezena_2 + decimal_2 == 0){
                    value += "cinco centavos";
                    }else{
                    value += " e cinco centavos";
                    }
                    break;
                case 6:
                    if(dezena + dezena_2 + decimal_2 == 0){
                    value += "seis centavos";
                    }else{
                    value += " e seis centavos";
                    }                   
                    break;
                case 7:
                    if(dezena + dezena_2 + decimal_2 == 0){
                    value += "sete centavos";
                    }else{
                    value += " e sete centavos";
                    }                    
                    break;
                case 8:
                    if(dezena + dezena_2 + decimal_2 == 0){
                    value += "oito centavos";
                    }else{
                    value += " e oito centavos";
                    }                    
                    break;
                case 9:
                    if(dezena + dezena_2 + decimal_2 == 0){
                    value += "nove centavos";
                    }else{
                    value += " e nove centavos";
                    }                    
                    break;

            }

        }
        System.err.println("VALUE DE SUBSTRING>>>"+arg.substring(arg.length()-1,arg.length()));
        if("0".equals(arg.substring(arg.length()-1,arg.length())) && "0".equals(arg.substring(arg.length()-2,arg.length())))
        return value.trim().substring(0, value.length()-2);
        else
        return value;    

    }
}
