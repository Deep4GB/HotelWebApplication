/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author deeppatel
 */
@Entity
@Table(name = "RESERVATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservation.findAll", query = "SELECT r FROM Reservation r"),
    @NamedQuery(name = "Reservation.findByReservationid", query = "SELECT r FROM Reservation r WHERE r.reservationid = :reservationid"),
    @NamedQuery(name = "Reservation.findByBookingstartdate", query = "SELECT r FROM Reservation r WHERE r.bookingstartdate = :bookingstartdate"),
    @NamedQuery(name = "Reservation.findByBookingenddate", query = "SELECT r FROM Reservation r WHERE r.bookingenddate = :bookingenddate")})
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RESERVATIONID")
    private Integer reservationid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKINGSTARTDATE")
    @Temporal(TemporalType.DATE)
    private Date bookingstartdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKINGENDDATE")
    @Temporal(TemporalType.DATE)
    private Date bookingenddate;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne(optional = false)
    private Customer customerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservationid")
    private Collection<Checkin> checkinCollection;

    public Reservation() {
    }

    public Reservation(Integer reservationid) {
        this.reservationid = reservationid;
    }

    public Reservation(Integer reservationid, Date bookingstartdate, Date bookingenddate) {
        this.reservationid = reservationid;
        this.bookingstartdate = bookingstartdate;
        this.bookingenddate = bookingenddate;
    }

    public Integer getReservationid() {
        return reservationid;
    }

    public void setReservationid(Integer reservationid) {
        this.reservationid = reservationid;
    }

    public Date getBookingstartdate() {
        return bookingstartdate;
    }

    public void setBookingstartdate(Date bookingstartdate) {
        this.bookingstartdate = bookingstartdate;
    }

    public Date getBookingenddate() {
        return bookingenddate;
    }

    public void setBookingenddate(Date bookingenddate) {
        this.bookingenddate = bookingenddate;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    @XmlTransient
    public Collection<Checkin> getCheckinCollection() {
        return checkinCollection;
    }

    public void setCheckinCollection(Collection<Checkin> checkinCollection) {
        this.checkinCollection = checkinCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationid != null ? reservationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationid == null && other.reservationid != null) || (this.reservationid != null && !this.reservationid.equals(other.reservationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Reservation[ reservationid=" + reservationid + " ]";
    }
    
}
