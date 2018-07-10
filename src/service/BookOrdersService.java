package service;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Ebook;
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
		//DbMethod db=new DbMethod();
		
		Map<String,Object> MapObj=new HashMap<String,Object>();
		MapObj.put("order", bookorders);
		ArrayList<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		arrayList.add(MapObj);
		//System.out.println(bookorders.getBookName());
		bookorders order=(bookorders)arrayList.get(0).get("order");
		System.out.println(order.getBookName());
		return arrayList;
	}
	
	public ArrayList<Map<String,Object>> getOrderList(user user){
		//System.out.println(2222);
		List<Object> list = new ArrayList<Object>();
		List<Object> list2 = new ArrayList<Object>();
		Map<String,Object> MapObj=new HashMap<String,Object>();
		//Pbook pbook=new Pbook();
		ArrayList<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		try {
			list=dao2.getObjectList("bean.bookorders", "idUser", user.getIdUser());
			
			//System.out.println(333);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MapObj.put("order", list);
		
		DbMethod db=new DbMethod();
		for (int i = 0; i < list.size(); i++) {
			bookorders order=(bookorders)list.get(i);
			System.out.println("循环"+i+"次");
			Pbook arr=db.searchPbookUrl(order.getBookId());
					//db.search("select PbookPictureUrl from pbook where idPbook='"+bookorders.getBookId()+"'",1,"PbookPictureUrl");
			list2.add(arr);
			//list.add(arr);
		}
		MapObj.put("Url", list2);
		arrayList.add(MapObj);
		System.out.println(arrayList);
		List<Object> list3=(List<Object>)arrayList.get(0).get("Url");
		//bookorders bd=(bookorders)list3.get(0);
		Pbook pb=(Pbook)list3.get(0);
		//System.out.println(bd.getBookName());
		System.out.println(pb.getPbookPictureUrl());

		return arrayList;
	}
}
