package com.employment.portal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employment.portal.model.Candidate;

public interface ICandidateService {

	List<Candidate> findByIsActive(boolean isActive);

	List<Candidate> findByTitleContaining(String title);

	List<Candidate> findAll();

	Optional<Candidate> findById(long id);

	Candidate save(Candidate candidate);

	void deleteById(long id);

	void deleteAll();
}
