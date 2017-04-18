package com.bzu.service.impl;

////2528728029
import java.util.ArrayList;
import java.util.List;

import com.bzu.dao.impl.EmployerDaoImpl;
import com.bzu.dao.inter.EmployerDao;
import com.bzu.entity.Employer;
import com.bzu.service.inter.EmployerService;

public class EmployerServiceImpl implements EmployerService {

	private EmployerDao employerDao;

	public EmployerDao getEmployerDao() {
		return employerDao;
	}

	public void setEmployerDao(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	public List<Employer> getByPage(int index, Class clazz, String hql) {

		List<Object> list = employerDao.getByPage(index, clazz, hql);
		return this.obj2Empl(list);
	}

	public List<Employer> getAllEmployer(Class clazz, String hql) {
		// TODO Auto-generated method stub
		return this.obj2Empl(employerDao.getAllEmployer(clazz, hql));
	}

	public void deleteEmployer(Employer em) {

		employerDao.deleteEmployer(em);

	}
	
	public Employer getEmployer(Class clazz,int id) {
		// TODO Auto-generated method stub
		return employerDao.getEmployer(clazz, id);
	}
	public void updateEmployer(Employer em){
		
		employerDao.updateEmployer(em);
		
	}
	public void addEmployer(Employer em){
		
		employerDao.addEmployer(em);
	}

	//
	// public Admin login(Admin admin) {
	//		
	// return adminDao.select(admin);
	// }
	//
	// public Serializable addAdmin(Admin admin) {
	//		
	// return adminDao.add(admin);
	// }
	//
	// public void updateAdmin(Admin admin) {
	// adminDao.update(admin);
	// }

	public List<Employer> obj2Empl(List<Object> list) {

		List<Employer> elist = new ArrayList<Employer>();
		for (Object obj : list) {

			Employer em = (Employer) obj;
			elist.add(em);
		}

		return elist;
	}

	

}
