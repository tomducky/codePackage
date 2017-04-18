package com.bzu.service.inter;

import java.util.List;

import com.bzu.entity.Employer;


public interface EmployerService {
	
//	public Admin login(Admin admin);
//	public Serializable addAdmin(Admin admin);
//	public void updateAdmin(Admin admin);
	
	public List<Employer> getByPage(int index,Class clazz,String hql);
	public List<Employer> getAllEmployer(Class clazz,String hql);
	public void deleteEmployer(Employer em);
	public Employer getEmployer(Class clazz,int id);
	public void updateEmployer(Employer em);
	public void addEmployer(Employer em);
}
