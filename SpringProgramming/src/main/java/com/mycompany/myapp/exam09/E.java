package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class E {
	//1007
		private static final Logger logger = LoggerFactory.getLogger(E.class);
		//B,D에 의존
		private B b;
		private D d;
		
		public E(B b, D d) {
			logger.info("E 객체 생성");
			this.b = b;
			this.d = d;
		}
		
		public void method(){
			logger.info("E: method 실행");
			b.method1();
			d.method();
	
		}
}
