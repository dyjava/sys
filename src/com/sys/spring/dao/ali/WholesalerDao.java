package com.sys.spring.dao.ali;

import java.util.List;

import com.sys.spring.domain.ali.Wholesaler;

public interface WholesalerDao {

	public int insert(Wholesaler who) ;
	
	public int update(Wholesaler who) ;
	
	public Wholesaler getById(int id) ;
	
	public List<Wholesaler> getAllWholesaler() ;
}
