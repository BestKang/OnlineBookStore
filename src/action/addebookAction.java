package action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.Ebook;
import bean.Obook;
import service.operatebookservice;

public class addebookAction extends ActionSupport implements ModelDriven<Ebook>{
	Ebook ebook= new Ebook();
	private Map<String, Object> dataMap;
	public Ebook getEbook() {
		return ebook;
	}
	public void setEbook(Ebook ebook) {
		this.ebook = ebook;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	@Override
	public Ebook getModel() {
		// TODO Auto-generated method stub
		return ebook;
	}
	
	public String addEbookExcute(){
		 operatebookservice operatebookservice= new operatebookservice();
		if(!operatebookservice.addeBook(ebook)){
			dataMap=new HashMap<String,Object>();
			dataMap.put("addEbookResult", "添加失败");
			System.out.println("return register result:"+dataMap.get("addEbookResult"));
			return SUCCESS;
		}
		dataMap=new HashMap<String,Object>();
		dataMap.put("addEbookResult", "添加成功");
		System.out.println("return register result:"+dataMap.get("addEbookResult"));
		return SUCCESS;
	}
	
	public String updateExcute(){
		 operatebookservice operatebookservice= new operatebookservice();
		if(!operatebookservice.updateEBook(ebook)){
			dataMap=new HashMap<String,Object>();
			dataMap.put("UpdateEbookResult", "修改失败");
			System.out.println("return update result:"+dataMap.get("UpdateEbookResult"));
			return SUCCESS;
		}
		dataMap=new HashMap<String,Object>();
		dataMap.put("UpdateObookResult", "修改成功");
		System.out.println("return update result:"+dataMap.get("UpdateEbookResult"));
		return SUCCESS;
	}
}
