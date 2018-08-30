package com.qa.persistence.repository;

public interface CDRepository {
	
	String getAllCDs();

	String addCD(String cd);

	String updateCD(Long id, String cdToUpdate);

	String deleteCD(Long id);


}
