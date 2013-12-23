package com.sys.spring.service.ali;

import java.util.List;

import com.sys.spring.domain.ali.Buy;
import com.sys.spring.domain.ali.Sale;
import com.sys.spring.domain.ali.Wholesaler;

public interface AliService {

	public int insertWho(Wholesaler who) ;
	public int insertBuy(Buy buy) ;
	public int insertSale(Sale sale) ;
	
	public int updateWho(Wholesaler who) ;
	public int updateBuy(Buy buy) ;
	public int updateSale(Sale sale) ;
	
	public Wholesaler getWhoById(int id) ;
	public Buy getBuyById(int id) ;
	public Sale getSaleById(int id) ;
	
	public List<Wholesaler> getList() ;
	public List<Buy> getList(Buy buy) ;
	public List<Sale> getList(Sale sale) ;
	
	public List<Buy> getRepertory(Buy buy) ;
	public List<Buy> getRepertory() ;
}
