package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.ExtraDao;
import com.mycompany.myweb.dao.ExtraOrderDao;
import com.mycompany.myweb.dao.OrderDao;
import com.mycompany.myweb.dao.OrderItemDao;
import com.mycompany.myweb.dto.Extra;
import com.mycompany.myweb.dto.ExtraOrder;
import com.mycompany.myweb.dto.OrderItem;
//이명진
@Component
public class ExtraOrderService {
	
	public static final int INSERT_SUCCESS = 1;
	public static final int INSERT_FAIL = 0;
	
	public static final int UPDATE_SUCCESS = 1;
	public static final int UPDATE_FAIL = 0;
	
	public static final int DELETE_SUCCESS = 1;
	public static final int DELETE_FAIL = 0;
	
	@Autowired
	ExtraOrderDao extraOrderDao;
	
	@Autowired
	ExtraDao extraDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderItemDao orderItemDao;
	
	//중요
	//1개 주문 품목에 대한 모든 사이드(xid) 검색
	public List<ExtraOrder> allExtraOrderByoneOid(int oid){
		return extraOrderDao.selectExtraOrdersByOid(oid);
	}
		
	//주문 품목 사이드오더 삽입(다수)
	public int addExtraOrder(ExtraOrder extraOrder){
		if(extraOrderDao.insertExtraOrder(extraOrder)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}
	
	//주문 품목 사이드오더 삽입(다수)(주문 시 필요)
	public int addExtraOrder(int xid, int oid){
		if(extraOrderDao.insertExtraOrder(xid, oid)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}
	
	//1개 주문 품목 사이드오더 삭제
	public int removeExtraOrder(ExtraOrder extraorder){
		if(extraOrderDao.deleteExtraOrder(extraorder)==1){
			return DELETE_SUCCESS;
		}
		return DELETE_FAIL;
	}
	//-------------------------------------------------
	
	//1개 주문 시(매칭되는) 한 품목 사이드 상세 찾기
	/*public Extra orderItemExtra(int orid){
		int xid = extraOrderDao.selectXidByOrid(orderItemDao.selectByOrid(orid).getOrid());
		Extra extra = extraDao.selectByXid(xid);
		
		return extra;//주문내역 상세보기 - 사이드에(xname)도 이용하면 됨
	}*/
	
	/*//한 주문 시 한 품목 사이드 상세 찾기
	public ExtraOrder oneXidOid(ExtraOrder extraorder){
		return extraOrderDao.selectByXidOrid(extraorder);
	}*/
	
	//1개 주문 시 한 품목 사이드 추가(ExtraDao의 selectByXid(xid)쓰임)
	/*public int writeXidOid(ExtraOrder extraorder,int xid){
		
		//Extra extra = extraDao.selectByXid(xid);
		
		if(extraOrderDao.insertXidOrid(extraorder)==1){
			return INSERT_SUCCESS;
		}
		return INSERT_FAIL;
	}*/
	
	
	
	//1개 주문 시 한 품목 사이드 고치기
	/*public int modifyXidOid(OrderReceipt orderreceipt){
		if(orderReceiptDao.update(orderreceipt)==1){
			return UPDATE_SUCCESS;
		}
		return UPDATE_FAIL;
	}*/
	
	
}
