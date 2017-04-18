package com.bzu.service.inter;

import java.util.List;
import java.util.Map;

import com.bzu.entity.GoodsSpend;
import com.bzu.entity.IntoGoods;

public interface IntoGoodsService {
	
	public void addIntoGoods(IntoGoods intoGoods);
	public List<IntoGoods> getByPage(int index, Class clazz, String hql);
	public List<IntoGoods> getAllIntoGoods(Class  clazz,
			String hql);
	
	public IntoGoods getIntoGoods(Class clazz,int id);

	public void deleteIntoGoods(IntoGoods intoGoods);
	
	public void updateIntoGoods(IntoGoods intoGoods);
	
	public void addGoodsSpend(GoodsSpend goodsSpend);
	
	public List<GoodsSpend> getGoodsSpendList(Class clazz,String hql);
	
}
