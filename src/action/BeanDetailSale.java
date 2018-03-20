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
public class BeanDetailSale {
    
    private  String codeSale;
    private  String dateHourSale;
    private  int terminal;
    private  boolean isCanceled;
    private  boolean isClosed;
    private  String user;
    private  double discount;
    private  double total;

    /**
     * @return the user
     */
    public  String getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public  void setUser(String aUser) {
        user = aUser;
    }

    /**
     * @return the codeSale
     */
    public  String getCodeSale() {
        return codeSale;
    }

    /**
     * @param aCodeSale the codeSale to set
     */
    public  void setCodeSale(String aCodeSale) {
        codeSale = aCodeSale;
    }

    /**
     * @return the dateHourSale
     */
    public  String getDateHourSale() {
        return dateHourSale;
    }

    /**
     * @param aDateHourSale the dateHourSale to set
     */
    public  void setDateHourSale(String aDateHourSale) {
        dateHourSale = aDateHourSale;
    }

    /**
     * @return the terminal
     */
    public  int getTerminal() {
        return terminal;
    }

    /**
     * @param aTerminal the terminal to set
     */
    public  void setTerminal(int aTerminal) {
        terminal = aTerminal;
    }

    /**
     * @return the isCanceled
     */
    public  boolean isIsCanceled() {
        return isCanceled;
    }

    /**
     * @param aIsCanceled the isCanceled to set
     */
    public  void setIsCanceled(boolean aIsCanceled) {
        isCanceled = aIsCanceled;
    }

    /**
     * @return the isClosed
     */
    public  boolean isIsClosed() {
        return isClosed;
    }

    /**
     * @param aIsClosed the isClosed to set
     */
    public  void setIsClosed(boolean aIsClosed) {
        isClosed = aIsClosed;
    }

    /**
     * @return the discount
     */
    public  double getDiscount() {
        return discount;
    }

    /**
     * @param aDiscount the discount to set
     */
    public  void setDiscount(double aDiscount) {
        discount = aDiscount;
    }

    /**
     * @return the total
     */
    public  double getTotal() {
        return total;
    }

    /**
     * @param aTotal the total to set
     */
    public  void setTotal(double aTotal) {
        total = aTotal;
    }

  
    
}
