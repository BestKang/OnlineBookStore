package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.Ebook;
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
	public ArrayList<Map<String,Object>> getbook(String name){//电子书
		ArrayList<Map<String,Object>> eBookList=new ArrayList<Map<String,Object>>();
		ArrayList<Ebook> eb=db.searchebookByName(name);
		if(eb.size()==0) return null;
		for(int i=0;i<eb.size();i++){
			eBookList.add(this.ClassToMap(eb.get(i)));
		}
		return eBookList;
	}
	public ArrayList<Map<String,Object>> getPBookList(String name){//实体书
		ArrayList<Map<String,Object>> pBookList=new ArrayList<Map<String,Object>>();
		ArrayList<Pbook> pb=db.searchPbookByName(name);
		for(int i=0;i<pb.size();i++){
			pBookList.add(this.ClassToMap(pb.get(i)));
		}
		return pBookList;
	}
	public ArrayList<Map<String,Object>> getOBookList(String name){//二手书
		ArrayList<Map<String,Object>> OBookList=new ArrayList<Map<String,Object>>();
		ArrayList<Obook> ob=db.searchobookbyname(name);
		for(int i=0;i<ob.size();i++){
			OBookList.add(this.ClassToMap(ob.get(i)));
		}
		return OBookList;
	}
	
	public Map<String,Object> ClassToMap(Obook ob){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("idobook", ob.getIdobook());
		map.put("obookAbstract", ob.getObookAbstract());
		map.put("obookClickTimes", ob.getObookClickTimes());
		map.put("obookName", ob.getObookName());
		map.put("obookPictureUrl", ob.getObookPictureUrl());
		map.put("obookPrice", ob.getObookPrice());
		map.put("obookPublisher", ob.getObookPublisher());
		map.put("obookSoldNumber", ob.getObookSoldNumber());
		map.put("obookPublishTime", ob.getObookPublishTime());
		map.put("obookStockNumber", ob.getObookStockNumber());
		map.put("obookWriter", ob.getObookWriter());
		return map;
	
}
public Map<String,Object> ClassToMap(Pbook ob){
	Map<String,Object> map=new HashMap<String, Object>();
	map.put("idPbook", ob.getIdPbook());
	map.put("PbookAbstract", ob.getPbookAbstract());
	map.put("PbookClickTimes", ob.getPbookClickTimes());
	map.put("PbookName", ob.getPbookName());
	map.put("PbookPictureUrl", ob.getPbookPictureUrl());
	map.put("PbookPrice", ob.getPbookPrice());
	map.put("PbookPublisher", ob.getPbookPublisher());
	map.put("PbookSoldNumber", ob.getPbookSoldNumber());
	map.put("PbookPublishTime", ob.getPbookPublishTime());
	map.put("PbookStockNumber", ob.getPbookStockNumber());
	map.put("PbookWriter", ob.getPbookWriter());
	return map;
}
public Map<String,Object> ClassToMap(Ebook ob){
	Map<String,Object> map=new HashMap<String, Object>();
	map.put("idebook", ob.getIdebook());
	map.put("ebookAbstract", ob.getEbookAbstract());
	map.put("ebookClickTimes", ob.getEbookClickTimes());
	map.put("ebookPictureUrl", ob.getEbookPictureUrl());
	map.put("ebookPrice", ob.getEbookPrice());
	map.put("ebookSoldNumber", ob.getEbookSoldNumber());
	map.put("ebookWriter", ob.getEbookWriter());
	map.put("ebookName", ob.getEbookNameS());
	return map;
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
	
	
	public boolean addeBook(Ebook obook){//增加一本电子书
		String pbookName=obook.getEbookNameS();
		String pbookWriter=obook.getEbookWriter();
		//String pbookPublisher=obook.get;
		//String pbookPublishTime=obook.getObookPublishTime();
		double pbookPrice=obook.getEbookPrice();
		//int pbookStockNumber=obook.get;
		int pbookSoldNumber=obook.getEbookSoldNumber();
		String pbookAbstract=obook.getEbookAbstract();
		String pbookPictureUrl=obook.getEbookPictureUrl();
		int pbookClickTimes=obook.getEbookClickTimes();
		String obookUpTime=obook.getEbookTxtUrl();
		Object[] args={pbookName,pbookWriter,pbookAbstract,pbookPictureUrl,pbookClickTimes,pbookPrice,pbookSoldNumber,obookUpTime};
		String sql="insert into ebook(ebookName,ebookWriter,ebookAbstract,ebookPictureUrl,ebookClickTimes,ebookPrice,ebookSoldNumber,ebookTxtUrl) "+
		"values(?,?,?,?,?,?,?,?)";
		db.setAutoCommit();
		if (db.insert(sql, args)) {
			db.commit();
			
			return true;
		}
		db.commit();
		return false;
	}

	public boolean updateEBook(Ebook obook){//电子书信息更新
		String pbookName=obook.getEbookNameS();
		String pbookWriter=obook.getEbookWriter();
		double pbookPrice=obook.getEbookPrice();
		int pbookSoldNumber=obook.getEbookSoldNumber();
		String pbookAbstract=obook.getEbookAbstract();
		String pbookPictureUrl=obook.getEbookPictureUrl();
		int pbookClickTimes=obook.getEbookClickTimes();
		String obookUpTime=obook.getEbookTxtUrl();
		List<String> attr=new ArrayList<String>();
		List<String> value=new ArrayList<String>();
		attr.add("ebookName");
		attr.add("ebookWriter");
		//attr.add("obookPublisher");
		//attr.add("obookPublishTime");
		attr.add("ebookPrice");
		//attr.add("obookStockNumber");
		attr.add("ebookSoldNumber");
		attr.add("ebookAbstract");
		attr.add("oebookPictureUrl");
		attr.add("ebookClickTimes");
		attr.add("obookTxtUrl");
		value.add(pbookName);
		value.add(pbookWriter);
		//value.add(pbookPublisher);
		//value.add(pbookPublishTime);
		value.add(String.valueOf(pbookPrice));
		//value.add(String.valueOf(pbookStockNumber));
		value.add(String.valueOf(pbookSoldNumber));
		value.add(pbookAbstract);
		value.add(pbookPictureUrl);
		value.add(String.valueOf(pbookClickTimes));
		value.add(obookUpTime);
		db.setAutoCommit();
		if (db.update("ebook", attr, value, "where idebook='"+obook.getIdebook()+"'")) {
			db.commit();
			return true;
		}
		db.commit();
		
		/*if (db.update(sql)) {
			return true;
		}	*/	
		return false;
	}
}
