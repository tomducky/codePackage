package com.bzu.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer id;
	private Inputer inputer;
	private String name;
	private Double inputPrise;
	private Double outputPrise;
	private Integer remainNum;
	private Set<IntoGoods> intoGoodses = new HashSet<IntoGoods>(0);
	private Set<GoodsSpend> goodsSpends = new HashSet<GoodsSpend>(0);
	private Set<GoodsSell> goodsSells = new HashSet<GoodsSell>(0);

	// Constructors

	/** default constructor */
	
	
	public Goods() {
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", inputPrise=" + inputPrise + ", inputer="
				+ inputer + ", name=" + name + ", outputPrise=" + outputPrise
				+ ", remainNum=" + remainNum + "]";
	}

	/** minimal constructor */
	public Goods(Integer id, Inputer inputer, String name, Double inputPrise,
			Double outputPrise) {
		this.id = id;
		this.inputer = inputer;
		this.name = name;
		this.inputPrise = inputPrise;
		this.outputPrise = outputPrise;
	}

	

	// Property accessors

	public Integer getRemainNum() {
		return remainNum;
	}

	public void setRemainNum(Integer remainNum) {
		this.remainNum = remainNum;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Inputer getInputer() {
		return this.inputer;
	}

	public void setInputer(Inputer inputer) {
		this.inputer = inputer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getInputPrise() {
		return this.inputPrise;
	}

	public void setInputPrise(Double inputPrise) {
		this.inputPrise = inputPrise;
	}

	public Double getOutputPrise() {
		return this.outputPrise;
	}

	public void setOutputPrise(Double outputPrise) {
		this.outputPrise = outputPrise;
	}

	public Set<IntoGoods> getIntoGoodses() {
		return intoGoodses;
	}

	public void setIntoGoodses(Set<IntoGoods> intoGoodses) {
		this.intoGoodses = intoGoodses;
	}

	public Set<GoodsSpend> getGoodsSpends() {
		return goodsSpends;
	}

	public void setGoodsSpends(Set<GoodsSpend> goodsSpends) {
		this.goodsSpends = goodsSpends;
	}

	public Set<GoodsSell> getGoodsSells() {
		return goodsSells;
	}

	public void setGoodsSells(Set<GoodsSell> goodsSells) {
		this.goodsSells = goodsSells;
	}

	

}