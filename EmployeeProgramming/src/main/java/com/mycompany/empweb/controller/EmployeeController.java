package com.mycompany.empweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.empweb.dto.Employee;
import com.mycompany.empweb.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "employee/write";
	}
	
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String write(Employee emp){
		try {
			int result = employeeService.write(emp);
			return "redirect:/";
		} catch (Exception e) {
			return "employee/write";
		}
	}
	
	@RequestMapping("/info")
	public String info(int no, Model model){
		Employee employee =employeeService.info(no);
		model.addAttribute("emp", employee);
		return "employee/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(int no, Model model){
		Employee employee = employeeService.info(no);
		model.addAttribute("emp",employee);
		return "employee/modify";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String modify(Employee employee){
		employeeService.modify(employee);
		return "redirect:/";	
	}
	
	@RequestMapping("/remove")
	public String remove(int no){
		employeeService.remove(no);
		return "redirect:/";
	}
	
}
