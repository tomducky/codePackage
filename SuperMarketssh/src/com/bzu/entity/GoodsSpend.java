package com.bzu.entity;

/**
 * GoodsSpend entity. @author MyEclipse Persistence Tools
 */

public class GoodsSpend implements java.io.Serializable {

	// Fields

	private Integer id;
	private IntoGoods intoGoods;
	private Double spendMoney;

	// Constructors

	/** default constructor */
	public GoodsSpend() {
	}

	/** full constructor */
	public GoodsSpend( IntoGoods intoGoods, Double spendMoney) {
		this.intoGoods = intoGoods;
		this.spendMoney = spendMoney;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IntoGoods getIntoGoods() {
		return this.intoGoods;
	}

	public void setIntoGoods(IntoGoods intoGoods) {
		this.intoGoods = intoGoods;
	}

	public Double getSpendMoney() {
		return this.spendMoney;
	}

	public void setSpendMoney(Double spendMoney) {
		this.spendMoney = spendMoney;
	}

}