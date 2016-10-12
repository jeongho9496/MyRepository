package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceA {
	//1006
	private static final Logger logger = LoggerFactory.getLogger(ServiceA.class);
	
	public ServiceA(){
		logger.info("ServiceA 객체 생성");
	}
	
	public void method1(){
		logger.info("ServiceA : method1 실행");
	}

}
