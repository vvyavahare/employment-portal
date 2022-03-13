package com.employment.portal.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "job_post_date")
	private Instant jonPostDate;

	@Column(name = "experience_range")
	private Instant experienceRange;

	@Column(name = "role")
	private String role;

	@Column(name = "skills_needed")
	private String skillsNeeded;

	@Column(name = "job_description")
	private String jobDescription;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "address_id", nullable = false)
	private Employer employer;
}
