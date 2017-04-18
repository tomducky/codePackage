package com.bzu.dao.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.hibernate.SessionFactory;
import org.jfree.data.category.DefaultCategoryDataset;

import com.bzu.dao.inter.WorkdayDao;
import com.bzu.entity.Employer;
import com.bzu.entity.Inputer;
import com.bzu.entity.Workday;
import com.bzu.util.ToolMethodUtil;
import com.bzu.util.WorkMapUtil;

public class WorkdayDaoImpl extends SuperDao implements WorkdayDao {

	private SessionFactory osessionFactory;

	public SessionFactory getOsessionFactory() {
		return osessionFactory;
	}

	public void setOsessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void addWorkday(List<Employer> list) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.CHINA);
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		String todaydate = formatter.format(curDate);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Employer employer = (Employer) iterator.next();
			Workday workday = new Workday(employer, todaydate, 0.0d);
			super.add(workday);
		}
	}

	public List<Object> todayWorklist() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.CHINA);
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		String hql = "and s.workday between ";

		curDate.setDate(curDate.getDate() - 1);
		hql += formatter.format(curDate);
		curDate.setDate(curDate.getDate() + 2);
		hql += " and " + formatter.format(curDate);
		List<Object> list = super.getAllObject(Workday.class, hql);

		return list;
	}

	public String monthWorkMap(String file) {
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//         select cs.name, count(*) from Goods s join CS cs on s.id = cs.id group by s.inputer.id
		String s = "select w.employer.id, count(*) from Workday w group by w.employer.id ";
		//String s="select em.username,count(*) from Workday w jion Employer em on em";
		List<Object> list = super.find(s);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			int num=Integer.parseInt(object[1].toString());
			int id=Integer.parseInt(object[0].toString());        // ).getName()   ((Inputer)
			String name=((Employer)super.select(Employer.class, id)).getUsername();
			dataset.addValue(num, "员工", name);
		}
		try {
			WorkMapUtil.creatMap(dataset, file,list.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "D:\\workMap.jpg";
	}

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.CHINA);
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		String hql = "and s.workday between ";

		curDate.setDate(curDate.getDate() - 1);
		hql += formatter.format(curDate);
		curDate.setDate(curDate.getDate() + 2);
		hql += " and " + formatter.format(curDate);

		System.out.println(hql);

	}

	public int getWorkday(int employerId) {

		int worday=0;
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat format=new SimpleDateFormat("yy-MM-dd");
		String date1=format.format(date);
		Object obj=super.select("select count(*) from Workday w where w.employer.id="+employerId+"" +
				" and  month(workday)=month('"+ date1+"')");
		if(obj!=null)
			worday=Integer.parseInt(((List)obj).get(0).toString());
		
		return worday;
		
		
	}
}
