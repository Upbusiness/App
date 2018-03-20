

package action;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import model.ClassProduct;

/**
 * Information about one clinet.
 * 
 * @author Rafiusks
 */
public class ComponentsProduct {
    
   

    private double codProduct;
    private double categoryProduct;
    private String descriptionProduct;
    private String unityMensurationProduct;
    private int typeProductionProduct;
    private int budgetMin;
    private int budgetActual;
    private double priceBuyProduct;
    private double percentagemQuotaProduct;
    private double percentagemProfit;
    private double priceActualSale;
    private double priceTab1Sale;
    private double priceTab2Sale;
    private double priceMeanBuyProduct;
   
    
    
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

    public double getCodProduct() {
        return codProduct;
    }

    public double getCategoryProduct() {
        return categoryProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Set Methods">

    public void setCodProduct(double codProduct) {
        double oldCodProduct = this.codProduct;
        this.codProduct = codProduct;
        changeSupport.firePropertyChange("codProduct", oldCodProduct, codProduct);
    }

    public void setCategoryProduct(double categoryProduct) {
        double oldCategoryProduct = this.categoryProduct;
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
    public int getBudgetMin() {
        return budgetMin;
    }

    /**
     * @param budgetMin the budgetMin to set
     */
    public void setBudgetMin(int budgetMin) {
        int oldBudgetMin = this.budgetMin;
        this.budgetMin = budgetMin;
        changeSupport.firePropertyChange("budgetMin", oldBudgetMin, budgetMin);
    }

    /**
     * @return the budgetMax
     */
    public int getBudgetActual() {
        return budgetActual;
    }

    /**
     * @param budgetMax the budgetMax to set
     */
    public void setBudgetActual(int budgetActual) {
        int oldBudgetActual = this.budgetActual;
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
     * @param QuotaProduct the QuotaProduct to set
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
     * @param QuotaProduct the QuotaProduct to set
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
     * @param priceActualBuy the priceActualBuy to set
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
     * @param priceTab1Buy the priceTab1Buy to set
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
     * @param priceTab2Buy the priceTab2Buy to set
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
    

   
    
}
