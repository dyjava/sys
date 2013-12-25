package com.sys.spring.dao.ali.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.ali.WholesalerDao;
import com.sys.spring.domain.ali.Wholesaler;

public class WholesalerDaoImpl extends AbstractDBDao implements WholesalerDao {
	private static final Logger logger = Logger.getLogger(WholesalerDaoImpl.class);
	
	public int insert(Wholesaler who) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "insert into ali_wholesaler (name,info,url) values(?,?,?)" ;
		Object[] params = {who.getName(),who.getInfo(),who.getUrl()} ;
		int result = update(sqlStr, params) ;
		buf.append("|").append(sqlStr).append(" ")
		.append(who.getName()).append(",")
		.append(who.getInfo()).append(",")
		.append(who.getUrl()).append(",")
		.append("|").append(result) ;
		
		buf.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public int update(Wholesaler who) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("update ali_wholesaler set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(who.getName()!=null){
			sqlStr.append(" name=?,") ;
			params.add(who.getName()) ;
		}
		if(who.getUrl()!=null){
			sqlStr.append(" url=?,") ;
			params.add(who.getUrl()) ;
		}
		if(who.getInfo()!=null){
			sqlStr.append(" info=?,") ;
			params.add(who.getInfo()) ;
		}
		String sql = sqlStr.substring(0,sqlStr.length()-1)+ " where id=?" ;
		params.add(who.getId()) ;
		
		int result = update(sql, params.toArray()) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public List<Wholesaler> getAllWholesaler() {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from ali_wholesaler order by id ";
		Object[] params = {} ;
		List<Wholesaler> result = super.selectList(sqlStr,params, Wholesaler.class) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public Wholesaler getById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from ali_wholesaler where id = ? ";
		Object[] params = {id} ;
		Wholesaler result = super.selectObject(sqlStr,params, Wholesaler.class) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result.getId()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

}
