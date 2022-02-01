package service;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import common.PersistenceService;
import dao.LoanAccountOpenDao;
import model.Loaninfo;
import model.Sanctioninfo;

@Dependent
@Transactional(TxType.SUPPORTS)
public class LaonAccountOpenService {

	@Inject
	private PersistenceService persistenceService;

	@Inject
	private LoanAccountOpenDao loanAccountOpenDao;

	@Transactional(TxType.REQUIRED)
	public void saveLoanAccount(Loaninfo loaninfo, Sanctioninfo sanctioninfo) throws Exception {

		loaninfo = persistenceService.save(loaninfo);
		sanctioninfo.setLoanAccountNo(loaninfo);
		persistenceService.save(sanctioninfo);

	}

	
	@Transactional(TxType.REQUIRED)
	public void updateLoanAccount(Loaninfo loaninfo, Sanctioninfo sanctioninfo) throws Exception {
		persistenceService.update(loaninfo);
		persistenceService.update(sanctioninfo);
	}
	
	public Loaninfo getLoaninfo(Integer loanAccountNo) throws Exception {

		Loaninfo loaninfo = loanAccountOpenDao.getLoaninfo(loanAccountNo);
		return loaninfo;
	}


	public Sanctioninfo getSanctioninfo(Integer sanctionNo) {

		Sanctioninfo sanctiondetails = loanAccountOpenDao.getSanctiondetails(sanctionNo);

		return sanctiondetails;
	}

}
