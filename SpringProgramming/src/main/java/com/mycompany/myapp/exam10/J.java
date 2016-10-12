package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component	//관리객체로 들어감
//@Component 없으면 에러
//org.springframework.beans.factory.UnsatisfiedDependencyException: 
//Error creating bean with name 'exam10Controller': 
//Unsatisfied dependency expressed through method 'setI' parameter 0; 
//nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: 
//No qualifying bean found for dependency [com.mycompany.myapp.exam10.I]: 
//expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {} =>에러 문구

public class J {
	//1007
		private static final Logger logger = LoggerFactory.getLogger(J.class);
		
		private H h;
		private G g;
		
		@Autowired	//생성자 주입
		public J(H h, G g){
			logger.info("J 객체 생성");
			this.h = h;
			this.g = g;
		}
		
		public void method(){
			logger.info("J: method 실행");
			h.method();
			g.method();
		}
}
