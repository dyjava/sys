package com.sys.web.struts2.ali;

import java.util.List;

import com.sys.spring.domain.ali.Buy;
import com.sys.spring.domain.ali.Sale;
import com.sys.spring.service.ali.AliService;
import com.sys.web.struts2.BaseAction;

public class SaleAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7223189751443606869L;
	private AliService aliService ;
	private Sale sale = new Sale() ;
	private List<Sale> list ;
	private List<Buy> buylist ;

	public String add(){
		buylist = this.aliService.getList(new Buy()) ;
		if(sale.getBuyer()==null){
			return ADD ;
		}
		int result = this.aliService.insertSale(sale) ;
		if(result==1){
			this.error = "成功" ;
			sale = new Sale() ;
		}
		return ADD ;
	}
	
	public String up(){
		buylist = this.aliService.getList(new Buy()) ;
		if(sale.getBuyer()==null){
			sale = this.aliService.getSaleById(sale.getId()) ;
			return UPDATE ;
		}
		int result = this.aliService.updateSale(sale) ;
		if(result == 1){
			this.error = "成功" ;
			sale = new Sale() ;
		}
		return list() ;
	}
	
	public String list(){
		buylist = this.aliService.getList(new Buy()) ;
		list = this.aliService.getList(sale) ;
		return LIST ;
	}

	public AliService getAliService() {
		return aliService;
	}
	public void setAliService(AliService aliService) {
		this.aliService = aliService;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public List<Sale> getList() {
		return list;
	}
	public void setList(List<Sale> list) {
		this.list = list;
	}
	public List<Buy> getBuylist() {
		return buylist;
	}
	public void setBuylist(List<Buy> buylist) {
		this.buylist = buylist;
	}

	
}
