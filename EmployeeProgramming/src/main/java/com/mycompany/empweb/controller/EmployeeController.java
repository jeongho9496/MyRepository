package com.mycompany.empweb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.empweb.dto.Employee;
import com.mycompany.empweb.job.MailSendScheduler;
import com.mycompany.empweb.service.EmployeeService;

@Controller

public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public String getemployeeList(Model model){
		List<Map<String, Object>> employeeList = employeeService.getEmployeeList();
		model.addAttribute("employeeList", employeeList);
		
		return "employee/index";
	}
	
	@RequestMapping(value="/employee/write", method=RequestMethod.GET)
	public String write(){
		return "employee/write";
	}
	
	@RequestMapping(value = "/employee/write", method=RequestMethod.POST)
	public String write(Employee emp){
		try {
			int result = employeeService.write(emp);
			return "redirect:/";
		} catch (Exception e) {
			return "employee/write";
		}
	}
	
	@RequestMapping("/employee/info")
	public String info(int no, Model model){
		Employee employee =employeeService.info(no);
		model.addAttribute("emp", employee);
		return "employee/info";
	}
	
	@RequestMapping(value="/employee/modify", method=RequestMethod.GET)
	public String modifyForm(int no, Model model){
		Employee employee = employeeService.info(no);
		model.addAttribute("emp",employee);
		return "employee/modify";
	}
	
	@RequestMapping(value = "/employee/modify", method=RequestMethod.POST)
	public String modify(Employee employee , int no){
		employeeService.modify(employee, no);
		return "redirect:/";	
	}
	
	@RequestMapping("/employee/remove")
	public String remove(int no){
		employeeService.remove(no);
		return "redirect:/";
	}
	
	@RequestMapping("/searchEmployee")
	public String searchEmployee(HttpServletRequest request, Model model){
		String searchType = request.getParameter("searchType");
		String searchParam = request.getParameter("searchParam");
		logger.info("searchType : " + searchType);
		logger.info("searchParam : " + searchParam);
		
		List<Map<String, Object>> employeeList = employeeService.searchEmployee(Integer.parseInt(searchType), searchParam);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchParam", searchParam);
		model.addAttribute("employeeList", employeeList);
		
		return "employee/index";
	}
	
	@RequestMapping("/csvDown")
	public String csvDown(HttpServletRequest request, Model model) {
		List<Map<String, Object>> employeeList = employeeService.getEmployeeList();
		model.addAttribute("employeeList", employeeList);
		
		return "employee/csvDown";
	}
	
	@RequestMapping("/xlsDown")
	public String xlsxDown(HttpServletRequest request, Model model) {
		List<Map<String, Object>> employeeList = employeeService.getEmployeeList();
		model.addAttribute("employeeList", employeeList);
		
		return "employee/xlsDown";
	}
	
	@RequestMapping("/startScheduler")
	public String startScheduler() {
		List<Map<String, Object>> employeeList = employeeService.getEmployeeList();
		new MailSendScheduler(employeeList);
		return "employee/scheduler";
	}
	
}
