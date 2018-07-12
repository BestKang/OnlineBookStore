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
		private Pbook pbook=new Pbook();                         //管理员添加修改实体书
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
		public String addExcute(){                                              //添加实体书，需要书籍所有信息
			 operatebookservice operatebookservice= new operatebookservice();
			if(!operatebookservice.addPBook(pbook)){                            //调用添加方法
				dataMap=new HashMap<String,Object>();
				dataMap.put("addPbookResult", "添加失败");						//添加返回前端的数据
				System.out.println("return register result:"+dataMap.get("addPbookResult"));
				return SUCCESS;
			}
			dataMap=new HashMap<String,Object>();
			dataMap.put("addPbookResult", "添加成功");
			System.out.println("return register result:"+dataMap.get("addPbookResult"));
			return SUCCESS;
		}
		public String updateExcute(){                                          //更新实体书信息，需要书籍所有信息
			 operatebookservice operatebookservice= new operatebookservice();
			if(!operatebookservice.updatePBook(pbook)){								//调用书籍修改方法
				dataMap=new HashMap<String,Object>();
				dataMap.put("UpdateResult", "修改失败");								//添加返回前端的数据
				System.out.println("return update result:"+dataMap.get("UpdateResult"));
				return SUCCESS;
			}
			dataMap=new HashMap<String,Object>();
			dataMap.put("UpdateResult", "修改成功");
			System.out.println("return update result:"+dataMap.get("UpdateResult"));
			return SUCCESS;
		}
	
	}