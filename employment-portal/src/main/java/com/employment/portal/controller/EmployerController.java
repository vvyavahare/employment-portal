package com.employment.portal.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employment.portal.model.Address;
import com.employment.portal.model.Candidate;
import com.employment.portal.model.Employer;
import com.employment.portal.model.Job;
import com.employment.portal.service.IEmployerService;

@RestController
@RequestMapping("/api")
public class EmployerController {

	@Autowired
	IEmployerService employerService;

	@PostMapping
	@RequestMapping("/employer")
	public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer) {
		Set<Address> addresses = new HashSet<Address>();
		List<Job> jobs = new ArrayList<Job>();
		for (Address address : employer.getAddress()) {
			address.setEmployer(employer);
			addresses.add(address);
		}

		if (employer.getJobs() != null) {
			for (Job job : employer.getJobs()) {
				job.setEmployer(employer);
				jobs.add(job);
			}
		}
		employerService.save(employer);
		return new ResponseEntity<>(employer, HttpStatus.CREATED);
	}

	@GetMapping("/employer/{id}")
	public ResponseEntity<Employer> getEmployerById(@PathVariable("id") long id) {
		Optional<Employer> employer = employerService.findById(id);

		if (employer.isPresent()) {
			return new ResponseEntity<>(employer.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/employer/{id}")
	public ResponseEntity<Employer> updateEmployer(@PathVariable("id") long id, @RequestBody Employer employer) {
		Optional<Employer> employerData = employerService.findById(id);

		if (employerData.isPresent()) {
			// Candidate candidateFromDB = candidateData.get();
			Set<Address> addresses = new HashSet<Address>();
			List<Job> jobs = new ArrayList<Job>();
			for (Address address : employer.getAddress()) {
				address.setEmployer(employer);
				addresses.add(address);
			}

			if (employer.getJobs() != null) {
				for (Job job : employer.getJobs()) {
					job.setEmployer(employer);
					jobs.add(job);
				}
			}
			return new ResponseEntity<>(employerService.save(employer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
