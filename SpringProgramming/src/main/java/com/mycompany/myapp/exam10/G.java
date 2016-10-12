package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component //@Component -> DI 컨테이너에 자동으로 관리객체됨 
public class G {
	//1007
	private static final Logger logger = LoggerFactory.getLogger(G.class);

	public G(){
		logger.info("G객체 생성");
	}
	
	public void method(){
		logger.info("G : method 실행");
	}
}
