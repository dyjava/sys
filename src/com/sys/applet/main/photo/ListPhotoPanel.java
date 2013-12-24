package com.sys.applet.main.photo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import com.sys.applet.ConstService;
import com.sys.applet.main.CommonPanel;
import com.sys.applet.main.util.TableFactory;
import com.sys.spring.domain.Diary;

/** 
 * by dyong 2010-9-1
 */
public class ListPhotoPanel extends CommonPanel{

    List<List<Object>> data = new ArrayList<List<Object>>() ;
    
    private int pageNo ;
    public ListPhotoPanel() {
    	
    	List<String> title = new ArrayList<String>() ;
    	title.add("UUID") ;
    	title.add("标题") ;
    	title.add("内容") ;
    	title.add("日期") ;
    	title.add("用户") ;
    	title.add("修改") ;
        table = TableFactory.createtable(title, data) ;
        
        
		super.printSearchTableModel() ;
//        
        TableFactory.freshTableData(table, getData(0)) ;
    }
    
//    查询数据
    private List<List<Object>> getData(int pageNo){
//    	查询
    	List<Diary> ulist = ConstService.diaryService.findDiaryListByUser(ConstService.user) ;
    	
//    	封装
    	int psize = 10 ;
        if(ulist!=null)
        for(int i=psize*pageNo;i<ulist.size()&&i<psize*(pageNo+1);i++){
        	List<Object> l = new ArrayList<Object>() ;
        	Diary d = ulist.get(i) ;
        	l.add(d.getUid()) ;
        	l.add(d.getTitle()) ;
        	l.add(d.getContent()) ;
        	l.add(d.getDatetime().split(" ")[0]) ;
        	l.add(d.getUsername()) ;
        	l.add("修改") ;
        	data.add(l) ;
        }
        return data ;
    }
    
    
}
