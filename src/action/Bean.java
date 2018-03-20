/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

/**
 *
 * @author Rafael Recalcatti
 */
public class Bean {
        
    private static Object bean;
    private static String nameClient;
    private static String cpfClient;
    private static boolean isOpened = false;
    private static boolean isLoged = false;
    /**
     * @return the bean
     */
    public static Object getBean() {
        return bean;
    }

    /**
     * @param aBean the bean to set
     */
    public static void setBean(Object aBean) {
        bean = aBean;
       
    }

    /**
     * @return the nameClient
     */
    public static String getNameClient() {
        return nameClient;
    }

    /**
     * @param aNameClient the nameClient to set
     */
    public static void setNameClient(String aNameClient) {
        nameClient = aNameClient;
    }

    /**
     * @return the cpfClient
     */
    public static String getCpfClient() {
        return cpfClient;
    }

    /**
     * @param aCpfClient the cpfClient to set
     */
    public static void setCpfClient(String aCpfClient) {
        cpfClient = aCpfClient;
    }

    /**
     * @return the isOpened
     */
    public static boolean isIsOpened() {
        return isOpened;
    }

    /**
     * @param aIsOpened the isOpened to set
     */
    public static void setIsOpened(boolean aIsOpened) {
        isOpened = aIsOpened;
    }

    /**
     * @return the isLoged
     */
    public static boolean isIsLoged() {
        return isLoged;
    }

    /**
     * @param aIsLoged the isLoged to set
     */
    public static void setIsLoged(boolean aIsLoged) {
        isLoged = aIsLoged;
    }

    
}
