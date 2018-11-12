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
	
	public static int intervalMinute(String d1n, String d2n) {
		String d1 = formatData(d1n);
		String d2 = formatData(d2n);
		
		
		DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime ldt1=LocalDateTime.parse(d1, dtf1);
		LocalDateTime ldt2=LocalDateTime.parse(d2, dtf2);
		
		Duration duration=Duration.between(ldt1, ldt2);
		int diff=Integer.parseInt(String.valueOf(Math.abs(duration.toMinutes())));
		return diff;
	}
	
public static String formatData(String oldDate) {
		
		StringTokenizer st=new StringTokenizer(oldDate,"/.-T: ");
		String newDate="";
		
		int index=0;
		
		while(st.hasMoreTokens()) {
			index += 1;
			String tk=st.nextToken();
			if(tk.length()>=3 && tk.charAt(2)==('.')) {
				String temp=tk.substring(0, 1);
				tk=temp+tk.substring(1,2);
				newDate+=tk;
				break;
			}
			if(index<3) {
				newDate+=tk;
				newDate+="-";
			}
			else if(index==3) {
				newDate+=tk;
				newDate+=" ";
			}
			else if(index<5) {//index<6 se nella data ci sono anche i secondi
				newDate+=tk;
				newDate+=":";
			}else {
				newDate+=tk;
			}//if
			
		}//while
		
		newDate+=":00";
		
		return newDate;
		
		
	}	
}
