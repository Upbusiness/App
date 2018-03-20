/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import xml.XML_Config;

/**
 *
 * @author User
 */
public class BeanConfig {
    
    private static String ip;
    private static String path;
    private static String logo;
    private static boolean isPrintService;
    private static boolean isCoolRate;
    private static double valueCoolRate;
    private static boolean isAddCigarreteRate;
    private static String headerCoupon;
    private static String footerCoupon;
    private static final File file = new File(System.getProperty("user.dir")+"/config.xml");
    private static List<Object> config;

    /**
     * @return the ip
     */
    public static String getIp() {        
        return ip;
    }

    /**
     * @param aIp the ip to set
     */
    public static void setIp(String aIp) {
        ip = aIp;
    }

    /**
     * @return the path
     */
    public static String getPath() {
        return path;
    }

    /**
     * @param aPath the path to set
     */
    public static void setPath(String aPath) {
        path = aPath;
    }

    /**
     * @return the logo
     */
    public static String getLogo() {
        return logo;
    }

    /**
     * @param aLogo the logo to set
     */
    public static void setLogo(String aLogo) {
        logo = aLogo;
    }

    /**
     * @return the isPrintService
     */
    public static boolean isIsPrintService() {
        return isPrintService;
    }

    /**
     * @param aIsPrintService the isPrintService to set
     */
    public static void setIsPrintService(boolean aIsPrintService) {
        isPrintService = aIsPrintService;
    }

    /**
     * @return the isCoolRate
     */
    public static boolean isIsCoolRate() {
        return isCoolRate;
    }

    /**
     * @param aIsCoolRate the isCoolRate to set
     */
    public static void setIsCoolRate(boolean aIsCoolRate) {
        isCoolRate = aIsCoolRate;
    }

    /**
     * @return the valueCoolRate
     */
    public static double getValueCoolRate() {
        return valueCoolRate;
    }

    /**
     * @param aValueCoolRate the valueCoolRate to set
     */
    public static void setValueCoolRate(double aValueCoolRate) {
        valueCoolRate = aValueCoolRate;
    }

    /**
     * @return the isAddCigarreteRate
     */
    public static boolean isIsAddCigarreteRate() {
        return isAddCigarreteRate;
    }

    /**
     * @param aIsAddCigarreteRate the isAddCigarreteRate to set
     */
    public static void setIsAddCigarreteRate(boolean aIsAddCigarreteRate) {
        isAddCigarreteRate = aIsAddCigarreteRate;
    }

    /**
     * @return the headerCoupon
     */
    public static String getHeaderCoupon() {
        return headerCoupon;
    }

    /**
     * @param aHeaderCoupon the headerCoupon to set
     */
    public static void setHeaderCoupon(String aHeaderCoupon) {
        headerCoupon = aHeaderCoupon;
    }

    /**
     * @return the footerCoupon
     */
    public static String getFooterCoupon() {
        return footerCoupon;
    }

    /**
     * @param aFooterCoupon the footerCoupon to set
     */
    public static void setFooterCoupon(String aFooterCoupon) {
        footerCoupon = aFooterCoupon;
    }
   
    public BeanConfig(){
        
        config = new ArrayList<>(XML_Config.loadConfig(file.getPath()));       
        ip = (String) config.get(0);
        path = (String) config.get(1);
        logo = (String) config.get(2);
        isPrintService =  Boolean.valueOf(config.get(3).toString());
        isCoolRate =  Boolean.valueOf(config.get(4).toString());
        valueCoolRate = new Double(config.get(5).toString());
        isAddCigarreteRate =  Boolean.valueOf(config.get(6).toString());
        headerCoupon = (String) ((config.size()<8) ? "" :  config.get(7));
        footerCoupon = (String) ((config.size()<9) ? "" :  config.get(8));
        
    }
}