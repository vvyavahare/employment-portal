package com.employment.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employment.portal.model.Employer;
import com.employment.portal.service.IEmployerService;

@RestController
@RequestMapping("/api")
public class EmployerController {

	@Autowired
	IEmployerService employerService;

	@PostMapping
	@RequestMapping("/employer")
	public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer) {
		employerService.save(employer);
		return new ResponseEntity<>(employer, HttpStatus.CREATED);
	}
}
