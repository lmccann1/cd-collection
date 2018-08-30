package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.CD;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative

public class CDMapRepository implements CDRepository {

	private Map<Long, CD> cdMap;
	
	@Inject
	private JSONUtil util;
	
	private Long counter = 1L;
	
	public CDMapRepository() {
		this.cdMap = new HashMap<Long, CD>();
	}

	public String getAllCDs() {
		return util.getJSONForObject(cdMap);
	}

	public String addCD(String cd) {
		counter++;
		cdMap.put(counter, util.getObjectForJSON(cd, CD.class));
		return cd;
		
	}

	public String updateCD(Long id, String cdToUpdate) {
		cdMap.put(counter, util.getObjectForJSON(cdToUpdate, CD.class));
		return cdToUpdate;
	}

	public String deleteCD(Long id) {
		cdMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}

	
	}

	

