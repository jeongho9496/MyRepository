package com.mycompany.myweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.ExtraDao;
import com.mycompany.myweb.dao.ExtraOrderDao;
import com.mycompany.myweb.dao.MenuDao;
import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dao.OrderItemDao;
import com.mycompany.myweb.dto.DetailOrder;
import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.dto.Menu;
import com.mycompany.myweb.dto.OrderItem;
//이명진
@Component
public class OrderItemService {
	
	public static final int INSERT_SUCCESS = 1;
	public static final int INSERT_FAIL = 0;
	
	public static final int UPDATE_SUCCESS = 1;
	public static final int UPDATE_FAIL = 0;
	
	public static final int DELETE_SUCCESS = 1;
	public static final int DELETE_FAIL = 0;
	
	@Autowired
	OrderItemDao orderItemtDao;
	
	@Autowired
	MenuDao menuDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ExtraOrderDao extraOrderDao;
	
	@Autowired
	ExtraDao extraDao;
	
	//중요
	//1개 주문에 대한 모든 품목 리스트 찾기
	public List<OrderItem> allOrderItemByOgid(String ogid){
		List<OrderItem> orderItems = orderItemtDao.selectOrderItemsByOgid(ogid);
		return orderItems;
	}
	
	//1개 주문에 대한 품목 찾기(주문 시 필요)
	public List<OrderItem> searchOrderItemsByOgidMid(String ogid,int mid){
		List<OrderItem> orderItems = orderItemtDao.selectOrderItemsByOgidMid(ogid,mid);
		return orderItems;
	}
	/*//1개 주문 품목 당 총 가격 구하기(메뉴+사이드)
	public int sumOnePrice(int mid, int xid){
		Menu menu = menuDao.selectByMid(mid);//어떤 메뉴인지
		Extra extra = extraOrderDao.selectByXid(xid);//어떤 사이드인지
		
		return menu.getMprice()+extra.getXprice();//하나의 품목에 대한 총 가격이며 주문 상세보기 - 가격 부분에 이용
		
	}*/
	
