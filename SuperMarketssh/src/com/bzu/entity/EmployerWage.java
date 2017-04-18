package com.bzu.entity;

/**
 * EmployerWage entity. @author MyEclipse Persistence Tools
 */

public class EmployerWage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Employer employer;
	private String months;
	private Integer wage;

	// Constructors

	/** default constructor */
	public EmployerWage() {
	}

	/** full constructor */
	public EmployerWage( Employer employer, String months,
			Integer wage) {
		this.employer = employer;
		this.months = months;
		this.wage = wage;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employer getEmployer() {
		return this.employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getMonths() {
		return this.months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public Integer getWage() {
		return this.wage;
	}

	public void setWage(Integer wage) {
		this.wage = wage;
	}

}