package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import org.omg.PortableInterceptor.SUCCESSFUL;

import com.opensymphony.xwork2.ActionSupport;

import bean.Pbook;
import dao.DbMethod;
import service.operatebookservice;

public class adminsearchAction extends ActionSupport{
	private String idPbook;
	private String bookname;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {                  //查询搜索功能
		this.bookname = bookname;
	}
	private Map<String, Object> dataMap;//编码统一使用utf-8 
	public String getIdPbook() {
		return idPbook;
	}
	public void setIdPbook(String idPbook) {
		this.idPbook = idPbook;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String searchexcute(){                                   	//通过页面传入的实体书idPook 查询书籍
		DbMethod dbMethod=new DbMethod();
		Pbook pbook=dbMethod.searchPbook(this.idPbook);			//      dataMap.put("Pbook", pbook);
		dataMap.put("Pbook", pbook);
		return SUCCESS;
	}
	public String searchbookbynameexcute(){     						//通过页面传入的书名bookname查询书籍，查询范围包括实体书、电子书、二手书
		operatebookservice operatebookservice=new operatebookservice();
		DbMethod dbMethod=new DbMethod();										//dataMap.put("EBookList",EBookList);
																				//dataMap.put("PBookList",PBookList);
																				//dataMap.put("OBookList",OBookList);
		List<Map<String,Object>> EBookList=new ArrayList<Map<String,Object>>();
		EBookList=operatebookservice.getbook(this.bookname);								//分别调用获取电子书，实体书，二手书的方法获取
		List<Map<String,Object>> PBookList=new ArrayList<Map<String,Object>>();
		PBookList=operatebookservice.getPBookList(this.bookname);
		List<Map<String,Object>> OBookList=new ArrayList<Map<String,Object>>();
		OBookList=operatebookservice.getOBookList(this.bookname);
		dataMap.put("EBookList",EBookList);
		dataMap.put("PBookList",PBookList);										//添加到传给前端的数据中去
		dataMap.put("OBookList",OBookList);
		//dataMap.put("Pbook", pbook);
		return SUCCESS;
	}
	
}
