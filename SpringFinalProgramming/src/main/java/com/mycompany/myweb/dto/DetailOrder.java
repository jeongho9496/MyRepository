package com.mycompany.myweb.dto;

//명진 - 주문, 1품목 위해 만듬
public class DetailOrder {//1품목에 대한
	private String mname;//메뉴명
	private int sameItemCount;//수량
	private String xname;//사이드 이름들
	private int sameItemPrice;//가격
	private String oghowpay;//결제방식
	private String hot_ice;//핫_아이스
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getSameItemCount() {
		return sameItemCount;
	}
	public void setSameItemCount(int sameItemCount) {
		this.sameItemCount = sameItemCount;
	}
	public String getXname() {
		return xname;
	}
	public void setXname(String xname) {
		this.xname = xname;
	}
	public int getSameItemPrice() {
		return sameItemPrice;
	}
	public void setSameItemPrice(int sameItemPrice) {
		this.sameItemPrice = sameItemPrice;
	}
	public String getOghowpay() {
		return oghowpay;
	}
	public void setOghowpay(String oghowpay) {
		this.oghowpay = oghowpay;
	}
	public String getHot_ice() {
		return hot_ice;
	}
	public void setHot_ice(String hot_ice) {
		this.hot_ice = hot_ice;
	}
	
	
	
}
