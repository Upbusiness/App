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
@Table(name = "tbl_client", catalog = "upmarket", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblClient.findAll", query = "SELECT t FROM TblClient t"),
    @NamedQuery(name = "TblClient.findByCpfClient", query = "SELECT t FROM TblClient t WHERE t.cpfClient = :cpfClient"),
    @NamedQuery(name = "TblClient.findByNameClient", query = "SELECT t FROM TblClient t WHERE t.nameClient = :nameClient"),
    @NamedQuery(name = "TblClient.findByAddressClient", query = "SELECT t FROM TblClient t WHERE t.addressClient = :addressClient"),
    @NamedQuery(name = "TblClient.findByDistrictClient", query = "SELECT t FROM TblClient t WHERE t.districtClient = :districtClient"),
    @NamedQuery(name = "TblClient.findByCityClient", query = "SELECT t FROM TblClient t WHERE t.cityClient = :cityClient")})
public class TblClient implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cpf_client")
    private String cpfClient;
    @Basic(optional = false)
    @Column(name = "name_client")
    private String nameClient;
    @Column(name = "address_client")
    private String addressClient;
    @Column(name = "district_client")
    private String districtClient;
    @Column(name = "city_client")
    private String cityClient;

    public TblClient() {
    }

    public TblClient(String cpfClient) {
        this.cpfClient = cpfClient;
    }

    public TblClient(String cpfClient, String nameClient) {
        this.cpfClient = cpfClient;
        this.nameClient = nameClient;
    }

    public String getCpfClient() {
        return cpfClient;
    }

    public void setCpfClient(String cpfClient) {
        String oldCpfClient = this.cpfClient;
        this.cpfClient = cpfClient;
        changeSupport.firePropertyChange("cpfClient", oldCpfClient, cpfClient);
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        String oldNameClient = this.nameClient;
        this.nameClient = nameClient;
        changeSupport.firePropertyChange("nameClient", oldNameClient, nameClient);
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        String oldAddressClient = this.addressClient;
        this.addressClient = addressClient;
        changeSupport.firePropertyChange("addressClient", oldAddressClient, addressClient);
    }

    public String getDistrictClient() {
        return districtClient;
    }

    public void setDistrictClient(String districtClient) {
        String oldDistrictClient = this.districtClient;
        this.districtClient = districtClient;
        changeSupport.firePropertyChange("districtClient", oldDistrictClient, districtClient);
    }

    public String getCityClient() {
        return cityClient;
    }

    public void setCityClient(String cityClient) {
        String oldCityClient = this.cityClient;
        this.cityClient = cityClient;
        changeSupport.firePropertyChange("cityClient", oldCityClient, cityClient);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpfClient != null ? cpfClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblClient)) {
            return false;
        }
        TblClient other = (TblClient) object;
        if ((this.cpfClient == null && other.cpfClient != null) || (this.cpfClient != null && !this.cpfClient.equals(other.cpfClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.TblClient[ cpfClient=" + cpfClient + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
