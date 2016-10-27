package com.mycompany.myweb.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String list(@RequestParam(defaultValue="1")int pageNo, Model model){	//@RequestParam(defaultValue="1")=>페이지의 기본값 지정
	
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		
		int totalBoardNo = freeBoardService.getCount();//전체 게시물 수 구하기
		
		int totalPageNo = (totalBoardNo/rowsPerPage)+((totalBoardNo%rowsPerPage!=0)?1:0);//전체 페이지수
		int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);//전체 그룹수
		
		int groupNo = (pageNo-1)/pagesPerGroup + 1;//현재 그룹의 번호
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;//그룹의 첫번째 번호 구하기
		int endPageNo = startPageNo + pagesPerGroup - 1;//그룹의 마지막 번호 구하기
		
		if (groupNo == totalGroupNo) {
			endPageNo = totalPageNo;
		}
		List<FreeBoard> list = freeBoardService.list(pageNo, rowsPerPage);
		
		model.addAttribute("pageNo",pageNo);
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
	public String write(FreeBoard freeBoard) {
		return "freeboard/write";
	}
	
}
