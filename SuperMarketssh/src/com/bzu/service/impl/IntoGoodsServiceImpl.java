package com.bzu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bzu.dao.inter.IntoGoodsDao;
import com.bzu.entity.Employer;
import com.bzu.entity.GoodsSpend;
import com.bzu.entity.IntoGoods;
import com.bzu.service.inter.IntoGoodsService;

public class IntoGoodsServiceImpl implements IntoGoodsService {

	private IntoGoodsDao intoGoodsDao;

	public void addIntoGoods(IntoGoods intoGoods) {

		intoGoodsDao.addIntoGoods(intoGoods);
	}

	public IntoGoodsDao getIntoGoodsDao() {
		return intoGoodsDao;
	}

	public void setIntoGoodsDao(IntoGoodsDao intoGoodsDao) {
		this.intoGoodsDao = intoGoodsDao;
	}

	public List<IntoGoods> getByPage(int index, Class clazz, String hql) {

		List<Object> list = intoGoodsDao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<IntoGoods> getAllIntoGoods(Class clazz, String hql) {
		// TODO Auto-generated method stub
		return this.obj2Empl(intoGoodsDao.getAllIntoGoods(clazz, hql));
	}

	public IntoGoods getIntoGoods(Class clazz, int id) {
		// TODO Auto-generated method stub
		return intoGoodsDao.getIntoGoods(clazz, id);
	}

	public List<GoodsSpend> getGoodsSpendList(Class clazz, String hql) {
		// TODO Auto-generated method stub
		return this.obj2Spend(intoGoodsDao.getAllIntoGoods(clazz, hql));
	}

	public List<IntoGoods> obj2Empl(List<Object> list) {

		List<IntoGoods> elist = new ArrayList<IntoGoods>();
		for (Object obj : list) {

			IntoGoods em = (IntoGoods) obj;
			elist.add(em);
		}

		return elist;
	}

	public List<GoodsSpend> obj2Spend(List<Object> list) {

		List<GoodsSpend> elist = new ArrayList<GoodsSpend>();
		for (Object obj : list) {

			GoodsSpend em = (GoodsSpend) obj;
			elist.add(em);
		}

		return elist;
	}

	public void deleteIntoGoods(IntoGoods intoGoods) {

		intoGoodsDao.deleteIntoGoods(intoGoods);
	}

	public void updateIntoGoods(IntoGoods intoGoods) {
		intoGoodsDao.updateIntoGoods(intoGoods);
	}

	public void addGoodsSpend(GoodsSpend goodsSpend) {

		intoGoodsDao.addGoodsSpend(goodsSpend);
	}

}
