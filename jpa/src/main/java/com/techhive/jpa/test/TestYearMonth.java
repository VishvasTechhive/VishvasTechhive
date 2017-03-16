package com.techhive.jpa.test;

import java.util.Calendar;
import java.util.Date;

public class TestYearMonth {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.YEAR, 2017);
		Date date = calendar.getTime();
		
		System.out.println("date : " + date);
		
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);
		System.out.println(calendar2.get(Calendar.YEAR));
		System.out.println(calendar2.get(Calendar.MONTH));
	}
	
}
