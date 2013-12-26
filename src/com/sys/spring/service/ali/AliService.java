package com.sys.spring.service.ali;

import java.util.List;

import com.sys.spring.domain.ali.Buy;
import com.sys.spring.domain.ali.Goods;
import com.sys.spring.domain.ali.GoodsTable;
import com.sys.spring.domain.ali.Sale;
import com.sys.spring.domain.ali.Wholesaler;

public interface AliService {

	public int insertWho(Wholesaler who) ;
	public int insertGoods(Goods goods) ;
	public int insertBuy(Buy buy) ;
	public int insertSale(Sale sale) ;
	
	public int updateWho(Wholesaler who) ;
	public int updateGoods(Goods goods) ;
	public int updateBuy(Buy buy) ;
	public int updateSale(Sale sale) ;
	
	public Wholesaler getWhoById(int id) ;
	public Goods getGoodsById(int id) ;
	public Buy getBuyById(int id) ;
	public Sale getSaleById(int id) ;
	
	public List<Wholesaler> getList() ;
	public List<Goods> getList(Goods goods) ;
	public List<Buy> getList(Buy buy) ;
	public List<Sale> getList(Sale sale) ;
	
	public List<GoodsTable> getRepertory(Goods goods) ;
	public List<GoodsTable> getRepertory() ;
}
