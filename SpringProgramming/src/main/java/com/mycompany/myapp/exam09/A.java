package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class A {
	private static final Logger logger = LoggerFactory.getLogger(A.class);

	public A(){
		logger.info("A객체 생성");
	}//<beans:bean name="aObj" class="com.mycompany.myapp.exam09.A"/> 관리객체로 만들어 진 후 실행
	
	public void method1(){
		logger.info("A : method1 실행");
	}
}
