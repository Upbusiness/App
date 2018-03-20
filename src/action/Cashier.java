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
public class Cashier {


    private String code_user_start_cashier;
    private String code_user_end_cashier;
    private String name_user_start_cashier;
    private String name_user_end_cashier;

    private String date_open_cashier;
    private String hour_open_cashier;
    private String date_close_cashier;
    private String hour_close_cashier;

    private double value_started_cashier;
    private double value_end_cashier;
    private double value_sales_cash;
    private double value_sales_card;
    private double value_discount_cash;
    private double value_discount_card;
    private int quantyti_sales_cash;
    private int quantyti_sales_card;
    private int quantyti_discount_cash;
    private int quantyti_discount_card;

    private double value_removed_cashier;
    private double value_add_cashier;
    private double value_remainder_cashier;
    private boolean isClose;
    private int turn_cashier;
    private String terminal_cashier;
    private String idCashier;

    // <editor-fold defaultstate="collapsed" desc="PropertyChange Stuff">
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        getChangeSupport().addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        getChangeSupport().removePropertyChangeListener(listener);
    }
    // </editor-fold>

     // <editor-fold defaultstate="collapsed" desc="Get Methods">
    /**
     * @return the code_user_start_cashier
     */
    public String getCode_user_start_cashier() {
        return code_user_start_cashier;
    }

    /**
     * @return the code_user_end_cashier
     */
    public String getCode_user_end_cashier() {
        return code_user_end_cashier;
    }

    /**
     * @return the name_user_start_cashier
     */
    public String getName_user_start_cashier() {
        return name_user_start_cashier;
    }

    /**
     * @return the name_user_end_cashier
     */
    public String getName_user_end_cashier() {
        return name_user_end_cashier;
    }

    /**
     * @return the date_open_cashier
     */
    public String getDate_open_cashier() {
        return date_open_cashier;
    }

    /**
     * @return the hour_open_cashier
     */
    public String getHour_open_cashier() {
        return hour_open_cashier;
    }

    /**
     * @return the date_close_cashier
     */
    public String getDate_close_cashier() {
        return date_close_cashier;
    }

    /**
     * @return the hour_close_cashier
     */
    public String getHour_close_cashier() {
        return hour_close_cashier;
    }

    /**
     * @return the value_started_cashier
     */
    public double getValue_started_cashier() {
        return value_started_cashier;
    }

    /**
     * @return the value_end_cashier
     */
    public double getValue_end_cashier() {
        return value_end_cashier;
    }

    /**
     * @return the value_sales_cash
     */
    public double getValue_sales_cash() {
        return value_sales_cash;
    }

    /**
     * @return the value_sales_card
     */
    public double getValue_sales_card() {
        return value_sales_card;
    }

    /**
     * @return the quantyti_sales_cash
     */
    public int getQuantyti_sales_cash() {
        return quantyti_sales_cash;
    }

    /**
     * @return the quantyti_sales_card
     */
    public int getQuantyti_sales_card() {
        return quantyti_sales_card;
    }

    /**
     * @return the value_removed_cashier
     */
    public double getValue_removed_cashier() {
        return value_removed_cashier;
    }

    /**
     * @return the value_add_cashier
     */
    public double getValue_add_cashier() {
        return value_add_cashier;
    }

    /**
     * @return the isClose
     */
    public boolean isIsClose() {
        return isClose;
    }

    /**
     * @return the turn_cashier
     */
    public int getTurn_cashier() {
        return turn_cashier;
    }

    /**
     * @return the changeSupport
     */
    public PropertyChangeSupport getChangeSupport() {
        return changeSupport;
    }

    /**
     * @return the value_remainder_cashier
     */
    public double getValue_remainder_cashier() {
        return value_remainder_cashier;
    }

    /**
     * @return the terminal_cashier
     */
    public String getTerminal_cashier() {
        return terminal_cashier;
    }

    /**
     * @return the idCashier
     */
    public String getIdCashier() {
        return idCashier;
    }

    /**
     * @return the value_discount_card
     */
    public double getValue_discount_card() {
        return value_discount_card;
    }

    /**
     * @return the quantyti_discount_card
     */
    public int getQuantyti_discount_card() {
        return quantyti_discount_card;
    }
    
    /**
     * @return the value_discount_cash
     */
    public double getValue_discount_cash() {
        return value_discount_cash;
    }

    /**
     * @return the quantyti_discount_cash
     */
    public int getQuantyti_discount_cash() {
        return quantyti_discount_cash;
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Set Methods">
    /**
     * @param code_user_start_cashier the code_user_start_cashier to set
     */
    public void setCode_user_start_cashier(String code_user_start_cashier) {
        Object oldCode_user_start_cashier = this.code_user_start_cashier;
        this.code_user_start_cashier = code_user_start_cashier;
        changeSupport.firePropertyChange("code_user_start_cashier", oldCode_user_start_cashier, code_user_start_cashier);
    }

    /**
     * @param code_user_end_cashier the code_user_end_cashier to set
     */
    public void setCode_user_end_cashier(String code_user_end_cashier) {
        this.code_user_end_cashier = code_user_end_cashier;
    }

    /**
     * @param name_user_start_cashier the name_user_start_cashier to set
     */
    public void setName_user_start_cashier(String name_user_start_cashier) {
        String oldName_user_start_cashier = this.name_user_start_cashier;
        this.name_user_start_cashier = name_user_start_cashier;
        changeSupport.firePropertyChange("name_user_start_cashier", oldName_user_start_cashier, name_user_start_cashier);
    }

    /**
     * @param name_user_end_cashier the name_user_end_cashier to set
     */
    public void setName_user_end_cashier(String name_user_end_cashier) {
        String oldName_user_end_cashier = this.name_user_end_cashier;
        this.name_user_end_cashier = name_user_end_cashier;
        changeSupport.firePropertyChange("name_user_end_cashier", oldName_user_end_cashier, name_user_end_cashier);
    }

    /**
     * @param date_open_cashier the date_open_cashier to set
     */
    public void setDate_open_cashier(String date_open_cashier) {
        this.date_open_cashier = date_open_cashier;
    }

    /**
     * @param hour_open_cashier the hour_open_cashier to set
     */
    public void setHour_open_cashier(String hour_open_cashier) {
        this.hour_open_cashier = hour_open_cashier;
    }

    /**
     * @param date_close_cashier the date_close_cashier to set
     */
    public void setDate_close_cashier(String date_close_cashier) {
        this.date_close_cashier = date_close_cashier;
    }

    /**
     * @param hour_close_cashier the hour_close_cashier to set
     */
    public void setHour_close_cashier(String hour_close_cashier) {
        this.hour_close_cashier = hour_close_cashier;
    }

    /**
     * @param value_started_cashier the value_started_cashier to set
     */
    public void setValue_started_cashier(double value_started_cashier) {
        this.value_started_cashier = value_started_cashier;
    }

    /**
     * @param value_end_cashier the value_end_cashier to set
     */
    public void setValue_end_cashier(double value_end_cashier) {
        this.value_end_cashier = value_end_cashier;
    }

    /**
     * @param value_sales_cash the value_sales_cash to set
     */
    public void setValue_sales_cash(double value_sales_cash) {
        double oldValue_sales_cash = this.value_sales_cash;
        this.value_sales_cash = value_sales_cash;
        changeSupport.firePropertyChange("value_sales_cash", oldValue_sales_cash, value_sales_cash);
    }

    /**
     * @param value_sales_card the value_sales_card to set
     */
    public void setValue_sales_card(double value_sales_card) {
        double oldValue_sales_card = this.value_sales_card;
        this.value_sales_card = value_sales_card;
        changeSupport.firePropertyChange("value_sales_card", oldValue_sales_card, value_sales_card);
    }

    /**
     * @param value_discount_card
     */
    public void setValue_discount_card(double value_discount_card) {
        double oldValue_discount = this.getValue_discount_card();
        this.value_discount_card = value_discount_card;
        changeSupport.firePropertyChange("value_discount", oldValue_discount, value_discount_card);
    }

    /**
     * @param quantyti_sales_cash the quantyti_sales_cash to set
     */
    public void setQuantyti_sales_cash(int quantyti_sales_cash) {
        int oldQuantyti_sales_cash = this.quantyti_sales_cash;
        this.quantyti_sales_cash = quantyti_sales_cash;
        changeSupport.firePropertyChange("quantyti_sales_cash", oldQuantyti_sales_cash, quantyti_sales_cash);
    }

    /**
     * @param quantyti_sales_card the quantyti_sales_card to set
     */
    public void setQuantyti_sales_card(int quantyti_sales_card) {
        int oldQuantyti_sales_card = this.quantyti_sales_card;
        this.quantyti_sales_card = quantyti_sales_card;
        changeSupport.firePropertyChange("quantyti_sales_card", oldQuantyti_sales_card, quantyti_sales_card);
    }

    /**
     * @param value_removed_cashier the value_removed_cashier to set
     */
    public void setValue_removed_cashier(double value_removed_cashier) {
        this.value_removed_cashier = value_removed_cashier;
    }

    /**
     * @param value_add_cashier the value_add_cashier to set
     */
    public void setValue_add_cashier(double value_add_cashier) {
        this.value_add_cashier = value_add_cashier;
    }

    /**
     * @param isClose the isClose to set
     */
    public void setIsClose(boolean isClose) {
        this.isClose = isClose;
    }

    /**
     * @param turn_cashier the turn_cashier to set
     */
    public void setTurn_cashier(int turn_cashier) {
        this.turn_cashier = turn_cashier;
    }

    /**
     * @param changeSupport the changeSupport to set
     */
    public void setChangeSupport(PropertyChangeSupport changeSupport) {
        this.changeSupport = changeSupport;
    }

    /**
     * @param value_remainder_cashier the value_remainder_cashier to set
     */
    public void setValue_remainder_cashier(double value_remainder_cashier) {
        this.value_remainder_cashier = value_remainder_cashier;
    }

    /**
     * @param terminal_cashier the terminal_cashier to set
     */
    public void setTerminal_cashier(String terminal_cashier) {
        this.terminal_cashier = terminal_cashier;
    }

    /**
     * @param idCashier the idCashier to set
     */
    public void setIdCashier(String idCashier) {
        this.idCashier = idCashier;
    }

    /**
     * @param quantyti_discount_card the quantyti_discount_card to set
     */
    public void setQuantyti_discount_card(int quantyti_discount_card) {
        this.quantyti_discount_card = quantyti_discount_card;
        //changeSupport.firePropertyChange("quantyti_discount_card", oldQuantyti_discount, quantyti_discount_card);
    }

    /**
     * @param value_discount_cash the value_discount_cash to set
     */
    public void setValue_discount_cash(double value_discount_cash) {
        double oldValue_discount_cash = this.value_discount_cash;
        this.value_discount_cash = value_discount_cash;
        changeSupport.firePropertyChange("value_discount_cash", oldValue_discount_cash, value_discount_cash);
    }

    /**
     * @param quantyti_discount_cash the quantyti_discount_cash to set
     */
    public void setQuantyti_discount_cash(int quantyti_discount_cash) {
        int oldQuantyti_discount_cash = this.quantyti_discount_cash;
        this.quantyti_discount_cash = quantyti_discount_cash;
        changeSupport.firePropertyChange("quantyti_discount_cash", oldQuantyti_discount_cash, quantyti_discount_cash);
    }

}// </editor-fold>

