package action;


import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.Ebook;
import bean.NewUserBean;
import bean.Obook;
import bean.Pbook;
import service.operatebookservice;
import service.registerService;
import service.updateUserInfo;

	public class addobookAction extends ActionSupport implements ModelDriven<Obook>{
		//private Pbook pbook=new Pbook();
		private Obook obook=new Obook();
		//private Ebook ebook=new Ebook();
		private Map<String, Object> dataMap;
		//private operatebookservice operatebookservice;
		public addobookAction() {
			// TODO Auto-generated constructor stub
		}
		
		public Obook getObook() {
			return obook;
		}

		public void setObook(Obook obook) {
			this.obook = obook;
		}

		public Map<String, Object> getDataMap() {
			return dataMap;
		}
		public void setDataMap(Map<String, Object> dataMap) {
			this.dataMap = dataMap;
		}
		@Override
		public Obook getModel() {
			// TODO Auto-generated method stub
			return obook;
		}
		
		public String addobookExcute(){
			 operatebookservice operatebookservice= new operatebookservice();
			if(!operatebookservice.addoBook(obook)){
				dataMap=new HashMap<String,Object>();
				dataMap.put("addobookResult", "添加失败");
				System.out.println("return register result:"+dataMap.get("addobookResult"));
				return SUCCESS;
			}
			dataMap=new HashMap<String,Object>();
			dataMap.put("addobookResult", "添加成功");
			System.out.println("return register result:"+dataMap.get("addobookResult"));
			return SUCCESS;
		}
		
		public String updateExcute(){
			 operatebookservice operatebookservice= new operatebookservice();
			if(!operatebookservice.updateOBook(obook)){
				dataMap=new HashMap<String,Object>();
				dataMap.put("UpdateObookResult", "修改失败");
				System.out.println("return update result:"+dataMap.get("UpdateObookResult"));
				return SUCCESS;
			}
			dataMap=new HashMap<String,Object>();
			dataMap.put("UpdateObookResult", "修改成功");
			System.out.println("return update result:"+dataMap.get("UpdateObookResult"));
			return SUCCESS;
		}
	
	}