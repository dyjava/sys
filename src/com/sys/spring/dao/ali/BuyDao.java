package com.sys.spring.dao.ali;

import java.util.List;

import com.sys.spring.domain.ali.Buy;

public interface BuyDao {

	public int insert(Buy buy) ;
	
	public int update(Buy buy) ;
	
	public Buy getById(int id) ;
	
	public List<Buy> getAll() ;
	
	public List<Buy> getAllByBuy(Buy buy) ;
	
	public List<Buy> getRepertory(Buy buy) ;//查库存
}
