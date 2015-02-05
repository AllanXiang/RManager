package com.xzy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
	public static final String TimeDiff(String old){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String res = "";
        Date d1 = null;
        Date d2 = new Date();

        try {
            d1 = df.parse(old);
            long diff = d2.getTime() - d1.getTime();
            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);
            
            if(diffDays > 0){
            	res += diffDays+"天";
            }
            if(diffHours > 0){
            	res += diffHours+"小时";
            }
            if(diffMinutes > 0){
            	res += diffMinutes+"分";
            }
            if(diffSeconds > 0){
            	res += diffSeconds+"秒";
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(res.equals("")){
        	res = "0";
        }
        return res;
	}

    public static final String dateToString(Date time){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String ctime = formatter.format(time);
        return ctime;
    }

    public static final String getPrevMonth(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) - 1);
        String res = dateToString(calendar.getTime());
        return res;
    }

    public static final String dateToStringDate(Date time){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("yyyy-MM-dd");
        String ctime = formatter.format(time);
        return ctime;
    }

    public static final String dateToStringDateMonthBegin(Date time){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat ("yyyy-MM");
        String ctime = formatter.format(time)+"-01 00:00:00";
        return ctime;
    }
}
