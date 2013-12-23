package test.com.sys.spring.dao;

import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Test;

import com.sys.spring.dao.account.AccountDao;
import com.sys.spring.domain.Account;
import com.sys.util.CommUtil;

public class AccountIncomeDaoTest extends BaseDaoTest<AccountDao> {

	public AccountIncomeDaoTest(){
		super("accountDao") ;
	}
	@Test
	public void test() {
//		fail("Not yet implemented");
	}

	//test insert account
	public void testInsertAccount(){
		Account acc = new Account() ;
		acc.setTitle("零食") ;
		acc.setMoney(10) ;
		
		acc.setKindid("3cccad50-08b2-4013-80b2-7075c33134d2") ;
		acc.setKindtitle("分类1") ;
		
		acc.setUserId("20c15fa6-0078-481b-8c76-d7ac1b45fc8e") ;
		acc.setUsername("admin") ;
		
		acc.setUid(UUID.randomUUID().toString()) ;
		acc.setDatetime(CommUtil.getNowDate()) ;
		int r = this.bean.insertAccount(acc) ;
		Assert.assertEquals(r, 1) ;
 	}
	
	//test find account by id
	public void testFindAccountById(){
		int id = 10 ;
		Account acc = this.bean.findAccountById(id ) ;
		Assert.assertEquals(id, acc.getId()) ;
	}
	
	//test update account by id
	public void testUpdateAccount(){
		int id = 10 ;
		Account acc = this.bean.findAccountById(id ) ;
		acc.setDatetime(CommUtil.getNowDate()) ;
		int r = this.bean.updateAccount(acc) ;
		Assert.assertEquals(r, 1) ;
	}
	
	//test find account list by parames
	public void testFindAccountList(){
		String begin = "2013-01-01" ;
		String end = "2014-01-01" ;
		Account account = new Account() ;
		List<Account> list = this.bean.findAccountList(begin, end, account) ;
		Assert.assertTrue(list.size()>2) ;
	}
	
	
}
