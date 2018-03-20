/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rafael Recalcatti
 */
@Entity
@Table(name = "tbl_category_product", catalog = "upmarket", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblCategoryProduct.findAll", query = "SELECT t FROM TblCategoryProduct t"),
    @NamedQuery(name = "TblCategoryProduct.findByIdtblCategoryProduct", query = "SELECT t FROM TblCategoryProduct t WHERE t.idtblCategoryProduct = :idtblCategoryProduct"),
    @NamedQuery(name = "TblCategoryProduct.findByDescriptionCategory", query = "SELECT t FROM TblCategoryProduct t WHERE t.descriptionCategory = :descriptionCategory"),
    @NamedQuery(name = "TblCategoryProduct.findBySectorCategory", query = "SELECT t FROM TblCategoryProduct t WHERE t.sectorCategory = :sectorCategory"),
    @NamedQuery(name = "TblCategoryProduct.findByObservationCategory", query = "SELECT t FROM TblCategoryProduct t WHERE t.observationCategory = :observationCategory"),
    @NamedQuery(name = "TblCategoryProduct.findByPercentageProfit", query = "SELECT t FROM TblCategoryProduct t WHERE t.percentageProfit = :percentageProfit")})
public class TblCategoryProduct implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtbl_category_product")
    private Integer idtblCategoryProduct;
    @Basic(optional = false)
    @Column(name = "description_category")
    private String descriptionCategory;
    @Column(name = "sector_category")
    private String sectorCategory;
    @Column(name = "observation_category")
    private String observationCategory;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "percentage_profit")
    private Double percentageProfit;

    public TblCategoryProduct() {
    }

    public TblCategoryProduct(Integer idtblCategoryProduct) {
        this.idtblCategoryProduct = idtblCategoryProduct;
    }

    public TblCategoryProduct(Integer idtblCategoryProduct, String descriptionCategory) {
        this.idtblCategoryProduct = idtblCategoryProduct;
        this.descriptionCategory = descriptionCategory;
    }

    public Integer getIdtblCategoryProduct() {
        return idtblCategoryProduct;
    }

    public void setIdtblCategoryProduct(Integer idtblCategoryProduct) {
        Integer oldIdtblCategoryProduct = this.idtblCategoryProduct;
        this.idtblCategoryProduct = idtblCategoryProduct;
        changeSupport.firePropertyChange("idtblCategoryProduct", oldIdtblCategoryProduct, idtblCategoryProduct);
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        String oldDescriptionCategory = this.descriptionCategory;
        this.descriptionCategory = descriptionCategory;
        changeSupport.firePropertyChange("descriptionCategory", oldDescriptionCategory, descriptionCategory);
    }

    public String getSectorCategory() {
        return sectorCategory;
    }

    public void setSectorCategory(String sectorCategory) {
        String oldSectorCategory = this.sectorCategory;
        this.sectorCategory = sectorCategory;
        changeSupport.firePropertyChange("sectorCategory", oldSectorCategory, sectorCategory);
    }

    public String getObservationCategory() {
        return observationCategory;
    }

    public void setObservationCategory(String observationCategory) {
        String oldObservationCategory = this.observationCategory;
        this.observationCategory = observationCategory;
        changeSupport.firePropertyChange("observationCategory", oldObservationCategory, observationCategory);
    }

    public Double getPercentageProfit() {
        return percentageProfit;
    }

    public void setPercentageProfit(Double percentageProfit) {
        Double oldPercentageProfit = this.percentageProfit;
        this.percentageProfit = percentageProfit;
        changeSupport.firePropertyChange("percentageProfit", oldPercentageProfit, percentageProfit);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtblCategoryProduct != null ? idtblCategoryProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCategoryProduct)) {
            return false;
        }
        TblCategoryProduct other = (TblCategoryProduct) object;
        if ((this.idtblCategoryProduct == null && other.idtblCategoryProduct != null) || (this.idtblCategoryProduct != null && !this.idtblCategoryProduct.equals(other.idtblCategoryProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.TblCategoryProduct[ idtblCategoryProduct=" + idtblCategoryProduct + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
