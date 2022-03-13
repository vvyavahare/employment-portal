package com.employment.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employment.portal.model.Employer;
import com.employment.portal.repository.EmployerRepository;

@Service
public class EmployerService implements IEmployerService {

	@Autowired
	EmployerRepository employerRepository;

//	@Override
//	public List<Candidate> findByIsActive(boolean isActive) {
//
//		return candidateRepository.findByIsActive(isActive);
//	}

	@Override
	public List<Employer> findByCompanyNameContaining(String companyName) {

		return employerRepository.findByCompanyNameContaining(companyName);
	}

	@Override
	public List<Employer> findAll() {
		return employerRepository.findAll();
	}

	@Override
	public Optional<Employer> findById(long id) {
		return employerRepository.findById(id);
	}

	@Override
	public Employer save(Employer employer) {
		return employerRepository.save(employer);
	}

	@Override
	public void deleteById(long id) {
		employerRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		employerRepository.deleteAll();
	}

}
