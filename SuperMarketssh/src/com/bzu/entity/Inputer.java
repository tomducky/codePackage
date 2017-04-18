package com.bzu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Inputer entity. @author MyEclipse Persistence Tools
 */

public class Inputer implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set<Goods> goodses = new HashSet<Goods>(0);

	// Constructors

	/** default constructor */
	public Inputer() {
	}

	/** minimal constructor */
	public Inputer(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Goods> getGoodses() {
		return goodses;
	}

	public void setGoodses(Set<Goods> goodses) {
		this.goodses = goodses;
	}



}