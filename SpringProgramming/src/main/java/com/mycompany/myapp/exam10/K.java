package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class K {
	// 1007
	private static final Logger logger = LoggerFactory.getLogger(K.class);
	
	@Autowired	//spring DI 컨테이너에 있는 해당 객체(여기선 G)를 가져와 대입
	private G g;
	
	@Autowired
	private H h;
	
	public K(){
		logger.info("K 객체 생성");//DispatcherServlet에서 읽음
	}
	
	public void method(){
		logger.info("K : method 실행");
		g.method();
		h.method();
	}

}
