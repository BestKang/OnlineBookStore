package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.operatebookservice;

//import org.omg.PortableInterceptor.SUCCESSFUL;

import com.opensymphony.xwork2.ActionSupport;

import bean.Pbook;
import dao.DbMethod;

public class adminsearchAction extends ActionSupport{
	private String idPbook;
	private Map<String, Object> dataMap;//编码统一使用utf-8 
	private String bookname;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {                  //查询搜索功能
		this.bookname = bookname;
	}
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
	public String searchexcute(){
		DbMethod dbMethod=new DbMethod();
		dataMap = new HashMap<String, Object>();
		Pbook pbook=dbMethod.searchPbook(idPbook);
		dataMap.put("Pbook", pbook);
		return SUCCESS;
	}
	public String searchbookbynameexcute(){     						//通过页面传入的书名bookname查询书籍，查询范围包括实体书、电子书、二手书
		operatebookservice operatebookservice=new operatebookservice();
		dataMap = new HashMap<String, Object>();
		DbMethod dbMethod=new DbMethod();										//dataMap.put("EBookList",EBookList);
																				//dataMap.put("PBookList",PBookList);																				//dataMap.put("OBookList",OBookList);
		List<Map<String,Object>> EBookList=new ArrayList<Map<String,Object>>();
		EBookList=operatebookservice.getbook(this.bookname);								//分别调用获取电子书，实体书，二手书的方法获取
		List<Map<String,Object>> PBookList=new ArrayList<Map<String,Object>>();
		PBookList=operatebookservice.getPBookList(this.bookname);
		List<Map<String,Object>> OBookList=new ArrayList<Map<String,Object>>();
		OBookList=operatebookservice.getOBookList(this.bookname);
		//System.out.println(EBookList.size());
		if(EBookList!=null){
			dataMap.put("EBookList",EBookList);
		}
		else dataMap.put("EBookList","电子书中无该书空");
		if(PBookList.size()>0){
			dataMap.put("PBookList",PBookList);
		}
		else
			dataMap.put("PBookList","实体书中无该书");
		if(OBookList.size()>0){
			//添加到传给前端的数据中去
			dataMap.put("OBookList",OBookList);
		}else
			dataMap.put("OBookList","二手书中无该书");
		
		//dataMap.put("Pbook", pbook);
		return SUCCESS;
	}
}
