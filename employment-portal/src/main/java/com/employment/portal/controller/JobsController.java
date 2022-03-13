package com.employment.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping
	@GetMapping("/jobs")
	public ResponseEntity<Job> addJob(@RequestBody Job job) {
		jobsService.save(job);
		return new ResponseEntity<>(job, HttpStatus.CREATED);
	}
}
