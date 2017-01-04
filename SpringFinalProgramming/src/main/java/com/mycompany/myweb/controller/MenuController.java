package com.mycompany.myweb.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Menu;
import com.mycompany.myweb.service.MenuService;
// 메뉴관련코드작성자: 보나 (20161107~)


// 일반적인 페이징처리 메뉴 리스트
@Controller
@RequestMapping("/menu")
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/list")
	public String list(String pageNo, Model model, HttpSession session){
		
		String sid = (String) session.getAttribute("login");
	
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 8;
		int pagesPerGroup = 5;
		
		int totalBoardNo = menuService.getCount();
		
		int totalPageNo = (totalBoardNo/rowsPerPage) + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		
		List<Menu> list = menuService.list(intPageNo, rowsPerPage, sid);
		
		model.addAttribute("sid",sid);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		
		return "menu/menuList";
	} // list
	 
	
	// 페이징+그룹핑 기능 리스트
	@RequestMapping(value="/menuList")
	public String mgroupList(String keyword, String pageNo, Model model, HttpSession session){
		logger.info("메뉴리스트 그룹+페이징 컨트롤러");
		String sid = (String) session.getAttribute("login");
		String mgroup = null;
		
		if(!keyword.equals("전체")) {
			mgroup = keyword;
		}
		
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		
		session.setAttribute("pageNo", String.valueOf(intPageNo));
		
		int rowsPerPage = 8;
		int pagesPerGroup = 5;
		int totalBoardNo = menuService.getCountMgroup(sid, mgroup);
		
		logger.info("totalBoardNo: "+totalBoardNo);

		
		int totalPageNo = (totalBoardNo/rowsPerPage) + ((totalBoardNo%rowsPerPage!=0)?1:0);
		int totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		
		if(groupNo == totalGroupNo){
			endPageNo = totalPageNo;
		}
		logger.info("before model addAttribute");
		
		List<Menu> list = menuService.listPageMgroup(intPageNo, rowsPerPage, sid, mgroup);
		
		model.addAttribute("sid", sid);
		model.addAttribute("keyword", keyword);
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		logger.info(sid, mgroup);
		return "menu/menuList";
	
	} // menuList
	
	
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public String registerForm(HttpSession session){
		return "menu/registerForm";
	} 
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String registerForm(HttpSession session, Menu menu){
		logger.info("메뉴등록");
	
		String sid = (String)session.getAttribute("login");
		menu.setSid(sid);
		logger.info(""+sid);
		//String msavedfile = new Date().getTime() + menu.getPhoto().getOriginalFilename();
		String msavedfile = menu.getPhoto().getOriginalFilename();
		String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/" + msavedfile);
		logger.info(realpath);
		try {
			menu.getPhoto().transferTo(new File(realpath));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		menu.setMsavedfile(msavedfile);
		menu.setMmimetype(menu.getPhoto().getContentType());
		
		menuService.write(menu);
		return "menu/menuRegister";		
	
	} // register
	
	
	@RequestMapping("/showPhoto")
	public void showPhoto(String msavedfile, HttpServletRequest request, HttpServletResponse response){
		try{
			String fileName = msavedfile;
			String mimeType = request.getServletContext().getMimeType(fileName);
			response.setContentType(mimeType);
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/" + fileName);
			InputStream is = new FileInputStream(filePath);
			
			byte[] values = new byte[1024];
			int byteNum = -1;
			while((byteNum = is.read(values)) != -1){
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	} // showPhoto 
	
	@RequestMapping(value="/info")
	public String info(int mid, Model model){
		logger.info("menuController- Info 부분");
		Menu menu = menuService.info(mid);
		model.addAttribute("menu", menu);
		return "menu/menuInfo";
	} // info
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(int mid, Model model){
		logger.info("수정 컨트롤러");
		Menu menu = menuService.info(mid);
		model.addAttribute("menu", menu);
		logger.info("수정 컨트롤러 폼 넘어가기 전");
		return "menu/modify";
	} // modifyForm
	
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Menu menu, HttpSession session, Model model){
		String sid=(String)session.getAttribute("login");
		menu.setSid(sid);
		//String msavedfile = new Date().getTime()+event.getPhoto().getOriginalFilename();
		logger.info("이벤트 modify post 컨트롤러");
		
		String msavedfile = menu.getPhoto().getOriginalFilename();
		String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+msavedfile);
		
		try{
			// String sid = (String)session.getAttribute("login");
			// menu.setSid(sid);
			
			logger.info("realpath : "+realpath);
			menu.getPhoto().transferTo(new File(realpath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		menu.setMsavedfile(msavedfile);
		menu.setMmimetype(menu.getPhoto().getContentType());
		menuService.modify(menu);
		return "menu/modifyResult";
	} //modify
	
	
	@RequestMapping("/remove")
	public String remove(int mid){
		menuService.remove(mid);
		return "menu/menuList";
	}

} // class
