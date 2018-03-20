package action;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;

/**
 * Information about one clinet.
 *
 * @author Rafiusks
 */
public class Invoice {

    //header nota
    private int filialInvoice;
    private int seriesInvoive;
    private int numberInvoive;
    private String dateEntryInvoice;
    private String dateEmissionInvoice;
    private String idInvoice;
    private String vendorInvoice;
    private int cfopInvoice;
    private BigDecimal baseIcmsInvoice;
    private BigDecimal totalIcmsInvoice;
    private BigDecimal valueDutyInvoice;
    private BigDecimal valueOthersInvoice;
    private BigDecimal valueSubstInvoice;
    private BigDecimal valueTotalInvoice;
    private String valueAllProductsInvoice;
    private String transporter;
    private String observationInvoice;
    //body nota
    private double valueProductInvoice;
    private double quantityProductInvoice;
    private String descriptionProductInvoice;
    private double codProductInvoice;
    private String codBarProductInvoice;
    private String observationProductInvoice;
    
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
     * @return the filialInvoive
     */
    public int getFilialInvoice() {
        return filialInvoice;
    }

    /**
     * @param filialInvoice
     */
    public void setFilialInvoice(int filialInvoice) {
        int oldFilialInvoice = this.filialInvoice;
        this.filialInvoice = filialInvoice;
        changeSupport.firePropertyChange("filialInvoive", oldFilialInvoice, filialInvoice);

    }

    /**
     * @return the seriesInvoive
     */
    public int getSeriesInvoive() {
        return seriesInvoive;
    }

    /**
     * @param seriesInvoive
     */
    public void setSeriesInvoive(int seriesInvoive) {
        int oldSeriesInvoive = this.seriesInvoive;
        this.seriesInvoive = seriesInvoive;
        changeSupport.firePropertyChange("seriesInvoive", oldSeriesInvoive, seriesInvoive);
    }

    /**
     * @return the numberInvoive
     */
    public int getNumberInvoice() {
        return numberInvoive;
    }

    /**
     * @param numberInvoive
     */
    public void setNumberInvoice(int numberInvoive) {
        int oldNumberInvoice = this.numberInvoive;
        this.numberInvoive = numberInvoive;
        changeSupport.firePropertyChange("numberInvoive", oldNumberInvoice, numberInvoive);
    }

    /**
     * @return the dateEntryInvoice
     */
    public String getDateEntryInvoice() {
        return dateEntryInvoice;
    }

    /**
     * @param dateEntryInvoice
     */
    public void setDateEntryInvoice(String dateEntryInvoice) {
        String oldDateEntryInvoice = this.dateEntryInvoice;
        this.dateEntryInvoice = dateEntryInvoice;
        changeSupport.firePropertyChange("dateEntryInvoice", oldDateEntryInvoice, dateEntryInvoice);
    }

    /**
     * @return the dateEmissionInvoice
     */
    public String getDateEmissionInvoice() {
        return dateEmissionInvoice;
    }

    /**
     * @param dateEmissionInvoice
     */
    public void setDateEmissionInvoice(String dateEmissionInvoice) {
        String oldDateEmissionInvoice = this.dateEmissionInvoice;
        this.dateEmissionInvoice = dateEmissionInvoice;
        changeSupport.firePropertyChange("dateEmissionInvoice", oldDateEmissionInvoice, dateEmissionInvoice);
    }

    /**
     * @return the idInvoice
     */
    public String getIdInvoice() {
        return idInvoice;
    }

    /**
     * @param idInvoice the idInvoice to set
     */
    public void setIdInvoice(String idInvoice) {
        String oldIdInvoice = this.idInvoice;
        this.idInvoice = idInvoice;
        changeSupport.firePropertyChange("idInvoice", oldIdInvoice, idInvoice);
    }

    /**
     * @return the vendorInvoice
     */
    public String getVendorInvoice() {
        return vendorInvoice;
    }

    /**
     * @param vendorInvoice the vendorInvoice to set
     */
    public void setVendorInvoice(String vendorInvoice) {
        String oldVendorInvoice = this.vendorInvoice;
        this.vendorInvoice = vendorInvoice;
        changeSupport.firePropertyChange("vendorInvoice", oldVendorInvoice, vendorInvoice);
    }

    /**
     * @return the cfopInvoice
     */
    public int getCfopInvoice() {
        return cfopInvoice;
    }

