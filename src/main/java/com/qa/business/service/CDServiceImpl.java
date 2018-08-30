package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.repository.CDRepository;

public class CDServiceImpl implements CDService {

	@Inject
	private CDRepository crp;

	
	public String getAllCDs() {
	
		return crp.getAllCDs();
	}

	public String addCD(String cd) {
	
		return crp.addCD(cd);
	}

	public String updateCD(Long id, String cd) {
		
		return crp.updateCD(id, cd);
	}

	public String deleteCD(Long id) {
		
		return crp.deleteCD(id);
	}
	
	public void setRepo(CDRepository crp) {
		this.crp = crp;
	}

}
