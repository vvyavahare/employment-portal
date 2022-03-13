package com.employment.portal.service;

import java.util.List;
import java.util.Optional;

import com.employment.portal.model.Employer;
import com.employment.portal.model.Job;

public interface IJobsService {

	List<Job> findByRoleContaining(String companyName);

	List<Job> findAll();

	Optional<Job> findById(long id);

	Job save(Job candidate);

	void deleteById(long id);

	void deleteAll();

}
