package com.bzu.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bzu.entity.Employer;
import com.bzu.entity.EmployerWage;
import com.bzu.entity.GoodsSpend;
import com.bzu.entity.IntoGoods;
import com.bzu.service.inter.EmployerService;
import com.bzu.service.inter.EmployerWageService;
import com.bzu.service.inter.IntoGoodsService;
import com.bzu.service.inter.WorkdayService;
import com.bzu.util.ToolMethodUtil;
import com.opensymphony.xwork2.ActionSupport;

public class EmployerWageAction extends ActionSupport {

	private EmployerWage employerWage;

	private EmployerWageService employerWageService;
	
	private IntoGoodsService intoGoodsService;

	private Double beginWage;

	private Double endWage;

	private int index;

	public String employerWageList() {

		String hql = "";
		if (employerWage != null) {

			if (employerWage.getEmployer().getId() != -1)
				hql += " and s.employer.id = "
						+ employerWage.getEmployer().getId();

			if (beginWage != null && endWage != null)
				hql += " and s.wage between " + beginWage + " and " + endWage
						+ "";
		}

		List<EmployerWage> list = index != 0 ? employerWageService.getByPage(
				index, EmployerWage.class, hql) : employerWageService
				.getByPage(1, EmployerWage.class, hql);

		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("list", list);
		session.setAttribute("thisindex", index == 0 ? 1 : index);

		session.setAttribute("count", employerWageService.getAllEmployerWage(
				EmployerWage.class, hql).size());

		Map<Integer, String> map = employerWageService.getAllEmployer(
				Employer.class, "");
		ServletActionContext.getRequest().setAttribute("map", map);
		return "employerWageList";

	}

	private EmployerService employerService;

	private WorkdayService workdayService;

	public String createWage() {

		List<Employer> emplist = employerService.getAllEmployer(Employer.class,
				"");// 获得所有的员工
		// List<EmployerWage> wagelist=new ArrayList<EmployerWage>();

		String months = ToolMethodUtil.getYearAndMonth();
		String num = ((List) (employerWageService
				.getInfo("select count(*) from EmployerWage e where e.months='"
						+ months + "'"))).get(0).toString();
		if (Integer.parseInt(num) != 0)
			return "createWageSuccess";

		for (Iterator iterator = emplist.iterator(); iterator.hasNext();) {// 遍历所有的员工，通过他们的id获得到他们的月薪
			Employer employer = (Employer) iterator.next();

			double monthpay = employer.getMonthpay();

			int workday = workdayService.getWorkday(employer.getId());
			Double dempWage = (monthpay * (((float) workday) / 30));
			int empWage = dempWage.intValue();
			EmployerWage employerWage = new EmployerWage(employer, months,
					empWage);

			employerWageService.addempWage(employerWage);

			// wagelist.add(employerWage);

		}
		return "createWageSuccess";
	}

	public String createGoodsSpend() {

		String date = ToolMethodUtil.getDate();
		
		String num = ((List) (employerWageService//getInfo方法就是通过hql语句获得list的集合,这里是查询物品消费表里面是否有本月的记录
				.getInfo("select count(*) from GoodsSpend g where month(g.intoGoods.intoDate)=month('"
						+ date + "')"))).get(0).toString();
		System.out.println(num);
		if (Integer.parseInt(num) != 0)
			return "createWageSuccess";
		
		List<IntoGoods> inglist=intoGoodsService.getAllIntoGoods(IntoGoods.class, " and month(s.intoDate)=month('"
						+ date + "')");//获得所有本月的进货记录
		
		for (Iterator iterator = inglist.iterator(); iterator.hasNext();) {
			IntoGoods intoGoods = (IntoGoods) iterator.next();
			
			double money=intoGoods.getNum()*intoGoods.getGoods().getInputPrise();
			
			GoodsSpend goodSpend=new GoodsSpend(intoGoods, money);
			
			intoGoodsService.addGoodsSpend(goodSpend);
			
		}

		return "createWageSuccess";//创建货物花费金额成功，为了少写一个result，就直接返回createWageSuccess。
	}
	
	public String goodsSpendList(){
		
		String date = ToolMethodUtil.getDate();
		List<GoodsSpend> list=intoGoodsService.getGoodsSpendList(GoodsSpend.class, "and month(s.intoGoods.intoDate)=month('"+date + "')");
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("spendlist", list);
		
		return "spendlist";
		
	}

	public WorkdayService getWorkdayService() {
		return workdayService;
	}

	public void setWorkdayService(WorkdayService workdayService) {
		this.workdayService = workdayService;
	}

	public EmployerService getEmployerService() {
		return employerService;
	}

	public void setEmployerService(EmployerService employerService) {
		this.employerService = employerService;
	}

	public Double getBeginWage() {
		return beginWage;
	}

	public void setBeginWage(Double beginWage) {
		this.beginWage = beginWage;
	}

	public Double getEndWage() {
		return endWage;
	}

	public void setEndWage(Double endWage) {
		this.endWage = endWage;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public EmployerWageService getEmployerWageService() {
		return employerWageService;
	}

	public void setEmployerWageService(EmployerWageService employerWageService) {
		this.employerWageService = employerWageService;
	}

	public EmployerWage getEmployerWage() {
		return employerWage;
	}

	public void setEmployerWage(EmployerWage employerWage) {
		this.employerWage = employerWage;
	}

	
	public IntoGoodsService getIntoGoodsService() {
		return intoGoodsService;
	}

	public void setIntoGoodsService(IntoGoodsService intoGoodsService) {
		this.intoGoodsService = intoGoodsService;
	}

	public static void main(String[] args) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
		String date1 = format.format(date);
		System.out.println(date1);
		//
		System.out.println("20" + date1.substring(0, date1.indexOf("-")));
		System.out.println(date1.substring(date1.indexOf("-") + 1, date1
				.indexOf("-") + 3));
	}
}
