package com.mycompany.empweb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.empweb.dto.Sphoto;
import com.mycompany.empweb.service.SphotoService;

@Controller
@RequestMapping("/sphoto")
public class SphotoController {
	private static final Logger logger = LoggerFactory.getLogger(SphotoController.class);
	
	@Autowired
	private SphotoService sphotoService;
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "sphoto/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Sphoto sphoto, HttpSession session){
		
		try {
			String sid = (String)session.getAttribute("login");
			sphoto.setSid(sid);
			
			for(MultipartFile photo: sphoto.getPhoto()){
			String savedfile = new Date().getTime()+photo.getOriginalFilename();
			String realpath = session.getServletContext().getRealPath("/WEB-INF/photo"+savedfile);
			
			photo.transferTo(new File(realpath));
			sphoto.setSpic_savedfile(savedfile);
			
			logger.info(realpath);
			
			sphoto.setSpic_mimetype(photo.getContentType());
			
			int result = sphotoService.write(sphoto);
			
			}
			
			return "redirect:/index";
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "sphoto/write";
		}
	}
		
		@RequestMapping("/showPhoto")
		public void showPhoto(String spic_savedfile, HttpServletRequest request, HttpServletResponse response){
			try{
				String fileName = spic_savedfile;
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
		
		
	}
	
	

