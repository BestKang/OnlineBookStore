package service;

import java.util.HashMap;
import java.util.Map;

import bean.Pbook;
import dao.DbMethod;

public class SearchBar {
	private DbMethod db;
	public SearchBar(){
		this.db=new DbMethod();
	}
	public DbMethod getDb() {
		return db;
	}
	public void setDb(DbMethod db) {
		this.db = db;
	}
	public Map<String,Object> getOneBook(String bookName){
		/*Pbook pbo=new Pbook();
		pbo=db.searchOne("select * from pbook where bookName like '%"+bookName+"%'");
		if(pbo!=null){
			System.out.println("在实体书中已找到");
			Map<String,Object> map=new HashMap<String, Object>();
			map=new getBookList().ClassToMap(pbo);
			return map;
		}*/
		return null;
	}
	

}
