package com.bzu.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.bzu.dao.inter.EmployerDao;
import com.bzu.entity.Employer;

public class EmployerDaoImpl extends SuperDao implements EmployerDao {
	
	private SessionFactory osessionFactory;
	
	
	public SessionFactory getOsessionFactory() {
		return osessionFactory;
	}


	public void setOsessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}


	public List<Object> getByPage(int index, Class clazz, String hql) {
		// TODO Auto-generated method stub
		return super.selectPage(index, clazz, hql);
	}


	public List<Object> getAllEmployer(Class clazz,String hql) {
		
		return super.getAllObject(clazz,hql);
	}


	public void deleteEmployer(Employer em) {

		super.delete(em);
		
	}
	public Employer getEmployer(Class clazz,int id) {
		// TODO Auto-generated method stub
		return (Employer) super.select(clazz, id);
	}
	public void updateEmployer(Employer em){
		
		super.update(em);
		
	}
	
	public void addEmployer(Employer em){
		
		super.add(em);
	}

//	public Admin select(Admin admin) {
//
//		Admin adm=(Admin) super.check("from Admin a where a.username=? and a.password=?", 
//				new String[]{admin.getUsername(),admin.getPassword()});
//		return adm;
//	}
//
//
//	public Serializable add(Admin admin) {
//		
//		return  super.add(admin);
//	}
//
//
//	public void update(Admin admin) {
//		super.update(admin);
//	}
}