    /**
     * @param cfopInvoice the cfopInvoice to set
     */
    public void setCfopInvoice(int cfopInvoice) {
        int oldCfopInvoice = this.cfopInvoice;
        this.cfopInvoice = cfopInvoice;
        changeSupport.firePropertyChange("cfopInvoice", oldCfopInvoice, cfopInvoice);
    }

    /**
     * @return the baseIcmsInvoice
     */
    public BigDecimal getBaseIcmsInvoice() {
        return baseIcmsInvoice;
    }

    /**
     * @param baseIcmsInvoice the baseIcmsInvoice to set
     */
    public void setBaseIcmsInvoice(BigDecimal baseIcmsInvoice) {
        BigDecimal oldBaseIcmsInvoice = this.baseIcmsInvoice;
        this.baseIcmsInvoice = baseIcmsInvoice;
        changeSupport.firePropertyChange("baseIcmsInvoice", oldBaseIcmsInvoice, baseIcmsInvoice);
    }

    /**
     * @return the totalIcmsInvoice
     */
    public BigDecimal getTotalIcmsInvoice() {
        return totalIcmsInvoice;
    }

    /**
     * @param totalIcmsInvoice the totalIcmsInvoice to set
     */
    public void setTotalIcmsInvoice(BigDecimal totalIcmsInvoice) {
        BigDecimal oldTotalIcmsInvoice = this.totalIcmsInvoice;
        this.totalIcmsInvoice = totalIcmsInvoice;
        changeSupport.firePropertyChange("totalIcmsInvoice", oldTotalIcmsInvoice, totalIcmsInvoice);
    }

    /**
     * @return the valueDutyInvoice
     */
    public BigDecimal getValueDutyInvoice() {
        return valueDutyInvoice;
    }

    /**
     * @param valueDutyInvoice the valueDutyInvoice to set
     */
    public void setValueDutyInvoice(BigDecimal valueDutyInvoice) {
        BigDecimal oldValueDutyInvoice = this.valueDutyInvoice;
        this.valueDutyInvoice = valueDutyInvoice;
        changeSupport.firePropertyChange("valueDutyInvoice", oldValueDutyInvoice, valueDutyInvoice);
    }

    /**
     * @return the valueOthersInvoice
     */
    public BigDecimal getValueOthersInvoice() {
        return valueOthersInvoice;
    }

    /**
     * @param valueOthersInvoice the valueOthersInvoice to set
     */
    public void setValueOthersInvoice(BigDecimal valueOthersInvoice) {
        BigDecimal oldValueOthersInvoice = this.valueOthersInvoice;
        this.valueOthersInvoice = valueOthersInvoice;
        changeSupport.firePropertyChange("valueOthersInvoice", oldValueOthersInvoice, valueOthersInvoice);
    }

    /**
     * @return the valueSubstInvoice
     */
    public BigDecimal getValueSubstInvoice() {
        return valueSubstInvoice;
    }

    /**
     * @param valueSubstInvoice the valueSubstInvoice to set
     */
    public void setValueSubstInvoice(BigDecimal valueSubstInvoice) {
        BigDecimal oldValueSubstInvoice = this.valueSubstInvoice;
        this.valueSubstInvoice = valueSubstInvoice;
        changeSupport.firePropertyChange("valueSubstInvoice", oldValueSubstInvoice, valueSubstInvoice);
    }

    /**
     * @return the valueTotalInvoice
     */
    public BigDecimal getValueTotalInvoice() {
        return valueTotalInvoice;
    }

    /**
     * @param valueTotalInvoice the valueTotalInvoice to set
     */
    public void setValueTotalInvoice(BigDecimal valueTotalInvoice) {
        BigDecimal oldValueTotalInvoice = this.valueTotalInvoice;
        this.valueTotalInvoice = valueTotalInvoice;
        changeSupport.firePropertyChange("valueTotalInvoice", oldValueTotalInvoice, valueTotalInvoice);
    }
    
    /**
     * @return the valueAllProductsInvoice
     */
    public String getValueAllProductsInvoice() {
        return valueAllProductsInvoice;
    }

