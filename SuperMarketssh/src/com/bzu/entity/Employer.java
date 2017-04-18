package com.bzu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Employer entity. @author MyEclipse Persistence Tools
 */

public class Employer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String adress;
	private String telephone;
	private Double monthpay;
	private Set<EmployerWage> employerWages = new HashSet<EmployerWage>(0);
	private Set<Workday> workdaies = new HashSet<Workday>(0);
	private Set<GoodsSell> goodsSells = new HashSet<GoodsSell>(0);

	// Constructors

	/** default constructor */
	public Employer() {
	}

	/** minimal constructor */
	public Employer(Integer id, String username, String password,
			Double monthpay) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.monthpay = monthpay;
	}

	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Double getMonthpay() {
		return this.monthpay;
	}

	public void setMonthpay(Double monthpay) {
		this.monthpay = monthpay;
	}

	public Set<EmployerWage> getEmployerWages() {
		return employerWages;
	}

	public void setEmployerWages(Set<EmployerWage> employerWages) {
		this.employerWages = employerWages;
	}

	public Set<Workday> getWorkdaies() {
		return workdaies;
	}

	public void setWorkdaies(Set<Workday> workdaies) {
		this.workdaies = workdaies;
	}

	public Set<GoodsSell> getGoodsSells() {
		return goodsSells;
	}

	public void setGoodsSells(Set<GoodsSell> goodsSells) {
		this.goodsSells = goodsSells;
	}

	
}