package com.bzu.service.inter;

import java.util.List;

import com.bzu.entity.Employer;
import com.bzu.entity.Workday;

public interface WorkdayService {
	
	public void addWorkday(List<Employer> list);
	public List<Workday> todayWorklist();
	public String monthWorkMap(String file);
	
	public int getWorkday(int employerId);

}
