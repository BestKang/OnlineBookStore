package service;

import java.util.ArrayList;
import java.util.Map;

import bean.Pbook;
import dao.DbMethod;

public class operatebookservice {
	private  DbMethod db;
	//private Pbook pbook;
	public DbMethod getDb() {
		return db;
	}
	public void setDb(DbMethod db) {
		this.db = db;
	}
	public operatebookservice(){
		this.db=new DbMethod();
	}	
	public boolean addPBook(Pbook pbook){//实体书
		String pbookName=pbook.getPbookName();
		String pbookWriter=pbook.getPbookWriter();
		String pbookPublisher=pbook.getPbookPublisher();
		String pbookPublishTime=pbook.getPbookPublishTime();
		double pbookPrice=pbook.getPbookPrice();
		int pbookStockNumber=pbook.getPbookStockNumber();
		int pbookSoldNumber=pbook.getPbookSoldNumber();
		String pbookAbstract=pbook.getPbookAbstract();
		String pbookPictureUrl=pbook.getPbookPictureUrl();
		int pbookClickTimes=pbook.getPbookClickTimes();
		Object[] args={pbookName,pbookWriter,pbookPublisher,pbookPublishTime,pbookPrice,pbookStockNumber,pbookSoldNumber,pbookAbstract,pbookPictureUrl,pbookClickTimes};
		String sql="insert into pbook(pbookName,pbookWriter,pbookPublisher,pbookPublishTime,pbookPrice,pbookStockNumber,pbookSoldNumber,pbookAbstract,pbookPictureUrl,pbookClickTimes) "+
		"values(?,?,?,?,?,?,?,?,?,?)";
		if (db.insert(sql, args)) {
			return true;
		}		
		return false;
	}

	public boolean updatePBook(Pbook pbook){//实体书
		String pbookName=pbook.getPbookName();
		String pbookWriter=pbook.getPbookWriter();
		String pbookPublisher=pbook.getPbookPublisher();
		String pbookPublishTime=pbook.getPbookPublishTime();
		double pbookPrice=pbook.getPbookPrice();
		int pbookStockNumber=pbook.getPbookStockNumber();
		int pbookSoldNumber=pbook.getPbookSoldNumber();
		String pbookAbstract=pbook.getPbookAbstract();
		String pbookPictureUrl=pbook.getPbookPictureUrl();
		int pbookClickTimes=pbook.getPbookClickTimes();
		//Object[] args={pbookName,pbookWriter,pbookPublisher,pbookPublishTime,pbookPrice,pbookStockNumber,pbookSoldNumber,pbookAbstract,pbookPictureUrl,pbookClickTimes};
		String sql="update pbook set pbookName="+pbookName+",pbookWriter="+pbookWriter+",pbookPublisher"+pbookPublisher+",pbookPublishTime="+pbookPublishTime+
				",pbookPrice="+pbookPrice+",pbookStockNumber="+pbookStockNumber+",pbookSoldNumber="+pbookSoldNumber+
				",pbookAbstract="+pbookAbstract+",pbookPictureUrl="+pbookPictureUrl+",pbookClickTimes="+pbookClickTimes;
		if (db.update(sql)) {
			return true;
		}		
		return false;
	}
	public Pbook searchPbook(String idpbook){
		Pbook pbook =db.searchPbook(idpbook);
		return pbook;
	}
}
