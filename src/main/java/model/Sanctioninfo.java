
package model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author masum
 */
@Entity
@Table(name = "sanctioninfo")
@NamedQueries({
    @NamedQuery(name = "Sanctioninfo.findAll", query = "SELECT s FROM Sanctioninfo s"),
    @NamedQuery(name = "Sanctioninfo.findBySanctionno", query = "SELECT s FROM Sanctioninfo s WHERE s.sanctionno = :sanctionno"),
    @NamedQuery(name = "Sanctioninfo.findByAmount", query = "SELECT s FROM Sanctioninfo s WHERE s.amount = :amount"),
    @NamedQuery(name = "Sanctioninfo.findByGraceperiod", query = "SELECT s FROM Sanctioninfo s WHERE s.graceperiod = :graceperiod"),
    @NamedQuery(name = "Sanctioninfo.findByExperiedate", query = "SELECT s FROM Sanctioninfo s WHERE s.experiedate = :experiedate")})
public class Sanctioninfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sanctionno")
    private Integer sanctionno;
    @Basic(optional = false)
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @Column(name = "graceperiod")
    private String graceperiod;
    @Basic(optional = false)
    @Column(name = "experiedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date experiedate;
    @JoinColumn(name = "loanAccountNo", referencedColumnName = "loanaccountno")
    @ManyToOne(optional = false)
    private Loaninfo loanAccountNo;

    public Sanctioninfo() {
    }

    public Integer getSanctionno() {
        return sanctionno;
    }

    public void setSanctionno(Integer sanctionno) {
        this.sanctionno = sanctionno;
    }

    

    public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getGraceperiod() {
        return graceperiod;
    }

    public void setGraceperiod(String graceperiod) {
        this.graceperiod = graceperiod;
    }

    public Date getExperiedate() {
        return experiedate;
    }

    public void setExperiedate(Date experiedate) {
        this.experiedate = experiedate;
    }

    public Loaninfo getLoanAccountNo() {
        return loanAccountNo;
    }

    public void setLoanAccountNo(Loaninfo loanAccountNo) {
        this.loanAccountNo = loanAccountNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sanctionno != null ? sanctionno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sanctioninfo)) {
            return false;
        }
        Sanctioninfo other = (Sanctioninfo) object;
        if ((this.sanctionno == null && other.sanctionno != null) || (this.sanctionno != null && !this.sanctionno.equals(other.sanctionno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mmode.Sanctioninfo[ sanctionno=" + sanctionno + " ]";
    }
    
}
