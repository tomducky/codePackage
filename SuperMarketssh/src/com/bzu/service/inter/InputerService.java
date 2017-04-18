package com.bzu.service.inter;

import java.util.List;
import java.util.Map;

import com.bzu.entity.Inputer;

public interface InputerService {
	
	public Map<Integer,String> getAllInputer();
	
	public Inputer getInputer(Class clazz,int id);
	
	public List<Inputer> getInputerList();
	
	public void addInputer(Inputer inputer);

}
