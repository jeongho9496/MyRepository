package com.mycompany.kjhapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceDImpl2 implements ServiceD{
	//1006
	
		private static final Logger logger = LoggerFactory.getLogger(ServiceDImpl2.class);

		public ServiceDImpl2() {
			logger.info("ServiceImpl2 객체 생성");
		}
		
		@Override
		public void method() {
			logger.info("ServiceDImpl2 : method 실행");
		}

}
