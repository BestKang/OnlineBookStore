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

	public class adminAddAction extends ActionSupport implements ModelDriven<Pbook>{
		private Pbook pbook=new Pbook();
		private Obook obook=new Obook();
		private Ebook ebook=new Ebook();
		private Map<String, Object> dataMap;
		//private operatebookservice operatebookservice;
		public adminAddAction() {
			// TODO Auto-generated constructor stub
		}
		
		public Obook getObook() {
			return obook;
		}

		public void setObook(Obook obook) {
			this.obook = obook;
		}

		public Ebook getEbook() {
			return ebook;
		}

		public void setEbook(Ebook ebook) {
			this.ebook = ebook;
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
		public String addExcute(){								//添加实体书
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
		
		public String addobookExcute(){								//添加二手书
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
		
		public String updateExcute(){								//修改实体书
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