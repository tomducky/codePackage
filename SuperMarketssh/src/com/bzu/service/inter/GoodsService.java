package com.bzu.service.inter;

import java.util.List;
import java.util.Map;

import com.bzu.entity.Employer;
import com.bzu.entity.Goods;

public interface GoodsService {
	
	public List<Goods> goodsList();
	public void addGoods(Goods goods);
	public List<Goods> getByPage(int index,Class clazz,String hql);
	public List<Goods> getAllByWhere(Class clazz, String hql) ;
	public void goodsDelete(Goods goods);
	public Goods getGoods(Class clazz,int id);
	public void UpdateGoods(Goods goods);
	public Map<Integer,String> getAllGoods();

}
