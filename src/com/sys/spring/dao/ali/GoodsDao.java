package com.sys.spring.dao.ali;

import java.util.List;

import com.sys.spring.domain.ali.Goods;
import com.sys.spring.domain.ali.GoodsTable;

public interface GoodsDao {

	public int insert(Goods goods) ;
	
	public int update(Goods goods) ;
	
	public Goods getById(int id) ;
	
	public List<Goods> getAll() ;
	
	public List<Goods> getAllByGoods(Goods goods) ;
	
	public List<GoodsTable> getRepertory(Goods goods) ;//查库存
}
