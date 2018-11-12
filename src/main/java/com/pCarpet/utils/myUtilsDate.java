package com.pCarpet.utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.taglibs.standard.tag.el.fmt.FormatDateTag;
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
	
	public static int intervalMinute(String orainizio, String orafine) {
		//if(!orafine.equals("0000-00-00T00:00:00")) {
			
		
		String d1 = formatData(orainizio);
		String d2 = formatData(orafine);
		
		
		DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime ldt1=LocalDateTime.parse(d1, dtf1);
		LocalDateTime ldt2=LocalDateTime.parse(d2, dtf2);
		
		Duration duration=Duration.between(ldt1, ldt2);
		int diff=Integer.parseInt(String.valueOf(Math.abs(duration.toMinutes())));
		return diff;
		//}
		//return -1;
	}
	
	//Converte da [2018-11-12T12:00:00.587] oppure da [2018-11-12T12:00:00.587] oppure da [2018-11-12 12:00]
	//in [2018-11-12 12:00]
	public static String formatData(String oldDate) {
		String newDate=oldDate;
		if(!oldDate.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}[\\s][0-9]{2}[:][0-9]{2}")) {
			StringTokenizer st=new StringTokenizer(oldDate,"T:");
			newDate="";
				
			int index=0;
				
			while(st.hasMoreTokens()) {
					
				String tk=st.nextToken();
				
				if(index==1) {
					newDate+=" ";
				}
				else if(index==2) {
					newDate+=":";
				}else if(index==3) {
					break;
				}
				
				newDate+=tk;
				index++;
					
			}
		}
			
		return newDate;
			
	}
	
}
