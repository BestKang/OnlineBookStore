package service;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.deploy.model.DDBean;

import com.mysql.jdbc.Connection;

import bean.Ebook;
import bean.Obook;
import bean.Pbook;
import bean.bookorders;
import bean.user;
import dao.Dao2;
import dao.DbMethod;

public class BookOrdersService {
	private Dao2 dao2;
	private bookorders bookorders;
	public BookOrdersService() {
		//super();
		this.dao2 = new Dao2();
		this.bookorders=null;
	}
	public ArrayList<Map<String,Object>> getorderlist(user user){
		System.out.println(2222);
		try {
			bookorders=(bookorders)dao2.getObject("bean.bookorders", "idUser", user.getIdUser());
			System.out.println(333);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String,Object> MapObj=new HashMap<String,Object>();
		MapObj.put("order", bookorders);
		ArrayList<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		arrayList.add(MapObj);
		bookorders order=(bookorders)arrayList.get(0).get("order");
		System.out.println(order.getBookName());
		return arrayList;
	}
	
	public ArrayList<Map<String,Object>> getOrderList(user user){
		//System.out.println(2222);
		List<Object> list = new ArrayList<Object>();
		
		List<Object> list2 = new ArrayList<Object>();
		
		List<Object> list4 = new ArrayList<Object>();
		
		Map<String,Object> MapObj=new HashMap<String,Object>();
		
		ArrayList<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		try {
			list=dao2.getObjectList("bean.bookorders", "idUser", user.getIdUser());			
			//list3=dao2.getObjectList("bean.bookorders", param, value)
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MapObj.put("order", list);
	/*	
		DbMethod db=new DbMethod();
		for (int i = 0; i < list.size(); i++) {
			bookorders order=(bookorders)list.get(i);
			//System.out.println("循环"+i+"次");
			Pbook arr=db.searchPbookUrl(order.getBookId());
					//db.search("select PbookPictureUrl from pbook where idPbook='"+bookorders.getBookId()+"'",1,"PbookPictureUrl");
			if (arr!=null) {
				list2.add(arr);
				System.out.println("pbookname："+arr.getPbookName());
			}
			
			Obook obook =db.searchObookUrl(order.getBookId());
			
			if (obook!=null) {
				System.out.println("obookname:"+obook.getObookName());
				list4.add(obook);
			}
			
		}
		if (list2.size()>0) {
			System.out.println("测试输出Pbook");
			MapObj.put("PbookUrl", list2);
		}
		if (list4.size()>0) {
			System.out.println("测试输出Obook");
			MapObj.put("ObookUrl", list4);
		}
		*/
		
		arrayList.add(MapObj);
		List<Object> list3=(List<Object>)arrayList.get(0).get("order");
		bookorders bd=(bookorders)list3.get(0);
		System.out.println(bd.getBookName()+bd.getPictureUrl());
		//List<Object> list3=(List<Object>)arrayList.get(0).get("Url");
		//
		//Pbook pb=(Pbook)list3.get(0);
		//System.out.println(bd.getBookName());
		//System.out.println(pb.getPbookPictureUrl());

		return arrayList;
	}
	
	
	public void insertpbookorder(Pbook pbook,user user,int number,String rcname) {
		DbMethod db=new DbMethod();
		
		String idUser=user.getIdUser();
		
		String bookId=pbook.getIdPbook();
		
		String bookName=pbook.getPbookName();
		
		int bookNumber=number;
		
		double cost = number*pbook.getPbookPrice();
		
		String shippingAddress=user.getUserAddress();
		
		String receiverName = rcname;
		
		String booktype="pbook";
		
		String pictureUrl=pbook.getPbookPictureUrl();
		
		Date ss = new Date();
		
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String finishTime = format0.format(ss.getTime());//这个就是把时间戳经过处理得到期望格式的时间
        
		Object[] args={finishTime,idUser,bookId,bookName,bookNumber,cost,shippingAddress,receiverName,booktype,pictureUrl};
		
		System.out.println("购买前");
		
		//db.setAutoCommit(false); //开启事务，相当于  start transaction;

		
		String sql="insert into bookorders(finishTime,idUser,bookId,bookName,bookNumber,cost,shippingAddress,receiverName,booktype,pictureUrl) values(?,?,?,?,?,?,?,?,?,?)";
		
		boolean isInsert=db.insert(sql,args);
		
		Object[] args2={pbook.getPbookStockNumber(),pbook.getPbookSoldNumber(),pbook.getIdPbook()};
		
		int n=pbook.getPbookStockNumber()-number;
		
		int m=pbook.getPbookSoldNumber()+number;		
		
		String sql2="update pbook set PbookStockNumber='"+n+"',PbookSoldNumber='"+m+"' where idPbook ='"+pbook.getIdPbook()+"'";
		
		boolean isUpdate=db.update(sql2,args2);
		
		System.out.println("购买后");
		
		
	}
}
