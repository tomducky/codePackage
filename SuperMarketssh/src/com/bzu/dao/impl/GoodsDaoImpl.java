package com.bzu.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.bzu.dao.inter.GoodsDao;
import com.bzu.entity.Goods;

public class GoodsDaoImpl extends SuperDao implements GoodsDao {

	private SessionFactory osessionFactory;

	public SessionFactory getOsessionFactory() {
		return osessionFactory;
	}

	public void setOsessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void addGoods(Goods goods) {
		super.add(goods);

	}

	public List<Object> getAllGoods() {

		List<Object> list = new ArrayList<Object>();

		list = super.getAllObject(Goods.class, "");

		return list;
	}

	public List<Object> getByPage(int index, Class clazz, String hql) {
		// TODO Auto-generated method stub
		return super.selectPage(index, clazz, hql);
	}

	public List<Object> getAllBywhere(Class clazz, String hql) {

		return super.getAllObject(clazz, hql);
	}

	public void goodsDelete(Goods goods) {
		
		super.delete(goods);
	}

	public Goods getGoods(Class clazz, int id) {
		
		return (Goods) super.select(clazz, id);
	}

	public void UpdateGoods(Goods goods) {
		super.update(goods);
	}

	public void intoGoods(Goods goods) {

		
	}

	
}
