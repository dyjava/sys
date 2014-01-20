package com.sys.web.struts2.action;

import java.util.List;

import com.sys.spring.domain.Account;
import com.sys.spring.domain.Kind;
import com.sys.spring.service.account.AccountService;
import com.sys.spring.service.account.KindService;
import com.sys.web.struts2.BaseAction;

/** 
 * by dyong 2010-6-16
 */
public class AccountAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3029317598650587064L;

	private AccountService accountService ;
	private KindService kindService ;
	
	private Account acc = new Account() ;
	private List<Account> list ;

	private List<Kind> kindlist ;
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		kindlist = kindService.findKindList(1) ;
		if(acc.getDatetime()==null){
			acc.setDatetime(this.getDate()) ;
		}
		if(acc.getTitle()==null){
			return ADD ;
		}

		for(Kind k:kindlist){
			if(k.getId() == acc.getKid() ){
				acc.setKindtitle(k.getTitle()) ;
				acc.setKid(k.getId()) ;
				acc.setKindid(k.getUid()) ;
				break ;
			}
		}
		
		int result = accountService.insertAccount(acc,super.getUser()) ;
		
		if(result==1){
			acc = new Account() ;
			this.error = "成功" ;
		}
		return ADD ;
	}

	/**
	 * 修改
	 * @return
	 */
	public String up(){
		kindlist = kindService.findKindList(1) ;
		if(acc.getTitle()==null){
			acc = accountService.findAccountById(acc.getId(),super.getUser()) ;
			return UPDATE ;
		}

		for(Kind k:kindlist){
			if(k.getId() == acc.getKid() ){
				acc.setKindtitle(k.getTitle()) ;
				acc.setKid(k.getId()) ;
				acc.setKindid(k.getUid()) ;
				break ;
			}
		}
		
		int result = accountService.updateAccount(acc,super.getUser()) ;
		
		if(result==1){
			acc = new Account() ;
			this.error = "成功" ;
		}
		return list() ;
	}

	/**
	 * 列表
	 * @return
	 */
	public String list(){
		kindlist = kindService.findKindList(1) ;
		list = accountService.findAccountList(this.getBeginDate(),this.getEndDate(),acc,super.getUser()) ;
		return LIST ;
	}
	
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	public List<Account> getList() {
		return list;
	}
	public void setList(List<Account> list) {
		this.list = list;
	}
	public KindService getKindService() {
		return kindService;
	}
	public void setKindService(KindService kindService) {
		this.kindService = kindService;
	}
	public List<Kind> getKindlist() {
		return kindlist;
	}
	public void setKindlist(List<Kind> kindlist) {
		this.kindlist = kindlist;
	}
}
