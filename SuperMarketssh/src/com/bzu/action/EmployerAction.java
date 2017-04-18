package com.bzu.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bzu.entity.Employer;
import com.bzu.entity.Workday;
import com.bzu.service.inter.EmployerService;
import com.bzu.service.inter.WorkdayService;
import com.opensymphony.xwork2.ActionSupport;

public class EmployerAction extends ActionSupport {
	
	
	
	
	private int index;
	
	private Employer employer;
	
	private Double startMoney ;
	
	private Double endMoney;
	
	private List<Employer> list;
	
	
	public String emplyerList(){
		
		String hql="";
		if(employer!=null){
			String username = null;
			String adress=null;
			try {
				username = new String((employer.getUsername().getBytes("ISO8859-1")),"UTF-8");
				adress= new String((employer.getAdress().getBytes("ISO8859-1")),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		if(username!=null&&!("".equals(username)))
			hql+=" and s.username like '%"+username+"%'";
		if(adress!=null&&!("".equals(adress)))
			hql+=" and s.adress like '%"+adress+"%'";
		if(employer.getTelephone()!=null&&!("".equals(employer.getTelephone())))
			hql+=" and s.telephone = "+employer.getTelephone();
		if(startMoney!=null && endMoney!=null)
			hql+=" and s.monthpay between '"+startMoney+"' and '"+endMoney+"'";
		
		System.out.println(hql+"000000000000000000000000000000000"+employer.getUsername());
		}
		
		List<Employer> list = index != 0 ? employerService.getByPage(index, Employer.class,hql)
				:employerService.getByPage(1, Employer.class,hql);
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("list",list);
		session.setAttribute("thisindex",index==0?1:index);
		
		session.setAttribute("count",employerService.getAllEmployer(Employer.class,hql).size());
		System.out.println("0000"+list.size());
		return SUCCESS;
	}
	
	public String deleteEmployer(){
		
		employerService.deleteEmployer(employer);
		return "deletesuccess";
	}
	
	public String updateEmployerDialog(){
		
		Employer emp=employerService.getEmployer(Employer.class, employer.getId());
//		HttpSession session=ServletActionContext.getRequest().getSession();
//		session.setAttribute("emp",emp);
		ServletActionContext.getRequest().setAttribute("emp", emp);
		return "dilog";
	}
	
	public String updateEmployer() throws IOException{
		
		employer.setUsername(new String(employer.getUsername().getBytes("ISO8859-1"),"UTF-8"));
		employer.setAdress(new String(employer.getAdress().getBytes("ISO8859-1"),"UTF-8"));
		employerService.updateEmployer(employer);
		
		return "operasuccess";
	}
	
	public String addEmployer() throws IOException{
		
		employer.setUsername(new String(employer.getUsername().getBytes("ISO8859-1"),"UTF-8"));
		employer.setAdress(new String(employer.getAdress().getBytes("ISO8859-1"),"UTF-8"));
		
		employerService.addEmployer(employer);
		
		return "operasuccess";
	}
	public String workList(){
		
		
		this.emplyerList();
		
		return "worklist";
	}
	
	public String employerworks(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String[] ids=request.getParameterValues("ids");
		
	    list=new ArrayList<Employer>();
		for (int i = 0; i < ids.length; i++) {
			System.out.println(ids[i]);
			Employer em=employerService.getEmployer(Employer.class, Integer.parseInt(ids[i]));
			list.add(em);
		}
		workdayService.addWorkday(list);
		return "employerworks";
		
	}
	
	public String todayWorkView(){
		
		List<Workday> list = new ArrayList<Workday>();
		list=workdayService.todayWorklist();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("todayworklist",list);
		System.out.println(list.size());
		return "todayworklist";
		
	}
	
  	public String  monthWorkMap(){
  		String root = ServletActionContext.getRequest().getRealPath("/map/map.jpg");
  		
  		workdayService.monthWorkMap(root);
  		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("file","/map/map.jpg");
		System.out.println(session.getAttribute("file"));
  		return "workMap";
  	}
	
	
	
	
	
	
	
	
	
	
	
	private EmployerService employerService;
	                       
	private WorkdayService workdayService;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Double getStartMoney() {
		return startMoney;
	}


	public void setStartMoney(Double startMoney) {
		this.startMoney = startMoney;
	}


	public Double getEndMoney() {
		return endMoney;
	}

	public void setEndMoney(Double endMoney) {
		this.endMoney = endMoney;
	}


	public EmployerService getEmployerService() {
		return employerService;
	}











	public WorkdayService getWorkdayService() {
		return workdayService;
	}

	public void setWorkdayService(WorkdayService workdayService) {
		this.workdayService = workdayService;
	}

	public void setEmployerService(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	
	
	
	
}
