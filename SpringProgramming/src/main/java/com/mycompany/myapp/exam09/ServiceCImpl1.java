package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceCImpl1 implements ServiceC {
	//1006
	private static final Logger logger = LoggerFactory.getLogger(ServiceCImpl1.class);

	public ServiceCImpl1() {
		logger.info("ServiceImpl1 객체 생성");
	}
	
	@Override
	public void method1() {
		logger.info("ServiceCImpl1 : method1 실행");
	}

}
