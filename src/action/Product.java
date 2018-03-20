package action;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Information about one clinet.
 *
 * @author Rafiusks
 */
public class Product {



    private String codProduct;
    private Object categoryProduct;
    private String barCodeProduct;
    private String oldBarCodeProduct;
    private String descriptionProduct;
    private String unityMensurationProduct;
    private int typeProductionProduct;
    private double budgetMin;
    private double budgetMax;
    private double budgetActual;
    private double priceBuyProduct;
    private double percentagemQuotaProduct;
    private double percentagemProfit;
    private double priceActualSale;
    private double priceTab1Sale;
    private double priceTab2Sale;
    private double priceMeanBuyProduct;
    private Object vendor;
    private String abbreviature;
    private double unity_measure;
    private String dateCreation;
    private String dateLastModification;
    private boolean isActiveProduct;
    private boolean isControlReserve;
    private String observationProduct;
    private String meanSaleIndicator;

    // <editor-fold defaultstate="collapsed" desc="PropertyChange Stuff">
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Get Methods">
    public Object getCategoryProduct() {
        return categoryProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Set Methods">
    public void setCategoryProduct(Object categoryProduct) {
        Object oldCategoryProduct = this.categoryProduct;
        this.categoryProduct = categoryProduct;
        changeSupport.firePropertyChange("categoryProduct", oldCategoryProduct, categoryProduct);
    }

    public void setDescriptionProduct(String descriptionProduct) {
        String oldDescriptionProduct = this.descriptionProduct;
        this.descriptionProduct = descriptionProduct;
        changeSupport.firePropertyChange("descriptionProduct", oldDescriptionProduct, descriptionProduct);
    }

    // </editor-fold>
    /**
     * @return the unityMensurationProduct
     */
    public String getUnityMensurationProduct() {
        return unityMensurationProduct;
    }

    /**
     * @param unityMensurationProduct the unityMensurationProduct to set
     */
    public void setUnityMensurationProduct(String unityMensurationProduct) {
        String oldUnityMensurationProduct = this.unityMensurationProduct;
        this.unityMensurationProduct = unityMensurationProduct;
        changeSupport.firePropertyChange("unityMensurationProduct", oldUnityMensurationProduct, unityMensurationProduct);

    }

    /**
     * @return the typeProductionProduct
     */
    public int getTypeProductionProduct() {
        return typeProductionProduct;
    }

    /**
     * @param typeProductionProduct the typeProductionProduct to set
     */
    public void setTypeProductionProduct(int typeProductionProduct) {
        int oldTypeProductionProduct = this.typeProductionProduct;
        this.typeProductionProduct = typeProductionProduct;
        changeSupport.firePropertyChange("typeProductionProduct", oldTypeProductionProduct, typeProductionProduct);
    }

    /**
     * @return the budgetMin
     */
    public double getBudgetMin() {
        return budgetMin;
    }

    /**
     * @param budgetMin the budgetMin to set
     */
    public void setBudgetMin(double budgetMin) {
        double oldBudgetMin = this.budgetMin;
        this.budgetMin = budgetMin;
        changeSupport.firePropertyChange("budgetMin", oldBudgetMin, budgetMin);
    }

    /**
     * @return the budgetMax
     */
    public double getBudgetMax() {
        return budgetMax;
    }

    /**
     * @param budgetMax the budgetMax to set
     */
    public void setBudgetMax(double budgetMax) {
        double oldBudgetMax = this.budgetMax;
        this.budgetMax = budgetMax;
        changeSupport.firePropertyChange("budgetMax", oldBudgetMax, budgetMax);
    }

    /**
     * @return the budgetMax
     */
    public double getBudgetActual() {
        return budgetActual;
    }

    /**
     * @param budgetActual
     */
    public void setBudgetActual(double budgetActual) {
        double oldBudgetActual = this.budgetActual;
        this.budgetActual = budgetActual;
        changeSupport.firePropertyChange("budgetActual", oldBudgetActual, budgetActual);
    }

    /**
     * @return the priceBuyProduct
     */
    public double getPriceBuyProduct() {
        return priceBuyProduct;
    }

    /**
     * @param priceBuyProduct the priceBuyProduct to set
     */
    public void setPriceBuyProduct(double priceBuyProduct) {
        double oldPriceBuyProduct = this.priceBuyProduct;
        this.priceBuyProduct = priceBuyProduct;
        changeSupport.firePropertyChange("priceBuyProduct", oldPriceBuyProduct, priceBuyProduct);
    }

    /**
     * @return the QuotaProduct
     */
    public double getPercentagemQuotaProduct() {
        return percentagemQuotaProduct;
    }

    /**
     * @param percentagemQuotaProduct
     */
    public void setPercentagemQuotaProduct(double percentagemQuotaProduct) {
        double oldPercentagemQuotaProduct = this.percentagemQuotaProduct;
        this.percentagemQuotaProduct = percentagemQuotaProduct;
        changeSupport.firePropertyChange("percentagemQuotaProduct", oldPercentagemQuotaProduct, percentagemQuotaProduct);
    }

    /**
     * @return the QuotaProduct
     */
    public double getPercentagemProfit() {
        return percentagemProfit;
    }

    /**
     * @param percentagemProfit
     */
    public void setPercentagemProfit(double percentagemProfit) {
        double oldPercentagemProfit = this.percentagemProfit;
        this.percentagemProfit = percentagemProfit;
        changeSupport.firePropertyChange("percentagemProfit", oldPercentagemProfit, percentagemProfit);
    }

    /**
     * @return the priceActualBuy
     */
    public double getPriceActualSale() {
        return priceActualSale;
    }

    /**
     * @param priceActualSale
     */
    public void setPriceActualSale(double priceActualSale) {
        double oldPriceActualSale = this.priceActualSale;
        this.priceActualSale = priceActualSale;
        changeSupport.firePropertyChange("priceActualSale", oldPriceActualSale, priceActualSale);

    }

    /**
     * @return the priceTab1Buy
     */
    public double getPriceTab1Sale() {
        return priceTab1Sale;
    }

    /**
     * @param priceTab1Sale
     * @pa
     */
    public void setPriceTab1Sale(double priceTab1Sale) {
        double oldPriceTab1Sale = this.priceTab1Sale;
        this.priceTab1Sale = priceTab1Sale;
        changeSupport.firePropertyChange("priceTab1Sale", oldPriceTab1Sale, priceTab1Sale);
    }

    /**
     * @return the priceTab2Buy
     */
    public double getPriceTab2Sale() {
        return priceTab2Sale;
    }

    /**
     * @param priceTab2Sale
     */
    public void setPriceTab2Sale(double priceTab2Sale) {
        double oldPriceTab2Sale = this.priceTab2Sale;
        this.priceTab2Sale = priceTab2Sale;
        changeSupport.firePropertyChange("priceTab2Sale", oldPriceTab2Sale, priceTab2Sale);
    }

    /**
     * @return the priceMeanBuyProduct
     */
    public double getPriceMeanBuyProduct() {
        return priceMeanBuyProduct;
    }

    /**
     * @param priceMeanBuyProduct the priceMeanBuyProduct to set
     */
    public void setPriceMeanBuyProduct(double priceMeanBuyProduct) {
        double oldPriceMeanBuyProduct = this.priceMeanBuyProduct;
        this.priceMeanBuyProduct = priceMeanBuyProduct;
        changeSupport.firePropertyChange("priceMeanBuyProduct", oldPriceMeanBuyProduct, priceMeanBuyProduct);
    }

    /**
     * @return the barCodeProduct
     */
    public String getBarCodeProduct() {
        return barCodeProduct;
    }

    public String getOldBarCodeProduct() {
        return oldBarCodeProduct;
    }

    /**
     * @param oldBarCodeProduct the barCodeProduct to set
     */
    public void setOldBarCodeProduct(String oldBarCodeProduct) {
        String oldOldBarCodeProduct = this.oldBarCodeProduct;
        this.oldBarCodeProduct = oldBarCodeProduct;
        changeSupport.firePropertyChange("barCodeProduct", oldOldBarCodeProduct, oldBarCodeProduct);

    }

    /**
     * @param barCodeProduct the barCodeProduct to set
     */
    public void setBarCodeProduct(String barCodeProduct) {
        String olDBarCodeProduct = this.barCodeProduct;
        this.barCodeProduct = barCodeProduct;
        changeSupport.firePropertyChange("barCodeProduct", olDBarCodeProduct, barCodeProduct);

    }

    /**
     * @return the abbreviature
     */
    public String getAbbreviature() {
        return abbreviature;
    }

    /**
     * @param abbreviature the abbreviature to set
     */
    public void setAbbreviature(String abbreviature) {
        String oldAbbreviature = this.abbreviature;
        this.abbreviature = abbreviature;
        changeSupport.firePropertyChange("abbreviature", oldAbbreviature, abbreviature);

    }

    /**
     * @return the abbreviature
     */
    public Object getVendor() {
        return vendor;
    }

    /**
     * @param abbreviature the abbreviature to set
     */
    public void setVendor(Object abbreviature) {
        Object oldVendor = vendor;
        this.vendor = abbreviature;
        changeSupport.firePropertyChange("vendor", oldVendor, vendor);

    }

    /**
     * @return the unity_measure
     */
    public double getUnity_measure() {
        return unity_measure;
    }

    /**
     * @param unity_measure the unity_measure to set
     */
    public void setUnity_measure(double unity_measure) {
        double oldUnity_measure = this.unity_measure;
        this.unity_measure = unity_measure;
        changeSupport.firePropertyChange("unity_measure", oldUnity_measure, unity_measure);

    }

    /**
     * @return the codProduct
     */
    public String getCodProduct() {
        return codProduct;
    }

    /**
     * @param codProduct the codProduct to set
     */
    public void setCodProduct(String codProduct) {
        String oldCodProduct = this.codProduct;
        this.codProduct = codProduct;
        changeSupport.firePropertyChange("codProduct", oldCodProduct, codProduct);
    }

    /**
     * @return the isActiveProduct
     */
    public boolean isIsActiveProduct() {
        return isActiveProduct;
    }

    /**
     * @param isActiveProduct the isActiveProduct to set
     */
    public void setIsActiveProduct(boolean isActiveProduct) {
        boolean OldIsActiveProduct = this.isActiveProduct;
        this.isActiveProduct = isActiveProduct;
        changeSupport.firePropertyChange("isActiveProduct", OldIsActiveProduct, isActiveProduct);
    }

    /**
     * @return the dateCreation
     */
    public String getDateCreation() {
        return dateCreation;
    }

    /**
     * @param dateCreation the dateCreation to set
     */
    public void setDateCreation(String dateCreation) {
        String oldDateCreation = this.dateCreation;
        this.dateCreation = dateCreation;
        changeSupport.firePropertyChange("dateCreation", oldDateCreation, dateCreation);
    }

    /**
     * @return the dateLastModification
     */
    public String getDateLastModification() {
        return dateLastModification;
    }

    /**
     * @param dateLastModification the dateLastModification to set
     */
    public void setDateLastModification(String dateLastModification) {
        String oldDateLastModification = this.dateLastModification;
        this.dateLastModification = dateLastModification;
        changeSupport.firePropertyChange("dateLastModification", oldDateLastModification, dateLastModification);
    }
 /**
     * @return the observationProduct
     */
    public String getObservationProduct() {
        return observationProduct;
    }
     /**
     * @param observationProduct the observationProduct to set
     */
    public void setObservationProduct(String observationProduct) {
        String oldObservationProduct = this.getObservationProduct();
        this.observationProduct = observationProduct;
        changeSupport.firePropertyChange("observationProduct", oldObservationProduct, observationProduct);
    }

    /**
     * @return the isControlReserve
     */
    public boolean isIsControlReserve() {
        return isControlReserve;
    }

    /**
     * @param isControlReserve the isControlReserve to set
     */
    public void setIsControlReserve(boolean isControlReserve) {
        boolean oldIsControlReserve = this.isControlReserve;
        this.isControlReserve = isControlReserve;
        changeSupport.firePropertyChange("isControlReserve", oldIsControlReserve, isControlReserve);
    }

    /**
     * @return the meanSaleIndicator
     */
    public String getMeanSaleIndicator() {
        return meanSaleIndicator;
    }

    /**
     * @param meanSaleIndicator the meanSaleIndicator to set
     */
    public void setMeanSaleIndicator(String meanSaleIndicator) {
        String oldMeanSaleIndicator = this.meanSaleIndicator;
        this.meanSaleIndicator = meanSaleIndicator;
        changeSupport.firePropertyChange("meanSaleIndicator", oldMeanSaleIndicator, meanSaleIndicator);
    }

   
}
