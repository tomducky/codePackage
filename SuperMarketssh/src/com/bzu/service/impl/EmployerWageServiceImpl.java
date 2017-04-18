package com.bzu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bzu.dao.inter.IntoGoodsDao;
import com.bzu.entity.Employer;
import com.bzu.entity.EmployerWage;
import com.bzu.service.inter.EmployerWageService;

public class EmployerWageServiceImpl implements EmployerWageService {

	private IntoGoodsDao intoGoodsDao;

	public List<EmployerWage> getByPage(int index, Class clazz, String hql) {
		List<Object> list = intoGoodsDao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<EmployerWage> getAllEmployerWage(Class clazz, String hql) {
		List<Object> list = intoGoodsDao.getAllIntoGoods(EmployerWage.class,
				hql);
		return this.obj2Empl(list);
	}

	public Map<Integer, String> getAllEmployer(Class clazz, String hql) {

		List<Object> list = intoGoodsDao.getAllIntoGoods(Employer.class,
				hql);
		
		
		return this.obj2Map(list);
	}
	
	public Map<Integer, String> obj2Map(List<Object> list) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Object obj : list) {

			Employer employer = (Employer) obj;
			map.put(employer.getId(), employer.getUsername());
		}

		return map;
	}

	public List<EmployerWage> obj2Empl(List<Object> list) {

		List<EmployerWage> elist = new ArrayList<EmployerWage>();
		for (Object obj : list) {

			EmployerWage em = (EmployerWage) obj;
			elist.add(em);
		}

		return elist;
	}

	public void addempWage(EmployerWage employerWage) {
		
		intoGoodsDao.addIntoGoods(employerWage);
		
	}
	public Object getInfo(String hql) {
		// TODO Auto-generated method stub
		return intoGoodsDao.getInfo(hql);
	}
	
	
	public IntoGoodsDao getIntoGoodsDao() {
		return intoGoodsDao;
	}

	public void setIntoGoodsDao(IntoGoodsDao intoGoodsDao) {
		this.intoGoodsDao = intoGoodsDao;
	}

	

	
}
