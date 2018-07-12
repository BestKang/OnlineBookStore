package action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bean.NewUserBean;
import bean.Pbook;
import service.operatebookservice;
import service.registerService;
import service.updateUserInfo;

	public class adminAddAction extends ActionSupport implements ModelDriven<Pbook>{
		private Pbook pbook=new Pbook();
		private Map<String, Object> dataMap;
		//private operatebookservice operatebookservice;
		public adminAddAction() {
			// TODO Auto-generated constructor stub
		}
		
		public Pbook getPbook() {
			return pbook;
		}

		public void setPbook(Pbook pbook) {
			this.pbook = pbook;
		}

		public Map<String, Object> getDataMap() {
			return dataMap;
		}
		public void setDataMap(Map<String, Object> dataMap) {
			this.dataMap = dataMap;
		}
		@Override
		public Pbook getModel() {
			// TODO Auto-generated method stub
			return pbook;
		}
		public String addExcute(){
			 operatebookservice operatebookservice= new operatebookservice();
			if(!operatebookservice.addPBook(pbook)){
				dataMap=new HashMap<String,Object>();
				dataMap.put("addPbookResult", "添加失败");
				System.out.println("return register result:"+dataMap.get("addPbookResult"));
				return SUCCESS;
			}
			dataMap=new HashMap<String,Object>();
			dataMap.put("addPbookResult", "添加成功");
			System.out.println("return register result:"+dataMap.get("addPbookResult"));
			return SUCCESS;
		}
		public String updateExcute(){
			 operatebookservice operatebookservice= new operatebookservice();
			if(!operatebookservice.updatePBook(pbook)){
				dataMap=new HashMap<String,Object>();
				dataMap.put("UpdateResult", "修改失败");
				System.out.println("return update result:"+dataMap.get("UpdateResult"));
				return SUCCESS;
			}
			dataMap=new HashMap<String,Object>();
			dataMap.put("UpdateResult", "修改成功");
			System.out.println("return update result:"+dataMap.get("UpdateResult"));
			return SUCCESS;
		}
	
	}