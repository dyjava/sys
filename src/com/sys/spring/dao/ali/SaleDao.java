package com.sys.spring.dao.ali;

import java.util.List;

import com.sys.spring.domain.ali.Sale;

public interface SaleDao {

	public int insert(Sale sale) ;
	
	public int update(Sale sale) ;
	
	public Sale getById(int id) ;
	
	public List<Sale> getAll() ;
	
	public List<Sale> getAllBySale(Sale sale) ;
	
}
