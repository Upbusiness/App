/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "tbl_coupon", catalog = "upmarket", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblCoupon.findAll", query = "SELECT t FROM TblCoupon t"),
    @NamedQuery(name = "TblCoupon.findByIdtblCoupon", query = "SELECT t FROM TblCoupon t WHERE t.idtblCoupon = :idtblCoupon"),
    @NamedQuery(name = "TblCoupon.findByDateHourCoupon", query = "SELECT t FROM TblCoupon t WHERE t.dateHourCoupon = :dateHourCoupon"),
    @NamedQuery(name = "TblCoupon.findByIsCanceled", query = "SELECT t FROM TblCoupon t WHERE t.isCanceled = :isCanceled"),
    @NamedQuery(name = "TblCoupon.findByIsClosed", query = "SELECT t FROM TblCoupon t WHERE t.isClosed = :isClosed"),
    @NamedQuery(name = "TblCoupon.findByTerminalCoupon", query = "SELECT t FROM TblCoupon t WHERE t.terminalCoupon = :terminalCoupon"),
    @NamedQuery(name = "TblCoupon.findByCostCoupon", query = "SELECT t FROM TblCoupon t WHERE t.costCoupon = :costCoupon"),
    @NamedQuery(name = "TblCoupon.findByTotalCoupon", query = "SELECT t FROM TblCoupon t WHERE t.totalCoupon = :totalCoupon"),
    @NamedQuery(name = "TblCoupon.findByDiscountCoupon", query = "SELECT t FROM TblCoupon t WHERE t.discountCoupon = :discountCoupon"),
    @NamedQuery(name = "TblCoupon.findByIsLaunch", query = "SELECT t FROM TblCoupon t WHERE t.isLaunch = :isLaunch")})
public class TblCoupon implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtbl_coupon")
    private String idtblCoupon;
    @Column(name = "date_hour_coupon")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHourCoupon;
    @Column(name = "isCanceled")
    private Boolean isCanceled;
    @Column(name = "isClosed")
    private Boolean isClosed;
    @Column(name = "terminal_coupon")
    private Integer terminalCoupon;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost_coupon")
    private Double costCoupon;
    @Column(name = "total_coupon")
    private Double totalCoupon;
    @Column(name = "discount_coupon")
    private Double discountCoupon;
    @Column(name = "isLaunch")
    private Boolean isLaunch;

    public TblCoupon() {
    }

    public TblCoupon(String idtblCoupon) {
        this.idtblCoupon = idtblCoupon;
    }

    public String getIdtblCoupon() {
        return idtblCoupon;
    }

    public void setIdtblCoupon(String idtblCoupon) {
        String oldIdtblCoupon = this.idtblCoupon;
        this.idtblCoupon = idtblCoupon;
        changeSupport.firePropertyChange("idtblCoupon", oldIdtblCoupon, idtblCoupon);
    }

    public Date getDateHourCoupon() {
        return dateHourCoupon;
    }

    public void setDateHourCoupon(Date dateHourCoupon) {
        Date oldDateHourCoupon = this.dateHourCoupon;
        this.dateHourCoupon = dateHourCoupon;
        changeSupport.firePropertyChange("dateHourCoupon", oldDateHourCoupon, dateHourCoupon);
    }

    public Boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(Boolean isCanceled) {
        Boolean oldIsCanceled = this.isCanceled;
        this.isCanceled = isCanceled;
        changeSupport.firePropertyChange("isCanceled", oldIsCanceled, isCanceled);
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        Boolean oldIsClosed = this.isClosed;
        this.isClosed = isClosed;
        changeSupport.firePropertyChange("isClosed", oldIsClosed, isClosed);
    }

    public Integer getTerminalCoupon() {
        return terminalCoupon;
    }

    public void setTerminalCoupon(Integer terminalCoupon) {
        Integer oldTerminalCoupon = this.terminalCoupon;
        this.terminalCoupon = terminalCoupon;
        changeSupport.firePropertyChange("terminalCoupon", oldTerminalCoupon, terminalCoupon);
    }

    public Double getCostCoupon() {
        return costCoupon;
    }

    public void setCostCoupon(Double costCoupon) {
        Double oldCostCoupon = this.costCoupon;
        this.costCoupon = costCoupon;
        changeSupport.firePropertyChange("costCoupon", oldCostCoupon, costCoupon);
    }

    public Double getTotalCoupon() {
        return totalCoupon;
    }

    public void setTotalCoupon(Double totalCoupon) {
        Double oldTotalCoupon = this.totalCoupon;
        this.totalCoupon = totalCoupon;
        changeSupport.firePropertyChange("totalCoupon", oldTotalCoupon, totalCoupon);
    }

    public Double getDiscountCoupon() {
        return discountCoupon;
    }

    public void setDiscountCoupon(Double discountCoupon) {
        Double oldDiscountCoupon = this.discountCoupon;
        this.discountCoupon = discountCoupon;
        changeSupport.firePropertyChange("discountCoupon", oldDiscountCoupon, discountCoupon);
    }

    public Boolean getIsLaunch() {
        return isLaunch;
    }

    public void setIsLaunch(Boolean isLaunch) {
        Boolean oldIsLaunch = this.isLaunch;
        this.isLaunch = isLaunch;
        changeSupport.firePropertyChange("isLaunch", oldIsLaunch, isLaunch);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtblCoupon != null ? idtblCoupon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCoupon)) {
            return false;
        }
        TblCoupon other = (TblCoupon) object;
        if ((this.idtblCoupon == null && other.idtblCoupon != null) || (this.idtblCoupon != null && !this.idtblCoupon.equals(other.idtblCoupon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.TblCoupon[ idtblCoupon=" + idtblCoupon + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
