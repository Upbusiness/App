/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.Random;
import util.DateActual;

/**
 *
 * @author Rafiusks
 */
public class ClassCodRandon {

    public static String codeGeneratorCoupon() {

        Random gerador = new Random();
        Object[] caracter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "W", "Y", "V"};
        Object cod = caracter[gerador.nextInt(26)];

        for (int i = 0; i < 13; i++) {

            cod += String.valueOf(gerador.nextInt(10));

        }

        return cod.toString();
    }

    public static String codeGeneratorInvoice() {

        Random gerador = new Random();
        Object[] caracter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "W", "Y", "V"};
        Object cod = "";

        for (int i = 0; i < 5; i++) {

            cod += String.valueOf(gerador.nextInt(10));

        }

        return "I" + cod.toString() + caracter[gerador.nextInt(26)];
    }

    public static String codeGeneratorVendor() {

        Random gerador = new Random();
        Object[] caracter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "W", "Y", "V"};
        Object cod = "";

        for (int i = 0; i < 5; i++) {

            cod += String.valueOf(gerador.nextInt(10));

        }

        return "F" + cod.toString() + caracter[gerador.nextInt(26)];
    }

    public static String codeGeneratorCard() {

        Random gerador = new Random();
        Object[] caracter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "W", "Y", "V"};
        Object cod = "";

        for (int i = 0; i < 3; i++) {

            cod += String.valueOf(gerador.nextInt(10));

        }

        return "S" + cod.toString() + caracter[gerador.nextInt(26)];
    }

     
    public static String codeGeneratorLot() {

        Random gerador = new Random();
        Object cod = "";
        Object[] caracter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "W", "Y", "V"};

        for (int i = 0; i < 4; i++) {

            cod += String.valueOf(gerador.nextInt(10));

        }

        return "L" + cod.toString() + caracter[gerador.nextInt(26)] + DateActual.setDate(new Date(), "Y");
    }

    public static String codeGeneratorReserveIn() {

        Random gerador = new Random();
        Object[] caracter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "W", "Y", "V"};
        Object cod = "";

        for (int i = 0; i < 10; i++) {

            cod += String.valueOf(gerador.nextInt(10));

        }

        return "R" + cod.toString() + caracter[gerador.nextInt(26)];
    }
    
    public static String codeGeneratorCashier() {

        Random gerador = new Random();
        Object[] caracter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "W", "Y", "V"};
        Object cod = "";

        for (int i = 0; i < 7; i++) {

            cod += String.valueOf(gerador.nextInt(10));

        }

        return "C" + cod.toString() + caracter[gerador.nextInt(26)];
    }
     public static String codeGeneratorOpenCashier() {

        Random gerador = new Random();
        Object[] caracter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "W", "Y", "V"};
        Object cod = "";

        for (int i = 0; i < 4; i++) {

            cod += String.valueOf(gerador.nextInt(10));

        }

        return "OC" + cod.toString() + caracter[gerador.nextInt(26)];
    }
     
     public static String codeGeneratorCostOperate() {

        Random gerador = new Random();
        Object cod = "";

        for (int i = 0; i < 3; i++) {

            cod += String.valueOf(gerador.nextInt(10));

        }

        return "CO" + cod.toString();
    }
}
