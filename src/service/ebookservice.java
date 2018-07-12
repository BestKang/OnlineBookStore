package service;

import java.util.ArrayList;
import java.util.List;

import bean.Ebook;
import bean.Pbook;
import dao.DbMethod;

public class ebookservice {
	private  DbMethod db;

	public DbMethod getDb() {
		return db;
	}

	public void setDb(DbMethod db) {
		this.db = db;
	}
	public ebookservice(){
		db= new DbMethod();
	}
	public boolean addEBook(Ebook ebook){//增加一本实体书
		
		String pbookName=ebook.getEbookName();
		String pbookWriter=ebook.getEbookWriter();
		double pbookPrice=ebook.getEbookPrice();
		int pbookSoldNumber=ebook.getEbookSoldNumber();
		String pbookAbstract=ebook.getEbookAbstract();
		String pbookPictureUrl=ebook.getEbookPictureUrl();
		int pbookClickTimes=ebook.getEbookClickTimes();
		String lastUpdateTime = ebook.getLastUpdateTime();
		String txtUrl=ebook.getEbookTxtUrl();
		Object[] args={pbookName,pbookWriter,pbookAbstract,pbookPictureUrl,pbookClickTimes,pbookPrice,pbookSoldNumber,txtUrl,lastUpdateTime};
		String sql="insert into ebook(ebookName,ebookWriter,ebookAbstract,ebookPictureUrl,ebookClickTimes,ebookPrice,ebookSoldNumber,ebookTxtUrl,lastUpdateTime) "+
		"values(?,?,?,?,?,?,?,?,?)";
		db.setAutoCommit();
		if (db.insert(sql, args)) {
			db.commit();
			return true;
		}
		db.commit();
		return false;
	}

	public boolean updateEBook(Ebook ebook){//实体书信息更新
		String idebook =ebook.getIdebook();
		String pbookName=ebook.getEbookName();
		String pbookWriter=ebook.getEbookWriter();
		double pbookPrice=ebook.getEbookPrice();
		int pbookSoldNumber=ebook.getEbookSoldNumber();
		String pbookAbstract=ebook.getEbookAbstract();
		String pbookPictureUrl=ebook.getEbookPictureUrl();
		int pbookClickTimes=ebook.getEbookClickTimes();
		String lastUpdateTime = ebook.getLastUpdateTime();
		String txtUrl=ebook.getEbookTxtUrl();

		List<String> attr=new ArrayList<String>();
		List<String> value=new ArrayList<String>();
		attr.add("ebookName");
		attr.add("ebookWriter");
		attr.add("ebookAbstract");
		attr.add("ebookPictureUrl");
		attr.add("ebookClickTimes");
		attr.add("ebookPrice");
		attr.add("ebookSoldNumber");
		attr.add("ebookTxtUrl");
		attr.add("lastUpdateTime");
		
		value.add(pbookName);
		value.add(pbookWriter);
		value.add(pbookAbstract);
		value.add(pbookPictureUrl);
		value.add(String.valueOf(pbookClickTimes));
		value.add(String.valueOf(pbookPrice));		
		value.add(String.valueOf(pbookSoldNumber));
		value.add(txtUrl);
		value.add(lastUpdateTime);
		db.setAutoCommit();	
		if (db.update("ebook", attr, value, "where idebook='"+ebook.getIdebook()+"'")) {
			db.commit();
			return true;
		}
		db.commit();
		/*if (db.update(sql)) {
			return true;
		}	*/	
		return false;
	}
	public Ebook searchEbook(String idpbook){//查找一本实体书信息
		db.setAutoCommit();
		Ebook pbook =db.searchEbook(idpbook);
		db.commit();
		return pbook;
	}
	
	/*	
	public boolean DeletePBook(String id){//实体书下架库存清零
			
		String sql="update pbook set pbookStockNumber='"+0+"' where idPbook='"+id+"'";
		if (db.update(sql)) {
			return true;
		}		
		return false;
	}*/
}
