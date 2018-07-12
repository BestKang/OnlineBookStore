package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Obook;
import bean.Pbook;
import dao.DbMethod;

public class operatebookservice {
	private  DbMethod db;
	private String pbookAbstract;
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
	public boolean addPBook(Pbook pbook){//增加一本实体书
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
		db.setAutoCommit();
		if (db.insert(sql, args)) {
			db.commit();
			return true;
		}
		db.commit();
		return false;
	}

	public boolean updatePBook(Pbook pbook){//实体书信息更新
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
//		String sql="update pbook set pbookName="+pbookName+",pbookWriter="+pbookWriter+",pbookPublisher"+pbookPublisher+",pbookPublishTime="+pbookPublishTime+
//				",pbookPrice="+pbookPrice+",pbookStockNumber="+pbookStockNumber+",pbookSoldNumber="+pbookSoldNumber+
//				",pbookAbstract="+pbookAbstract+",pbookPictureUrl="+pbookPictureUrl+",pbookClickTimes="+pbookClickTimes+"where idPbook="+pbook.getIdPbook();
		List<String> attr=new ArrayList<String>();
		List<String> value=new ArrayList<String>();
		attr.add("pbookName");
		attr.add("pbookWriter");
		attr.add("pbookPublisher");
		attr.add("pbookPublishTime");
		attr.add("pbookPrice");
		attr.add("pbookStockNumber");
		attr.add("pbookSoldNumber");
		attr.add("pbookAbstract");
		attr.add("pbookPictureUrl");
		attr.add("pbookClickTimes");
		value.add(pbookName);
		value.add(pbookWriter);
		value.add(pbookPublisher);
		value.add(pbookPublishTime);
		value.add(String.valueOf(pbookPrice));
		value.add(String.valueOf(pbookStockNumber));
		value.add(String.valueOf(pbookSoldNumber));
		value.add(pbookAbstract);
		value.add(pbookPictureUrl);
		value.add(String.valueOf(pbookClickTimes));
		db.setAutoCommit();
		if (db.update("pbook", attr, value, "where idPbook='"+pbook.getIdPbook()+"'")) {
			db.commit();
			return true;
		}
		db.commit();
		/*if (db.update(sql)) {
			return true;
		}	*/	
		return false;
	}
	public Pbook searchPbook(String idpbook){//查找一本实体书信息
		Pbook pbook =db.searchPbook(idpbook);
		return pbook;
	}
	
		
	public boolean DeletePBook(String id){//实体书下架库存清零
			
		String sql="update pbook set pbookStockNumber='"+0+"' where idPbook='"+id+"'";
		db.setAutoCommit();
		if (db.update(sql)) {
			db.commit();
			return true;
		}		
		db.commit();
		return false;
	}
	
	public boolean addoBook(Obook obook){//增加一本二手书
		String pbookName=obook.getObookName();
		String pbookWriter=obook.getObookWriter();
		String pbookPublisher=obook.getObookPublisher();
		String pbookPublishTime=obook.getObookPublishTime();
		double pbookPrice=obook.getObookPrice();
		int pbookStockNumber=obook.getObookStockNumber();
		int pbookSoldNumber=obook.getObookSoldNumber();
		String pbookAbstract=obook.getObookAbstract();
		String pbookPictureUrl=obook.getObookPictureUrl();
		int pbookClickTimes=obook.getObookClickTimes();
		String obookUpTime=obook.getObookUpTime();
		Object[] args={pbookName,pbookWriter,pbookPublisher,pbookPublishTime,pbookPrice,pbookStockNumber,pbookSoldNumber,pbookAbstract,pbookPictureUrl,pbookClickTimes,obookUpTime};
		String sql="insert into obook(obookName,obookWriter,obookPublisher,obookPublishTime,obookPrice,obookStockNumber,obookSoldNumber,obookAbstract,obookPictureUrl,obookClickTimes,obookUpTime) "+
		"values(?,?,?,?,?,?,?,?,?,?,?)";
		db.setAutoCommit();
		if (db.insert(sql, args)) {
			db.commit();
			
			return true;
		}
		db.commit();
		return false;
	}

	public boolean updateOBook(Obook obook){//二手书信息更新
		String pbookName=obook.getObookName();
		String pbookWriter=obook.getObookWriter();
		String pbookPublisher=obook.getObookPublisher();
		String pbookPublishTime=obook.getObookPublishTime();
		double pbookPrice=obook.getObookPrice();
		int pbookStockNumber=obook.getObookStockNumber();
		int pbookSoldNumber=obook.getObookSoldNumber();
		String pbookAbstract=obook.getObookAbstract();
		String pbookPictureUrl=obook.getObookPictureUrl();
		int pbookClickTimes=obook.getObookClickTimes();
		String obookUpTime=obook.getObookUpTime();
		List<String> attr=new ArrayList<String>();
		List<String> value=new ArrayList<String>();
		attr.add("obookName");
		attr.add("obookWriter");
		attr.add("obookPublisher");
		attr.add("obookPublishTime");
		attr.add("obookPrice");
		attr.add("obookStockNumber");
		attr.add("obookSoldNumber");
		attr.add("obookAbstract");
		attr.add("obookPictureUrl");
		attr.add("obookClickTimes");
		attr.add("obookUpTime");
		value.add(pbookName);
		value.add(pbookWriter);
		value.add(pbookPublisher);
		value.add(pbookPublishTime);
		value.add(String.valueOf(pbookPrice));
		value.add(String.valueOf(pbookStockNumber));
		value.add(String.valueOf(pbookSoldNumber));
		value.add(pbookAbstract);
		value.add(pbookPictureUrl);
		value.add(String.valueOf(pbookClickTimes));
		value.add(obookUpTime);
		db.setAutoCommit();
		if (db.update("obook", attr, value, "where idobook='"+obook.getIdobook()+"'")) {
			db.commit();
			return true;
		}
		db.commit();
		
		/*if (db.update(sql)) {
			return true;
		}	*/	
		return false;
	}
	public Obook searchObook(String idobook){//查找一本二手书信息
		Obook pbook =db.searchObook(idobook);
		return pbook;
	}
	
		
	public boolean DeleteOBook(String id){//二手书下架库存清零
			
		String sql="update obook set obookStockNumber='"+0+"' where idobook='"+id+"'";
		db.setAutoCommit();
		if (db.update(sql)) {
			db.commit();
			return true;
		}	
		db.commit();
		return false;
	}
}
