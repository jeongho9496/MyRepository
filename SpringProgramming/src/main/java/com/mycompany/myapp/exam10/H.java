package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component //@Component -> 관리 객체 됨
public class H {
	//1007
	private static final Logger logger = LoggerFactory.getLogger(H.class);

	public H(){
		logger.info("H객체 생성");
	}
	
	public void method(){
		logger.info("H : method 실행");
	}
}
