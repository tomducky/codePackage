package com.bzu.entity;

import java.sql.Timestamp;

/**
 * IntoGoods entity. @author MyEclipse Persistence Tools
 */

public class IntoGoods implements java.io.Serializable {

	// Fields

	private Integer id;
	private Goods goods;
	private Timestamp intoDate;
	private Integer num;

	// Constructors

	/** default constructor */
	public IntoGoods() {
	}

	/** minimal constructor */
	public IntoGoods(Integer id, Goods goods) {
		this.id = id;
		this.goods = goods;
	}

	/** full constructor */
	public IntoGoods(Integer id, Goods goods, Timestamp intoDate) {
		this.id = id;
		this.goods = goods;
		this.intoDate = intoDate;
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

	public Timestamp getIntoDate() {
		return this.intoDate;
	}

	public void setIntoDate(Timestamp intoDate) {
		this.intoDate = intoDate;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}