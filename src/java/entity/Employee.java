/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByEmployeeid", query = "SELECT e FROM Employee e WHERE e.employeeid = :employeeid"),
    @NamedQuery(name = "Employee.findByEmployeefirstname", query = "SELECT e FROM Employee e WHERE e.employeefirstname = :employeefirstname"),
    @NamedQuery(name = "Employee.findByEmployeelastname", query = "SELECT e FROM Employee e WHERE e.employeelastname = :employeelastname"),
    @NamedQuery(name = "Employee.findByEmployeephonenumber", query = "SELECT e FROM Employee e WHERE e.employeephonenumber = :employeephonenumber"),
    @NamedQuery(name = "Employee.findByEmployeeposition", query = "SELECT e FROM Employee e WHERE e.employeeposition = :employeeposition")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPLOYEEID")
    private Integer employeeid;
    @Size(max = 40)
    @Column(name = "EMPLOYEEFIRSTNAME")
    private String employeefirstname;
    @Size(max = 40)
    @Column(name = "EMPLOYEELASTNAME")
    private String employeelastname;
    @Column(name = "EMPLOYEEPHONENUMBER")
    private BigInteger employeephonenumber;
    @Size(max = 40)
    @Column(name = "EMPLOYEEPOSITION")
    private String employeeposition;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeid")
    private Collection<Checkin> checkinCollection;

    public Employee() {
    }

    public Employee(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeefirstname() {
        return employeefirstname;
    }

    public void setEmployeefirstname(String employeefirstname) {
        this.employeefirstname = employeefirstname;
    }

    public String getEmployeelastname() {
        return employeelastname;
    }

    public void setEmployeelastname(String employeelastname) {
        this.employeelastname = employeelastname;
    }

    public BigInteger getEmployeephonenumber() {
        return employeephonenumber;
    }

    public void setEmployeephonenumber(BigInteger employeephonenumber) {
        this.employeephonenumber = employeephonenumber;
    }

    public String getEmployeeposition() {
        return employeeposition;
    }

    public void setEmployeeposition(String employeeposition) {
        this.employeeposition = employeeposition;
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
        hash += (employeeid != null ? employeeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeid == null && other.employeeid != null) || (this.employeeid != null && !this.employeeid.equals(other.employeeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employee[ employeeid=" + employeeid + " ]";
    }
    
}
