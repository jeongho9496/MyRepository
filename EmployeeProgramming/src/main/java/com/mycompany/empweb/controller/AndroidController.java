package com.mycompany.empweb.controller;


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

import com.mycompany.empweb.dto.Event;
import com.mycompany.empweb.dto.Extra;
import com.mycompany.empweb.dto.Menu;
import com.mycompany.empweb.dto.Order;
import com.mycompany.empweb.dto.OrderItem;
import com.mycompany.empweb.dto.Sphoto;
import com.mycompany.empweb.dto.Store;
import com.mycompany.empweb.dto.User;
import com.mycompany.empweb.service.EventService;
import com.mycompany.empweb.service.ExtraOrderService;
import com.mycompany.empweb.service.ExtraService;
import com.mycompany.empweb.service.MenuService;
import com.mycompany.empweb.service.OrderItemService;
import com.mycompany.empweb.service.OrderService;
import com.mycompany.empweb.service.SphotoService;
import com.mycompany.empweb.service.StoreService;
import com.mycompany.empweb.service.UserService;

@Controller
public class AndroidController {

	private static final Logger logger = LoggerFactory.getLogger(AndroidController.class);
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private SphotoService sphotoService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ExtraService extraService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private ExtraOrderService extraOrderService;
	
	@RequestMapping("/eventAndroid")
	public String getEvent(int sbeacon, Model model){
		Store store = storeService.findStore(sbeacon);

		String sid = store.getSid();
		
		List<Event> eventList = eventService.getEventList(sid);
		
		model.addAttribute("store", store);		
		
		model.addAttribute("list", eventList);
		
		logger.info("android 요청");
		logger.info("kjh sid : " + sid);
		
		return "android/eventAndroid";
	}
	
	@RequestMapping("/storeAndroid")
	public String getStore(String sid, Model model){
		Store store = storeService.info(sid);

		model.addAttribute("store", store);		
		
		logger.info("android 요청");
		
		return "android/storeAndroid";
	}
	
	@RequestMapping("/sphotoAndroid")
	public String getSphoto(String sid, Model model){
		
		//===================sphoto=========================
		List<Sphoto> list = sphotoService.info(sid);
		model.addAttribute("list", list);
		//===================sphoto=========================
		
		return "android/sphotoAndroid";
	}
	
	/*@RequestMapping("/menuAndroid")
	public String getMenu(String sid, Model model){
		
		logger.info("menuAndroid 실행");
		if(sid.equals("store444")){
		//List<Menu> list = menuService.list(pageNo, rowsPerPage, sid);
		List<Menu> list = new ArrayList<>();
		list.add(new Menu(1, "커피", "아메리카노", "HOT", 3000, "따뜻한 아메리카노", "coffee1.png", "store444"));
		list.add(new Menu(2, "커피", "아메리카노", "ICED", 3500, "차가운 아메리카노", "coffee2.png", "store444"));
		list.add(new Menu(3, "차", "홍차", "HOT", 5000, "따뜻한 홍차", "tea1.png", "store444"));
		list.add(new Menu(4, "차", "홍차", "ICED", 5500, "차가운 홍차", "tea2.png", "store444"));
		list.add(new Menu(5, "커피", "헤이즐넛", "HOT", 5000, "따뜻한 헤이즐넛", "coffee3.png", "store444"));
		list.add(new Menu(6, "커피", "헤이즐넛", "ICED", 5500, "차가운 헤이즐넛", "coffee4.png", "store444"));
		list.add(new Menu(7, "케익", "트라미수", "없음", 7000, "티라미슈 케익", "cake1.png", "store444"));
		list.add(new Menu(8, "베이글", "치즈베이글", "없음", 6000, "치즈 베이글", "etc1.png", "store444"));
		
		model.addAttribute("list",list);
		}
		return "android/menuAndroid";
	}*/
	
	@RequestMapping(value="/menuAndroid")
	public String list(String sid, String pageNo, Model model, HttpSession session){
		
	
		/*int intPageNo = 1;
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
		}*/
		
		int intPageNo = 1;
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		int rowsPerPage = 8;
		List<Menu> list = menuService.list(intPageNo, rowsPerPage, sid);
		
		model.addAttribute("sid",sid);
		/*model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNo", totalBoardNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);*/
		model.addAttribute("list", list);
		
		return "android/menuAndroid";
	} // list
	
	// 페이징+그룹핑 기능 리스트
		@RequestMapping(value="/menuGroupAndroid")
		public String mgroupList(String sid, String mgroup, String pageNo, Model model, HttpSession session){
			logger.info("메뉴리스트 그룹+페이징 컨트롤러");
		
			if(mgroup.equals("전체")) mgroup = null;
			
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
			
			logger.info(""+totalBoardNo);
			
			if (totalBoardNo == 0){
				totalBoardNo = 1;
			}
			
			logger.info("if문 처리 후"+totalBoardNo);
			
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
			
			model.addAttribute("sid",sid);
			model.addAttribute("mgroup", mgroup);
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
			return "android/menuGroupAndroid";
		
		} // menuList
	
