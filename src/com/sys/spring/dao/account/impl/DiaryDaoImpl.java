package com.sys.spring.dao.account.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sys.spring.dao.AbstractDBDao;
import com.sys.spring.dao.account.DiaryDao;
import com.sys.spring.domain.Diary;
import com.sys.spring.domain.admin.User;

/** 
 * by dyong 2010-6-16
 */
public class DiaryDaoImpl extends AbstractDBDao implements DiaryDao {
	private static final Logger log = Logger.getLogger(DiaryDaoImpl.class);
	
	public List<Diary> findDiaryListByUser(String begin, String end, Diary diary, User user) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("findDiaryListByUser") ;
		
		StringBuffer sql = new StringBuffer("select * from diary where userid=?");
		ArrayList<Object> params = new ArrayList<Object>() ;
		params.add(user.getUid()) ;
		if(begin.length()>0){
			sql.append(" and date(datetime)>=?") ;
			params.add(begin) ;
		}
		if(end.length()>0){
			sql.append(" and date(datetime)<=?") ;
			params.add(end) ;
		}
		if(diary!=null){
			if(diary.getTitle()!=null && diary.getTitle().trim().length()>0){
				sql.append(" and title like ?") ;
				params.add("%"+diary.getTitle()+"%") ;
			}
		}
		
		List<Diary> list = this.selectList(sql.toString(),params.toArray() ,Diary.class) ;

		buf.append("|").append(sql)
		.append("|").append(this.list2String(params))
		.append("|").append(list.size())
		.append("|").append(System.currentTimeMillis() - start) ;
		log.info(buf) ;
		return list;
	}

	public int insertDiary(Diary diary) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("insertDiary") ;
		
		String sql = "insert into diary (uid,title,content,datetime,userid,username) values(?,?,?,?,?,?)" ;
//		log.info(sql+"	"+diary.getUid()+"	"+diary.getTitle()+"	"+diary.getContent()
//				+"	"+diary.getDatetime()+"	"+diary.getUserId()+"	"+diary.getUserName()) ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		params.add(diary.getUid()) ;
		params.add(diary.getTitle()) ;
		params.add(diary.getContent()) ;
		params.add(diary.getDatetime()) ;
		params.add(diary.getUserId()) ;
		params.add(diary.getUsername()) ;
		
		int result = this.update(sql, params.toArray()) ;
		buf.append("|").append(sql)
		.append("|").append(this.list2String(params))
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis() - start) ;
		log.info(buf) ;
		
		return result ;
	}

	public int updateDiary(Diary diary) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("updateDiary") ;
		
		StringBuffer sql = new StringBuffer("update diary set ") ;
		ArrayList<Object> params = new ArrayList<Object>() ;
		
		if(diary.getTitle()!=null){
			sql.append(" title=? ,") ;
			params.add(diary.getTitle()) ;
		}
		if(diary.getContent()!=null){
			sql.append(" content=? ,") ;
			params.add(diary.getContent()) ;
		}
		
		sql.append(" id=?").append(" where id=?") ;
		params.add(diary.getId()) ;
		params.add(diary.getId()) ;

		int result = this.update(sql.toString(), params.toArray()) ;
		buf.append("|").append(sql)
		.append("|").append(this.list2String(params))
		.append("|").append(result)
		.append("|").append(System.currentTimeMillis() - start) ;
		log.info(buf) ;
		
		return result ;
	}

	public Diary findDiaryById(int id) {
		long start = System.currentTimeMillis() ;
		StringBuffer buf = new StringBuffer() ;
		buf.append(this.getClass().getName()).append("|").append("findDiaryById") ;
		
		String sql = "select * from diary where id = ? ";
		
		List<Diary> list = this.selectList(sql ,new Object[] {id} ,Diary.class) ;

		buf.append("|").append(sql)
		.append("|").append(id)
		.append("|").append(list.size())
		.append("|").append(System.currentTimeMillis() - start) ;
		log.info(buf) ;
		
		if(list==null || list.size()==0){
			return new Diary() ;
		} else {
			return list.get(0) ;
		}
	}

}
