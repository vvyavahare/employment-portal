package com.employment.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employment.portal.model.Employer;
import com.employment.portal.model.Job;
import com.employment.portal.repository.EmployerRepository;
import com.employment.portal.repository.JobsRepository;

@Service
public class JobsService implements IJobsService {

	@Autowired
	JobsRepository jobsRepository;

//	@Override
//	public List<Candidate> findByIsActive(boolean isActive) {
//
//		return candidateRepository.findByIsActive(isActive);
//	}

	@Override
	public List<Job> findByRoleContaining(String role) {

		return jobsRepository.findByRoleContaining(role);
	}

	@Override
	public List<Job> findAll() {
		return jobsRepository.findAll();
	}

	@Override
	public Optional<Job> findById(long id) {
		return jobsRepository.findById(id);
	}

	@Override
	public Job save(Job job) {
		return jobsRepository.save(job);
	}

	@Override
	public void deleteById(long id) {
		jobsRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		jobsRepository.deleteAll();
	}

}
