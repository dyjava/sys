package com.sys.web.struts2.ali;

import java.util.List;

import com.sys.spring.domain.ali.Goods;
import com.sys.spring.domain.ali.GoodsTable;
import com.sys.spring.domain.ali.Wholesaler;
import com.sys.spring.service.ali.AliService;
import com.sys.web.struts2.BaseAction;

public class GoodsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2702021373400545524L;
	private AliService aliService ;
	private Goods goods = new Goods() ;
	private List<Goods> list ;
	private List<GoodsTable> tablelist ;
	private List<Wholesaler> wholist ;
	
	public String add(){
		wholist = aliService.getList() ;
		if(goods.getName()==null){
			return ADD ;
		}
		int result = this.aliService.insertGoods(goods) ;
		if(result==1){
			this.error = "成功" ;
			goods = new Goods() ;
		}
		return ADD ;
	}
	
	public String up(){
		wholist = aliService.getList() ;
		if(goods.getName()==null && goods.getState()==0){
			goods = this.aliService.getGoodsById(goods.getId()) ;
			return UPDATE ;
		}
		int result = this.aliService.updateGoods(goods) ;
		if(result == 1){
			this.error = "成功" ;
			goods = new Goods() ;
		}
		return list() ;
	}
	
	public String list(){
		wholist = aliService.getList() ;
		list = this.aliService.getList(goods) ;
		return LIST ;
	}
	
	public String table(){
		wholist = aliService.getList() ;
		
		tablelist = this.aliService.getRepertory(goods) ;
		return "table" ;
	}

	public AliService getAliService() {
		return aliService;
	}
	public void setAliService(AliService aliService) {
		this.aliService = aliService;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public List<Goods> getList() {
		return list;
	}
	public void setList(List<Goods> list) {
		this.list = list;
	}
	public List<Wholesaler> getWholist() {
		return wholist;
	}
	public void setWholist(List<Wholesaler> wholist) {
		this.wholist = wholist;
	}
	public List<GoodsTable> getTablelist() {
		return tablelist;
	}
	public void setTablelist(List<GoodsTable> tablelist) {
		this.tablelist = tablelist;
	}

}
