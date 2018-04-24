package com.dekyou.study.date;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class App {
	
	@Test
	public void test1() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));    // 0 - 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
 
        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());     // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
        
        
        Calendar.getInstance().getTimeInMillis();
        System.currentTimeMillis();
        Clock.systemDefaultZone().millis(); // Java 8
        
        
        Calendar time = Calendar.getInstance();
        time.getActualMaximum(Calendar.DAY_OF_MONTH);
        
        
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));
 
        // Java 8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));
        
        
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.DATE, -1);
//        System.out.println(cal.getTime());
//        
//        //java -8
//        LocalDateTime today = LocalDateTime.now();
//        LocalDateTime yesterday = today.minusDays(1);
// 
//        System.out.println(yesterday);

	}
}
