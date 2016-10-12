package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceB {
	//1006
	private static final Logger logger = LoggerFactory.getLogger(ServiceB.class);
	
	public ServiceB(){
		logger.info("ServiceB 객체 생성");
	}
	
	public void method1(){
		logger.info("ServiceB : method1 실행");
	}

}
