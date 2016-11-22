package com.mycompany.myweb.controller;


import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Bistro;
import com.mycompany.myweb.dto.StoreEvent;
import com.mycompany.myweb.dto.Light;

@Controller
public class HomeController {
	//1025
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/")
	public String index() {
		
		logger.info("index() 실행");	
		return "index";
	}
	
	@RequestMapping("/lightList")
	public String lightList( Model model ) {
		
		logger.info("lightList() 실행");	
		
		List<Light> list = new ArrayList<>();
        list.add(new Light("light1.png","light1_large.png","인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light2.png","light2_large.png","인테리어 조명1", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light3.png","light3_large.png","인테리어 조명1", "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light4.png","light4_large.png","인테리어 조명1", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light5.png","light5_large.png","인테리어 조명1", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light1.png","light1_large.png","인테리어 조명1", "거실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light2.png","light2_large.png","인테리어 조명1", "자녀방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light3.png","light3_large.png","인테리어 조명1", "화장실등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light4.png","light4_large.png","인테리어 조명1", "현관등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
        list.add(new Light("light5.png","light5_large.png","인테리어 조명1", "안방등으로 사용하면 좋습니다. 검은색 테두리와 백열등의 조화가 이쁩니다."));
		
        model.addAttribute("list", list);//객체를 jsp로 넘김
		
		return "lightList";
	}
	
	@RequestMapping("/bistroList")
	public String bistroList(Model model) {
		logger.info("bistro() 실행");
		
		List<Bistro> list = new ArrayList<>();
		list.add(new Bistro("food01.png", "food01_large.png","삼겹살", "12,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro("food02.png", "food02_large.png","양념장어구이", "34,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro("food03.png", "food03_large.png","소금장어구이", "34,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro("food04.png", "food04_large.png","비빔밥", "7,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro("food05.png", "food05_large.png","볶음밥", "7,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
        list.add(new Bistro("food06.png", "food06_large.png","떡볶이", "5,000 WON", "Information about popular Korean food dishes and local restaurant listings in the Tri-state area."));
		
        model.addAttribute("list", list);
        
        return "bistroList";
		
	}
	
	@RequestMapping("/eventList")
	public String eventList(Model model) throws ParseException {
		String estartperiod = "2016-11-18";
		String elastperiod = "2016-11-19";
		
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date start = format.parse(estartperiod);
		Date end = format.parse(elastperiod);
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy년MM월dd일 HH시mm분ss초");
		formatDate.format(start);
		formatDate.format(end);*/
		
		List<StoreEvent> list = new ArrayList<>();
		list.add(new StoreEvent(503, estartperiod, elastperiod, "자스 커피 할인 이벤트", "전품목 1000원 할인", "store1","coffee1.png"));
		
		model.addAttribute("list", list);
		
		return "eventList";
	}
	
	@RequestMapping("/getImage")
	public void getImage(String fileName, HttpServletRequest request,HttpServletResponse response){
		//직접 응답을 만들어 보내기 때문에 따로 JSP에 요청하지 않아도 된다.
		try{
			
			String mimeType = request.getServletContext().getMimeType(fileName);
			response.setContentType(mimeType);//Content-Type 설정
			
			OutputStream os = response.getOutputStream();
			
			String filePath = request.getServletContext().getRealPath("/resources/image/"+fileName);
			
			logger.info(filePath);
			
			InputStream is = new FileInputStream(filePath);
			byte[] values =new byte[1024];
			int byteNum = -1;
			while ((byteNum = is.read(values)) != -1 ) {
				os.write(values, 0, byteNum);
			}
			logger.info("android 요청" + fileName);
			os.flush();
			is.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
