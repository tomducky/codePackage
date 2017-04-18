package com.bzu.service.impl;

import java.io.Serializable;

import com.bzu.dao.inter.AdminDao;
import com.bzu.entity.Admin;
import com.bzu.service.inter.AdminService;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao;
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public Admin login(Admin admin) {
		
		return adminDao.select(admin);
	}

	public Serializable addAdmin(Admin admin) {
		
		return adminDao.add(admin);
	}

	public void updateAdmin(Admin admin) {
		adminDao.update(admin);
	}

}
