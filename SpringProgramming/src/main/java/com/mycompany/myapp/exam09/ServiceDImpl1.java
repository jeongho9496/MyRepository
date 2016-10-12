package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceDImpl1 implements ServiceD{
	//1006
	
		private static final Logger logger = LoggerFactory.getLogger(ServiceDImpl1.class);

		public ServiceDImpl1() {
			logger.info("ServiceImpl1 객체 생성");
		}
		
		@Override
		public void method1() {
			logger.info("ServiceDImpl1 : method1 실행");
		}

}
