package com.employment.portal.service;

import java.util.List;
import java.util.Optional;

import com.employment.portal.model.Employer;

public interface IEmployerService {

//	List<Employer> findByIsActive(boolean isActive);
//
	List<Employer> findByCompanyNameContaining(String companyName);

	List<Employer> findAll();

	Optional<Employer> findById(long id);

	Employer save(Employer candidate);

	void deleteById(long id);

	void deleteAll();

}
