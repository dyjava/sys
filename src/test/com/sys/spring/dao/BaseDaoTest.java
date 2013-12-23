package test.com.sys.spring.dao;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;
import junit.framework.TestCase;

public class BaseDaoTest<T> extends TestCase{

	protected static Logger log = Logger.getLogger(BaseDaoTest.class);
	private static ApplicationContext context ;
	public T bean ;
	static{
		context = new ClassPathXmlApplicationContext("spring-*");
		
	}
	public BaseDaoTest(){
	}
	@SuppressWarnings("unchecked")
	public BaseDaoTest(String name){
		bean = (T) context.getBean(name) ;
	}
	
	/** 结果不为空*/
	public void testResultNotNull() {
		Assert.assertNotNull(bean) ;
	}
	
}
