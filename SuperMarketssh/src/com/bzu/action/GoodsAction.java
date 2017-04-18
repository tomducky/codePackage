package com.bzu.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bzu.entity.Goods;
import com.bzu.entity.Inputer;
import com.bzu.service.inter.GoodsService;
import com.bzu.service.inter.InputerService;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport {

	private GoodsService goodsService;

	private InputerService inputerService;

	private int index;

	private Goods goods;
	private Double startMoney;

	private Double endMoney;
	
	private int inputerId;
	
	private Map<Integer,String> map;

	public String intoGoods() {

		return null;
	}

	public String goodsList() {

		String hql = "";
		if (goods != null) {
			String name = null;
			try {
				name = new String((goods.getName().getBytes("ISO8859-1")),
						"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (name != null && !("".equals(name)))
				hql += " and s.name like '%" + name + "%'";

			if (startMoney != null && endMoney != null)
				hql += " and s.inputPrise between '" + startMoney + "' and '"
						+ endMoney + "'";

		}

		List<Goods> list = new ArrayList<Goods>();
		list = index != 0 ? goodsService.getByPage(index, Goods.class, hql)
				: goodsService.getByPage(1, Goods.class, hql);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("goodslist", list);
		session.setAttribute("thisindex", index == 0 ? 1 : index);

		session.setAttribute("count", goodsService.getAllByWhere(Goods.class,
				hql).size());
		return "goodslist";
	}

	public String updateGoodsDialog() {
		Goods good =null;
		// HttpSession session=ServletActionContext.getRequest().getSession();
		// session.setAttribute("emp",emp);
		map = inputerService.getAllInputer();
		ServletActionContext.getRequest().getSession().setAttribute("map", map);
		if(goods!=null){
		good= goodsService.getGoods(Goods.class, goods.getId());
		ServletActionContext.getRequest().setAttribute("goods", good);
		return "dilog";
		}
		else
			return "addGoods";
	}

	public String goodsDelete() {

		goodsService.goodsDelete(goods);

		return "deletesuccess";

	}

	public String IntoGoods() {
		
		
		goodsService.goodsDelete(goods);

		return "deletesuccess";

	}
	
	
	public String updateGoods(){
		System.out.println("caoshenghuan ");
		System.out.println(goods==null);
		System.out.println(goods.getId());
		System.out.println(inputerId);
		if(goods.getId()==null){
			                                                          
			goods.setInputer(inputerService.getInputer(Inputer.class, inputerId));

			goodsService.addGoods(goods);
			
		}
		else{
		goods.setInputer(inputerService.getInputer(Inputer.class, inputerId));

		goodsService.UpdateGoods(goods);
		}
		
		return "operasuccess";
	}

	public InputerService getInputerService() {
		return inputerService;
	}

	public void setInputerService(InputerService inputerService) {
		this.inputerService = inputerService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
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

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	public int getInputerId() {
		return inputerId;
	}

	public void setInputerId(int inputerId) {
		this.inputerId = inputerId;
	}
	

}
