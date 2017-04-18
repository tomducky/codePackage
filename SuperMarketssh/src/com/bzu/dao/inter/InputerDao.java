package com.bzu.dao.inter;

import java.util.List;
import java.util.Map;

import com.bzu.entity.Inputer;

public interface InputerDao {

	public List<Object> getAllInputer();
	public Inputer getInputer(Class clazz, int id);
	public void addInputer(Inputer inputer);
}
