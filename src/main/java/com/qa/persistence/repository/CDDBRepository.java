package com.qa.persistence.repository;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;


import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import com.qa.persistence.domain.CD;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class CDDBRepository implements CDRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	public String getAllCDs() {
		Query query = em.createQuery("Select a From CD a");
		Collection<CD> cd = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cd);
	}
	@Transactional(REQUIRED)
	public String addCD(String cd) {
		CD newCD = util.getObjectForJSON(cd, CD.class);
		em.persist(newCD);
		return "{\"message\": \"cd has been added\"}";
	}
	@Transactional(REQUIRED)

	public String updateCD(Long id, String cdToUpdate) {
		CD updateCD = util.getObjectForJSON(cdToUpdate, CD.class);
		CD cdDB = findCD(id);
		if (cdToUpdate != null) {
			cdDB = updateCD;
			em.merge(cdDB);	
			
		}
		
		return "{\"message\": \"cd has been updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteCD(Long id) {
		CD cdDB = findCD(id);
		if (cdDB != null) {
			em.remove(cdDB);
		}
		return "{\"message\": \"cd has been delete\"}";
	
	}
	private CD findCD(Long id) {
		return em.find(CD.class, id);
	}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	
	
	
}
