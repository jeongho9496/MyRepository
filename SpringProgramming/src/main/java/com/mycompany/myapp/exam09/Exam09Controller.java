package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//관리 객체 만들기
@RequestMapping("/exam09")
public class Exam09Controller {//@Controller로 인해 객체를 이미 만들고 있음'
	//1006
	
	private static final Logger logger = LoggerFactory.getLogger(Exam09Controller.class);
	
	private A a;
	
	public void setA(A a){//<beans:property name="a" ref="aObj"/> 주입후 실행
		logger.info("setA() 실행");
		this.a = a;
	}
	
	private B b;
	
	public void setB(B b){
		logger.info("setB() 실행");
		this.b = b;
	}
	
	private ServiceA serviceA;
	
	public void setServiceA(ServiceA serviceA){//외부에서 객체를 받아 저장
		logger.info("setServiceA() 실행");
		this.serviceA = serviceA;
	}
	
	private ServiceB serviceB;
	
	public void setServiceB(ServiceB serviceB){
		logger.info("setServiceB() 실행");
		this.serviceB = serviceB;
	}
	
	//Interface
	private ServiceC serviceC;//구현객체가 대입돼야됨.
	
	public void setServiceC(ServiceC serviceC) {
		logger.info("setServiceC() 실행");
		this.serviceC = serviceC;
	}
	
	private ServiceD serviceD;
	
	public void setServiceD(ServiceD serviceD){
		logger.info("setServiceD() 실행");
		this.serviceD = serviceD;
	}
	
	@RequestMapping("/method1")
	public String method1(){
		logger.info("method1처리");
		a.method1();
		b.method1();
		serviceA.method1();
		serviceB.method1();
		serviceC.method1();
		serviceD.method1();
		return "redirect:/exam09/index";
	}
	
	public Exam09Controller(){	//spring에서 Controller의 생성자는 기본 생성자가 반드시있어야 한다.
		logger.info("Exam09Controller 객체 생성");
	}
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index처리");
		return "exam09/index";
	}
	//1007
	private C c;
	public void setC(C c){
		logger.info("setC() 실행");
		this.c = c;
	}
	
	private E e;
	public void setE(E e){
		logger.info("setE() 실행");
		this.e = e;
	}
	
	private F f;
	public void setF(F f){
		logger.info("setF() 실행");
		this.f = f;
	}
		
	@RequestMapping("/method2")
	public String method2(){
		logger.info("method2 처리");
		c.method();
		e.method();
		f.method();
		return "redirect:/exam09/index";
	}
}
