/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author deeppatel
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid = :customerid"),
    @NamedQuery(name = "Customer.findByCustomerfirstname", query = "SELECT c FROM Customer c WHERE c.customerfirstname = :customerfirstname"),
    @NamedQuery(name = "Customer.findByCustomerlastname", query = "SELECT c FROM Customer c WHERE c.customerlastname = :customerlastname"),
    @NamedQuery(name = "Customer.findByCustomeremail", query = "SELECT c FROM Customer c WHERE c.customeremail = :customeremail"),
    @NamedQuery(name = "Customer.findByCustomerstreetaddress", query = "SELECT c FROM Customer c WHERE c.customerstreetaddress = :customerstreetaddress"),
    @NamedQuery(name = "Customer.findByCustomercity", query = "SELECT c FROM Customer c WHERE c.customercity = :customercity"),
    @NamedQuery(name = "Customer.findByCustomerzipcode", query = "SELECT c FROM Customer c WHERE c.customerzipcode = :customerzipcode"),
    @NamedQuery(name = "Customer.findByCustomerstate", query = "SELECT c FROM Customer c WHERE c.customerstate = :customerstate")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private Integer customerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CUSTOMERFIRSTNAME")
    private String customerfirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CUSTOMERLASTNAME")
    private String customerlastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CUSTOMEREMAIL")
    private String customeremail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CUSTOMERSTREETADDRESS")
    private String customerstreetaddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CUSTOMERCITY")
    private String customercity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERZIPCODE")
    private int customerzipcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CUSTOMERSTATE")
    private String customerstate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private Collection<Reservation> reservationCollection;

    public Customer() {
    }

    public Customer(Integer customerid) {
        this.customerid = customerid;
    }

    public Customer(Integer customerid, String customerfirstname, String customerlastname, String customeremail, String customerstreetaddress, String customercity, int customerzipcode, String customerstate) {
        this.customerid = customerid;
        this.customerfirstname = customerfirstname;
        this.customerlastname = customerlastname;
        this.customeremail = customeremail;
        this.customerstreetaddress = customerstreetaddress;
        this.customercity = customercity;
        this.customerzipcode = customerzipcode;
        this.customerstate = customerstate;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomerfirstname() {
        return customerfirstname;
    }

    public void setCustomerfirstname(String customerfirstname) {
        this.customerfirstname = customerfirstname;
    }

    public String getCustomerlastname() {
        return customerlastname;
    }

    public void setCustomerlastname(String customerlastname) {
        this.customerlastname = customerlastname;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getCustomerstreetaddress() {
        return customerstreetaddress;
    }

    public void setCustomerstreetaddress(String customerstreetaddress) {
        this.customerstreetaddress = customerstreetaddress;
    }

    public String getCustomercity() {
        return customercity;
    }

    public void setCustomercity(String customercity) {
        this.customercity = customercity;
    }

    public int getCustomerzipcode() {
        return customerzipcode;
    }

    public void setCustomerzipcode(int customerzipcode) {
        this.customerzipcode = customerzipcode;
    }

    public String getCustomerstate() {
        return customerstate;
    }

    public void setCustomerstate(String customerstate) {
        this.customerstate = customerstate;
    }

    @XmlTransient
    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ customerid=" + customerid + " ]";
    }
    
}
