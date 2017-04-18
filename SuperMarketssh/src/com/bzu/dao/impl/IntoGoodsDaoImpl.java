package com.bzu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bzu.dao.inter.IntoGoodsDao;
import com.bzu.entity.GoodsSpend;
import com.bzu.entity.IntoGoods;

public class IntoGoodsDaoImpl extends SuperDao implements IntoGoodsDao {

	private SessionFactory osessionFactory;

	public SessionFactory getOsessionFactory() {
		return osessionFactory;
	}

	public void setOsessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void addIntoGoods(Object intoGoods) {

		super.add(intoGoods);

	}

	public List<Object> getByPage(int index, Class clazz, String hql) {
		// TODO Auto-generated method stub
		return super.selectPage(index, clazz, hql);
	}
	

	public List<Object> getAllIntoGoods(Class clazz, String hql) {
		
		return super.getAllObject(clazz, hql);
		
	}

	public IntoGoods getIntoGoods(Class clazz, int id) {
		
		return (IntoGoods) super.select(clazz, id);
	}

	public void deleteIntoGoods(IntoGoods intoGoods) {

		super.delete(intoGoods);
	}

	public void updateIntoGoods(IntoGoods intoGoods) {
		super.update(intoGoods);
	}

	public Object getInfo(String hql) {
		
		return super.find(hql);
	}

	public void addGoodsSpend(GoodsSpend goodsSpend) {
		super.add(goodsSpend);
		
	}

	public List<Object> getGoodsSpendList(Class clazz,String hql) {
		
		return super.getAllObject(clazz, hql);
	}

}
