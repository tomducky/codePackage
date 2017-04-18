package com.bzu.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.bzu.dao.inter.InputerDao;
import com.bzu.entity.Inputer;

public class InputerDaoImpl extends SuperDao implements InputerDao {
	
	private SessionFactory osessionFactory;

	public SessionFactory getOsessionFactory() {
		return osessionFactory;
	}

	public void setOsessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public List<Object> getAllInputer() {
		
		List<Object> list=super.getAllObject(Inputer.class, "");
		
		return list;
	}

	public Inputer getInputer(Class clazz, int id) {
		
		return (Inputer) super.select(clazz, id);
	}

	public void addInputer(Inputer inputer) {
		super.add(inputer);
	}

	

}
