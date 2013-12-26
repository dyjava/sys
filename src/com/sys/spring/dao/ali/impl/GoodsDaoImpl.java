package com.sys.spring.dao.ali.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.ali.GoodsDao;
import com.sys.spring.domain.ali.Goods;
import com.sys.spring.domain.ali.GoodsTable;

public class GoodsDaoImpl extends AbstractDBDao implements GoodsDao {
	private static final Logger logger = Logger.getLogger(GoodsDaoImpl.class);
	
	public int insert(Goods goods) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "insert into ali_goods (whoid,name,info,state) values(?,?,?,?)" ;
		Object[] params = {goods.getWhoid(),goods.getName(),goods.getInfo(),goods.getState()} ;
		int result = update(sqlStr, params) ;
		buf.append("|").append(sqlStr).append(" ")
		.append(goods.getWhoid()).append(",")
		.append(goods.getName()).append(",")
		.append(goods.getInfo()).append(",")
		.append(goods.getState()).append(",")
		.append("|").append(result) ;
		
		buf.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public int update(Goods goods) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("update ali_goods set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(goods.getWhoid()>0){
			sqlStr.append(" whoid=?,") ;
			params.add(goods.getWhoid()) ;
		}
		if(goods.getName()!=null){
			sqlStr.append(" name=?,") ;
			params.add(goods.getName()) ;
		}
		if(goods.getInfo()!=null){
			sqlStr.append(" info=?,") ;
			params.add(goods.getInfo()) ;
		}
		if(goods.getState()>0){
			sqlStr.append(" state=?,") ;
			params.add(goods.getState()) ;
		}
		String sql = sqlStr.substring(0,sqlStr.length()-1)+ " where id=?" ;
		params.add(goods.getId()) ;
		
		int result = update(sql, params.toArray()) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public Goods getById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from ali_goods where id = ? ";
		Object[] params = {id} ;
		Goods result = super.selectObject(sqlStr,params, Goods.class) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(result.getId()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public List<Goods> getAll() {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		String sqlStr = "select * from ali_goods order by whoid, id";
		Object[] params = {} ;
		List<Goods> result = super.selectList(sqlStr,params, Goods.class) ;
		
		buf.append("|").append(sqlStr)
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public List<Goods> getAllByGoods(Goods goods) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		StringBuffer sqlStr = new StringBuffer("select * from ali_goods where 1=1" );
		ArrayList<Object> params = new ArrayList<Object>() ;
		if(goods.getWhoid()>0){
			sqlStr.append(" and whoid = ?") ;
			params.add(goods.getWhoid()) ;
		}
		if(goods.getState()>0){
			sqlStr.append(" and state = ?") ;
			params.add(goods.getState()) ;
		}
		sqlStr.append(" order by whoid, id") ;
		List<Goods> result = super.selectList(sqlStr.toString(), params.toArray(), Goods.class) ;

		buf.append("|").append(sqlStr)
		.append("|").append(result.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

	public List<GoodsTable> getRepertory(Goods goods) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		
		ArrayList<Object> params = new ArrayList<Object>() ;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM(" )
		.append("SELECT goods.id,goods.name,who.name whoname  FROM ali_goods goods , ali_wholesaler who WHERE goods.whoid = who.id") ;
		if(goods.getId()>0){
			sql.append(" AND goods.id=?") ;
			params.add(goods.getId()) ;
		}
		if(goods.getWhoid()>0){
			sql.append(" AND goods.whoid=?") ;
			params.add(goods.getWhoid()) ;
		}
		if(goods.getState()>0){
			sql.append(" AND goods.state=?") ;
			params.add(goods.getState()) ;
		}
		sql.append(" ORDER BY goods.id) goods ") ;
		
		sql.append("LEFT JOIN(")
		.append("SELECT goodsid,SUM(price*num+fare) buy_money,SUM(num) buy_num,COUNT(*) buy_count FROM ali_buy GROUP BY goodsid ")
		.append(") buy  ON goods.id=buy.goodsid ")

		.append("LEFT JOIN(")
		.append("SELECT goodsid,SUM(price) sale_money,SUM(num) sale_num,COUNT(*) sale_count  FROM ali_sale GROUP BY goodsid")
		.append(") sale ON goods.id= sale.goodsid ") ;


		List<GoodsTable> result = super.selectList(sql.toString(), params.toArray(), GoodsTable.class) ;

		buf.append("|").append(sql.toString())
		.append("|").append(result.size()) 
		.append("|").append(System.currentTimeMillis()-start) ;
		logger.info(buf.toString()) ;
		return result ;
	}

}
