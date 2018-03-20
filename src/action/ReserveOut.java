/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author root
 */
public class ReserveOut {

    
    private String idReserveOut;
    private String descriptionProductReserveOut;
    private String barCodeProductReserveOut;
    private String dateRegisterReserveOut;
    private double quantityRemoveReserveOut;
    private String lotProductReserveOut;
    private String observationReserveOut;
    private double quantityActualReserveOut;
    private Object descriptionReserveOut;
    private static Object bean;
    
    
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
     * @return the idReserveOut
     */
    public String getIdReserveOut() {
        return idReserveOut;
    }

    /**
     * @param idReserveOut the idReserveOut to set
     */
    public void setIdReserveOut(String idReserveOut) {
        java.lang.String oldIdReserveOut = this.idReserveOut;
        this.idReserveOut = idReserveOut;
        changeSupport.firePropertyChange("idReserveOut", oldIdReserveOut, idReserveOut);
    }

    /**
     * @return the descriptionProductReserveOut
     */
    public String getDescriptionProductReserveOut() {
        return descriptionProductReserveOut;
    }

    /**
     * @param descriptionProductReserveOut the descriptionProductReserveOut to set
     */
    public void setDescriptionProductReserveOut(String descriptionProductReserveOut) {
        java.lang.String oldDescriptionProductReserveOut = this.descriptionProductReserveOut;
        this.descriptionProductReserveOut = descriptionProductReserveOut;
        changeSupport.firePropertyChange("descriptionProductReserveOut", oldDescriptionProductReserveOut, descriptionProductReserveOut);
    }

    /**
     * @return the barCodeProductReserveOut
     */
    public String getBarCodeProductReserveOut() {
        return barCodeProductReserveOut;
    }

    /**
     * @param barCodeProductReserveOut the barCodeProductReserveOut to set
     */
    public void setBarCodeProductReserveOut(String barCodeProductReserveOut) {
        java.lang.String oldBarCodeProductReserveOut = this.barCodeProductReserveOut;
        this.barCodeProductReserveOut = barCodeProductReserveOut;
        changeSupport.firePropertyChange("barCodeProductReserveOut", oldBarCodeProductReserveOut, barCodeProductReserveOut);
    }

    /**
     * @return the dateRegisterReserveOut
     */
    public String getDateRegisterReserveOut() {
        return dateRegisterReserveOut;
    }

    /**
     * @param dateRegisterReserveOut the dateRegisterReserveOut to set
     */
    public void setDateRegisterReserveOut(String dateRegisterReserveOut) {
        java.lang.String oldDateRegisterReserveOut = this.dateRegisterReserveOut;
        this.dateRegisterReserveOut = dateRegisterReserveOut;
        changeSupport.firePropertyChange("dateRegisterReserveOut", oldDateRegisterReserveOut, dateRegisterReserveOut);
    }

    /**
     * @return the quantityRemoveReserveOut
     */
    public double getQuantityRemoveReserveOut() {
        return quantityRemoveReserveOut;
    }

    /**
     * @param quantityRemoveReserveOut the quantityRemoveReserveOut to set
     */
    public void setQuantityRemoveReserveOut(double quantityRemoveReserveOut) {
        double oldQuantityRemoveReserveOut = this.quantityRemoveReserveOut;
        this.quantityRemoveReserveOut = quantityRemoveReserveOut;
        changeSupport.firePropertyChange("quantityRemoveReserveOut", oldQuantityRemoveReserveOut, quantityRemoveReserveOut);
    }

    /**
     * @return the lotProductReserveOut
     */
    public String getLotProductReserveOut() {
        return lotProductReserveOut;
    }

    /**
     * @param lotProductReserveOut the lotProductReserveOut to set
     */
    public void setLotProductReserveOut(String lotProductReserveOut) {
        java.lang.String oldLotProductReserveOut = this.lotProductReserveOut;
        this.lotProductReserveOut = lotProductReserveOut;
        changeSupport.firePropertyChange("lotProductReserveOut", oldLotProductReserveOut, lotProductReserveOut);
    }

    /**
     * @return the observationReserveOut
     */
    public String getObservationReserveOut() {
        return observationReserveOut;
    }

    /**
     * @param observationReserveOut the observationReserveOut to set
     */
    public void setObservationReserveOut(String observationReserveOut) {
        java.lang.String oldObservationReserveOut = this.observationReserveOut;
        this.observationReserveOut = observationReserveOut;
        changeSupport.firePropertyChange("observationReserveOut", oldObservationReserveOut, observationReserveOut);
    }

    /**
     * @return the quantityActualReserveOut
     */
    public double getQuantityActualReserveOut() {
        return quantityActualReserveOut;
    }

    /**
     * @param quantityActualReserveOut the quantityActualReserveOut to set
     */
    public void setQuantityActualReserveOut(double quantityActualReserveOut) {
        double oldQuantityActualReserveOut = this.quantityActualReserveOut;
        this.quantityActualReserveOut = quantityActualReserveOut;
        changeSupport.firePropertyChange("quantityActualReserveOut", oldQuantityActualReserveOut, quantityActualReserveOut);
    }

    /**
     * @return the descriptionReserveOut
     */
    public Object getDescriptionReserveOut() {
        return descriptionReserveOut;
    }

    /**
     * @param descriptionReserveOut the descriptionReserveOut to set
     */
    public void setDescriptionReserveOut(Object descriptionReserveOut) {
        Object oldDescriptionReserveOut = this.descriptionReserveOut;
        this.descriptionReserveOut = descriptionReserveOut;
        changeSupport.firePropertyChange("descriptionReserveOut", oldDescriptionReserveOut, descriptionReserveOut);
    }
    
        /**
     * @return the bean
     */
    public static Object getBean() {
        return bean;
    }

    /**
     * @param bean the bean to set
     */
    public static void setBean(Object bean) {
        ReserveOut.bean = bean;
    }
    
   
    
}
