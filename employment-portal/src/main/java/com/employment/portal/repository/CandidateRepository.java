package com.employment.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employment.portal.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	List<Candidate> findByIsActive(boolean isActive);

	List<Candidate> findByTitleContaining(String title);
}
