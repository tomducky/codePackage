package com.bzu.dao.inter;

import java.io.Serializable;

import com.bzu.entity.Admin;

public interface AdminDao {
	
	public Admin select(Admin admin);
	public Serializable add(Admin admin);
	public void update(Admin admin);

}
