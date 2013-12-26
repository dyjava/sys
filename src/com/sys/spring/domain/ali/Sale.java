package com.sys.spring.domain.ali;

public class Sale {

	private int id ;
	private int goodsid ;
	private String buyer ;
	private String buyer_ww ;
	private double price ;
	private int num ;
	private double fare ;
	private String date ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getBuyer_ww() {
		return buyer_ww;
	}
	public void setBuyer_ww(String buyer_ww) {
		this.buyer_ww = buyer_ww;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
