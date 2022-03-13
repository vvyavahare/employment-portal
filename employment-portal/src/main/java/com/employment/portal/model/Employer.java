package com.employment.portal.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employer")
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "company_name")
	private String companyName;

	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Address> address;

	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Address> jobs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public List<Address> getJobs() {
		return jobs;
	}

	public void setJobs(List<Address> jobs) {
		this.jobs = jobs;
	}

}
