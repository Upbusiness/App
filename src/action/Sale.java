/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.util.List;

/**
 *
 * @author Rafiusks
 */
public class Sale {

    private static String codCoupon;
    private static String oldCodeCoupon;
    private static boolean isRegistredAccount;
    private static boolean isNewCoupon;
    private static List<String> footerCoupon;
    private static boolean isPrintService;
    private static boolean isGenerateCodeCoupon;
    private static double productPrice;
    private static double productCost;
    private static double quantity;
    private static String productName;
    private static String productAbbreviature;
    private static String unityMeasure;
    private static double priceTotal;
    private static double costTotal;
    private static double discountCoupon;
    private static int quantityTotal;
    private static String categoryName;

    /**
     * @return the productPrice
     */
    public static double getProductPrice() {
        return productPrice;
    }

    /**
     * @param aProductPrice the productPrice to set
     */
    public static void setProductPrice(double aProductPrice) {
        productPrice = aProductPrice;
    }

    /**
     * @return the productName
     */
    public static String getProductName() {
        return productName;
    }

    /**
     * @param aProductName the productName to set
     */
    public static void setProductName(String aProductName) {
        productName = aProductName;
    }

    /**
     * @return the priceTotal
     */
    public static double getPriceTotal() {
        return priceTotal;
    }

    /**
     * @param aPriceTotal the priceTotal to set
     */
    public static void setPriceTotal(double aPriceTotal) {
        priceTotal = aPriceTotal;
    }

    /**
     * @return the quantityTotal
     */
    public static int getQuantityTotal() {
        return quantityTotal;
    }

    /**
     * @param aQuantityTotal the quantityTotal to set
     */
    public static void setQuantityTotal(int aQuantityTotal) {
        quantityTotal = aQuantityTotal;
    }

    /**
     * @return the quantity
     */
    public static double getQuantity() {
        return quantity;
    }

    /**
     * @param aQuantity the quantity to set
     */
    public static void setQuantity(double aQuantity) {
        quantity = aQuantity;
    }

    /**
     * @return the categoryName
     */
    public static String getCategoryName() {
        return categoryName;
    }

    /**
     * @param aCategoryName the categoryName to set
     */
    public static void setCategoryName(String aCategoryName) {
        categoryName = aCategoryName;
    }

    /**
     * @return the productAbbreviature
     */
    public static String getProductAbbreviature() {
        return productAbbreviature;
    }

    /**
     * @param aProductAbbreviature the productAbbreviature to set
     */
    public static void setProductAbbreviature(String aProductAbbreviature) {
        productAbbreviature = aProductAbbreviature;
    }

    /**
     * @return the unityMeasure
     */
    public static String getUnityMeasure() {
        return unityMeasure;
    }

    /**
     * @param aUnityMeasure the unityMeasure to set
     */
    public static void setUnityMeasure(String aUnityMeasure) {
        unityMeasure = aUnityMeasure;
    }

    /**
     * @return the productCost
     */
    public static double getProductCost() {
        return productCost;
    }

    /**
     * @param aProductCost the productCost to set
     */
    public static void setProductCost(double aProductCost) {
        productCost = aProductCost;
    }

    /**
     * @return the costTotal
     */
    public static double getCostTotal() {
        return costTotal;
    }

    /**
     * @param aCostTotal the costTotal to set
     */
    public static void setCostTotal(double aCostTotal) {
        costTotal = aCostTotal;
    }

    /**
     * @return the discountCoupon
     */
    public static double getDiscountCoupon() {
        return discountCoupon;
    }

    /**
     * @param aDiscountCoupon the discountCoupon to set
     */
    public static void setDiscountCoupon(double aDiscountCoupon) {
        discountCoupon = aDiscountCoupon;
    }

    /**
     * @return the codCoupon
     */
    public static String getCodCoupon() {
        return codCoupon;
    }

    /**
     * @param aCodCoupon the codCoupon to set
     */
    public static void setCodCoupon(String aCodCoupon) {
        codCoupon = aCodCoupon;
    }

    /**
     * @return the oldCodeCoupon
     */
    public static String getOldCodeCoupon() {
        return oldCodeCoupon;
    }

    /**
     * @param aOldCodeCoupon the oldCodeCoupon to set
     */
    public static void setOldCodeCoupon(String aOldCodeCoupon) {
        oldCodeCoupon = aOldCodeCoupon;
    }

    /**
     * @return the footerCoupon
     */
    public static List<String> getFooterCoupon() {
        return footerCoupon;
    }

    /**
     * @param aFooterCoupon the footerCoupon to set
     */
    public static void setFooterCoupon(List<String> aFooterCoupon) {
        footerCoupon = aFooterCoupon;
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
     * @return the isGenerateCodeCoupon
     */
    public static boolean isIsGenerateCodeCoupon() {
        return isGenerateCodeCoupon;
    }

    /**
     * @param aIsGenerateCodeCoupon the isGenerateCodeCoupon to set
     */
    public static void setIsGenerateCodeCoupon(boolean aIsGenerateCodeCoupon) {
        isGenerateCodeCoupon = aIsGenerateCodeCoupon;
    }

    /**
     * @return the isNewCoupon
     */
    public static boolean isIsNewCoupon() {
        return isNewCoupon;
    }

    /**
     * @param aIsNewCoupon the isNewCoupon to set
     */
    public static void setIsNewCoupon(boolean aIsNewCoupon) {
        isNewCoupon = aIsNewCoupon;
    }

    /**
     * @return the isRegistredAccount
     */
    public static boolean isIsRegistredAccount() {
        return isRegistredAccount;
    }

    /**
     * @param aIsRegistredAccount the isRegistredAccount to set
     */
    public static void setIsRegistredAccount(boolean aIsRegistredAccount) {
        isRegistredAccount = aIsRegistredAccount;
    }

}