    /**
     * @param valueAllProductsInvoice the valueAllProductsInvoice to set
     */
    public void setValueAllProductsInvoice(String valueAllProductsInvoice) {
        String oldValueAllProductsInvoice = this.valueAllProductsInvoice;
        this.valueAllProductsInvoice = valueAllProductsInvoice;
        changeSupport.firePropertyChange("valueAllProductsInvoice", oldValueAllProductsInvoice, valueAllProductsInvoice);
        
    }
     /**
     * @return the transporter
     */
    public String getTransporter() {
        return transporter;
    }

    /**
     * @param transporter the transporter to set
     */
    public void setTransporter(String transporter) {
        String oldTransporter = this.transporter;
        this.transporter = transporter;
        changeSupport.firePropertyChange("transporter", oldTransporter, transporter);
    }

    /**
     * @return the observationInvoice
     */
    public String getObservationInvoice() {
        return observationInvoice;
    }

    /**
     * @param observationInvoice the observationInvoice to set
     */
    public void setObservationInvoice(String observationInvoice) {
        String oldObservationInvoice = this.observationInvoice;
        this.observationInvoice = observationInvoice;
        changeSupport.firePropertyChange("observationInvoice", oldObservationInvoice, observationInvoice);
    }

    /**
     * @return the valueProductInvoice
     */
    public double getValueProductInvoice() {
        return valueProductInvoice;
    }

    /**
     * @param valueProductInvoice the valueProductInvoice to set
     */
    public void setValueProductInvoice(double valueProductInvoice) {
        double oldValueProductInvoice = this.valueProductInvoice;
        this.valueProductInvoice = valueProductInvoice;
        changeSupport.firePropertyChange("valueProductInvoice", oldValueProductInvoice, valueProductInvoice);
        
    }

    /**
     * @return the descriptionProductInvoice
     */
    public String getDescriptionProductInvoice() {
        return descriptionProductInvoice;
    }

    /**
     * @param descriptionProductInvoice the descriptionProductInvoice to set
     */
    public void setDescriptionProductInvoice(String descriptionProductInvoice) {
        String oldDescriptionProductInvoice = this.descriptionProductInvoice;
        this.descriptionProductInvoice = descriptionProductInvoice;
        changeSupport.firePropertyChange("descriptionProductInvoice", oldDescriptionProductInvoice, descriptionProductInvoice);
        
    }

    /**
     * @return the codProductInvoice
     */
    public double getCodProductInvoice() {
        return codProductInvoice;
    }

    /**
     * @param codProductInvoice the codProductInvoice to set
     */
    public void setCodProductInvoice(double codProductInvoice) {
        double oldCodProductInvoice = this.codProductInvoice;
        this.codProductInvoice = codProductInvoice;
        changeSupport.firePropertyChange("codProductInvoice", oldCodProductInvoice, codProductInvoice);
        
        
    }

    /**
     * @return the codBarProductInvoice
     */
    public String getCodBarProductInvoice() {
        return codBarProductInvoice;
    }

    /**
     * @param codBarProductInvoice the codBarProductInvoice to set
     */
    public void setCodBarProductInvoice(String codBarProductInvoice) {
        String oldCodBarProductInvoice = this.codBarProductInvoice;
        this.codBarProductInvoice = codBarProductInvoice;
        changeSupport.firePropertyChange("codBarProductInvoice", oldCodBarProductInvoice, codBarProductInvoice);
        
    }

    /**
     * @return the observationProductInvoice
     */
    public String getObservationProductInvoice() {
        return observationProductInvoice;
    }

    /**
     * @param observationProductInvoice the observationProductInvoice to set
     */
    public void setObservationProductInvoice(String observationProductInvoice) {
        String oldObservationProductInvoice = this.observationProductInvoice;
        this.observationProductInvoice = observationProductInvoice;
        changeSupport.firePropertyChange("observationProductInvoice", oldObservationProductInvoice, observationProductInvoice);
    }

    /**
     * @return the quantityProductInvoice
     */
    public double getQuantityProductInvoice() {
        return quantityProductInvoice;
    }

    /**
     * @param quantityProductInvoice the quantityProductInvoice to set
     */
    public void setQuantityProductInvoice(double quantityProductInvoice) {
        double oldQuantityProductInvoice = this.quantityProductInvoice;
        this.quantityProductInvoice = quantityProductInvoice;
        changeSupport.firePropertyChange("quantityProductInvoice", oldQuantityProductInvoice, quantityProductInvoice);
        
    }
}
