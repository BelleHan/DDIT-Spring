package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.pointcut.Behavior;
import com.spring.pointcut.BehaviorImpl;

public class 하루일과 {

	public static void main(String[] args) {
		
		ApplicationContext ctx 
		= new GenericXmlApplicationContext(
				"classpath:com/spring/context/application-context.xml");
		
		Behavior 행동 = ctx.getBean("behavior",Behavior.class);
		
		행동.밥먹기();
		행동.정신수양();
		행동.밥먹기();
		행동.공부하기();
		행동.놀기();
		행동.데이트();
		행동.운동();
		행동.밥먹기();
		행동.잠자기();


	}

}
