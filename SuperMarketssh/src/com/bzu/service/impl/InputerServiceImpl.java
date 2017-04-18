package com.bzu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bzu.dao.inter.InputerDao;
import com.bzu.entity.Goods;
import com.bzu.entity.GoodsSpend;
import com.bzu.entity.Inputer;
import com.bzu.service.inter.InputerService;

public class InputerServiceImpl implements InputerService {

	private InputerDao inputerDao;

	public InputerDao getInputerDao() {
		return inputerDao;
	}

	public void setInputerDao(InputerDao inputerDao) {
		this.inputerDao = inputerDao;
	}

	public Map<Integer, String> getAllInputer() {

		List<Object> list = inputerDao.getAllInputer();

		return this.obj2Map(list);
	}

	public List<Inputer> getInputerList() {

		List<Object> list = inputerDao.getAllInputer();
		return this.obj2SInputer(list);

	}
	
	public void addInputer(Inputer inputer){
		
		inputerDao.addInputer(inputer);
		
	}

	public List<Inputer> obj2SInputer(List<Object> list) {

		List<Inputer> elist = new ArrayList<Inputer>();
		for (Object obj : list) {

			Inputer em = (Inputer) obj;
			elist.add(em);
		}

		return elist;
	}

	public Map<Integer, String> obj2Map(List<Object> list) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Object obj : list) {

			Inputer inputer = (Inputer) obj;
			map.put(inputer.getId(), inputer.getName());
		}

		return map;
	}

	public Inputer getInputer(Class clazz, int id) {

		return inputerDao.getInputer(clazz, id);
	}
}