	//1개 주문 품목 추가(MenuDao의 selectByMid(mid)쓰임)()
	public int addOrderItem(String ogid, int mid, int ordercount){
		if(orderItemtDao.insertOrderItem(ogid, mid, ordercount)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}
	
	//1개 주문 품목 추가(MenuDao의 selectByMid(mid)쓰임)()
	/*public int writeOid(OrderItem orderitem){
		if(orderItemtDao.insertOrderItem(orderitem)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}*/
	
	
		
		
	//1개 주문 품목 제거
	public int removeByOrid(OrderItem orderitem){
		if(orderItemtDao.deleteOrderItem(orderitem)==1){
			return DELETE_SUCCESS;
		}
		return DELETE_FAIL;
	}
	
	//-------------------------------------------------
	
	/*//중요
	//1개 주문 품목에 대한 메뉴(mid) 검색
	public int oneMidByOrid(int orid){
		return orderItemtDao.selectMidByOrid(orid);
	}
	
	//중요
	//1개 주문 품목에 대한 메뉴 검색
	public Menu oneMenuByOrid(int orid){
		Menu menu = new Menu();
		menu = menuDao.selectByMid(orderItemtDao.selectMidByOrid(orid));
		return menu;
	}
			
	//중요
	//1개 주문 품목에 대한 모든 사이드 검색
	public List<Extra> allExtraByXids(List<Integer> xids){
		return extraOrderDao.selectExtrasByXids(xids);
	}
	
	//중요
	//1개 주문의 모든 품목에 대한 같은 메뉴와 사이드인 품목 카운트
	*/	
	
	
	
	
	
	//중요
		//1개 주문의 모든 품목에 대한 같은 메뉴와 사이드인 품목 카운트
		/*public List<DetailOrder> countByOrid(int oid){
			List<DetailOrder> detailOrders = new ArrayList<>();
			
			List<OrderItem> orderItems1 = new ArrayList<>();
			orderItems1 = orderItemtDao.selectOrderItemsByOid(oid);
			
			List<OrderItem> orderItems2 = new ArrayList<>();
			orderItems2 = orderItemtDao.selectOrderItemsByOid(oid);
			
			//비교 시작
			
			for(int i=0;i<orderItems1.size();i++){
				int sameItemCount = 0; int sameItemPrice = 0; int avoidIndex = 0;
				
				DetailOrder detailOrder = new DetailOrder();
				
				OrderItem orderItem1 = orderItems1.get(i);
				List<Integer> xids1 = extraOrderDao.selectXidsByOrid(orderItem1.getOrid());
				Menu menu1  = menuDao.selectByMid(orderItemtDao.selectMidByOrid(orderItem1.getOrid()));
				
				//일단 담음
				detailOrder.setMname(menu1.getMname());
				sameItemCount++;
				detailOrder.setSameItemCount(sameItemCount);
				sameItemPrice += menu1.getMprice();
				for(int k=0;k<xids1.size();k++){
					String temp = "";
					sameItemPrice += xids1.get(k);
					temp += extraDao.selectByXid(xids1.get(k)).getXname()+" ";
					detailOrder.setXname(temp);
					
				}
				detailOrder.setSameItemPrice(sameItemPrice);
				
				avoidIndex = i;
				
				for(int j=0;j<orderItems2.size();j++){
					if(j == avoidIndex){
						continue;
					}else{
						OrderItem orderItem2 = orderItems2.get(j);
						List<Integer> xids2 = extraOrderDao.selectXidsByOrid(orderItem2.getOrid());
						Menu menu2  = menuDao.selectByMid(orderItemtDao.selectMidByOrid(orderItem2.getOrid()));
						
						if(menu1.getMid() == menu2.getMid()){//같은 메뉴인 경우
							boolean sameOrNot = false;
							if(xids1.size()==xids2.size()){
								for(int k=0;k<xids1.size();k++){		
									if(xids1.get(k)==xids2.get(k)){
										sameOrNot=true;//같은 메뉴면서 사이드도 같은 경우(완전 같은 거임)
									}else{
										sameOrNot=false;//같은 메뉴면서 사이드는 다른 경우(사이드만 다른 거임)
									}
								}
								if(sameOrNot){//같은 메뉴면서 사이드도 같은 경우(완전 같은 거임)
									
								}else{//같은 메뉴면서 사이드는 다른 경우(사이드만 다른 거임)
									
								}
								
							}else{//같은 메뉴면서 사이드는 다른 경우(사이드만 다른 거임)
								
							}
						}else if(menu1.getMid() != menu2.getMid()){//다른 메뉴인 경우
							
							
						}
					}
					
				}
				
			}
			return detailOrders;
		}*/
		
	
	//1개 주문 총 가격 구하기(주문 상세보기의 총가격 에 쓰임)
	/*public Order sumAllPrice(int oid, int mid, int xid){
		Order order = orderDao.selectByOid(oid);
		List<OrderItem> list = orderItemtDao.selectByOid(oid);
		int resultAllPrice = 0;
		
		for(int i=0;i<list.size();i++){
			Menu menu = menuDao.selectByMid(list.get(i).getMid());//어떤 메뉴인지
			Extra extra = extraDao.selectByXid(extraOrderDao.selectXidByOrid(list.get(i).getOrid()));
			resultAllPrice += menu.getMprice()+extra.getXprice();
		}
		order.setOtotalprice(resultAllPrice);
		return order;
		//하나의 품목에 대한 총 가격이 담긴 order 리턴
		//order가 뭐하면 int로 변환하면 됨
	}*/
	
	//(mid, mname)
	//1개 주문에 대해 같은 이름과 사이드를 갖는 품목의 이름들을 담는 것(아메리카노 시럼추가 2개, 아이스아메리카노 샷추가 1개 이런식에서 (아메, 시럼2)
	/*public Map<Integer,String> mnameSameItem(int oid){
		int xid = 0; String mname = null;
		int xid2 = 0; String mname2 = null;
		int mid = 0;
			
		Map<Integer,String> map = new HashMap<>();
		List<OrderItem> list = orderItemtDao.selectByOid(oid);
		for(int i=0;i<list.size();i++){
			Extra extra = extraDao.selectByXid(extraOrderDao.selectXidByOrid(list.get(i).getOrid()));
			xid = extra.getXid();
			Menu menu = menuDao.selectByMid(list.get(i).getMid());
			mid = menu.getMid();
			mname = menu.getMname();
			for(int j=0;j<list.size();j++){
				Extra extra2 = extraDao.selectByXid(extraOrderDao.selectXidByOrid(list.get(i).getOrid()));
				xid2 = extra2.getXid();
				Menu menu2 = menuDao.selectByMid(list.get(i).getMid());
				mname2 = menu2.getMname();
				if(mname.equals(mname2)&&xid==xid2) map.put(mid, mname);
			}
		}
		return map;
	}*/
	
	//(mid, count)
	//1개 주문에 대해 같은 이름과 사이드를 갖는 품목을 카운트 하는 것(아메리카노 시럼추가 2개, 아이스아메리카노 샷추가 1개 이런식에서 (아메, 시럼2)
	/*public Map<Integer,Integer> countSameItem(int oid){
		int countSameItem = 0; 
		int xid = 0; String mname = null;
		int xid2 = 0; String mname2 = null;
		int mid = 0;
		
		Map<Integer,Integer> map = new HashMap<>();
		List<OrderItem> list = orderItemtDao.selectByOid(oid);
		for(int i=0;i<list.size();i++){
			Extra extra = extraDao.selectByXid(extraOrderDao.selectXidByOrid(list.get(i).getOrid()));
			xid = extra.getXid();
			Menu menu = menuDao.selectByMid(list.get(i).getMid());
			mid = menu.getMid();
			mname = menu.getMname();
			for(int j=0;j<list.size();j++){
				Extra extra2 = extraDao.selectByXid(extraOrderDao.selectXidByOrid(list.get(i).getOrid()));
				xid2 = extra2.getXid();
				Menu menu2 = menuDao.selectByMid(list.get(i).getMid());
				mname2 = menu2.getMname();
				if(mname.equals(mname2)&&xid==xid2) countSameItem++;
			}
			map.put(mid, countSameItem);
			countSameItem = 0;
		}
		return map;
	}*/
	
	//(mid, xname)
	//1개 주문에 대해 같은 이름과 사이드를 갖는 사이드이름을 반환 하는 것(아메리카노 시럼추가 2개, 아이스아메리카노 샷추가 1개 이런식에서 (아메, 시럽))
	/*public Map<Integer,String> xnameSameItem(int oid){
		String xnameSameItem = null; 
		int xid = 0; String mname = null;
		int xid2 = 0; String mname2 = null;
		int mid = 0;
			
		Map<Integer,String> map = new HashMap<>();
		List<OrderItem> list = orderItemtDao.selectByOid(oid);
		for(int i=0;i<list.size();i++){
			Extra extra = extraDao.selectByXid(extraOrderDao.selectXidByOrid(list.get(i).getOrid()));
			xid = extra.getXid();
			Menu menu = menuDao.selectByMid(list.get(i).getMid());
			mid = menu.getMid();
			mname = menu.getMname();
			for(int j=0;j<list.size();j++){
				Extra extra2 = extraDao.selectByXid(extraOrderDao.selectXidByOrid(list.get(i).getOrid()));
				xid2 = extra2.getXid();
				Menu menu2 = menuDao.selectByMid(list.get(i).getMid());
				mname2 = menu2.getMname();
				if(mname.equals(mname2)&&xid==xid2) xnameSameItem = extra.getXname();
			}
			map.put(mid, xnameSameItem);
			xnameSameItem = null;
		}
		return map;
	}*/
	
	//(mid, extra)
	//1개 주문에 대해 같은 이름과 사이드를 갖는 사이드를 반환 하는 것(아메리카노 시럼추가 2개, 아이스아메리카노 샷추가 1개 이런식에서 (아메, 시럽))
	/*public Map<Integer,Extra> xSameItem(int oid){
		//List<Extra> extraAll = null; 
		int xid = 0; String mname = null;
		int xid2 = 0; String mname2 = null;
		int mid = 0;
				
		Map<Integer,Extra> map = new HashMap<>();
		List<OrderItem> list = orderItemtDao.selectByOid(oid);
		for(int i=0;i<list.size();i++){
			Extra extra = extraDao.selectByXid(extraOrderDao.selectXidByOrid(list.get(i).getOrid()));
			xid = extra.getXid();
			Menu menu = menuDao.selectByMid(list.get(i).getMid());
			mid = menu.getMid();
			mname = menu.getMname();
			for(int j=0;j<list.size();j++){
				Extra extra2 = extraDao.selectByXid(extraOrderDao.selectXidByOrid(list.get(i).getOrid()));
				xid2 = extra2.getXid();
				Menu menu2 = menuDao.selectByMid(list.get(i).getMid());
				mname2 = menu2.getMname();
				if(mname.equals(mname2)&&xid==xid2) map.put(mid, extra);
			}
		}
		return map;
	}*/
	
	//(mid, sum)
	//1개 주문 같은 품목(이름,사이드)당 합한 가격(아메 시럽추가 2잔 6000원 이런식에서 6000)
	/*public Map<Integer,Integer> sumSameItem(int oid){
		int mid = 0; int countSameItem = 0; int mprice = 0; int xprice = 0; int sumSameItem = 0;
		
		Map<Integer,Integer> sumSameItems = new HashMap<>();
		
		Map<Integer,Integer> map1 = new HashMap<>();
		map1 = countSameItem(oid);
		Map<Integer,Extra> map2 = new HashMap<>();
		map2 = xSameItem(oid);
		
		
		Set<Map.Entry<Integer,Integer>> entrySet1 = map1.entrySet();
		Iterator<Map.Entry<Integer,Integer>> entryIterator1 = entrySet1.iterator();
		
		Set<Map.Entry<Integer,Extra>> entrySet2 = map2.entrySet();
		Iterator<Map.Entry<Integer,Extra>> entryIterator2 = entrySet2.iterator();
		
		
		while(entryIterator1.hasNext()){
			Map.Entry<Integer, Integer> entry1 = entryIterator1.next();
			Map.Entry<Integer, Extra> entry2 = entryIterator2.next();
			
			mid = entry1.getKey();
			mprice = menuDao.selectByMid(mid).getMprice();
			countSameItem = entry1.getValue();
			xprice = entry2.getValue().getXprice();
			
			sumSameItems.put(mid, (mprice+xprice)*countSameItem);
		}
			
		return sumSameItems;
	}*/
		
	
}
