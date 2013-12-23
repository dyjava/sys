package com.sys.spring.service.ali.impl;

import java.util.List;

import com.sys.spring.dao.ali.BuyDao;
import com.sys.spring.dao.ali.SaleDao;
import com.sys.spring.dao.ali.WholesalerDao;
import com.sys.spring.domain.ali.Buy;
import com.sys.spring.domain.ali.Sale;
import com.sys.spring.domain.ali.Wholesaler;
import com.sys.spring.service.ali.AliService;

public class AliServiceImpl implements AliService {

	private WholesalerDao whoDao ;
	private BuyDao buyDao ;
	private SaleDao saleDao ;
	
	public int insertWho(Wholesaler who) {
		if(who==null){
			return -1 ;
		}
		return whoDao.insert(who) ;
	}

	public int insertBuy(Buy buy) {
		if(buy==null){
			return -1 ;
		}
		return buyDao.insert(buy) ;
	}

	public int insertSale(Sale sale) {
		if(sale==null){
			return -1 ;
		}
		return saleDao.insert(sale) ;
	}

	public int updateWho(Wholesaler who) {
		if(who==null){
			return -1 ;
		}
		return whoDao.update(who) ;
	}

	public int updateBuy(Buy buy) {
		if(buy==null){
			return -1 ;
		}
		return buyDao.update(buy) ;
	}

	public int updateSale(Sale sale) {
		if(sale==null){
			return -1 ;
		}
		return saleDao.update(sale) ;
	}

	public Wholesaler getWhoById(int id) {
		return whoDao.getById(id) ;
	}

	public Buy getBuyById(int id) {
		return buyDao.getById(id) ;
	}

	public Sale getSaleById(int id) {
		return saleDao.getById(id) ;
	}

	public List<Wholesaler> getList() {
		return whoDao.getAllWholesaler() ;
	}

	public List<Buy> getList(Buy buy) {
		if(buy==null){
			return buyDao.getAll() ;
		}
		return buyDao.getAllByBuy(buy) ;
	}

	public List<Sale> getList(Sale sale) {
		if(sale==null){
			return saleDao.getAll() ;
		}
		return saleDao.getAllBySale(sale) ;
	}

	public List<Buy> getRepertory(Buy buy) {
		return buyDao.getRepertory(buy) ;
	}

	public List<Buy> getRepertory() {
		return buyDao.getRepertory(new Buy()) ;
	}

	public WholesalerDao getWhoDao() {
		return whoDao;
	}

	public void setWhoDao(WholesalerDao whoDao) {
		this.whoDao = whoDao;
	}

	public BuyDao getBuyDao() {
		return buyDao;
	}

	public void setBuyDao(BuyDao buyDao) {
		this.buyDao = buyDao;
	}

	public SaleDao getSaleDao() {
		return saleDao;
	}

	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}

	
}
