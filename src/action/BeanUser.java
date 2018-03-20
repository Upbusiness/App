
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package action;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Rafael Recalcatti
 */
public class BeanUser {

    
    private String  user;
    private String  password;
    private boolean isAccessRestrict;
    private boolean isReportAccess;
    private boolean isCoastOperationAccess ;
    private boolean isCancelAccess ;
    private boolean isCashierAccess;
    private boolean isSaleAccess;
    private boolean isRegisterProductsAccess ;
    private boolean isControlReserveAccess ;
    private boolean isRegisterUserAccess;
    private boolean isRegisterCategoryAccess;
    private boolean isRegisterCardAccess;
    private boolean isConfigRates;

        // <editor-fold defaultstate="collapsed" desc="PropertyChange Stuff">
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    // </editor-fold>
    
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public void setUser(String user) {
        java.lang.String oldUser = this.user;
        this.user = user;                  
        changeSupport.firePropertyChange("user", oldUser, user);
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isAccessRestrict
     */
    public boolean isIsAccessRestrict() {
        return isAccessRestrict;
    }

    /**
     * @param isAccessRestrict the isAccessRestrict to set
     */
    public void setIsAccessRestrict(boolean isAccessRestrict) {
        boolean OldIsAccessRestrict = this.isAccessRestrict;
        this.isAccessRestrict = isAccessRestrict;                  
        changeSupport.firePropertyChange("isActiveProduct", OldIsAccessRestrict, isAccessRestrict);
    }

    /**
     * @return the isReportAccess
     */
    public boolean isIsReportAccess() {
        return isReportAccess;
    }

    /**
     * @param isReportAccess the isReportAccess to set
     */
    public void setIsReportAccess(boolean isReportAccess) {
        this.isReportAccess = isReportAccess;
    }

    /**
     * @return the isCoastOperationAccess
     */
    public boolean isIsCoastOperationAccess() {
        return isCoastOperationAccess;
    }

    /**
     * @param isCoastOperationAccess the isCoastOperationAccess to set
     */
    public void setIsCoastOperationAccess(boolean isCoastOperationAccess) {
        this.isCoastOperationAccess = isCoastOperationAccess;
    }

    /**
     * @return the isCancelAccess
     */
    public boolean isIsCancelAccess() {
        return isCancelAccess;
    }

    /**
     * @param isCancelAccess the isCancelAccess to set
     */
    public void setIsCancelAccess(boolean isCancelAccess) {
        this.isCancelAccess = isCancelAccess;
    }

    /**
     * @return the isCashierAccess
     */
    public boolean isIsCashierAccess() {
        return isCashierAccess;
    }

    /**
     * @param isCashierAccess the isCashierAccess to set
     */
    public void setIsCashierAccess(boolean isCashierAccess) {
        this.isCashierAccess = isCashierAccess;
    }

    /**
     * @return the isSaleAccess
     */
    public boolean isIsSaleAccess() {
        return isSaleAccess;
    }

    /**
     * @param isSaleAccess the isSaleAccess to set
     */
    public void setIsSaleAccess(boolean isSaleAccess) {
        this.isSaleAccess = isSaleAccess;
    }

    /**
     * @return the isRegisterProductsAccess
     */
    public boolean isIsRegisterProductsAccess() {
        return isRegisterProductsAccess;
    }

    /**
     * @param isRegisterProductsAccess the isRegisterProductsAccess to set
     */
    public void setIsRegisterProductsAccess(boolean isRegisterProductsAccess) {
        this.isRegisterProductsAccess = isRegisterProductsAccess;
    }

    /**
     * @return the isControlReserveAccess
     */
    public boolean isIsControlReserveAccess() {
        return isControlReserveAccess;
    }

    /**
     * @param isControlReserveAccess the isControlReserveAccess to set
     */
    public void setIsControlReserveAccess(boolean isControlReserveAccess) {
        this.isControlReserveAccess = isControlReserveAccess;
    }

    /**
     * @return the isRegisterUserAccess
     */
    public boolean isIsRegisterUserAccess() {
        return isRegisterUserAccess;
    }

    /**
     * @param isRegisterUserAccess the isRegisterUserAccess to set
     */
    public void setIsRegisterUserAccess(boolean isRegisterUserAccess) {
        this.isRegisterUserAccess = isRegisterUserAccess;
    }

    /**
     * @return the isRegisterCategoryAccess
     */
    public boolean isIsRegisterCategoryAccess() {
        return isRegisterCategoryAccess;
    }

    /**
     * @param isRegisterCategoryAccess the isRegisterCategoryAccess to set
     */
    public void setIsRegisterCategoryAccess(boolean isRegisterCategoryAccess) {
        this.isRegisterCategoryAccess = isRegisterCategoryAccess;
    }

    /**
     * @return the isRegisterCardAccess
     */
    public boolean isIsRegisterCardAccess() {
        return isRegisterCardAccess;
    }

    /**
     * @param isRegisterCardAccess the isRegisterCardAccess to set
     */
    public void setIsRegisterCardAccess(boolean isRegisterCardAccess) {
        this.isRegisterCardAccess = isRegisterCardAccess;
    }

    /**
     * @return the isConfigRates
     */
    public boolean isIsConfigRates() {
        return isConfigRates;
    }

    /**
     * @param isConfigRates the isConfigRates to set
     */
    public void setIsConfigRates(boolean isConfigRates) {
        this.isConfigRates = isConfigRates;
    }
 
}