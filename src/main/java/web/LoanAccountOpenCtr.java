package web;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Loaninfo;
import model.Sanctioninfo;
import service.LaonAccountOpenService;


@Named
@ViewScoped
public class LoanAccountOpenCtr implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Loaninfo loaninfo;
	
	@Inject
	private Sanctioninfo sanctioninfo;
	
	@Inject
	private LaonAccountOpenService ilaonAccountOpenService;
	
	
	@PostConstruct
	public void init(){
		
	}
	
	
	public void saveData() {

		
		try {
			ilaonAccountOpenService.saveLoanAccount(loaninfo, sanctioninfo);
		} catch (Exception e) {
			
		}
		

	}
	
	
	public void updateData() {

		try {
			ilaonAccountOpenService.updateLoanAccount(loaninfo, sanctioninfo);
		} catch (Exception e) {
			
		}

	}
	
	
	public void getLoanDetails() throws Exception{
		
		sanctioninfo = ilaonAccountOpenService.getSanctioninfo(sanctioninfo.getSanctionno());
		loaninfo = ilaonAccountOpenService.getLoaninfo(loaninfo.getLoanaccountno());
		
	}


	public Loaninfo getLoaninfo() {
		return loaninfo;
	}


	public void setLoaninfo(Loaninfo loaninfo) {
		this.loaninfo = loaninfo;
	}


	public Sanctioninfo getSanctioninfo() {
		return sanctioninfo;
	}


	public void setSanctioninfo(Sanctioninfo sanctioninfo) {
		this.sanctioninfo = sanctioninfo;
	}
	
	

}
