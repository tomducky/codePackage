package com.bzu.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Workday entity. @author MyEclipse Persistence Tools
 */

public class Workday implements java.io.Serializable {

	// Fields

	private Integer id;
	private Employer employer;
	private String workday;
	private Double addwork;

	// Constructors

	/** default constructor */
	public Workday() {
	}

	
	/** full constructor */
	public Workday( Employer employer, 
			String workday, Double addwork) {
		this.employer = employer;
		this.workday = workday;
		this.addwork = addwork;
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


	public String getWorkday() {
		return this.workday;
	}

	public void setWorkday(String workday) {
		this.workday = workday;
	}

	public Double getAddwork() {
		return this.addwork;
	}

	public void setAddwork(Double addwork) {
		this.addwork = addwork;
	}

}