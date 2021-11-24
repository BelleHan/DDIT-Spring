package com.spring.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("jobTask")
public class TestScheduler {
	
	//@Scheduled(fixedRate=1000*5)
	//@Scheduled(cron = "0/5 * * * * * ")
	public void testMessage() {
		System.out.println("안녕하세요.!!");
	}

}
