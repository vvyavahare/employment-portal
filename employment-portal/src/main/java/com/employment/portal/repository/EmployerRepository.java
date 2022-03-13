package com.employment.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employment.portal.model.Candidate;
import com.employment.portal.model.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {

	List<Employer> findByCompanyNameContaining(String companyName);
}
