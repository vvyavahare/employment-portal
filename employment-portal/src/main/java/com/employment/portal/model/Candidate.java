package com.employment.portal.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "profile_description")
	private String profileDescription;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "experience")
	private double yearsOfExperience;

	@Column(name = "phone_no")
	private String phoneNo;

	@Column(name = "email_id")
	private String emailId;

	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Address> address;

	public Candidate() {
	}

	public static CandidateBuilder builder() {
		return new CandidateBuilder();
	}

	public Candidate(long id, String title, String profileDescription, boolean isActive, String firstName,
			String lastName, double yearsOfExperience, String phoneNo, String emailId) {
		super();
		this.id = id;
		this.title = title;
		this.profileDescription = profileDescription;
		this.isActive = isActive;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsOfExperience = yearsOfExperience;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setYearsOfExperience(double yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getYearsOfExperience() {
		return yearsOfExperience;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static class CandidateBuilder {
		private long id;
		private String title;
		private String profileDescription;
		private boolean isActive;
		private String firstName;
		private String lastName;
		private double yearsOfExperience;
		private String phoneNo;
		private String emailId;

		public CandidateBuilder setId(long id) {
			this.id = id;
			return this;
		}

		public CandidateBuilder setTitle(String title) {
			this.title = title;
			return this;
		}

		public CandidateBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public CandidateBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public CandidateBuilder setYearsOfExperience(double yearsOfExperience) {
			this.yearsOfExperience = yearsOfExperience;
			return this;
		}

		public CandidateBuilder setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
			return this;
		}

		public CandidateBuilder setEmailId(String emailId) {
			this.emailId = emailId;
			return this;
		}

		public CandidateBuilder setProfileDescription(String profileDescription) {
			this.profileDescription = profileDescription;
			return this;
		}

		public CandidateBuilder setIsActive(boolean isActive) {
			this.isActive = isActive;
			return this;
		}

		public Candidate build() {

			return new Candidate(id, title, profileDescription, isActive, firstName, lastName, yearsOfExperience,
					phoneNo, emailId);
		}

	}
}
