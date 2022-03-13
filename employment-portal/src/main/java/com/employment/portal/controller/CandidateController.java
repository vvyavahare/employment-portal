package com.employment.portal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employment.portal.model.Candidate;
import com.employment.portal.service.ICandidateService;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CandidateController {

	@Autowired
	ICandidateService candidateService;

	Logger logger = LoggerFactory.getLogger(CandidateController.class);

	@GetMapping("/candidates")
	public ResponseEntity<List<Candidate>> getAllCandidates(@RequestParam(required = false) String title) {
		logger.info("getting all candidates");
		try {
			List<Candidate> Candidates = new ArrayList<Candidate>();

			if (title == null)
				candidateService.findAll().forEach(Candidates::add);
			else
				candidateService.findByTitleContaining(title).forEach(Candidates::add);

			if (Candidates.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Candidates, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/candidates/{id}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") long id) {
		Optional<Candidate> CandidateData = candidateService.findById(id);

		if (CandidateData.isPresent()) {
			return new ResponseEntity<>(CandidateData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/candidates")
	public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
		try {
//			Candidate buildCandidate = Candidate.builder().setTitle(candidate.getTitle())
//					.setDescription(candidate.getDescription()).setPublished(candidate.isPublished()).build();

			Candidate savedCandidate = candidateService.save(candidate);
			return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/candidates/{id}")
	public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") long id, @RequestBody Candidate Candidate) {
		Optional<Candidate> CandidateData = candidateService.findById(id);

		if (CandidateData.isPresent()) {
			Candidate candidate = CandidateData.get();
			candidate.setTitle(Candidate.getTitle());
			candidate.setProfileDescription(Candidate.getProfileDescription());
			candidate.setIsActive(Candidate.isActive());
			return new ResponseEntity<>(candidateService.save(candidate), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/candidates/{id}")
	public ResponseEntity<HttpStatus> deleteCandidate(@PathVariable("id") long id) {
		try {
			candidateService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/candidates")
	public ResponseEntity<HttpStatus> deleteAllCandidates() {
		try {
			candidateService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/candidates/isActive")
	public ResponseEntity<List<Candidate>> findActiveCandidates() {
		try {
			List<Candidate> Candidates = candidateService.findByIsActive(true);

			if (Candidates.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Candidates, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
