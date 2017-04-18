package com.bzu.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;

import com.bzu.dao.inter.AdminDao;
import com.bzu.entity.Admin;

public class AdminDaoImpl extends SuperDao implements AdminDao {
	
	private SessionFactory osessionFactory;
	
	
	public SessionFactory getOsessionFactory() {
		return osessionFactory;
	}


	public void setOsessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}


	public Admin select(Admin admin) {

		Admin adm=(Admin) super.check("from Admin a where a.username=? and a.password=?", 
				new String[]{admin.getUsername(),admin.getPassword()});
		return adm;
	}


	public Serializable add(Admin admin) {
		
		return  super.add(admin);
	}


	public void update(Admin admin) {
		super.update(admin);
	}
}
