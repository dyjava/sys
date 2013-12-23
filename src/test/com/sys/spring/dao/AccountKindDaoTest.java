package test.com.sys.spring.dao;

import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Test;

import com.sys.spring.dao.account.KindDao;
import com.sys.spring.domain.Kind;
import com.sys.util.CommUtil;

public class AccountKindDaoTest extends BaseDaoTest<KindDao> {

	public AccountKindDaoTest(){
		super("kindDao") ;
	}
	@Test
	public void test() {
//		fail("Not yet implemented");
	}

	//test insert account
	public void testInsertKind(){
		Kind k = new Kind() ;
		k.setTitle("分类n") ;
		k.setNote("这是一个分类。") ;
		k.setParentId("1") ;
		k.setUid(UUID.randomUUID().toString()) ;
		
		int r = this.bean.insertKind(k) ;
		Assert.assertEquals(r, 1) ;
 	}
	
	//test find account by id
	public void testFindKindById(){
		int id = 4 ;
		Kind k = this.bean.findKindById(id) ;
		Assert.assertEquals(id, k.getId()) ;
	}
	
	//test update account by id
	public void testUpdateKind(){
		int id = 4 ;
		Kind k = this.bean.findKindById(id ) ;
		k.setNote("update :"+CommUtil.getNowDate()) ;
		int r = this.bean.updateKind(k) ;
		Assert.assertEquals(r, 1) ;
	}
	
	//test find account list by parames
	public void testFindKindList(){
		List<Kind> list = this.bean.findKindListByParentId(1) ;
		Assert.assertTrue(list.size()>2) ;
	}
	
	
}
