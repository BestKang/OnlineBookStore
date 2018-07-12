package action;

import java.util.Map;

//import org.omg.PortableInterceptor.SUCCESSFUL;

import com.opensymphony.xwork2.ActionSupport;

import bean.Pbook;
import dao.DbMethod;

public class adminsearchAction extends ActionSupport{
	private String idPbook;
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
	public String searchexcute(){
		DbMethod dbMethod=new DbMethod();
		Pbook pbook=dbMethod.searchPbook(idPbook);
		dataMap.put("Pbook", pbook);
		return SUCCESS;
	}
}
