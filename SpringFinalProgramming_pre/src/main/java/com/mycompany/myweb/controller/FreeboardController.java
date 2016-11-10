package com.mycompany.myweb.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.service.FreeBoardService;

@Controller
@RequestMapping("/freeboard")
public class FreeboardController {
	//1027
	private static final Logger logger = LoggerFactory.getLogger(FreeboardController.class);
	
	@Autowired
	private FreeBoardService freeBoardService;
	
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session){	//@RequestParam(defaultValue="1")=>페이지의 기본값 지정
		//1028
		
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if (pageNo != null) {
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));//세션에 현재 저장된 페이지 전달
		
		
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		int totalBoardNo = freeBoardService.getCount();//전체 게시물 수 구하기
		
		int totalPageNo = (totalBoardNo/rowsPerPage)+((totalBoardNo%rowsPerPage!=0)?1:0);//전체 페이지수
		int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);//전체 그룹수
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;//현재 그룹의 번호
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;//그룹의 첫번째 번호 구하기
		int endPageNo = startPageNo + pagesPerGroup - 1;//그룹의 마지막 번호 구하기
		
		if (groupNo == totalGroupNo) {
			endPageNo = totalPageNo;
		}
		List<FreeBoard> list = freeBoardService.list(intPageNo, rowsPerPage);
		
		model.addAttribute("pageNo",intPageNo);
		model.addAttribute("rowsPerPage",rowsPerPage);
		model.addAttribute("pagesPerGroup",pagesPerGroup);
		model.addAttribute("totalBoardNo",totalBoardNo);
		model.addAttribute("totalPageNo",totalPageNo);
		model.addAttribute("totalGroupNo",totalGroupNo);
		model.addAttribute("groupNo",groupNo);
		model.addAttribute("startPageNo",startPageNo);
		model.addAttribute("endPageNo",endPageNo);
		model.addAttribute("list",list);
			
		return "freeboard/list";
	}
	
	@RequestMapping(value = "/write", method=RequestMethod.GET)
	public String write() {
		return "freeboard/write";
	}
	
	@RequestMapping(value = "/write", method=RequestMethod.POST)
	public String write(FreeBoard freeBoard, HttpSession session) {
		String mid = (String)session.getAttribute("login");
		freeBoard.setBwriter(mid);
		int result = freeBoardService.write(freeBoard);
		
		if (result == FreeBoardService.WRITE_FAIL) {
			return "freeboard/write";	//jsp파일에서 매개변수인 FreeBoard 사용 가능
		} else {
			return "redirect:/freeboard/list";
		}
	}
	
	@RequestMapping("/info")
	public String info(int bno, Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		freeBoard.setBhitcount(freeBoard.getBhitcount() + 1); //조회수 증가
		freeBoardService.modify(freeBoard);
		model.addAttribute("freeBoard", freeBoard);
		return "freeboard/info";
	}
	
	@RequestMapping(value = "/modify", method=RequestMethod.GET)
	public String modifyForm(int bno, Model model){
		FreeBoard freeBoard = freeBoardService.info(bno);
		model.addAttribute("freeBoard", freeBoard);
		return "freeboard/modify";
	}
	@RequestMapping(value = "/modify", method=RequestMethod.POST)
	public String modify(FreeBoard freeBoard){
		FreeBoard dbFreeBoard = freeBoardService.info(freeBoard.getBno());
		freeBoard.setBhitcount(dbFreeBoard.getBhitcount());//좋은 방법이 아님 hitcount를 따로 만들어야 됨.
		freeBoardService.modify(freeBoard);
		return "redirect:/freeboard/list";
	}
	
	//1028
	@RequestMapping("/remove")
	public String remove(int bno){
		freeBoardService.remove(bno);
		return "redirect:/freeboard/list";
	}
	
}
