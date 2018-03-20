

package action;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Information about one clinet.
 * 
 * @author Rafiusks
 */
public class Category {
    
   

    private int codCategory;
    private String descriptionCategory;
    private String observationCategory;
    private String sectorcategory;
    private double percentageProfitCategory;
    
    
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
    public int getCodCategory() {
        return codCategory;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public String getObservationCategory() {
        return observationCategory;
    }

    /**
     * @return the sectorcategory
     */
    public String getSectorcategory() {
        return sectorcategory;
    }

    /**
     * @return the percentageProfitCategory
     */
    public double getPercentageProfitCategory() {
        return percentageProfitCategory;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Set Methods">

    public void setCodCategory(int codCategory) {
        int oldCodCategory = this.codCategory;
        this.codCategory = codCategory;
        changeSupport.firePropertyChange("codCategory", oldCodCategory, codCategory);
    }

    public void setDescriptionCategory(String nameCategory) {
        String oldNameCategory = this.descriptionCategory;
        this.descriptionCategory = nameCategory;
        changeSupport.firePropertyChange("nameCategory", oldNameCategory, nameCategory);
    }

    public void setObservationCategory(String descriptionCategory) {
        String oldDescriptionCategory = this.observationCategory;
        this.observationCategory = descriptionCategory;
        changeSupport.firePropertyChange("descriptionCategory", oldDescriptionCategory, descriptionCategory);
    }

    /**
     * @param sectorcategory the sectorcategory to set
     */
    public void setSectorcategory(String sectorcategory) {
        String oldSectorcategory = this.sectorcategory;
        this.sectorcategory = sectorcategory;
        changeSupport.firePropertyChange("sectorcategory", oldSectorcategory, sectorcategory);
    }

    /**
     * @param percentageProfitCategory the percentageProfitCategory to set
     */
    public void setPercentageProfitCategory(double percentageProfitCategory) {
        double oldPercentageProfitCategory = this.percentageProfitCategory;
        this.percentageProfitCategory = percentageProfitCategory;
        changeSupport.firePropertyChange("percentageProfitCategory", oldPercentageProfitCategory, percentageProfitCategory);
    }  

}
