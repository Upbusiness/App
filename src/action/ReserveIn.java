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
 * @author Rafael Recalcatti
 */
public class ReserveIn {
    
    
    private String idReserveIn;
    private String descriptionProductReserveIn;
    private String barCodeProductReserveIn;
    private String dateRegister;
    private double quantityInsertReserveIn;
    private double quantityRemainderReserveIn;
    private double valueCoastProductReserveIn;
    private String lotProductReserveIn;
    private String dateProductionProductReserveIn;
    private String dateExpiringProductReserveIn;
    private int monthsForExipiringProductReserveIn;
    private int pack;
    private static Object bean;
    private boolean controlExpiring;
    
    
    
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
     * @return the idReserveIn
     */
    public String getIdReserveIn() {
        return idReserveIn;
    }

    /**
     * @return the descriptionProductReserveIn
     */
    public String getDescriptionProductReserveIn() {
        return descriptionProductReserveIn;
    }

    /**
     * @return the barCodeProductReserveIn
     */
    public String getBarCodeProductReserveIn() {
        return barCodeProductReserveIn;
    }

    /**
     * @return the dateRegister
     */
    public String getDateRegister() {
        return dateRegister;
    }

    /**
     * @return the quantityInsertReserveIn
     */
    public double getQuantityInsertReserveIn() {
        return quantityInsertReserveIn;
    }

    /**
     * @return the quantityRemainderReserveIn
     */
    public double getQuantityRemainderReserveIn() {
        return quantityRemainderReserveIn;
    }

    /**
     * @return the valueCoastProductReserveIn
     */
    public double getValueCoastProductReserveIn() {
        return valueCoastProductReserveIn;
    }

    /**
     * @return the lotProductReserveIn
     */
    public String getLotProductReserveIn() {
        return lotProductReserveIn;
    }

    /**
     * @return the dateProductionProductReserveIn
     */
    public String getDateProductionProductReserveIn() {
        return dateProductionProductReserveIn;
    }

    /**
     * @return the dateExpiringProductReserveIn
     */
    public String getDateExpiringProductReserveIn() {
        return dateExpiringProductReserveIn;
    }

    /**
     * @return the monthsForExipiringProductReserveIn
     */
    public int getMonthsForExipiringProductReserveIn() {
        return monthsForExipiringProductReserveIn;
    }

     /**
     * @return the pack
     */
    public int getPack() {
        return pack;
    }
    /**
     * @param idReserveIn the idReserveIn to set
     */
    public void setIdReserveIn(String idReserveIn) {
        String oldIdReserveIn = this.idReserveIn;
        this.idReserveIn = idReserveIn;
        changeSupport.firePropertyChange("idReserveIn", oldIdReserveIn, idReserveIn);
    }

    /**
     * @param descriptionProductReserveIn the descriptionProductReserveIn to set
     */
    public void setDescriptionProductReserveIn(String descriptionProductReserveIn) {
        String oldDescriptionProductReserveIn = this.descriptionProductReserveIn;
        this.descriptionProductReserveIn = descriptionProductReserveIn;
        changeSupport.firePropertyChange("descriptionProductReserveIn", oldDescriptionProductReserveIn, descriptionProductReserveIn);
    }

    /**
     * @param barCodeProductReserveIn the barCodeProductReserveIn to set
     */
    public void setBarCodeProductReserveIn(String barCodeProductReserveIn) {
        String oldBarCodeProductReserveIn = this.barCodeProductReserveIn;
        this.barCodeProductReserveIn = barCodeProductReserveIn;
        changeSupport.firePropertyChange("barCodeProductReserveIn", oldBarCodeProductReserveIn, barCodeProductReserveIn);
    }

    /**
     * @param dateRegister the dateRegister to set
     */
    public void setDateRegister(String dateRegister) {
        String oldDateRegister = this.dateRegister;
        this.dateRegister = dateRegister;
        changeSupport.firePropertyChange("dateRegister", oldDateRegister, dateRegister);
    }

