package com.mycompany.kjhapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/exam09")
public class Exam09Controller {
	private static final Logger logger = LoggerFactory.getLogger(Exam09Controller.class);
	
	public Exam09Controller(){
		logger.info("Exam09Controller 객체 생성");
	}
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index처리");
		return "exam09/index";
	}
	
	private A a;
	private B b;
	private ServiceA serviceA;
	private ServiceB serviceB;
	
	public void setA(A a) {
		this.a = a;
	}

	public void setB(B b) {
		this.b = b;
	}

	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}

	public void setServiceB(ServiceB serviceB) {
		this.serviceB = serviceB;
	}
	
	//interface
	private ServiceC serviceC;
	private ServiceD serviceD;
	
	public void setServiceC(ServiceC serviceC) {
		this.serviceC = serviceC;
	}

	public void setServiceD(ServiceD serviceD) {
		this.serviceD = serviceD;
	}

	@RequestMapping("/method")
	public String method(){
		logger.info("method처리");
		a.method();
		b.method();
		serviceA.method();
		serviceB.method();
		//interface
		serviceC.method();
		serviceD.method();
		return "redirect:/exam09/index";
	}
}
