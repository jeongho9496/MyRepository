package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class D {
	//1007
	private static final Logger logger = LoggerFactory.getLogger(D.class);

	public D(){
		logger.info("D 객체 생성");
	}
	
	public void method() {
		logger.info("D: method 실행");
	}
}