	/*@RequestMapping("/detailMenuAndroid")
	public String getDetailMenu(int mid, Model model){
		logger.info("detailMenuAndroid 실행");
		
		if(mid == 1){
		Menu menu = new Menu(1, "커피", "아메리카노", "HOT", 3000, "따뜻한 아메리카노", "coffee1.png", "store444");
		model.addAttribute("menu", menu);
		} else if(mid == 2){
			Menu menu = new Menu(2, "커피", "아메리카노", "ICED", 3500, "차가운 아메리카노", "coffee2.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 3){
			Menu menu = new Menu(3, "차", "홍차", "HOT", 5000, "따뜻한 홍차", "tea1.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 4){
			Menu menu = new Menu(4, "차", "홍차", "ICED", 5500, "차가운 홍차", "tea2.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 5){
			Menu menu = new Menu(5, "커피", "헤이즐넛", "HOT", 5000, "따뜻한 헤이즐넛", "coffee3.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 6){
			Menu menu = new Menu(6, "커피", "헤이즐넛", "ICED", 5500, "차가운 헤이즐넛", "coffee4.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 7){
			Menu menu = new Menu(7, "케익", "트라미수", "없음", 7000, "티라미슈 케익", "cake1.png", "store444");
			model.addAttribute("menu", menu);
		} else if(mid == 8){
			Menu menu = new Menu(8, "베이글", "치즈베이글", "없음", 6000, "치즈 베이글", "etc1.png", "store444");
			model.addAttribute("menu", menu);
		}
		
		return "android/detailMenuAndroid";
		
	}*/
	
	
		
	@RequestMapping(value="/detailMenuAndroid")
	public String info(int mid, Model model){
		Menu menu = menuService.info(mid);
		menuService.modify(menu);
		model.addAttribute("menu", menu);
		return "android/detailMenuAndroid";
	} 
	
	@RequestMapping(value="/joinAndroid", method=RequestMethod.POST)
	public String join(User user, Model model){
			String strResult = "JOIN_SUCCESS";
			int result = userService.join(user);
			if(result == UserService.JOIN_FAIL) {
			logger.info("회원가입 실패");
			strResult = "JOIN_FAIL";
			
			} 
			logger.info("회원가입 성공"+strResult);
			//model.addAttribute("user", user);
			model.addAttribute("result", result);
			return "android/joinAndroid";
	}
	
	@RequestMapping(value="/loginAndroid", method=RequestMethod.POST)
	public String login(String user_id, String user_pw, HttpSession session, Model model){
		String strResult = "LOGIN_SUCCESS";
		int result = userService.login(user_id, user_pw);

		if (result == UserService.LOGIN_FAIL_USER_PW) {
			model.addAttribute("error","LOGIN_FAIL_USER_PW");
			strResult = "LOGIN_FAIL_USER_PW";
		
		} else if(result == UserService.LOGIN_FAIL_USER_ID) {
			model.addAttribute("error","LOGIN_FAIL_USER_ID");
			strResult = "LOGIN_FAIL_USER_ID";
		
		}
			logger.info(""+result);
			//session.setAttribute("login", user_id);//성공 시 session에 저장	
			model.addAttribute("result", strResult);
			return "android/loginAndroid";
	}
	
	@RequestMapping(value="/orderTotalAndroid", method=RequestMethod.POST)
	public String orderForm(String howpay, String sid, int ogtotalprice,String user_id, int ordercount,
			String orderSize, String orderSyrup, String orderShot, int mid, Model model, HttpSession session){
		String strResult = "WRITE_SUCCESS";
		
		String ogid= null;
		long time = System.currentTimeMillis();
		double random = Math.random();
		ogid = ""+sid+time+random;
			
		Order order = new Order();	
		/*ogid = (String) session.getAttribute("ogid");	*/
		order.setOgid(ogid);
		order.setOgtotalprice(ogtotalprice);//우선 0으로 초기화 -> 주문이 완료되면 수정되게 함
		order.setUser_id(user_id);//임의 데이터!
		order.setSid(sid);
		order.setOghowpay(howpay);//임의 데이터!
			
		int result = orderService.addOrder(order);
		
		if (result == OrderService.WRITE_FAIL) {
			model.addAttribute("error","WRITE_FAIL");
			strResult = "WRITE_FAIL";
		} 
		logger.info(""+result);
		//session.setAttribute("login", user_id);//성공 시 session에 저장	
		model.addAttribute("result", strResult);
		
		
		
		//---------------------------------------------------------------------------------
		
		Extra extra1 = extraService.infoByXname(orderSize);
		Extra extra2 = extraService.infoByXname(orderSyrup);
		Extra extra3 = extraService.infoByXname(orderShot);
		int xid1 = extra1.getXid();
		int xid2 = extra2.getXid();
		int xid3 = extra3.getXid();
		
		orderItemService.addOrderItem(ogid, mid, ordercount);
		
		List<OrderItem> orderItems = orderItemService.searchOrderItemsByOgidMid(ogid,mid);
		
		extraOrderService.addExtraOrder(xid1,orderItems.get(0).getOid());
		extraOrderService.addExtraOrder(xid2,orderItems.get(0).getOid());
		extraOrderService.addExtraOrder(xid3,orderItems.get(0).getOid());
			
		
		return "android/orderTotalAndroid";
	}
	
	
	//menu test
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
