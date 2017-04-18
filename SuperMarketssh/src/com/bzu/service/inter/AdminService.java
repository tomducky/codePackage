package com.bzu.service.inter;

import java.io.Serializable;

import com.bzu.entity.Admin;

public interface AdminService {
	
	public Admin login(Admin admin);
	public Serializable addAdmin(Admin admin);
	public void updateAdmin(Admin admin);

}
