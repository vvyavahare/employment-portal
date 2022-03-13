package com.employment.portal.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	@Column(name = "job_post_date")
	private LocalDateTime jobPostDate;

	@Column(name = "experience_range")
	private String experienceRange;

	@Column(name = "role")
	private String role;

	@Column(name = "skills_needed")
	private String skillsNeeded;

	@Column(name = "job_description")
	private String jobDescription;

	@JsonIgnore
	@ManyToOne(optional = true)
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	private Employer employer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExperienceRange() {
		return experienceRange;
	}

	public void setExperienceRange(String experienceRange) {
		this.experienceRange = experienceRange;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSkillsNeeded() {
		return skillsNeeded;
	}

	public void setSkillsNeeded(String skillsNeeded) {
		this.skillsNeeded = skillsNeeded;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public LocalDateTime getJobPostDate() {
		return jobPostDate;
	}

	public void setJobPostDate(LocalDateTime jobPostDate) {
		this.jobPostDate = jobPostDate;
	}

}
