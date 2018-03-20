/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

/**
 *
 * @author User
 */
public class BeanCodeSale {
    
    private static String codeSale;
    private static String barCode;
    private static int numIten;
    private static double qtdIten;
    private static boolean isCancelItenDirect;
    

    /**
     * @return the codeSale
     */
    public static String getCodeSale() {
        return codeSale;
    }

    /**
     * @param aCodeSale the codeSale to set
     */
    public static void setCodeSale(String aCodeSale) {
        codeSale = aCodeSale;
    }

    /**
     * @return the qtdIten
     */
    public static double getQtdIten() {
        return qtdIten;
    }

    /**
     * @param aQtdIten the qtdIten to set
     */
    public static void setQtdIten(double aQtdIten) {
        qtdIten = aQtdIten;
    }

    /**
     * @return the barCode
     */
    public static String getBarCode() {
        return barCode;
    }

    /**
     * @param aBarCode the barCode to set
     */
    public static void setBarCode(String aBarCode) {
        barCode = aBarCode;
    }

    /**
     * @return the numIten
     */
    public static int getNumIten() {
        return numIten;
    }

    /**
     * @param aNumIten the numIten to set
     */
    public static void setNumIten(int aNumIten) {
        numIten = aNumIten;
    }

    /**
     * @return the isCancelItenDirect
     */
    public static boolean isIsCancelItenDirect() {
        return isCancelItenDirect;
    }

    /**
     * @param aIsCancelItenDirect the isCancelItenDirect to set
     */
    public static void setIsCancelItenDirect(boolean aIsCancelItenDirect) {
        isCancelItenDirect = aIsCancelItenDirect;
    }
    
}
