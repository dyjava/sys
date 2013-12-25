package com.sys.web.struts2.ali;

import java.util.List;

import com.sys.spring.domain.ali.Wholesaler;
import com.sys.spring.service.ali.AliService;
import com.sys.web.struts2.BaseAction;

public class WhoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9141899163638438423L;
	private AliService aliService ;
	private Wholesaler who = new Wholesaler() ;
	private List<Wholesaler> list ;
	
	public String add(){
		if(who.getName()==null){
			return ADD ;
		}
		int result = this.aliService.insertWho(who) ;
		if(result == 1){
			this.error = "成功" ;
			who = new Wholesaler() ;
		}
		return ADD ;
	}
	
	public String up(){
		if(who.getName()==null){
			who = this.aliService.getWhoById(who.getId()) ;
			return UPDATE ;
		}
		this.aliService.updateWho(who) ;
		return list() ;
	}
	
	public String list(){
		list = this.aliService.getList() ;
		return LIST ;
	}

	public AliService getAliService() {
		return aliService;
	}
	public void setAliService(AliService aliService) {
		this.aliService = aliService;
	}
	public Wholesaler getWho() {
		return who;
	}
	public void setWho(Wholesaler who) {
		this.who = who;
	}
	public List<Wholesaler> getList() {
		return list;
	}
	public void setList(List<Wholesaler> list) {
		this.list = list;
	}
	
	
}
