package com.sys.spring.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDBDao {

	private JdbcTemplate jdbc ;

	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	/**
	 * 更新和添加
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql,Object[] params){
		if(params==null || params.length==0){
			return jdbc.update(sql) ;
		}
		return jdbc.update(sql, params) ;
	}
	
	/**
	 * 查询单条结果
	 * @param sql
	 * @param params
	 * @param T
	 * @return
	 */
	public <T> T selectObject(String sql,Object[] params,Class<?> T){
		List<T> result = selectList(sql, params, T) ;
		if(result.size()>0){
			return result.get(0) ;
		}
		return null ;
	}
	
	/**
	 * 查询多条结果
	 * @param sql
	 * @param params
	 * @param T
	 * @return
	 */
	public <T> List<T> selectList(String sql,Object[] params,Class<?> T){
		List<?> list ;
		if(params==null || params.length==0){
			list = jdbc.queryForList(sql) ;
		} else {
			list = jdbc.queryForList(sql,params) ;
		}
		if(list==null || list.size()==0){
			return new ArrayList<T>() ;
		}
		return queryToObjectList(list,T) ;
	}
	
	/**
	 * 结果列表转指定类型
	 * @param result
	 * @param T
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T> List<T> queryToObjectList(List<?> result,Class<?> T) {
		List<T> list = new ArrayList<T>() ;
		
		Iterator<?> iterator = result.iterator();
		
		while (iterator.hasNext()) {
			Map<String, Object> itmap = (Map<String, Object>) iterator.next();
			try {
				T o = (T) T.newInstance();

				mapToBean(itmap, o, T) ;
				list.add(o) ;
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list ;
	}
	
	/**
	 * 数据库返回map对象转指定类型
	 * @param map
	 * @param bean
	 * @param clas
	 */
	private void mapToBean(Map<String,Object> map,Object bean,Class<?> clas){
		if(!clas.getSuperclass().equals(Object.class)){
			this.mapToBean(map, bean, clas.getSuperclass()) ;
		}
		Field[] fs = clas.getDeclaredFields();	//获取私有属性。
		for(Field f:fs){
			if(map.containsKey(f.getName())){
				f.setAccessible(true);//设置私有、保护变量的可以访问权限。
				try {
					if(map.get(f.getName())!=null){
						String item = String.valueOf(map.get(f.getName())) ;
						if(f.getType().getName().equals("java.lang.String")){
							f.set(bean, (String)item) ;
						} else if(f.getType().getName().equals("int")){
							f.set(bean, Integer.parseInt(item)) ;
						} else if(f.getType().getName().equals("double")){
							f.set(bean, Double.parseDouble(item)) ;
						} else if(f.getType().getName().equals("long")){
							f.set(bean, Long.parseLong(item)) ;
						}
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 打印日志用的
	 * @param list
	 * @return
	 */
	protected String list2String(List<Object> list){
		StringBuffer buf = new StringBuffer() ;
		for(Object obj:list){
			buf.append(obj).append(",") ;
		}
		return buf.toString() ;
	}
}
