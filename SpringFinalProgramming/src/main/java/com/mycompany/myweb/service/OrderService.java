package com.mycompany.myweb.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dto.Order;
//명진
@Component
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;

	public static final int WRITE_SUCCESS=1;
	public static final int WRITE_FAIL=0;
	
	public static final int MODIFY_SUCCESS=1;
	public static final int MODIFY_FAIL=0;
	
	public static final int REMOVE_SUCCESS=1;
	public static final int REMOVE_FAIL=0;
		
	Logger logo = Logger.getLogger(OrderService.class);
	
	//주문 추가(완료)
	public int addOrder(Order order){
		int row = orderDao.insertOrder(order);
		if(row == 1) return WRITE_SUCCESS;
		else return WRITE_FAIL;
	}
	
	//주문 1개 조회(완료)
	public Order searchOne(String ogid){
		return orderDao.selectByOgid(ogid);
	}
	
	//주문 기간 조회(완료) 
	public List<Order> listTerm(int pageNo, int rowsPerPage, Date term1, Date term2){
		return orderDao.selectByTerm(pageNo, rowsPerPage, term1, term2);
	}
	
	//주문 가격 수정(완료)
	public int modifyOgprice(String ogid,int ogprice){
		return orderDao.updateOgprice(ogid, ogprice);
	}
	
	//주문 기간 조회(완료)(주문할 때)(지워질 듯)
	public Order searchOneByTime(Date start, Date end){
		return orderDao.selectByTime(start, end);
	}
	
	//주문 전체 조회(완료)
	public List<Order> listAll(int pageNo, int rowsPerPage){
		return orderDao.selectByPage(pageNo,rowsPerPage);
	}
	
	//주문 제거(완료)
	public int removeByOgid(String ogid){
		int row = orderDao.deleteOrder(ogid);
		if(row == 1) return REMOVE_SUCCESS;
		else return REMOVE_FAIL;
	}
	
	//주문 카운트(완료)
	public int getCount(){
		return orderDao.countOrder();
	}
	//-------------------------------------------------
}
