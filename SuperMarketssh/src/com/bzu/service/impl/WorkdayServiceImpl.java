package com.bzu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bzu.dao.inter.WorkdayDao;
import com.bzu.entity.Employer;
import com.bzu.entity.Workday;
import com.bzu.service.inter.WorkdayService;

public class WorkdayServiceImpl implements WorkdayService {
	
	private WorkdayDao workdayDao;
	
	public WorkdayDao getWorkdayDao() {
		return workdayDao;
	}

	public void setWorkdayDao(WorkdayDao workdayDao) {
		this.workdayDao = workdayDao;
	}

	public void addWorkday(List<Employer> list) {
		
		workdayDao.addWorkday(list);
		
	}

	public List<Workday> todayWorklist() {

		List<Workday> list = new ArrayList<Workday>();
		
		list=this.obj2Workday(workdayDao.todayWorklist());
		
		return list;
		
	}
	
	public String monthWorkMap(String file){
		
		return workdayDao.monthWorkMap(file);
		
	}
	public int getWorkday(int employerId) {

		return workdayDao.getWorkday(employerId);

	}
	
	
	
	
	
	
	
	
	public List<Workday> obj2Workday(List<Object> list) {

		List<Workday> elist = new ArrayList<Workday>();
		for (Object obj : list) {

			Workday em = (Workday) obj;
			elist.add(em);
		}

		return elist;
	}

	

}
