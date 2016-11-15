package com.mycompany.myweb.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
