package com.bzu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bzu.dao.inter.GoodsDao;
import com.bzu.entity.Employer;
import com.bzu.entity.Goods;
import com.bzu.entity.Inputer;
import com.bzu.service.inter.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	private GoodsDao goodsDao;

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public List<Goods> goodsList() {

		return this.obj2Goods(goodsDao.getAllGoods());
	}

	public void addGoods(Goods goods) {

		goodsDao.addGoods(goods);
	}
	
	public List<Goods> getByPage(int index, Class clazz, String hql) {
		// TODO Auto-generated method stub
		return this.obj2Goods(goodsDao.getByPage(index, clazz, hql));
	}
	public List<Goods> getAllByWhere(Class clazz, String hql) {
		// TODO Auto-generated method stub
		return this.obj2Goods(goodsDao.getAllBywhere(clazz, hql));
	}

	
	public void goodsDelete(Goods goods) {
		goodsDao.goodsDelete(goods);		
	}
	
	public Goods getGoods(Class clazz,int id){
		
		return goodsDao.getGoods(clazz, id);
		
	}
	public void UpdateGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.UpdateGoods(goods);
	}
	public Map<Integer, String> getAllGoods() {
		List<Object> list=goodsDao.getAllGoods();
		Map<Integer, String> map=this.obj2Map(list);
		return map;
	}
	


	public Map<Integer, String> obj2Map(List<Object> list) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Object obj : list) {

			Goods goods = (Goods) obj;
			map.put(goods.getId(), goods.getName());
		}

		return map;
	}
	
	
	
	public List<Goods> obj2Goods(List<Object> list) {

		List<Goods> elist = new ArrayList<Goods>();
		for (Object obj : list) {

			Goods em = (Goods) obj;
			elist.add(em);
		}

		return elist;
	}

	

	

	

	

}
