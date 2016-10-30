package com.mycompany.kjhweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
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

import com.mycompany.kjhweb.dto.PhotoBoard;
import com.mycompany.kjhweb.service.PhotoBoardService;



@Controller
@RequestMapping("/photoboard")
public class PhotoBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoBoardController.class);
	
	@Autowired
	private PhotoBoardService photoBoardService;
	
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
		
		
		int rowsPerPage = 8;
		int pagesPerGroup = 5;
		
		int totalBoardNo = photoBoardService.getCount();//전체 게시물 수 구하기
		
		int totalPageNo = (totalBoardNo/rowsPerPage)+((totalBoardNo%rowsPerPage!=0)?1:0);//전체 페이지수
		int totalGroupNo = (totalPageNo/pagesPerGroup)+((totalPageNo%pagesPerGroup!=0)?1:0);//전체 그룹수
		
		int groupNo = (intPageNo-1)/pagesPerGroup + 1;//현재 그룹의 번호
		int startPageNo = (groupNo-1)*pagesPerGroup + 1;//그룹의 첫번째 번호 구하기
		int endPageNo = startPageNo + pagesPerGroup - 1;//그룹의 마지막 번호 구하기
		
		if (groupNo == totalGroupNo) {
			endPageNo = totalPageNo;
		}
		List<PhotoBoard> list = photoBoardService.list(intPageNo, rowsPerPage);
		
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
			
		return "photoboard/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "photoboard/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(PhotoBoard photoBoard, HttpSession session){
		try {
			String mid = (String)session.getAttribute("login");
			photoBoard.setBwriter(mid);
			photoBoard.setOriginalfile(photoBoard.getPhoto().getOriginalFilename());
			logger.info("실제 파일 이름 : "+photoBoard.getPhoto().getOriginalFilename().toString());
			
			String savedfile = new Date().getTime()+photoBoard.getPhoto().getOriginalFilename();
			logger.info("DB에 저장되는 이름 : "+savedfile);
			
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);
			logger.info(realpath);
			
			photoBoard.getPhoto().transferTo(new File(realpath));
			photoBoard.setSavedfile(savedfile);
			photoBoard.setMimetype(photoBoard.getPhoto().getContentType());
			logger.info(photoBoard.getPhoto().getContentType());
			
			photoBoardService.write(photoBoard);
			
			return "redirect:/photoboard/list";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "photoboard/write";
		}
	}
	
	@RequestMapping("/showPhoto")
	public void showPhoto(String savedfile, HttpServletRequest request,HttpServletResponse response){//이미지 다운로드 받기 위해 메소드 작성
		try{
			String fileName = savedfile;
			
			/* 브라우저에서 보여주지 않고 강제로 다운로드 할 경우
			fileName = URLEncoder.encode(fileName, "UTF-8"); //fileName(한글) UTF-8형식으로 변환
			response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");//첨부화일 만들기(다운로드)
			*/		
			
			String mimeType = request.getServletContext().getMimeType(savedfile);
			response.setContentType(mimeType);//Content-Type 설정
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/WEB-INF/photo/"+fileName);
			InputStream is = new FileInputStream(filePath);
			byte[] values =new byte[1024];
			int byteNum = -1;
			while ((byteNum = is.read(values)) != -1 ) {
				os.write(values, 0, byteNum);
			}
			os.flush();
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
