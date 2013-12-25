package com.sys.spring.dao.ali.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.ali.BuyDao;
import com.sys.spring.domain.ali.Buy;

public class BuyDaoImpl extends AbstractDBDao implements BuyDao {
	private static final Logger logger = Logger.getLogger(BuyDaoImpl.class);

	public int insert(Buy buy) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "insert into ali_buy (whoid,name,info,price,num,fare,date) values(?,?,?,?,?,?,?)" ;
		Object[] params = {buy.getWhoid(),buy.getName(),buy.getInfo(),buy.getPrice(),buy.getNum(),buy.getFare(),buy.getDate()} ;
		int result = update(sqlStr, params) ;
		buf.append("|").append(sqlStr).append(";")
		.append(buy.getWhoid()).append(",")
		.append(buy.getName()).append(",")
		.append(buy.getInfo()).append(",")
		.append(buy.getPrice()).append(",")
		.append(buy.getNum()).append(",")
		.append(buy.getFare()).append(",")
		.append(buy.getDate()).append(",")
		.append("|").append(result) ;
		
		buf.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public int update(Buy buy) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("update ali_buy set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(buy.getWhoid()>0){
			sqlStr.append(" whoid=?,") ;
			params.add(buy.getWhoid()) ;
		}
		if(buy.getName()!=null){
			sqlStr.append(" name=?,") ;
			params.add(buy.getName()) ;
		}
		if(buy.getInfo()!=null){
			sqlStr.append(" info=?,") ;
			params.add(buy.getInfo()) ;
		}
		if(buy.getPrice()>0){
			sqlStr.append(" price=?,") ;
			params.add(buy.getPrice()) ;
		}
		if(buy.getNum()>0){
			sqlStr.append(" num=?,") ;
			params.add(buy.getNum()) ;
		}
		if(buy.getFare()>0){
			sqlStr.append(" fare=?,") ;
			params.add(buy.getFare()) ;
		}
		if(buy.getDate()!=null){
			sqlStr.append(" date=?,") ;
			params.add(buy.getDate()) ;
		}
		String sql = sqlStr.substring(0,sqlStr.length()-1)+ " where id=?" ;
		params.add(buy.getId()) ;
		
		int result = update(sql, params.toArray()) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public List<Buy> getAll() {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from ali_buy order by whoid, id";
		Object[] params = {} ;
		List<Buy> result = super.selectList(sqlStr,params, Buy.class) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public List<Buy> getAllByBuy(Buy buy) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("select * from ali_buy where 1=1" );
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(buy.getWhoid()>0){
			sqlStr.append(" and whoid = ?") ;
			params.add(buy.getWhoid()) ;
		}
		if(buy.getDate()!=null){
			sqlStr.append(" and date= ?") ;
			params.add(buy.getDate()) ;
		}
		sqlStr.append(" order by whoid, id") ;
		List<Buy> result = super.selectList(sqlStr.toString(), params.toArray(), Buy.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public List<Buy> getRepertory(Buy buy) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("select * from ali_buy where 1=1" );
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(buy.getWhoid()>0){
			sqlStr.append(" and whoid = ?") ;
			params.add(buy.getWhoid()) ;
		}
		if(buy.getDate()!=null){
			sqlStr.append(" and date= ?") ;
			params.add(buy.getDate()) ;
		}
		List<Buy> result = super.selectList(sqlStr.toString(), params.toArray(), Buy.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public Buy getById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from ali_buy where id = ? ";
		Object[] params = {id} ;
		Buy result = super.selectObject(sqlStr,params, Buy.class) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result.getId()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

}
