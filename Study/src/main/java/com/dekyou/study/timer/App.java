package com.dekyou.study.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class App {
		   public static void main(String[] args) {
		      // creating timer task, timer
		      TimerTask tasknew = new TimerCancel();
		      Timer timer = new Timer();
		      
		      // scheduling the task at interval
		      timer.schedule(tasknew, new Date(),1000);      
		   }
 
}
