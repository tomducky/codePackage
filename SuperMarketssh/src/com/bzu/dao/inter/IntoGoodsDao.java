package com.bzu.dao.inter;

import java.util.List;

import com.bzu.entity.GoodsSpend;
import com.bzu.entity.IntoGoods;

public interface IntoGoodsDao {

	public void addIntoGoods(Object intoGoods);

	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllIntoGoods(Class clazz, String hql);
	public IntoGoods getIntoGoods(Class clazz, int id);
	public void deleteIntoGoods(IntoGoods intoGoods);
	
	public void updateIntoGoods(IntoGoods intoGoods) ;
	
	public Object getInfo(String hql);
	
	public void addGoodsSpend(GoodsSpend goodsSpend);
	
	public List<Object> getGoodsSpendList(Class clazz,String hql);
}
