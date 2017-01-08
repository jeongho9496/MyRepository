package com.mycompany.empweb.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.empweb.dto.Sphoto;
import com.mycompany.empweb.dto.Store;
import com.mycompany.empweb.service.SphotoService;
import com.mycompany.empweb.service.StoreService;

//패스워드 찾기, 아이디 찾기
@Controller
public class StoreController {
// 김정호
// 보나 20161122 - 아이디&비번찾기 추가 
	
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private SphotoService sphotoService;
	
	@RequestMapping(value="/store/login")
	public String login(String sid, String spw, HttpSession session, Model model){
		logger.info("sid: "+sid);
		logger.info("spw: "+spw);
		
		int result = storeService.login(sid, spw);
		logger.info("result : "+ result);
		
		if (result == StoreService.LOGIN_FAIL_SPW) {
			model.addAttribute("result", "LOGIN_FAIL_SPW");
			logger.info("login_실패1");
			return "store/loginResult";
			
		} else if (result == StoreService.LOGIN_FAIL_SID) {
			model.addAttribute("result", "LOGIN_FAIL_SID");
			logger.info("login_실패2");
			return "store/loginResult";
			
		} else {
			model.addAttribute("result", "LOGIN_SUCCESS");
			session.setAttribute("login", sid);
			logger.info("login_성공");
			String login = (String)session.getAttribute("login");
			logger.info("login: "+login);
			return "store/loginResult";
		}
		
		
	}
	
	@RequestMapping(value="/store/findSid", method=RequestMethod.GET)
	public String findSidForm(){
		return "store/findSidForm";
	}
	
	@RequestMapping(value="/store/findSid", method=RequestMethod.POST)
	public String findSid(String semail, Model model, HttpSession session){
		String sid = storeService.findSid(semail);
		if (sid == null) {
			model.addAttribute("error", "not found");
			return "store/findSidForm";
		}
		session.setAttribute("findSid", sid);
		return "store/resultFindSid";
	}

	
	@RequestMapping(value="/store/findSpw", method=RequestMethod.GET)
	public String findSpwForm(){
		return "store/findSpwForm";
	}
	
	@RequestMapping(value="/store/findSpw", method=RequestMethod.POST)
	public String findSpw(String sid, String semail, Model model, HttpSession session){
		String spw = storeService.findSpw(sid, semail);
		if (spw == null) {
			model.addAttribute("error","이메일 및 아이디가 존재 하지 않음.");
			return "store/findSpwForm";
		}
		session.setAttribute("findSpw", spw);
		return "store/resultFindSpw";
	}
	
	@RequestMapping(value="/store/join")
	public String join(Store store, HttpSession session, Model model){
		logger.info("store(id) " + store.getSid() );
		logger.info("store(email 아이디) " + store.getSemail1());
		logger.info("store(email 아이디) " + store.getSemail2());
		logger.info("store(DB 등록 이메일)" + store.getSemail());
		logger.info("store(spw) " + store.getSpw());
		logger.info("store(sname) " + store.getSname());
		logger.info("store(slocal) " + store.getSlocal());
		logger.info("store(sadder) " + store.getSaddr());
		logger.info("store(stel) "  + store.getStel());
		logger.info("store(sopen) " + store.getSopen());
		logger.info("store(sclose) " + store.getSclosed());
		logger.info("store(sbeacon) " + store.getSbeacon());
		logger.info("store(sphoto) " + store.getSphoto().length);
		
		try {
			 storeService.join(store);
			
			//=========sphoto=============================
			for(MultipartFile photo: store.getSphoto()){
					//String savedfile = new Date().getTime()+photo.getOriginalFilename();
					String savedfile = photo.getOriginalFilename();
					String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);
					
					photo.transferTo(new File(realpath));
					
					Sphoto sphoto = new Sphoto();
					sphoto.setSid(store.getSid());
					sphoto.setSpic_savedfile(savedfile);
					sphoto.setSpic_mimetype(photo.getContentType());
					
					sphotoService.write(sphoto);
			}
			//=========sphoto=============================
			model.addAttribute("result", "success");
			return "store/joinResult";
		} catch (Exception e) {
			logger.info("join 실패"+e.getMessage());
			model.addAttribute("result", "fail");
			return "store/joinResult";
		}
		
	}
	
	@RequestMapping("/store/logout")
	public String logout(HttpSession session, Model model){
		session.removeAttribute("login");
		model.addAttribute("result", "success");
		return "store/logoutResult";
	}
	
	@RequestMapping("/store/showPhoto")
	public void showPhoto(String savedfile, HttpServletRequest request,HttpServletResponse response){//이미지 다운로드 받기 위해 메소드 작성
						//보기를 원하는 파일명
		try{
			String fileName = savedfile;
			
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
	
	//post로 받는다
	@RequestMapping(value="/store/info", method=RequestMethod.GET)
	public String info(HttpSession session, Model model){
		logger.info("storemodifyForm정보");
		String sid = (String) session.getAttribute("login");
		
		Store store = storeService.info(sid);
		model.addAttribute("store", store);
		
		//===================sphoto=========================
		
		List<Sphoto> list = sphotoService.info(sid);
		model.addAttribute("list", list);
		logger.info(""+store.getSid());
		//===================sphoto=========================
		return "store/info";
	}
	
	@RequestMapping(value="/store/modify", method=RequestMethod.GET)
	public String modifyForm(HttpSession session, Model model){
		logger.info("modifyForm정보");
		String sid = (String) session.getAttribute("login");
		
		Store store = storeService.info(sid);
		model.addAttribute("store", store);
		
		//===================sphoto=========================
		
		List<Sphoto> list = sphotoService.info(sid);
		model.addAttribute("list", list);
		logger.info(""+store.getSid());
		//===================sphoto=========================
		return "store/modify";
	}
	
	@RequestMapping(value="/store/modify", method=RequestMethod.POST)
	public String modify(HttpSession session, Store store, Sphoto sphoto){
		int row = storeService.modify(store);
		logger.info("row => "+row);
		try{
		/*=========sphoto=============================*/
		String sid = (String)session.getAttribute("login");
		sphoto.setSid(sid);
		
		/*for(MultipartFile photo: sphoto.getPhoto()){
				String savedfile = new Date().getTime()+photo.getOriginalFilename();
				String realpath = session.getServletContext().getRealPath("/WEB-INF/photo/"+savedfile);
				
				photo.transferTo(new File(realpath));
				sphoto.setSpic_savedfile(savedfile);
				
				logger.info("realpath => "+realpath);
				
				sphoto.setSpic_mimetype(photo.getContentType());
				
				int result2 = sphotoService.modify(sphoto);
				logger.info("result2 => "+result2);
				
				logger.info("photo spic_id : "+ sphoto.getSpic_id());
			
		}*/
		/*=========sphoto=============================*/
		return "redirect:/store/info";
	} catch (Exception e) {
		logger.info("join 실패"+e.getMessage());
		return "store/modify";
	}
		
	}
	
	
	@RequestMapping("/store/withdraw")
	public String withdraw(HttpSession session){
		return "store/index";
	}
}