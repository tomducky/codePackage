package com.bzu.dao.inter;

import java.io.Serializable;
import java.util.List;

import com.bzu.entity.Admin;
import com.bzu.entity.Employer;

public interface EmployerDao {
	
	
	public List<Object> getByPage(int index, Class clazz, String hql);
	public List<Object> getAllEmployer(Class clazz,String hql);

	public void deleteEmployer(Employer em);
	
	public Employer getEmployer(Class clazz,int id);
	public void updateEmployer(Employer em);
	public void addEmployer(Employer em);
//	public Admin select(Admin admin);
//	public Serializable add(Admin admin);
//	public void update(Admin admin);
	
	

}
