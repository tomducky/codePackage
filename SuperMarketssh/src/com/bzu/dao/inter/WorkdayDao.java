package com.bzu.dao.inter;

import java.util.List;

import com.bzu.entity.Employer;

public interface WorkdayDao {
	
	public void addWorkday(List<Employer> list);
	public List<Object> todayWorklist();
	public String monthWorkMap(String file);
	public int getWorkday(int employerId) ;

}
