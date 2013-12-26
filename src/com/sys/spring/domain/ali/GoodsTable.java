package com.sys.spring.domain.ali;

public class GoodsTable extends Goods {

	private int id ;
	private String name ;
	private int whoid ;
	private String whoname ;
	private int goodsid ;
	private double buy_money ;
	private int buy_num ;
	private long buy_count ;
	private double sale_money ;
	private int sale_num ;
	private long sale_count ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWhoid() {
		return whoid;
	}
	public void setWhoid(int whoid) {
		this.whoid = whoid;
	}
	public String getWhoname() {
		return whoname;
	}
	public void setWhoname(String whoname) {
		this.whoname = whoname;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public double getBuy_money() {
		return buy_money;
	}
	public void setBuy_money(double buy_money) {
		this.buy_money = buy_money;
	}
	public int getBuy_num() {
		return buy_num;
	}
	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}
	public long getBuy_count() {
		return buy_count;
	}
	public void setBuy_count(long buy_count) {
		this.buy_count = buy_count;
	}
	public double getSale_money() {
		return sale_money;
	}
	public void setSale_money(double sale_money) {
		this.sale_money = sale_money;
	}
	public int getSale_num() {
		return sale_num;
	}
	public void setSale_num(int sale_num) {
		this.sale_num = sale_num;
	}
	public long getSale_count() {
		return sale_count;
	}
	public void setSale_count(long sale_count) {
		this.sale_count = sale_count;
	}
	
	
	
}
