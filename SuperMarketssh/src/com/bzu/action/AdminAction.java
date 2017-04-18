package com.bzu.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bzu.entity.Admin;
import com.bzu.service.inter.AdminService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	private AdminService adminService;
	

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String login() {

		Admin adm = adminService.login(admin);
		HttpSession session=ServletActionContext.getRequest().getSession();

		if (adm != null){
			session.setAttribute("admin_info", adm);
			return "loginsuccess";
		}

		return INPUT;
	}
	public String addAdmin(){
		
		adminService.addAdmin(admin);
		
		return SUCCESS;
	}
	
	public String updateAdmin(){
		
		adminService.updateAdmin(admin);
		
		return SUCCESS;
	}
}
