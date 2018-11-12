package com.pCarpet.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.format.annotation.DateTimeFormat;

public class myUtilsDate {

	
	public static List<String> formatDateHour(String oldDate) {
		
		List<String> lDate = new ArrayList<>();
		
		
		StringTokenizer st=new StringTokenizer(oldDate," ");
	
		
		while(st.hasMoreTokens()) {
			String tk=st.nextToken();
			lDate.add(tk);
		}
			
		
		return lDate;
		
	}
	
	public static int intervalMinute(String d1, String d2) {
		DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime ldt1=LocalDateTime.parse(d1, dtf1);
		LocalDateTime ldt2=LocalDateTime.parse(d2, dtf2);
		
		Duration duration=Duration.between(ldt1, ldt2);
		int diff=Integer.parseInt(String.valueOf(Math.abs(duration.toMinutes())));
		return diff;
	}
	
}
