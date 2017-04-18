package com.bzu.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bzu.entity.Inputer;
import com.bzu.service.inter.InputerService;
import com.opensymphony.xwork2.ActionSupport;

public class InputerAction extends ActionSupport {
	
	private Inputer inputer;

	private InputerService inputerService;

	public String inputerList() {

		List<Inputer> list=inputerService.getInputerList();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("inputerlist", list);
		return "inputerlist";
	}
	
	public String addInputer() throws Exception{
		
		inputer.setName(new String(inputer.getName().getBytes("ISO8859-1"),"utf-8"));
		inputerService.addInputer(inputer);
		
		return "operasuccess";
	}
	
	public String updateInputerDialog(){
		
		Inputer inpu=inputerService.getInputer(Inputer.class, inputer.getId());
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("inputer", inpu);
		
		return "dilog";
		
	}
	
	
	
	

	public Inputer getInputer() {
		return inputer;
	}

	public void setInputer(Inputer inputer) {
		this.inputer = inputer;
	}

	public InputerService getInputerService() {
		return inputerService;
	}

	public void setInputerService(InputerService inputerService) {
		this.inputerService = inputerService;
	}

}