    /**
     * @param quantityInsertReserveIn the quantityInsertReserveIn to set
     */
    public void setQuantityInsertReserveIn(double quantityInsertReserveIn) {
        double oldQuantityInsertReserveIn = this.quantityInsertReserveIn;
        this.quantityInsertReserveIn = quantityInsertReserveIn;
        changeSupport.firePropertyChange("quantityInsertReserveIn", oldQuantityInsertReserveIn, quantityInsertReserveIn);
    }

    /**
     * @param quantityRemainderReserveIn the quantityRemainderReserveIn to set
     */
    public void setQuantityRemainderReserveIn(double quantityRemainderReserveIn) {
        double oldQuantityRemainderReserveIn = this.quantityRemainderReserveIn;
        this.quantityRemainderReserveIn = quantityRemainderReserveIn;
        changeSupport.firePropertyChange("quantityRemainderReserveIn", oldQuantityRemainderReserveIn, quantityRemainderReserveIn);
    }

    /**
     * @param valueCoastProductReserveIn the valueCoastProductReserveIn to set
     */
    public void setValueCoastProductReserveIn(double valueCoastProductReserveIn) {
        double oldValueCoastProductReserveIn = this.valueCoastProductReserveIn;
        this.valueCoastProductReserveIn = valueCoastProductReserveIn;
        changeSupport.firePropertyChange("valueCoastProductReserveIn", oldValueCoastProductReserveIn, valueCoastProductReserveIn);
    }

    /**
     * @param lotProductReserveIn the lotProductReserveIn to set
     */
    public void setLotProductReserveIn(String lotProductReserveIn) {
        String oldLotProductReserveIn = this.lotProductReserveIn;
        this.lotProductReserveIn = lotProductReserveIn;
        changeSupport.firePropertyChange("lotProductReserveIn", oldLotProductReserveIn, lotProductReserveIn);
    }

    /**
     * @param dateProductionProductReserveIn the dateProductionProductReserveIn to set
     */
    public void setDateProductionProductReserveIn(String dateProductionProductReserveIn) {
        String oldDateProductionProductReserveIn = this.dateProductionProductReserveIn;
        this.dateProductionProductReserveIn = dateProductionProductReserveIn;
        changeSupport.firePropertyChange("dateProductionProductReserveIn", oldDateProductionProductReserveIn, dateProductionProductReserveIn);
    }

    /**
     * @param dateExpiringProductReserveIn the dateExpiringProductReserveIn to set
     */
    public void setDateExpiringProductReserveIn(String dateExpiringProductReserveIn) {
        java.lang.String oldDateExpiringProductReserveIn = this.dateExpiringProductReserveIn;
        this.dateExpiringProductReserveIn = dateExpiringProductReserveIn;
        changeSupport.firePropertyChange("dateExpiringProductReserveIn", oldDateExpiringProductReserveIn, dateExpiringProductReserveIn);
    }

    /**
     * @param monthsForExipiringProductReserveIn the monthsForExipiringProductReserveIn to set
     */
    public void setMonthsForExipiringProductReserveIn(int monthsForExipiringProductReserveIn) {
        int oldMonthsForExipiringProductReserveIn = this.monthsForExipiringProductReserveIn;
        this.monthsForExipiringProductReserveIn = monthsForExipiringProductReserveIn;
        changeSupport.firePropertyChange("monthsForExipiringProductReserveIn", oldMonthsForExipiringProductReserveIn, monthsForExipiringProductReserveIn);
    }
    
     /**
     * @param pack
     */
    public void setPack(int pack) {
        int oldPack = this.pack;
        this.pack = pack;
        changeSupport.firePropertyChange("pack", oldPack, pack);
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
        ReserveIn.bean = bean;
    }

    /**
     * @return the controlExpiring
     */
    public boolean isControlExpiring() {
        return controlExpiring;
    }

    /**
     * @param controlExpiring the controlExpiring to set
     */
    public void setControlExpiring(boolean controlExpiring) {
        boolean oldControlExpiring = this.controlExpiring;
        this.controlExpiring = controlExpiring;
        changeSupport.firePropertyChange("controlExpiring", oldControlExpiring, controlExpiring);
    }
    
   }
