package com.sys.spring.dao.ali.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.ali.SaleDao;
import com.sys.spring.domain.ali.Sale;

public class SaleDaoImpl extends AbstractDBDao implements SaleDao {
	private static final Logger logger = Logger.getLogger(SaleDaoImpl.class);

	public int insert(Sale sale) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "insert into ali_sale (buy_id,buyer,buyer_ww,num,price,fare,date) values(?,?,?,?,?,?,?)" ;
		Object[] params = {sale.getBuy_id(),sale.getBuyer(),sale.getBuyer_ww(),sale.getNum(),sale.getPrice(),sale.getFare(),sale.getDate()} ;
		int result = update(sqlStr, params) ;
		buf.append("|").append(sqlStr).append(" ")
		.append(sale.getBuy_id()).append(",")
		.append(sale.getBuyer()).append(",")
		.append(sale.getBuyer_ww()).append(",")
		.append(sale.getNum()).append(",")
		.append(sale.getPrice()).append(",")
		.append(sale.getFare()).append(",")
		.append(sale.getDate()).append(",")
		.append("|").append(result) ;
		
		buf.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public int update(Sale sale) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("update ali_sale set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(sale.getBuy_id()>0){
			sqlStr.append(" buy_id=?,") ;
			params.add(sale.getBuy_id()) ;
		}
		if(sale.getBuyer()!=null){
			sqlStr.append(" buyer=?,") ;
			params.add(sale.getBuyer()) ;
		}
		if(sale.getBuyer_ww()!=null){
			sqlStr.append(" buyer_ww=?,") ;
			params.add(sale.getBuyer_ww()) ;
		}
		if(sale.getPrice()>0){
			sqlStr.append(" price=?,") ;
			params.add(sale.getPrice()) ;
		}
		if(sale.getNum()>0){
			sqlStr.append(" num=?,") ;
			params.add(sale.getNum()) ;
		}
		if(sale.getFare()>0){
			sqlStr.append(" fare=?,") ;
			params.add(sale.getFare()) ;
		}
		if(sale.getDate()!=null){
			sqlStr.append(" date=?,") ;
			params.add(sale.getDate()) ;
		}
		String sql = sqlStr.substring(0,sqlStr.length()-1)+ " where id=?" ;
		params.add(sale.getId()) ;
		
		int result = update(sql, params.toArray()) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public List<Sale> getAll() {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from ali_sale ";
		Object[] params = {} ;
		List<Sale> result = super.selectList(sqlStr,params, Sale.class) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public List<Sale> getAllBySale(Sale sale) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("select * from ali_sale where 1=1" );
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(sale.getBuy_id()>0){
			sqlStr.append(" and buy_id = ?") ;
			params.add(sale.getBuy_id()) ;
		}
		if(sale.getBuyer()!=null){
			sqlStr.append(" and buyer= ?") ;
			params.add(sale.getBuyer()) ;
		}
		if(sale.getDate()!=null){
			sqlStr.append(" and date= ?") ;
			params.add(sale.getDate()) ;
		}
		List<Sale> result = super.selectList(sqlStr.toString(), params.toArray(), Sale.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public Sale getById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from ali_sale where id = ? ";
		Object[] params = {id} ;
		Sale result = super.selectObject(sqlStr,params, Sale.class) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result.getId()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

}
