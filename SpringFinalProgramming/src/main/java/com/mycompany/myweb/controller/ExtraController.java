package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.service.ExtraService;


@Controller
@RequestMapping("/extra")
public class ExtraController {
	private static final Logger logger = LoggerFactory.getLogger(ExtraController.class);

	@Autowired
	private ExtraService extraService;
	
	@RequestMapping("/list")
	public String list(Model model, HttpSession session) { //Model -> jsp에 데이터 값을 보여주기 위해 객체로 담아 전달.
		logger.info("service list 실행1");
		int xid = (int) session.getAttribute("login");
		List<Extra> list = extraService.getList(xid);
		model.addAttribute("extraList",list);
		logger.info("service list 실행2");
		return "extra/list";			
	}
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String register() {
		logger.info("extraForm 실행");
		return "extra/registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerForm(Extra extra, HttpSession session) {
		logger.info("extra 등록 성공");
		int xid = (int)session.getAttribute("login");
		extra.setXid(xid);
		int result = extraService.add(extra);
		
		if(result == ExtraService.ADD_SUCESS) {
			return "extra/registerForm";
			
		} else {
			return "redirect:/extra/list";
		}
	}
	@RequestMapping(value="/info")
	public String info(int xid, Model model) {
		logger.info("엑스트라 세부정보 form 실행");
		Extra extra = extraService.info(xid);
		model.addAttribute("extra", extra);
		return "extra/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(int xid, Model model) {
		logger.info("엑스트라 수정폼 form 실행");
		Extra extra = extraService.info(xid);
		model.addAttribute("extra", extra);
			return "extra/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Extra extra) {
		extraService.modify(extra);
		return "redirect:/extra/list";
	}
	
	@RequestMapping("/remove")
	public String remove(int xid){
		extraService.remove(xid);
		return "redirect:/extra/list";
	}
	
}
