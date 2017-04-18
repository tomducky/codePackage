package com.bzu.dao.inter;

import java.util.List;
import java.util.Map;

import com.bzu.entity.Goods;

public interface GoodsDao {

	
	public List<Object> getAllGoods();
	public void addGoods(Goods goods);
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllBywhere(Class clazz, String hql);
	
	public void goodsDelete(Goods goods);
	public Goods getGoods(Class clazz,int id);
	public void UpdateGoods(Goods goods) ;
	public void intoGoods(Goods goods);
	
	
}
