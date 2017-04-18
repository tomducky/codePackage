package com.bzu.service.inter;

import java.util.List;
import java.util.Map;

import com.bzu.entity.EmployerWage;

public interface EmployerWageService {

	public List<EmployerWage> getByPage(int index, Class clazz, String hql);
	
	public List<EmployerWage> getAllEmployerWage(Class clazz, String hql);
	
	public Map<Integer,String> getAllEmployer(Class clazz, String hql);
	
	public void addempWage(EmployerWage employerWage);
	
	public Object getInfo(String hql);
}
