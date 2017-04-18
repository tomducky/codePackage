package com.bzu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToolMethodUtil {
	
	public static String getYearAndMonth(){
		
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat format=new SimpleDateFormat("yy-MM-dd");
		String date1=format.format(date);
		String year="20"+date1.substring(0,date1.indexOf("-"));
		String month=date1.substring(date1.indexOf("-")+1,date1.indexOf("-")+3);
	
		String months= year+"-"+month;
		
		return months;
	}
	
	public static String getDate(){
		
		Date date=new Date(System.currentTimeMillis());
		SimpleDateFormat format=new SimpleDateFormat("yy-MM-dd");
		String date1=format.format(date);
		
		
		return date1;
	}

}
