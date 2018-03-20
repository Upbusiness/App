/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author User
 */
public class PaymentCoupon {
    
    private static double totalCoupon;
    private static BigDecimal smallCash = new BigDecimal(BigInteger.ONE);
    private static double valuepayment;
    private static double discoutPayment;    

    /**
     * @return the totalCoupon
     */
    public static double getTotalCoupon() {
        return totalCoupon;
    }

    /**
     * @param aTotalCoupon the totalCoupon to set
     */
    public static void setTotalCoupon(double aTotalCoupon) {
        totalCoupon = aTotalCoupon;
    }

    /**
     * @return the smallCash
     */
    public static BigDecimal getSmallCash() {
        return smallCash;
    }

    /**
     * @param aSmallCash the smallCash to set
     */
    public static void setSmallCash(BigDecimal aSmallCash) {
        smallCash = aSmallCash;
    }

    /**
     * @return the valuepayment
     */
    public static double getValuepayment() {
        return valuepayment;
    }

    /**
     * @param aValuepayment the valuepayment to set
     */
    public static void setValuepayment(double aValuepayment) {
        valuepayment = aValuepayment;
    }

    /**
     * @return the discoutPayment
     */
    public static double getDiscoutPayment() {
        return discoutPayment;
    }

    /**
     * @param aDiscoutPayment the discoutPayment to set
     */
    public static void setDiscoutPayment(double aDiscoutPayment) {
        discoutPayment = aDiscoutPayment;
    }

   
}
