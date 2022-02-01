
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author masum
 */
@Entity
@Table(name = "loaninfo")
@NamedQueries({
    @NamedQuery(name = "Loaninfo.findAll", query = "SELECT l FROM Loaninfo l"),
    @NamedQuery(name = "Loaninfo.findByLoanaccountno", query = "SELECT l FROM Loaninfo l WHERE l.loanaccountno = :loanaccountno"),
    @NamedQuery(name = "Loaninfo.findByCustomerid", query = "SELECT l FROM Loaninfo l WHERE l.customerid = :customerid"),
    @NamedQuery(name = "Loaninfo.findByLoanproductID", query = "SELECT l FROM Loaninfo l WHERE l.loanproductID = :loanproductID"),
    @NamedQuery(name = "Loaninfo.findByRemarks", query = "SELECT l FROM Loaninfo l WHERE l.remarks = :remarks")})
public class Loaninfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "loanaccountno")
    private Integer loanaccountno;
    @Basic(optional = false)
    @Column(name = "customerid")
    private String customerid;
    @Basic(optional = false)
    @Column(name = "loanproductID")
    private String loanproductID;
    @Basic(optional = false)
    @Column(name = "remarks")
    private String remarks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loanAccountNo")
    private Collection<Sanctioninfo> sanctioninfoCollection;

    public Loaninfo() {
    }

    public Integer getLoanaccountno() {
        return loanaccountno;
    }

    public void setLoanaccountno(Integer loanaccountno) {
        this.loanaccountno = loanaccountno;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getLoanproductID() {
        return loanproductID;
    }

    public void setLoanproductID(String loanproductID) {
        this.loanproductID = loanproductID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Collection<Sanctioninfo> getSanctioninfoCollection() {
        return sanctioninfoCollection;
    }

    public void setSanctioninfoCollection(Collection<Sanctioninfo> sanctioninfoCollection) {
        this.sanctioninfoCollection = sanctioninfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (loanaccountno != null ? loanaccountno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaninfo)) {
            return false;
        }
        Loaninfo other = (Loaninfo) object;
        if ((this.loanaccountno == null && other.loanaccountno != null) || (this.loanaccountno != null && !this.loanaccountno.equals(other.loanaccountno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mmode.Loaninfo[ loanaccountno=" + loanaccountno + " ]";
    }
    
}
