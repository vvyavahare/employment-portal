package com.employment.portal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employment.portal.model.Job;
import com.employment.portal.service.IJobsService;

@RestController
@RequestMapping("/api")
public class JobsController {

	@Autowired
	IJobsService jobsService;

	@PostMapping("/jobs")
	public ResponseEntity<Job> addJob(@RequestBody Job job) {

		List<Job> jobs = new ArrayList<Job>();
		jobs.add(job);
		if (job.getEmployer() != null) {
			job.getEmployer().setJobs(jobs);
		}

		jobsService.save(job);
		return new ResponseEntity<>(job, HttpStatus.CREATED);
	}

	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable("id") long id) {
		Optional<Job> job = jobsService.findById(id);

		if (job.isPresent()) {
			return new ResponseEntity<>(job.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
