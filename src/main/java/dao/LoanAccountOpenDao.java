package dao;


import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Loaninfo;
import model.Sanctioninfo;



@Dependent
public class LoanAccountOpenDao {

	
	@Inject
	private EntityManager em;

	
	
	public Loaninfo getLoaninfo(Integer loanAccountNo) throws Exception {
		
		Query query = em.createNamedQuery("Loaninfo.findByLoanaccountno");
		query.setParameter("loanaccountno",loanAccountNo);
		Loaninfo  loanInfo = (Loaninfo) query.getSingleResult();
		return loanInfo;

	}
	
	public Sanctioninfo getSanctiondetails(int sanctionNo) {
		Query query = em.createNativeQuery("SELECT * FROM sanctioninfo s WHERE s.sanctionno=:sanctionNo",Sanctioninfo.class);
		query.setParameter("sanctionNo",sanctionNo);
		Sanctioninfo sanctioninfo = (Sanctioninfo) query.getSingleResult();
		return sanctioninfo;
	}

}
