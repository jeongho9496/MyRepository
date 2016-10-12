package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 관리객체로 들어감
// @Component 없으면 에러
// org.springframework.beans.factory.UnsatisfiedDependencyException:
// Error creating bean with name 'exam10Controller':
// Unsatisfied dependency expressed through method 'setI' parameter 0;
// nested exception is
// org.springframework.beans.factory.NoSuchBeanDefinitionException:
// No qualifying bean found for dependency [com.mycompany.myapp.exam10.I]:
// expected at least 1 bean which qualifies as autowire candidate. Dependency
// annotations: {}

public class I {
	// 1007
	private static final Logger logger = LoggerFactory.getLogger(I.class);

	private H h;

	@Autowired // 생성자 주입 DI컨테이너에 있는 관리 객체중 H객체를 찾아 매개값으로 대입한다.
	public I(H h) {
		logger.info("I 객체 생성");
		this.h = h;
	}

	public void method() {
		logger.info("I: method 실행");
		h.method();
	}
}
