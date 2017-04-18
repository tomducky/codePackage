package com.bzu.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bzu.entity.Goods;
import com.bzu.entity.IntoGoods;
import com.bzu.service.inter.EmployerService;
import com.bzu.service.inter.GoodsService;
import com.bzu.service.inter.IntoGoodsService;
import com.opensymphony.xwork2.ActionSupport;

public class IntoGoodsAction extends ActionSupport {

	private GoodsService goodsService;

	private IntoGoodsService intoGoodsService;

	private EmployerService employerService;

	private IntoGoods intoGoods;

	private int index;

	private String beginDate;

	private String endDate;

	public String addIntoGoodsView() {
		
		Map<Integer, String> map = goodsService.getAllGoods();
		// HttpSession session=ServletActionContext.getRequest().getSession();
		ServletActionContext.getRequest().setAttribute("map", map);
		System.out.println(map.size());

		return "addIntoGoods";
	}

	public String addIntoGoods() {

		Goods good = goodsService.getGoods(Goods.class, intoGoods.getGoods()
				.getId());

		good.setRemainNum(good.getRemainNum() + intoGoods.getNum());

		goodsService.UpdateGoods(good);

		// goodsService.

		intoGoodsService.addIntoGoods(intoGoods);

		return "operasuccess";
	}

	public String intoGoodsList() {

		String hql = "";
		if (intoGoods != null) {

			if (intoGoods.getGoods() != null)
				hql += " and s.goods.id = " + intoGoods.getGoods().getId();

			if (beginDate != null && endDate != null && !("".equals(beginDate))
					&& !("".equals(endDate)))
				hql += " and s.intoDate between '" + beginDate + "' and '"
						+ endDate + "'";
		}

		List<IntoGoods> list = index != 0 ? intoGoodsService.getByPage(index,
				IntoGoods.class, hql) : intoGoodsService.getByPage(1,
				IntoGoods.class, hql);

		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		session.setAttribute("thisindex", index == 0 ? 1 : index);

		session.setAttribute("count", intoGoodsService.getAllIntoGoods(
				IntoGoods.class, hql).size());

		Map<Integer, String> map = goodsService.getAllGoods();
		ServletActionContext.getRequest().setAttribute("map", map);
		return "intoGoodsList";
	}

	public String deleteIntoGood() {
		
		IntoGoods intoGood=intoGoodsService.getIntoGoods(IntoGoods.class, intoGoods.getId());

		Goods good = goodsService.getGoods(Goods.class, intoGood.getGoods()
				.getId());

		good.setRemainNum(good.getRemainNum() - intoGood.getNum());
		goodsService.UpdateGoods(good);
		intoGoodsService.deleteIntoGoods(intoGood);
		
		return "deletesuccess";

	}

	public String updateIntoGoodsDialog(){
		
		
		IntoGoods intoGood=null;
		if(intoGoods!=null)
			intoGood=intoGoodsService.getIntoGoods(IntoGoods.class, intoGoods.getId());
		
		Map<Integer, String> map = goodsService.getAllGoods();
		// HttpSession session=ServletActionContext.getRequest().getSession();
		ServletActionContext.getRequest().setAttribute("map", map);
		ServletActionContext.getRequest().setAttribute("intoGoods", intoGood);

		return "dialog";
		
	}
	public String updateIntoGoods(){
		
		System.out.println("1");
		
		IntoGoods intoGood=intoGoodsService.getIntoGoods(IntoGoods.class, intoGoods.getId());//原来的进货信息
		System.out.println("2");
		Goods good = goodsService.getGoods(Goods.class, intoGood.getGoods()//原来的货物信息
				.getId());
		System.out.println("3");
		if(good.getId()==intoGoods.getGoods().getId()){//如果原来的进货和修改后的进货是同一种货物,修改货物剩余为：货物剩余-货物原来添加的+现在修改后的添加的
			System.out.println("4");
			good.setRemainNum(good.getRemainNum() - intoGood.getNum()+intoGoods.getNum());
			goodsService.UpdateGoods(good);
		}
		else{
			System.out.println("5");
			good.setRemainNum(good.getRemainNum() - intoGood.getNum());
			goodsService.UpdateGoods(good);
			System.out.println("7");

			Goods newGood=intoGoods.getGoods();//获得更新后的货物
			newGood.setRemainNum(good.getRemainNum() + intoGoods.getNum());
			System.out.println(newGood);
			goodsService.UpdateGoods(newGood);
			System.out.println("6");
			intoGoodsService.updateIntoGoods(intoGoods);
		}
		
		System.out.println("end");
		
		return "operasuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public EmployerService getEmployerService() {
		return employerService;
	}

	public void setEmployerService(EmployerService employerService) {
		this.employerService = employerService;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public IntoGoodsService getIntoGoodsService() {
		return intoGoodsService;
	}

	public void setIntoGoodsService(IntoGoodsService intoGoodsService) {
		this.intoGoodsService = intoGoodsService;
	}

	public IntoGoods getIntoGoods() {
		return intoGoods;
	}

	public void setIntoGoods(IntoGoods intoGoods) {
		this.intoGoods = intoGoods;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
}
