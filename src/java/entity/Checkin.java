/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deeppatel
 */
@Entity
@Table(name = "CHECKIN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkin.findAll", query = "SELECT c FROM Checkin c"),
    @NamedQuery(name = "Checkin.findByCheckinid", query = "SELECT c FROM Checkin c WHERE c.checkinid = :checkinid"),
    @NamedQuery(name = "Checkin.findByRoomnumber", query = "SELECT c FROM Checkin c WHERE c.roomnumber = :roomnumber"),
    @NamedQuery(name = "Checkin.findByCheckindatetime", query = "SELECT c FROM Checkin c WHERE c.checkindatetime = :checkindatetime"),
    @NamedQuery(name = "Checkin.findByCheckoutdatetime", query = "SELECT c FROM Checkin c WHERE c.checkoutdatetime = :checkoutdatetime"),
    @NamedQuery(name = "Checkin.findByAdditionalfees", query = "SELECT c FROM Checkin c WHERE c.additionalfees = :additionalfees")})
public class Checkin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHECKINID")
    private Integer checkinid;
    @Column(name = "ROOMNUMBER")
    private Integer roomnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHECKINDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkindatetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHECKOUTDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkoutdatetime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDITIONALFEES")
    private int additionalfees;
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID")
    @ManyToOne(optional = false)
    private Employee employeeid;
    @JoinColumn(name = "RESERVATIONID", referencedColumnName = "RESERVATIONID")
    @ManyToOne(optional = false)
    private Reservation reservationid;

    public Checkin() {
    }

    public Checkin(Integer checkinid) {
        this.checkinid = checkinid;
    }

    public Checkin(Integer checkinid, Date checkindatetime, Date checkoutdatetime, int additionalfees) {
        this.checkinid = checkinid;
        this.checkindatetime = checkindatetime;
        this.checkoutdatetime = checkoutdatetime;
        this.additionalfees = additionalfees;
    }

    public Integer getCheckinid() {
        return checkinid;
    }

    public void setCheckinid(Integer checkinid) {
        this.checkinid = checkinid;
    }

    public Integer getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(Integer roomnumber) {
        this.roomnumber = roomnumber;
    }

    public Date getCheckindatetime() {
        return checkindatetime;
    }

    public void setCheckindatetime(Date checkindatetime) {
        this.checkindatetime = checkindatetime;
    }

    public Date getCheckoutdatetime() {
        return checkoutdatetime;
    }

    public void setCheckoutdatetime(Date checkoutdatetime) {
        this.checkoutdatetime = checkoutdatetime;
    }

    public int getAdditionalfees() {
        return additionalfees;
    }

    public void setAdditionalfees(int additionalfees) {
        this.additionalfees = additionalfees;
    }

    public Employee getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Employee employeeid) {
        this.employeeid = employeeid;
    }

    public Reservation getReservationid() {
        return reservationid;
    }

    public void setReservationid(Reservation reservationid) {
        this.reservationid = reservationid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkinid != null ? checkinid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checkin)) {
            return false;
        }
        Checkin other = (Checkin) object;
        if ((this.checkinid == null && other.checkinid != null) || (this.checkinid != null && !this.checkinid.equals(other.checkinid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Checkin[ checkinid=" + checkinid + " ]";
    }
    
}
