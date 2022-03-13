package com.employment.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employment.portal.model.Candidate;
import com.employment.portal.repository.CandidateRepository;

@Service
public class CandidateService implements ICandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	@Override
	public List<Candidate> findByIsActive(boolean isActive) {

		return candidateRepository.findByIsActive(isActive);
	}

	@Override
	public List<Candidate> findByTitleContaining(String title) {

		return candidateRepository.findByTitleContaining(title);
	}

	@Override
	public List<Candidate> findAll() {
		return candidateRepository.findAll();
	}

	@Override
	public Optional<Candidate> findById(long id) {
		return candidateRepository.findById(id);
	}

	@Override
	public Candidate save(Candidate candidate) {
		return candidateRepository.save(candidate);
	}

	@Override
	public void deleteById(long id) {
		candidateRepository.deleteById(id);
	}

	@Override
	public void deleteAll() {
		candidateRepository.deleteAll();
	}

}
