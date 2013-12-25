package com.sys.web.struts2.ali;

import java.util.List;

import com.sys.spring.domain.ali.Buy;
import com.sys.spring.domain.ali.Wholesaler;
import com.sys.spring.service.ali.AliService;
import com.sys.web.struts2.BaseAction;

public class BuyAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2702021373400545524L;
	private AliService aliService ;
	private Buy buy = new Buy() ;
	private List<Buy> list ;
	private List<Wholesaler> wholist ;

	public String add(){
		wholist = aliService.getList() ;
		if(buy.getName()==null){
			return ADD ;
		}
		int result = this.aliService.insertBuy(buy) ;
		if(result==1){
			this.error = "成功" ;
			buy = new Buy() ;
		}
		return ADD ;
	}
	
	public String up(){
		wholist = aliService.getList() ;
		if(buy==null || buy.getName()==null){
			buy = this.aliService.getBuyById(buy.getId()) ;
			return UPDATE ;
		}
		int result = this.aliService.updateBuy(buy) ;
		if(result == 1){
			this.error = "成功" ;
			buy = new Buy() ;
		}
		return list() ;
	}
	
	public String list(){
		wholist = aliService.getList() ;
		list = this.aliService.getList(buy) ;
		return LIST ;
	}

	public AliService getAliService() {
		return aliService;
	}
	public void setAliService(AliService aliService) {
		this.aliService = aliService;
	}
	public Buy getBuy() {
		return buy;
	}
	public void setBuy(Buy buy) {
		this.buy = buy;
	}
	public List<Buy> getList() {
		return list;
	}
	public void setList(List<Buy> list) {
		this.list = list;
	}
	public List<Wholesaler> getWholist() {
		return wholist;
	}
	public void setWholist(List<Wholesaler> wholist) {
		this.wholist = wholist;
	}

}
