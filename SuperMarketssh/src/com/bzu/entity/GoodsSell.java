package com.bzu.entity;

import java.sql.Timestamp;

/**
 * GoodsSell entity. @author MyEclipse Persistence Tools
 */

public class GoodsSell implements java.io.Serializable {

	// Fields

	private Integer id;
	private Goods goods;
	private Employer employer;
	private Integer number;
	private Timestamp sellDate;

	// Constructors

	/** default constructor */
	public GoodsSell() {
	}

	/** full constructor */
	public GoodsSell(Integer id, Goods goods, Employer employer,
			Integer number, Timestamp sellDate) {
		this.id = id;
		this.goods = goods;
		this.employer = employer;
		this.number = number;
		this.sellDate = sellDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Employer getEmployer() {
		return this.employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Timestamp getSellDate() {
		return this.sellDate;
	}

	public void setSellDate(Timestamp sellDate) {
		this.sellDate = sellDate;
	}

}